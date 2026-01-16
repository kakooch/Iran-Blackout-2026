package ir.nasim;

import ir.nasim.C4922Hd1;
import ir.nasim.FX0;

/* renamed from: ir.nasim.bY0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10395bY0 {
    public static final double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.copySign(o(d < 0.0d ? -d : d, d2, d3, d4, d5, d6), d);
    }

    public static final double b(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.copySign(q(d < 0.0d ? -d : d, d2, d3, d4, d5, d6), d);
    }

    public static final AbstractC9775aY0 c(AbstractC9775aY0 abstractC9775aY0, C10767c98 c10767c98, AbstractC22963w7 abstractC22963w7) {
        if (!FX0.e(abstractC9775aY0.e(), FX0.a.b())) {
            return abstractC9775aY0;
        }
        AbstractC13042fc3.g(abstractC9775aY0, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        C13920h26 c13920h26 = (C13920h26) abstractC9775aY0;
        if (f(c13920h26.F(), c10767c98)) {
            return abstractC9775aY0;
        }
        return new C13920h26(c13920h26, l(e(abstractC22963w7.b(), c13920h26.F().c(), c10767c98.c()), c13920h26.E()), c10767c98);
    }

    public static /* synthetic */ AbstractC9775aY0 d(AbstractC9775aY0 abstractC9775aY0, C10767c98 c10767c98, AbstractC22963w7 abstractC22963w7, int i, Object obj) {
        if ((i & 2) != 0) {
            abstractC22963w7 = AbstractC22963w7.b.a();
        }
        return c(abstractC9775aY0, c10767c98, abstractC22963w7);
    }

    public static final float[] e(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArrN = n(fArr, fArr2);
        float[] fArrN2 = n(fArr, fArr3);
        return l(k(fArr), m(new float[]{fArrN2[0] / fArrN[0], fArrN2[1] / fArrN[1], fArrN2[2] / fArrN[2]}, fArr));
    }

    public static final boolean f(C10767c98 c10767c98, C10767c98 c10767c982) {
        if (c10767c98 == c10767c982) {
            return true;
        }
        return Math.abs(c10767c98.a() - c10767c982.a()) < 0.001f && Math.abs(c10767c98.b() - c10767c982.b()) < 0.001f;
    }

    public static final boolean g(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (Float.compare(fArr[i], fArr2[i]) != 0 && Math.abs(fArr[i] - fArr2[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public static final C4922Hd1 h(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, int i) {
        int iB = abstractC9775aY0.b();
        int iB2 = abstractC9775aY02.b();
        if ((iB | iB2) < 0) {
            return j(abstractC9775aY0, abstractC9775aY02, i);
        }
        C16734lm4 c16734lm4A = AbstractC5156Id1.a();
        int i2 = iB | (iB2 << 6) | (i << 12);
        Object objB = c16734lm4A.b(i2);
        if (objB == null) {
            objB = j(abstractC9775aY0, abstractC9775aY02, i);
            c16734lm4A.r(i2, objB);
        }
        return (C4922Hd1) objB;
    }

    public static /* synthetic */ C4922Hd1 i(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            abstractC9775aY02 = LY0.a.G();
        }
        if ((i2 & 2) != 0) {
            i = PN5.a.b();
        }
        return h(abstractC9775aY0, abstractC9775aY02, i);
    }

    private static final C4922Hd1 j(AbstractC9775aY0 abstractC9775aY0, AbstractC9775aY0 abstractC9775aY02, int i) {
        C4922Hd1 c4922Hd1;
        if (abstractC9775aY0 == abstractC9775aY02) {
            return C4922Hd1.g.c(abstractC9775aY0);
        }
        long jE = abstractC9775aY0.e();
        FX0.a aVar = FX0.a;
        ED1 ed1 = null;
        if (FX0.e(jE, aVar.b()) && FX0.e(abstractC9775aY02.e(), aVar.b())) {
            AbstractC13042fc3.g(abstractC9775aY0, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            AbstractC13042fc3.g(abstractC9775aY02, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            c4922Hd1 = new C4922Hd1.b((C13920h26) abstractC9775aY0, (C13920h26) abstractC9775aY02, i, ed1);
        } else {
            c4922Hd1 = new C4922Hd1(abstractC9775aY0, abstractC9775aY02, i, ed1);
        }
        return c4922Hd1;
    }

    public static final float[] k(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[3];
        float f3 = fArr[6];
        float f4 = fArr[1];
        float f5 = fArr[4];
        float f6 = fArr[7];
        float f7 = fArr[2];
        float f8 = fArr[5];
        float f9 = fArr[8];
        float f10 = (f5 * f9) - (f6 * f8);
        float f11 = (f6 * f7) - (f4 * f9);
        float f12 = (f4 * f8) - (f5 * f7);
        float f13 = (f * f10) + (f2 * f11) + (f3 * f12);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f10 / f13;
        fArr2[1] = f11 / f13;
        fArr2[2] = f12 / f13;
        fArr2[3] = ((f3 * f8) - (f2 * f9)) / f13;
        fArr2[4] = ((f9 * f) - (f3 * f7)) / f13;
        fArr2[5] = ((f7 * f2) - (f8 * f)) / f13;
        fArr2[6] = ((f2 * f6) - (f3 * f5)) / f13;
        fArr2[7] = ((f3 * f4) - (f6 * f)) / f13;
        fArr2[8] = ((f * f5) - (f2 * f4)) / f13;
        return fArr2;
    }

    public static final float[] l(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[9];
        if (fArr.length < 9 || fArr2.length < 9) {
            return fArr3;
        }
        float f = fArr[0] * fArr2[0];
        float f2 = fArr[3];
        float f3 = fArr2[1];
        float f4 = fArr[6];
        float f5 = fArr2[2];
        fArr3[0] = f + (f2 * f3) + (f4 * f5);
        float f6 = fArr[1];
        float f7 = fArr2[0];
        float f8 = fArr[4];
        float f9 = fArr[7];
        fArr3[1] = (f6 * f7) + (f3 * f8) + (f9 * f5);
        float f10 = fArr[2] * f7;
        float f11 = fArr[5];
        float f12 = f10 + (fArr2[1] * f11);
        float f13 = fArr[8];
        fArr3[2] = f12 + (f5 * f13);
        float f14 = fArr[0];
        float f15 = fArr2[3] * f14;
        float f16 = fArr2[4];
        float f17 = f15 + (f2 * f16);
        float f18 = fArr2[5];
        fArr3[3] = f17 + (f4 * f18);
        float f19 = fArr[1];
        float f20 = fArr2[3];
        fArr3[4] = (f19 * f20) + (f8 * f16) + (f9 * f18);
        float f21 = fArr[2];
        fArr3[5] = (f20 * f21) + (f11 * fArr2[4]) + (f18 * f13);
        float f22 = f14 * fArr2[6];
        float f23 = fArr[3];
        float f24 = fArr2[7];
        float f25 = f22 + (f23 * f24);
        float f26 = fArr2[8];
        fArr3[6] = f25 + (f4 * f26);
        float f27 = fArr2[6];
        fArr3[7] = (f19 * f27) + (fArr[4] * f24) + (f9 * f26);
        fArr3[8] = (f21 * f27) + (fArr[5] * fArr2[7]) + (f13 * f26);
        return fArr3;
    }

    public static final float[] m(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = fArr2[0] * f;
        float f3 = fArr[1];
        float f4 = fArr2[1] * f3;
        float f5 = fArr[2];
        return new float[]{f2, f4, fArr2[2] * f5, fArr2[3] * f, fArr2[4] * f3, fArr2[5] * f5, f * fArr2[6], f3 * fArr2[7], f5 * fArr2[8]};
    }

    public static final float[] n(float[] fArr, float[] fArr2) {
        if (fArr.length < 9 || fArr2.length < 3) {
            return fArr2;
        }
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        fArr2[0] = (fArr[0] * f) + (fArr[3] * f2) + (fArr[6] * f3);
        fArr2[1] = (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f3);
        fArr2[2] = (fArr[2] * f) + (fArr[5] * f2) + (fArr[8] * f3);
        return fArr2;
    }

    public static final double o(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 * d4 ? (Math.pow(d, 1.0d / d6) - d3) / d2 : d / d4;
    }

    public static final double p(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 * d4 ? (Math.pow(d - d6, 1.0d / d8) - d3) / d2 : (d - d7) / d4;
    }

    public static final double q(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d6) : d * d4;
    }

    public static final double r(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d8) + d6 : (d4 * d) + d7;
    }
}
