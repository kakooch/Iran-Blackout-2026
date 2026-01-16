package ir.nasim;

import android.app.AppOpsManager;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* renamed from: ir.nasim.jc8, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15456jc8 {
    public static final C15456jc8 a = new C15456jc8();

    private C15456jc8() {
    }

    public static final boolean b(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            C5721Ko c5721Ko = C5721Ko.a;
            Object systemService = c5721Ko.d().getSystemService("appops");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.AppOpsManager");
            Class cls = Integer.TYPE;
            Object objInvoke = AppOpsManager.class.getMethod("checkOpNoThrow", cls, cls, String.class).invoke((AppOpsManager) systemService, Integer.valueOf(i), Integer.valueOf(Process.myUid()), c5721Ko.d().getPackageName());
            AbstractC13042fc3.g(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) objInvoke).intValue() == 0;
        } catch (Exception e) {
            C19406qI3.j("XiaomiUtils", "Error in isCustomPermissionGranted: " + e.getMessage(), new Object[0]);
            return true;
        }
    }

    public static final boolean c() {
        String str = Build.MANUFACTURER;
        AbstractC13042fc3.h(str, "MANUFACTURER");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC13042fc3.d("xiaomi", lowerCase);
    }

    public final Intent a() {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_package_uid", Process.myUid());
        intent.putExtra("extra_pkgname", C5721Ko.a.d().getPackageName());
        return intent;
    }
}
