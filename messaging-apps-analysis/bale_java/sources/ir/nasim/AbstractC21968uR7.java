package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.uR7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21968uR7 {
    private static boolean a = true;
    private static boolean b;

    public static final void c(C20082rR7 c20082rR7, C6616Og5 c6616Og5) {
        if (a) {
            e(c20082rR7, c6616Og5);
        } else {
            d(c20082rR7, c6616Og5);
        }
    }

    private static final void d(C20082rR7 c20082rR7, C6616Og5 c6616Og5) {
        if (AbstractC3768Cg5.b(c6616Og5)) {
            c20082rR7.f(c6616Og5.h());
            c20082rR7.e();
        }
        long jK = c6616Og5.k();
        List listE = c6616Og5.e();
        int size = listE.size();
        int i = 0;
        while (i < size) {
            C17185mY2 c17185mY2 = (C17185mY2) listE.get(i);
            long jP = ZG4.p(c17185mY2.b(), jK);
            long jB = c17185mY2.b();
            c20082rR7.f(ZG4.q(c20082rR7.c(), jP));
            c20082rR7.a(c17185mY2.c(), c20082rR7.c());
            i++;
            jK = jB;
        }
        c20082rR7.f(ZG4.q(c20082rR7.c(), ZG4.p(c6616Og5.h(), jK)));
        c20082rR7.a(c6616Og5.o(), c20082rR7.c());
    }

    private static final void e(C20082rR7 c20082rR7, C6616Og5 c6616Og5) {
        if (AbstractC3768Cg5.b(c6616Og5)) {
            c20082rR7.e();
        }
        if (!AbstractC3768Cg5.d(c6616Og5)) {
            List listE = c6616Og5.e();
            int size = listE.size();
            for (int i = 0; i < size; i++) {
                C17185mY2 c17185mY2 = (C17185mY2) listE.get(i);
                c20082rR7.a(c17185mY2.c(), c17185mY2.a());
            }
            c20082rR7.a(c6616Og5.o(), c6616Og5.g());
        }
        if (AbstractC3768Cg5.d(c6616Og5) && c6616Og5.o() - c20082rR7.d() > 40) {
            c20082rR7.e();
        }
        c20082rR7.g(c6616Og5.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(float[] fArr, float[] fArr2, int i, boolean z) {
        int i2 = i - 1;
        float f = fArr2[i2];
        float fSignum = 0.0f;
        int i3 = i2;
        while (i3 > 0) {
            int i4 = i3 - 1;
            float f2 = fArr2[i4];
            if (f != f2) {
                float f3 = (z ? -fArr[i4] : fArr[i3] - fArr[i4]) / (f - f2);
                fSignum += (f3 - (Math.signum(fSignum) * ((float) Math.sqrt(2 * Math.abs(fSignum))))) * Math.abs(f3);
                if (i3 == i2) {
                    fSignum *= 0.5f;
                }
            }
            i3--;
            f = f2;
        }
        return Math.signum(fSignum) * ((float) Math.sqrt(2 * Math.abs(fSignum)));
    }

    private static final float g(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i] * fArr2[i];
        }
        return f;
    }

    public static final boolean h() {
        return b;
    }

    public static final float[] i(float[] fArr, float[] fArr2, int i, int i2, float[] fArr3) {
        int i3 = i2;
        if (i3 < 1) {
            M73.a("The degree must be at positive integer");
        }
        if (i == 0) {
            M73.a("At least one point must be provided");
        }
        if (i3 >= i) {
            i3 = i - 1;
        }
        int i4 = i3 + 1;
        float[][] fArr4 = new float[i4][];
        for (int i5 = 0; i5 < i4; i5++) {
            fArr4[i5] = new float[i];
        }
        for (int i6 = 0; i6 < i; i6++) {
            fArr4[0][i6] = 1.0f;
            for (int i7 = 1; i7 < i4; i7++) {
                fArr4[i7][i6] = fArr4[i7 - 1][i6] * fArr[i6];
            }
        }
        float[][] fArr5 = new float[i4][];
        for (int i8 = 0; i8 < i4; i8++) {
            fArr5[i8] = new float[i];
        }
        float[][] fArr6 = new float[i4][];
        for (int i9 = 0; i9 < i4; i9++) {
            fArr6[i9] = new float[i4];
        }
        int i10 = 0;
        while (i10 < i4) {
            float[] fArr7 = fArr5[i10];
            AbstractC9648aK.i(fArr4[i10], fArr7, 0, 0, i);
            for (int i11 = 0; i11 < i10; i11++) {
                float[] fArr8 = fArr5[i11];
                float fG = g(fArr7, fArr8);
                for (int i12 = 0; i12 < i; i12++) {
                    fArr7[i12] = fArr7[i12] - (fArr8[i12] * fG);
                }
            }
            float fSqrt = (float) Math.sqrt(g(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f = 1.0f / fSqrt;
            for (int i13 = 0; i13 < i; i13++) {
                fArr7[i13] = fArr7[i13] * f;
            }
            float[] fArr9 = fArr6[i10];
            int i14 = 0;
            while (i14 < i4) {
                fArr9[i14] = i14 < i10 ? 0.0f : g(fArr7, fArr4[i14]);
                i14++;
            }
            i10++;
        }
        for (int i15 = i3; -1 < i15; i15--) {
            float fG2 = g(fArr5[i15], fArr2);
            float[] fArr10 = fArr6[i15];
            int i16 = i15 + 1;
            if (i16 <= i3) {
                int i17 = i3;
                while (true) {
                    fG2 -= fArr10[i17] * fArr3[i17];
                    if (i17 != i16) {
                        i17--;
                    }
                }
            }
            fArr3[i15] = fG2 / fArr10[i15];
        }
        return fArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(C17449mz1[] c17449mz1Arr, int i, long j, float f) {
        C17449mz1 c17449mz1 = c17449mz1Arr[i];
        if (c17449mz1 == null) {
            c17449mz1Arr[i] = new C17449mz1(j, f);
        } else {
            c17449mz1.d(j);
            c17449mz1.c(f);
        }
    }
}
