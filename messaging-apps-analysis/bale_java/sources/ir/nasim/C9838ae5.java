package ir.nasim;

import eu.geekplace.javapinning.CertificateNotPinnedException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import javax.net.ssl.X509TrustManager;

/* renamed from: ir.nasim.ae5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C9838ae5 implements X509TrustManager {
    private final Collection a;

    C9838ae5(Collection collection) {
        this.a = collection;
    }

    private boolean a(X509Certificate x509Certificate) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((AbstractC17827nd5) it.next()).b(x509Certificate)) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateNotPinnedException {
        X509Certificate x509Certificate = x509CertificateArr[0];
        if (a(x509Certificate)) {
            return;
        }
        throw new CertificateNotPinnedException("Certificate not pinned. Use 'CERTPLAIN:" + AbstractC23775xV2.b(x509Certificate.getEncoded()) + "' to pin this certificate. But only pin the certificate if you are sure this is the correct certificate!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
