package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import ir.nasim.BB0;

/* loaded from: classes.dex */
public class E13 {
    public void a(int i, BB0.a aVar) {
        if (((ImageCapturePixelHDRPlusQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(ImageCapturePixelHDRPlusQuirk.class)) == null) {
            return;
        }
        if (i == 0) {
            aVar.f(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.TRUE);
        } else {
            if (i != 1) {
                return;
            }
            aVar.f(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.FALSE);
        }
    }
}
