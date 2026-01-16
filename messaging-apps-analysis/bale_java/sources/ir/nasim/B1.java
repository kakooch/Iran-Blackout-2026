package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.NotFoundException;

/* loaded from: classes3.dex */
public abstract class B1 extends MK4 {
    private final int[] b;
    private final int[] e;
    private final int[] f;
    private final int[] a = new int[4];
    private final float[] c = new float[4];
    private final float[] d = new float[4];

    protected B1() {
        int[] iArr = new int[8];
        this.b = iArr;
        this.e = new int[iArr.length / 2];
        this.f = new int[iArr.length / 2];
    }

    protected static void g(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 < f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static void n(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 > f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static boolean o(int[] iArr) {
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i = Integer.MAX_VALUE;
            int i2 = RecyclerView.UNDEFINED_DURATION;
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
                if (i3 < i) {
                    i = i3;
                }
            }
            if (i2 < i * 10) {
                return true;
            }
        }
        return false;
    }

    protected static int p(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (MK4.d(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.a();
    }

    protected final int[] h() {
        return this.b;
    }

    protected final int[] i() {
        return this.a;
    }

    protected final int[] j() {
        return this.f;
    }

    protected final float[] k() {
        return this.d;
    }

    protected final int[] l() {
        return this.e;
    }

    protected final float[] m() {
        return this.c;
    }
}
