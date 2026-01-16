package ir.nasim.features.libphotovideo.Paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.TextureView;
import ir.nasim.AbstractC17682nN7;
import ir.nasim.C16983mB7;
import ir.nasim.C19406qI3;
import ir.nasim.C19905r83;
import ir.nasim.InterfaceC13156fl0;
import ir.nasim.NZ;
import ir.nasim.YB2;
import ir.nasim.features.libphotovideo.Paint.a;
import ir.nasim.features.media.components.Size;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes3.dex */
public class RenderView extends TextureView {
    private f a;
    private C16983mB7 b;
    private NZ c;
    private ir.nasim.features.libphotovideo.Paint.a d;
    private e e;
    private C19905r83 f;
    private Bitmap g;
    private boolean h;
    private int i;
    private float j;
    private int k;
    private InterfaceC13156fl0 l;
    private boolean m;

    class a implements TextureView.SurfaceTextureListener {

        /* renamed from: ir.nasim.features.libphotovideo.Paint.RenderView$a$a, reason: collision with other inner class name */
        class RunnableC1169a implements Runnable {
            RunnableC1169a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (RenderView.this.e != null) {
                    RenderView.this.e.q();
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RenderView.this.e.shutdown();
                RenderView.this.e = null;
            }
        }

        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (surfaceTexture == null || RenderView.this.e != null) {
                return;
            }
            RenderView.this.e = RenderView.this.new e(surfaceTexture);
            RenderView.this.e.s(i, i2);
            RenderView.this.t();
            RenderView.this.e.q();
            if (RenderView.this.d.I()) {
                RenderView.this.d.L();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (RenderView.this.e != null && !RenderView.this.m) {
                RenderView.this.d.K(new b());
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (RenderView.this.e == null) {
                return;
            }
            RenderView.this.e.s(i, i2);
            RenderView.this.t();
            RenderView.this.e.q();
            RenderView.this.e.postRunnable(new RunnableC1169a());
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class b implements a.g {
        b() {
        }

        @Override // ir.nasim.features.libphotovideo.Paint.a.g
        public C16983mB7 a() {
            return RenderView.this.b;
        }

        @Override // ir.nasim.features.libphotovideo.Paint.a.g
        public void b() throws InterruptedException {
            if (RenderView.this.e != null) {
                RenderView.this.e.r();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RenderView.this.d.z(RenderView.this.h);
            RenderView.this.e.shutdown();
            RenderView.this.e = null;
        }
    }

    class d implements Runnable {
        final /* synthetic */ Runnable a;

        d(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RenderView.this.e == null || !RenderView.this.e.n) {
                return;
            }
            RenderView.this.e.t();
            this.a.run();
        }
    }

    private class e extends NZ {
        private final int f;
        private final int g;
        private SurfaceTexture h;
        private EGL10 i;
        private EGLDisplay j;
        private EGLConfig k;
        private EGLContext l;
        private EGLSurface m;
        private boolean n;
        private boolean o;
        private int p;
        private int q;
        private Runnable r;
        private Runnable s;

        class a implements Runnable {

            /* renamed from: ir.nasim.features.libphotovideo.Paint.RenderView$e$a$a, reason: collision with other inner class name */
            class RunnableC1170a implements Runnable {
                RunnableC1170a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    e.this.o = true;
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                if (!e.this.n || RenderView.this.m) {
                    return;
                }
                e.this.t();
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glViewport(0, 0, e.this.p, e.this.q);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
                RenderView.this.d.O();
                GLES20.glBlendFunc(1, 771);
                e.this.i.eglSwapBuffers(e.this.j, e.this.m);
                if (e.this.o) {
                    return;
                }
                RenderView.this.c.postRunnable(new RunnableC1170a(), 200L);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.s.run();
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.r = null;
                e.this.s.run();
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.finish();
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    looperMyLooper.quit();
                }
            }
        }

        /* renamed from: ir.nasim.features.libphotovideo.Paint.RenderView$e$e, reason: collision with other inner class name */
        class RunnableC1171e implements Runnable {
            final /* synthetic */ Bitmap[] a;
            final /* synthetic */ CountDownLatch b;

            RunnableC1171e(Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
                this.a = bitmapArr;
                this.b = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a[0] = RenderView.this.d.E(new RectF(0.0f, 0.0f, RenderView.this.d.G().width, RenderView.this.d.G().height), false).a;
                this.b.countDown();
            }
        }

        public e(SurfaceTexture surfaceTexture) {
            super("Q_RV_Canvas");
            this.f = 12440;
            this.g = 4;
            this.s = new a();
            this.h = surfaceTexture;
        }

        private void n() {
            Size sizeG = RenderView.this.d.G();
            if (RenderView.this.g.getWidth() == sizeG.width && RenderView.this.g.getHeight() == sizeG.height && RenderView.this.i == 0) {
                return;
            }
            float width = RenderView.this.g.getWidth();
            if (RenderView.this.i % 360 == 90 || RenderView.this.i % 360 == 270) {
                width = RenderView.this.g.getHeight();
            }
            float f = sizeG.width / width;
            RenderView renderView = RenderView.this;
            renderView.g = o(renderView.g, f);
            RenderView.this.i = 0;
            RenderView.this.h = true;
        }

        private Bitmap o(Bitmap bitmap, float f) {
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            matrix.postRotate(RenderView.this.i);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }

        private boolean p() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.i = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.j = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                C19406qI3.b("baleMessages", "eglGetDisplay failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            if (!this.i.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                C19406qI3.b("baleMessages", "eglInitialize failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.i.eglChooseConfig(this.j, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                C19406qI3.b("baleMessages", "eglChooseConfig failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            if (iArr[0] <= 0) {
                C19406qI3.b("baleMessages", "eglConfig not initialized");
                finish();
                return false;
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            this.k = eGLConfig;
            EGLContext eGLContextEglCreateContext = this.i.eglCreateContext(this.j, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.l = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext == null) {
                C19406qI3.b("baleMessages", "eglCreateContext failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            SurfaceTexture surfaceTexture = this.h;
            if (!(surfaceTexture instanceof SurfaceTexture)) {
                finish();
                return false;
            }
            EGLSurface eGLSurfaceEglCreateWindowSurface = this.i.eglCreateWindowSurface(this.j, this.k, surfaceTexture, null);
            this.m = eGLSurfaceEglCreateWindowSurface;
            if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                C19406qI3.b("baleMessages", "createWindowSurface failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            if (!this.i.eglMakeCurrent(this.j, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.l)) {
                C19406qI3.b("baleMessages", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            GLES20.glEnable(3042);
            GLES20.glDisable(3024);
            GLES20.glDisable(2960);
            GLES20.glDisable(2929);
            RenderView.this.d.X();
            n();
            RenderView.this.d.S(RenderView.this.g);
            AbstractC17682nN7.a();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean t() {
            if (!this.n) {
                return false;
            }
            if (this.l.equals(this.i.eglGetCurrentContext()) && this.m.equals(this.i.eglGetCurrentSurface(12377))) {
                return true;
            }
            EGL10 egl10 = this.i;
            EGLDisplay eGLDisplay = this.j;
            EGLSurface eGLSurface = this.m;
            return egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.l);
        }

        public void finish() {
            if (this.m != null) {
                EGL10 egl10 = this.i;
                EGLDisplay eGLDisplay = this.j;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                this.i.eglDestroySurface(this.j, this.m);
                this.m = null;
            }
            EGLContext eGLContext = this.l;
            if (eGLContext != null) {
                this.i.eglDestroyContext(this.j, eGLContext);
                this.l = null;
            }
            EGLDisplay eGLDisplay2 = this.j;
            if (eGLDisplay2 != null) {
                this.i.eglTerminate(eGLDisplay2);
                this.j = null;
            }
        }

        public Bitmap getTexture() throws InterruptedException {
            if (!this.n) {
                return null;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Bitmap[] bitmapArr = new Bitmap[1];
            try {
                postRunnable(new RunnableC1171e(bitmapArr, countDownLatch));
                countDownLatch.await();
            } catch (Exception e) {
                C19406qI3.b("baleMessages", e.getMessage());
            }
            return bitmapArr[0];
        }

        public void q() {
            postRunnable(new b());
        }

        public void r() throws InterruptedException {
            Runnable runnable = this.r;
            if (runnable != null) {
                cancelRunnable(runnable);
                this.r = null;
            }
            c cVar = new c();
            this.r = cVar;
            postRunnable(cVar, 1L);
        }

        @Override // ir.nasim.NZ, java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            if (RenderView.this.g == null || RenderView.this.g.isRecycled()) {
                return;
            }
            this.n = p();
            super.run();
        }

        public void s(int i, int i2) {
            this.p = i;
            this.q = i2;
        }

        public void shutdown() {
            postRunnable(new d());
        }
    }

    public interface f {
        boolean a();

        void b(boolean z);

        void c();
    }

    public RenderView(Context context, ir.nasim.features.libphotovideo.Paint.a aVar, Bitmap bitmap, int i) {
        super(context);
        this.g = bitmap;
        this.i = i;
        this.d = aVar;
        aVar.W(this);
        setSurfaceTextureListener(new a());
        this.f = new C19905r83(this);
        this.d.U(new b());
    }

    private float n(float f2) {
        float f3 = this.d.G().width;
        return (0.00390625f * f3) + (f3 * 0.043945312f * f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Matrix matrix = new Matrix();
        float width = this.d != null ? getWidth() / this.d.G().width : 1.0f;
        float f2 = width > 0.0f ? width : 1.0f;
        Size sizeG = getPainting().G();
        matrix.preTranslate(getWidth() / 2.0f, getHeight() / 2.0f);
        matrix.preScale(f2, -f2);
        matrix.preTranslate((-sizeG.width) / 2.0f, (-sizeG.height) / 2.0f);
        this.f.f(matrix);
        this.d.V(YB2.c(YB2.b(0.0f, this.e.p, 0.0f, this.e.q, -1.0f, 1.0f), YB2.a(matrix)));
    }

    public InterfaceC13156fl0 getCurrentBrush() {
        return this.l;
    }

    public int getCurrentColor() {
        return this.k;
    }

    public float getCurrentWeight() {
        return this.j;
    }

    public ir.nasim.features.libphotovideo.Paint.a getPainting() {
        return this.d;
    }

    public Bitmap getResultBitmap() {
        e eVar = this.e;
        if (eVar != null) {
            return eVar.getTexture();
        }
        return null;
    }

    public void o() {
        f fVar = this.a;
        if (fVar != null) {
            fVar.c();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        e eVar = this.e;
        if (eVar != null && eVar.n && this.e.o) {
            this.f.d(motionEvent);
        }
        return true;
    }

    public void p(boolean z) {
        f fVar = this.a;
        if (fVar != null) {
            fVar.b(z);
        }
    }

    public void q(Runnable runnable) {
        e eVar = this.e;
        if (eVar == null) {
            return;
        }
        eVar.postRunnable(new d(runnable));
    }

    public boolean r() {
        f fVar = this.a;
        return fVar == null || fVar.a();
    }

    public void s() {
        this.m = true;
        if (this.e != null) {
            q(new c());
        }
        setVisibility(8);
    }

    public void setBrush(InterfaceC13156fl0 interfaceC13156fl0) {
        ir.nasim.features.libphotovideo.Paint.a aVar = this.d;
        this.l = interfaceC13156fl0;
        aVar.T(interfaceC13156fl0);
    }

    public void setBrushSize(float f2) {
        this.j = n(f2);
    }

    public void setColor(int i) {
        this.k = i;
    }

    public void setDelegate(f fVar) {
        this.a = fVar;
    }

    public void setQueue(NZ nz) {
        this.c = nz;
    }

    public void setUndoStore(C16983mB7 c16983mB7) {
        this.b = c16983mB7;
    }
}
