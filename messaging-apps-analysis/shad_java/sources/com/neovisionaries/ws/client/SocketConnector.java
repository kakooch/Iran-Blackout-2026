package com.neovisionaries.ws.client;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Comparator;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
class SocketConnector {
    private final Address mAddress;
    private final int mConnectionTimeout;
    private int mDualStackFallbackDelay;
    private DualStackMode mDualStackMode;
    private final String mHost;
    private final int mPort;
    private final ProxyHandshaker mProxyHandshaker;
    private final SSLSocketFactory mSSLSocketFactory;
    private final String[] mServerNames;
    private Socket mSocket;
    private final SocketFactory mSocketFactory;
    private final int mSocketTimeout;
    private boolean mVerifyHostname;

    SocketConnector(SocketFactory socketFactory, Address address, int i, String[] strArr, int i2) {
        this(socketFactory, address, i, i2, strArr, null, null, null, 0);
    }

    SocketConnector(SocketFactory socketFactory, Address address, int i, int i2, String[] strArr, ProxyHandshaker proxyHandshaker, SSLSocketFactory sSLSocketFactory, String str, int i3) {
        this.mDualStackMode = DualStackMode.BOTH;
        this.mDualStackFallbackDelay = 250;
        this.mSocketFactory = socketFactory;
        this.mAddress = address;
        this.mConnectionTimeout = i;
        this.mSocketTimeout = i2;
        this.mServerNames = strArr;
        this.mProxyHandshaker = proxyHandshaker;
        this.mSSLSocketFactory = sSLSocketFactory;
        this.mHost = str;
        this.mPort = i3;
    }

    public Socket getSocket() {
        return this.mSocket;
    }

    private void connectSocket() throws WebSocketException {
        try {
            this.mSocket = new SocketInitiator(this.mSocketFactory, this.mAddress, this.mConnectionTimeout, this.mServerNames, this.mDualStackMode, this.mDualStackFallbackDelay).establish(resolveHostname());
        } catch (Exception e) {
            Object[] objArr = new Object[3];
            objArr[0] = this.mProxyHandshaker != null ? "the proxy " : BuildConfig.FLAVOR;
            objArr[1] = this.mAddress;
            objArr[2] = e.getMessage();
            throw new WebSocketException(WebSocketError.SOCKET_CONNECT_ERROR, String.format("Failed to connect to %s'%s': %s", objArr), e);
        }
    }

    private InetAddress[] resolveHostname() throws WebSocketException, UnknownHostException {
        InetAddress[] allByName;
        UnknownHostException e = null;
        try {
            allByName = InetAddress.getAllByName(this.mAddress.getHostname());
            try {
                Arrays.sort(allByName, new Comparator<InetAddress>(this) { // from class: com.neovisionaries.ws.client.SocketConnector.1
                    @Override // java.util.Comparator
                    public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
                        if (inetAddress.getClass() == inetAddress2.getClass()) {
                            return 0;
                        }
                        return inetAddress instanceof Inet6Address ? -1 : 1;
                    }
                });
            } catch (UnknownHostException e2) {
                e = e2;
            }
        } catch (UnknownHostException e3) {
            allByName = null;
            e = e3;
        }
        if (allByName != null && allByName.length > 0) {
            return allByName;
        }
        if (e == null) {
            e = new UnknownHostException("No IP addresses found");
        }
        throw new WebSocketException(WebSocketError.SOCKET_CONNECT_ERROR, String.format("Failed to resolve hostname %s: %s", this.mAddress, e.getMessage()), e);
    }

    public Socket connect() throws WebSocketException, IOException {
        try {
            doConnect();
            return this.mSocket;
        } catch (WebSocketException e) {
            Socket socket = this.mSocket;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException unused) {
                }
            }
            throw e;
        }
    }

    SocketConnector setDualStackSettings(DualStackMode dualStackMode, int i) {
        this.mDualStackMode = dualStackMode;
        this.mDualStackFallbackDelay = i;
        return this;
    }

    SocketConnector setVerifyHostname(boolean z) {
        this.mVerifyHostname = z;
        return this;
    }

    private void doConnect() throws WebSocketException, IOException {
        boolean z = this.mProxyHandshaker != null;
        connectSocket();
        int i = this.mSocketTimeout;
        if (i > 0) {
            setSoTimeout(i);
        }
        Socket socket = this.mSocket;
        if (socket instanceof SSLSocket) {
            verifyHostname((SSLSocket) socket, this.mAddress.getHostname());
        }
        if (z) {
            handshake();
        }
    }

    private void setSoTimeout(int i) throws SocketException, WebSocketException {
        try {
            this.mSocket.setSoTimeout(i);
        } catch (SocketException e) {
            throw new WebSocketException(WebSocketError.SOCKET_CONNECT_ERROR, String.format("Failed to set SO_TIMEOUT: %s", e.getMessage()), e);
        }
    }

    private void verifyHostname(SSLSocket sSLSocket, String str) throws HostnameUnverifiedException {
        if (this.mVerifyHostname && !OkHostnameVerifier.INSTANCE.verify(str, sSLSocket.getSession())) {
            throw new HostnameUnverifiedException(sSLSocket, str);
        }
    }

    private void handshake() throws WebSocketException, IOException {
        try {
            this.mProxyHandshaker.perform(this.mSocket);
            SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
            if (sSLSocketFactory == null) {
                return;
            }
            try {
                Socket socketCreateSocket = sSLSocketFactory.createSocket(this.mSocket, this.mHost, this.mPort, true);
                this.mSocket = socketCreateSocket;
                try {
                    ((SSLSocket) socketCreateSocket).startHandshake();
                    verifyHostname((SSLSocket) this.mSocket, this.mProxyHandshaker.getProxiedHostname());
                } catch (IOException e) {
                    throw new WebSocketException(WebSocketError.SSL_HANDSHAKE_ERROR, String.format("SSL handshake with the WebSocket endpoint (%s) failed: %s", this.mAddress, e.getMessage()), e);
                }
            } catch (IOException e2) {
                throw new WebSocketException(WebSocketError.SOCKET_OVERLAY_ERROR, "Failed to overlay an existing socket: " + e2.getMessage(), e2);
            }
        } catch (IOException e3) {
            throw new WebSocketException(WebSocketError.PROXY_HANDSHAKE_ERROR, String.format("Handshake with the proxy server (%s) failed: %s", this.mAddress, e3.getMessage()), e3);
        }
    }

    void closeSilently() {
        Socket socket = this.mSocket;
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }
}
