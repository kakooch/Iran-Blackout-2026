package ir.nasim;

import ir.nasim.AbstractC7076Qe0;

/* renamed from: ir.nasim.qw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C19792qw7 extends AbstractC7076Qe0 {

    /* renamed from: ir.nasim.qw7$a */
    private static final class a implements AbstractC7076Qe0.f {
        private final C5045Hq7 a;
        private final EW4 b = new EW4();
        private final int c;
        private final int d;

        public a(int i, C5045Hq7 c5045Hq7, int i2) {
            this.c = i;
            this.a = c5045Hq7;
            this.d = i2;
        }

        private AbstractC7076Qe0.e c(EW4 ew4, long j, long j2) {
            int iA;
            int iA2;
            int iG = ew4.g();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (ew4.a() >= 188 && (iA2 = (iA = AbstractC22864vw7.a(ew4.e(), ew4.f(), iG)) + 188) <= iG) {
                long jC = AbstractC22864vw7.c(ew4, iA, this.c);
                if (jC != -9223372036854775807L) {
                    long jB = this.a.b(jC);
                    if (jB > j) {
                        return j5 == -9223372036854775807L ? AbstractC7076Qe0.e.d(jB, j2) : AbstractC7076Qe0.e.e(j2 + j4);
                    }
                    if (100000 + jB > j) {
                        return AbstractC7076Qe0.e.e(j2 + iA);
                    }
                    j4 = iA;
                    j5 = jB;
                }
                ew4.S(iA2);
                j3 = iA2;
            }
            return j5 != -9223372036854775807L ? AbstractC7076Qe0.e.f(j5, j2 + j3) : AbstractC7076Qe0.e.d;
        }

        @Override // ir.nasim.AbstractC7076Qe0.f
        public AbstractC7076Qe0.e a(InterfaceC9845af2 interfaceC9845af2, long j) {
            long position = interfaceC9845af2.getPosition();
            int iMin = (int) Math.min(this.d, interfaceC9845af2.getLength() - position);
            this.b.O(iMin);
            interfaceC9845af2.m(this.b.e(), 0, iMin);
            return c(this.b, j, position);
        }

        @Override // ir.nasim.AbstractC7076Qe0.f
        public void b() {
            this.b.P(AbstractC9683aN7.f);
        }
    }

    public C19792qw7(C5045Hq7 c5045Hq7, long j, long j2, int i, int i2) {
        super(new AbstractC7076Qe0.b(), new a(i, c5045Hq7, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
