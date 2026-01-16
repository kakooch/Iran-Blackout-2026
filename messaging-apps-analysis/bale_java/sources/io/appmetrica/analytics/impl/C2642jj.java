package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.jj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2642jj {
    public volatile long a;
    public C2733ne b;
    public TimeProvider c;

    public static C2642jj c() {
        return AbstractC2618ij.a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.a;
    }

    public final synchronized void b() {
        this.b.c(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.a;
    }

    public final synchronized void e() {
        a(C2586ha.C.w(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.a(true);
    }

    public final synchronized void a(long j, Long l) {
        try {
            this.a = (j - this.c.currentTimeMillis()) / 1000;
            boolean z = true;
            if (this.b.a(true)) {
                if (l != null) {
                    long jAbs = Math.abs(j - this.c.currentTimeMillis());
                    C2733ne c2733ne = this.b;
                    if (jAbs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                        z = false;
                    }
                    c2733ne.c(z);
                } else {
                    this.b.c(false);
                }
            }
            this.b.d(this.a);
            this.b.b();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(C2733ne c2733ne, TimeProvider timeProvider) {
        this.b = c2733ne;
        this.a = c2733ne.a(0);
        this.c = timeProvider;
    }
}
