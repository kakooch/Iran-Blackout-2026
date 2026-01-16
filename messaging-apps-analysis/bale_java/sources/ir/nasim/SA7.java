package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class SA7 {
    public static boolean a(Context context, int i) throws PackageManager.NameNotFoundException {
        if (!b(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return com.google.android.gms.common.e.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return false;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    public static boolean b(Context context, int i, String str) {
        return Fb8.a(context).g(i, str);
    }
}
