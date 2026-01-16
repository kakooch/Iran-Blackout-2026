package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.iC0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C14614iC0 extends C15212jC0 {
    C14614iC0(CameraCaptureSession cameraCaptureSession) {
        super(cameraCaptureSession, null);
    }

    @Override // ir.nasim.C15212jC0, ir.nasim.TB0.a
    public int b(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.captureBurstRequests(list, executor, captureCallback);
    }

    @Override // ir.nasim.C15212jC0, ir.nasim.TB0.a
    public int c(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }
}
