package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class Sh8 {
    private static final Object a = new Object();
    private static boolean b;
    private static String c;
    private static int d;

    public static int a(Context context) {
        b(context);
        return d;
    }

    private static void b(Context context) {
        Bundle bundle;
        synchronized (a) {
            try {
                if (b) {
                    return;
                }
                b = true;
                try {
                    bundle = Fb8.a(context).c(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
                if (bundle == null) {
                    return;
                }
                c = bundle.getString("com.google.app.id");
                d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
