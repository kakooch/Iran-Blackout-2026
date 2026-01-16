package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;

/* renamed from: com.google.android.exoplayer2.d0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C2024d0 {
    public final MediaSource.MediaPeriodId a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    C2024d0(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        AbstractC20011rK.a(!z4 || z2);
        AbstractC20011rK.a(!z3 || z2);
        if (z && (z2 || z3 || z4)) {
            z5 = false;
        }
        AbstractC20011rK.a(z5);
        this.a = mediaPeriodId;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public C2024d0 a(long j) {
        return j == this.c ? this : new C2024d0(this.a, this.b, j, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public C2024d0 b(long j) {
        return j == this.b ? this : new C2024d0(this.a, j, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2024d0.class != obj.getClass()) {
            return false;
        }
        C2024d0 c2024d0 = (C2024d0) obj;
        return this.b == c2024d0.b && this.c == c2024d0.c && this.d == c2024d0.d && this.e == c2024d0.e && this.f == c2024d0.f && this.g == c2024d0.g && this.h == c2024d0.h && this.i == c2024d0.i && AbstractC9683aN7.c(this.a, c2024d0.a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.a.hashCode()) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }
}
