package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class Nexus4AndroidLTargetAspectRatioQuirk implements InterfaceC5592Jz5 {
    private static final List a = Arrays.asList("NEXUS 4");

    static boolean d() {
        "GOOGLE".equalsIgnoreCase(Build.BRAND);
        return false;
    }

    public int c() {
        return 2;
    }
}
