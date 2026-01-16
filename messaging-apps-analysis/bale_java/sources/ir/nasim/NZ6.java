package ir.nasim;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class NZ6 {
    private static final boolean a;

    static {
        a = Build.VERSION.SDK_INT >= 34;
    }

    public static final boolean a() {
        return a;
    }
}
