package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import ir.nasim.InterfaceC5592Jz5;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class FlashAvailabilityBufferUnderflowQuirk implements InterfaceC5592Jz5 {
    private static final Set a = new HashSet();

    static {
        c("sprd", "lemp");
        c("sprd", "DM20C");
    }

    private static void c(String str, String str2) {
        Set set = a;
        Locale locale = Locale.US;
        set.add(new Pair(str.toLowerCase(locale), str2.toLowerCase(locale)));
    }

    static boolean d() {
        Set set = a;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        return set.contains(new Pair(str.toLowerCase(locale), Build.MODEL.toLowerCase(locale)));
    }
}
