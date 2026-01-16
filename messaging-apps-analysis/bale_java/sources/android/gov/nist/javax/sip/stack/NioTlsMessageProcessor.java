package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import java.net.InetAddress;
import java.nio.channels.SocketChannel;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class NioTlsMessageProcessor extends NioTcpMessageProcessor {
    private static StackLogger logger = CommonLogger.getLogger(NioTlsMessageProcessor.class);
    SSLContext sslClientCtx;
    SSLContext sslServerCtx;
    TrustManager[] trustAllCerts;

    public NioTlsMessageProcessor(InetAddress inetAddress, SIPTransactionStack sIPTransactionStack, int i) {
        super(inetAddress, sIPTransactionStack, i);
        this.trustAllCerts = new TrustManager[]{new X509TrustManager() { // from class: android.gov.nist.javax.sip.stack.NioTlsMessageProcessor.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                if (NioTlsMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTlsMessageProcessor.logger.logDebug("checkClientTrusted : Not validating certs " + x509CertificateArr + " authType " + str);
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                if (NioTlsMessageProcessor.logger.isLoggingEnabled(32)) {
                    NioTlsMessageProcessor.logger.logDebug("checkServerTrusted : Not validating certs " + x509CertificateArr + " authType " + str);
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        this.transport = "TLS";
        try {
            init();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageProcessor
    ConnectionOrientedMessageChannel constructMessageChannel(InetAddress inetAddress, int i) {
        return new NioTlsMessageChannel(inetAddress, i, this.sipStack, this);
    }

    @Override // android.gov.nist.javax.sip.stack.NioTcpMessageProcessor
    public NioTcpMessageChannel createMessageChannel(NioTcpMessageProcessor nioTcpMessageProcessor, SocketChannel socketChannel) {
        NioTcpMessageChannel messageChannel = this.nioHandler.getMessageChannel(socketChannel);
        if (messageChannel != null) {
            return messageChannel;
        }
        NioTlsMessageChannel nioTlsMessageChannel = new NioTlsMessageChannel(nioTcpMessageProcessor, socketChannel);
        this.nioHandler.putMessageChannel(socketChannel, nioTlsMessageChannel);
        return nioTlsMessageChannel;
    }

    public void init() throws KeyManagementException {
        if (this.sipStack.securityManagerProvider.getKeyManagers(false) == null || this.sipStack.securityManagerProvider.getTrustManagers(false) == null || this.sipStack.securityManagerProvider.getTrustManagers(true) == null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("TLS initialization failed due to NULL security config");
                return;
            }
            return;
        }
        this.sslServerCtx = SSLContext.getInstance("TLS");
        this.sslClientCtx = SSLContext.getInstance("TLS");
        if (this.sipStack.getClientAuth() != ClientAuthType.DisabledAll) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("ClientAuth " + this.sipStack.getClientAuth());
            }
            this.sslServerCtx.init(this.sipStack.securityManagerProvider.getKeyManagers(false), this.sipStack.securityManagerProvider.getTrustManagers(false), null);
            this.sslClientCtx.init(this.sipStack.securityManagerProvider.getKeyManagers(true), this.sipStack.securityManagerProvider.getTrustManagers(true), null);
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("ClientAuth " + this.sipStack.getClientAuth() + " bypassing all cert validations");
        }
        this.sslServerCtx.init(this.sipStack.securityManagerProvider.getKeyManagers(false), this.trustAllCerts, null);
        this.sslClientCtx.init(this.sipStack.securityManagerProvider.getKeyManagers(true), this.trustAllCerts, null);
    }
}
