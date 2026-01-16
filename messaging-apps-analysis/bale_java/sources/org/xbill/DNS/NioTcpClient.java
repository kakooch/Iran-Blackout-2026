package org.xbill.DNS;

import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import lombok.Generated;
import org.xbill.DNS.NioClient;
import org.xbill.DNS.NioTcpClient;
import org.xbill.DNS.io.TcpIoClient;

/* loaded from: classes8.dex */
final class NioTcpClient extends NioClient implements TcpIoClient {

    @Generated
    private static final OI3 log = RI3.i(NioTcpClient.class);
    private final Queue<ChannelState> registrationQueue = new ConcurrentLinkedQueue();
    private final Map<ChannelKey, ChannelState> channelMap = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    static class ChannelKey {
        final InetSocketAddress local;
        final InetSocketAddress remote;

        @Generated
        public ChannelKey(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
            this.local = inetSocketAddress;
            this.remote = inetSocketAddress2;
        }

        @Generated
        protected boolean canEqual(Object obj) {
            return obj instanceof ChannelKey;
        }

        @Generated
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChannelKey)) {
                return false;
            }
            ChannelKey channelKey = (ChannelKey) obj;
            if (!channelKey.canEqual(this)) {
                return false;
            }
            InetSocketAddress inetSocketAddress = this.local;
            InetSocketAddress inetSocketAddress2 = channelKey.local;
            if (inetSocketAddress != null ? !inetSocketAddress.equals(inetSocketAddress2) : inetSocketAddress2 != null) {
                return false;
            }
            InetSocketAddress inetSocketAddress3 = this.remote;
            InetSocketAddress inetSocketAddress4 = channelKey.remote;
            return inetSocketAddress3 != null ? inetSocketAddress3.equals(inetSocketAddress4) : inetSocketAddress4 == null;
        }

        @Generated
        public int hashCode() {
            InetSocketAddress inetSocketAddress = this.local;
            int iHashCode = inetSocketAddress == null ? 43 : inetSocketAddress.hashCode();
            InetSocketAddress inetSocketAddress2 = this.remote;
            return ((iHashCode + 59) * 59) + (inetSocketAddress2 != null ? inetSocketAddress2.hashCode() : 43);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ChannelState implements NioClient.KeyProcessor {
        private final SocketChannel channel;
        final Queue<Transaction> pendingTransactions = new ConcurrentLinkedQueue();
        ByteBuffer responseLengthData = ByteBuffer.allocate(2);
        ByteBuffer responseData = ByteBuffer.allocate(65535);
        int readState = 0;

        @Generated
        public ChannelState(SocketChannel socketChannel) {
            this.channel = socketChannel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleChannelException(IOException iOException) throws IOException {
            handleTransactionException(iOException);
            for (Map.Entry entry : NioTcpClient.this.channelMap.entrySet()) {
                if (entry.getValue() == this) {
                    NioTcpClient.this.channelMap.remove(entry.getKey());
                    try {
                        this.channel.close();
                        return;
                    } catch (IOException e) {
                        NioTcpClient.log.f("Failed to close channel l={}/r={}", ((ChannelKey) entry.getKey()).local, ((ChannelKey) entry.getKey()).remote, e);
                        return;
                    }
                }
            }
        }

        private void processConnect(SelectionKey selectionKey) throws IOException {
            try {
                this.channel.finishConnect();
                selectionKey.interestOps(4);
            } catch (IOException e) {
                handleChannelException(e);
            }
        }

        private void processRead() throws IOException {
            try {
                if (this.readState == 0) {
                    if (this.channel.read(this.responseLengthData) < 0) {
                        handleChannelException(new EOFException());
                        return;
                    } else if (this.responseLengthData.position() == 2) {
                        int i = ((this.responseLengthData.get(0) & 255) << 8) + (this.responseLengthData.get(1) & 255);
                        this.responseLengthData.flip();
                        this.responseData.limit(i);
                        this.readState = 1;
                    }
                }
                if (this.channel.read(this.responseData) < 0) {
                    handleChannelException(new EOFException());
                    return;
                }
                if (this.responseData.hasRemaining()) {
                    return;
                }
                this.readState = 0;
                this.responseData.flip();
                int iLimit = this.responseData.limit();
                byte[] bArr = new byte[iLimit];
                System.arraycopy(this.responseData.array(), this.responseData.arrayOffset(), bArr, 0, this.responseData.limit());
                if (iLimit < 2) {
                    NioClient.verboseLog("TCP read: response too short for a valid reply, discarding", this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), bArr);
                    return;
                }
                int i2 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
                NioClient.verboseLog("TCP read: transaction id=" + i2, this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), bArr);
                Iterator<Transaction> it = this.pendingTransactions.iterator();
                while (it.hasNext()) {
                    Transaction next = it.next();
                    if (i2 == next.query.getHeader().getID()) {
                        next.f.complete(bArr);
                        it.remove();
                        return;
                    }
                }
                NioTcpClient.log.q("Transaction for answer to id {} not found", Integer.valueOf(i2));
            } catch (IOException e) {
                handleChannelException(e);
            }
        }

        private void processWrite(SelectionKey selectionKey) {
            Iterator<Transaction> it = this.pendingTransactions.iterator();
            while (it.hasNext()) {
                Transaction next = it.next();
                try {
                } catch (IOException e) {
                    next.f.completeExceptionally(e);
                    it.remove();
                }
                if (!next.send()) {
                    selectionKey.interestOps(4);
                    return;
                }
                continue;
            }
            selectionKey.interestOps(1);
        }

        void handleTransactionException(IOException iOException) {
            Iterator<Transaction> it = this.pendingTransactions.iterator();
            while (it.hasNext()) {
                it.next().f.completeExceptionally(iOException);
                it.remove();
            }
        }

        @Override // org.xbill.DNS.NioClient.KeyProcessor
        public void processReadyKey(SelectionKey selectionKey) throws IOException {
            if (selectionKey.isValid()) {
                if (selectionKey.isConnectable()) {
                    processConnect(selectionKey);
                    return;
                }
                if (selectionKey.isWritable()) {
                    processWrite(selectionKey);
                }
                if (selectionKey.isReadable()) {
                    processRead();
                }
            }
        }
    }

    private static class Transaction {
        long bytesWrittenTotal = 0;
        private final SocketChannel channel;
        private final long endTime;
        private final CompletableFuture<byte[]> f;
        private final Message query;
        private final byte[] queryData;
        private ByteBuffer queryDataBuffer;

        @Generated
        public Transaction(Message message, byte[] bArr, long j, SocketChannel socketChannel, CompletableFuture<byte[]> completableFuture) {
            this.query = message;
            this.queryData = bArr;
            this.endTime = j;
            this.channel = socketChannel;
            this.f = completableFuture;
        }

        boolean send() {
            long j = this.bytesWrittenTotal;
            byte[] bArr = this.queryData;
            if (j == bArr.length + 2) {
                return true;
            }
            if (this.queryDataBuffer == null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 2);
                this.queryDataBuffer = byteBufferAllocate;
                byteBufferAllocate.put((byte) (this.queryData.length >>> 8));
                this.queryDataBuffer.put((byte) (this.queryData.length & 255));
                this.queryDataBuffer.put(this.queryData);
                this.queryDataBuffer.flip();
            }
            NioClient.verboseLog("TCP write: transaction id=" + this.query.getHeader().getID(), this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), this.queryDataBuffer);
            while (this.queryDataBuffer.hasRemaining()) {
                long jWrite = this.channel.write(this.queryDataBuffer);
                long j2 = this.bytesWrittenTotal + jWrite;
                this.bytesWrittenTotal = j2;
                if (jWrite == 0) {
                    NioTcpClient.log.s("Insufficient room for the data in the underlying output buffer for transaction {}, retrying", Integer.valueOf(this.query.getHeader().getID()));
                    return false;
                }
                if (j2 < this.queryData.length) {
                    NioTcpClient.log.l("Wrote {} of {} bytes data for transaction {}", Long.valueOf(this.bytesWrittenTotal), Integer.valueOf(this.queryData.length), Integer.valueOf(this.query.getHeader().getID()));
                }
            }
            NioTcpClient.log.c("Send for transaction {} is complete, wrote {} bytes", Integer.valueOf(this.query.getHeader().getID()), Long.valueOf(this.bytesWrittenTotal));
            return true;
        }
    }

    NioTcpClient() {
        NioClient.setRegistrationsTask(new Runnable() { // from class: org.xbill.DNS.p
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.processPendingRegistrations();
            }
        }, true);
        NioClient.setTimeoutTask(new Runnable() { // from class: org.xbill.DNS.q
            @Override // java.lang.Runnable
            public final void run() {
                this.a.checkTransactionTimeouts();
            }
        }, true);
        NioClient.setCloseTask(new Runnable() { // from class: org.xbill.DNS.r
            @Override // java.lang.Runnable
            public final void run() {
                this.a.closeTcp();
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTransactionTimeouts() {
        Iterator<ChannelState> it = this.channelMap.values().iterator();
        while (it.hasNext()) {
            Iterator<Transaction> it2 = it.next().pendingTransactions.iterator();
            while (it2.hasNext()) {
                Transaction next = it2.next();
                if (next.endTime - System.nanoTime() < 0) {
                    next.f.completeExceptionally(new SocketTimeoutException("Query timed out"));
                    it2.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeTcp() {
        this.registrationQueue.clear();
        final EOFException eOFException = new EOFException("Client is closing");
        this.channelMap.forEach(new BiConsumer() { // from class: org.xbill.DNS.o
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) throws IOException {
                NioTcpClient.lambda$closeTcp$0(eOFException, (NioTcpClient.ChannelKey) obj, (NioTcpClient.ChannelState) obj2);
            }
        });
        this.channelMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$closeTcp$0(EOFException eOFException, ChannelKey channelKey, ChannelState channelState) throws IOException {
        channelState.handleTransactionException(eOFException);
        channelState.handleChannelException(eOFException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ChannelState lambda$sendAndReceiveTcp$1(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, CompletableFuture completableFuture, ChannelKey channelKey) throws IOException {
        SocketChannel socketChannelOpen;
        log.c("Opening async channel for l={}/r={}", inetSocketAddress, inetSocketAddress2);
        try {
            socketChannelOpen = SocketChannel.open();
            try {
                socketChannelOpen.configureBlocking(false);
                if (inetSocketAddress != null) {
                    socketChannelOpen.bind((SocketAddress) inetSocketAddress);
                }
                socketChannelOpen.connect(inetSocketAddress2);
                return new ChannelState(socketChannelOpen);
            } catch (IOException e) {
                e = e;
                if (socketChannelOpen != null) {
                    try {
                        socketChannelOpen.close();
                    } catch (IOException unused) {
                    }
                }
                completableFuture.completeExceptionally(e);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            socketChannelOpen = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPendingRegistrations() throws IOException {
        while (!this.registrationQueue.isEmpty()) {
            ChannelState channelStatePoll = this.registrationQueue.poll();
            if (channelStatePoll != null) {
                try {
                    Selector selector = NioClient.selector();
                    if (channelStatePoll.channel.isConnected()) {
                        channelStatePoll.channel.keyFor(selector).interestOps(4);
                    } else {
                        channelStatePoll.channel.register(selector, 8, channelStatePoll);
                    }
                } catch (IOException e) {
                    channelStatePoll.handleChannelException(e);
                }
            }
        }
    }

    @Override // org.xbill.DNS.io.TcpIoClient
    public CompletableFuture<byte[]> sendAndReceiveTcp(final InetSocketAddress inetSocketAddress, final InetSocketAddress inetSocketAddress2, Message message, byte[] bArr, Duration duration) {
        final CompletableFuture<byte[]> completableFuture = new CompletableFuture<>();
        try {
            Selector selector = NioClient.selector();
            long jNanoTime = System.nanoTime() + duration.toNanos();
            ChannelState channelStateComputeIfAbsent = this.channelMap.computeIfAbsent(new ChannelKey(inetSocketAddress, inetSocketAddress2), new Function() { // from class: org.xbill.DNS.s
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.lambda$sendAndReceiveTcp$1(inetSocketAddress, inetSocketAddress2, completableFuture, (NioTcpClient.ChannelKey) obj);
                }
            });
            if (channelStateComputeIfAbsent != null) {
                log.n("Creating transaction for id {} ({}/{})", Integer.valueOf(message.getHeader().getID()), message.getQuestion().getName(), Type.string(message.getQuestion().getType()));
                channelStateComputeIfAbsent.pendingTransactions.add(new Transaction(message, bArr, jNanoTime, channelStateComputeIfAbsent.channel, completableFuture));
                this.registrationQueue.add(channelStateComputeIfAbsent);
                selector.wakeup();
            }
        } catch (IOException e) {
            completableFuture.completeExceptionally(e);
        }
        return completableFuture;
    }
}
