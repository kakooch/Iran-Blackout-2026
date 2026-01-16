package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC7076Qe0;

/* renamed from: ir.nasim.ey5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C12653ey5 extends AbstractC7076Qe0 {

    /* renamed from: ir.nasim.ey5$b */
    private static final class b implements AbstractC7076Qe0.f {
        private final C5045Hq7 a;
        private final EW4 b;

        private AbstractC7076Qe0.e c(EW4 ew4, long j, long j2) {
            int iF = -1;
            int iF2 = -1;
            long j3 = -9223372036854775807L;
            while (ew4.a() >= 4) {
                if (C12653ey5.k(ew4.e(), ew4.f()) != 442) {
                    ew4.T(1);
                } else {
                    ew4.T(4);
                    long jL = C13289fy5.l(ew4);
                    if (jL != -9223372036854775807L) {
                        long jB = this.a.b(jL);
                        if (jB > j) {
                            return j3 == -9223372036854775807L ? AbstractC7076Qe0.e.d(jB, j2) : AbstractC7076Qe0.e.e(j2 + iF2);
                        }
                        if (100000 + jB > j) {
                            return AbstractC7076Qe0.e.e(j2 + ew4.f());
                        }
                        iF2 = ew4.f();
                        j3 = jB;
                    }
                    d(ew4);
                    iF = ew4.f();
                }
            }
            return j3 != -9223372036854775807L ? AbstractC7076Qe0.e.f(j3, j2 + iF) : AbstractC7076Qe0.e.d;
        }

        private static void d(EW4 ew4) {
            int iK;
            int iG = ew4.g();
            if (ew4.a() < 10) {
                ew4.S(iG);
                return;
            }
            ew4.T(9);
            int iF = ew4.F() & 7;
            if (ew4.a() < iF) {
                ew4.S(iG);
                return;
            }
            ew4.T(iF);
            if (ew4.a() < 4) {
                ew4.S(iG);
                return;
            }
            if (C12653ey5.k(ew4.e(), ew4.f()) == 443) {
                ew4.T(4);
                int iL = ew4.L();
                if (ew4.a() < iL) {
                    ew4.S(iG);
                    return;
                }
                ew4.T(iL);
            }
            while (ew4.a() >= 4 && (iK = C12653ey5.k(ew4.e(), ew4.f())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                ew4.T(4);
                if (ew4.a() < 2) {
                    ew4.S(iG);
                    return;
                }
                ew4.S(Math.min(ew4.g(), ew4.f() + ew4.L()));
            }
        }

        @Override // ir.nasim.AbstractC7076Qe0.f
        public AbstractC7076Qe0.e a(InterfaceC9845af2 interfaceC9845af2, long j) {
            long position = interfaceC9845af2.getPosition();
            int iMin = (int) Math.min(20000L, interfaceC9845af2.getLength() - position);
            this.b.O(iMin);
            interfaceC9845af2.m(this.b.e(), 0, iMin);
            return c(this.b, j, position);
        }

        @Override // ir.nasim.AbstractC7076Qe0.f
        public void b() {
            this.b.P(AbstractC9683aN7.f);
        }

        private b(C5045Hq7 c5045Hq7) {
            this.a = c5045Hq7;
            this.b = new EW4();
        }
    }

    public C12653ey5(C5045Hq7 c5045Hq7, long j, long j2) {
        super(new AbstractC7076Qe0.b(), new b(c5045Hq7), j, 0L, j + 1, 0L, j2, 188L, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
