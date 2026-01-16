package com.google.zxing.common;

/* loaded from: classes.dex */
public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float a11, float a21, float a31, float a12, float a22, float a32, float a13, float a23, float a33) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float x0, float y0, float x1, float y1, float x2, float y2, float x3, float y3, float x0p, float y0p, float x1p, float y1p, float x2p, float y2p, float x3p, float y3p) {
        return squareToQuadrilateral(x0p, y0p, x1p, y1p, x2p, y2p, x3p, y3p).times(quadrilateralToSquare(x0, y0, x1, y1, x2, y2, x3, y3));
    }

    public void transformPoints(float[] points) {
        float f = this.a11;
        float f2 = this.a12;
        float f3 = this.a13;
        float f4 = this.a21;
        float f5 = this.a22;
        float f6 = this.a23;
        float f7 = this.a31;
        float f8 = this.a32;
        float f9 = this.a33;
        int length = points.length - 1;
        for (int i = 0; i < length; i += 2) {
            float f10 = points[i];
            int i2 = i + 1;
            float f11 = points[i2];
            float f12 = (f3 * f10) + (f6 * f11) + f9;
            points[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            points[i2] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    public static PerspectiveTransform squareToQuadrilateral(float x0, float y0, float x1, float y1, float x2, float y2, float x3, float y3) {
        float f = ((x0 - x1) + x2) - x3;
        float f2 = ((y0 - y1) + y2) - y3;
        if (f == 0.0f && f2 == 0.0f) {
            return new PerspectiveTransform(x1 - x0, x2 - x1, x0, y1 - y0, y2 - y1, y0, 0.0f, 0.0f, 1.0f);
        }
        float f3 = x1 - x2;
        float f4 = x3 - x2;
        float f5 = y1 - y2;
        float f6 = y3 - y2;
        float f7 = (f3 * f6) - (f4 * f5);
        float f8 = ((f6 * f) - (f4 * f2)) / f7;
        float f9 = ((f3 * f2) - (f * f5)) / f7;
        return new PerspectiveTransform((f8 * x1) + (x1 - x0), (f9 * x3) + (x3 - x0), x0, (y1 - y0) + (f8 * y1), (y3 - y0) + (f9 * y3), y0, f8, f9, 1.0f);
    }

    public static PerspectiveTransform quadrilateralToSquare(float x0, float y0, float x1, float y1, float x2, float y2, float x3, float y3) {
        return squareToQuadrilateral(x0, y0, x1, y1, x2, y2, x3, y3).buildAdjoint();
    }

    PerspectiveTransform buildAdjoint() {
        float f = this.a22;
        float f2 = this.a33;
        float f3 = this.a23;
        float f4 = this.a32;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.a31;
        float f7 = this.a21;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f * f6);
        float f10 = this.a13;
        float f11 = this.a12;
        float f12 = (f10 * f4) - (f11 * f2);
        float f13 = this.a11;
        return new PerspectiveTransform(f5, f8, f9, f12, (f2 * f13) - (f10 * f6), (f6 * f11) - (f4 * f13), (f11 * f3) - (f10 * f), (f10 * f7) - (f3 * f13), (f13 * f) - (f11 * f7));
    }

    PerspectiveTransform times(PerspectiveTransform other) {
        float f = this.a11;
        float f2 = other.a11;
        float f3 = this.a21;
        float f4 = other.a12;
        float f5 = this.a31;
        float f6 = other.a13;
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = other.a21;
        float f9 = other.a22;
        float f10 = other.a23;
        float f11 = (f * f8) + (f3 * f9) + (f5 * f10);
        float f12 = other.a31;
        float f13 = other.a32;
        float f14 = other.a33;
        float f15 = (f * f12) + (f3 * f13) + (f5 * f14);
        float f16 = this.a12;
        float f17 = this.a22;
        float f18 = this.a32;
        float f19 = (f16 * f2) + (f17 * f4) + (f18 * f6);
        float f20 = (f16 * f8) + (f17 * f9) + (f18 * f10);
        float f21 = (f18 * f14) + (f16 * f12) + (f17 * f13);
        float f22 = this.a13;
        float f23 = this.a23;
        float f24 = (f2 * f22) + (f4 * f23);
        float f25 = this.a33;
        return new PerspectiveTransform(f7, f11, f15, f19, f20, f21, (f6 * f25) + f24, (f8 * f22) + (f9 * f23) + (f10 * f25), (f22 * f12) + (f23 * f13) + (f25 * f14));
    }
}
