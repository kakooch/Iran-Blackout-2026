package ir.nasim;

import android.view.ViewConfiguration;

/* renamed from: ir.nasim.a32, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9491a32 {
    private static final float a = ViewConfiguration.getScrollFriction();
    private static final double b;
    private static final double c;

    static {
        double dLog = Math.log(0.78d) / Math.log(0.9d);
        b = dLog;
        c = dLog - 1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(WH1 wh1, float f) {
        double density = wh1.getDensity() * 386.0878f * 160.0f * 0.84f;
        double dAbs = Math.abs(f) * 0.35f;
        float f2 = a;
        return (float) (f2 * density * Math.exp((b / c) * Math.log(dAbs / (f2 * density))));
    }
}
