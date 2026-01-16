package android.gov.nist.core.net;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.stack.ClientAuthType;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class SslNetworkLayer implements NetworkLayer {
    private static StackLogger logger = CommonLogger.getLogger(SslNetworkLayer.class);
    private SSLServerSocketFactory sslServerSocketFactory;
    private SSLSocketFactory sslSocketFactory;
    TrustManager[] trustAllCerts = {new X509TrustManager() { // from class: android.gov.nist.core.net.SslNetworkLayer.1
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (SslNetworkLayer.logger.isLoggingEnabled(32)) {
                SslNetworkLayer.logger.logDebug("checkClientTrusted : Not validating certs " + x509CertificateArr + " authType " + str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (SslNetworkLayer.logger.isLoggingEnabled(32)) {
                SslNetworkLayer.logger.logDebug("checkServerTrusted : Not validating certs " + x509CertificateArr + " authType " + str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }};

    public SslNetworkLayer(SipStackImpl sipStackImpl, String str, String str2, char[] cArr, char[] cArr2, String str3, String str4) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm);
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm);
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt();
        KeyStore keyStore = KeyStore.getInstance(str3 == null ? KeyStore.getDefaultType() : str3);
        KeyStore keyStore2 = KeyStore.getInstance(str4 == null ? KeyStore.getDefaultType() : str4);
        keyStore.load(new FileInputStream(str2), cArr);
        keyStore2.load(new FileInputStream(str), cArr2);
        trustManagerFactory.init(keyStore2);
        keyManagerFactory.init(keyStore, cArr);
        if (sipStackImpl.getClientAuth() == ClientAuthType.DisabledAll) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("ClientAuth " + sipStackImpl.getClientAuth() + " bypassing all cert validations");
            }
            sSLContext.init(null, this.trustAllCerts, secureRandom);
        } else {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("ClientAuth " + sipStackImpl.getClientAuth());
            }
            sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), secureRandom);
        }
        this.sslServerSocketFactory = sSLContext.getServerSocketFactory();
        this.sslSocketFactory = sSLContext.getSocketFactory();
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public DatagramSocket createDatagramSocket() {
        return new DatagramSocket();
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public SSLServerSocket createSSLServerSocket(int i, int i2, InetAddress inetAddress) {
        return (SSLServerSocket) this.sslServerSocketFactory.createServerSocket(i, i2, inetAddress);
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public SSLSocket createSSLSocket(InetAddress inetAddress, int i) {
        return createSSLSocket(inetAddress, i, null);
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) {
        return new ServerSocket(i, i2, inetAddress);
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public Socket createSocket(InetAddress inetAddress, int i) {
        return new Socket(inetAddress, i);
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public void setSipStack(SipStackImpl sipStackImpl) {
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public DatagramSocket createDatagramSocket(int i, InetAddress inetAddress) {
        return new DatagramSocket(i, inetAddress);
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public SSLSocket createSSLSocket(InetAddress inetAddress, int i, InetAddress inetAddress2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.sslSocketFactory.createSocket();
        if (inetAddress2 != null) {
            sSLSocket.bind(new InetSocketAddress(inetAddress2, 0));
        }
        try {
            sSLSocket.connect(new InetSocketAddress(inetAddress, i), 8000);
            return sSLSocket;
        } catch (SocketTimeoutException unused) {
            throw new ConnectException("Socket timeout error (8sec)" + inetAddress + ":" + i);
        }
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2) throws IOException {
        if (inetAddress2 == null) {
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(inetAddress, i), 8000);
                return socket;
            } catch (SocketTimeoutException unused) {
                throw new ConnectException("Socket timeout error (8sec)" + inetAddress + ":" + i);
            }
        }
        Socket socket2 = new Socket();
        socket2.bind(new InetSocketAddress(inetAddress2, 0));
        try {
            socket2.connect(new InetSocketAddress(inetAddress, i), 8000);
            return socket2;
        } catch (SocketTimeoutException unused2) {
            throw new ConnectException("Socket timeout error (8sec)" + inetAddress + ":" + i);
        }
    }

    @Override // android.gov.nist.core.net.NetworkLayer
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (inetAddress2 != null) {
            Socket socket = new Socket();
            socket.bind(new InetSocketAddress(inetAddress2, 0));
            try {
                socket.connect(new InetSocketAddress(inetAddress, i), 8000);
                return socket;
            } catch (SocketTimeoutException unused) {
                throw new ConnectException("Socket timeout error (8sec)" + inetAddress + ":" + i);
            }
        }
        Socket socket2 = new Socket();
        if (i2 != 0) {
            socket2.bind(new InetSocketAddress(i));
        }
        try {
            socket2.connect(new InetSocketAddress(inetAddress, i), 8000);
            return socket2;
        } catch (SocketTimeoutException unused2) {
            throw new ConnectException("Socket timeout error (8sec)" + inetAddress + ":" + i);
        }
    }
}
