package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class LegacyCameraSurfaceCleanupQuirk implements InterfaceC5592Jz5 {
    static boolean c(C19349qC0 c19349qC0) {
        Integer num = (Integer) c19349qC0.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    static boolean d(C19349qC0 c19349qC0) {
        return Build.VERSION.SDK_INT < 29 && c(c19349qC0);
    }
}
