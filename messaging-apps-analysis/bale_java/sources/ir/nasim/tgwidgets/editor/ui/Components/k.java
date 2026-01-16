package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Looper;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.HU1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.l;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes7.dex */
public class k extends HU1 {
    private boolean A;
    private boolean A0;
    private int B;
    private Runnable B0;
    private int D;
    private int G;
    private int H;
    private FloatBuffer J;
    private boolean Y;
    private long Z;
    private SurfaceTexture g;
    private EGL10 h;
    private EGLDisplay i;
    private EGLContext j;
    private EGLSurface k;
    private boolean l;
    private volatile int m;
    private volatile int n;
    private Bitmap o;
    private int p;
    private SurfaceTexture q;
    private boolean r;
    private float[] s;
    private int[] t;
    private boolean u;
    private l v;
    private int w;
    private int x;
    private int y;
    private int z;
    private b z0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.l) {
                k.this.k0();
                if (k.this.r) {
                    k.this.q.updateTexImage();
                    k.this.q.getTransformMatrix(k.this.s);
                    k.this.o0();
                    k.this.r = false;
                    k.this.v.t(k.this.s);
                    k.this.u = true;
                }
                if (k.this.Y) {
                    if (k.this.z0 == null || k.this.u) {
                        GLES20.glViewport(0, 0, k.this.B, k.this.D);
                        k.this.v.i();
                        k.this.v.g();
                        if (k.this.z0 == null) {
                            k.this.v.h();
                        }
                        k.this.v.f();
                        k kVar = k.this;
                        kVar.A = kVar.v.e();
                        k.this.A0 = true;
                    }
                    if (k.this.A0) {
                        GLES20.glViewport(0, 0, k.this.m, k.this.n);
                        GLES20.glBindFramebuffer(36160, 0);
                        GLES20.glUseProgram(k.this.w);
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, k.this.v.o(1 ^ (k.this.A ? 1 : 0)));
                        GLES20.glUniform1i(k.this.z, 0);
                        GLES20.glEnableVertexAttribArray(k.this.y);
                        GLES20.glVertexAttribPointer(k.this.y, 2, 5126, false, 8, (Buffer) (k.this.J != null ? k.this.J : k.this.v.p()));
                        GLES20.glEnableVertexAttribArray(k.this.x);
                        GLES20.glVertexAttribPointer(k.this.x, 2, 5126, false, 8, (Buffer) k.this.v.q());
                        GLES20.glDrawArrays(5, 0, 4);
                        k.this.h.eglSwapBuffers(k.this.i, k.this.k);
                    }
                }
            }
        }
    }

    public interface b {
        void a(SurfaceTexture surfaceTexture);
    }

    public k(SurfaceTexture surfaceTexture, Bitmap bitmap, int i, boolean z, l.b bVar, boolean z2) {
        super("PhotoFilterGLThread", false);
        this.s = new float[16];
        this.t = new int[1];
        this.B0 = new a();
        this.g = surfaceTexture;
        this.o = bitmap;
        this.p = i;
        l lVar = new l(false, bVar);
        this.v = lVar;
        lVar.x(z2);
        float[] fArr = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        if (z) {
            fArr[2] = 0.0f;
            fArr[0] = 1.0f;
            fArr[6] = 0.0f;
            fArr[4] = 1.0f;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.J = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr);
        this.J.position(0);
        start();
    }

    private Bitmap Y() {
        int i;
        int i2 = this.B;
        if (i2 == 0 || (i = this.D) == 0) {
            return null;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i2 * i * 4);
        GLES20.glReadPixels(0, 0, this.B, this.D, 6408, 5121, byteBufferAllocateDirect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.B, this.D, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        return bitmapCreateBitmap;
    }

    private boolean a0() {
        int width;
        int height;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.h = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.i = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
            }
            X();
            return false;
        }
        if (!this.h.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("eglInitialize failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
            }
            X();
            return false;
        }
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.h.eglChooseConfig(this.i, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
            }
            X();
            return false;
        }
        if (iArr[0] <= 0) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("eglConfig not initialized");
            }
            X();
            return false;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = this.h.eglCreateContext(this.i, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        this.j = eGLContextEglCreateContext;
        if (eGLContextEglCreateContext == null) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("eglCreateContext failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
            }
            X();
            return false;
        }
        SurfaceTexture surfaceTexture = this.g;
        if (!(surfaceTexture instanceof SurfaceTexture)) {
            X();
            return false;
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = this.h.eglCreateWindowSurface(this.i, eGLConfig, surfaceTexture, null);
        this.k = eGLSurfaceEglCreateWindowSurface;
        if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("createWindowSurface failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
            }
            X();
            return false;
        }
        if (!this.h.eglMakeCurrent(this.i, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.j)) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
            }
            X();
            return false;
        }
        int iR = l.r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
        int iR2 = l.r(35632, "varying highp vec2 vTextureCoord;uniform sampler2D sTexture;void main() {gl_FragColor = texture2D(sTexture, vTextureCoord);}");
        if (iR == 0 || iR2 == 0) {
            return false;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.w = iGlCreateProgram;
        GLES20.glAttachShader(iGlCreateProgram, iR);
        GLES20.glAttachShader(this.w, iR2);
        GLES20.glBindAttribLocation(this.w, 0, "position");
        GLES20.glBindAttribLocation(this.w, 1, "inputTexCoord");
        GLES20.glLinkProgram(this.w);
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(this.w, 35714, iArr2, 0);
        if (iArr2[0] == 0) {
            GLES20.glDeleteProgram(this.w);
            this.w = 0;
        } else {
            this.x = GLES20.glGetAttribLocation(this.w, "position");
            this.y = GLES20.glGetAttribLocation(this.w, "inputTexCoord");
            this.z = GLES20.glGetUniformLocation(this.w, "sourceImage");
        }
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            width = bitmap.getWidth();
            height = this.o.getHeight();
        } else {
            width = this.G;
            height = this.H;
        }
        int i = width;
        int i2 = height;
        if (this.z0 != null) {
            GLES20.glGenTextures(1, this.t, 0);
            Matrix.setIdentityM(this.s, 0);
            SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.t[0]);
            this.q = surfaceTexture2;
            surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ir.nasim.eo2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture3) {
                    this.a.c0(surfaceTexture3);
                }
            });
            GLES20.glBindTexture(36197, this.t[0]);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.fo2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d0();
                }
            });
        }
        if (!this.v.c()) {
            X();
            return false;
        }
        if (i != 0 && i2 != 0) {
            this.v.w(this.o, this.p, this.t[0], i, i2);
            this.Y = true;
            this.B = this.v.m();
            this.D = this.v.l();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
        GLES20.glBindFramebuffer(36160, this.v.n());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.v.o(!this.A ? 1 : 0), 0);
        GLES20.glClear(0);
        bitmapArr[0] = Y();
        countDownLatch.countDown();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClear(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(SurfaceTexture surfaceTexture) {
        m0(false, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0() {
        this.z0.a(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.v.u();
        }
        if (z2) {
            this.r = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z3 || Math.abs(this.Z - jCurrentTimeMillis) > 30) {
            this.Z = jCurrentTimeMillis;
            this.B0.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(l.c cVar) {
        this.v.v(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(int i, int i2) {
        this.m = i;
        this.n = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(int i, int i2) {
        if (this.G == i && this.H == i2) {
            return;
        }
        this.G = i;
        this.H = i2;
        int iH = AbstractC8662Wx6.h();
        int iMin = 1920;
        if (iH != 1) {
            if (iH != 2) {
                iMin = SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE;
            } else {
                Point point = AbstractC21455b.h;
                iMin = Math.min(1920, Math.max(point.x, point.y));
            }
        }
        int i3 = this.G;
        if (i3 > iMin || this.H > iMin) {
            int i4 = this.H;
            if (i3 > i4) {
                this.H = (int) (i4 / (iMin / i3));
                this.G = iMin;
            } else {
                this.G = (int) (i3 / (iMin / i4));
                this.H = iMin;
            }
        }
        this.Y = false;
        o0();
        this.B0.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        X();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(l.b bVar) {
        k0();
        this.v.z(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        if (this.j.equals(this.h.eglGetCurrentContext()) && this.k.equals(this.h.eglGetCurrentSurface(12377))) {
            return;
        }
        EGL10 egl10 = this.h;
        EGLDisplay eGLDisplay = this.i;
        EGLSurface eGLSurface = this.k;
        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.j) || !AbstractC8814Xl0.b) {
            return;
        }
        AbstractC6403Nl2.b("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        int i;
        int i2;
        if (this.Y || (i = this.G) <= 0 || (i2 = this.H) <= 0) {
            return;
        }
        this.v.w(this.o, this.p, this.t[0], i, i2);
        this.Y = true;
        this.B = this.v.m();
        this.D = this.v.l();
    }

    public void X() {
        this.o = null;
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
        SurfaceTexture surfaceTexture = this.g;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public Bitmap Z() throws InterruptedException {
        if (!this.l || !isAlive()) {
            return null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Bitmap[] bitmapArr = new Bitmap[1];
        try {
            if (i(new Runnable() { // from class: ir.nasim.co2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b0(bitmapArr, countDownLatch);
                }
            })) {
                countDownLatch.await();
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        return bitmapArr[0];
    }

    public void l0(boolean z) {
        m0(z, false, false);
    }

    public void m0(final boolean z, final boolean z2, final boolean z3) {
        i(new Runnable() { // from class: ir.nasim.go2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e0(z, z3, z2);
            }
        });
    }

    public void n0(final l.c cVar) {
        i(new Runnable() { // from class: ir.nasim.ko2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f0(cVar);
            }
        });
    }

    public void p0(final int i, final int i2) {
        i(new Runnable() { // from class: ir.nasim.io2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g0(i, i2);
            }
        });
    }

    public void q0(final int i, final int i2) {
        i(new Runnable() { // from class: ir.nasim.ho2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h0(i, i2);
            }
        });
    }

    public void r0() {
        i(new Runnable() { // from class: ir.nasim.do2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i0();
            }
        });
    }

    @Override // ir.nasim.HU1, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.l = a0();
        super.run();
    }

    public void s0(final l.b bVar) {
        i(new Runnable() { // from class: ir.nasim.jo2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j0(bVar);
            }
        });
    }

    public k(SurfaceTexture surfaceTexture, b bVar, l.b bVar2) {
        super("VideoFilterGLThread", false);
        this.s = new float[16];
        this.t = new int[1];
        this.B0 = new a();
        this.g = surfaceTexture;
        this.z0 = bVar;
        this.v = new l(true, bVar2);
        start();
    }
}
