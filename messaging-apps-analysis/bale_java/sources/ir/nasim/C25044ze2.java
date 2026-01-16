package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.j;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.BB0;
import ir.nasim.PA0;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.ze2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C25044ze2 {
    private final PA0 a;
    private final C3274Ae2 b;
    private final Executor c;
    private boolean d = false;
    private AbstractC16967mA0.a e;
    private PA0.c f;

    C25044ze2(PA0 pa0, C19349qC0 c19349qC0, Executor executor) {
        this.a = pa0;
        this.b = new C3274Ae2(c19349qC0, 0);
        this.c = executor;
    }

    private void a() {
        AbstractC16967mA0.a aVar = this.e;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            this.e = null;
        }
        PA0.c cVar = this.f;
        if (cVar != null) {
            this.a.O(cVar);
            this.f = null;
        }
    }

    void b(boolean z) {
        if (z == this.d) {
            return;
        }
        this.d = z;
        if (z) {
            return;
        }
        this.b.b(0);
        a();
    }

    void c(BB0.a aVar) {
        aVar.g(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.b.a()), j.c.REQUIRED);
    }
}
