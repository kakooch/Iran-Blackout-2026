package io.sentry.android.core.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class m {
    private final long a;
    private final io.sentry.transport.p b;
    private final int d;
    private final AtomicInteger c = new AtomicInteger(0);
    private final AtomicLong e = new AtomicLong(0);

    public m(io.sentry.transport.p pVar, long j, int i) {
        this.b = pVar;
        this.a = j;
        this.d = i <= 0 ? 1 : i;
    }

    public boolean a() {
        long jA = this.b.a();
        if (this.e.get() == 0 || this.e.get() + this.a <= jA) {
            this.c.set(0);
            this.e.set(jA);
            return false;
        }
        if (this.c.incrementAndGet() < this.d) {
            return false;
        }
        this.c.set(0);
        return true;
    }
}
