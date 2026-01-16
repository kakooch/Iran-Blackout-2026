package ir.nasim;

import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;

/* loaded from: classes.dex */
public class IS {
    private final boolean a;
    private final boolean b;

    public IS(C6293Mz5 c6293Mz5) {
        this.a = c6293Mz5.a(ImageCaptureFailWithAutoFlashQuirk.class);
        this.b = androidx.camera.camera2.internal.compat.quirk.b.b(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) != null;
    }

    public int a(int i) {
        if ((this.a || this.b) && i == 2) {
            return 1;
        }
        return i;
    }
}
