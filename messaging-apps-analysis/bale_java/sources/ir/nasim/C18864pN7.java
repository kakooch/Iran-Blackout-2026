package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: ir.nasim.pN7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18864pN7 {
    public static final C18864pN7 a = new C18864pN7();

    private C18864pN7() {
    }

    public static final boolean a(Context context) {
        AbstractC13042fc3.i(context, "context");
        String str = "";
        Context applicationContext = context.getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        try {
            String str2 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            if (str2 != null) {
                str = str2;
            }
        } catch (PackageManager.NameNotFoundException e) {
            C19406qI3.c("Utils", " get package info failed", e);
        }
        return AbstractC20762sZ6.X(str, "debug", false, 2, null);
    }
}
