package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Locale;

/* loaded from: classes.dex */
public class StillCaptureFlashStopRepeatingQuirk implements InterfaceC5592Jz5 {
    static boolean c() {
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        return "SAMSUNG".equals(str.toUpperCase(locale)) && Build.MODEL.toUpperCase(locale).startsWith("SM-A716");
    }
}
