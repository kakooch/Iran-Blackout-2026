package ir.appp.rghapp.rubinoPostSlider;

import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
public class RubinoLikeInterpolator implements Interpolator {
    public float f = 2.6f;
    public float d = -28.0f;
    public float b = 100.0f;
    public float w = 0.029f;
    public float A = -40.0f;
    public float p = 400.0f;
    public float a = 0.015f;

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return getBezierCoordinateY(f * 100.0f) / 100.0f;
    }

    protected float getBezierCoordinateY(float f) {
        double d = this.A;
        double dExp = Math.exp((-this.a) * ((this.f * f) + this.d));
        Double.isNaN(d);
        double dCos = d * dExp * Math.cos(this.w * (((f * this.f) + this.d) - this.p));
        double d2 = this.b;
        Double.isNaN(d2);
        return (float) (dCos + d2);
    }
}
