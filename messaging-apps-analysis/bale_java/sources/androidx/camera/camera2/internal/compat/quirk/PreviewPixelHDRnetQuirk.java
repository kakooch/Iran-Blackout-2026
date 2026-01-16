package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class PreviewPixelHDRnetQuirk implements InterfaceC5592Jz5 {
    private static final List a = Arrays.asList("sunfish", "bramble", "redfin", "barbet");

    static boolean c() {
        return "Google".equals(Build.MANUFACTURER) && a.contains(Build.DEVICE.toLowerCase(Locale.getDefault()));
    }
}
