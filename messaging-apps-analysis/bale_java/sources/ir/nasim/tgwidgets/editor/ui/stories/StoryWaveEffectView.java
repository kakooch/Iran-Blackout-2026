package ir.nasim.tgwidgets.editor.ui.stories;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.WindowManager;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes7.dex */
public class StoryWaveEffectView extends TextureView implements TextureView.SurfaceTextureListener {
    private Bitmap a;
    private final WindowManager.LayoutParams b;
    private final WindowManager c;
    private a d;
    private final FloatBuffer e;
    private final FloatBuffer f;
    private float g;
    private float h;
    private float i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends Thread {
        private volatile boolean a;
        private SurfaceTexture b;
        private EGL10 c;
        private EGLDisplay d;
        private EGLContext e;
        private EGLSurface f;
        private boolean g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private Bitmap p;
        private int[] q;
        final int[] r;
        private long s;
        private final long t;
        private final InterpolatorC12631ew1 u;

        public a(SurfaceTexture surfaceTexture, Bitmap bitmap) {
            super("StoryWaveEffectView.RenderingThread");
            this.q = new int[1];
            this.r = new int[1];
            this.t = 800L;
            this.u = InterpolatorC12631ew1.g;
            this.b = surfaceTexture;
            this.p = bitmap;
            start();
        }

        private EGLConfig b() {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL10 egl10 = this.c;
            EGLDisplay eGLDisplay = this.d;
            egl10.eglChooseConfig(eGLDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, new int[]{0});
            return eGLConfigArr[0];
        }

        private void c() {
            this.a = false;
            EGL10 egl10 = this.c;
            EGLDisplay eGLDisplay = this.d;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.c.eglDestroySurface(this.d, this.f);
            this.c.eglDestroyContext(this.d, this.e);
            this.c.eglTerminate(this.d);
            GLES20.glDeleteProgram(this.h);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g();
                }
            });
        }

        private void d() {
            if (this.g) {
                this.c.eglQuerySurface(this.d, this.f, 12375, this.r);
                int[] iArr = this.r;
                int i = iArr[0];
                this.c.eglQuerySurface(this.d, this.f, 12374, iArr);
                int i2 = this.r[0];
                GLES20.glViewport(0, 0, i, i2);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
                GLES20.glBlendFuncSeparate(770, 771, 1, 771);
                GLES20.glUseProgram(this.h);
                GLES20.glUniform2f(this.o, i, i2);
                GLES20.glUniform2f(this.l, StoryWaveEffectView.this.g, StoryWaveEffectView.this.h);
                GLES20.glUniform1f(this.n, StoryWaveEffectView.this.i);
                float fCurrentTimeMillis = (System.currentTimeMillis() - this.s) / 800.0f;
                GLES20.glUniform1f(this.m, Math.min(1.0f, this.u.getInterpolation(Math.min(1.0f, fCurrentTimeMillis))));
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.q[0]);
                GLES20.glUniform1i(this.i, 0);
                GLES20.glEnableVertexAttribArray(this.j);
                GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 8, (Buffer) StoryWaveEffectView.this.e);
                GLES20.glEnableVertexAttribArray(this.k);
                GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 8, (Buffer) StoryWaveEffectView.this.f);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.j);
                this.c.eglSwapBuffers(this.d, this.f);
                if (fCurrentTimeMillis < 1.0f || !this.a) {
                    return;
                }
                this.a = false;
            }
        }

        private void e(SurfaceTexture surfaceTexture) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.c = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.d = eGLDisplayEglGetDisplay;
            this.c.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
            EGLConfig eGLConfigB = b();
            this.e = StoryWaveEffectView.this.h(this.c, this.d, eGLConfigB);
            EGLSurface eGLSurfaceEglCreateWindowSurface = this.c.eglCreateWindowSurface(this.d, eGLConfigB, surfaceTexture, null);
            this.f = eGLSurfaceEglCreateWindowSurface;
            if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                throw new RuntimeException("GL Error: " + this.c.eglGetError());
            }
            if (!this.c.eglMakeCurrent(this.d, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.e)) {
                throw new RuntimeException("GL Make current error: " + this.c.eglGetError());
            }
            int[] iArr = new int[1];
            int iGlCreateShader = GLES20.glCreateShader(35633);
            GLES20.glShaderSource(iGlCreateShader, "attribute vec4 vPosition;\nattribute vec2 aTexCoord;\nvarying vec2 vTexCoord;\nvoid main() {\n  gl_Position = vPosition;\n  vTexCoord = aTexCoord;\n}\n");
            GLES20.glCompileShader(iGlCreateShader);
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
                GLES20.glDeleteShader(iGlCreateShader);
                throw new RuntimeException("Shader Compile Error: " + strGlGetShaderInfoLog);
            }
            int iGlCreateShader2 = GLES20.glCreateShader(35632);
            GLES20.glShaderSource(iGlCreateShader2, "precision lowp float;\nvarying vec2 vTexCoord;\nuniform sampler2D sTexture;\nuniform vec2 iResolution;\nuniform vec2 c;\nuniform float r;\nuniform float t;\nvoid main() {\n   vec2 U = vTexCoord * iResolution.xy;   float maxd = .35 * max(\n       max(length(c - vec2(0., 0.)), length(c - vec2(iResolution.x, 0.))),\n       max(length(c - vec2(0., iResolution.y)), length(c - iResolution))\n   );   float len = 250.;\n   float amplitude = len / 2. * (1. - t);   float R = mix(r - len, maxd + len, t);\n   float d = (length(U - c) - R) / len;\n   if (d > -1. && d < 1. && length(U - c) > r) {\n       vec2 dir = normalize(c - U);\n       vec2 uv = vTexCoord + dir * d * pow(1. - abs(d), 1.5) * amplitude / iResolution.xy;\n       if (length(uv * iResolution - c) > r) {\n           gl_FragColor = texture2D(sTexture, uv);\n       } else {\n           gl_FragColor = vec4(0.);\n       }\n       gl_FragColor.a *= min(1., (1. - abs(d)) * 2.);\n   } else {\n       gl_FragColor = vec4(0.);\n   }\n}\n");
            GLES20.glCompileShader(iGlCreateShader2);
            GLES20.glGetShaderiv(iGlCreateShader2, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String strGlGetShaderInfoLog2 = GLES20.glGetShaderInfoLog(iGlCreateShader2);
                GLES20.glDeleteShader(iGlCreateShader2);
                throw new RuntimeException("Shader Compile Error: " + strGlGetShaderInfoLog2);
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.h = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader);
            GLES20.glAttachShader(this.h, iGlCreateShader2);
            GLES20.glLinkProgram(this.h);
            GLES20.glGetProgramiv(this.h, 35714, iArr, 0);
            if (iArr[0] == 0) {
                String strGlGetProgramInfoLog = GLES20.glGetProgramInfoLog(this.h);
                GLES20.glDeleteProgram(this.h);
                throw new RuntimeException("Program Link Error: " + strGlGetProgramInfoLog);
            }
            this.j = GLES20.glGetAttribLocation(this.h, "vPosition");
            this.k = GLES20.glGetAttribLocation(this.h, "aTexCoord");
            this.l = GLES20.glGetUniformLocation(this.h, "c");
            this.n = GLES20.glGetUniformLocation(this.h, "r");
            this.m = GLES20.glGetUniformLocation(this.h, "t");
            this.o = GLES20.glGetUniformLocation(this.h, "iResolution");
            this.i = GLES20.glGetUniformLocation(this.h, "sTexture");
            GLES20.glDeleteShader(iGlCreateShader);
            GLES20.glDeleteShader(iGlCreateShader2);
            if (this.p != null) {
                GLES20.glGenTextures(1, this.q, 0);
                GLES20.glBindTexture(3553, this.q[0]);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9728);
                GLUtils.texImage2D(3553, 0, this.p, 0);
                this.p.recycle();
                this.p = null;
            }
            GLES20.glEnable(3042);
            GLES20.glDisable(3024);
            GLES20.glDisable(2960);
            GLES20.glDisable(2929);
            this.g = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            ((WindowManager) StoryWaveEffectView.this.getContext().getSystemService("window")).removeView(StoryWaveEffectView.this);
        }

        public void f() {
            this.a = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            this.a = true;
            e(this.b);
            long jMax = (long) (1000.0f / Math.max(30.0f, AbstractC21455b.i));
            this.s = System.currentTimeMillis();
            while (this.a) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                d();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                long j = jMax - 1;
                if (jCurrentTimeMillis2 < j) {
                    try {
                        Thread.sleep(j - jCurrentTimeMillis2);
                    } catch (Exception unused) {
                    }
                }
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EGLContext h(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
    }

    public StoryWaveEffectView j() {
        this.c.addView(this, this.b);
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.d == null) {
            this.d = new a(surfaceTexture, this.a);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a aVar = this.d;
        if (aVar == null) {
            return false;
        }
        aVar.f();
        this.d = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.j) {
            WindowManager.LayoutParams layoutParams = this.b;
            layoutParams.flags |= 16;
            this.c.updateViewLayout(this, layoutParams);
            this.j = true;
            animate().alpha(0.0f).setDuration(180L).withEndAction(new Runnable() { // from class: ir.nasim.EX6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i();
                }
            }).start();
        }
        return super.onTouchEvent(motionEvent);
    }
}
