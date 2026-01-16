package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.view.PreviewView;
import androidx.camera.view.i;
import androidx.camera.view.n;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterfaceFutureC15215jC3;
import ir.nasim.PI3;
import ir.nasim.WB2;
import ir.nasim.Z27;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class n extends i {
    SurfaceView e;
    final b f;

    private static class a {
        static void a(SurfaceView surfaceView, Bitmap bitmap, PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, Handler handler) {
            PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
        }
    }

    class b implements SurfaceHolder.Callback {
        private Size a;
        private Z27 b;
        private Z27 c;
        private i.a d;
        private Size e;
        private boolean f = false;
        private boolean g = false;

        b() {
        }

        private boolean b() {
            return (this.f || this.b == null || !Objects.equals(this.a, this.e)) ? false : true;
        }

        private void c() {
            if (this.b != null) {
                PI3.a("SurfaceViewImpl", "Request canceled: " + this.b);
                this.b.E();
            }
        }

        private void d() {
            if (this.b != null) {
                PI3.a("SurfaceViewImpl", "Surface closed " + this.b);
                this.b.m().d();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(i.a aVar, Z27.g gVar) {
            PI3.a("SurfaceViewImpl", "Safe to release surface.");
            if (aVar != null) {
                aVar.a();
            }
        }

        private boolean g() throws ExecutionException, InterruptedException {
            Surface surface = n.this.e.getHolder().getSurface();
            if (!b()) {
                return false;
            }
            PI3.a("SurfaceViewImpl", "Surface set on Preview.");
            final i.a aVar = this.d;
            Z27 z27 = this.b;
            Objects.requireNonNull(z27);
            z27.B(surface, AbstractC4043Dl1.i(n.this.e.getContext()), new InterfaceC25043ze1() { // from class: androidx.camera.view.o
                @Override // ir.nasim.InterfaceC25043ze1
                public final void accept(Object obj) {
                    n.b.e(aVar, (Z27.g) obj);
                }
            });
            this.f = true;
            n.this.f();
            return true;
        }

        void f(Z27 z27, i.a aVar) {
            c();
            if (this.g) {
                this.g = false;
                z27.q();
                return;
            }
            this.b = z27;
            this.d = aVar;
            Size sizeO = z27.o();
            this.a = sizeO;
            this.f = false;
            if (g()) {
                return;
            }
            PI3.a("SurfaceViewImpl", "Wait for new Surface creation.");
            n.this.e.getHolder().setFixedSize(sizeO.getWidth(), sizeO.getHeight());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) throws ExecutionException, InterruptedException {
            PI3.a("SurfaceViewImpl", "Surface changed. Size: " + i2 + "x" + i3);
            this.e = new Size(i2, i3);
            g();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Z27 z27;
            PI3.a("SurfaceViewImpl", "Surface created.");
            if (!this.g || (z27 = this.c) == null) {
                return;
            }
            z27.q();
            this.c = null;
            this.g = false;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            PI3.a("SurfaceViewImpl", "Surface destroyed.");
            if (this.f) {
                d();
            } else {
                c();
            }
            this.g = true;
            Z27 z27 = this.b;
            if (z27 != null) {
                this.c = z27;
            }
            this.f = false;
            this.b = null;
            this.d = null;
            this.e = null;
            this.a = null;
        }
    }

    n(FrameLayout frameLayout, e eVar) {
        super(frameLayout, eVar);
        this.f = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Semaphore semaphore, int i) {
        if (i == 0) {
            PI3.a("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
        } else {
            PI3.c("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i);
        }
        semaphore.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Z27 z27, i.a aVar) {
        this.f.f(z27, aVar);
    }

    private static boolean p(SurfaceView surfaceView, Size size, Z27 z27) {
        return surfaceView != null && Objects.equals(size, z27.o());
    }

    @Override // androidx.camera.view.i
    View b() {
        return this.e;
    }

    @Override // androidx.camera.view.i
    Bitmap c() {
        SurfaceView surfaceView = this.e;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.e.getHolder().getSurface().isValid()) {
            return null;
        }
        final Semaphore semaphore = new Semaphore(0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        a.a(this.e, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.camera.view.m
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                n.n(semaphore, i);
            }
        }, new Handler(handlerThread.getLooper()));
        try {
            try {
                if (!semaphore.tryAcquire(1, 100L, TimeUnit.MILLISECONDS)) {
                    PI3.c("SurfaceViewImpl", "Timed out while trying to acquire screenshot.");
                }
            } catch (InterruptedException e) {
                PI3.d("SurfaceViewImpl", "Interrupted while trying to acquire screenshot.", e);
            }
            return bitmapCreateBitmap;
        } finally {
            handlerThread.quitSafely();
        }
    }

    @Override // androidx.camera.view.i
    void d() {
    }

    @Override // androidx.camera.view.i
    void e() {
    }

    @Override // androidx.camera.view.i
    void g(final Z27 z27, final i.a aVar) {
        if (!p(this.e, this.a, z27)) {
            this.a = z27.o();
            m();
        }
        if (aVar != null) {
            z27.j(AbstractC4043Dl1.i(this.e.getContext()), new Runnable() { // from class: androidx.camera.view.k
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a();
                }
            });
        }
        this.e.post(new Runnable() { // from class: androidx.camera.view.l
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(z27, aVar);
            }
        });
    }

    @Override // androidx.camera.view.i
    void i(Executor executor, PreviewView.d dVar) {
        throw new IllegalArgumentException("SurfaceView doesn't support frame update listener");
    }

    @Override // androidx.camera.view.i
    InterfaceFutureC15215jC3 j() {
        return WB2.l(null);
    }

    void m() {
        AbstractC4980Hj5.g(this.b);
        AbstractC4980Hj5.g(this.a);
        SurfaceView surfaceView = new SurfaceView(this.b.getContext());
        this.e = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
        this.b.removeAllViews();
        this.b.addView(this.e);
        this.e.getHolder().addCallback(this.f);
    }
}
