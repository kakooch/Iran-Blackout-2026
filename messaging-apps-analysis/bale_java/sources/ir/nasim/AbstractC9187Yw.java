package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;

/* renamed from: ir.nasim.Yw, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9187Yw {
    public static void a(CameraCaptureSession.CaptureCallback captureCallback, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
        captureCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
    }
}
