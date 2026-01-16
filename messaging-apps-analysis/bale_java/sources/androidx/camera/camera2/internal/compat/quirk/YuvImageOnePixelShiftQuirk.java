package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public final class YuvImageOnePixelShiftQuirk implements InterfaceC5592Jz5 {
    private static boolean c() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "MotoG3".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean d() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-A920F".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean e() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-G532F".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean f() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-J415F".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean g() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && "SM-J700F".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean h() {
        return "xiaomi".equalsIgnoreCase(Build.BRAND) && "Mi A1".equalsIgnoreCase(Build.MODEL);
    }

    static boolean i(C19349qC0 c19349qC0) {
        return c() || e() || g() || d() || f() || h();
    }
}
