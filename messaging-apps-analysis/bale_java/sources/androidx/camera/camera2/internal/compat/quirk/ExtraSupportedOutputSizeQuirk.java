package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class ExtraSupportedOutputSizeQuirk implements InterfaceC5592Jz5 {
    private Size[] d() {
        return new Size[]{new Size(1440, 1080), new Size(960, 720)};
    }

    private static boolean e() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    static boolean f() {
        return e();
    }

    public Size[] c(int i) {
        return (i == 34 && e()) ? d() : new Size[0];
    }
}
