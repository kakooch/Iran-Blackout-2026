package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.j;
import ir.nasim.VF0;

/* loaded from: classes.dex */
public final class BB0 extends VF0 {
    public static final j.a I = j.a.a("camera2.captureRequest.templateType", Integer.TYPE);
    public static final j.a J = j.a.a("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);
    public static final j.a K = j.a.a("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
    public static final j.a L = j.a.a("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
    public static final j.a M = j.a.a("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
    public static final j.a N = j.a.a("camera2.captureRequest.tag", Object.class);
    public static final j.a O = j.a.a("camera2.cameraCaptureSession.physicalCameraId", String.class);

    public static final class a implements InterfaceC3513Be2 {
        private final androidx.camera.core.impl.q a = androidx.camera.core.impl.q.Z();

        @Override // ir.nasim.InterfaceC3513Be2
        public androidx.camera.core.impl.p a() {
            return this.a;
        }

        public BB0 c() {
            return new BB0(androidx.camera.core.impl.r.X(this.a));
        }

        public a d(androidx.camera.core.impl.j jVar) {
            e(jVar, j.c.OPTIONAL);
            return this;
        }

        public a e(androidx.camera.core.impl.j jVar, j.c cVar) {
            for (j.a aVar : jVar.e()) {
                this.a.n(aVar, cVar, jVar.a(aVar));
            }
            return this;
        }

        public a f(CaptureRequest.Key key, Object obj) {
            this.a.p(BB0.V(key), obj);
            return this;
        }

        public a g(CaptureRequest.Key key, Object obj, j.c cVar) {
            this.a.n(BB0.V(key), cVar, obj);
            return this;
        }
    }

    public BB0(androidx.camera.core.impl.j jVar) {
        super(jVar);
    }

    public static j.a V(CaptureRequest.Key key) {
        return j.a.b("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    public VF0 W() {
        return VF0.a.e(getConfig()).d();
    }

    public int X(int i) {
        return ((Integer) getConfig().g(I, Integer.valueOf(i))).intValue();
    }

    public CameraDevice.StateCallback Y(CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) getConfig().g(K, stateCallback);
    }

    public String Z(String str) {
        return (String) getConfig().g(O, str);
    }

    public CameraCaptureSession.CaptureCallback a0(CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) getConfig().g(M, captureCallback);
    }

    public CameraCaptureSession.StateCallback b0(CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) getConfig().g(L, stateCallback);
    }

    public long c0(long j) {
        return ((Long) getConfig().g(J, Long.valueOf(j))).longValue();
    }
}
