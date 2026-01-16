package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.os.Build;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* renamed from: ir.nasim.qd1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19596qd1 {
    public static final a h = new a(null);
    private final int a;
    private final String b;
    private final OkHttpClient c;
    private final String d;
    private final InterfaceC3570Bk5 e;
    private final ConcurrentHashMap f;
    private final InterfaceC9173Yu3 g;

    /* renamed from: ir.nasim.qd1$a */
    public static final class a {
        private a() {
        }

        public final C19596qd1 a(Context context) {
            AbstractC13042fc3.i(context, "context");
            return ((InterfaceC8129Uq4) I22.a(context.getApplicationContext(), InterfaceC8129Uq4.class)).g0();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qd1$b */
    private final class b implements Callback {
        private final String a;
        final /* synthetic */ C19596qd1 b;

        public b(C19596qd1 c19596qd1, String str) {
            AbstractC13042fc3.i(str, "domain");
            this.b = c19596qd1;
            this.a = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(iOException, "e");
            C19406qI3.b("ConnectionHealthChecker", "Health check failed for domain: " + this.a + ", with message: " + iOException.getMessage());
            this.b.f.remove(this.a);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(response, "response");
            C19406qI3.a("ConnectionHealthChecker", "Health check successful for domain: " + this.a + " and response code: " + response.code(), new Object[0]);
            this.b.f.remove(this.a);
        }
    }

    public C19596qd1(int i, String str, OkHttpClient okHttpClient, String str2, InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(str, "appVersion");
        AbstractC13042fc3.i(okHttpClient, "client");
        AbstractC13042fc3.i(str2, "healthCheckerUrl");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        this.a = i;
        this.b = str;
        this.c = okHttpClient;
        this.d = str2;
        this.e = interfaceC3570Bk5;
        this.f = new ConcurrentHashMap();
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pd1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Long.valueOf(C19596qd1.g(this.a));
            }
        });
    }

    private final RequestBody c(String str, String str2, String str3, String str4, String str5) {
        return RequestBody.INSTANCE.create(AbstractC16016kZ6.g("\n            {\n                \"domain\": \"" + str + "\",\n                \"api_version\": \"" + str2 + "\",\n                \"app_version\": \"" + str3 + "\",\n                \"request_time\": \"" + str4 + "\",\n                \"session_id\": \"" + str5 + "\"\n            }\n        "), MediaType.INSTANCE.get("application/json"));
    }

    public static final C19596qd1 d(Context context) {
        return h.a(context);
    }

    private final long e() {
        return ((Number) this.g.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(C19596qd1 c19596qd1) {
        AbstractC13042fc3.i(c19596qd1, "this$0");
        if (c19596qd1.e.contains("session_id_key")) {
            return c19596qd1.e.getLong("session_id_key", 0L);
        }
        long jK = AbstractC17026mG5.a.k();
        c19596qd1.e.putLong("session_id_key", jK);
        return jK;
    }

    public final void f(String str, String str2) {
        AbstractC13042fc3.i(str, "domain");
        AbstractC13042fc3.i(str2, "requestTimeInMillis");
        if (this.f.contains(str)) {
            C19406qI3.j("ConnectionHealthChecker", "Already running the health check for the given domain: " + str, new Object[0]);
            return;
        }
        try {
            Request requestBuild = new Request.Builder().addHeader(SIPHeaderNames.CONTENT_TYPE, "application/json").addHeader("Host", "health.ble.ir").url(this.d).post(c(str, String.valueOf(this.a), this.b, str2, String.valueOf(e()))).build();
            C19406qI3.a("ConnectionHealthChecker", "Requesting health check for domain: " + str, new Object[0]);
            Call callNewCall = this.c.newCall(requestBuild);
            this.f.put(str, callNewCall);
            callNewCall.enqueue(new b(this, str));
        } catch (Throwable th) {
            this.f.remove(str);
            C19406qI3.c("ConnectionHealthChecker", "Health check failed for domain: " + str, th);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C19596qd1(OkHttpClient okHttpClient, InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(okHttpClient, "client");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        this(Build.VERSION.SDK_INT, strR, okHttpClient, "https://2.189.68.149:443/dnscheck", interfaceC3570Bk5);
    }
}
