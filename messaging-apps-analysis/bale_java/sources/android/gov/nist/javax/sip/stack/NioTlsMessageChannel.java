package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.ClientTransactionExt;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.stack.SSLStateMachine;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import livekit.org.webrtc.PeerConnectionFactory;

/* loaded from: classes.dex */
public class NioTlsMessageChannel extends NioTcpMessageChannel implements NioTlsChannelInterface {
    private static StackLogger logger = CommonLogger.getLogger(NioTlsMessageChannel.class);
    private int appBufferMax;
    private boolean handshakeCompleted;
    private HandshakeCompletedListener handshakeCompletedListener;
    private int netBufferMax;
    SSLStateMachine sslStateMachine;

    public static class SSLReconnectedException extends IOException {
        private static final long serialVersionUID = 1;
    }

    protected NioTlsMessageChannel(NioTcpMessageProcessor nioTcpMessageProcessor, SocketChannel socketChannel) throws IOException {
        super(nioTcpMessageProcessor, socketChannel);
        this.handshakeCompleted = false;
        this.messageProcessor = nioTcpMessageProcessor;
        this.myClientInputStream = socketChannel.socket().getInputStream();
        try {
            init(false);
            createBuffers();
        } catch (Exception e) {
            throw new IOException("Can't do TLS init", e);
        }
    }

    private void checkSocketState() throws IOException {
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel != null) {
            if (socketChannel.isConnected() && this.socketChannel.isOpen()) {
                return;
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Need to reset SSL engine for socket " + this.socketChannel);
            }
            try {
                init(this.sslStateMachine.sslEngine.getUseClientMode());
            } catch (Exception e) {
                logger.logError("Cannot reset SSL engine", e);
                throw new IOException(e);
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel
    protected void addBytes(byte[] bArr) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Adding TLS bytes for decryption " + bArr.length);
        }
        if (bArr.length <= 0) {
            return;
        }
        this.sslStateMachine.unwrap(ByteBuffer.wrap(bArr));
    }

    @Override // android.gov.nist.javax.sip.stack.NioTlsChannelInterface
    public void addPlaintextBytes(byte[] bArr) {
        this.nioParser.addBytes(bArr);
    }

    protected void createBuffers() {
        SSLSession session = this.sslStateMachine.sslEngine.getSession();
        this.appBufferMax = session.getApplicationBufferSize();
        this.netBufferMax = session.getPacketBufferSize();
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("appBufferMax=" + this.appBufferMax + " netBufferMax=" + this.netBufferMax);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTlsChannelInterface
    public /* bridge */ /* synthetic */ ClientTransactionExt getEncapsulatedClientTransaction() {
        return super.getEncapsulatedClientTransaction();
    }

    public HandshakeCompletedListenerImpl getHandshakeCompletedListener() {
        return (HandshakeCompletedListenerImpl) this.handshakeCompletedListener;
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel, android.gov.nist.javax.sip.stack.MessageChannel
    public String getTransport() {
        return "TLS";
    }

    public void init(boolean z) {
        NioTlsMessageProcessor nioTlsMessageProcessor = (NioTlsMessageProcessor) this.messageProcessor;
        SSLStateMachine sSLStateMachine = new SSLStateMachine((z ? nioTlsMessageProcessor.sslClientCtx : nioTlsMessageProcessor.sslServerCtx).createSSLEngine(), this);
        this.sslStateMachine = sSLStateMachine;
        sSLStateMachine.sslEngine.setUseClientMode(z);
        String property = ((SipStackImpl) this.sipStack).getConfigurationProperties().getProperty("android.gov.nist.javax.sip.TLS_CLIENT_AUTH_TYPE");
        if (property == null) {
            property = PeerConnectionFactory.TRIAL_ENABLED;
        }
        if (property.equals("Disabled") || property.equals("DisabledAll")) {
            this.sslStateMachine.sslEngine.setNeedClientAuth(false);
            this.sslStateMachine.sslEngine.setWantClientAuth(false);
        } else if (property.equals(PeerConnectionFactory.TRIAL_ENABLED)) {
            this.sslStateMachine.sslEngine.setNeedClientAuth(true);
        } else {
            if (!property.equals("Want")) {
                throw new RuntimeException("Invalid parameter for TLS authentication: " + property);
            }
            this.sslStateMachine.sslEngine.setNeedClientAuth(false);
            this.sslStateMachine.sslEngine.setWantClientAuth(true);
        }
        this.sslStateMachine.sslEngine.setEnabledProtocols(((SipStackImpl) this.sipStack).getEnabledProtocols());
        this.sslStateMachine.sslEngine.setEnabledCipherSuites(((SipStackImpl) this.sipStack).getEnabledCipherSuites());
        if (getHandshakeCompletedListener() == null) {
            setHandshakeCompletedListener(new HandshakeCompletedListenerImpl(this, getSocketChannel()));
        }
    }

    public boolean isHandshakeCompleted() {
        return this.handshakeCompleted;
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel, android.gov.nist.javax.sip.stack.MessageChannel
    public boolean isSecure() {
        return true;
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel
    public void onNewSocket(byte[] bArr) {
        super.onNewSocket(bArr);
        try {
            if (logger.isLoggingEnabled(32)) {
                String str = bArr != null ? new String(bArr, "UTF-8") : null;
                logger.logDebug("New socket for " + this + " last message = " + str);
            }
            init(true);
            createBuffers();
            sendMessage(bArr, false);
        } catch (Exception e) {
            logger.logError("Cant reinit", e);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTlsChannelInterface
    public ByteBuffer prepareAppDataBuffer() {
        return ByteBufferFactory.getInstance().allocateDirect(this.appBufferMax);
    }

    @Override // android.gov.nist.javax.sip.stack.NioTlsChannelInterface
    public ByteBuffer prepareEncryptedDataBuffer() {
        return ByteBufferFactory.getInstance().allocateDirect(this.netBufferMax);
    }

    @Override // android.gov.nist.javax.sip.stack.NioTlsChannelInterface
    public void sendEncryptedData(byte[] bArr) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendEncryptedData  this = " + this + " peerPort = " + this.peerPort + " addr = " + this.peerAddress);
        }
        this.lastActivityTimeStamp = System.currentTimeMillis();
        NIOHandler nIOHandler = ((NioTcpMessageProcessor) this.messageProcessor).nioHandler;
        SocketChannel socketChannel = this.socketChannel;
        if (socketChannel != null && socketChannel.isConnected() && this.socketChannel.isOpen()) {
            nIOHandler.putSocket(NIOHandler.makeKey(this.peerAddress, this.peerPort), this.socketChannel);
        }
        super.sendMessage(bArr, this.peerAddress, this.peerPort, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel, android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    public void sendMessage(byte[] bArr, final boolean z) throws IOException {
        checkSocketState();
        try {
            this.sslStateMachine.wrap(ByteBuffer.wrap(bArr), ByteBufferFactory.getInstance().allocateDirect(this.netBufferMax), new SSLStateMachine.MessageSendCallback() { // from class: android.gov.nist.javax.sip.stack.NioTlsMessageChannel.1
                @Override // android.gov.nist.javax.sip.stack.SSLStateMachine.MessageSendCallback
                public void doSend(byte[] bArr2) throws Throwable {
                    NioTlsMessageChannel.super.sendMessage(bArr2, z);
                }
            });
        } catch (Exception e) {
            throw new IOException("Can't send message", e);
        }
    }

    public void setHandshakeCompleted(boolean z) {
        this.handshakeCompleted = z;
    }

    public void setHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.handshakeCompletedListener = handshakeCompletedListener;
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel, android.gov.nist.javax.sip.stack.MessageChannel
    public SipStackImpl getSIPStack() {
        return (SipStackImpl) super.getSIPStack();
    }

    @Override // android.gov.nist.javax.sip.stack.NioTlsChannelInterface
    public ByteBuffer prepareAppDataBuffer(int i) {
        return ByteBufferFactory.getInstance().allocateDirect(i);
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageChannel, android.gov.nist.javax.sip.stack.MessageChannel
    public void sendMessage(byte[] bArr, final InetAddress inetAddress, final int i, final boolean z) throws IOException {
        checkSocketState();
        this.sslStateMachine.wrap(ByteBuffer.wrap(bArr), ByteBufferFactory.getInstance().allocateDirect(this.netBufferMax), new SSLStateMachine.MessageSendCallback() { // from class: android.gov.nist.javax.sip.stack.NioTlsMessageChannel.2
            @Override // android.gov.nist.javax.sip.stack.SSLStateMachine.MessageSendCallback
            public void doSend(byte[] bArr2) throws Throwable {
                NioTlsMessageChannel.super.sendMessage(bArr2, inetAddress, i, z);
            }
        });
    }

    public NioTlsMessageChannel(InetAddress inetAddress, int i, SIPTransactionStack sIPTransactionStack, NioTcpMessageProcessor nioTcpMessageProcessor) throws IOException {
        super(inetAddress, i, sIPTransactionStack, nioTcpMessageProcessor);
        this.handshakeCompleted = false;
        try {
            init(true);
            createBuffers();
        } catch (Exception e) {
            throw new IOException("Can't init the TLS channel", e);
        }
    }
}
