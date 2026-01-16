package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class SurfaceViewNotCroppedByParentQuirk implements InterfaceC5592Jz5 {
    static boolean c() {
        return "XIAOMI".equalsIgnoreCase(Build.MANUFACTURER) && "M2101K7AG".equalsIgnoreCase(Build.MODEL);
    }
}
