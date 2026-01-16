package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import ir.nasim.C19349qC0;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class JpegCaptureDownsizingQuirk implements SoftwareJpegEncodingPreferredQuirk {
    private static final Set a = new HashSet(Arrays.asList("redmi note 8 pro"));

    static boolean c(C19349qC0 c19349qC0) {
        return a.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) c19349qC0.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
