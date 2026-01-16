package ir.nasim;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes2.dex */
public abstract class FS4 {
    private static final String a = HI3.f("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            HI3.c().a(a, String.format("%s %s", cls.getName(), z ? "enabled" : "disabled"), new Throwable[0]);
        } catch (Exception e) {
            HI3.c().a(a, String.format("%s could not be %s", cls.getName(), z ? "enabled" : "disabled"), e);
        }
    }
}
