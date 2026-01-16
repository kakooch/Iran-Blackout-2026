package androidx.camera.extensions.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class ExtensionDisabledQuirk implements InterfaceC5592Jz5 {
    private static boolean c() {
        return "motorola".equalsIgnoreCase(Build.BRAND);
    }

    private static boolean d() {
        return "google".equalsIgnoreCase(Build.BRAND) && "redfin".equalsIgnoreCase(Build.DEVICE);
    }

    private static boolean e() {
        return "realme".equalsIgnoreCase(Build.BRAND);
    }

    static boolean f() {
        return d() || c() || e();
    }
}
