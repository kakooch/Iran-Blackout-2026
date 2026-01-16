package ir.nasim;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

/* loaded from: classes.dex */
public abstract class MD0 {
    public static CameraUnavailableException a(CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int iD = cameraAccessExceptionCompat.d();
        int i = 1;
        if (iD != 1) {
            i = 2;
            if (iD != 2) {
                i = 3;
                if (iD != 3) {
                    i = 4;
                    if (iD != 4) {
                        i = 5;
                        if (iD != 5) {
                            i = iD != 10001 ? 0 : 6;
                        }
                    }
                }
            }
        }
        return new CameraUnavailableException(i, cameraAccessExceptionCompat);
    }
}
