package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class jo {
    private final long a;
    private final long b;
    private final long c;
    private long d = 0;
    private long e;
    private long f;
    private long g;
    private long h;

    protected jo(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.a = j;
        this.b = j2;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.c = j7;
        this.h = a(j2, 0L, j4, j5, j6, j7);
    }

    protected static long a(long j, long j2, long j3, long j4, long j5, long j6) {
        if (j4 + 1 >= j5 || 1 + j2 >= j3) {
            return j4;
        }
        long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
        return aeu.I(((j4 + j7) - j6) - (j7 / 20), j4, (-1) + j5);
    }

    static /* synthetic */ void g(jo joVar, long j, long j2) {
        joVar.e = j;
        joVar.g = j2;
        joVar.i();
    }

    static /* synthetic */ void h(jo joVar, long j, long j2) {
        joVar.d = j;
        joVar.f = j2;
        joVar.i();
    }

    private final void i() {
        this.h = a(this.b, this.d, this.e, this.f, this.g, this.c);
    }
}
