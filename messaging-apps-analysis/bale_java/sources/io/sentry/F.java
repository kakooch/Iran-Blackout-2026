package io.sentry;

import io.sentry.C3155n3;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public final class F {
    private Boolean A;
    private Boolean B;
    private String C;
    private List D;
    private List E;
    private Boolean F;
    private Boolean G;
    private Boolean H;
    private Boolean I;
    private Boolean J;
    private Boolean K;
    private C3155n3.f L;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Double i;
    private Double j;
    private C3155n3.k k;
    private C3155n3.j m;
    private String r;
    private Long s;
    private List u;
    private Boolean v;
    private Boolean w;
    private Boolean y;
    private Boolean z;
    private final Map l = new ConcurrentHashMap();
    private final List n = new CopyOnWriteArrayList();
    private final List o = new CopyOnWriteArrayList();
    private List p = null;
    private final List q = new CopyOnWriteArrayList();
    private final Set t = new CopyOnWriteArraySet();
    private Set x = new CopyOnWriteArraySet();

    public static F g(io.sentry.config.f fVar, ILogger iLogger) throws ClassNotFoundException {
        F f = new F();
        f.X(fVar.f("dsn"));
        f.f0(fVar.f("environment"));
        f.r0(fVar.f("release"));
        f.W(fVar.f("dist"));
        f.v0(fVar.f("servername"));
        f.d0(fVar.g("uncaught.handler.enabled"));
        f.n0(fVar.g("uncaught.handler.print-stacktrace"));
        f.y0(fVar.c("traces-sample-rate"));
        f.o0(fVar.c("profiles-sample-rate"));
        f.V(fVar.g("debug"));
        f.Z(fVar.g("enable-deduplication"));
        f.s0(fVar.g("send-client-reports"));
        f.g0(fVar.g("force-init"));
        String strF = fVar.f("max-request-body-size");
        if (strF != null) {
            f.m0(C3155n3.k.valueOf(strF.toUpperCase(Locale.ROOT)));
        }
        for (Map.Entry entry : fVar.a("tags").entrySet()) {
            f.x0((String) entry.getKey(), (String) entry.getValue());
        }
        String strF2 = fVar.f("proxy.host");
        String strF3 = fVar.f("proxy.user");
        String strF4 = fVar.f("proxy.pass");
        String strD = fVar.d("proxy.port", "80");
        if (strF2 != null) {
            f.q0(new C3155n3.j(strF2, strD, strF3, strF4));
        }
        Iterator it = fVar.e("in-app-includes").iterator();
        while (it.hasNext()) {
            f.e((String) it.next());
        }
        Iterator it2 = fVar.e("in-app-excludes").iterator();
        while (it2.hasNext()) {
            f.d((String) it2.next());
        }
        List listE = fVar.f("trace-propagation-targets") != null ? fVar.e("trace-propagation-targets") : null;
        if (listE == null && fVar.f("tracing-origins") != null) {
            listE = fVar.e("tracing-origins");
        }
        if (listE != null) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                f.f((String) it3.next());
            }
        }
        Iterator it4 = fVar.e("context-tags").iterator();
        while (it4.hasNext()) {
            f.b((String) it4.next());
        }
        f.p0(fVar.f("proguard-uuid"));
        Iterator it5 = fVar.e("bundle-ids").iterator();
        while (it5.hasNext()) {
            f.a((String) it5.next());
        }
        f.i0(fVar.b("idle-timeout"));
        f.k0(fVar.h("ignored-errors"));
        f.e0(fVar.g("enabled"));
        f.b0(fVar.g("enable-pretty-serialization-output"));
        f.u0(fVar.g("send-modules"));
        f.t0(fVar.g("send-default-pii"));
        f.j0(fVar.h("ignored-checkins"));
        f.l0(fVar.h("ignored-transactions"));
        f.Y(fVar.g("enable-backpressure-handling"));
        f.h0(fVar.g("global-hub-mode"));
        f.T(fVar.g("capture-open-telemetry-events"));
        f.a0(fVar.g("logs.enabled"));
        for (String str : fVar.e("ignored-exceptions-for-type")) {
            try {
                Class<?> cls = Class.forName(str);
                if (Throwable.class.isAssignableFrom(cls)) {
                    f.c(cls);
                } else {
                    iLogger.c(Y2.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", str, str);
                }
            } catch (ClassNotFoundException unused) {
                iLogger.c(Y2.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", str, str);
            }
        }
        Long lB = fVar.b("cron.default-checkin-margin");
        Long lB2 = fVar.b("cron.default-max-runtime");
        String strF5 = fVar.f("cron.default-timezone");
        Long lB3 = fVar.b("cron.default-failure-issue-threshold");
        Long lB4 = fVar.b("cron.default-recovery-threshold");
        if (lB != null || lB2 != null || strF5 != null || lB3 != null || lB4 != null) {
            C3155n3.f fVar2 = new C3155n3.f();
            fVar2.f(lB);
            fVar2.h(lB2);
            fVar2.j(strF5);
            fVar2.g(lB3);
            fVar2.i(lB4);
            f.U(fVar2);
        }
        f.c0(fVar.g("enable-spotlight"));
        f.w0(fVar.f("spotlight-connection-url"));
        return f;
    }

    public String A() {
        return this.r;
    }

    public C3155n3.j B() {
        return this.m;
    }

    public String C() {
        return this.c;
    }

    public Boolean D() {
        return this.w;
    }

    public String E() {
        return this.e;
    }

    public String F() {
        return this.C;
    }

    public Map G() {
        return this.l;
    }

    public List H() {
        return this.p;
    }

    public Double I() {
        return this.i;
    }

    public Boolean J() {
        return this.K;
    }

    public Boolean K() {
        return this.H;
    }

    public Boolean L() {
        return this.B;
    }

    public Boolean M() {
        return this.z;
    }

    public Boolean N() {
        return this.A;
    }

    public Boolean O() {
        return this.y;
    }

    public Boolean P() {
        return this.J;
    }

    public Boolean Q() {
        return this.I;
    }

    public Boolean R() {
        return this.G;
    }

    public Boolean S() {
        return this.F;
    }

    public void T(Boolean bool) {
        this.K = bool;
    }

    public void U(C3155n3.f fVar) {
        this.L = fVar;
    }

    public void V(Boolean bool) {
        this.g = bool;
    }

    public void W(String str) {
        this.d = str;
    }

    public void X(String str) {
        this.a = str;
    }

    public void Y(Boolean bool) {
        this.H = bool;
    }

    public void Z(Boolean bool) {
        this.h = bool;
    }

    public void a(String str) {
        this.x.add(str);
    }

    public void a0(Boolean bool) {
        this.B = bool;
    }

    public void b(String str) {
        this.q.add(str);
    }

    public void b0(Boolean bool) {
        this.z = bool;
    }

    public void c(Class cls) {
        this.t.add(cls);
    }

    public void c0(Boolean bool) {
        this.A = bool;
    }

    public void d(String str) {
        this.n.add(str);
    }

    public void d0(Boolean bool) {
        this.f = bool;
    }

    public void e(String str) {
        this.o.add(str);
    }

    public void e0(Boolean bool) {
        this.y = bool;
    }

    public void f(String str) {
        if (this.p == null) {
            this.p = new CopyOnWriteArrayList();
        }
        if (str.isEmpty()) {
            return;
        }
        this.p.add(str);
    }

    public void f0(String str) {
        this.b = str;
    }

    public void g0(Boolean bool) {
        this.J = bool;
    }

    public Set h() {
        return this.x;
    }

    public void h0(Boolean bool) {
        this.I = bool;
    }

    public List i() {
        return this.q;
    }

    public void i0(Long l) {
        this.s = l;
    }

    public C3155n3.f j() {
        return this.L;
    }

    public void j0(List list) {
        this.D = list;
    }

    public Boolean k() {
        return this.g;
    }

    public void k0(List list) {
        this.u = list;
    }

    public String l() {
        return this.d;
    }

    public void l0(List list) {
        this.E = list;
    }

    public String m() {
        return this.a;
    }

    public void m0(C3155n3.k kVar) {
        this.k = kVar;
    }

    public Boolean n() {
        return this.h;
    }

    public void n0(Boolean bool) {
        this.v = bool;
    }

    public Boolean o() {
        return this.f;
    }

    public void o0(Double d) {
        this.j = d;
    }

    public String p() {
        return this.b;
    }

    public void p0(String str) {
        this.r = str;
    }

    public Long q() {
        return this.s;
    }

    public void q0(C3155n3.j jVar) {
        this.m = jVar;
    }

    public List r() {
        return this.D;
    }

    public void r0(String str) {
        this.c = str;
    }

    public List s() {
        return this.u;
    }

    public void s0(Boolean bool) {
        this.w = bool;
    }

    public Set t() {
        return this.t;
    }

    public void t0(Boolean bool) {
        this.G = bool;
    }

    public List u() {
        return this.E;
    }

    public void u0(Boolean bool) {
        this.F = bool;
    }

    public List v() {
        return this.n;
    }

    public void v0(String str) {
        this.e = str;
    }

    public List w() {
        return this.o;
    }

    public void w0(String str) {
        this.C = str;
    }

    public C3155n3.k x() {
        return this.k;
    }

    public void x0(String str, String str2) {
        this.l.put(str, str2);
    }

    public Boolean y() {
        return this.v;
    }

    public void y0(Double d) {
        this.i = d;
    }

    public Double z() {
        return this.j;
    }
}
