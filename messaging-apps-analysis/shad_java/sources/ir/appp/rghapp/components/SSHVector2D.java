package ir.appp.rghapp.components;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class SSHVector2D extends PointF {
    public static float getAngle(SSHVector2D sSHVector2D, SSHVector2D sSHVector2D2) {
        sSHVector2D.normalize();
        sSHVector2D2.normalize();
        return (float) ((Math.atan2(((PointF) sSHVector2D2).y, ((PointF) sSHVector2D2).x) - Math.atan2(((PointF) sSHVector2D).y, ((PointF) sSHVector2D).x)) * 57.29577951308232d);
    }

    public void normalize() {
        float f = ((PointF) this).x;
        float f2 = ((PointF) this).y;
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        ((PointF) this).x /= fSqrt;
        ((PointF) this).y /= fSqrt;
    }
}
