package ir.nasim;

import com.google.zxing.NotFoundException;

/* loaded from: classes3.dex */
public final class YD1 extends AbstractC12277eL2 {
    @Override // ir.nasim.AbstractC12277eL2
    public C4705Gf0 c(C4705Gf0 c4705Gf0, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return d(c4705Gf0, i, i2, J65.b(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // ir.nasim.AbstractC12277eL2
    public C4705Gf0 d(C4705Gf0 c4705Gf0, int i, int i2, J65 j65) throws NotFoundException {
        if (i <= 0 || i2 <= 0) {
            throw NotFoundException.a();
        }
        C4705Gf0 c4705Gf02 = new C4705Gf0(i, i2);
        int i3 = i * 2;
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            float f = i4 + 0.5f;
            for (int i5 = 0; i5 < i3; i5 += 2) {
                fArr[i5] = (i5 / 2) + 0.5f;
                fArr[i5 + 1] = f;
            }
            j65.f(fArr);
            AbstractC12277eL2.a(c4705Gf0, fArr);
            for (int i6 = 0; i6 < i3; i6 += 2) {
                try {
                    if (c4705Gf0.e((int) fArr[i6], (int) fArr[i6 + 1])) {
                        c4705Gf02.o(i6 / 2, i4);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.a();
                }
            }
        }
        return c4705Gf02;
    }
}
