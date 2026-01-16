package io.sentry;

import io.sentry.protocol.C3171f;

/* loaded from: classes3.dex */
public interface Z {
    default boolean A() {
        return false;
    }

    void B(F1 f1, D1 d1);

    io.sentry.protocol.v C(C3160o3 c3160o3, I i);

    X D();

    io.sentry.protocol.v E(C3171f c3171f, I i, D1 d1);

    io.sentry.protocol.v F(C3158o1 c3158o1);

    default io.sentry.protocol.v G(C3134j2 c3134j2) {
        return x(c3134j2, new I());
    }

    default io.sentry.protocol.v H(C3171f c3171f, I i) {
        return E(c3171f, i, null);
    }

    io.sentry.protocol.v I(L2 l2, I i);

    default io.sentry.protocol.v J(L2 l2) {
        return I(l2, new I());
    }

    InterfaceC3127i0 K(W3 w3, Y3 y3);

    io.sentry.protocol.v L(io.sentry.protocol.C c, T3 t3, I i, C3186s1 c3186s1);

    Z M(String str);

    default io.sentry.protocol.v N(C3171f c3171f) {
        return H(c3171f, null);
    }

    void a(C3106e c3106e);

    void b(C3106e c3106e, I i);

    S clone();

    void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str);

    C3155n3 e();

    InterfaceC3127i0 f();

    void g();

    X getScope();

    void i(boolean z);

    boolean isEnabled();

    void l();

    void r(long j);

    boolean t();

    io.sentry.transport.A w();

    io.sentry.protocol.v x(C3134j2 c3134j2, I i);

    default io.sentry.protocol.v y(io.sentry.protocol.C c, T3 t3, I i) {
        return L(c, t3, i, null);
    }

    default void z(D1 d1) {
        B(null, d1);
    }
}
