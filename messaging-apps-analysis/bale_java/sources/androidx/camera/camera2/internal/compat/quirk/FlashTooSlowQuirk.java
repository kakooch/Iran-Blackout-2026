package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class FlashTooSlowQuirk implements UseTorchAsFlashQuirk {
    private static final List a = Arrays.asList("PIXEL 3A", "PIXEL 3A XL", "PIXEL 4", "PIXEL 5", "SM-A320", "MOTO G(20)", "ITEL L6006", "RMX3231");

    private static boolean c() {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    static boolean d(C19349qC0 c19349qC0) {
        return c() && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
