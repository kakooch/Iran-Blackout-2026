package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ImageCaptureWithFlashUnderexposureQuirk implements UseTorchAsFlashQuirk {
    public static final List a = Arrays.asList("sm-a260f", "sm-j530f", "sm-j600g", "sm-j701f", "sm-g610f", "sm-j710mn");

    static boolean c(C19349qC0 c19349qC0) {
        return a.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
