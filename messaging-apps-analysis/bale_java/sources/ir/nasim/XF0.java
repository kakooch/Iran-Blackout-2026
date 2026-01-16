package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import androidx.camera.core.impl.j;
import ir.nasim.BB0;

/* loaded from: classes.dex */
public final class XF0 {
    public static final XF0 a = new XF0();

    private XF0() {
    }

    public static final void a(BB0.a aVar, j.c cVar) {
        AbstractC13042fc3.i(aVar, "options");
        AbstractC13042fc3.i(cVar, "priority");
        if (Build.VERSION.SDK_INT >= 34) {
            aVar.g(CaptureRequest.CONTROL_SETTINGS_OVERRIDE, 1, cVar);
        }
    }
}
