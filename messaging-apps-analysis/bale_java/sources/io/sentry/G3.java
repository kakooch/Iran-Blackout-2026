package io.sentry;

import io.sentry.protocol.C3168c;
import io.sentry.protocol.C3174i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class G3 implements InterfaceC3117g0 {
    private AbstractC3124h2 a;
    private AbstractC3124h2 b;
    private final H3 c;
    private final C3234z3 d;
    private Throwable e;
    private final Z f;
    private final N3 i;
    private J3 j;
    private boolean g = false;
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final Map k = new ConcurrentHashMap();
    private final Map l = new ConcurrentHashMap();
    private final C3168c m = new C3168c();

    G3(C3234z3 c3234z3, Z z, H3 h3, N3 n3, J3 j3) {
        this.c = h3;
        h3.r(n3.a());
        this.d = (C3234z3) io.sentry.util.u.c(c3234z3, "transaction is required");
        this.f = (Z) io.sentry.util.u.c(z, "Scopes are required");
        this.i = n3;
        this.j = j3;
        AbstractC3124h2 abstractC3124h2C = n3.c();
        if (abstractC3124h2C != null) {
            this.a = abstractC3124h2C;
        } else {
            this.a = z.e().getDateProvider().a();
        }
    }

    private void I(AbstractC3124h2 abstractC3124h2) {
        this.a = abstractC3124h2;
    }

    private List f() {
        ArrayList arrayList = new ArrayList();
        for (G3 g3 : this.d.M()) {
            if (g3.z() != null && g3.z().equals(C())) {
                arrayList.add(g3);
            }
        }
        return arrayList;
    }

    public V3 A() {
        return this.c.j();
    }

    J3 B() {
        return this.j;
    }

    public M3 C() {
        return this.c.k();
    }

    public Map D() {
        return this.c.m();
    }

    public io.sentry.protocol.v E() {
        return this.c.n();
    }

    public Boolean F() {
        return this.c.h();
    }

    void G(J3 j3) {
        this.j = j3;
    }

    public boolean H(AbstractC3124h2 abstractC3124h2) {
        if (this.b == null) {
            return false;
        }
        this.b = abstractC3124h2;
        return true;
    }

    public Map e() {
        return this.k;
    }

    public Map g() {
        return this.l;
    }

    @Override // io.sentry.InterfaceC3117g0
    public String getDescription() {
        return this.c.c();
    }

    public String h() {
        return this.c.e();
    }

    N3 i() {
        return this.i;
    }

    @Override // io.sentry.InterfaceC3117g0
    public O3 j() {
        return this.c.l();
    }

    @Override // io.sentry.InterfaceC3117g0
    public boolean k() {
        return this.g;
    }

    @Override // io.sentry.InterfaceC3117g0
    public Boolean l() {
        return this.c.i();
    }

    @Override // io.sentry.InterfaceC3117g0
    public void m() {
        r(this.c.l());
    }

    @Override // io.sentry.InterfaceC3117g0
    public void n(String str) {
        this.c.p(str);
    }

    @Override // io.sentry.InterfaceC3117g0
    public void o(String str, Number number) {
        if (k()) {
            this.f.e().getLogger().c(Y2.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.l.put(str, new C3174i(number, null));
        if (this.d.K() != this) {
            this.d.a0(str, number);
        }
    }

    @Override // io.sentry.InterfaceC3117g0
    public void q(String str, Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            this.k.remove(str);
        } else {
            this.k.put(str, obj);
        }
    }

    @Override // io.sentry.InterfaceC3117g0
    public void r(O3 o3) {
        x(o3, this.f.e().getDateProvider().a());
    }

    @Override // io.sentry.InterfaceC3117g0
    public InterfaceC3117g0 s(String str, String str2, AbstractC3124h2 abstractC3124h2, EnumC3152n0 enumC3152n0) {
        return u(str, str2, abstractC3124h2, enumC3152n0, new N3());
    }

    @Override // io.sentry.InterfaceC3117g0
    public void t(String str, Number number, E0 e0) {
        if (k()) {
            this.f.e().getLogger().c(Y2.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.l.put(str, new C3174i(number, e0.apiName()));
        if (this.d.K() != this) {
            this.d.b0(str, number, e0);
        }
    }

    @Override // io.sentry.InterfaceC3117g0
    public InterfaceC3117g0 u(String str, String str2, AbstractC3124h2 abstractC3124h2, EnumC3152n0 enumC3152n0, N3 n3) {
        return this.g ? C3033a1.e() : this.d.c0(this.c.k(), str, str2, abstractC3124h2, enumC3152n0, n3);
    }

    @Override // io.sentry.InterfaceC3117g0
    public H3 v() {
        return this.c;
    }

    @Override // io.sentry.InterfaceC3117g0
    public AbstractC3124h2 w() {
        return this.b;
    }

    @Override // io.sentry.InterfaceC3117g0
    public void x(O3 o3, AbstractC3124h2 abstractC3124h2) {
        AbstractC3124h2 abstractC3124h22;
        if (this.g || !this.h.compareAndSet(false, true)) {
            return;
        }
        this.c.t(o3);
        if (abstractC3124h2 == null) {
            abstractC3124h2 = this.f.e().getDateProvider().a();
        }
        this.b = abstractC3124h2;
        if (this.i.f() || this.i.e()) {
            AbstractC3124h2 abstractC3124h2Y = null;
            AbstractC3124h2 abstractC3124h2W = null;
            for (G3 g3 : this.d.K().C().equals(C()) ? this.d.H() : f()) {
                if (abstractC3124h2Y == null || g3.y().j(abstractC3124h2Y)) {
                    abstractC3124h2Y = g3.y();
                }
                if (abstractC3124h2W == null || (g3.w() != null && g3.w().i(abstractC3124h2W))) {
                    abstractC3124h2W = g3.w();
                }
            }
            if (this.i.f() && abstractC3124h2Y != null && this.a.j(abstractC3124h2Y)) {
                I(abstractC3124h2Y);
            }
            if (this.i.e() && abstractC3124h2W != null && ((abstractC3124h22 = this.b) == null || abstractC3124h22.i(abstractC3124h2W))) {
                H(abstractC3124h2W);
            }
        }
        Throwable th = this.e;
        if (th != null) {
            this.f.d(th, this, this.d.getName());
        }
        J3 j3 = this.j;
        if (j3 != null) {
            j3.a(this);
        }
        this.g = true;
    }

    @Override // io.sentry.InterfaceC3117g0
    public AbstractC3124h2 y() {
        return this.a;
    }

    public M3 z() {
        return this.c.g();
    }

    public G3(W3 w3, C3234z3 c3234z3, Z z, N3 n3) {
        H3 h3 = (H3) io.sentry.util.u.c(w3, "context is required");
        this.c = h3;
        h3.r(n3.a());
        this.d = (C3234z3) io.sentry.util.u.c(c3234z3, "sentryTracer is required");
        this.f = (Z) io.sentry.util.u.c(z, "scopes are required");
        this.j = null;
        AbstractC3124h2 abstractC3124h2C = n3.c();
        if (abstractC3124h2C != null) {
            this.a = abstractC3124h2C;
        } else {
            this.a = z.e().getDateProvider().a();
        }
        this.i = n3;
    }
}
