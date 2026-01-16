package io.sentry;

import io.sentry.util.C3202a;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: io.sentry.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3101d {
    static final Integer i = 8192;
    static final Integer j = 64;
    private static final c k = new c();
    private final ConcurrentHashMap a;
    private final C3202a b;
    private Double c;
    private Double d;
    private final String e;
    private boolean f;
    private final boolean g;
    final ILogger h;

    /* renamed from: io.sentry.d$b */
    public static final class b {
        public static final List a = Arrays.asList("sentry-trace_id", "sentry-public_key", "sentry-release", "sentry-user_id", "sentry-environment", "sentry-transaction", "sentry-sample_rate", "sentry-sample_rand", "sentry-sampled", "sentry-replay_id");
    }

    /* renamed from: io.sentry.d$c */
    private static class c extends ThreadLocal {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DecimalFormat initialValue() {
            return new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT));
        }
    }

    public C3101d(ILogger iLogger) {
        this(new ConcurrentHashMap(), null, null, null, true, false, iLogger);
    }

    public static C3101d c(AbstractC3099c2 abstractC3099c2, String str, C3155n3 c3155n3) {
        C3101d c3101d = new C3101d(c3155n3.getLogger());
        H3 h3I = abstractC3099c2.C().i();
        c3101d.E(h3I != null ? h3I.n().toString() : null);
        c3101d.y(c3155n3.retrieveParsedDsn().a());
        c3101d.z(abstractC3099c2.J());
        c3101d.x(abstractC3099c2.F());
        c3101d.F(str);
        c3101d.C(null);
        c3101d.D(null);
        c3101d.B(null);
        Object objC = abstractC3099c2.C().c("replay_id");
        if (objC != null && !objC.toString().equals(io.sentry.protocol.v.b.toString())) {
            c3101d.A(objC.toString());
            abstractC3099c2.C().m("replay_id");
        }
        c3101d.b();
        return c3101d;
    }

    private static boolean p(io.sentry.protocol.F f) {
        return (f == null || io.sentry.protocol.F.URL.equals(f)) ? false : true;
    }

    private static Double s(V3 v3) {
        if (v3 == null) {
            return null;
        }
        return v3.c();
    }

    private static Double t(V3 v3) {
        if (v3 == null) {
            return null;
        }
        return v3.d();
    }

    private static String u(Double d) {
        if (io.sentry.util.y.h(d, false)) {
            return ((DecimalFormat) k.get()).format(d);
        }
        return null;
    }

    private static Boolean v(V3 v3) {
        if (v3 == null) {
            return null;
        }
        return v3.e();
    }

    public void A(String str) {
        w("sentry-replay_id", str);
    }

    public void B(Double d) {
        if (q()) {
            this.d = d;
        }
    }

    public void C(Double d) {
        if (q()) {
            this.c = d;
        }
    }

    public void D(String str) {
        w("sentry-sampled", str);
    }

    public void E(String str) {
        w("sentry-trace_id", str);
    }

    public void F(String str) {
        w("sentry-transaction", str);
    }

    public void G(V3 v3) {
        if (v3 == null) {
            return;
        }
        D(io.sentry.util.B.g(v(v3)));
        if (v3.c() != null) {
            B(s(v3));
        }
        if (v3.d() != null) {
            a(t(v3));
        }
    }

    public void H(X x, C3155n3 c3155n3) {
        C3199u1 c3199u1Z = x.z();
        io.sentry.protocol.v vVarJ = x.j();
        E(c3199u1Z.e().toString());
        y(c3155n3.retrieveParsedDsn().a());
        z(c3155n3.getRelease());
        x(c3155n3.getEnvironment());
        if (!io.sentry.protocol.v.b.equals(vVarJ)) {
            A(vVarJ.toString());
        }
        F(null);
        C(null);
        D(null);
    }

    public void I(io.sentry.protocol.v vVar, io.sentry.protocol.v vVar2, C3155n3 c3155n3, V3 v3, String str, io.sentry.protocol.F f) {
        E(vVar.toString());
        y(c3155n3.retrieveParsedDsn().a());
        z(c3155n3.getRelease());
        x(c3155n3.getEnvironment());
        if (!p(f)) {
            str = null;
        }
        F(str);
        if (vVar2 != null && !io.sentry.protocol.v.b.equals(vVar2)) {
            A(vVar2.toString());
        }
        C(t(v3));
        D(io.sentry.util.B.g(v(v3)));
        B(s(v3));
    }

    public T3 J() {
        String strL = l();
        String strH = h();
        String strF = f();
        if (strL == null || strF == null) {
            return null;
        }
        T3 t3 = new T3(new io.sentry.protocol.v(strL), strF, g(), e(), o(), m(), u(j()), k(), strH == null ? null : new io.sentry.protocol.v(strH), u(i()));
        t3.c(n());
        return t3;
    }

    public void a(Double d) {
        this.c = d;
    }

    public void b() {
        this.f = false;
    }

    public String d(String str) {
        if (str == null) {
            return null;
        }
        return (String) this.a.get(str);
    }

    public String e() {
        return d("sentry-environment");
    }

    public String f() {
        return d("sentry-public_key");
    }

    public String g() {
        return d("sentry-release");
    }

    public String h() {
        return d("sentry-replay_id");
    }

    public Double i() {
        return this.d;
    }

    public Double j() {
        return this.c;
    }

    public String k() {
        return d("sentry-sampled");
    }

    public String l() {
        return d("sentry-trace_id");
    }

    public String m() {
        return d("sentry-transaction");
    }

    public Map n() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            for (Map.Entry entry : this.a.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!b.a.contains(str) && str2 != null) {
                    concurrentHashMap.put(str.replaceFirst("sentry-", ""), str2);
                }
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return concurrentHashMap;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String o() {
        return d("sentry-user_id");
    }

    public boolean q() {
        return this.f;
    }

    public boolean r() {
        return this.g;
    }

    public void w(String str, String str2) {
        if (this.f) {
            if (str2 == null) {
                this.a.remove(str);
            } else {
                this.a.put(str, str2);
            }
        }
    }

    public void x(String str) {
        w("sentry-environment", str);
    }

    public void y(String str) {
        w("sentry-public_key", str);
    }

    public void z(String str) {
        w("sentry-release", str);
    }

    public C3101d(ConcurrentHashMap concurrentHashMap, Double d, Double d2, String str, boolean z, boolean z2, ILogger iLogger) {
        this.b = new C3202a();
        this.a = concurrentHashMap;
        this.c = d;
        this.d = d2;
        this.h = iLogger;
        this.e = str;
        this.f = z;
        this.g = z2;
    }
}
