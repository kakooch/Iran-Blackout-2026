package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;

/* renamed from: ir.nasim.ax, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10024ax {
    public static void a(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        stateCallback.onCaptureQueueEmpty(cameraCaptureSession);
    }
}
