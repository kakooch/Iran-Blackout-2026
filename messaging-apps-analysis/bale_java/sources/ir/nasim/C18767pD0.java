package ir.nasim;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.pD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C18767pD0 extends C18176oD0 {
    C18767pD0(Context context) {
        super(context);
    }

    @Override // ir.nasim.C18176oD0, ir.nasim.C19949rD0, ir.nasim.C17585nD0.b
    public CameraCharacteristics b(String str) throws CameraAccessExceptionCompat {
        try {
            return this.a.getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }

    @Override // ir.nasim.C18176oD0, ir.nasim.C19949rD0, ir.nasim.C17585nD0.b
    public void d(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessException, CameraAccessExceptionCompat {
        try {
            this.a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }
}
