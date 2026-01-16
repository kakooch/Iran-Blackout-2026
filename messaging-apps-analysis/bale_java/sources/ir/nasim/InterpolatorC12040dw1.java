package ir.nasim;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* renamed from: ir.nasim.dw1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class InterpolatorC12040dw1 implements Interpolator {
    public static final a f = new a(null);
    private static final InterpolatorC12040dw1 g = new InterpolatorC12040dw1(0.25d, 0.1d, 0.25d, 1.0d);
    private static final InterpolatorC12040dw1 h = new InterpolatorC12040dw1(0.0d, 0.0d, 0.58d, 1.0d);
    private static final InterpolatorC12040dw1 i = new InterpolatorC12040dw1(0.23d, 1.0d, 0.32d, 1.0d);
    private static final InterpolatorC12040dw1 j = new InterpolatorC12040dw1(0.42d, 0.0d, 1.0d, 1.0d);
    public static final InterpolatorC12040dw1 k = new InterpolatorC12040dw1(0.42d, 0.0d, 0.58d, 1.0d);
    private PointF a;
    private PointF b;
    private PointF c;
    private PointF d;
    private PointF e;

    /* renamed from: ir.nasim.dw1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public InterpolatorC12040dw1(PointF pointF, PointF pointF2) {
        AbstractC13042fc3.i(pointF, "start");
        AbstractC13042fc3.i(pointF2, "end");
        this.c = new PointF();
        this.d = new PointF();
        this.e = new PointF();
        float f2 = pointF.x;
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]".toString());
        }
        float f3 = pointF2.x;
        if (f3 < 0.0f || f3 > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]".toString());
        }
        this.a = pointF;
        this.b = pointF2;
    }

    private final float a(float f2) {
        PointF pointF = this.e;
        float f3 = 3;
        PointF pointF2 = this.a;
        float f4 = pointF2.x * f3;
        pointF.x = f4;
        PointF pointF3 = this.d;
        float f5 = (f3 * (this.b.x - pointF2.x)) - f4;
        pointF3.x = f5;
        PointF pointF4 = this.c;
        float f6 = (1 - pointF.x) - f5;
        pointF4.x = f6;
        return f2 * (pointF.x + ((pointF3.x + (f6 * f2)) * f2));
    }

    private final float b(float f2) {
        PointF pointF = this.e;
        float f3 = 3;
        PointF pointF2 = this.a;
        float f4 = pointF2.y * f3;
        pointF.y = f4;
        PointF pointF3 = this.d;
        float f5 = (f3 * (this.b.y - pointF2.y)) - f4;
        pointF3.y = f5;
        PointF pointF4 = this.c;
        float f6 = (1 - pointF.y) - f5;
        pointF4.y = f6;
        return f2 * (pointF.y + ((pointF3.y + (f6 * f2)) * f2));
    }

    private final float c(float f2) {
        return this.e.x + (f2 * ((2 * this.d.x) + (3 * this.c.x * f2)));
    }

    private final float d(float f2) {
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

    public InterpolatorC12040dw1(float f2, float f3, float f4, float f5) {
        this(new PointF(f2, f3), new PointF(f4, f5));
    }

    public InterpolatorC12040dw1(double d, double d2, double d3, double d4) {
        this((float) d, (float) d2, (float) d3, (float) d4);
    }
}
