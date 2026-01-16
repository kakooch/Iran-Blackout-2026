package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* renamed from: ir.nasim.rK1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC20013rK1 {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (d == null) {
            boolean z = false;
            if (AbstractC3993Df5.h() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            d = Boolean.valueOf(z);
        }
        return d.booleanValue();
    }

    public static boolean b() {
        int i = com.google.android.gms.common.d.a;
        return "user".equals(Build.TYPE);
    }

    public static boolean c(Context context) {
        return g(context.getPackageManager());
    }

    public static boolean d(Context context) {
        if (c(context) && !AbstractC3993Df5.g()) {
            return true;
        }
        if (e(context)) {
            return !AbstractC3993Df5.h() || AbstractC3993Df5.k();
        }
        return false;
    }

    public static boolean e(Context context) {
        if (b == null) {
            boolean z = false;
            if (AbstractC3993Df5.f() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            b = Boolean.valueOf(z);
        }
        return b.booleanValue();
    }

    public static boolean f(Context context) {
        if (c == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            c = Boolean.valueOf(z);
        }
        return c.booleanValue();
    }

    public static boolean g(PackageManager packageManager) {
        if (a == null) {
            boolean z = false;
            if (AbstractC3993Df5.e() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }
}
