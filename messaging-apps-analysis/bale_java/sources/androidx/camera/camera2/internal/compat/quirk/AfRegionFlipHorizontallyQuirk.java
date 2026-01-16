package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class AfRegionFlipHorizontallyQuirk implements InterfaceC5592Jz5 {
    static boolean c(C19349qC0 c19349qC0) {
        return Build.BRAND.equalsIgnoreCase("SAMSUNG") && Build.VERSION.SDK_INT < 33 && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
