package ir.nasim;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: ir.nasim.wi3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C23311wi3 {
    public static final C23311wi3 a = new C23311wi3();

    protected C23311wi3() {
    }

    public static SSLContext c(String... strArr) {
        return a.a(strArr);
    }

    private static final SSLContext d(TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustManagerArr = {trustManager};
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArr, new SecureRandom());
        return sSLContext;
    }

    public static X509TrustManager g(Collection collection) {
        return a.e(collection);
    }

    protected final SSLContext a(String... strArr) {
        return d(f(strArr));
    }

    protected final X509TrustManager e(Collection collection) {
        return b(new C9838ae5(collection));
    }

    protected final X509TrustManager f(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(AbstractC17827nd5.a(str));
        }
        return e(arrayList);
    }

    protected X509TrustManager b(C9838ae5 c9838ae5) {
        return c9838ae5;
    }
}
