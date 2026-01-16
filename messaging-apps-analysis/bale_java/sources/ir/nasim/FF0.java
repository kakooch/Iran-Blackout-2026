package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;

/* loaded from: classes.dex */
final class FF0 extends JB0 {
    private final CameraCaptureSession.CaptureCallback a;

    private FF0(CameraCaptureSession.CaptureCallback captureCallback) {
        if (captureCallback == null) {
            throw new NullPointerException("captureCallback is null");
        }
        this.a = captureCallback;
    }

    static FF0 e(CameraCaptureSession.CaptureCallback captureCallback) {
        return new FF0(captureCallback);
    }

    CameraCaptureSession.CaptureCallback f() {
        return this.a;
    }
}
