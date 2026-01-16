package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.HostPort;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.ListeningPointExt;
import java.net.InetAddress;
import java.nio.channels.SocketChannel;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;

/* loaded from: classes.dex */
public class NioTlsWebSocketMessageProcessor extends NioWebSocketMessageProcessor {
    private static StackLogger logger = CommonLogger.getLogger(NioTlsWebSocketMessageProcessor.class);
    SSLContext sslClientCtx;
    SSLContext sslServerCtx;

    public NioTlsWebSocketMessageProcessor(InetAddress inetAddress, SIPTransactionStack sIPTransactionStack, int i) {
        super(inetAddress, sIPTransactionStack, i);
        this.transport = ListeningPointExt.WSS;
        try {
            init();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioWebSocketMessageProcessor, android.gov.nist.javax.sip.stack.NioTcpMessageProcessor
    public NioTcpMessageChannel createMessageChannel(NioTcpMessageProcessor nioTcpMessageProcessor, SocketChannel socketChannel) {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("NioTlsWebSocketMessageProcessor::createMessageChannel: " + nioTcpMessageProcessor + " client " + socketChannel);
        }
        NioTlsWebSocketMessageChannel nioTlsWebSocketMessageChannel = (NioTlsWebSocketMessageChannel) this.nioHandler.getMessageChannel(socketChannel);
        if (nioTlsWebSocketMessageChannel != null) {
            return nioTlsWebSocketMessageChannel;
        }
        NioTlsWebSocketMessageChannel nioTlsWebSocketMessageChannel2 = new NioTlsWebSocketMessageChannel(this.sipStack, nioTcpMessageProcessor, socketChannel);
        this.nioHandler.putMessageChannel(socketChannel, nioTlsWebSocketMessageChannel2);
        return nioTlsWebSocketMessageChannel2;
    }

    public void init() throws NoSuchAlgorithmException, KeyManagementException {
        if (this.sipStack.securityManagerProvider.getKeyManagers(false) == null || this.sipStack.securityManagerProvider.getTrustManagers(false) == null || this.sipStack.securityManagerProvider.getTrustManagers(true) == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("TLS initialization failed due to NULL security config");
            }
        } else {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            this.sslServerCtx = sSLContext;
            sSLContext.init(this.sipStack.securityManagerProvider.getKeyManagers(false), this.sipStack.securityManagerProvider.getTrustManagers(false), null);
            SSLContext sSLContext2 = SSLContext.getInstance("TLS");
            this.sslClientCtx = sSLContext2;
            sSLContext2.init(this.sipStack.securityManagerProvider.getKeyManagers(true), this.sipStack.securityManagerProvider.getTrustManagers(true), null);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageProcessor, android.gov.nist.javax.sip.stack.MessageProcessor
    public MessageChannel createMessageChannel(HostPort hostPort) throws Throwable {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("NioTlsWebSocketMessageProcessor::createMessageChannel: " + hostPort);
        }
        NioTlsWebSocketMessageChannel nioTlsWebSocketMessageChannel = null;
        try {
            String key = MessageChannel.getKey(hostPort, this.transport);
            if (this.messageChannels.get(key) != null) {
                NioTlsWebSocketMessageChannel nioTlsWebSocketMessageChannel2 = (NioTlsWebSocketMessageChannel) this.messageChannels.get(key);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("MessageChannel::createMessageChannel - exit " + nioTlsWebSocketMessageChannel2);
                }
                return nioTlsWebSocketMessageChannel2;
            }
            NioTlsWebSocketMessageChannel nioTlsWebSocketMessageChannel3 = new NioTlsWebSocketMessageChannel(hostPort.getInetAddress(), hostPort.getPort(), this.sipStack, this);
            try {
                synchronized (this.messageChannels) {
                    this.messageChannels.put(key, nioTlsWebSocketMessageChannel3);
                }
                nioTlsWebSocketMessageChannel3.isCached = true;
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("key " + key);
                    logger.logDebug("Creating " + nioTlsWebSocketMessageChannel3);
                }
                this.selector.wakeup();
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("MessageChannel::createMessageChannel - exit " + nioTlsWebSocketMessageChannel3);
                }
                return nioTlsWebSocketMessageChannel3;
            } catch (Throwable th) {
                th = th;
                nioTlsWebSocketMessageChannel = nioTlsWebSocketMessageChannel3;
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("MessageChannel::createMessageChannel - exit " + nioTlsWebSocketMessageChannel);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageProcessor, android.gov.nist.javax.sip.stack.MessageProcessor
    public MessageChannel createMessageChannel(InetAddress inetAddress, int i) {
        String key = MessageChannel.getKey(inetAddress, i, this.transport);
        if (this.messageChannels.get(key) != null) {
            return this.messageChannels.get(key);
        }
        NioTlsWebSocketMessageChannel nioTlsWebSocketMessageChannel = new NioTlsWebSocketMessageChannel(inetAddress, i, this.sipStack, this);
        this.selector.wakeup();
        this.messageChannels.put(key, nioTlsWebSocketMessageChannel);
        nioTlsWebSocketMessageChannel.isCached = true;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("key " + key);
            logger.logDebug("Creating " + nioTlsWebSocketMessageChannel);
        }
        return nioTlsWebSocketMessageChannel;
    }
}
