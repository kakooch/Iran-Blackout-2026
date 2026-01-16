package ir.nasim;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class BD1 implements OV0 {
    private static final BD1 a = new BD1();

    private BD1() {
    }

    public static OV0 a() {
        return a;
    }

    @Override // ir.nasim.OV0
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // ir.nasim.OV0
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // ir.nasim.OV0
    public final long nanoTime() {
        return System.nanoTime();
    }
}
