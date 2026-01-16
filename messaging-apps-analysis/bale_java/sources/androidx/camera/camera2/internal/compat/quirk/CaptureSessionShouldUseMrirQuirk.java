package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class CaptureSessionShouldUseMrirQuirk implements InterfaceC5592Jz5 {
    static boolean c() {
        return "google".equalsIgnoreCase(Build.BRAND) && Build.VERSION.SDK_INT >= 35;
    }
}
