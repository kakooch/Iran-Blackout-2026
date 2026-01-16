package ir.nasim;

import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Build;
import java.util.List;

/* renamed from: ir.nasim.ar, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9965ar {
    public static final Shader a(long j, long j2, List list, List list2, int i) {
        f(list, list2);
        int iC = c(list);
        return new LinearGradient(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (4294967295L & j2)), d(list, iC), e(list2, list, iC), AbstractC17370mr.a(i));
    }

    public static final Shader b(long j, float f, List list, List list2, int i) {
        f(list, list2);
        int iC = c(list);
        return new RadialGradient(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), f, d(list, iC), e(list2, list, iC), AbstractC17370mr.a(i));
    }

    public static final int c(List list) {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int iO = AbstractC10360bX0.o(list);
        for (int i2 = 1; i2 < iO; i2++) {
            if (C24381yX0.r(((C24381yX0) list.get(i2)).y()) == 0.0f) {
                i++;
            }
        }
        return i;
    }

    public static final int[] d(List list, int i) {
        int i2;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            int[] iArr = new int[size];
            while (i3 < size) {
                iArr[i3] = DX0.k(((C24381yX0) list.get(i3)).y());
                i3++;
            }
            return iArr;
        }
        int[] iArr2 = new int[list.size() + i];
        int iO = AbstractC10360bX0.o(list);
        int size2 = list.size();
        int i4 = 0;
        while (i3 < size2) {
            long jY = ((C24381yX0) list.get(i3)).y();
            if (C24381yX0.r(jY) == 0.0f) {
                if (i3 == 0) {
                    i2 = i4 + 1;
                    iArr2[i4] = DX0.k(C24381yX0.o(((C24381yX0) list.get(1)).y(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else if (i3 == iO) {
                    i2 = i4 + 1;
                    iArr2[i4] = DX0.k(C24381yX0.o(((C24381yX0) list.get(i3 - 1)).y(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else {
                    int i5 = i4 + 1;
                    iArr2[i4] = DX0.k(C24381yX0.o(((C24381yX0) list.get(i3 - 1)).y(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                    i4 += 2;
                    iArr2[i5] = DX0.k(C24381yX0.o(((C24381yX0) list.get(i3 + 1)).y(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                }
                i4 = i2;
            } else {
                iArr2[i4] = DX0.k(jY);
                i4++;
            }
            i3++;
        }
        return iArr2;
    }

    public static final float[] e(List list, List list2, int i) {
        if (i == 0) {
            if (list != null) {
                return AbstractC15401jX0.j1(list);
            }
            return null;
        }
        float[] fArr = new float[list2.size() + i];
        fArr[0] = list != null ? ((Number) list.get(0)).floatValue() : 0.0f;
        int iO = AbstractC10360bX0.o(list2);
        int i2 = 1;
        for (int i3 = 1; i3 < iO; i3++) {
            long jY = ((C24381yX0) list2.get(i3)).y();
            float fFloatValue = list != null ? ((Number) list.get(i3)).floatValue() : i3 / AbstractC10360bX0.o(list2);
            int i4 = i2 + 1;
            fArr[i2] = fFloatValue;
            if (C24381yX0.r(jY) == 0.0f) {
                i2 += 2;
                fArr[i4] = fFloatValue;
            } else {
                i2 = i4;
            }
        }
        fArr[i2] = list != null ? ((Number) list.get(AbstractC10360bX0.o(list2))).floatValue() : 1.0f;
        return fArr;
    }

    private static final void f(List list, List list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
