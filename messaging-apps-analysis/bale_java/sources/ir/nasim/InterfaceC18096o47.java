package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: ir.nasim.o47, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC18096o47 {

    /* renamed from: ir.nasim.o47$a */
    public interface a {
        Executor b();

        InterfaceFutureC15215jC3 f(CameraDevice cameraDevice, C8626Wt6 c8626Wt6, List list);

        InterfaceFutureC15215jC3 j(List list, long j);

        C8626Wt6 k(int i, List list, c cVar);

        boolean stop();
    }

    /* renamed from: ir.nasim.o47$b */
    public static class b {
        private final Executor a;
        private final ScheduledExecutorService b;
        private final Handler c;
        private final C15248jG0 d;
        private final C6293Mz5 e;
        private final C6293Mz5 f;

        b(Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler, C15248jG0 c15248jG0, C6293Mz5 c6293Mz5, C6293Mz5 c6293Mz52) {
            this.a = executor;
            this.b = scheduledExecutorService;
            this.c = handler;
            this.d = c15248jG0;
            this.e = c6293Mz5;
            this.f = c6293Mz52;
        }

        a a() {
            return new C24121y47(this.e, this.f, this.d, this.a, this.b, this.c);
        }
    }

    void a();

    c c();

    void close();

    void d();

    void e();

    void g(int i);

    CameraDevice h();

    int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback);

    int l(List list, CameraCaptureSession.CaptureCallback captureCallback);

    TB0 m();

    InterfaceFutureC15215jC3 n();

    /* renamed from: ir.nasim.o47$c */
    public static abstract class c {
        public abstract void r(InterfaceC18096o47 interfaceC18096o47);

        abstract void s(InterfaceC18096o47 interfaceC18096o47);

        abstract void t(InterfaceC18096o47 interfaceC18096o47);

        abstract void u(InterfaceC18096o47 interfaceC18096o47);

        void o(InterfaceC18096o47 interfaceC18096o47) {
        }

        void p(InterfaceC18096o47 interfaceC18096o47) {
        }

        public void q(InterfaceC18096o47 interfaceC18096o47) {
        }

        void v(InterfaceC18096o47 interfaceC18096o47, Surface surface) {
        }
    }
}
