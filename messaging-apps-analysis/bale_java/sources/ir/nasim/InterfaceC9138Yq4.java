package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import android.os.Build;
import ir.nasim.C17785nZ2;
import ir.nasim.C23249wc1;
import ir.nasim.C6663Ol2;
import ir.nasim.InterfaceC9138Yq4;
import ir.nasim.database.dailogLists.DialogEntity;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.xbill.DNS.SimpleResolver;

/* renamed from: ir.nasim.Yq4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC9138Yq4 {
    public static final a a = a.a;

    /* renamed from: ir.nasim.Yq4$a */
    public static final class a {
        static final /* synthetic */ a a = new a();

        /* renamed from: ir.nasim.Yq4$a$a, reason: collision with other inner class name */
        public static final class C0800a implements Interceptor {
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Socket socket;
                AbstractC13042fc3.i(chain, ReferencesHeader.CHAIN);
                Connection connection = chain.connection();
                C19406qI3.a("FileHTTP", "Connection localPort(" + ((connection == null || (socket = connection.socket()) == null) ? null : Integer.valueOf(socket.getLocalPort())) + Separators.RPAREN, new Object[0]);
                return chain.proceed(chain.request());
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(String str) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            C19406qI3.a("FileHTTP", str, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean g(String str, SSLSession sSLSession) {
            return true;
        }

        public final OkHttpClient c(Dns dns, InterfaceC9824ad1 interfaceC9824ad1, Set set, Set set2, Set set3) {
            AbstractC13042fc3.i(dns, "dns");
            AbstractC13042fc3.i(interfaceC9824ad1, "configurationRepository");
            AbstractC13042fc3.i(set, "interceptors");
            AbstractC13042fc3.i(set2, "eventListenerFactories");
            AbstractC13042fc3.i(set3, "fileEventListenerFactories");
            D86 d86 = new D86();
            OkHttpClient.Builder builderDns = new OkHttpClient.Builder().dns(dns);
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequests(1024);
            OkHttpClient.Builder builderConnectionPool = builderDns.dispatcher(dispatcher).writeTimeout(AbstractC9372Zq4.d(interfaceC9824ad1), TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(AbstractC9372Zq4.c(interfaceC9824ad1), 16L, TimeUnit.MINUTES));
            X509TrustManager x509TrustManagerC = d86.c();
            AbstractC13042fc3.h(x509TrustManagerC, "getTrustManager(...)");
            OkHttpClient.Builder builderEventListenerFactory = builderConnectionPool.sslSocketFactory(d86, x509TrustManagerC).eventListenerFactory(new C23249wc1.a(AbstractC4846Gu6.m(AbstractC4846Gu6.l(set2, set3), new C6663Ol2.a("FileHTTP"))));
            C17785nZ2 c17785nZ2 = new C17785nZ2(new C17785nZ2.b() { // from class: ir.nasim.Wq4
                @Override // ir.nasim.C17785nZ2.b
                public final void log(String str) {
                    InterfaceC9138Yq4.a.d(str);
                }
            });
            c17785nZ2.a(C17785nZ2.a.b);
            OkHttpClient.Builder builderAddNetworkInterceptor = builderEventListenerFactory.addInterceptor(c17785nZ2).addNetworkInterceptor(new C0800a());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                builderAddNetworkInterceptor.addInterceptor((Interceptor) it.next());
            }
            return builderAddNetworkInterceptor.build();
        }

        public final OkHttpClient e(Dns dns, Set set, Set set2) {
            AbstractC13042fc3.i(dns, "dns");
            AbstractC13042fc3.i(set, "interceptors");
            AbstractC13042fc3.i(set2, "eventListenerFactories");
            D86 d86 = new D86();
            OkHttpClient.Builder builderDns = new OkHttpClient.Builder().dns(dns);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder builderConnectionPool = builderDns.connectTimeout(15L, timeUnit).writeTimeout(15L, timeUnit).readTimeout(15L, timeUnit).connectionPool(new ConnectionPool(5, 16L, TimeUnit.MINUTES));
            X509TrustManager x509TrustManagerC = d86.c();
            AbstractC13042fc3.h(x509TrustManagerC, "getTrustManager(...)");
            OkHttpClient.Builder builderSslSocketFactory = builderConnectionPool.sslSocketFactory(d86, x509TrustManagerC);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                builderSslSocketFactory.addInterceptor((Interceptor) it.next());
            }
            builderSslSocketFactory.eventListenerFactory(new C23249wc1.a(set2));
            return builderSslSocketFactory.build();
        }

        public final OkHttpClient f() throws NoSuchAlgorithmException, KeyManagementException {
            b bVar = new b();
            SSLContext sSLContextB = C13916h22.b.b(bVar);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            SSLSocketFactory socketFactory = sSLContextB.getSocketFactory();
            AbstractC13042fc3.h(socketFactory, "getSocketFactory(...)");
            return builder.sslSocketFactory(socketFactory, bVar).connectTimeout(2L, TimeUnit.SECONDS).hostnameVerifier(new HostnameVerifier() { // from class: ir.nasim.Xq4
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return InterfaceC9138Yq4.a.g(str, sSLSession);
                }
            }).build();
        }

        public final Set h() {
            if (Build.VERSION.SDK_INT < 26) {
                return AbstractC4363Eu6.c(new LA4());
            }
            String[] strArr = {"185.136.96.111", "185.136.98.111", "1.1.1.1", "8.8.8.8", "9.9.9.9"};
            ArrayList arrayList = new ArrayList(5);
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                SimpleResolver simpleResolver = new SimpleResolver(str);
                simpleResolver.setTimeout(Duration.ofSeconds(3L));
                arrayList.add(new C14256hc8(str, simpleResolver));
            }
            return AbstractC15401jX0.r1(arrayList);
        }

        /* renamed from: ir.nasim.Yq4$a$b */
        public static final class b implements X509TrustManager {
            b() {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }
        }
    }
}
