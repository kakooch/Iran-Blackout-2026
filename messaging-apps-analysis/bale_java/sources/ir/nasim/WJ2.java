package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class WJ2 {
    private final float[] a;
    private final int[] b;

    public WJ2(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    private void a(WJ2 wj2) {
        int i = 0;
        while (true) {
            int[] iArr = wj2.b;
            if (i >= iArr.length) {
                return;
            }
            this.a[i] = wj2.a[i];
            this.b[i] = iArr[i];
            i++;
        }
    }

    private int c(float f) {
        int iBinarySearch = Arrays.binarySearch(this.a, f);
        if (iBinarySearch >= 0) {
            return this.b[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.b[0];
        }
        int[] iArr = this.b;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.a;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return AD2.c((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }

    public WJ2 b(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = c(fArr[i]);
        }
        return new WJ2(fArr, iArr);
    }

    public int[] d() {
        return this.b;
    }

    public float[] e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WJ2 wj2 = (WJ2) obj;
        return Arrays.equals(this.a, wj2.a) && Arrays.equals(this.b, wj2.b);
    }

    public int f() {
        return this.b.length;
    }

    public void g(WJ2 wj2, WJ2 wj22, float f) {
        int[] iArr;
        if (wj2.equals(wj22)) {
            a(wj2);
            return;
        }
        if (f <= 0.0f) {
            a(wj2);
            return;
        }
        if (f >= 1.0f) {
            a(wj22);
            return;
        }
        if (wj2.b.length != wj22.b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + wj2.b.length + " vs " + wj22.b.length + Separators.RPAREN);
        }
        int i = 0;
        while (true) {
            iArr = wj2.b;
            if (i >= iArr.length) {
                break;
            }
            this.a[i] = AbstractC7323Rf4.i(wj2.a[i], wj22.a[i], f);
            this.b[i] = AD2.c(f, wj2.b[i], wj22.b[i]);
            i++;
        }
        int length = iArr.length;
        while (true) {
            float[] fArr = this.a;
            if (length >= fArr.length) {
                return;
            }
            int[] iArr2 = wj2.b;
            fArr[length] = fArr[iArr2.length - 1];
            int[] iArr3 = this.b;
            iArr3[length] = iArr3[iArr2.length - 1];
            length++;
        }
    }

    public int hashCode() {
        return (Arrays.hashCode(this.a) * 31) + Arrays.hashCode(this.b);
    }
}
