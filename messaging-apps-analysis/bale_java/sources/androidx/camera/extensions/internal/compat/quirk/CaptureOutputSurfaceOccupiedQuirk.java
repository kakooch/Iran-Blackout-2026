package androidx.camera.extensions.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class CaptureOutputSurfaceOccupiedQuirk implements InterfaceC5592Jz5 {
    static boolean c() {
        return Build.BRAND.equalsIgnoreCase("Xiaomi");
    }
}
