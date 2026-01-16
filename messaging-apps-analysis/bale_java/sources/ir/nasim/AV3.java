package ir.nasim;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AV3 {
    public static final a b = new a(null);
    private final float[] a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ AV3(float[] fArr) {
        this.a = fArr;
    }

    public static final /* synthetic */ AV3 a(float[] fArr) {
        return new AV3(fArr);
    }

    public static /* synthetic */ float[] c(float[] fArr, int i, ED1 ed1) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return b(fArr);
    }

    public static boolean d(float[] fArr, Object obj) {
        return (obj instanceof AV3) && AbstractC13042fc3.d(fArr, ((AV3) obj).p());
    }

    public static int e(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public static final long f(float[] fArr, long j) {
        if (fArr.length < 16) {
            return j;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[3];
        float f4 = fArr[4];
        float f5 = fArr[5];
        float f6 = fArr[7];
        float f7 = fArr[12];
        float f8 = fArr[13];
        float f9 = fArr[15];
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float f10 = 1 / (((f3 * fIntBitsToFloat) + (f6 * fIntBitsToFloat2)) + f9);
        if ((Float.floatToRawIntBits(f10) & Integer.MAX_VALUE) >= 2139095040) {
            f10 = 0.0f;
        }
        float f11 = ((f * fIntBitsToFloat) + (f4 * fIntBitsToFloat2) + f7) * f10;
        float f12 = f10 * ((f2 * fIntBitsToFloat) + (f5 * fIntBitsToFloat2) + f8);
        return ZG4.e((Float.floatToRawIntBits(f11) << 32) | (Float.floatToRawIntBits(f12) & 4294967295L));
    }

    public static final void g(float[] fArr, C6908Pm4 c6908Pm4) {
        if (fArr.length < 16) {
            return;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[3];
        float f4 = fArr[4];
        float f5 = fArr[5];
        float f6 = fArr[7];
        float f7 = fArr[12];
        float f8 = fArr[13];
        float f9 = fArr[15];
        float fB = c6908Pm4.b();
        float fD = c6908Pm4.d();
        float fC = c6908Pm4.c();
        float fA = c6908Pm4.a();
        float f10 = f3 * fB;
        float f11 = f6 * fD;
        float f12 = 1.0f / ((f10 + f11) + f9);
        if ((Float.floatToRawIntBits(f12) & Integer.MAX_VALUE) >= 2139095040) {
            f12 = 0.0f;
        }
        float f13 = f * fB;
        float f14 = f4 * fD;
        float f15 = f12 * (f13 + f14 + f7);
        float f16 = fB * f2;
        float f17 = fD * f5;
        float f18 = f12 * (f16 + f17 + f8);
        float f19 = f6 * fA;
        float f20 = 1.0f / ((f10 + f19) + f9);
        float f21 = (Float.floatToRawIntBits(f20) & Integer.MAX_VALUE) < 2139095040 ? f20 : 0.0f;
        float f22 = f4 * fA;
        float f23 = (f13 + f22 + f7) * f21;
        float f24 = f5 * fA;
        float f25 = f21 * (f16 + f24 + f8);
        float f26 = f3 * fC;
        float f27 = 1.0f / ((f26 + f11) + f9);
        if ((Float.floatToRawIntBits(f27) & Integer.MAX_VALUE) >= 2139095040) {
            f27 = 0.0f;
        }
        float f28 = f * fC;
        float f29 = f27 * (f28 + f14 + f7);
        float f30 = f2 * fC;
        float f31 = f27 * (f17 + f30 + f8);
        float f32 = 1.0f / ((f26 + f19) + f9);
        float f33 = (Float.floatToRawIntBits(f32) & Integer.MAX_VALUE) < 2139095040 ? f32 : 0.0f;
        float f34 = (f28 + f22 + f7) * f33;
        float f35 = f33 * (f30 + f24 + f8);
        c6908Pm4.i(Math.min(f15, Math.min(f23, Math.min(f29, f34))));
        c6908Pm4.k(Math.min(f18, Math.min(f25, Math.min(f31, f35))));
        c6908Pm4.j(Math.max(f15, Math.max(f23, Math.max(f29, f34))));
        c6908Pm4.h(Math.max(f18, Math.max(f25, Math.max(f31, f35))));
    }

    public static final void h(float[] fArr) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    public static final void i(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        double d = f6 * 0.017453292519943295d;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        float f12 = -fSin;
        float f13 = (f4 * fCos) - (f5 * fSin);
        float f14 = (f4 * fSin) + (f5 * fCos);
        double d2 = f7 * 0.017453292519943295d;
        float fSin2 = (float) Math.sin(d2);
        float fCos2 = (float) Math.cos(d2);
        float f15 = -fSin2;
        float f16 = fSin * fSin2;
        float f17 = fSin * fCos2;
        float f18 = fCos * fSin2;
        float f19 = fCos * fCos2;
        float f20 = (f3 * fCos2) + (f14 * fSin2);
        float f21 = ((-f3) * fSin2) + (f14 * fCos2);
        double d3 = f8 * 0.017453292519943295d;
        float fSin3 = (float) Math.sin(d3);
        float fCos3 = (float) Math.cos(d3);
        float f22 = -fSin3;
        float f23 = (f22 * fCos2) + (fCos3 * f16);
        float f24 = fSin3 * fCos;
        float f25 = fCos * fCos3;
        float f26 = (f22 * f15) + (fCos3 * f17);
        float f27 = ((fCos2 * fCos3) + (f16 * fSin3)) * f9;
        float f28 = f24 * f9;
        float f29 = ((fCos3 * f15) + (fSin3 * f17)) * f9;
        float f30 = f23 * f10;
        float f31 = f25 * f10;
        float f32 = f26 * f10;
        float f33 = f18 * f11;
        float f34 = f12 * f11;
        float f35 = f19 * f11;
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = f27;
        fArr[1] = f28;
        fArr[2] = f29;
        fArr[3] = 0.0f;
        fArr[4] = f30;
        fArr[5] = f31;
        fArr[6] = f32;
        fArr[7] = 0.0f;
        fArr[8] = f33;
        fArr[9] = f34;
        fArr[10] = f35;
        fArr[11] = 0.0f;
        float f36 = -f;
        fArr[12] = ((f27 * f36) - (f2 * f30)) + f20 + f;
        fArr[13] = ((f28 * f36) - (f2 * f31)) + f13 + f2;
        fArr[14] = ((f36 * f29) - (f2 * f32)) + f21;
        fArr[15] = 1.0f;
    }

    public static final void j(float[] fArr, float f) {
        if (fArr.length < 16) {
            return;
        }
        double d = f * 0.017453292519943295d;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = -fSin;
        float f5 = fArr[1];
        float f6 = fArr[5];
        float f7 = fArr[2];
        float f8 = fArr[6];
        float f9 = fArr[3];
        float f10 = fArr[7];
        fArr[0] = (fCos * f2) + (fSin * f3);
        fArr[1] = (fCos * f5) + (fSin * f6);
        fArr[2] = (fCos * f7) + (fSin * f8);
        fArr[3] = (fCos * f9) + (fSin * f10);
        fArr[4] = (f2 * f4) + (f3 * fCos);
        fArr[5] = (f5 * f4) + (f6 * fCos);
        fArr[6] = (f7 * f4) + (f8 * fCos);
        fArr[7] = (f4 * f9) + (fCos * f10);
    }

    public static final void k(float[] fArr, float f, float f2, float f3) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
        fArr[4] = fArr[4] * f2;
        fArr[5] = fArr[5] * f2;
        fArr[6] = fArr[6] * f2;
        fArr[7] = fArr[7] * f2;
        fArr[8] = fArr[8] * f3;
        fArr[9] = fArr[9] * f3;
        fArr[10] = fArr[10] * f3;
        fArr[11] = fArr[11] * f3;
    }

    public static final void l(float[] fArr, float[] fArr2) {
        if (fArr.length >= 16 && fArr2.length >= 16) {
            float f = fArr[0];
            float f2 = fArr2[0];
            float f3 = fArr[1];
            float f4 = fArr2[4];
            float f5 = fArr[2];
            float f6 = fArr2[8];
            float f7 = fArr[3];
            float f8 = fArr2[12];
            float f9 = (f * f2) + (f3 * f4) + (f5 * f6) + (f7 * f8);
            float f10 = fArr2[1];
            float f11 = fArr2[5];
            float f12 = fArr2[9];
            float f13 = fArr2[13];
            float f14 = (f * f10) + (f3 * f11) + (f5 * f12) + (f7 * f13);
            float f15 = fArr2[2];
            float f16 = fArr2[6];
            float f17 = fArr2[10];
            float f18 = fArr2[14];
            float f19 = (f * f15) + (f3 * f16) + (f5 * f17) + (f7 * f18);
            float f20 = fArr2[3];
            float f21 = fArr2[7];
            float f22 = fArr2[11];
            float f23 = fArr2[15];
            float f24 = (f * f20) + (f3 * f21) + (f5 * f22) + (f7 * f23);
            float f25 = fArr[4];
            float f26 = fArr[5];
            float f27 = fArr[6];
            float f28 = fArr[7];
            float f29 = (f25 * f2) + (f26 * f4) + (f27 * f6) + (f28 * f8);
            float f30 = (f25 * f10) + (f26 * f11) + (f27 * f12) + (f28 * f13);
            float f31 = (f25 * f15) + (f26 * f16) + (f27 * f17) + (f28 * f18);
            float f32 = (f25 * f20) + (f26 * f21) + (f27 * f22) + (f28 * f23);
            float f33 = fArr[8];
            float f34 = fArr[9];
            float f35 = fArr[10];
            float f36 = fArr[11];
            float f37 = (f33 * f2) + (f34 * f4) + (f35 * f6) + (f36 * f8);
            float f38 = (f33 * f10) + (f34 * f11) + (f35 * f12) + (f36 * f13);
            float f39 = (f33 * f15) + (f34 * f16) + (f35 * f17) + (f36 * f18);
            float f40 = (f33 * f20) + (f34 * f21) + (f35 * f22) + (f36 * f23);
            float f41 = fArr[12];
            float f42 = fArr[13];
            float f43 = (f2 * f41) + (f4 * f42);
            float f44 = fArr[14];
            float f45 = f43 + (f6 * f44);
            float f46 = fArr[15];
            fArr[0] = f9;
            fArr[1] = f14;
            fArr[2] = f19;
            fArr[3] = f24;
            fArr[4] = f29;
            fArr[5] = f30;
            fArr[6] = f31;
            fArr[7] = f32;
            fArr[8] = f37;
            fArr[9] = f38;
            fArr[10] = f39;
            fArr[11] = f40;
            fArr[12] = f45 + (f8 * f46);
            fArr[13] = (f10 * f41) + (f11 * f42) + (f12 * f44) + (f13 * f46);
            fArr[14] = (f15 * f41) + (f16 * f42) + (f17 * f44) + (f18 * f46);
            fArr[15] = (f41 * f20) + (f42 * f21) + (f44 * f22) + (f46 * f23);
        }
    }

    public static String m(float[] fArr) {
        return AbstractC16016kZ6.g("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    public static final void n(float[] fArr, float f, float f2, float f3) {
        if (fArr.length < 16) {
            return;
        }
        float f4 = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        float f5 = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        float f6 = (fArr[2] * f) + (fArr[6] * f2) + (fArr[10] * f3) + fArr[14];
        float f7 = (fArr[3] * f) + (fArr[7] * f2) + (fArr[11] * f3) + fArr[15];
        fArr[12] = f4;
        fArr[13] = f5;
        fArr[14] = f6;
        fArr[15] = f7;
    }

    public static /* synthetic */ void o(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        n(fArr, f, f2, f3);
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return e(this.a);
    }

    public final /* synthetic */ float[] p() {
        return this.a;
    }

    public String toString() {
        return m(this.a);
    }

    public static float[] b(float[] fArr) {
        return fArr;
    }
}
