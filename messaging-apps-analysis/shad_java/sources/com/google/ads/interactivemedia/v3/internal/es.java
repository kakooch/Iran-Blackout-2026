package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class es {
    public static final es a = new ep();

    public int c(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == d(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == d(z) ? e(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public int d(boolean z) {
        if (u()) {
            return -1;
        }
        return s() - 1;
    }

    public int e(boolean z) {
        return u() ? -1 : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof es)) {
            return false;
        }
        es esVar = (es) obj;
        if (esVar.s() != s() || esVar.t() != t()) {
            return false;
        }
        er erVar = new er();
        eq eqVar = new eq();
        er erVar2 = new er();
        eq eqVar2 = new eq();
        for (int i = 0; i < s(); i++) {
            if (!v(i, erVar).equals(esVar.v(i, erVar2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < t(); i2++) {
            if (!h(i2, eqVar, true).equals(esVar.h(i2, eqVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public abstract er f(int i, er erVar, long j);

    public eq g(Object obj, eq eqVar) {
        return h(i(obj), eqVar, true);
    }

    public abstract eq h(int i, eq eqVar, boolean z);

    public final int hashCode() {
        er erVar = new er();
        eq eqVar = new eq();
        int iS = s() + 217;
        for (int i = 0; i < s(); i++) {
            iS = (iS * 31) + v(i, erVar).hashCode();
        }
        int iT = (iS * 31) + t();
        for (int i2 = 0; i2 < t(); i2++) {
            iT = (iT * 31) + h(i2, eqVar, true).hashCode();
        }
        return iT;
    }

    public abstract int i(Object obj);

    public abstract Object j(int i);

    public abstract int s();

    public abstract int t();

    public final boolean u() {
        return s() == 0;
    }

    public final er v(int i, er erVar) {
        return f(i, erVar, 0L);
    }

    public final int w(int i, eq eqVar, er erVar, int i2, boolean z) {
        int i3 = z(i, eqVar).c;
        if (v(i3, erVar).m != i) {
            return i + 1;
        }
        int iC = c(i3, i2, z);
        if (iC == -1) {
            return -1;
        }
        return v(iC, erVar).l;
    }

    public final Pair<Object, Long> x(er erVar, eq eqVar, int i, long j) {
        Pair<Object, Long> pairY = y(erVar, eqVar, i, j, 0L);
        ary.t(pairY);
        return pairY;
    }

    public final Pair<Object, Long> y(er erVar, eq eqVar, int i, long j, long j2) {
        ary.u(i, s());
        f(i, erVar, j2);
        if (j == -9223372036854775807L) {
            j = erVar.n;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = erVar.l;
        long j3 = erVar.p + j;
        long j4 = h(i2, eqVar, true).d;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < erVar.m) {
            j3 -= j4;
            i2++;
            j4 = h(i2, eqVar, true).d;
        }
        Object obj = eqVar.b;
        ary.t(obj);
        return Pair.create(obj, Long.valueOf(j3));
    }

    public final eq z(int i, eq eqVar) {
        return h(i, eqVar, false);
    }
}
