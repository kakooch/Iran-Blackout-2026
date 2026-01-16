package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class er {
    public static final Object a = new Object();
    private static final dg q;
    public Object b = a;
    public dg c = q;
    public Object d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public long n;
    public long o;
    public long p;

    static {
        db dbVar = new db();
        dbVar.e("com.google.ads.interactivemedia.v3.exoplayer2.Timeline");
        dbVar.h(Uri.EMPTY);
        q = dbVar.a();
    }

    public final long a() {
        return bi.a(this.n);
    }

    public final void b(Object obj, dg dgVar, Object obj2, long j, long j2, long j3, boolean z, boolean z2, boolean z3, long j4, long j5, int i, long j6) {
        this.b = obj;
        this.c = dgVar != null ? dgVar : q;
        this.d = obj2;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.n = j4;
        this.o = j5;
        this.l = 0;
        this.m = i;
        this.p = j6;
        this.k = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && er.class.equals(obj.getClass())) {
            er erVar = (er) obj;
            if (aeu.c(this.b, erVar.b) && aeu.c(this.c, erVar.c) && aeu.c(this.d, erVar.d) && this.e == erVar.e && this.f == erVar.f && this.g == erVar.g && this.h == erVar.h && this.i == erVar.i && this.j == erVar.j && this.k == erVar.k && this.n == erVar.n && this.o == erVar.o && this.l == erVar.l && this.m == erVar.m && this.p == erVar.p) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.b.hashCode() + 217) * 31) + this.c.hashCode()) * 31;
        Object obj = this.d;
        int iHashCode2 = obj == null ? 0 : obj.hashCode();
        long j = this.e;
        long j2 = this.f;
        long j3 = this.g;
        boolean z = this.h;
        boolean z2 = this.i;
        boolean z3 = this.j;
        boolean z4 = this.k;
        long j4 = this.n;
        long j5 = this.o;
        int i = this.l;
        int i2 = this.m;
        long j6 = this.p;
        return ((((((((((((((((((((((((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 31) + (z4 ? 1 : 0)) * 31) + ((int) ((j4 >>> 32) ^ j4))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + i) * 31) + i2) * 31) + ((int) ((j6 >>> 32) ^ j6));
    }
}
