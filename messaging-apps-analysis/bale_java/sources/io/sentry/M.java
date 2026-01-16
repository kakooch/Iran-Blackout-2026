package io.sentry;

import io.sentry.protocol.C3171f;

/* loaded from: classes3.dex */
public final class M implements S {
    private final Z a;

    public M(Z z) {
        this.a = z;
    }

    @Override // io.sentry.Z
    public void B(F1 f1, D1 d1) {
        this.a.B(f1, d1);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v C(C3160o3 c3160o3, I i) {
        return this.a.C(c3160o3, i);
    }

    @Override // io.sentry.Z
    public X D() {
        return Z1.s();
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v E(C3171f c3171f, I i, D1 d1) {
        return this.a.E(c3171f, i, d1);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v F(C3158o1 c3158o1) {
        return this.a.F(c3158o1);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v I(L2 l2, I i) {
        return this.a.I(l2, i);
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 K(W3 w3, Y3 y3) {
        return this.a.K(w3, y3);
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v L(io.sentry.protocol.C c, T3 t3, I i, C3186s1 c3186s1) {
        return this.a.L(c, t3, i, c3186s1);
    }

    @Override // io.sentry.Z
    public Z M(String str) {
        return this.a.M(str);
    }

    @Override // io.sentry.Z
    public void a(C3106e c3106e) {
        this.a.a(c3106e);
    }

    @Override // io.sentry.Z
    public void b(C3106e c3106e, I i) {
        this.a.b(c3106e, i);
    }

    @Override // io.sentry.Z
    public void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str) {
        this.a.d(th, interfaceC3117g0, str);
    }

    @Override // io.sentry.Z
    public C3155n3 e() {
        return this.a.e();
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 f() {
        return this.a.f();
    }

    @Override // io.sentry.Z
    public void g() {
        this.a.g();
    }

    @Override // io.sentry.Z
    public X getScope() {
        return this.a.getScope();
    }

    @Override // io.sentry.Z
    public void i(boolean z) {
        this.a.i(z);
    }

    @Override // io.sentry.Z
    public boolean isEnabled() {
        return this.a.isEnabled();
    }

    @Override // io.sentry.Z
    public void l() {
        this.a.l();
    }

    @Override // io.sentry.Z
    public void r(long j) {
        this.a.r(j);
    }

    @Override // io.sentry.Z
    public boolean t() {
        return this.a.t();
    }

    @Override // io.sentry.Z
    public io.sentry.transport.A w() {
        return this.a.w();
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v x(C3134j2 c3134j2, I i) {
        return this.a.x(c3134j2, i);
    }

    @Override // io.sentry.Z
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public S m17clone() {
        return this.a.m19clone();
    }
}
