package ir.nasim;

import ir.nasim.FX0;

/* renamed from: ir.nasim.Hd1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4922Hd1 {
    public static final a g = new a(null);
    private final AbstractC9775aY0 a;
    private final AbstractC9775aY0 b;
    private final AbstractC9775aY0 c;
    private final AbstractC9775aY0 d;
    private final int e;
    private final float[] f;

    /* renamed from: ir.nasim.Hd1$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] b(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, int i) {
            if (!PN5.e(i, PN5.a.a())) {
                return null;
            }
            long jE = abstractC9775aY0.e();
            FX0.a aVar = FX0.a;
            boolean zE = FX0.e(jE, aVar.b());
            boolean zE2 = FX0.e(abstractC9775aY02.e(), aVar.b());
            if (zE && zE2) {
                return null;
            }
            if (!zE && !zE2) {
                return null;
            }
            if (!zE) {
                abstractC9775aY0 = abstractC9775aY02;
            }
            AbstractC13042fc3.g(abstractC9775aY0, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            C13920h26 c13920h26 = (C13920h26) abstractC9775aY0;
            float[] fArrC = zE ? c13920h26.F().c() : L03.a.c();
            float[] fArrC2 = zE2 ? c13920h26.F().c() : L03.a.c();
            return new float[]{fArrC[0] / fArrC2[0], fArrC[1] / fArrC2[1], fArrC[2] / fArrC2[2]};
        }

        public final C4922Hd1 c(AbstractC9775aY0 abstractC9775aY0) {
            return new C0402a(abstractC9775aY0, PN5.a.c());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }

        /* renamed from: ir.nasim.Hd1$a$a, reason: collision with other inner class name */
        public static final class C0402a extends C4922Hd1 {
            C0402a(AbstractC9775aY0 abstractC9775aY0, int i) {
                super(abstractC9775aY0, abstractC9775aY0, i, null);
            }

            @Override // ir.nasim.C4922Hd1
            public long a(long j) {
                return j;
            }
        }
    }

    /* renamed from: ir.nasim.Hd1$b */
    public static final class b extends C4922Hd1 {
        private final C13920h26 h;
        private final C13920h26 i;
        private final float[] j;

        public /* synthetic */ b(C13920h26 c13920h26, C13920h26 c13920h262, int i, ED1 ed1) {
            this(c13920h26, c13920h262, i);
        }

        private final float[] b(C13920h26 c13920h26, C13920h26 c13920h262, int i) {
            if (AbstractC10395bY0.f(c13920h26.F(), c13920h262.F())) {
                return AbstractC10395bY0.l(c13920h262.y(), c13920h26.E());
            }
            float[] fArrE = c13920h26.E();
            float[] fArrY = c13920h262.y();
            float[] fArrC = c13920h26.F().c();
            float[] fArrC2 = c13920h262.F().c();
            C10767c98 c10767c98F = c13920h26.F();
            L03 l03 = L03.a;
            if (!AbstractC10395bY0.f(c10767c98F, l03.b())) {
                fArrE = AbstractC10395bY0.l(AbstractC10395bY0.e(AbstractC22963w7.b.a().b(), fArrC, l03.f()), c13920h26.E());
            }
            if (!AbstractC10395bY0.f(c13920h262.F(), l03.b())) {
                fArrY = AbstractC10395bY0.k(AbstractC10395bY0.l(AbstractC10395bY0.e(AbstractC22963w7.b.a().b(), fArrC2, l03.f()), c13920h262.E()));
            }
            if (PN5.e(i, PN5.a.a())) {
                fArrE = AbstractC10395bY0.m(new float[]{fArrC[0] / fArrC2[0], fArrC[1] / fArrC2[1], fArrC[2] / fArrC2[2]}, fArrE);
            }
            return AbstractC10395bY0.l(fArrY, fArrE);
        }

        @Override // ir.nasim.C4922Hd1
        public long a(long j) {
            float fV = C24381yX0.v(j);
            float fU = C24381yX0.u(j);
            float fS = C24381yX0.s(j);
            float fR = C24381yX0.r(j);
            float fA = (float) this.h.w().a(fV);
            float fA2 = (float) this.h.w().a(fU);
            float fA3 = (float) this.h.w().a(fS);
            float[] fArr = this.j;
            return DX0.a((float) this.i.A().a((fArr[0] * fA) + (fArr[3] * fA2) + (fArr[6] * fA3)), (float) this.i.A().a((fArr[1] * fA) + (fArr[4] * fA2) + (fArr[7] * fA3)), (float) this.i.A().a((fArr[2] * fA) + (fArr[5] * fA2) + (fArr[8] * fA3)), fR, this.i);
        }

        private b(C13920h26 c13920h26, C13920h26 c13920h262, int i) {
            super(c13920h26, c13920h262, c13920h26, c13920h262, i, null, null);
            this.h = c13920h26;
            this.i = c13920h262;
            this.j = b(c13920h26, c13920h262, i);
        }
    }

    public /* synthetic */ C4922Hd1(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, int i, ED1 ed1) {
        this(abstractC9775aY0, abstractC9775aY02, i);
    }

    public long a(long j) {
        float fV = C24381yX0.v(j);
        float fU = C24381yX0.u(j);
        float fS = C24381yX0.s(j);
        float fR = C24381yX0.r(j);
        long jH = this.c.h(fV, fU, fS);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jH >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jH & 4294967295L));
        float fI = this.c.i(fV, fU, fS);
        float[] fArr = this.f;
        if (fArr != null) {
            fIntBitsToFloat *= fArr[0];
            fIntBitsToFloat2 *= fArr[1];
            fI *= fArr[2];
        }
        float f = fIntBitsToFloat;
        return this.d.j(f, fIntBitsToFloat2, fI, fR, this.b);
    }

    public /* synthetic */ C4922Hd1(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, AbstractC9775aY0 abstractC9775aY03, AbstractC9775aY0 abstractC9775aY04, int i, float[] fArr, ED1 ed1) {
        this(abstractC9775aY0, abstractC9775aY02, abstractC9775aY03, abstractC9775aY04, i, fArr);
    }

    private C4922Hd1(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, AbstractC9775aY0 abstractC9775aY03, AbstractC9775aY0 abstractC9775aY04, int i, float[] fArr) {
        this.a = abstractC9775aY0;
        this.b = abstractC9775aY02;
        this.c = abstractC9775aY03;
        this.d = abstractC9775aY04;
        this.e = i;
        this.f = fArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C4922Hd1(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, int i) {
        long jE = abstractC9775aY0.e();
        FX0.a aVar = FX0.a;
        this(abstractC9775aY0, abstractC9775aY02, FX0.e(jE, aVar.b()) ? AbstractC10395bY0.d(abstractC9775aY0, L03.a.b(), null, 2, null) : abstractC9775aY0, FX0.e(abstractC9775aY02.e(), aVar.b()) ? AbstractC10395bY0.d(abstractC9775aY02, L03.a.b(), null, 2, null) : abstractC9775aY02, i, g.b(abstractC9775aY0, abstractC9775aY02, i), null);
    }
}
