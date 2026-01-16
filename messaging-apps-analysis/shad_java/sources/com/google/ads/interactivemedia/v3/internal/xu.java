package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class xu extends xz {
    final long a;
    final long b;
    final List<xx> c;
    final long d;
    private final long e;
    private final long f;

    public xu(xq xqVar, long j, long j2, long j3, long j4, List<xx> list, long j5, long j6, long j7) {
        super(xqVar, j, j2);
        this.a = j3;
        this.b = j4;
        this.c = list;
        this.d = j5;
        this.e = j6;
        this.f = j7;
    }

    public final long a(long j, long j2) {
        long j3 = this.a;
        long jH = h(j2);
        if (jH == 0) {
            return j3;
        }
        if (this.c == null) {
            long j4 = this.a + (j / ((this.b * 1000000) / this.i));
            return j4 < j3 ? j3 : jH != -1 ? Math.min(j4, (j3 + jH) - 1) : j4;
        }
        long j5 = (jH + j3) - 1;
        long j6 = j3;
        while (j6 <= j5) {
            long j7 = ((j5 - j6) / 2) + j6;
            long jC = c(j7);
            if (jC < j) {
                j6 = 1 + j7;
            } else {
                if (jC <= j) {
                    return j7;
                }
                j5 = j7 - 1;
            }
        }
        return j6 == j3 ? j6 : j5;
    }

    public final long b(long j, long j2) {
        List<xx> list = this.c;
        if (list != null) {
            return (list.get((int) (j - this.a)).b * 1000000) / this.i;
        }
        int iH = h(j2);
        return (iH == -1 || j != (this.a + ((long) iH)) + (-1)) ? (this.b * 1000000) / this.i : j2 - c(j);
    }

    public final long c(long j) {
        List<xx> list = this.c;
        return aeu.N(list != null ? list.get((int) (j - this.a)).a - this.j : (j - this.a) * this.b, 1000000L, this.i);
    }

    public abstract xq d(xt xtVar, long j);

    public final long e(long j, long j2) {
        if (h(j) == -1) {
            long j3 = this.e;
            if (j3 != -9223372036854775807L) {
                return Math.max(this.a, a((j2 - this.f) - j3, j));
            }
        }
        return this.a;
    }

    public final int f(long j, long j2) {
        int iH = h(j);
        return iH != -1 ? iH : (int) (a((j2 - this.f) + this.d, j) - e(j, j2));
    }

    public boolean g() {
        return this.c != null;
    }

    public abstract int h(long j);
}
