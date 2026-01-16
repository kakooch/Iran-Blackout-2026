package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ImageCaptureFlashNotFireQuirk implements UseTorchAsFlashQuirk {
    private static final List a = Arrays.asList("itel w6004");
    private static final List b = Arrays.asList("sm-j700f", "sm-j710f");

    static boolean c(C19349qC0 c19349qC0) {
        List list = b;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        return (list.contains(str.toLowerCase(locale)) && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 0) || a.contains(str.toLowerCase(locale));
    }
}
