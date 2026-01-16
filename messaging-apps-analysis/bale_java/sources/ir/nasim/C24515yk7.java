package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.yk7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C24515yk7 {
    private final boolean a;
    private final boolean b;

    public C24515yk7(C6293Mz5 c6293Mz5) {
        this.a = CaptureIntentPreviewQuirk.b(c6293Mz5);
        this.b = c6293Mz5.a(ImageCaptureFailedForVideoSnapshotQuirk.class);
    }

    public Map a(int i) {
        if (i == 3 && this.a) {
            HashMap map = new HashMap();
            map.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
            return Collections.unmodifiableMap(map);
        }
        if (i != 4 || !this.b) {
            return Collections.emptyMap();
        }
        HashMap map2 = new HashMap();
        map2.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
        return Collections.unmodifiableMap(map2);
    }
}
