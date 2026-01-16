package io.sentry;

import io.sentry.protocol.C3171f;
import io.sentry.util.q;

/* loaded from: classes3.dex */
public final class R0 implements Z {
    private static final R0 b = new R0();
    private final io.sentry.util.q a = new io.sentry.util.q(new q.a() { // from class: io.sentry.Q0
        @Override // io.sentry.util.q.a
        public final Object a() {
            return C3155n3.empty();
        }
    });

    private R0() {
    }

    public static R0 h() {
        return b;
    }

    @Override // io.sentry.Z
    public boolean A() {
        return true;
    }

    @Override // io.sentry.Z
    public void B(F1 f1, D1 d1) {
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v C(C3160o3 c3160o3, I i) {
        return io.sentry.protocol.v.b;
    }

    @Override // io.sentry.Z
    public X D() {
        return P0.i();
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v E(C3171f c3171f, I i, D1 d1) {
        return io.sentry.protocol.v.b;
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v F(C3158o1 c3158o1) {
        return io.sentry.protocol.v.b;
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v I(L2 l2, I i) {
        return io.sentry.protocol.v.b;
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 K(W3 w3, Y3 y3) {
        return C3098c1.e();
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v L(io.sentry.protocol.C c, T3 t3, I i, C3186s1 c3186s1) {
        return io.sentry.protocol.v.b;
    }

    @Override // io.sentry.Z
    public Z M(String str) {
        return h();
    }

    @Override // io.sentry.Z
    public void a(C3106e c3106e) {
    }

    @Override // io.sentry.Z
    public void b(C3106e c3106e, I i) {
    }

    @Override // io.sentry.Z
    public void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str) {
    }

    @Override // io.sentry.Z
    public C3155n3 e() {
        return (C3155n3) this.a.a();
    }

    @Override // io.sentry.Z
    public InterfaceC3127i0 f() {
        return null;
    }

    @Override // io.sentry.Z
    public void g() {
    }

    @Override // io.sentry.Z
    public X getScope() {
        return P0.i();
    }

    @Override // io.sentry.Z
    public void i(boolean z) {
    }

    @Override // io.sentry.Z
    public boolean isEnabled() {
        return false;
    }

    @Override // io.sentry.Z
    public void l() {
    }

    @Override // io.sentry.Z
    public void r(long j) {
    }

    @Override // io.sentry.Z
    public boolean t() {
        return true;
    }

    @Override // io.sentry.Z
    public io.sentry.transport.A w() {
        return null;
    }

    @Override // io.sentry.Z
    public io.sentry.protocol.v x(C3134j2 c3134j2, I i) {
        return io.sentry.protocol.v.b;
    }

    @Override // io.sentry.Z
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public S m21clone() {
        return K0.c();
    }
}
