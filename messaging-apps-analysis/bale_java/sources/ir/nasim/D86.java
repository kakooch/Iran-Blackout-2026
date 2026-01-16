package ir.nasim;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes5.dex */
public class D86 extends SSLSocketFactory {
    private SSLContext a;
    private X509TrustManager b;

    public D86() {
        X509TrustManager x509TrustManagerC = C13916h22.c(AbstractC17969nr7.d());
        this.b = x509TrustManagerC;
        this.a = C13916h22.d(x509TrustManagerC);
    }

    public static D86 a(String str, String str2) {
        return b(str, Arrays.asList(str2));
    }

    public static D86 b(String str, List list) {
        return new D86(str, list);
    }

    public X509TrustManager c() {
        return this.b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.getSocketFactory().createSocket(socket, str, i, z);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return this.a.getSocketFactory().createSocket();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return this.a.getSocketFactory().createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return this.a.getSocketFactory().createSocket(str, i, inetAddress, i2);
    }

    private D86(String str, List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        if (str != null) {
            try {
                if (str.length() > 0) {
                    List listF = !str.contains("rabbit-v3") ? AbstractC17969nr7.f(XY6.p(str)) : null;
                    if (listF != null) {
                        arrayList.addAll(listF);
                    }
                }
            } catch (Exception e) {
                C19406qI3.b("SSL", "exception in ps for Host e: " + e.getMessage());
                if (Objects.equals(e.getMessage(), "NOVALIDPIN")) {
                    throw new IOException("NOVALIDPIN");
                }
                return;
            }
        }
        if (arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2 != null && str2.length() != 0 && !str2.equals("SHA256:null") && !str2.equals("SHA256:")) {
                    if (!str2.startsWith("SHA256:")) {
                        str2 = "SHA256:" + str2;
                    }
                    arrayList2.add(str2);
                }
            }
            C19406qI3.a("SSL", "cp for host, size: " + arrayList2.size(), new Object[0]);
            if (arrayList2.size() != 0) {
                this.a = C23311wi3.c((String[]) arrayList2.toArray(new String[0]));
            } else {
                C19406qI3.b("SSL", "no valid p for host found");
                throw new Exception("NOVALIDPIN");
            }
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return this.a.getSocketFactory().createSocket(inetAddress, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return this.a.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
    }
}
