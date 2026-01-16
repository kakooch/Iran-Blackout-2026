package ir.nasim;

/* loaded from: classes2.dex */
public abstract class DX0 {
    /* JADX WARN: Removed duplicated region for block: B:112:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long a(float r20, float r21, float r22, float r23, ir.nasim.AbstractC9775aY0 r24) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DX0.a(float, float, float, float, ir.nasim.aY0):long");
    }

    public static final long b(int i) {
        return C24381yX0.l(C14599iA7.h(C14599iA7.h(i) << 32));
    }

    public static final long c(int i, int i2, int i3, int i4) {
        return b(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    public static final long d(long j) {
        return C24381yX0.l(C14599iA7.h(j << 32));
    }

    public static /* synthetic */ long e(float f, float f2, float f3, float f4, AbstractC9775aY0 abstractC9775aY0, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            abstractC9775aY0 = LY0.a.G();
        }
        return a(f, f2, f3, f4, abstractC9775aY0);
    }

    public static /* synthetic */ long f(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return c(i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long g(float r17, float r18, float r19, float r20, ir.nasim.AbstractC9775aY0 r21) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DX0.g(float, float, float, float, ir.nasim.aY0):long");
    }

    public static final long h(long j, long j2) {
        long jM = C24381yX0.m(j, C24381yX0.t(j2));
        float fR = C24381yX0.r(j2);
        float fR2 = C24381yX0.r(jM);
        float f = 1.0f - fR2;
        float f2 = (fR * f) + fR2;
        return g(f2 == 0.0f ? 0.0f : ((C24381yX0.v(jM) * fR2) + ((C24381yX0.v(j2) * fR) * f)) / f2, f2 == 0.0f ? 0.0f : ((C24381yX0.u(jM) * fR2) + ((C24381yX0.u(j2) * fR) * f)) / f2, f2 != 0.0f ? ((C24381yX0.s(jM) * fR2) + ((C24381yX0.s(j2) * fR) * f)) / f2 : 0.0f, f2, C24381yX0.t(j2));
    }

    public static final long i(long j, long j2, float f) {
        AbstractC9775aY0 abstractC9775aY0D = LY0.a.D();
        long jM = C24381yX0.m(j, abstractC9775aY0D);
        long jM2 = C24381yX0.m(j2, abstractC9775aY0D);
        float fR = C24381yX0.r(jM);
        float fV = C24381yX0.v(jM);
        float fU = C24381yX0.u(jM);
        float fS = C24381yX0.s(jM);
        float fR2 = C24381yX0.r(jM2);
        float fV2 = C24381yX0.v(jM2);
        float fU2 = C24381yX0.u(jM2);
        float fS2 = C24381yX0.s(jM2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return C24381yX0.m(g(AbstractC18932pV3.b(fV, fV2, f), AbstractC18932pV3.b(fU, fU2, f), AbstractC18932pV3.b(fS, fS2, f), AbstractC18932pV3.b(fR, fR2, f), abstractC9775aY0D), C24381yX0.t(j2));
    }

    public static final float j(long j) {
        AbstractC9775aY0 abstractC9775aY0T = C24381yX0.t(j);
        if (!FX0.e(abstractC9775aY0T.e(), FX0.a.b())) {
            L73.a("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) FX0.h(abstractC9775aY0T.e())));
        }
        AbstractC13042fc3.g(abstractC9775aY0T, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        InterfaceC15993kX1 interfaceC15993kX1W = ((C13920h26) abstractC9775aY0T).w();
        float fA = (float) ((interfaceC15993kX1W.a(C24381yX0.v(j)) * 0.2126d) + (interfaceC15993kX1W.a(C24381yX0.u(j)) * 0.7152d) + (interfaceC15993kX1W.a(C24381yX0.s(j)) * 0.0722d));
        if (fA < 0.0f) {
            fA = 0.0f;
        }
        if (fA > 1.0f) {
            return 1.0f;
        }
        return fA;
    }

    public static final int k(long j) {
        return (int) C14599iA7.h(C24381yX0.m(j, LY0.a.G()) >>> 32);
    }
}
