package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class InvalidVideoProfilesQuirk implements InterfaceC5592Jz5 {
    private static final List a = Arrays.asList("pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro");
    private static final List b = Arrays.asList("cph2417", "cph2451");
    private static final List c = Arrays.asList("cph2437", "cph2525", "pht110");

    private static boolean c() {
        return Build.VERSION.SDK_INT == 33;
    }

    private static boolean d() {
        return e() && c();
    }

    private static boolean e() {
        return b.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean f() {
        return g() && c();
    }

    private static boolean g() {
        return c.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean h() {
        return o() || m();
    }

    private static boolean i() {
        return j() && h();
    }

    private static boolean j() {
        return a.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean k() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && o();
    }

    private static boolean l() {
        String str = Build.BRAND;
        return ("redmi".equalsIgnoreCase(str) || "xiaomi".equalsIgnoreCase(str)) && (n() || o());
    }

    private static boolean m() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    private static boolean n() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tkq1");
    }

    private static boolean o() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    static boolean p() {
        return k() || i() || l() || d() || f();
    }
}
