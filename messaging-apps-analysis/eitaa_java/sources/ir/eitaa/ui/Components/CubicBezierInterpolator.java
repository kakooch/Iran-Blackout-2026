package ir.eitaa.ui.Components;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
public class CubicBezierInterpolator implements Interpolator {
    protected PointF a;
    protected PointF b;
    protected PointF c;
    protected PointF end;
    protected PointF start;
    public static final CubicBezierInterpolator DEFAULT = new CubicBezierInterpolator(0.25d, 0.1d, 0.25d, 1.0d);
    public static final CubicBezierInterpolator EASE_OUT = new CubicBezierInterpolator(0.0d, 0.0d, 0.58d, 1.0d);
    public static final CubicBezierInterpolator EASE_OUT_QUINT = new CubicBezierInterpolator(0.23d, 1.0d, 0.32d, 1.0d);
    public static final CubicBezierInterpolator EASE_IN = new CubicBezierInterpolator(0.42d, 0.0d, 1.0d, 1.0d);
    public static final CubicBezierInterpolator EASE_BOTH = new CubicBezierInterpolator(0.42d, 0.0d, 0.58d, 1.0d);

    public CubicBezierInterpolator(PointF start, PointF end) throws IllegalArgumentException {
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        float f = start.x;
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        float f2 = end.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.start = start;
        this.end = end;
    }

    public CubicBezierInterpolator(float startX, float startY, float endX, float endY) {
        this(new PointF(startX, startY), new PointF(endX, endY));
    }

    public CubicBezierInterpolator(double startX, double startY, double endX, double endY) {
        this((float) startX, (float) startY, (float) endX, (float) endY);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float time) {
        return getBezierCoordinateY(getXForTime(time));
    }

    protected float getBezierCoordinateY(float time) {
        PointF pointF = this.c;
        PointF pointF2 = this.start;
        float f = pointF2.y * 3.0f;
        pointF.y = f;
        PointF pointF3 = this.b;
        float f2 = ((this.end.y - pointF2.y) * 3.0f) - f;
        pointF3.y = f2;
        PointF pointF4 = this.a;
        float f3 = (1.0f - pointF.y) - f2;
        pointF4.y = f3;
        return time * (pointF.y + ((pointF3.y + (f3 * time)) * time));
    }

    protected float getXForTime(float time) {
        float xDerivate = time;
        for (int i = 1; i < 14; i++) {
            float bezierCoordinateX = getBezierCoordinateX(xDerivate) - time;
            if (Math.abs(bezierCoordinateX) < 0.001d) {
                break;
            }
            xDerivate -= bezierCoordinateX / getXDerivate(xDerivate);
        }
        return xDerivate;
    }

    private float getXDerivate(float t) {
        return this.c.x + (t * ((this.b.x * 2.0f) + (this.a.x * 3.0f * t)));
    }

    private float getBezierCoordinateX(float time) {
        PointF pointF = this.c;
        PointF pointF2 = this.start;
        float f = pointF2.x * 3.0f;
        pointF.x = f;
        PointF pointF3 = this.b;
        float f2 = ((this.end.x - pointF2.x) * 3.0f) - f;
        pointF3.x = f2;
        PointF pointF4 = this.a;
        float f3 = (1.0f - pointF.x) - f2;
        pointF4.x = f3;
        return time * (pointF.x + ((pointF3.x + (f3 * time)) * time));
    }
}
