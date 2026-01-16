package android.gov.nist.core.net;

import android.gov.nist.javax.sip.SipStackImpl;
import java.io.IOException;
import java.net.ConnectException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class DefaultNetworkLayer implements NetworkLayer {
    public static final DefaultNetworkLayer SINGLETON = new DefaultNetworkLayer();
    private SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
    private SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

    private DefaultNetworkLayer() {
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
    public DatagramSocket createDatagramSocket(int i, InetAddress inetAddress) throws IOException {
        if (!inetAddress.isMulticastAddress()) {
            return new DatagramSocket(i, inetAddress);
        }
        try {
            MulticastSocket multicastSocket = new MulticastSocket(i);
            multicastSocket.joinGroup(inetAddress);
            return multicastSocket;
        } catch (IOException e) {
            throw new SocketException(e.getLocalizedMessage());
        }
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
