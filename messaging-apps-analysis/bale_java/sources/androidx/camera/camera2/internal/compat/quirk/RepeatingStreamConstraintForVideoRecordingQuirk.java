package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class RepeatingStreamConstraintForVideoRecordingQuirk implements InterfaceC5592Jz5 {
    public static boolean c() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    static boolean d() {
        return c();
    }
}
