package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SipStackImpl;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class IOHandler {
    private static final String TCP = "tcp";
    private static final String TLS = "tls";
    private static StackLogger logger = CommonLogger.getLogger(IOHandler.class);
    private SipStackImpl sipStack;
    private final ConcurrentHashMap<String, Socket> socketTable = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Semaphore> socketCreationMap = new ConcurrentHashMap<>();

    protected IOHandler(SIPTransactionStack sIPTransactionStack) {
        this.sipStack = (SipStackImpl) sIPTransactionStack;
    }

    private void enterIOCriticalSection(String str) throws IOException {
        Semaphore semaphore = this.socketCreationMap.get(str);
        if (semaphore == null) {
            semaphore = new Semaphore(1, true);
            Semaphore semaphorePutIfAbsent = this.socketCreationMap.putIfAbsent(str, semaphore);
            if (semaphorePutIfAbsent != null) {
                semaphore = semaphorePutIfAbsent;
            } else if (logger.isLoggingEnabled(32)) {
                logger.logDebug("new Semaphore added for key " + str);
            }
        }
        try {
            if (semaphore.tryAcquire(10L, TimeUnit.SECONDS)) {
                return;
            }
            throw new IOException("Could not acquire IO Semaphore'" + str + "' after 10 seconds -- giving up ");
        } catch (InterruptedException unused) {
            throw new IOException("exception in acquiring sem");
        }
    }

    private void leaveIOCriticalSection(String str) {
        Semaphore semaphore = this.socketCreationMap.get(str);
        if (semaphore != null) {
            semaphore.release();
        }
    }

    protected static String makeKey(InetAddress inetAddress, int i) {
        return inetAddress.getHostAddress() + ":" + i;
    }

    private void writeChunks(OutputStream outputStream, byte[] bArr, int i) throws IOException {
        synchronized (outputStream) {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 8192;
                try {
                    outputStream.write(bArr, i2, i3 < i ? 8192 : i - i2);
                    i2 = i3;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        outputStream.flush();
    }

    public void closeAll() {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Closing " + this.socketTable.size() + " sockets from IOHandler");
        }
        Enumeration<Socket> enumerationElements = this.socketTable.elements();
        while (enumerationElements.hasMoreElements()) {
            try {
                enumerationElements.nextElement().close();
            } catch (IOException unused) {
            }
        }
    }

    public SocketAddress getLocalAddressForTcpDst(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        String strMakeKey = makeKey(inetAddress, i);
        Socket socket = getSocket(strMakeKey);
        if (socket == null) {
            socket = this.sipStack.getNetworkLayer().createSocket(inetAddress, i, inetAddress2, i2);
            putSocket(strMakeKey, socket);
        }
        return socket.getLocalSocketAddress();
    }

    public SocketAddress getLocalAddressForTlsDst(InetAddress inetAddress, int i, InetAddress inetAddress2, TLSMessageChannel tLSMessageChannel) throws IOException {
        String strMakeKey = makeKey(inetAddress, i);
        Socket socket = getSocket(strMakeKey);
        Socket socket2 = socket;
        if (socket == null) {
            SSLSocket sSLSocketCreateSSLSocket = this.sipStack.getNetworkLayer().createSSLSocket(inetAddress, i, inetAddress2);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("inaddr = " + inetAddress);
                logger.logDebug("port = " + i);
            }
            HandshakeCompletedListenerImpl handshakeCompletedListenerImpl = new HandshakeCompletedListenerImpl(tLSMessageChannel, sSLSocketCreateSSLSocket);
            tLSMessageChannel.setHandshakeCompletedListener(handshakeCompletedListenerImpl);
            sSLSocketCreateSSLSocket.addHandshakeCompletedListener(handshakeCompletedListenerImpl);
            sSLSocketCreateSSLSocket.setEnabledProtocols(this.sipStack.getEnabledProtocols());
            sSLSocketCreateSSLSocket.setEnabledCipherSuites(this.sipStack.getEnabledCipherSuites());
            handshakeCompletedListenerImpl.startHandshakeWatchdog();
            sSLSocketCreateSSLSocket.startHandshake();
            tLSMessageChannel.setHandshakeCompleted(true);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Handshake passed");
            }
            try {
                this.sipStack.getTlsSecurityPolicy().enforceTlsPolicy(tLSMessageChannel.getEncapsulatedClientTransaction());
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("TLS Security policy passed");
                }
                putSocket(strMakeKey, sSLSocketCreateSSLSocket);
                socket2 = sSLSocketCreateSSLSocket;
            } catch (SecurityException e) {
                throw new IOException(e.getMessage());
            }
        }
        return socket2.getLocalSocketAddress();
    }

    protected Socket getSocket(String str) {
        return this.socketTable.get(str);
    }

    protected void putSocket(String str, Socket socket) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("adding socket for key " + str);
        }
        this.socketTable.put(str, socket);
    }

    protected void removeSocket(String str) {
        this.socketTable.remove(str);
        Semaphore semaphoreRemove = this.socketCreationMap.remove(str);
        if (semaphoreRemove != null) {
            semaphoreRemove.release();
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("removed Socket and Semaphore for key " + str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00be, code lost:
    
        if (android.gov.nist.javax.sip.stack.IOHandler.logger.isLoggingEnabled(32) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c0, code lost:
    
        android.gov.nist.javax.sip.stack.IOHandler.logger.logDebug("inaddr = " + r29);
        android.gov.nist.javax.sip.stack.IOHandler.logger.logDebug("port = " + r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f0, code lost:
    
        r0 = r27.sipStack.getNetworkLayer().createSocket(r29, r30, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0102, code lost:
    
        if (android.gov.nist.javax.sip.stack.IOHandler.logger.isLoggingEnabled(32) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0104, code lost:
    
        android.gov.nist.javax.sip.stack.IOHandler.logger.logDebug("local inaddr = " + r0.getLocalAddress().getHostAddress());
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0123, code lost:
    
        r21 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0127, code lost:
    
        writeChunks(r0.getOutputStream(), r4, r13);
        putSocket(r15, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0131, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0135, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0136, code lost:
    
        r8 = android.gov.nist.javax.sip.stack.IOHandler.logger;
        r11 = new java.lang.StringBuilder();
        r11.append("Problem connecting ");
        r11.append(r29);
        r11.append(r10);
        r11.append(r30);
        r11.append(r10);
        r11.append(r28);
        r11.append(r9);
        r13 = r18;
        r11.append(new java.lang.String(r4, r13));
        r8.logError(r11.toString());
        removeSocket(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01b0, code lost:
    
        throw new java.net.SocketException(r0.getClass() + r10 + r0.getMessage() + r10 + r0.getCause() + " Problem connecting " + r29 + r10 + r30 + r10 + r28 + r9 + new java.lang.String(r4, r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02df, code lost:
    
        r2 = r27.sipStack.getNetworkLayer().createSSLSocket(r29, r30, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02f1, code lost:
    
        if (android.gov.nist.javax.sip.stack.IOHandler.logger.isLoggingEnabled(32) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02f3, code lost:
    
        android.gov.nist.javax.sip.stack.IOHandler.logger.logDebug("inaddr = " + r29);
        android.gov.nist.javax.sip.stack.IOHandler.logger.logDebug("port = " + r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x031f, code lost:
    
        r21 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0326, code lost:
    
        r0 = new android.gov.nist.javax.sip.stack.HandshakeCompletedListenerImpl((android.gov.nist.javax.sip.stack.TLSMessageChannel) r34, r2);
        ((android.gov.nist.javax.sip.stack.TLSMessageChannel) r34).setHandshakeCompletedListener(r0);
        r2.addHandshakeCompletedListener(r0);
        r2.setEnabledProtocols(r27.sipStack.getEnabledProtocols());
        r0.startHandshakeWatchdog();
        r2.startHandshake();
        ((android.gov.nist.javax.sip.stack.TLSMessageChannel) r34).setHandshakeCompleted(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0358, code lost:
    
        if (android.gov.nist.javax.sip.stack.IOHandler.logger.isLoggingEnabled(32) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x035a, code lost:
    
        android.gov.nist.javax.sip.stack.IOHandler.logger.logDebug("Handshake passed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0361, code lost:
    
        r27.sipStack.getTlsSecurityPolicy().enforceTlsPolicy(r34.getEncapsulatedClientTransaction());
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0376, code lost:
    
        if (android.gov.nist.javax.sip.stack.IOHandler.logger.isLoggingEnabled(32) == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0378, code lost:
    
        android.gov.nist.javax.sip.stack.IOHandler.logger.logDebug("TLS Security policy passed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x037f, code lost:
    
        writeChunks(r2.getOutputStream(), r32, r13);
        putSocket(r3, r2);
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x038d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0397, code lost:
    
        throw new java.io.IOException(r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020b A[Catch: all -> 0x00e9, TryCatch #2 {all -> 0x00e9, blocks: (B:18:0x00aa, B:22:0x00b6, B:24:0x00c0, B:29:0x00f0, B:30:0x00fa, B:32:0x0104, B:34:0x0127, B:37:0x0136, B:38:0x01b0, B:39:0x01b1, B:43:0x01bc, B:45:0x01c8, B:46:0x01de, B:50:0x01e7, B:51:0x01eb, B:53:0x01fa, B:54:0x01fd, B:56:0x0202, B:58:0x020b, B:59:0x0261), top: B:130:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02bd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.net.Socket sendBytes(java.net.InetAddress r28, java.net.InetAddress r29, int r30, java.lang.String r31, byte[] r32, boolean r33, android.gov.nist.javax.sip.stack.MessageChannel r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.stack.IOHandler.sendBytes(java.net.InetAddress, java.net.InetAddress, int, java.lang.String, byte[], boolean, android.gov.nist.javax.sip.stack.MessageChannel):java.net.Socket");
    }

    protected static String makeKey(String str, int i) {
        return str + ":" + i;
    }
}
