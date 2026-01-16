package ir.nasim;

import android.os.Build;

/* renamed from: ir.nasim.Xl0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC8814Xl0 {
    public static boolean a = true;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = false;
    public static boolean e;
    public static int f;
    public static String g;
    private static Boolean h;

    static {
        e = Build.VERSION.SDK_INT <= 29;
        f = 3712;
        g = "9.7.4";
    }

    public static boolean a() {
        if (h == null) {
            h = Boolean.FALSE;
        }
        return h.booleanValue();
    }
}
