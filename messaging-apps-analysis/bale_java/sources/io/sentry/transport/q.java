package io.sentry.transport;

import io.sentry.C3134j2;
import io.sentry.I;
import java.io.Closeable;

/* loaded from: classes3.dex */
public interface q extends Closeable {
    default void C1(C3134j2 c3134j2) {
        c0(c3134j2, new I());
    }

    void c0(C3134j2 c3134j2, I i);

    void i(boolean z);

    void r(long j);

    default boolean t() {
        return true;
    }

    A w();
}
