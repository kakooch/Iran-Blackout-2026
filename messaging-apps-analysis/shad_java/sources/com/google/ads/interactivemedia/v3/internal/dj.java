package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class dj {
    public final tw a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    dj(tw twVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3) {
        this.a = twVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
        this.h = z3;
    }

    public final dj a(long j) {
        return j == this.b ? this : new dj(this.a, j, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && dj.class == obj.getClass()) {
            dj djVar = (dj) obj;
            if (this.b == djVar.b && this.c == djVar.c && this.d == djVar.d && this.e == djVar.e && this.f == djVar.f && this.g == djVar.g && this.h == djVar.h && aeu.c(this.a, djVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.a.hashCode() + 527) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0);
    }
}
