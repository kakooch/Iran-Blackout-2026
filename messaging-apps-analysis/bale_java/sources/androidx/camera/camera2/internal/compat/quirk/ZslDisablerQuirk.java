package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ZslDisablerQuirk implements InterfaceC5592Jz5 {
    private static final List a = Arrays.asList("SM-F936", "SM-S901U", "SM-S908U", "SM-S908U1");
    private static final List b = Arrays.asList("MI 8");

    private static boolean c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean d() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && c(a);
    }

    private static boolean e() {
        return "xiaomi".equalsIgnoreCase(Build.BRAND) && c(b);
    }

    static boolean f() {
        return d() || e();
    }
}
