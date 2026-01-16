package io.sentry;

import io.sentry.protocol.C3171f;

/* loaded from: classes3.dex */
public final class N1 implements Z {
    private static final N1 a = new N1();

    private N1() {
    }

    public static N1 c() {
        return a;
    }

    @Override // io.sentry.Z
    public void B(F1 f1, D1 d1) {
        Z1.m(f1, d1);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v C(C3160o3 c3160o3, I i) {
        return Z1.r().C(c3160o3, i);
    }

    @Override // io.sentry.Z
    public X D() {
        return Z1.s();
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v E(C3171f c3171f, I i, D1 d1) {
        return Z1.k(c3171f, i, d1);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v F(C3158o1 c3158o1) {
        return Z1.r().F(c3158o1);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v H(C3171f c3171f, I i) {
        return Z1.j(c3171f, i);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v I(L2 l2, I i) {
        return Z1.h(l2, i);
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 K(W3 w3, Y3 y3) {
        return Z1.N(w3, y3);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v L(io.sentry.protocol.C c, T3 t3, I i, C3186s1 c3186s1) {
        return Z1.r().L(c, t3, i, c3186s1);
    }

    @Override // io.sentry.Z
    public Z M(String str) {
        return Z1.q(str);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v N(C3171f c3171f) {
        return Z1.i(c3171f);
    }

    @Override // io.sentry.Z
    public void a(C3106e c3106e) {
        b(c3106e, new I());
    }

    @Override // io.sentry.Z
    public void b(C3106e c3106e, I i) {
        Z1.e(c3106e, i);
    }

    @Override // io.sentry.Z
    public void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str) {
        Z1.r().d(th, interfaceC3117g0, str);
    }

    @Override // io.sentry.Z
    public C3155n3 e() {
        return Z1.r().e();
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 f() {
        return Z1.r().f();
    }

    @Override // io.sentry.Z
    public void g() {
        Z1.n();
    }

    @Override // io.sentry.Z
    public X getScope() {
        return Z1.r().getScope();
    }

    @Override // io.sentry.Z
    public void i(boolean z) {
        Z1.l();
    }

    @Override // io.sentry.Z
    public boolean isEnabled() {
        return Z1.C();
    }

    @Override // io.sentry.Z
    public void l() {
        Z1.M();
    }

    @Override // io.sentry.Z
    public void r(long j) {
        Z1.p(j);
    }

    @Override // io.sentry.Z
    public boolean t() {
        return Z1.D();
    }

    @Override // io.sentry.Z
    public io.sentry.transport.A w() {
        return Z1.r().w();
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v x(C3134j2 c3134j2, I i) {
        return Z1.r().x(c3134j2, i);
    }

    @Override // io.sentry.Z
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public S m19clone() {
        return Z1.r().m18clone();
    }
}
