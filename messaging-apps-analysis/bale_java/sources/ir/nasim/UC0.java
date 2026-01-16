package ir.nasim;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;

/* loaded from: classes.dex */
class UC0 extends TC0 {
    UC0(CameraDevice cameraDevice) {
        super((CameraDevice) AbstractC4980Hj5.g(cameraDevice), null);
    }

    @Override // ir.nasim.TC0, ir.nasim.NC0.a
    public void a(C8626Wt6 c8626Wt6) throws CameraAccessException, CameraAccessExceptionCompat {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) c8626Wt6.j();
        AbstractC4980Hj5.g(sessionConfiguration);
        try {
            this.a.createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }
}
