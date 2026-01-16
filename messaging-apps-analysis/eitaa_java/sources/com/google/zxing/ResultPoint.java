package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* loaded from: classes.dex */
public class ResultPoint {
    private final float x;
    private final float y;

    public ResultPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final boolean equals(Object other) {
        if (!(other instanceof ResultPoint)) {
            return false;
        }
        ResultPoint resultPoint = (ResultPoint) other;
        return this.x == resultPoint.x && this.y == resultPoint.y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    public final String toString() {
        return "(" + this.x + ',' + this.y + ')';
    }

    public static void orderBestPatterns(ResultPoint[] patterns) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fDistance = distance(patterns[0], patterns[1]);
        float fDistance2 = distance(patterns[1], patterns[2]);
        float fDistance3 = distance(patterns[0], patterns[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = patterns[0];
            resultPoint2 = patterns[1];
            resultPoint3 = patterns[2];
        } else if (fDistance3 >= fDistance2 && fDistance3 >= fDistance) {
            resultPoint = patterns[1];
            resultPoint2 = patterns[0];
            resultPoint3 = patterns[2];
        } else {
            resultPoint = patterns[2];
            resultPoint2 = patterns[0];
            resultPoint3 = patterns[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        patterns[0] = resultPoint2;
        patterns[1] = resultPoint;
        patterns[2] = resultPoint3;
    }

    public static float distance(ResultPoint pattern1, ResultPoint pattern2) {
        return MathUtils.distance(pattern1.x, pattern1.y, pattern2.x, pattern2.y);
    }

    private static float crossProductZ(ResultPoint pointA, ResultPoint pointB, ResultPoint pointC) {
        float f = pointB.x;
        float f2 = pointB.y;
        return ((pointC.x - f) * (pointA.y - f2)) - ((pointC.y - f2) * (pointA.x - f));
    }
}
