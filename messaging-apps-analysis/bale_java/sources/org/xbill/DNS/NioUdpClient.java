package org.xbill.DNS;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import lombok.Generated;
import org.xbill.DNS.NioClient;
import org.xbill.DNS.NioUdpClient;
import org.xbill.DNS.io.UdpIoClient;

/* loaded from: classes8.dex */
final class NioUdpClient extends NioClient implements UdpIoClient {

    @Generated
    private static final OI3 log = RI3.i(NioUdpClient.class);
    private final int ephemeralRange;
    private final int ephemeralStart;
    private final SecureRandom prng;
    private final Queue<Transaction> registrationQueue = new ConcurrentLinkedQueue();
    private final Queue<Transaction> pendingTransactions = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: private */
    class Transaction implements NioClient.KeyProcessor {
        private final DatagramChannel channel;
        private final byte[] data;
        private final long endTime;
        private final CompletableFuture<byte[]> f;
        private final int id;
        private final int max;

        @Generated
        public Transaction(int i, byte[] bArr, int i2, long j, DatagramChannel datagramChannel, CompletableFuture<byte[]> completableFuture) {
            this.id = i;
            this.data = bArr;
            this.max = i2;
            this.endTime = j;
            this.channel = datagramChannel;
            this.f = completableFuture;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void access$200(Transaction transaction, Exception exc) throws IOException {
            transaction.completeExceptionally(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void completeExceptionally(Exception exc) throws IOException {
            silentDisconnectAndCloseChannel();
            this.f.completeExceptionally(exc);
        }

        private void silentDisconnectAndCloseChannel() throws IOException {
            try {
                this.channel.disconnect();
            } catch (IOException unused) {
            } catch (Throwable th) {
                NioUdpClient.silentCloseChannel(this.channel);
                throw th;
            }
            NioUdpClient.silentCloseChannel(this.channel);
        }

        @Override // org.xbill.DNS.NioClient.KeyProcessor
        public void processReadyKey(SelectionKey selectionKey) throws IOException {
            if (!selectionKey.isReadable()) {
                completeExceptionally(new EOFException("Key for transaction " + this.id + " is not readable"));
                NioUdpClient.this.pendingTransactions.remove(this);
                return;
            }
            DatagramChannel datagramChannel = (DatagramChannel) selectionKey.channel();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.max);
            try {
                int i = datagramChannel.read(byteBufferAllocate);
                if (i <= 0) {
                    throw new EOFException();
                }
                byteBufferAllocate.flip();
                byte[] bArr = new byte[i];
                System.arraycopy(byteBufferAllocate.array(), 0, bArr, 0, i);
                NioClient.verboseLog("UDP read: transaction id=" + this.id, datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr);
                silentDisconnectAndCloseChannel();
                this.f.complete(bArr);
                NioUdpClient.this.pendingTransactions.remove(this);
            } catch (IOException e) {
                completeExceptionally(e);
                NioUdpClient.this.pendingTransactions.remove(this);
            }
        }

        void send() throws IOException {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.data);
            NioClient.verboseLog("UDP write: transaction id=" + this.id, this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), this.data);
            DatagramChannel datagramChannel = this.channel;
            int iSend = datagramChannel.send(byteBufferWrap, datagramChannel.socket().getRemoteSocketAddress());
            if (iSend == 0) {
                throw new EOFException("Insufficient room for the datagram in the underlying output buffer for transaction " + this.id);
            }
            if (iSend >= this.data.length) {
                return;
            }
            throw new EOFException("Could not send all data for transaction " + this.id);
        }
    }

    NioUdpClient() {
        int i;
        int i2;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            i = 32768;
            i2 = 60999;
        } else {
            i = 49152;
            i2 = 65535;
        }
        int iIntValue = Integer.getInteger("dnsjava.udp.ephemeral.start", i).intValue();
        this.ephemeralStart = iIntValue;
        this.ephemeralRange = Integer.getInteger("dnsjava.udp.ephemeral.end", i2).intValue() - iIntValue;
        if (Boolean.getBoolean("dnsjava.udp.ephemeral.use_ephemeral_port")) {
            this.prng = null;
        } else {
            this.prng = new SecureRandom();
        }
        NioClient.setRegistrationsTask(new Runnable() { // from class: org.xbill.DNS.t
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.processPendingRegistrations();
            }
        }, false);
        NioClient.setTimeoutTask(new Runnable() { // from class: org.xbill.DNS.u
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.checkTransactionTimeouts();
            }
        }, false);
        NioClient.setCloseTask(new Runnable() { // from class: org.xbill.DNS.v
            @Override // java.lang.Runnable
            public final void run() {
                this.a.closeUdp();
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTransactionTimeouts() throws IOException {
        Iterator<Transaction> it = this.pendingTransactions.iterator();
        while (it.hasNext()) {
            Transaction next = it.next();
            if (next.endTime - System.nanoTime() < 0) {
                next.completeExceptionally(new SocketTimeoutException("Query timed out"));
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeUdp() {
        this.registrationQueue.clear();
        final EOFException eOFException = new EOFException("Client is closing");
        this.pendingTransactions.forEach(new Consumer() { // from class: org.xbill.DNS.w
            @Override // java.util.function.Consumer
            public final void accept(Object obj) throws IOException {
                NioUdpClient.Transaction.access$200((NioUdpClient.Transaction) obj, eOFException);
            }
        });
        this.pendingTransactions.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingRegistrations() throws IOException {
        while (!this.registrationQueue.isEmpty()) {
            Transaction transactionPoll = this.registrationQueue.poll();
            if (transactionPoll != null) {
                try {
                    log.r("Registering OP_READ for transaction with id {}", Integer.valueOf(transactionPoll.id));
                    transactionPoll.channel.register(NioClient.selector(), 1, transactionPoll);
                    transactionPoll.send();
                } catch (IOException e) {
                    transactionPoll.completeExceptionally(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void silentCloseChannel(DatagramChannel datagramChannel) throws IOException {
        if (datagramChannel != null) {
            try {
                datagramChannel.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.xbill.DNS.io.UdpIoClient
    public CompletableFuture<byte[]> sendAndReceiveUdp(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, int i, Duration duration) throws Throwable {
        InetSocketAddress inetSocketAddress3;
        SecureRandom secureRandom;
        long jNanoTime = System.nanoTime() + duration.toNanos();
        CompletableFuture<byte[]> completableFuture = new CompletableFuture<>();
        DatagramChannel datagramChannel = null;
        try {
            Selector selector = NioClient.selector();
            DatagramChannel datagramChannelOpen = DatagramChannel.open();
            try {
                datagramChannelOpen.configureBlocking(false);
                Transaction transaction = new Transaction(message.getHeader().getID(), bArr, i, jNanoTime, datagramChannelOpen, completableFuture);
                if (inetSocketAddress == null || inetSocketAddress.getPort() == 0) {
                    for (int i2 = 0; i2 < 1024; i2++) {
                        try {
                            if (inetSocketAddress == null) {
                                inetSocketAddress3 = this.prng != null ? new InetSocketAddress(this.prng.nextInt(this.ephemeralRange) + this.ephemeralStart) : null;
                            } else {
                                int port = inetSocketAddress.getPort();
                                if (port == 0 && (secureRandom = this.prng) != null) {
                                    port = secureRandom.nextInt(this.ephemeralRange) + this.ephemeralStart;
                                }
                                inetSocketAddress3 = new InetSocketAddress(inetSocketAddress.getAddress(), port);
                            }
                            datagramChannelOpen.bind((SocketAddress) inetSocketAddress3);
                        } catch (SocketException unused) {
                        }
                    }
                    transaction.completeExceptionally(new IOException("No available source port found"));
                    return completableFuture;
                }
                datagramChannelOpen.connect(inetSocketAddress2);
                this.pendingTransactions.add(transaction);
                this.registrationQueue.add(transaction);
                selector.wakeup();
            } catch (IOException e) {
                e = e;
                datagramChannel = datagramChannelOpen;
                silentCloseChannel(datagramChannel);
                completableFuture.completeExceptionally(e);
                return completableFuture;
            } catch (Throwable th) {
                th = th;
                datagramChannel = datagramChannelOpen;
                silentCloseChannel(datagramChannel);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
        }
        return completableFuture;
    }
}
