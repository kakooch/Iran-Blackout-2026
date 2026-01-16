package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class bj {
    private final float a = 0.97f;
    private final float b = 1.03f;
    private final long c = 500;
    private final float d = 5.0E-8f;
    private de e = de.a;
    private long f = -9223372036854775807L;
    private float g = 1.0f;
    private long h = -9223372036854775807L;

    /* synthetic */ bj(float f, float f2, long j, float f3) {
    }

    public final void a(de deVar) {
        this.e = deVar;
        this.h = -9223372036854775807L;
    }

    public final void b(long j) {
        this.f = j;
        this.h = -9223372036854775807L;
    }

    public final float c(long j) {
        long jD = d();
        if (jD == -9223372036854775807L) {
            return 1.0f;
        }
        if (this.h != -9223372036854775807L && SystemClock.elapsedRealtime() - this.h < 500) {
            return this.g;
        }
        this.h = SystemClock.elapsedRealtime();
        long j2 = j - jD;
        if (Math.abs(j2) < 5000) {
            this.g = 1.0f;
            return 1.0f;
        }
        float f = (j2 * 5.0E-8f) + 1.0f;
        de deVar = this.e;
        float f2 = deVar.c;
        if (f2 == -3.4028235E38f) {
            f2 = 0.97f;
        }
        float f3 = deVar.d;
        if (f3 == -3.4028235E38f) {
            f3 = 1.03f;
        }
        float fJ = aeu.J(f, f2, f3);
        this.g = fJ;
        return fJ;
    }

    public final long d() {
        long j = this.f;
        return (j == -9223372036854775807L || this.e.b == -9223372036854775807L) ? bi.b(this.e.b) : j;
    }
}
