package ir.nasim;

import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class MK4 implements BI5 {
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.nasim.X06 c(ir.nasim.C6338Ne0 r22, java.util.Map r23) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.MK4.c(ir.nasim.Ne0, java.util.Map):ir.nasim.X06");
    }

    protected static float d(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    protected static void e(C3988Df0 c3988Df0, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iN = c3988Df0.n();
        if (i >= iN) {
            throw NotFoundException.a();
        }
        boolean z = !c3988Df0.i(i);
        while (i < iN) {
            if (c3988Df0.i(i) == z) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != iN) {
                throw NotFoundException.a();
            }
        }
    }

    protected static void f(C3988Df0 c3988Df0, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zI = c3988Df0.i(i);
        while (i > 0 && length >= 0) {
            i--;
            if (c3988Df0.i(i) != zI) {
                length--;
                zI = !zI;
            }
        }
        if (length >= 0) {
            throw NotFoundException.a();
        }
        e(c3988Df0, i + 1, iArr);
    }

    @Override // ir.nasim.BI5
    public X06 a(C6338Ne0 c6338Ne0, Map map) throws NotFoundException {
        try {
            return c(c6338Ne0, map);
        } catch (NotFoundException e) {
            if (map == null || !map.containsKey(EnumC19932rB1.TRY_HARDER) || !c6338Ne0.e()) {
                throw e;
            }
            C6338Ne0 c6338Ne0F = c6338Ne0.f();
            X06 x06C = c(c6338Ne0F, map);
            Map mapD = x06C.d();
            int iIntValue = 270;
            if (mapD != null) {
                EnumC11449d16 enumC11449d16 = EnumC11449d16.ORIENTATION;
                if (mapD.containsKey(enumC11449d16)) {
                    iIntValue = (((Integer) mapD.get(enumC11449d16)).intValue() + 270) % 360;
                }
            }
            x06C.h(EnumC11449d16.ORIENTATION, Integer.valueOf(iIntValue));
            C12092e16[] c12092e16ArrE = x06C.e();
            if (c12092e16ArrE != null) {
                int iC = c6338Ne0F.c();
                for (int i = 0; i < c12092e16ArrE.length; i++) {
                    c12092e16ArrE[i] = new C12092e16((iC - c12092e16ArrE[i].d()) - 1.0f, c12092e16ArrE[i].c());
                }
            }
            return x06C;
        }
    }

    public abstract X06 b(int i, C3988Df0 c3988Df0, Map map);

    @Override // ir.nasim.BI5
    public void reset() {
    }
}
