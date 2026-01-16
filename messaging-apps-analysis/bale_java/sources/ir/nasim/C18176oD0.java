package ir.nasim;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.oD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C18176oD0 extends C19949rD0 {
    C18176oD0(Context context) {
        super(context, null);
    }

    static C18176oD0 i(Context context) {
        return new C18176oD0(context);
    }

    private boolean j(Throwable th) {
        return Build.VERSION.SDK_INT == 28 && k(th);
    }

    private static boolean k(Throwable th) {
        StackTraceElement[] stackTrace;
        if (!th.getClass().equals(RuntimeException.class) || (stackTrace = th.getStackTrace()) == null || stackTrace.length < 0) {
            return false;
        }
        return "_enableShutterSound".equals(stackTrace[0].getMethodName());
    }

    private void l(Throwable th) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(10001, th);
    }

    @Override // ir.nasim.C19949rD0, ir.nasim.C17585nD0.b
    public void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.registerAvailabilityCallback(executor, availabilityCallback);
    }

    @Override // ir.nasim.C19949rD0, ir.nasim.C17585nD0.b
    public CameraCharacteristics b(String str) throws CameraAccessExceptionCompat {
        try {
            return super.b(str);
        } catch (RuntimeException e) {
            if (j(e)) {
                l(e);
            }
            throw e;
        }
    }

    @Override // ir.nasim.C19949rD0, ir.nasim.C17585nD0.b
    public void d(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessException, CameraAccessExceptionCompat {
        try {
            this.a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        } catch (IllegalArgumentException e2) {
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            if (j(e4)) {
                l(e4);
            }
            throw e4;
        }
    }

    @Override // ir.nasim.C19949rD0, ir.nasim.C17585nD0.b
    public void f(CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.unregisterAvailabilityCallback(availabilityCallback);
    }
}
