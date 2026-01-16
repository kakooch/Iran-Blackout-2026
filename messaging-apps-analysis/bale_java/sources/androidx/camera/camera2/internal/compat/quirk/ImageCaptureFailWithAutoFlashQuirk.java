package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ImageCaptureFailWithAutoFlashQuirk implements InterfaceC5592Jz5 {
    private static final List a = Arrays.asList("sm-j700f", "sm-j710f");

    static boolean c(C19349qC0 c19349qC0) {
        return a.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
