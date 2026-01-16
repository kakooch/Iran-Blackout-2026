package ir.nasim;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: ir.nasim.ew1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class InterpolatorC12631ew1 implements Interpolator {
    public static final InterpolatorC12631ew1 f = new InterpolatorC12631ew1(0.25d, 0.1d, 0.25d, 1.0d);
    public static final InterpolatorC12631ew1 g = new InterpolatorC12631ew1(0.0d, 0.0d, 0.58d, 1.0d);
    public static final InterpolatorC12631ew1 h = new InterpolatorC12631ew1(0.23d, 1.0d, 0.32d, 1.0d);
    public static final InterpolatorC12631ew1 i = new InterpolatorC12631ew1(0.42d, 0.0d, 1.0d, 1.0d);
    public static final InterpolatorC12631ew1 j = new InterpolatorC12631ew1(0.42d, 0.0d, 0.58d, 1.0d);
    public static final InterpolatorC12631ew1 k = new InterpolatorC12631ew1(0.34d, 1.56d, 0.64d, 1.0d);
    public static final Interpolator l = new PathInterpolator(AbstractC20446s15.d("M 0,0 C 0.05, 0, 0.133333, 0.06, 0.166666, 0.4 C 0.208333, 0.82, 0.25, 1, 1, 1"));
    protected PointF a;
    protected PointF b;
    protected PointF c;
    protected PointF d;
    protected PointF e;

    public InterpolatorC12631ew1(PointF pointF, PointF pointF2) {
        this.c = new PointF();
        this.d = new PointF();
        this.e = new PointF();
        float f2 = pointF.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f3 = pointF2.x;
        if (f3 < 0.0f || f3 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.a = pointF;
        this.b = pointF2;
    }

    private float a(float f2) {
        PointF pointF = this.e;
        PointF pointF2 = this.a;
        float f3 = pointF2.x * 3.0f;
        pointF.x = f3;
        PointF pointF3 = this.d;
        float f4 = ((this.b.x - pointF2.x) * 3.0f) - f3;
        pointF3.x = f4;
        PointF pointF4 = this.c;
        float f5 = (1.0f - pointF.x) - f4;
        pointF4.x = f5;
        return f2 * (pointF.x + ((pointF3.x + (f5 * f2)) * f2));
    }

    private float c(float f2) {
        return this.e.x + (f2 * ((this.d.x * 2.0f) + (this.c.x * 3.0f * f2)));
    }

    protected float b(float f2) {
        PointF pointF = this.e;
        PointF pointF2 = this.a;
        float f3 = pointF2.y * 3.0f;
        pointF.y = f3;
        PointF pointF3 = this.d;
        float f4 = ((this.b.y - pointF2.y) * 3.0f) - f3;
        pointF3.y = f4;
        PointF pointF4 = this.c;
        float f5 = (1.0f - pointF.y) - f4;
        pointF4.y = f5;
        return f2 * (pointF.y + ((pointF3.y + (f5 * f2)) * f2));
    }

    protected float d(float f2) {
        float fC = f2;
        for (int i2 = 1; i2 < 14; i2++) {
            float fA = a(fC) - f2;
            if (Math.abs(fA) < 0.001d) {
                break;
            }
            fC -= fA / c(fC);
        }
        return fC;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        return b(d(f2));
    }

    public InterpolatorC12631ew1(float f2, float f3, float f4, float f5) {
        this(new PointF(f2, f3), new PointF(f4, f5));
    }

    public InterpolatorC12631ew1(double d, double d2, double d3, double d4) {
        this((float) d, (float) d2, (float) d3, (float) d4);
    }
}
