package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import ir.nasim.TB0;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.jC0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C15212jC0 implements TB0.a {
    final CameraCaptureSession a;
    final Object b;

    /* renamed from: ir.nasim.jC0$a */
    private static class a {
        final Handler a;

        a(Handler handler) {
            this.a = handler;
        }
    }

    C15212jC0(CameraCaptureSession cameraCaptureSession, Object obj) {
        this.a = (CameraCaptureSession) AbstractC4980Hj5.g(cameraCaptureSession);
        this.b = obj;
    }

    static TB0.a d(CameraCaptureSession cameraCaptureSession, Handler handler) {
        return new C15212jC0(cameraCaptureSession, new a(handler));
    }

    @Override // ir.nasim.TB0.a
    public CameraCaptureSession a() {
        return this.a;
    }

    @Override // ir.nasim.TB0.a
    public int b(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.captureBurst(list, new TB0.b(executor, captureCallback), ((a) this.b).a);
    }

    @Override // ir.nasim.TB0.a
    public int c(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.setRepeatingRequest(captureRequest, new TB0.b(executor, captureCallback), ((a) this.b).a);
    }
}
