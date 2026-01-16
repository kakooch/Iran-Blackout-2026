package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;

/* loaded from: classes.dex */
public class TemporalNoiseQuirk implements CaptureIntentPreviewQuirk {
    private static boolean c() {
        return "Pixel 8".equalsIgnoreCase(Build.MODEL);
    }

    static boolean d(C19349qC0 c19349qC0) {
        return c() && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
