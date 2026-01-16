package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.core.impl.j;
import ir.nasim.BB0;

/* renamed from: ir.nasim.Bi, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3546Bi {
    private final Range a;

    public C3546Bi(C6293Mz5 c6293Mz5) {
        AeFpsRangeLegacyQuirk aeFpsRangeLegacyQuirk = (AeFpsRangeLegacyQuirk) c6293Mz5.b(AeFpsRangeLegacyQuirk.class);
        if (aeFpsRangeLegacyQuirk == null) {
            this.a = null;
        } else {
            this.a = aeFpsRangeLegacyQuirk.d();
        }
    }

    public void a(BB0.a aVar) {
        Range range = this.a;
        if (range != null) {
            aVar.g(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range, j.c.REQUIRED);
        }
    }
}
