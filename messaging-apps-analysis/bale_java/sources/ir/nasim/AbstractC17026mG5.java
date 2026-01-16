package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.mG5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC17026mG5 {
    public static final a a = new a(null);
    private static final AbstractC17026mG5 b = AbstractC13101ff5.a.b();

    /* renamed from: ir.nasim.mG5$a */
    public static final class a extends AbstractC17026mG5 implements Serializable {
        public /* synthetic */ a(ED1 ed1) {
            this();
        }

        @Override // ir.nasim.AbstractC17026mG5
        public int b(int i) {
            return AbstractC17026mG5.b.b(i);
        }

        @Override // ir.nasim.AbstractC17026mG5
        public boolean c() {
            return AbstractC17026mG5.b.c();
        }

        @Override // ir.nasim.AbstractC17026mG5
        public double d() {
            return AbstractC17026mG5.b.d();
        }

        @Override // ir.nasim.AbstractC17026mG5
        public double e(double d, double d2) {
            return AbstractC17026mG5.b.e(d, d2);
        }

        @Override // ir.nasim.AbstractC17026mG5
        public int f() {
            return AbstractC17026mG5.b.f();
        }

        @Override // ir.nasim.AbstractC17026mG5
        public int g(int i) {
            return AbstractC17026mG5.b.g(i);
        }

        @Override // ir.nasim.AbstractC17026mG5
        public int j(int i, int i2) {
            return AbstractC17026mG5.b.j(i, i2);
        }

        @Override // ir.nasim.AbstractC17026mG5
        public long k() {
            return AbstractC17026mG5.b.k();
        }

        @Override // ir.nasim.AbstractC17026mG5
        public long l(long j) {
            return AbstractC17026mG5.b.l(j);
        }

        @Override // ir.nasim.AbstractC17026mG5
        public long m(long j, long j2) {
            return AbstractC17026mG5.b.m(j, j2);
        }

        private a() {
        }
    }

    public abstract int b(int i);

    public abstract boolean c();

    public abstract double d();

    public double e(double d, double d2) {
        double d3;
        AbstractC18208oG5.b(d, d2);
        double d4 = d2 - d;
        if (!Double.isInfinite(d4) || Double.isInfinite(d) || Double.isNaN(d) || Double.isInfinite(d2) || Double.isNaN(d2)) {
            d3 = d + (d() * d4);
        } else {
            double d5 = 2;
            double d6 = d() * ((d2 / d5) - (d / d5));
            d3 = d + d6 + d6;
        }
        return d3 >= d2 ? Math.nextAfter(d2, Double.NEGATIVE_INFINITY) : d3;
    }

    public abstract int f();

    public abstract int g(int i);

    public int j(int i, int i2) {
        int iF;
        int i3;
        int iB;
        AbstractC18208oG5.c(i, i2);
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                iB = b(AbstractC18208oG5.e(i4));
            } else {
                do {
                    iF = f() >>> 1;
                    i3 = iF % i4;
                } while ((iF - i3) + (i4 - 1) < 0);
                iB = i3;
            }
            return i + iB;
        }
        while (true) {
            int iF2 = f();
            if (i <= iF2 && iF2 < i2) {
                return iF2;
            }
        }
    }

    public abstract long k();

    public long l(long j) {
        return m(0L, j);
    }

    public long m(long j, long j2) {
        long jK;
        long j3;
        long jB;
        int iF;
        AbstractC18208oG5.d(j, j2);
        long j4 = j2 - j;
        if (j4 > 0) {
            if (((-j4) & j4) == j4) {
                int i = (int) j4;
                int i2 = (int) (j4 >>> 32);
                if (i != 0) {
                    iF = b(AbstractC18208oG5.e(i));
                } else if (i2 == 1) {
                    iF = f();
                } else {
                    jB = (b(AbstractC18208oG5.e(i2)) << 32) + (f() & 4294967295L);
                }
                jB = iF & 4294967295L;
            } else {
                do {
                    jK = k() >>> 1;
                    j3 = jK % j4;
                } while ((jK - j3) + (j4 - 1) < 0);
                jB = j3;
            }
            return j + jB;
        }
        while (true) {
            long jK2 = k();
            if (j <= jK2 && jK2 < j2) {
                return jK2;
            }
        }
    }
}
