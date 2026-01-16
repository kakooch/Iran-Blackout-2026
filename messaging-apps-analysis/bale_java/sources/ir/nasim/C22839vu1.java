package ir.nasim;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.j;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.BB0;
import ir.nasim.Nc8;

/* renamed from: ir.nasim.vu1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C22839vu1 implements Nc8.b {
    private final C19349qC0 a;
    private AbstractC16967mA0.a c;
    private Rect b = null;
    private Rect d = null;

    C22839vu1(C19349qC0 c19349qC0) {
        this.a = c19349qC0;
    }

    @Override // ir.nasim.Nc8.b
    public void a(TotalCaptureResult totalCaptureResult) {
        if (this.c != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            Rect rect = request == null ? null : (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            Rect rect2 = this.d;
            if (rect2 == null || !rect2.equals(rect)) {
                return;
            }
            this.c.c(null);
            this.c = null;
            this.d = null;
        }
    }

    @Override // ir.nasim.Nc8.b
    public float b() {
        return 1.0f;
    }

    @Override // ir.nasim.Nc8.b
    public void c() {
        this.d = null;
        this.b = null;
        AbstractC16967mA0.a aVar = this.c;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
            this.c = null;
        }
    }

    @Override // ir.nasim.Nc8.b
    public void d(BB0.a aVar) {
        Rect rect = this.b;
        if (rect != null) {
            aVar.g(CaptureRequest.SCALER_CROP_REGION, rect, j.c.REQUIRED);
        }
    }

    @Override // ir.nasim.Nc8.b
    public float e() {
        Float f = (Float) this.a.a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f == null) {
            return 1.0f;
        }
        return f.floatValue() < b() ? b() : f.floatValue();
    }
}
