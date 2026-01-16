package io.sentry;

import io.sentry.protocol.C3169d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class C0 implements D, Closeable {
    private final C3155n3 a;
    private final C3188s3 b;
    private final M2 c;
    private volatile L d = null;

    public C0(C3155n3 c3155n3) {
        C3155n3 c3155n32 = (C3155n3) io.sentry.util.u.c(c3155n3, "The SentryOptions is required.");
        this.a = c3155n32;
        C3183r3 c3183r3 = new C3183r3(c3155n32);
        this.c = new M2(c3183r3);
        this.b = new C3188s3(c3183r3, c3155n32);
    }

    private void G(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.N() == null) {
            abstractC3099c2.e0(new HashMap(this.a.getTags()));
            return;
        }
        for (Map.Entry<String, String> entry : this.a.getTags().entrySet()) {
            if (!abstractC3099c2.N().containsKey(entry.getKey())) {
                abstractC3099c2.d0(entry.getKey(), entry.getValue());
            }
        }
    }

    private void H(L2 l2, I i) {
        if (l2.v0() == null) {
            List<io.sentry.protocol.q> listQ0 = l2.q0();
            ArrayList arrayList = null;
            if (listQ0 != null && !listQ0.isEmpty()) {
                for (io.sentry.protocol.q qVar : listQ0) {
                    if (qVar.g() != null && qVar.j() != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(qVar.j());
                    }
                }
            }
            if (this.a.isAttachThreads() || io.sentry.util.m.h(i, io.sentry.hints.a.class)) {
                Object objG = io.sentry.util.m.g(i);
                l2.G0(this.b.b(arrayList, objG instanceof io.sentry.hints.a ? ((io.sentry.hints.a) objG).f() : false));
            } else if (this.a.isAttachStacktrace()) {
                if ((listQ0 == null || listQ0.isEmpty()) && !e(i)) {
                    l2.G0(this.b.a());
                }
            }
        }
    }

    private boolean J(AbstractC3099c2 abstractC3099c2, I i) {
        if (io.sentry.util.m.u(i)) {
            return true;
        }
        this.a.getLogger().c(Y2.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", abstractC3099c2.G());
        return false;
    }

    private void d() {
        if (this.d == null) {
            this.d = L.e();
        }
    }

    private boolean e(I i) {
        return io.sentry.util.m.h(i, io.sentry.hints.e.class);
    }

    private void g(AbstractC3099c2 abstractC3099c2) {
        io.sentry.protocol.G gQ = abstractC3099c2.Q();
        if (gQ == null) {
            gQ = new io.sentry.protocol.G();
            abstractC3099c2.g0(gQ);
        }
        if (gQ.j() == null && this.a.isSendDefaultPii()) {
            gQ.m("{{auto}}");
        }
    }

    private void j(AbstractC3099c2 abstractC3099c2) {
        u(abstractC3099c2);
        n(abstractC3099c2);
        z(abstractC3099c2);
        m(abstractC3099c2);
        y(abstractC3099c2);
        G(abstractC3099c2);
        g(abstractC3099c2);
    }

    private void k(AbstractC3099c2 abstractC3099c2) {
        s(abstractC3099c2);
    }

    private void l(AbstractC3099c2 abstractC3099c2) {
        C3169d c3169dC = C3169d.c(abstractC3099c2.D(), this.a);
        if (c3169dC != null) {
            abstractC3099c2.T(c3169dC);
        }
    }

    private void m(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.E() == null) {
            abstractC3099c2.U(this.a.getDist());
        }
    }

    private void n(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.F() == null) {
            abstractC3099c2.V(this.a.getEnvironment());
        }
    }

    private void p(L2 l2) {
        Throwable thP = l2.P();
        if (thP != null) {
            l2.B0(this.c.d(thP));
        }
    }

    private void q(L2 l2) {
        Map mapA = this.a.getModulesLoader().a();
        if (mapA == null) {
            return;
        }
        Map mapU0 = l2.u0();
        if (mapU0 == null) {
            l2.F0(mapA);
        } else {
            mapU0.putAll(mapA);
        }
    }

    private void s(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.I() == null) {
            abstractC3099c2.Y("java");
        }
    }

    private void u(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.J() == null) {
            abstractC3099c2.Z(this.a.getRelease());
        }
    }

    private void y(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.L() == null) {
            abstractC3099c2.b0(this.a.getSdkVersion());
        }
    }

    private void z(AbstractC3099c2 abstractC3099c2) {
        if (abstractC3099c2.M() == null) {
            abstractC3099c2.c0(this.a.getServerName());
        }
        if (this.a.isAttachServerName() && abstractC3099c2.M() == null) {
            d();
            if (this.d != null) {
                abstractC3099c2.c0(this.d.d());
            }
        }
    }

    @Override // io.sentry.D
    public C3160o3 a(C3160o3 c3160o3, I i) {
        k(c3160o3);
        if (J(c3160o3, i)) {
            j(c3160o3);
            io.sentry.protocol.p pVarI = this.a.getSessionReplay().i();
            if (pVarI != null) {
                c3160o3.b0(pVarI);
            }
        }
        return c3160o3;
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, I i) {
        k(l2);
        p(l2);
        l(l2);
        q(l2);
        if (J(l2, i)) {
            j(l2);
            H(l2, i);
        }
        return l2;
    }

    @Override // io.sentry.D
    public io.sentry.protocol.C c(io.sentry.protocol.C c, I i) {
        k(c);
        l(c);
        if (J(c, i)) {
            j(c);
        }
        return c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d != null) {
            this.d.c();
        }
    }
}
