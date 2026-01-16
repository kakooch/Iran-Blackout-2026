package ir.nasim;

import android.view.animation.Interpolator;

/* renamed from: ir.nasim.dK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractInterpolatorC11626dK3 implements Interpolator {
    private final float[] a;
    private final float b;

    protected AbstractInterpolatorC11626dK3(float[] fArr) {
        this.a = fArr;
        this.b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.a;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.b;
        float f3 = (f - (iMin * f2)) / f2;
        float[] fArr2 = this.a;
        float f4 = fArr2[iMin];
        return f4 + (f3 * (fArr2[iMin + 1] - f4));
    }
}
