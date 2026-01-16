package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class LowMemoryQuirk implements InterfaceC5592Jz5 {
    private static final Set a = new HashSet(Arrays.asList("SM-A520W", "MOTOG3"));

    static boolean c() {
        return a.contains(Build.MODEL.toUpperCase(Locale.US));
    }
}
