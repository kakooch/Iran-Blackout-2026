package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class FN6 {
    private final boolean a;

    public FN6() {
        this.a = ((StillCaptureFlashStopRepeatingQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(StillCaptureFlashStopRepeatingQuirk.class)) != null;
    }

    public boolean a(List list, boolean z) {
        if (this.a && z) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) ((CaptureRequest) it.next()).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
                if (iIntValue == 2 || iIntValue == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
