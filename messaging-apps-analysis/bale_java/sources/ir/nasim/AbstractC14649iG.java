package ir.nasim;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: ir.nasim.iG, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14649iG {
    private static final ConcurrentMap a = new ConcurrentHashMap();

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    private static String b(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    public static InterfaceC14373ho3 c(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap concurrentMap = a;
        InterfaceC14373ho3 interfaceC14373ho3 = (InterfaceC14373ho3) concurrentMap.get(packageName);
        if (interfaceC14373ho3 != null) {
            return interfaceC14373ho3;
        }
        InterfaceC14373ho3 interfaceC14373ho3D = d(context);
        InterfaceC14373ho3 interfaceC14373ho32 = (InterfaceC14373ho3) concurrentMap.putIfAbsent(packageName, interfaceC14373ho3D);
        return interfaceC14373ho32 == null ? interfaceC14373ho3D : interfaceC14373ho32;
    }

    private static InterfaceC14373ho3 d(Context context) {
        return new C22456vG4(b(a(context)));
    }
}
