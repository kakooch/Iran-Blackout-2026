package com.google.zxing.common.detector;

/* loaded from: classes.dex */
public final class MathUtils {
    public static int round(float d) {
        return (int) (d + (d < 0.0f ? -0.5f : 0.5f));
    }

    public static float distance(float aX, float aY, float bX, float bY) {
        double d = aX - bX;
        double d2 = aY - bY;
        Double.isNaN(d);
        Double.isNaN(d);
        Double.isNaN(d2);
        Double.isNaN(d2);
        return (float) Math.sqrt((d * d) + (d2 * d2));
    }

    public static float distance(int aX, int aY, int bX, int bY) {
        double d = aX - bX;
        double d2 = aY - bY;
        Double.isNaN(d);
        Double.isNaN(d);
        Double.isNaN(d2);
        Double.isNaN(d2);
        return (float) Math.sqrt((d * d) + (d2 * d2));
    }
}
