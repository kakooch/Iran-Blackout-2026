package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class TB0 {
    private final a a;

    interface a {
        CameraCaptureSession a();

        int b(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback);

        int c(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback);
    }

    static final class b extends CameraCaptureSession.CaptureCallback {
        final CameraCaptureSession.CaptureCallback a;
        private final Executor b;

        b(Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
            this.b = executor;
            this.a = captureCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
            AbstractC9187Yw.a(this.a, cameraCaptureSession, captureRequest, surface, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.a.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.a.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.a.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(CameraCaptureSession cameraCaptureSession, int i) {
            this.a.onCaptureSequenceAborted(cameraCaptureSession, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(CameraCaptureSession cameraCaptureSession, int i, long j) {
            this.a.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            this.a.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final Surface surface, final long j) {
            this.b.execute(new Runnable() { // from class: ir.nasim.ZB0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(cameraCaptureSession, captureRequest, surface, j);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final TotalCaptureResult totalCaptureResult) {
            this.b.execute(new Runnable() { // from class: ir.nasim.VB0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureFailure captureFailure) {
            this.b.execute(new Runnable() { // from class: ir.nasim.YB0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(cameraCaptureSession, captureRequest, captureFailure);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureResult captureResult) {
            this.b.execute(new Runnable() { // from class: ir.nasim.WB0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(cameraCaptureSession, captureRequest, captureResult);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(final CameraCaptureSession cameraCaptureSession, final int i) {
            this.b.execute(new Runnable() { // from class: ir.nasim.aC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l(cameraCaptureSession, i);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(final CameraCaptureSession cameraCaptureSession, final int i, final long j) {
            this.b.execute(new Runnable() { // from class: ir.nasim.XB0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m(cameraCaptureSession, i, j);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final long j, final long j2) {
            this.b.execute(new Runnable() { // from class: ir.nasim.UB0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(cameraCaptureSession, captureRequest, j, j2);
                }
            });
        }
    }

    static final class c extends CameraCaptureSession.StateCallback {
        final CameraCaptureSession.StateCallback a;
        private final Executor b;

        c(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.b = executor;
            this.a = stateCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(CameraCaptureSession cameraCaptureSession) {
            this.a.onActive(cameraCaptureSession);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(CameraCaptureSession cameraCaptureSession) {
            AbstractC10024ax.a(this.a, cameraCaptureSession);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(CameraCaptureSession cameraCaptureSession) {
            this.a.onClosed(cameraCaptureSession);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(CameraCaptureSession cameraCaptureSession) {
            this.a.onConfigureFailed(cameraCaptureSession);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(CameraCaptureSession cameraCaptureSession) {
            this.a.onConfigured(cameraCaptureSession);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(CameraCaptureSession cameraCaptureSession) {
            this.a.onReady(cameraCaptureSession);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(CameraCaptureSession cameraCaptureSession, Surface surface) {
            AbstractC8932Xw.a(this.a, cameraCaptureSession, surface);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(final CameraCaptureSession cameraCaptureSession) {
            this.b.execute(new Runnable() { // from class: ir.nasim.bC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(final CameraCaptureSession cameraCaptureSession) {
            this.b.execute(new Runnable() { // from class: ir.nasim.eC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(final CameraCaptureSession cameraCaptureSession) {
            this.b.execute(new Runnable() { // from class: ir.nasim.cC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(final CameraCaptureSession cameraCaptureSession) {
            this.b.execute(new Runnable() { // from class: ir.nasim.hC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(final CameraCaptureSession cameraCaptureSession) {
            this.b.execute(new Runnable() { // from class: ir.nasim.fC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(final CameraCaptureSession cameraCaptureSession) {
            this.b.execute(new Runnable() { // from class: ir.nasim.gC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(final CameraCaptureSession cameraCaptureSession, final Surface surface) {
            this.b.execute(new Runnable() { // from class: ir.nasim.dC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(cameraCaptureSession, surface);
                }
            });
        }
    }

    private TB0(CameraCaptureSession cameraCaptureSession, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new C14614iC0(cameraCaptureSession);
        } else {
            this.a = C15212jC0.d(cameraCaptureSession, handler);
        }
    }

    public static TB0 d(CameraCaptureSession cameraCaptureSession, Handler handler) {
        return new TB0(cameraCaptureSession, handler);
    }

    public int a(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.b(list, executor, captureCallback);
    }

    public int b(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.c(captureRequest, executor, captureCallback);
    }

    public CameraCaptureSession c() {
        return this.a.a();
    }
}
