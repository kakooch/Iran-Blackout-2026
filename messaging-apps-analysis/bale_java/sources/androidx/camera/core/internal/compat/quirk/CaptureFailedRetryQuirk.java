package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import android.util.Pair;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class CaptureFailedRetryQuirk implements InterfaceC5592Jz5 {
    private static final Set a = new HashSet(Collections.singletonList(Pair.create("SAMSUNG", "SM-G981U1")));

    static boolean c() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        return a.contains(Pair.create(str.toUpperCase(locale), Build.MODEL.toUpperCase(locale)));
    }
}
