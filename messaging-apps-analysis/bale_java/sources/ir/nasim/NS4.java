package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
abstract class NS4 {

    private static class a {
        static boolean a(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.hardware.fingerprint");
        }
    }

    static boolean a(Context context) {
        return (context == null || context.getPackageManager() == null || !a.a(context.getPackageManager())) ? false : true;
    }
}
