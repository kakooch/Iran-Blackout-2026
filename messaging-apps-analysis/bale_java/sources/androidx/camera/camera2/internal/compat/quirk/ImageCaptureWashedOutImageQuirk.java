package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ImageCaptureWashedOutImageQuirk implements UseTorchAsFlashQuirk {
    public static final List a = Arrays.asList("SM-G9300", "SM-G930R", "SM-G930A", "SM-G930V", "SM-G930T", "SM-G930U", "SM-G930P", "SM-SC02H", "SM-SCV33", "SM-G9350", "SM-G935R", "SM-G935A", "SM-G935V", "SM-G935T", "SM-G935U", "SM-G935P");

    static boolean c(C19349qC0 c19349qC0) {
        return a.contains(Build.MODEL.toUpperCase(Locale.US)) && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
