package ir.nasim;

import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: ir.nasim.h22, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13916h22 implements X509TrustManager {
    public static final b b = new b(null);
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(a.a);
    private static final Object d = new Object();
    private X509TrustManager a;

    /* renamed from: ir.nasim.h22$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, ZW0.class, "mutableListOf", "mutableListOf()Ljava/util/List;", 1);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final List invoke() {
            return new ArrayList();
        }
    }

    /* renamed from: ir.nasim.h22$b */
    public static final class b {
        private b() {
        }

        private final List c() {
            return (List) C13916h22.c.getValue();
        }

        public final X509TrustManager a(List list) {
            C13916h22 c13916h22;
            AbstractC13042fc3.i(list, "pins");
            synchronized (C13916h22.d) {
                c13916h22 = new C13916h22(list);
                C13916h22.b.c().add(c13916h22);
            }
            return c13916h22;
        }

        public final SSLContext b(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
            AbstractC13042fc3.i(x509TrustManager, "trustManager");
            TrustManager[] trustManagerArr = {x509TrustManager};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            AbstractC13042fc3.f(sSLContext);
            return sSLContext;
        }

        public final void d() {
            synchronized (C13916h22.d) {
                try {
                    List listD = AbstractC17969nr7.d();
                    C19406qI3.j("DynamicPinningTrustManager", "onNewPinsLoaded()", new Object[0]);
                    for (C13916h22 c13916h22 : C13916h22.b.c()) {
                        AbstractC13042fc3.f(listD);
                        c13916h22.f(listD);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    private C13916h22(X509TrustManager x509TrustManager) {
        this.a = x509TrustManager;
    }

    public static final X509TrustManager c(List list) {
        return b.a(list);
    }

    public static final SSLContext d(X509TrustManager x509TrustManager) {
        return b.b(x509TrustManager);
    }

    public static final void e() {
        b.d();
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        AbstractC13042fc3.i(x509CertificateArr, ReferencesHeader.CHAIN);
        AbstractC13042fc3.i(str, "authType");
        this.a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        AbstractC13042fc3.i(x509CertificateArr, ReferencesHeader.CHAIN);
        AbstractC13042fc3.i(str, "authType");
        this.a.checkServerTrusted(x509CertificateArr, str);
    }

    public final void f(List list) {
        AbstractC13042fc3.i(list, "stringPins");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC17827nd5.a((String) it.next()));
        }
        this.a = C23311wi3.g(arrayList);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        X509Certificate[] acceptedIssuers = this.a.getAcceptedIssuers();
        AbstractC13042fc3.h(acceptedIssuers, "getAcceptedIssuers(...)");
        return acceptedIssuers;
    }

    public C13916h22(List list) {
        AbstractC13042fc3.i(list, "pins");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC17827nd5.a((String) it.next()));
        }
        X509TrustManager x509TrustManagerG = C23311wi3.g(arrayList);
        AbstractC13042fc3.h(x509TrustManagerG, "trustManagerForPins(...)");
        this(x509TrustManagerG);
    }
}
