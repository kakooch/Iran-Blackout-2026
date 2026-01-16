package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class CaptureNoResponseQuirk implements InterfaceC5592Jz5 {
    static boolean c(C19349qC0 c19349qC0) {
        String str = Build.HARDWARE;
        return ("samsungexynos7420".equalsIgnoreCase(str) || "universal7420".equalsIgnoreCase(str)) && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
