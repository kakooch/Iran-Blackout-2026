package ir.nasim;

import android.os.Build;

/* loaded from: classes3.dex */
public abstract class Rf8 {
    public static final int a;

    static {
        a = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
