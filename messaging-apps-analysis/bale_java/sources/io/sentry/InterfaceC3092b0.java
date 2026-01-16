package io.sentry;

import io.sentry.protocol.C3171f;

/* renamed from: io.sentry.b0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC3092b0 {
    io.sentry.protocol.v a(C3160o3 c3160o3, X x, I i);

    io.sentry.protocol.v b(io.sentry.protocol.C c, T3 t3, X x, I i, C3186s1 c3186s1);

    void c(C3 c3, I i);

    io.sentry.protocol.v d(C3171f c3171f, I i, X x);

    void e(C3100c3 c3100c3);

    io.sentry.protocol.v f(C3158o1 c3158o1, X x);

    io.sentry.protocol.v g(L2 l2, X x, I i);

    void i(boolean z);

    boolean isEnabled();

    void r(long j);

    default boolean t() {
        return true;
    }

    io.sentry.transport.A w();

    io.sentry.protocol.v x(C3134j2 c3134j2, I i);
}
