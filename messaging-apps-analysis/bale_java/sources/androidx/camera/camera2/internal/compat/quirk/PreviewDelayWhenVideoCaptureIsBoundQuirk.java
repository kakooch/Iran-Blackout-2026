package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.InterfaceC5592Jz5;

/* loaded from: classes.dex */
public class PreviewDelayWhenVideoCaptureIsBoundQuirk implements CaptureIntentPreviewQuirk, InterfaceC5592Jz5 {
    static boolean c() {
        return "Huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }
}
