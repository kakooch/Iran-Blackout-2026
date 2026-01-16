package android.gov.nist.core.net;

import android.gov.nist.javax.sip.SipStackImpl;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public interface NetworkLayer {
    DatagramSocket createDatagramSocket();

    DatagramSocket createDatagramSocket(int i, InetAddress inetAddress);

    SSLServerSocket createSSLServerSocket(int i, int i2, InetAddress inetAddress);

    SSLSocket createSSLSocket(InetAddress inetAddress, int i);

    SSLSocket createSSLSocket(InetAddress inetAddress, int i, InetAddress inetAddress2);

    ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress);

    Socket createSocket(InetAddress inetAddress, int i);

    Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2);

    Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2);

    void setSipStack(SipStackImpl sipStackImpl);
}
