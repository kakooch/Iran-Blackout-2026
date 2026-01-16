package ir.nasim;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class NC0 {
    private final a a;

    interface a {
        void a(C8626Wt6 c8626Wt6);
    }

    static final class b extends CameraDevice.StateCallback {
        final CameraDevice.StateCallback a;
        private final Executor b;

        b(Executor executor, CameraDevice.StateCallback stateCallback) {
            this.b = executor;
            this.a = stateCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(CameraDevice cameraDevice) {
            this.a.onClosed(cameraDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(CameraDevice cameraDevice) {
            this.a.onDisconnected(cameraDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(CameraDevice cameraDevice, int i) {
            this.a.onError(cameraDevice, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(CameraDevice cameraDevice) {
            this.a.onOpened(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(final CameraDevice cameraDevice) {
            this.b.execute(new Runnable() { // from class: ir.nasim.OC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(final CameraDevice cameraDevice) {
            this.b.execute(new Runnable() { // from class: ir.nasim.QC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(final CameraDevice cameraDevice, final int i) {
            this.b.execute(new Runnable() { // from class: ir.nasim.PC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g(cameraDevice, i);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(final CameraDevice cameraDevice) {
            this.b.execute(new Runnable() { // from class: ir.nasim.RC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(cameraDevice);
                }
            });
        }
    }

    private NC0(CameraDevice cameraDevice, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new UC0(cameraDevice);
        } else {
            this.a = TC0.e(cameraDevice, handler);
        }
    }

    public static NC0 b(CameraDevice cameraDevice, Handler handler) {
        return new NC0(cameraDevice, handler);
    }

    public void a(C8626Wt6 c8626Wt6) {
        this.a.a(c8626Wt6);
    }
}
