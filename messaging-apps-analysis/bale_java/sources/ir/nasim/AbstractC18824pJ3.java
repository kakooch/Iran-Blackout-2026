package ir.nasim;

import ir.nasim.Q12;

/* renamed from: ir.nasim.pJ3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18824pJ3 {
    private static final long a(long j) {
        return j < 0 ? Q12.b.b() : Q12.b.a();
    }

    private static final long b(long j, long j2, W12 w12) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            return T12.t(j3, w12);
        }
        W12 w122 = W12.d;
        if (w12.compareTo(w122) >= 0) {
            return Q12.T(a(j3));
        }
        long jB = Y12.b(1L, w122, w12);
        long j4 = (j / jB) - (j2 / jB);
        long j5 = (j % jB) - (j2 % jB);
        Q12.a aVar = Q12.b;
        return Q12.P(T12.t(j4, w122), T12.t(j5, w12));
    }

    public static final long c(long j, long j2, W12 w12) {
        AbstractC13042fc3.i(w12, "unit");
        return ((j2 - 1) | 1) == Long.MAX_VALUE ? j == j2 ? Q12.b.c() : Q12.T(a(j2)) : (1 | (j - 1)) == Long.MAX_VALUE ? a(j) : b(j, j2, w12);
    }
}
