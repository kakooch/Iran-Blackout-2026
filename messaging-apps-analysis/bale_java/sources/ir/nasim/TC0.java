package ir.nasim;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import ir.nasim.TB0;
import ir.nasim.VC0;
import java.util.List;

/* loaded from: classes.dex */
class TC0 extends SC0 {
    TC0(CameraDevice cameraDevice, Object obj) {
        super(cameraDevice, obj);
    }

    static TC0 e(CameraDevice cameraDevice, Handler handler) {
        return new TC0(cameraDevice, new VC0.a(handler));
    }

    @Override // ir.nasim.NC0.a
    public void a(C8626Wt6 c8626Wt6) throws CameraAccessException, CameraAccessExceptionCompat {
        VC0.c(this.a, c8626Wt6);
        TB0.c cVar = new TB0.c(c8626Wt6.a(), c8626Wt6.e());
        List listC = c8626Wt6.c();
        Handler handler = ((VC0.a) AbstractC4980Hj5.g((VC0.a) this.b)).a;
        C13987h93 c13987h93B = c8626Wt6.b();
        try {
            if (c13987h93B != null) {
                InputConfiguration inputConfiguration = (InputConfiguration) c13987h93B.a();
                AbstractC4980Hj5.g(inputConfiguration);
                this.a.createReprocessableCaptureSessionByConfigurations(inputConfiguration, C8626Wt6.h(listC), cVar, handler);
            } else if (c8626Wt6.d() == 1) {
                this.a.createConstrainedHighSpeedCaptureSession(VC0.d(listC), cVar, handler);
            } else {
                this.a.createCaptureSessionByOutputConfigurations(C8626Wt6.h(listC), cVar, handler);
            }
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }
}
