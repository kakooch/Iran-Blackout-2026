package ir.nasim;

import android.view.animation.Interpolator;

/* loaded from: classes2.dex */
public class ZU3 implements Interpolator {
    private static final ZU3 a = new ZU3();

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double d = f;
        return (float) (((Math.pow(d, 2.0d) * 6.0d) - (Math.pow(d, 3.0d) * 8.0d)) + (Math.pow(d, 4.0d) * 3.0d));
    }
}
