package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.stack.timers.SipTimer;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.SocketChannel;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class NIOHandler {
    private static StackLogger logger = CommonLogger.getLogger(NIOHandler.class);
    private NioTcpMessageProcessor messageProcessor;
    private SipStackImpl sipStack;
    protected SocketTimeoutAuditor socketTimeoutAuditor;
    private AtomicBoolean stopped = new AtomicBoolean(false);
    private final ConcurrentHashMap<String, SocketChannel> socketTable = new ConcurrentHashMap<>();
    protected HashMap<SocketChannel, NioTcpMessageChannel> channelMap = new HashMap<>();
    KeyedSemaphore keyedSemaphore = new KeyedSemaphore();

    protected NIOHandler(SIPTransactionStack sIPTransactionStack, NioTcpMessageProcessor nioTcpMessageProcessor) {
        this.socketTimeoutAuditor = null;
        this.sipStack = (SipStackImpl) sIPTransactionStack;
        this.messageProcessor = nioTcpMessageProcessor;
        if (sIPTransactionStack.nioSocketMaxIdleTime <= 0 || !(nioTcpMessageProcessor instanceof ConnectionOrientedMessageProcessor)) {
            return;
        }
        this.socketTimeoutAuditor = new SocketTimeoutAuditor(sIPTransactionStack.nioSocketMaxIdleTime, this);
        SipTimer timer = sIPTransactionStack.getTimer();
        SocketTimeoutAuditor socketTimeoutAuditor = this.socketTimeoutAuditor;
        long j = sIPTransactionStack.nioSocketMaxIdleTime;
        timer.scheduleWithFixedDelay(socketTimeoutAuditor, j, j);
    }

    protected static String makeKey(InetAddress inetAddress, int i) {
        return inetAddress.getHostAddress() + ":" + i;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x012c A[Catch: all -> 0x0155, TRY_ENTER, TryCatch #4 {all -> 0x0155, blocks: (B:52:0x0122, B:55:0x012c, B:58:0x015a, B:63:0x0165, B:87:0x01e7, B:88:0x01ee), top: B:94:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e7 A[Catch: all -> 0x0155, TRY_ENTER, TryCatch #4 {all -> 0x0155, blocks: (B:52:0x0122, B:55:0x012c, B:58:0x015a, B:63:0x0165, B:87:0x01e7, B:88:0x01ee), top: B:94:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.nio.channels.SocketChannel openOutgoingConnection(java.net.InetAddress r18, java.net.InetAddress r19, int r20, boolean r21, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.stack.NIOHandler.openOutgoingConnection(java.net.InetAddress, java.net.InetAddress, int, boolean, java.lang.String):java.nio.channels.SocketChannel");
    }

    private void removeSocket(String str, boolean z) throws Throwable {
        try {
            try {
                this.keyedSemaphore.enterIOCriticalSection(str);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            SocketChannel socketChannelRemove = this.socketTable.remove(str);
            if (logger.isLoggingEnabled(32)) {
                boolean z2 = socketChannelRemove != null;
                logger.logDebug("removed Socket for key " + str + ", removed:" + z2);
            }
            if (z) {
                this.keyedSemaphore.remove(str);
                if (logger.isLoggingEnabled(32)) {
                    z = socketChannelRemove != null;
                    logger.logDebug("removed Semaphore for key " + str + ", removed:" + z);
                }
            }
        } catch (IOException e2) {
            e = e2;
            z = true;
            if (logger.isLoggingEnabled(32)) {
                logger.logError("Failed on putting socket", e);
            }
            if (!z) {
                return;
            }
            this.keyedSemaphore.leaveIOCriticalSection(str);
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (z) {
                this.keyedSemaphore.leaveIOCriticalSection(str);
            }
            throw th;
        }
        this.keyedSemaphore.leaveIOCriticalSection(str);
    }

    private void writeChunks(SocketChannel socketChannel, byte[] bArr, int i) {
        this.messageProcessor.send(socketChannel, bArr);
    }

    public void closeAll() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Closing " + this.socketTable.size() + " sockets from IOHandler");
        }
        Enumeration<SocketChannel> enumerationElements = this.socketTable.elements();
        while (enumerationElements.hasMoreElements()) {
            try {
                enumerationElements.nextElement().close();
            } catch (IOException unused) {
            }
        }
    }

    public SocketChannel createOrReuseSocket(InetAddress inetAddress, int i) throws Throwable {
        SocketChannel socketChannelOpenOutgoingConnection = null;
        if (this.stopped.get()) {
            return null;
        }
        String strMakeKey = makeKey(inetAddress, i);
        SocketChannel socket = getSocket(strMakeKey);
        if (socket == null || ((socket.isConnected() && socket.isOpen()) || socket.isConnectionPending())) {
            socketChannelOpenOutgoingConnection = socket;
        } else if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Channel disconnected " + socket);
        }
        if (socketChannelOpenOutgoingConnection == null) {
            socketChannelOpenOutgoingConnection = openOutgoingConnection(this.messageProcessor.getIpAddress(), inetAddress, i, false, strMakeKey);
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Returning socket " + strMakeKey + " channel = " + socketChannelOpenOutgoingConnection);
        }
        return socketChannelOpenOutgoingConnection;
    }

    public int getCurrentChannelSize() {
        return this.channelMap.size();
    }

    public NioTcpMessageChannel getMessageChannel(SocketChannel socketChannel) {
        return this.channelMap.get(socketChannel);
    }

    protected SocketChannel getSocket(String str) {
        return this.socketTable.get(str);
    }

    public void putMessageChannel(SocketChannel socketChannel, NioTcpMessageChannel nioTcpMessageChannel) {
        this.channelMap.put(socketChannel, nioTcpMessageChannel);
    }

    protected void putSocket(String str, SocketChannel socketChannel) {
        if (this.stopped.get()) {
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("adding socket for key " + str);
        }
        boolean z = false;
        try {
            try {
                this.keyedSemaphore.enterIOCriticalSection(str);
                z = true;
                this.socketTable.put(str, socketChannel);
            } catch (IOException e) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logError("Failed on putting socket", e);
                }
                if (!z) {
                    return;
                }
            }
            this.keyedSemaphore.leaveIOCriticalSection(str);
        } catch (Throwable th) {
            if (z) {
                this.keyedSemaphore.leaveIOCriticalSection(str);
            }
            throw th;
        }
    }

    public void removeMessageChannel(SocketChannel socketChannel) {
        this.channelMap.remove(socketChannel);
    }

    public SocketChannel sendBytes(InetAddress inetAddress, InetAddress inetAddress2, int i, String str, byte[] bArr, boolean z, NioTcpMessageChannel nioTcpMessageChannel) throws Throwable {
        boolean z2;
        if (this.stopped.get()) {
            return null;
        }
        int length = bArr.length;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendBytes " + str + " inAddr " + inetAddress2.getHostAddress() + " port = " + i + " length = " + length + " retry " + z);
        }
        if (logger.isLoggingEnabled(16) && this.sipStack.isLogStackTraceOnMessageSend()) {
            logger.logStackTrace(16);
        }
        String strMakeKey = makeKey(inetAddress2, i);
        SocketChannel socket = getSocket(strMakeKey);
        SocketChannel socketChannelOpenOutgoingConnection = (socket == null || (socket.isConnected() && socket.isOpen()) || socket.isConnectionPending()) ? socket : null;
        if (socketChannelOpenOutgoingConnection == null) {
            socketChannelOpenOutgoingConnection = openOutgoingConnection(inetAddress, inetAddress2, i, z, strMakeKey);
            nioTcpMessageChannel.peerPort = i;
            z2 = true;
        } else {
            z2 = false;
        }
        if (socketChannelOpenOutgoingConnection != null) {
            if (z2 && (nioTcpMessageChannel instanceof NioTlsMessageChannel)) {
                NioTlsMessageChannel nioTlsMessageChannel = (NioTlsMessageChannel) nioTcpMessageChannel;
                nioTlsMessageChannel.setHandshakeCompletedListener(new HandshakeCompletedListenerImpl(nioTlsMessageChannel, socketChannelOpenOutgoingConnection));
            } else {
                writeChunks(socketChannelOpenOutgoingConnection, bArr, length);
            }
        }
        if (socketChannelOpenOutgoingConnection != null) {
            return socketChannelOpenOutgoingConnection;
        }
        if (logger.isLoggingEnabled(4)) {
            logger.logError(this.socketTable.toString());
            logger.logError("Could not connect to " + inetAddress2 + ":" + i);
        }
        throw new IOException("Could not connect to " + inetAddress2 + ":" + i);
    }

    public void stop() {
        this.stopped.set(true);
        try {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("keys to check for inactivity removal " + this.channelMap.keySet());
                logger.logDebug("existing socket in NIOHandler " + this.socketTable.keySet());
            }
            Iterator<Map.Entry<SocketChannel, NioTcpMessageChannel>> it = this.channelMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<SocketChannel, NioTcpMessageChannel> next = it.next();
                SocketChannel key = next.getKey();
                NioTcpMessageChannel value = next.getValue();
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("stop() : Removing socket " + value.key + " socketChannel = " + key);
                }
                value.close();
                this.channelMap.remove(key);
                it = this.channelMap.entrySet().iterator();
            }
        } catch (Exception unused) {
        }
    }

    protected static String makeKey(String str, int i) {
        return str + ":" + i;
    }

    protected void removeSocket(SocketChannel socketChannel) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Trying to remove cached socketChannel without key" + this + " socketChannel = " + socketChannel);
        }
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, SocketChannel> entry : this.socketTable.entrySet()) {
            if (entry.getValue().equals(socketChannel)) {
                linkedList.add(entry.getKey());
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Removing cached socketChannel without key" + this + " socketChannel = " + socketChannel + " key = " + str);
            }
            removeSocket(str, true);
        }
    }
}
