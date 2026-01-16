package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: ir.nasim.Sy1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C7725Sy1 {
    private final Context a;
    private final SharedPreferences b;
    private final InterfaceC17444my5 c;
    private boolean d;

    public C7725Sy1(Context context, String str, InterfaceC17444my5 interfaceC17444my5) {
        Context contextA = a(context);
        this.a = contextA;
        this.b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.c = interfaceC17444my5;
        this.d = c();
    }

    private static Context a(Context context) {
        return AbstractC4043Dl1.b(context);
    }

    private boolean c() {
        return this.b.contains("firebase_data_collection_default_enabled") ? this.b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.d;
    }
}
