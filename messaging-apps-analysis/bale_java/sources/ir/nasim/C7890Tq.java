package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.j;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.BB0;
import ir.nasim.Nc8;

/* renamed from: ir.nasim.Tq, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C7890Tq implements Nc8.b {
    private final C19349qC0 a;
    private final Range b;
    private AbstractC16967mA0.a d;
    private boolean f;
    private float c = 1.0f;
    private float e = 1.0f;

    C7890Tq(C19349qC0 c19349qC0) {
        this.f = false;
        this.a = c19349qC0;
        this.b = (Range) c19349qC0.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        this.f = c19349qC0.d();
    }

    @Override // ir.nasim.Nc8.b
    public void a(TotalCaptureResult totalCaptureResult) {
        if (this.d != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            Float f = request == null ? null : (Float) request.get(CaptureRequest.CONTROL_ZOOM_RATIO);
            if (f == null) {
                return;
            }
            if (this.e == f.floatValue()) {
                this.d.c(null);
                this.d = null;
            }
        }
    }

    @Override // ir.nasim.Nc8.b
    public float b() {
        return ((Float) this.b.getLower()).floatValue();
    }

    @Override // ir.nasim.Nc8.b
    public void c() {
        this.c = 1.0f;
        AbstractC16967mA0.a aVar = this.d;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
            this.d = null;
        }
    }

    @Override // ir.nasim.Nc8.b
    public void d(BB0.a aVar) {
        CaptureRequest.Key key = CaptureRequest.CONTROL_ZOOM_RATIO;
        Float fValueOf = Float.valueOf(this.c);
        j.c cVar = j.c.REQUIRED;
        aVar.g(key, fValueOf, cVar);
        if (this.f) {
            XF0.a(aVar, cVar);
        }
    }

    @Override // ir.nasim.Nc8.b
    public float e() {
        return ((Float) this.b.getUpper()).floatValue();
    }
}
