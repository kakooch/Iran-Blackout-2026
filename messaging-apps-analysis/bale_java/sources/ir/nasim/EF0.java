package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import ir.nasim.LB0;

/* loaded from: classes.dex */
final class EF0 extends CameraCaptureSession.CaptureCallback {
    private final JB0 a;

    EF0(JB0 jb0) {
        if (jb0 == null) {
            throw new NullPointerException("cameraCaptureCallback is null");
        }
        this.a = jb0;
    }

    private int a(CaptureRequest captureRequest) {
        Integer num;
        if ((captureRequest.getTag() instanceof C14935ij7) && (num = (Integer) ((C14935ij7) captureRequest.getTag()).d("CAPTURE_CONFIG_ID_KEY")) != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        C14935ij7 c14935ij7B;
        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        Object tag = captureRequest.getTag();
        if (tag != null) {
            AbstractC4980Hj5.b(tag instanceof C14935ij7, "The tagBundle object from the CaptureResult is not a TagBundle object.");
            c14935ij7B = (C14935ij7) tag;
        } else {
            c14935ij7B = C14935ij7.b();
        }
        this.a.b(a(captureRequest), new C22994wA0(c14935ij7B, totalCaptureResult));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        this.a.c(a(captureRequest), new LB0(LB0.a.ERROR));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
        super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        this.a.d(a(captureRequest));
    }
}
