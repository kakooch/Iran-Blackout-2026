package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.TextureView;
import ir.nasim.AbstractC18273oN7;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C17574nB7;
import ir.nasim.HU1;
import ir.nasim.SD6;
import ir.nasim.XB2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.a;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.d;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes7.dex */
public class RenderView extends TextureView {
    private d a;
    private C17574nB7 b;
    private HU1 c;
    private ir.nasim.tgwidgets.editor.ui.Components.Paint.d d;
    private c e;
    private ir.nasim.tgwidgets.editor.ui.Components.Paint.b f;
    private s g;
    private Bitmap h;
    private boolean i;
    private boolean j;
    private float k;
    private int l;
    private ir.nasim.tgwidgets.editor.ui.Components.Paint.a m;
    private boolean n;

    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (RenderView.this.e != null) {
                RenderView.this.e.H();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            RenderView.this.e.L();
            RenderView.this.e = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            if (RenderView.this.e != null) {
                RenderView.this.e.H();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (surfaceTexture == null || RenderView.this.e != null) {
                return;
            }
            RenderView.this.e = RenderView.this.new c(surfaceTexture);
            RenderView.this.e.J(i, i2);
            RenderView.this.I();
            RenderView.this.post(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d();
                }
            });
            if (RenderView.this.d.W()) {
                RenderView.this.d.n0();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (RenderView.this.e != null && !RenderView.this.n) {
                RenderView.this.d.m0(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e();
                    }
                });
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (RenderView.this.e == null) {
                return;
            }
            RenderView.this.e.J(i, i2);
            RenderView.this.I();
            RenderView.this.e.H();
            RenderView.this.e.i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class b implements d.InterfaceC1590d {
        b() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.d.InterfaceC1590d
        public C17574nB7 a() {
            return RenderView.this.b;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.d.InterfaceC1590d
        public void b() throws InterruptedException {
            if (RenderView.this.e != null) {
                RenderView.this.e.I();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.d.InterfaceC1590d
        public HU1 c() {
            return RenderView.this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c extends HU1 {
        private SurfaceTexture g;
        private EGL10 h;
        private EGLDisplay i;
        private EGLContext j;
        private EGLSurface k;
        private boolean l;
        private volatile boolean m;
        private int n;
        private int o;
        private Runnable p;
        private Runnable q;

        class a implements Runnable {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                RenderView.this.a.e();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!c.this.l || RenderView.this.n) {
                    return;
                }
                c.this.K();
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glViewport(0, 0, c.this.n, c.this.o);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
                RenderView.this.d.s0();
                GLES20.glBlendFunc(1, 771);
                c.this.h.eglSwapBuffers(c.this.i, c.this.k);
                if (!RenderView.this.j) {
                    RenderView.this.j = true;
                    AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.b();
                        }
                    });
                }
                if (c.this.m) {
                    return;
                }
                c.this.m = true;
            }
        }

        public c(SurfaceTexture surfaceTexture) {
            super("CanvasInternal");
            this.q = new a();
            this.g = surfaceTexture;
        }

        private boolean C() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.h = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.i = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                A();
                return false;
            }
            if (!this.h.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglInitialize failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                A();
                return false;
            }
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.h.eglChooseConfig(this.i, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                A();
                return false;
            }
            if (iArr[0] <= 0) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglConfig not initialized");
                }
                A();
                return false;
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eGLContextEglCreateContext = this.h.eglCreateContext(this.i, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.j = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext == null) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglCreateContext failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                A();
                return false;
            }
            SurfaceTexture surfaceTexture = this.g;
            if (!(surfaceTexture instanceof SurfaceTexture)) {
                A();
                return false;
            }
            EGLSurface eGLSurfaceEglCreateWindowSurface = this.h.eglCreateWindowSurface(this.i, eGLConfig, surfaceTexture, null);
            this.k = eGLSurfaceEglCreateWindowSurface;
            if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("createWindowSurface failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                A();
                return false;
            }
            if (!this.h.eglMakeCurrent(this.i, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.j)) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                A();
                return false;
            }
            GLES20.glEnable(3042);
            GLES20.glDisable(3024);
            GLES20.glDisable(2960);
            GLES20.glDisable(2929);
            RenderView.this.d.E0();
            z();
            RenderView.this.d.y0(RenderView.this.h);
            AbstractC18273oN7.a();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
            d.c cVarS = RenderView.this.d.S(new RectF(0.0f, 0.0f, RenderView.this.d.U().a, RenderView.this.d.U().b), false);
            if (cVarS != null) {
                bitmapArr[0] = cVarS.a;
            }
            countDownLatch.countDown();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E() {
            this.q.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void F() {
            this.p = null;
            this.q.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void G() {
            A();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null) {
                looperMyLooper.quit();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean K() {
            if (!this.l) {
                return false;
            }
            if (this.j.equals(this.h.eglGetCurrentContext()) && this.k.equals(this.h.eglGetCurrentSurface(12377))) {
                return true;
            }
            EGL10 egl10 = this.h;
            EGLDisplay eGLDisplay = this.i;
            EGLSurface eGLSurface = this.k;
            return egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.j);
        }

        private void z() {
            SD6 sd6U = RenderView.this.d.U();
            if (RenderView.this.h.getWidth() == sd6U.a && RenderView.this.h.getHeight() == sd6U.b) {
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) sd6U.a, (int) sd6U.b, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(RenderView.this.h, (Rect) null, new RectF(0.0f, 0.0f, sd6U.a, sd6U.b), (Paint) null);
            RenderView.this.h = bitmapCreateBitmap;
            RenderView.this.i = true;
        }

        public void A() {
            if (this.k != null) {
                EGL10 egl10 = this.h;
                EGLDisplay eGLDisplay = this.i;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                this.h.eglDestroySurface(this.i, this.k);
                this.k = null;
            }
            EGLContext eGLContext = this.j;
            if (eGLContext != null) {
                this.h.eglDestroyContext(this.i, eGLContext);
                this.j = null;
            }
            EGLDisplay eGLDisplay2 = this.i;
            if (eGLDisplay2 != null) {
                this.h.eglTerminate(eGLDisplay2);
                this.i = null;
            }
        }

        public Bitmap B() throws InterruptedException {
            if (!this.l) {
                return null;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Bitmap[] bitmapArr = new Bitmap[1];
            try {
                i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.D(bitmapArr, countDownLatch);
                    }
                });
                countDownLatch.await();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
            return bitmapArr[0];
        }

        public void H() {
            i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.E();
                }
            });
        }

        public void I() throws InterruptedException {
            Runnable runnable = this.p;
            if (runnable != null) {
                b(runnable);
                this.p = null;
            }
            Runnable runnable2 = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.F();
                }
            };
            this.p = runnable2;
            j(runnable2, 1L);
        }

        public void J(int i, int i2) {
            this.n = i;
            this.o = i2;
        }

        public void L() {
            i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.Paint.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.G();
                }
            });
        }

        @Override // ir.nasim.HU1, java.lang.Thread, java.lang.Runnable
        public void run() {
            if (RenderView.this.h == null || RenderView.this.h.isRecycled()) {
                return;
            }
            this.l = C();
            super.run();
        }
    }

    public interface d {
        boolean a();

        void b(boolean z);

        void c();

        void d();

        void e();

        void f();
    }

    public RenderView(Context context, ir.nasim.tgwidgets.editor.ui.Components.Paint.d dVar, Bitmap bitmap) {
        super(context);
        setOpaque(false);
        this.h = bitmap;
        this.d = dVar;
        dVar.D0(this);
        setSurfaceTextureListener(new a());
        this.f = new ir.nasim.tgwidgets.editor.ui.Components.Paint.b(this);
        this.g = new s(this, new Runnable() { // from class: ir.nasim.yO5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v();
            }
        });
        this.d.A0(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.e == null) {
            return;
        }
        Matrix matrix = new Matrix();
        float width = this.d != null ? getWidth() / this.d.U().a : 1.0f;
        float f = width > 0.0f ? width : 1.0f;
        SD6 sd6U = getPainting().U();
        matrix.preTranslate(getWidth() / 2.0f, getHeight() / 2.0f);
        matrix.preScale(f, -f);
        matrix.preTranslate((-sd6U.a) / 2.0f, (-sd6U.b) / 2.0f);
        if (this.m instanceof a.g) {
            this.g.q(matrix);
        } else {
            this.f.x(matrix);
        }
        this.d.C0(XB2.c(XB2.b(0.0f, this.e.n, 0.0f, this.e.o, -1.0f, 1.0f), XB2.a(matrix)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.d.z0(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Runnable runnable) {
        c cVar = this.e;
        if (cVar == null || !cVar.l) {
            return;
        }
        this.e.K();
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        this.d.F(this.i);
        this.e.L();
        this.e = null;
    }

    public void A(boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    public boolean B(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        c cVar = this.e;
        if (cVar != null && cVar.l && this.e.m) {
            if (this.m instanceof a.g) {
                this.g.n(motionEvent, getScaleX());
            } else {
                this.f.v(motionEvent, getScaleX());
            }
        }
        return true;
    }

    public void C(final Runnable runnable) {
        c cVar = this.e;
        if (cVar == null) {
            return;
        }
        cVar.i(new Runnable() { // from class: ir.nasim.wO5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w(runnable);
            }
        });
    }

    public void D() {
        c cVar = this.e;
        if (cVar == null) {
            return;
        }
        cVar.H();
    }

    public void E() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.f();
        }
        this.f.m();
    }

    protected void F(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar) {
    }

    public boolean G() {
        d dVar = this.a;
        return dVar == null || dVar.a();
    }

    public void H() {
        this.n = true;
        if (this.e != null) {
            C(new Runnable() { // from class: ir.nasim.vO5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.x();
                }
            });
        }
        setVisibility(8);
    }

    public ir.nasim.tgwidgets.editor.ui.Components.Paint.a getCurrentBrush() {
        return this.m;
    }

    public int getCurrentColor() {
        return this.l;
    }

    public float getCurrentWeight() {
        return this.k;
    }

    public ir.nasim.tgwidgets.editor.ui.Components.Paint.d getPainting() {
        return this.d;
    }

    public Bitmap getResultBitmap() {
        if (this.m instanceof a.g) {
            this.g.s();
        }
        c cVar = this.e;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    public C17574nB7 getUndoStore() {
        return this.b;
    }

    public float r(float f) {
        float f2 = this.d.U().a;
        return (0.00390625f * f2) + (f2 * 0.043945312f * f);
    }

    public void s() {
        this.f.k(new Runnable() { // from class: ir.nasim.xO5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.u();
            }
        });
    }

    public void setBrush(ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar) {
        if (this.m instanceof a.g) {
            this.g.s();
        }
        this.m = aVar;
        I();
        this.d.z0(this.m);
        ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar2 = this.m;
        if (aVar2 instanceof a.g) {
            this.g.r(((a.g) aVar2).p());
        }
    }

    public void setBrushSize(float f) {
        this.k = r(f);
        if (this.m instanceof a.g) {
            this.g.m();
        }
    }

    public void setColor(int i) {
        this.l = i;
        if (this.m instanceof a.g) {
            this.g.l();
        }
    }

    public void setDelegate(d dVar) {
        this.a = dVar;
    }

    public void setQueue(HU1 hu1) {
        this.c = hu1;
    }

    public void setUndoStore(C17574nB7 c17574nB7) {
        this.b = c17574nB7;
    }

    public void t() {
        s sVar = this.g;
        if (sVar != null) {
            sVar.f();
        }
    }

    public void y() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void z(Canvas canvas) {
        if (this.m instanceof a.g) {
            this.g.g(canvas);
        }
    }
}
