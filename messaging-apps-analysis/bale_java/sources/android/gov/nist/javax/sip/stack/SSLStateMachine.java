package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public class SSLStateMachine {
    protected NioTlsChannelInterface channel;
    protected SSLEngine sslEngine;
    protected ByteBuffer tlsRecordBuffer;
    private static StackLogger logger = CommonLogger.getLogger(SSLStateMachine.class);
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.wrap(new byte[0]);
    protected Queue<MessageSendItem> pendingOutboundBuffers = new LinkedList();
    private Object unwrapLock = new Object();
    private Object wrapLock = new Object();

    /* renamed from: android.gov.nist.javax.sip.stack.SSLStateMachine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;

        static {
            int[] iArr = new int[SSLEngineResult.HandshakeStatus.values().length];
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = iArr;
            try {
                iArr[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface MessageSendCallback {
        void doSend(byte[] bArr);
    }

    public static class MessageSendItem {
        private MessageSendCallback callback;
        private ByteBuffer message;

        public MessageSendItem(ByteBuffer byteBuffer, MessageSendCallback messageSendCallback) {
            this.message = byteBuffer;
            this.callback = messageSendCallback;
        }

        public MessageSendCallback getCallBack() {
            return this.callback;
        }

        public String toString() {
            return MessageSendItem.class.getSimpleName() + " [" + this.message + ", " + this.callback + "]";
        }
    }

    public SSLStateMachine(SSLEngine sSLEngine, NioTlsChannelInterface nioTlsChannelInterface) {
        this.sslEngine = sSLEngine;
        this.channel = nioTlsChannelInterface;
    }

    private void clearBuffer() {
        this.tlsRecordBuffer = null;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Buffer cleared");
        }
    }

    private ByteBuffer normalizeTlsRecordBuffer(ByteBuffer byteBuffer) {
        if (this.tlsRecordBuffer == null) {
            return byteBuffer;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Normalize buffer " + byteBuffer + " into record buffer " + this.tlsRecordBuffer);
        }
        ByteBuffer byteBuffer2 = this.tlsRecordBuffer;
        byteBuffer2.position(byteBuffer2.limit());
        ByteBuffer byteBuffer3 = this.tlsRecordBuffer;
        byteBuffer3.limit(byteBuffer3.capacity());
        this.tlsRecordBuffer.put(byteBuffer);
        this.tlsRecordBuffer.flip();
        return this.tlsRecordBuffer;
    }

    private void runDelegatedTasks(SSLEngineResult sSLEngineResult) throws IOException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Running delegated task for " + sSLEngineResult);
        }
        if (sSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            while (true) {
                Runnable delegatedTask = this.sslEngine.getDelegatedTask();
                if (delegatedTask == null) {
                    break;
                } else {
                    delegatedTask.run();
                }
            }
            SSLEngineResult.HandshakeStatus handshakeStatus = this.sslEngine.getHandshakeStatus();
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Handshake status after delegated tasks " + handshakeStatus);
            }
            if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                throw new IOException("handshake shouldn't need additional tasks");
            }
        }
    }

    private void startBuffer(ByteBuffer byteBuffer) {
        if (this.tlsRecordBuffer == null) {
            ByteBuffer byteBufferAllocateDirect = ByteBufferFactory.getInstance().allocateDirect(33270);
            this.tlsRecordBuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.put(byteBuffer);
            this.tlsRecordBuffer.flip();
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Allocated record buffer for reading " + this.tlsRecordBuffer + " for src = " + byteBuffer);
            }
        }
    }

    private void wrapNonAppData() throws IOException {
        SSLEngineResult sSLEngineResultWrap;
        ByteBuffer byteBufferPrepareEncryptedDataBuffer = this.channel.prepareEncryptedDataBuffer();
        do {
            sSLEngineResultWrap = this.sslEngine.wrap(EMPTY_BUFFER, byteBufferPrepareEncryptedDataBuffer);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("NonAppWrap result " + sSLEngineResultWrap + " buffers size " + this.pendingOutboundBuffers.size());
            }
            if (sSLEngineResultWrap.bytesProduced() > 0) {
                byteBufferPrepareEncryptedDataBuffer.flip();
                byte[] bArr = new byte[byteBufferPrepareEncryptedDataBuffer.remaining()];
                byteBufferPrepareEncryptedDataBuffer.get(bArr);
                sendSSLMetadata(bArr);
                byteBufferPrepareEncryptedDataBuffer.clear();
            }
            int i = AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[sSLEngineResultWrap.getHandshakeStatus().ordinal()];
            if (i == 3) {
                runDelegatedTasks(sSLEngineResultWrap);
            } else if (i == 4) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Handshake complete!");
                }
                NioTlsChannelInterface nioTlsChannelInterface = this.channel;
                if (nioTlsChannelInterface instanceof NioTlsMessageChannel) {
                    ((NioTlsMessageChannel) nioTlsChannelInterface).setHandshakeCompleted(true);
                    if (this.sslEngine.getSession() != null) {
                        if (!ClientAuthType.Disabled.equals(this.channel.getSIPStack().getClientAuth()) && !ClientAuthType.DisabledAll.equals(this.channel.getSIPStack().getClientAuth())) {
                            try {
                                ((NioTlsMessageChannel) this.channel).getHandshakeCompletedListener().setPeerCertificates(this.sslEngine.getSession().getPeerCertificates());
                            } catch (SSLPeerUnverifiedException unused) {
                                if (logger.isLoggingEnabled(32)) {
                                    logger.logDebug("sslEngine.getSession().getPeerCertificates() are not available, which is normal if running with android.gov.nist.javax.sip.TLS_CLIENT_AUTH_TYPE=Disabled");
                                }
                            } catch (SSLException e) {
                                throw e;
                            }
                        }
                        ((NioTlsMessageChannel) this.channel).getHandshakeCompletedListener().setLocalCertificates(this.sslEngine.getSession().getLocalCertificates());
                        ((NioTlsMessageChannel) this.channel).getHandshakeCompletedListener().setCipherSuite(this.sslEngine.getSession().getCipherSuite());
                    }
                }
            }
        } while (sSLEngineResultWrap.bytesProduced() != 0);
    }

    public void sendSSLMetadata(byte[] bArr) {
        this.channel.sendEncryptedData(bArr);
    }

    public void unwrap(ByteBuffer byteBuffer) {
        unwrap(byteBuffer, this.channel.prepareAppDataBuffer());
    }

    public void wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, MessageSendCallback messageSendCallback) {
        synchronized (this.wrapLock) {
            try {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Wrapping " + byteBuffer + ", buffers size " + this.pendingOutboundBuffers.size());
                }
                if (byteBuffer != null) {
                    this.pendingOutboundBuffers.offer(new MessageSendItem(byteBuffer, messageSendCallback));
                }
                while (true) {
                    MessageSendItem messageSendItemPeek = this.pendingOutboundBuffers.peek();
                    if (messageSendItemPeek == null) {
                        break;
                    }
                    try {
                        SSLEngineResult sSLEngineResultWrap = this.sslEngine.wrap(messageSendItemPeek.message, byteBuffer2);
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("Wrap result " + sSLEngineResultWrap + " buffers size " + this.pendingOutboundBuffers.size());
                        }
                        int iRemaining = messageSendItemPeek.message.remaining();
                        if (logger.isLoggingEnabled(32)) {
                            logger.logDebug("Remaining " + iRemaining + " queue size is " + this.pendingOutboundBuffers.size());
                        }
                        if (sSLEngineResultWrap.bytesProduced() <= 0) {
                            int i = AnonymousClass1.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[sSLEngineResultWrap.getHandshakeStatus().ordinal()];
                            if (i == 1) {
                                if (!messageSendItemPeek.message.hasRemaining()) {
                                    break;
                                }
                            } else {
                                if (i == 2) {
                                    break;
                                }
                                if (i == 3) {
                                    runDelegatedTasks(sSLEngineResultWrap);
                                } else if (i == 4) {
                                    NioTlsChannelInterface nioTlsChannelInterface = this.channel;
                                    if (nioTlsChannelInterface instanceof NioTlsMessageChannel) {
                                        ((NioTlsMessageChannel) nioTlsChannelInterface).setHandshakeCompleted(true);
                                        if (this.sslEngine.getSession() != null) {
                                            if (!ClientAuthType.Disabled.equals(this.channel.getSIPStack().getClientAuth()) && !ClientAuthType.DisabledAll.equals(this.channel.getSIPStack().getClientAuth())) {
                                                try {
                                                    ((NioTlsMessageChannel) this.channel).getHandshakeCompletedListener().setPeerCertificates(this.sslEngine.getSession().getPeerCertificates());
                                                } catch (SSLPeerUnverifiedException unused) {
                                                    if (logger.isLoggingEnabled(32)) {
                                                        logger.logDebug("sslEngine.getSession().getPeerCertificates() are not available, which is normal if running with android.gov.nist.javax.sip.TLS_CLIENT_AUTH_TYPE=Disabled");
                                                    }
                                                }
                                            }
                                            ((NioTlsMessageChannel) this.channel).getHandshakeCompletedListener().setLocalCertificates(this.sslEngine.getSession().getLocalCertificates());
                                            ((NioTlsMessageChannel) this.channel).getHandshakeCompletedListener().setCipherSuite(this.sslEngine.getSession().getCipherSuite());
                                        }
                                    }
                                } else if (i == 5) {
                                    break;
                                }
                            }
                        } else {
                            byteBuffer2.flip();
                            byte[] bArr = new byte[byteBuffer2.remaining()];
                            byteBuffer2.get(bArr);
                            if (messageSendItemPeek.getCallBack() != null) {
                                messageSendItemPeek.getCallBack().doSend(bArr);
                            } else {
                                sendSSLMetadata(bArr);
                            }
                            byteBuffer2.clear();
                        }
                    } finally {
                        if (!messageSendItemPeek.message.hasRemaining()) {
                            this.pendingOutboundBuffers.remove();
                            if (logger.isLoggingEnabled(32)) {
                                logger.logDebug("REMOVED item from encryption queue because it has no more data, all is done, buffers size now is " + this.pendingOutboundBuffers.size() + " current buffer is " + messageSendItemPeek);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void wrapRemaining() {
        wrap(null, this.channel.prepareEncryptedDataBuffer(), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x01c6, code lost:
    
        if (android.gov.nist.javax.sip.stack.SSLStateMachine.logger.isLoggingEnabled(32) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c8, code lost:
    
        android.gov.nist.javax.sip.stack.SSLStateMachine.logger.logDebug("Handshake passed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01cf, code lost:
    
        r7 = r6.channel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01d3, code lost:
    
        if ((r7 instanceof android.gov.nist.javax.sip.stack.NioTlsMessageChannel) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01d5, code lost:
    
        ((android.gov.nist.javax.sip.stack.NioTlsMessageChannel) r7).setHandshakeCompleted(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e0, code lost:
    
        if (r6.sslEngine.getSession() == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f2, code lost:
    
        if (android.gov.nist.javax.sip.stack.ClientAuthType.Disabled.equals(r6.channel.getSIPStack().getClientAuth()) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0204, code lost:
    
        if (android.gov.nist.javax.sip.stack.ClientAuthType.DisabledAll.equals(r6.channel.getSIPStack().getClientAuth()) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0206, code lost:
    
        ((android.gov.nist.javax.sip.stack.NioTlsMessageChannel) r6.channel).getHandshakeCompletedListener().setPeerCertificates(r6.sslEngine.getSession().getPeerCertificates());
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0222, code lost:
    
        if (android.gov.nist.javax.sip.stack.SSLStateMachine.logger.isLoggingEnabled(32) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0224, code lost:
    
        android.gov.nist.javax.sip.stack.SSLStateMachine.logger.logDebug("sslEngine.getSession().getPeerCertificates() are not available, which is normal if running with android.gov.nist.javax.sip.TLS_CLIENT_AUTH_TYPE=Disabled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x022b, code lost:
    
        ((android.gov.nist.javax.sip.stack.NioTlsMessageChannel) r6.channel).getHandshakeCompletedListener().setLocalCertificates(r6.sslEngine.getSession().getLocalCertificates());
        ((android.gov.nist.javax.sip.stack.NioTlsMessageChannel) r6.channel).getHandshakeCompletedListener().setCipherSuite(r6.sslEngine.getSession().getCipherSuite());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0255, code lost:
    
        r6.channel.getSIPStack().getTlsSecurityPolicy().enforceTlsPolicy(r6.channel.getEncapsulatedClientTransaction());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x026e, code lost:
    
        if (android.gov.nist.javax.sip.stack.SSLStateMachine.logger.isLoggingEnabled(32) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0270, code lost:
    
        android.gov.nist.javax.sip.stack.SSLStateMachine.logger.logDebug("TLS Security policy passed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0278, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0282, code lost:
    
        throw new java.io.IOException(r7.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void unwrap(java.nio.ByteBuffer r7, java.nio.ByteBuffer r8) {
        /*
            Method dump skipped, instructions count: 743
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.javax.sip.stack.SSLStateMachine.unwrap(java.nio.ByteBuffer, java.nio.ByteBuffer):void");
    }
}
