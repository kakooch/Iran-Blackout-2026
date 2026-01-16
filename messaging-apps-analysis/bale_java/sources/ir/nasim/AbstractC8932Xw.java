package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;

/* renamed from: ir.nasim.Xw, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8932Xw {
    public static void a(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession, Surface surface) {
        stateCallback.onSurfacePrepared(cameraCaptureSession, surface);
    }
}
