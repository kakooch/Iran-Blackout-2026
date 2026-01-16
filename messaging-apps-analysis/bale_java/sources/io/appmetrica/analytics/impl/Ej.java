package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class Ej {
    public final C2484d5 a;
    public final Vj b;
    public final Hj c;
    public long d;
    public long e;
    public AtomicLong f;
    public boolean g;
    public volatile Tj h;
    public long i;
    public long j;
    public final SystemTimeProvider k;

    public Ej(C2484d5 c2484d5, Vj vj, Hj hj, SystemTimeProvider systemTimeProvider) {
        this.a = c2484d5;
        this.b = vj;
        this.c = hj;
        this.k = systemTimeProvider;
        a();
    }

    public final void a() {
        Hj hj = this.c;
        long jElapsedRealtime = this.k.elapsedRealtime();
        Long l = hj.c;
        if (l != null) {
            jElapsedRealtime = l.longValue();
        }
        this.e = jElapsedRealtime;
        Long l2 = this.c.b;
        this.d = l2 == null ? -1L : l2.longValue();
        Long l3 = this.c.e;
        this.f = new AtomicLong(l3 == null ? 0L : l3.longValue());
        Boolean bool = this.c.f;
        this.g = bool == null ? true : bool.booleanValue();
        Long l4 = this.c.g;
        long jLongValue = l4 != null ? l4.longValue() : 0L;
        this.i = jLongValue;
        Hj hj2 = this.c;
        long jLongValue2 = jLongValue - this.e;
        Long l5 = hj2.h;
        if (l5 != null) {
            jLongValue2 = l5.longValue();
        }
        this.j = jLongValue2;
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", currentReportId=" + this.f + ", sessionRequestParams=" + this.h + ", sleepStart=" + this.i + '}';
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(long r14) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Ej.a(long):boolean");
    }
}
