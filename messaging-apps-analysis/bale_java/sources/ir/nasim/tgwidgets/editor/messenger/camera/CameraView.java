package ir.nasim.tgwidgets.editor.messenger.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C12212eE0;
import ir.nasim.C3803Ck4;
import ir.nasim.C9151Ys;
import ir.nasim.FL3;
import ir.nasim.HU1;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.QY0;
import ir.nasim.RD6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.messenger.camera.a;
import ir.nasim.tgwidgets.editor.messenger.video.MediaCodecVideoConvertor;
import ir.nasim.tgwidgets.editor.ui.Components.InstantCameraView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import livekit.org.webrtc.EglBase;

/* loaded from: classes7.dex */
public class CameraView extends FrameLayout implements TextureView.SurfaceTextureListener, a.c {
    private int A;
    private volatile int A0;
    private Paint B;
    boolean B0;
    boolean C0;
    private Paint D;
    private final Object D0;
    private float[][] E0;
    private float[][] F0;
    private boolean G;
    private float[][] G0;
    File H;
    private FloatBuffer H0;
    private FloatBuffer I0;
    private DecelerateInterpolator J;
    private float[][] J0;
    private volatile float K0;
    Runnable L0;
    private ir.nasim.tgwidgets.editor.messenger.camera.c M0;
    ValueAnimator N0;
    boolean O0;
    boolean P0;
    private int Q0;
    long R0;
    protected boolean S0;
    private boolean T0;
    private Matrix U0;
    private long V0;
    private boolean W0;
    private boolean X0;
    public boolean Y0;
    private boolean Z0;
    public boolean a;
    Rect a1;
    public boolean b;
    private int b1;
    private RD6[] c;
    private int c1;
    private RD6[] d;
    private int d1;
    ir.nasim.tgwidgets.editor.messenger.camera.b[] e;
    private Integer e1;
    private boolean f;
    private long f1;
    private boolean g;
    protected e g1;
    private TextureView h;
    private ValueAnimator h1;
    private ImageView i;
    private final Runnable i1;
    private ir.nasim.tgwidgets.editor.messenger.camera.c[] j;
    private float j1;
    private boolean k;
    private int k1;
    private f l;
    private int l1;
    private int m;
    private int[] m1;
    private int n;
    private int[][] n1;
    private boolean o;
    private int[] o1;
    private Matrix p;
    private h p1;
    private Matrix q;
    private volatile float q1;
    private int r;
    private volatile float r1;
    private Drawable s;
    private volatile float s1;
    private boolean t;
    private volatile float t1;
    private long u;
    private volatile float u1;
    private float v;
    private volatile float v1;
    private float w;
    private float x;
    private boolean y;
    private int z;
    private volatile int z0;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean z;
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (fFloatValue < 0.5f) {
                z = false;
            } else {
                fFloatValue -= 1.0f;
                z = true;
            }
            float f = fFloatValue * 180.0f;
            CameraView.this.h.setRotationY(f);
            CameraView.this.i.setRotationY(f);
            if (z) {
                CameraView cameraView = CameraView.this;
                if (cameraView.O0) {
                    return;
                }
                cameraView.O0 = true;
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CameraView cameraView = CameraView.this;
            cameraView.N0 = null;
            cameraView.h.setTranslationY(0.0f);
            CameraView.this.h.setRotationX(0.0f);
            CameraView.this.h.setRotationY(0.0f);
            CameraView.this.h.setScaleX(1.0f);
            CameraView.this.h.setScaleY(1.0f);
            CameraView.this.i.setRotationY(0.0f);
            CameraView cameraView2 = CameraView.this;
            if (!cameraView2.O0) {
                cameraView2.O0 = true;
            }
            cameraView2.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CameraView.this.h.setAlpha(this.a ? 1.0f : 0.0f);
            CameraView.this.h1 = null;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CameraView.this.i.setVisibility(8);
        }
    }

    public class e extends HU1 {
        private final int A;
        private int A0;
        private int B;
        private int B0;
        private int C0;
        private int D;
        private int D0;
        private int E0;
        private int F0;
        private int G;
        private int G0;
        private int H;
        private int H0;
        private int I0;
        private int J;
        private boolean J0;
        private boolean K0;
        private Matrix L0;
        private boolean M0;
        private int[] N0;
        private final float[] O0;
        private boolean P0;
        private final C9151Ys Q0;
        private final C9151Ys R0;
        private final C9151Ys S0;
        private final C9151Ys T0;
        private boolean U0;
        private boolean V0;
        private boolean W0;
        private long X0;
        private int Y;
        private float Y0;
        private int Z;
        final int[] Z0;
        private float[] a1;
        private long b1;
        private final Object c1;
        private final Object d1;
        private final Object e1;
        private SurfaceTexture g;
        private EGL10 h;
        private EGLDisplay i;
        private EGLContext j;
        private EGLSurface k;
        private EGLConfig l;
        private boolean m;
        private ir.nasim.tgwidgets.editor.messenger.camera.c[] n;
        private final SurfaceTexture[] o;
        private final int p;
        private final int q;
        private final int r;
        private final int s;
        private final int t;
        private final int u;
        private final int v;
        private final int w;
        private final int x;
        private final int y;
        private final int z;
        private int z0;

        public e(SurfaceTexture surfaceTexture) {
            super("CameraGLThread");
            this.n = new ir.nasim.tgwidgets.editor.messenger.camera.c[2];
            this.o = new SurfaceTexture[2];
            this.p = 0;
            this.q = 1;
            this.r = 2;
            this.s = 3;
            this.t = 4;
            this.u = 5;
            this.v = 6;
            this.w = 7;
            this.x = 8;
            this.y = 9;
            this.z = 10;
            this.A = 11;
            this.N0 = new int[]{-1, -1};
            this.O0 = new float[]{-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
            Runnable runnable = new Runnable() { // from class: ir.nasim.fE0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.y();
                }
            };
            InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
            this.Q0 = new C9151Ys(runnable, 560L, interpolatorC12631ew1);
            this.R0 = new C9151Ys(1.0f, new Runnable() { // from class: ir.nasim.gE0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.z();
                }
            }, 0L, 420L, interpolatorC12631ew1);
            this.S0 = new C9151Ys(new Runnable() { // from class: ir.nasim.hE0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.A();
                }
            }, 340L, interpolatorC12631ew1);
            this.T0 = new C9151Ys(new Runnable() { // from class: ir.nasim.iE0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.B();
                }
            }, 340L, interpolatorC12631ew1);
            this.Y0 = C.m().getInt("dualshape", 0);
            this.Z0 = new int[1];
            this.c1 = new Object();
            this.d1 = new Object();
            this.e1 = new Object();
            this.g = surfaceTexture;
            this.J0 = CameraView.this.S0;
            this.K0 = !CameraView.this.o;
            this.L0 = CameraView.this.U0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A() {
            H(false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B() {
            H(false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C() {
            CameraView.this.G0(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D() {
            CameraView.this.G0(1);
        }

        /* JADX WARN: Removed duplicated region for block: B:80:0x0183  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void E(int r24, int r25, boolean r26, boolean r27) {
            /*
                Method dump skipped, instructions count: 1063
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.CameraView.e.E(int, int, boolean, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M(SurfaceTexture surfaceTexture) {
            SurfaceTexture[] surfaceTextureArr = this.o;
            if (surfaceTexture == surfaceTextureArr[0]) {
                if (!this.W0 && System.currentTimeMillis() > this.X0) {
                    this.V0 = true;
                }
                H(true, false);
                return;
            }
            if (surfaceTexture == surfaceTextureArr[1]) {
                if (!this.U0) {
                    synchronized (CameraView.this.D0) {
                        CameraView.this.T0 = true;
                        CameraView.this.c0(1200L);
                    }
                }
                this.U0 = true;
                H(false, true);
            }
        }

        private void u(Matrix matrix) {
            w(matrix, CameraView.this.J0[1]);
        }

        private void w(Matrix matrix, float[] fArr) {
            if (this.a1 == null) {
                this.a1 = new float[9];
            }
            matrix.getValues(this.a1);
            float[] fArr2 = this.a1;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[3];
            fArr[2] = 0.0f;
            fArr[3] = fArr2[6];
            fArr[4] = fArr2[1];
            fArr[5] = fArr2[4];
            fArr[6] = 0.0f;
            fArr[7] = fArr2[7];
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 1.0f;
            fArr[11] = 0.0f;
            fArr[12] = fArr2[2];
            fArr[13] = fArr2[5];
            fArr[14] = 0.0f;
            fArr[15] = fArr2[8];
        }

        private boolean x() {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.a("CameraView start init gl");
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.h = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.i = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                this.i = null;
                v();
                return false;
            }
            if (!this.h.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglInitialize failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                v();
                return false;
            }
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.h.eglChooseConfig(this.i, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                v();
                return false;
            }
            if (iArr[0] <= 0) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglConfig not initialized");
                }
                v();
                return false;
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            this.l = eGLConfig;
            EGL10 egl102 = this.h;
            EGLDisplay eGLDisplay = this.i;
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            EGLContext eGLContextEglCreateContext = egl102.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, 2, 12344});
            this.j = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext == null || eGLContextEglCreateContext == eGLContext) {
                this.j = null;
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglCreateContext failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                v();
                return false;
            }
            SurfaceTexture surfaceTexture = this.g;
            if (surfaceTexture == null) {
                v();
                return false;
            }
            EGLSurface eGLSurfaceEglCreateWindowSurface = this.h.eglCreateWindowSurface(this.i, this.l, surfaceTexture, null);
            this.k = eGLSurfaceEglCreateWindowSurface;
            if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("createWindowSurface failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                v();
                return false;
            }
            if (!this.h.eglMakeCurrent(this.i, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.j)) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                }
                v();
                return false;
            }
            this.j.getGL();
            android.opengl.Matrix.setIdentityM(CameraView.this.F0[0], 0);
            int iE0 = CameraView.this.E0(35633, RLottieDrawable.S(null, AbstractC19363qD5.camera_vert));
            int iE02 = CameraView.this.E0(35632, RLottieDrawable.S(null, AbstractC19363qD5.camera_frag));
            if (iE0 == 0 || iE02 == 0) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("failed creating shader");
                }
                v();
                return false;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.B = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, iE0);
            GLES20.glAttachShader(this.B, iE02);
            GLES20.glLinkProgram(this.B);
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(this.B, 35714, iArr2, 0);
            if (iArr2[0] == 0) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("failed link shader");
                }
                GLES20.glDeleteProgram(this.B);
                this.B = 0;
            } else {
                this.Y = GLES20.glGetAttribLocation(this.B, "aPosition");
                this.Z = GLES20.glGetAttribLocation(this.B, "aTextureCoord");
                this.D = GLES20.glGetUniformLocation(this.B, "uMVPMatrix");
                this.G = GLES20.glGetUniformLocation(this.B, "uSTMatrix");
                this.H = GLES20.glGetUniformLocation(this.B, "cameraMatrix");
                this.J = GLES20.glGetUniformLocation(this.B, "oppositeCameraMatrix");
                this.z0 = GLES20.glGetUniformLocation(this.B, "roundRadius");
                this.A0 = GLES20.glGetUniformLocation(this.B, "pixelWH");
                this.B0 = GLES20.glGetUniformLocation(this.B, "dual");
                this.C0 = GLES20.glGetUniformLocation(this.B, "scale");
                this.D0 = GLES20.glGetUniformLocation(this.B, "blur");
                this.E0 = GLES20.glGetUniformLocation(this.B, "alpha");
                this.F0 = GLES20.glGetUniformLocation(this.B, "crossfade");
                this.G0 = GLES20.glGetUniformLocation(this.B, "shapeFrom");
                this.H0 = GLES20.glGetUniformLocation(this.B, "shapeTo");
                this.I0 = GLES20.glGetUniformLocation(this.B, "shapeT");
            }
            GLES20.glGenTextures(1, CameraView.this.n1[0], 0);
            GLES20.glBindTexture(36197, CameraView.this.n1[0][0]);
            GLES20.glTexParameteri(36197, 10241, 9729);
            GLES20.glTexParameteri(36197, 10240, 9729);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glEnable(3042);
            GLES20.glBlendFuncSeparate(770, 771, 1, 771);
            android.opengl.Matrix.setIdentityM(CameraView.this.E0[0], 0);
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("gl initied");
            }
            CameraView.this.H0 = ByteBuffer.allocateDirect(this.O0.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            CameraView.this.H0.put(this.O0).position(0);
            CameraView.this.I0 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
            CameraView.this.I0.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
            this.o[0] = new SurfaceTexture(CameraView.this.n1[0][0]);
            this.o[0].setOnFrameAvailableListener(new C12212eE0(this));
            if (this.J0) {
                GLES20.glGenTextures(1, CameraView.this.n1[1], 0);
                GLES20.glBindTexture(36197, CameraView.this.n1[1][0]);
                GLES20.glTexParameteri(36197, 10241, 9729);
                GLES20.glTexParameteri(36197, 10240, 9729);
                GLES20.glTexParameteri(36197, 10242, 33071);
                GLES20.glTexParameteri(36197, 10243, 33071);
                this.o[1] = new SurfaceTexture(CameraView.this.n1[1][0]);
                this.o[1].setOnFrameAvailableListener(new C12212eE0(this));
            }
            if (!this.J0) {
                CameraView.this.g0(this.o[0], 0);
            } else if (this.K0) {
                CameraView.this.g0(this.o[1], 1);
                CameraView.this.g0(this.o[0], 0);
            } else {
                CameraView.this.g0(this.o[0], 0);
                CameraView.this.g0(this.o[1], 1);
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            w(matrix, CameraView.this.J0[0]);
            Matrix matrix2 = this.L0;
            if (matrix2 != null) {
                w(matrix2, CameraView.this.J0[1]);
            } else {
                w(matrix, CameraView.this.J0[1]);
            }
            CameraView.this.u1 = this.Y0;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y() {
            H(false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z() {
            H(false, false);
        }

        public void F(long j) {
            this.b1 = System.currentTimeMillis() + j;
        }

        public void G() {
            Handler handlerD = d();
            if (handlerD != null) {
                l(handlerD.obtainMessage(2, Integer.valueOf(CameraView.this.e[0].a)), 0);
            }
        }

        public void H(boolean z, boolean z2) {
            Handler handlerD;
            if (this.b1 <= 0 || System.currentTimeMillis() >= this.b1) {
                if ((z || z2 || !this.M0) && (handlerD = d()) != null) {
                    if ((z || z2) && handlerD.hasMessages(0, this.e1)) {
                        return;
                    }
                    if (!z && handlerD.hasMessages(0, this.c1)) {
                        z = true;
                    }
                    if (!z2 && handlerD.hasMessages(0, this.d1)) {
                        z2 = true;
                    }
                    handlerD.removeMessages(0);
                    int[] iArr = this.N0;
                    l(handlerD.obtainMessage(0, iArr[0], iArr[1], (z && z2) ? this.e1 : z ? this.c1 : this.d1), 0);
                }
            }
        }

        public void I(ir.nasim.tgwidgets.editor.messenger.camera.c cVar, int i) {
            Handler handlerD = d();
            if (handlerD != null) {
                l(handlerD.obtainMessage(3, i, 0, cVar), 0);
            }
        }

        public void J(int i) {
            Handler handlerD = d();
            if (handlerD != null) {
                l(handlerD.obtainMessage(1, i, 0), 0);
            }
        }

        public boolean K(File file) {
            Handler handlerD = d();
            if (handlerD == null) {
                return true;
            }
            l(handlerD.obtainMessage(4, file), 0);
            return false;
        }

        public void L() {
            Handler handlerD = d();
            if (handlerD != null) {
                l(handlerD.obtainMessage(5), 0);
            }
        }

        @Override // ir.nasim.HU1
        public void f(Message message) {
            int i = message.what;
            boolean z = true;
            switch (i) {
                case 0:
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    Object obj = message.obj;
                    Object obj2 = this.e1;
                    boolean z2 = obj == obj2 || obj == this.c1;
                    if (obj != obj2 && obj != this.d1) {
                        z = false;
                    }
                    E(i2, i3, z2, z);
                    return;
                case 1:
                    v();
                    if (this.M0) {
                        CameraView.this.p1.y(message.arg1);
                    }
                    Looper looperMyLooper = Looper.myLooper();
                    if (looperMyLooper != null) {
                        looperMyLooper.quit();
                        return;
                    }
                    return;
                case 2:
                case 6:
                    int i4 = i == 2 ? 0 : 1;
                    EGL10 egl10 = this.h;
                    EGLDisplay eGLDisplay = this.i;
                    EGLSurface eGLSurface = this.k;
                    if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.j)) {
                        if (AbstractC8814Xl0.b) {
                            AbstractC6403Nl2.a("CameraView eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                            return;
                        }
                        return;
                    }
                    SurfaceTexture surfaceTexture = this.o[i4];
                    if (surfaceTexture != null) {
                        surfaceTexture.getTransformMatrix(CameraView.this.G0[i4]);
                        this.o[i4].setOnFrameAvailableListener(null);
                        this.o[i4].release();
                        this.o[i4] = null;
                    }
                    if (CameraView.this.n1[i4][0] == 0) {
                        GLES20.glGenTextures(1, CameraView.this.n1[i4], 0);
                    }
                    this.N0[i4] = message.arg1;
                    GLES20.glBindTexture(36197, CameraView.this.n1[i4][0]);
                    GLES20.glTexParameteri(36197, 10241, 9729);
                    GLES20.glTexParameteri(36197, 10240, 9729);
                    GLES20.glTexParameteri(36197, 10242, 33071);
                    GLES20.glTexParameteri(36197, 10243, 33071);
                    if (i4 == 1) {
                        u((Matrix) message.obj);
                    }
                    this.o[i4] = new SurfaceTexture(CameraView.this.n1[i4][0]);
                    this.o[i4].setOnFrameAvailableListener(new C12212eE0(this));
                    if (this.W0) {
                        this.V0 = false;
                        this.X0 = System.currentTimeMillis() + 60;
                        this.W0 = false;
                    }
                    CameraView.this.g0(this.o[i4], i4);
                    if (i4 == 1) {
                        this.U0 = false;
                        synchronized (CameraView.this.D0) {
                            CameraView.this.T0 = false;
                            CameraView.this.C0 = false;
                        }
                        this.S0.d(0.0f, true);
                        return;
                    }
                    return;
                case 3:
                    int i5 = message.arg1;
                    ir.nasim.tgwidgets.editor.messenger.camera.c cVar = (ir.nasim.tgwidgets.editor.messenger.camera.c) message.obj;
                    if (cVar == null) {
                        return;
                    }
                    ir.nasim.tgwidgets.editor.messenger.camera.c[] cVarArr = this.n;
                    if (cVarArr[i5] != cVar) {
                        cVarArr[i5] = cVar;
                        this.N0[i5] = cVar.a.a;
                    }
                    int iW = cVarArr[i5].w();
                    if (AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.a("CameraView set gl renderer session " + i5 + " angle=" + iW);
                    }
                    android.opengl.Matrix.setIdentityM(CameraView.this.E0[i5], 0);
                    if (iW != 0) {
                        android.opengl.Matrix.rotateM(CameraView.this.E0[i5], 0, iW, 0.0f, 0.0f, 1.0f);
                        return;
                    }
                    return;
                case 4:
                    if (this.m) {
                        CameraView cameraView = CameraView.this;
                        cameraView.H = (File) message.obj;
                        cameraView.p1 = new h();
                        this.M0 = true;
                        CameraView.this.p1.x(CameraView.this.H, EGL14.eglGetCurrentContext());
                        return;
                    }
                    return;
                case 5:
                    if (CameraView.this.p1 != null) {
                        CameraView.this.p1.y(0);
                        CameraView.this.p1 = null;
                    }
                    this.M0 = false;
                    return;
                case 7:
                    u((Matrix) message.obj);
                    H(false, false);
                    return;
                case 8:
                    int[] iArr = this.N0;
                    int i6 = iArr[0];
                    iArr[0] = iArr[1];
                    iArr[1] = i6;
                    ir.nasim.tgwidgets.editor.messenger.camera.c[] cVarArr2 = this.n;
                    ir.nasim.tgwidgets.editor.messenger.camera.c cVar2 = cVarArr2[0];
                    cVarArr2[0] = cVarArr2[1];
                    cVarArr2[1] = cVar2;
                    int[] iArr2 = CameraView.this.n1[0];
                    CameraView.this.n1[0] = CameraView.this.n1[1];
                    CameraView.this.n1[1] = iArr2;
                    SurfaceTexture[] surfaceTextureArr = this.o;
                    SurfaceTexture surfaceTexture2 = surfaceTextureArr[0];
                    surfaceTextureArr[0] = surfaceTextureArr[1];
                    surfaceTextureArr[1] = surfaceTexture2;
                    float[] fArr = CameraView.this.E0[0];
                    CameraView.this.E0[0] = CameraView.this.E0[1];
                    CameraView.this.E0[1] = fArr;
                    float[] fArr2 = CameraView.this.F0[0];
                    CameraView.this.F0[0] = CameraView.this.F0[1];
                    CameraView.this.F0[1] = fArr2;
                    float[] fArr3 = CameraView.this.G0[0];
                    CameraView.this.G0[0] = CameraView.this.G0[1];
                    CameraView.this.G0[1] = fArr3;
                    this.P0 = true;
                    CameraView.this.K0 = 1.0f;
                    this.Q0.d(1.0f, true);
                    H(true, true);
                    return;
                case 9:
                    float f = this.Y0 + 1.0f;
                    this.Y0 = f;
                    CameraView.this.u1 = f;
                    H(false, false);
                    return;
                case 10:
                    EGL10 egl102 = this.h;
                    EGLDisplay eGLDisplay2 = this.i;
                    EGLSurface eGLSurface2 = this.k;
                    if (!egl102.eglMakeCurrent(eGLDisplay2, eGLSurface2, eGLSurface2, this.j)) {
                        if (AbstractC8814Xl0.b) {
                            AbstractC6403Nl2.a("CameraView eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.h.eglGetError()));
                            return;
                        }
                        return;
                    }
                    SurfaceTexture surfaceTexture3 = this.o[1];
                    if (surfaceTexture3 != null) {
                        surfaceTexture3.getTransformMatrix(CameraView.this.G0[1]);
                        this.o[1].setOnFrameAvailableListener(null);
                        this.o[1].release();
                        this.o[1] = null;
                    }
                    if (CameraView.this.n1[1][0] != 0) {
                        GLES20.glDeleteTextures(1, CameraView.this.n1[1], 0);
                        CameraView.this.n1[1][0] = 0;
                    }
                    this.n[1] = null;
                    this.N0[1] = -1;
                    H(false, false);
                    return;
                case 11:
                    this.V0 = false;
                    this.W0 = true;
                    this.X0 = System.currentTimeMillis() + 60;
                    H(false, false);
                    return;
                default:
                    return;
            }
        }

        @Override // ir.nasim.HU1, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.m = x();
            super.run();
        }

        public void v() {
            if (this.o != null) {
                int i = 0;
                while (true) {
                    SurfaceTexture[] surfaceTextureArr = this.o;
                    if (i >= surfaceTextureArr.length) {
                        break;
                    }
                    SurfaceTexture surfaceTexture = surfaceTextureArr[i];
                    if (surfaceTexture != null) {
                        surfaceTexture.setOnFrameAvailableListener(null);
                        this.o[i].release();
                        this.o[i] = null;
                    }
                    i++;
                }
            }
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
    }

    public interface f {
        void a();
    }

    private static class g extends Handler {
        private WeakReference a;

        public g(h hVar) {
            this.a = new WeakReference(hVar);
        }

        public void a() {
            Looper.myLooper().quit();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws InterruptedException {
            int i = message.what;
            h hVar = (h) this.a.get();
            if (hVar == null) {
                return;
            }
            if (i == 0) {
                try {
                    if (AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.b("start encoder");
                    }
                    hVar.w();
                    return;
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                    hVar.q(0);
                    Looper.myLooper().quit();
                    return;
                }
            }
            if (i == 1) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("stop encoder");
                }
                hVar.q(message.arg1);
            } else if (i == 2) {
                hVar.r((message.arg1 << 32) | (message.arg2 & 4294967295L), (Integer) message.obj);
            } else {
                if (i != 3) {
                    return;
                }
                hVar.p((InstantCameraView.b) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class h implements Runnable {
        private volatile g A;
        private long A0;
        private final Object B;
        private long B0;
        private boolean C0;
        private boolean D;
        private int D0;
        private int E0;
        private int F0;
        private volatile boolean G;
        private int G0;
        private volatile int H;
        private int H0;
        private int I0;
        private long J;
        private int J0;
        private int K0;
        private int L0;
        private int M0;
        private int N0;
        private int O0;
        private int P0;
        private int Q0;
        private int R0;
        private int S0;
        private int T0;
        private int U0;
        private Integer V0;
        private AudioRecord W0;
        private FloatBuffer X0;
        private boolean Y;
        private ArrayBlockingQueue Y0;
        private long Z;
        private ArrayList Z0;
        private File a;
        HU1 a1;
        private File b;
        private Runnable b1;
        private boolean c;
        private String c1;
        private int d;
        private boolean e;
        private boolean f;
        private Surface g;
        private android.opengl.EGLDisplay h;
        private android.opengl.EGLContext i;
        private android.opengl.EGLContext j;
        private android.opengl.EGLConfig k;
        private android.opengl.EGLSurface l;
        private MediaCodec m;
        private MediaCodec n;
        private int o;
        private boolean p;
        private MediaCodec.BufferInfo q;
        private MediaCodec.BufferInfo r;
        private FL3 s;
        private ArrayList t;
        private int u;
        private int v;
        private long w;
        private long x;
        private long y;
        private long z;
        private long z0;

        class a implements Runnable {
            a() {
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
            
                if (r13.a.H == 0) goto L54;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.lang.IllegalStateException, java.lang.InterruptedException {
                /*
                    Method dump skipped, instructions count: 262
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.CameraView.h.a.run():void");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:75:0x019f A[Catch: all -> 0x0175, TryCatch #0 {all -> 0x0175, blocks: (B:50:0x011f, B:52:0x0129, B:53:0x0135, B:57:0x013c, B:59:0x0140, B:61:0x014d, B:63:0x0151, B:67:0x0178, B:69:0x0184, B:71:0x018e, B:72:0x0192, B:73:0x0199, B:75:0x019f, B:77:0x01a8, B:78:0x01ad, B:80:0x01b5, B:83:0x01c5, B:81:0x01bf, B:84:0x01cb, B:91:0x01e4, B:87:0x01d9), top: B:95:0x011f }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01c4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void p(ir.nasim.tgwidgets.editor.ui.Components.InstantCameraView.b r17) {
            /*
                Method dump skipped, instructions count: 495
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.CameraView.h.p(ir.nasim.tgwidgets.editor.ui.Components.InstantCameraView$b):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(int i) throws InterruptedException {
            if (this.G) {
                this.H = i;
                this.G = false;
                return;
            }
            try {
                n(true);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
            MediaCodec mediaCodec = this.m;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    this.m.release();
                    this.m = null;
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
            }
            MediaCodec mediaCodec2 = this.n;
            if (mediaCodec2 != null) {
                try {
                    mediaCodec2.stop();
                    this.n.release();
                    this.n = null;
                } catch (Exception e3) {
                    AbstractC6403Nl2.d(e3);
                }
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.a1.i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.camera.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u(countDownLatch);
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
            if (this.c && !this.b.renameTo(this.a)) {
                AbstractC6403Nl2.b("unable to rename file, try move file");
                try {
                    AbstractC21455b.B(this.b, this.a);
                    this.b.delete();
                } catch (IOException e5) {
                    AbstractC6403Nl2.d(e5);
                    AbstractC6403Nl2.b("unable to move file");
                }
            }
            EGL14.eglDestroySurface(this.h, this.l);
            this.l = EGL14.EGL_NO_SURFACE;
            Surface surface = this.g;
            if (surface != null) {
                surface.release();
                this.g = null;
            }
            android.opengl.EGLDisplay eGLDisplay = this.h;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroyContext(this.h, this.i);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.h);
            }
            this.h = EGL14.EGL_NO_DISPLAY;
            this.i = EGL14.EGL_NO_CONTEXT;
            this.k = null;
            this.A.a();
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.camera.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.v();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(long j, Integer num) {
            long j2;
            try {
                n(false);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!this.V0.equals(num)) {
                this.z = -1L;
                this.V0 = num;
            }
            long j3 = this.z;
            if (j3 == -1) {
                this.z = j;
                j2 = 0;
                if (this.y != 0) {
                    j2 = 1000000 * (jCurrentTimeMillis - this.w);
                }
            } else {
                j2 = j - j3;
                this.z = j;
            }
            this.w = jCurrentTimeMillis;
            if (!this.Y) {
                long j4 = this.J + j2;
                this.J = j4;
                if (j4 < 200000000) {
                    return;
                } else {
                    this.Y = true;
                }
            }
            this.y += j2;
            if (this.z0 == -1) {
                this.z0 = j / 1000;
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.a("CameraView first video frame was at " + this.z0);
                }
            }
            this.A0 = j;
            if (CameraView.this.n1[1][0] != 0 && !this.f) {
                GLES20.glEnable(3042);
                this.f = true;
            }
            boolean z = CameraView.this.S0;
            if (z) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
            }
            float f = CameraView.this.K0;
            boolean z2 = f > 0.0f;
            int i = -1;
            while (i < 2) {
                if (i != -1 || z2) {
                    int i2 = i < 0 ? 1 : i;
                    if (CameraView.this.n1[i2][0] != 0) {
                        GLES20.glUseProgram(this.D0);
                        GLES20.glVertexAttribPointer(this.I0, 3, 5126, false, 12, (Buffer) CameraView.this.H0);
                        GLES20.glEnableVertexAttribArray(this.I0);
                        GLES20.glVertexAttribPointer(this.J0, 2, 5126, false, 8, (Buffer) this.X0);
                        GLES20.glEnableVertexAttribArray(this.J0);
                        GLES20.glUniformMatrix4fv(this.E0, 1, false, CameraView.this.E0[i2], 0);
                        GLES20.glUniformMatrix4fv(this.G0, 1, false, CameraView.this.J0[i2], 0);
                        GLES20.glUniformMatrix4fv(this.H0, 1, false, CameraView.this.J0[1 - i2], 0);
                        GLES20.glActiveTexture(33984);
                        GLES20.glUniformMatrix4fv(this.F0, 1, false, CameraView.this.F0[i2], 0);
                        GLES20.glUniform1f(this.T0, 0.0f);
                        if (i2 == 0) {
                            GLES20.glUniform2f(this.L0, CameraView.this.q1, CameraView.this.r1);
                            GLES20.glUniform1f(this.M0, z ? 1.0f : 0.0f);
                        } else {
                            GLES20.glUniform2f(this.L0, CameraView.this.s1, CameraView.this.t1);
                            GLES20.glUniform1f(this.M0, 1.0f);
                        }
                        if (i2 == 1) {
                            GLES20.glUniform1f(this.R0, 1.0f);
                            if (i < 0) {
                                GLES20.glUniform1f(this.K0, 0.0f);
                                GLES20.glUniform1f(this.S0, 1.0f);
                                GLES20.glUniform1f(this.O0, 2.0f);
                                GLES20.glUniform1f(this.P0, 2.0f);
                                GLES20.glUniform1f(this.Q0, 0.0f);
                                GLES20.glUniform1f(this.N0, 1.0f);
                            } else if (z2) {
                                GLES20.glUniform1f(this.K0, AbstractC21455b.F(16.0f));
                                GLES20.glUniform1f(this.S0, 1.0f - f);
                                GLES20.glUniform1f(this.O0, (float) Math.floor(CameraView.this.v1));
                                GLES20.glUniform1f(this.P0, (float) Math.ceil(CameraView.this.v1));
                                GLES20.glUniform1f(this.Q0, CameraView.this.v1 - ((float) Math.floor(CameraView.this.v1)));
                                GLES20.glUniform1f(this.Q0, f);
                                GLES20.glUniform1f(this.N0, 0.0f);
                            } else {
                                GLES20.glUniform1f(this.K0, AbstractC21455b.F(16.0f));
                                GLES20.glUniform1f(this.S0, 1.0f);
                                GLES20.glUniform1f(this.O0, (float) Math.floor(CameraView.this.v1));
                                GLES20.glUniform1f(this.P0, (float) Math.ceil(CameraView.this.v1));
                                GLES20.glUniform1f(this.Q0, CameraView.this.v1 - ((float) Math.floor(CameraView.this.v1)));
                                GLES20.glUniform1f(this.N0, 0.0f);
                            }
                        } else {
                            GLES20.glUniform1f(this.R0, 1.0f);
                            if (z2) {
                                GLES20.glUniform1f(this.K0, AbstractC21455b.U0(AbstractC21455b.F(12.0f), AbstractC21455b.F(16.0f), f));
                                GLES20.glUniform1f(this.S0, 1.0f);
                                GLES20.glUniform1f(this.O0, CameraView.this.u1);
                                GLES20.glUniform1f(this.P0, 2.0f);
                                GLES20.glUniform1f(this.Q0, Utilities.c(1.0f - f, 1.0f, 0.0f));
                                GLES20.glUniform1f(this.N0, f);
                            } else {
                                GLES20.glUniform1f(this.K0, 0.0f);
                                GLES20.glUniform1f(this.S0, 1.0f);
                                GLES20.glUniform1f(this.O0, 2.0f);
                                GLES20.glUniform1f(this.P0, 2.0f);
                                GLES20.glUniform1f(this.Q0, 0.0f);
                                GLES20.glUniform1f(this.N0, 0.0f);
                            }
                        }
                        GLES20.glBindTexture(36197, CameraView.this.n1[i2][0]);
                        GLES20.glDrawArrays(5, 0, 4);
                        GLES20.glDisableVertexAttribArray(this.I0);
                        GLES20.glDisableVertexAttribArray(this.J0);
                        GLES20.glBindTexture(36197, 0);
                        GLES20.glUseProgram(0);
                    }
                }
                i++;
            }
            EGLExt.eglPresentationTimeANDROID(this.h, this.l, this.y);
            EGL14.eglSwapBuffers(this.h, this.l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            try {
                this.s.s(this.u, byteBuffer, bufferInfo, true);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            try {
                this.s.s(this.v, byteBuffer, bufferInfo, false);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(CountDownLatch countDownLatch) {
            try {
                this.s.n();
            } catch (Exception e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v() {
            if (CameraView.this.j[0] != null) {
                CameraView.this.j[0].G();
            }
            if (CameraView.this.j[1] != null) {
                CameraView.this.j[1].G();
            }
            CameraView.this.L0.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w() throws IllegalStateException, IOException {
            MediaCodec mediaCodec;
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                if (minBufferSize <= 0) {
                    minBufferSize = 3584;
                }
                int i = 49152 < minBufferSize ? ((minBufferSize / 2048) + 1) * 4096 : 49152;
                for (int i2 = 0; i2 < 3; i2++) {
                    this.Y0.add(new InstantCameraView.b());
                }
                AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, i);
                this.W0 = audioRecord;
                audioRecord.startRecording();
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.a("CameraView initied audio record with channels " + this.W0.getChannelCount() + " sample rate = " + this.W0.getSampleRate() + " bufferSize = " + i);
                }
                Thread thread = new Thread(this.b1);
                thread.setPriority(10);
                thread.start();
                this.r = new MediaCodec.BufferInfo();
                this.q = new MediaCodec.BufferInfo();
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", "audio/mp4a-latm");
                mediaFormat.setInteger("sample-rate", 44100);
                mediaFormat.setInteger("channel-count", 1);
                mediaFormat.setInteger("bitrate", 32000);
                mediaFormat.setInteger("max-input-size", 20480);
                MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
                this.n = mediaCodecCreateEncoderByType;
                mediaCodecCreateEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                this.n.start();
                boolean z = CameraView.this.b;
                this.c1 = z ? "video/hevc" : "video/avc";
                try {
                    if (z) {
                        String strG = AbstractC8662Wx6.g();
                        if (strG != null) {
                            this.m = MediaCodec.createByCodecName(strG);
                        }
                    } else {
                        this.c1 = "video/avc";
                        this.m = MediaCodec.createEncoderByType("video/avc");
                    }
                    if (this.c1.equals("video/hevc") && (mediaCodec = this.m) != null && !mediaCodec.getCodecInfo().isHardwareAccelerated()) {
                        AbstractC6403Nl2.b("hevc encoder isn't hardware accelerated");
                        this.m.release();
                        this.m = null;
                    }
                } catch (Throwable th) {
                    AbstractC6403Nl2.b("can't get hevc encoder");
                    AbstractC6403Nl2.d(th);
                }
                if (this.m == null && this.c1.equals("video/hevc")) {
                    this.c1 = "video/avc";
                    this.m = MediaCodec.createEncoderByType("video/avc");
                }
                this.p = true;
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(this.c1, CameraView.this.k1, CameraView.this.l1);
                mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
                mediaFormatCreateVideoFormat.setInteger("bitrate", this.d);
                mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
                mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
                this.m.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.g = this.m.createInputSurface();
                this.m.start();
                boolean zS0 = C21457d.s0(this.a);
                this.b = this.a;
                if (zS0) {
                    try {
                        File file = new File(AbstractC14047hG.b(), "camera_tmp.mp4");
                        this.b = file;
                        if (file.exists()) {
                            this.b.delete();
                        }
                        this.c = true;
                    } catch (Throwable th2) {
                        AbstractC6403Nl2.d(th2);
                        this.b = this.a;
                        this.c = false;
                    }
                }
                C3803Ck4 c3803Ck4 = new C3803Ck4();
                c3803Ck4.g(this.b);
                c3803Ck4.h(0);
                c3803Ck4.i(CameraView.this.k1, CameraView.this.l1);
                this.s = new FL3().d(c3803Ck4, false, false);
                if (this.h != EGL14.EGL_NO_DISPLAY) {
                    throw new RuntimeException("EGL already set up");
                }
                android.opengl.EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                this.h = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    throw new RuntimeException("unable to get EGL14 display");
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                    this.h = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                if (this.i == EGL14.EGL_NO_CONTEXT) {
                    android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
                    if (!EGL14.eglChooseConfig(this.h, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        throw new RuntimeException("Unable to find a suitable EGLConfig");
                    }
                    this.i = EGL14.eglCreateContext(this.h, eGLConfigArr[0], this.j, new int[]{12440, 2, 12344}, 0);
                    this.k = eGLConfigArr[0];
                }
                EGL14.eglQueryContext(this.h, this.i, 12440, new int[1], 0);
                if (this.l != EGL14.EGL_NO_SURFACE) {
                    throw new IllegalStateException("surface already created");
                }
                android.opengl.EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.h, this.k, this.g, new int[]{12344}, 0);
                this.l = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface == null) {
                    throw new RuntimeException("surface was null");
                }
                if (!EGL14.eglMakeCurrent(this.h, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.i)) {
                    if (AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.b("eglMakeCurrent failed " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
                    }
                    throw new RuntimeException("eglMakeCurrent failed");
                }
                GLES20.glBlendFunc(770, 771);
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.X0 = floatBufferAsFloatBuffer;
                floatBufferAsFloatBuffer.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
                int iE0 = CameraView.this.E0(35633, RLottieDrawable.S(null, AbstractC19363qD5.camera_vert));
                int iE02 = CameraView.this.E0(35632, RLottieDrawable.S(null, AbstractC19363qD5.camera_frag));
                if (iE0 == 0 || iE02 == 0) {
                    return;
                }
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.D0 = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, iE0);
                GLES20.glAttachShader(this.D0, iE02);
                GLES20.glLinkProgram(this.D0);
                int[] iArr2 = new int[1];
                GLES20.glGetProgramiv(this.D0, 35714, iArr2, 0);
                if (iArr2[0] == 0) {
                    GLES20.glDeleteProgram(this.D0);
                    this.D0 = 0;
                    return;
                }
                this.I0 = GLES20.glGetAttribLocation(this.D0, "aPosition");
                this.J0 = GLES20.glGetAttribLocation(this.D0, "aTextureCoord");
                this.E0 = GLES20.glGetUniformLocation(this.D0, "uMVPMatrix");
                this.F0 = GLES20.glGetUniformLocation(this.D0, "uSTMatrix");
                this.G0 = GLES20.glGetUniformLocation(this.D0, "cameraMatrix");
                this.H0 = GLES20.glGetUniformLocation(this.D0, "oppositeCameraMatrix");
                this.K0 = GLES20.glGetUniformLocation(this.D0, "roundRadius");
                this.L0 = GLES20.glGetUniformLocation(this.D0, "pixelWH");
                this.M0 = GLES20.glGetUniformLocation(this.D0, "dual");
                this.S0 = GLES20.glGetUniformLocation(this.D0, "scale");
                this.T0 = GLES20.glGetUniformLocation(this.D0, "blur");
                this.R0 = GLES20.glGetUniformLocation(this.D0, "alpha");
                this.N0 = GLES20.glGetUniformLocation(this.D0, "crossfade");
                this.O0 = GLES20.glGetUniformLocation(this.D0, "shapeFrom");
                this.P0 = GLES20.glGetUniformLocation(this.D0, "shapeTo");
                this.Q0 = GLES20.glGetUniformLocation(this.D0, "shapeT");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        protected void finalize() throws Throwable {
            HU1 hu1 = this.a1;
            if (hu1 != null) {
                hu1.k();
                this.a1 = null;
            }
            try {
                android.opengl.EGLDisplay eGLDisplay = this.h;
                if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                    android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                    EGL14.eglDestroyContext(this.h, this.i);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(this.h);
                    this.h = EGL14.EGL_NO_DISPLAY;
                    this.i = EGL14.EGL_NO_CONTEXT;
                    this.k = null;
                }
            } finally {
                super.finalize();
            }
        }

        public void n(boolean z) {
            ByteBuffer byteBufferAllocate;
            ByteBuffer byteBufferAllocate2;
            if (z) {
                this.m.signalEndOfInputStream();
            }
            while (true) {
                int iDequeueOutputBuffer = this.m.dequeueOutputBuffer(this.q, 10000L);
                byte b = 1;
                if (iDequeueOutputBuffer == -1) {
                    if (!z) {
                        break;
                    }
                } else if (iDequeueOutputBuffer == -3) {
                    continue;
                } else if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.m.getOutputFormat();
                    if (this.u == -5) {
                        this.u = this.s.a(outputFormat, false);
                        if (outputFormat.containsKey("prepend-sps-pps-to-idr-frames") && outputFormat.getInteger("prepend-sps-pps-to-idr-frames") == 1) {
                            ByteBuffer byteBuffer = outputFormat.getByteBuffer("csd-0");
                            ByteBuffer byteBuffer2 = outputFormat.getByteBuffer("csd-1");
                            this.o = (byteBuffer == null ? 0 : byteBuffer.limit()) + (byteBuffer2 != null ? byteBuffer2.limit() : 0);
                        }
                    }
                } else if (iDequeueOutputBuffer < 0) {
                    continue;
                } else {
                    ByteBuffer outputBuffer = this.m.getOutputBuffer(iDequeueOutputBuffer);
                    if (outputBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.q;
                    int i = bufferInfo.size;
                    if (i > 1) {
                        int i2 = bufferInfo.flags;
                        if ((i2 & 2) == 0) {
                            int i3 = this.o;
                            if (i3 != 0 && (i2 & 1) != 0) {
                                bufferInfo.offset += i3;
                                bufferInfo.size = i - i3;
                            }
                            if (this.p && (i2 & 1) != 0) {
                                MediaCodecVideoConvertor.f(this.c1, outputBuffer, bufferInfo);
                                this.p = false;
                            }
                            final MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
                            MediaCodec.BufferInfo bufferInfo3 = this.q;
                            bufferInfo2.size = bufferInfo3.size;
                            bufferInfo2.offset = bufferInfo3.offset;
                            bufferInfo2.flags = bufferInfo3.flags;
                            bufferInfo2.presentationTimeUs = bufferInfo3.presentationTimeUs;
                            final ByteBuffer byteBufferY = AbstractC21455b.y(outputBuffer);
                            this.a1.i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.camera.f
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.a.s(byteBufferY, bufferInfo2);
                                }
                            });
                        } else if (this.u == -5) {
                            if (this.c1.equals("video/hevc")) {
                                throw new RuntimeException("need fix parsing csd data");
                            }
                            MediaCodec.BufferInfo bufferInfo4 = this.q;
                            int i4 = bufferInfo4.size;
                            byte[] bArr = new byte[i4];
                            outputBuffer.limit(bufferInfo4.offset + i4);
                            outputBuffer.position(this.q.offset);
                            outputBuffer.get(bArr);
                            int i5 = this.q.size - 1;
                            while (i5 >= 0 && i5 > 3) {
                                if (bArr[i5] == b && bArr[i5 - 1] == 0 && bArr[i5 - 2] == 0) {
                                    int i6 = i5 - 3;
                                    if (bArr[i6] == 0) {
                                        byteBufferAllocate = ByteBuffer.allocate(i6);
                                        byteBufferAllocate2 = ByteBuffer.allocate(this.q.size - i6);
                                        byteBufferAllocate.put(bArr, 0, i6).position(0);
                                        byteBufferAllocate2.put(bArr, i6, this.q.size - i6).position(0);
                                        break;
                                    }
                                }
                                i5--;
                                b = 1;
                            }
                            byteBufferAllocate = null;
                            byteBufferAllocate2 = null;
                            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", CameraView.this.k1, CameraView.this.l1);
                            if (byteBufferAllocate != null && byteBufferAllocate2 != null) {
                                mediaFormatCreateVideoFormat.setByteBuffer("csd-0", byteBufferAllocate);
                                mediaFormatCreateVideoFormat.setByteBuffer("csd-1", byteBufferAllocate2);
                            }
                            this.u = this.s.a(mediaFormatCreateVideoFormat, false);
                        }
                    }
                    this.m.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    if ((this.q.flags & 4) != 0) {
                        break;
                    }
                }
            }
            while (true) {
                int iDequeueOutputBuffer2 = this.n.dequeueOutputBuffer(this.r, 0L);
                if (iDequeueOutputBuffer2 == -1) {
                    if (!z) {
                        return;
                    }
                    if (!this.G && this.H == 0) {
                        return;
                    }
                } else if (iDequeueOutputBuffer2 != -3) {
                    if (iDequeueOutputBuffer2 == -2) {
                        MediaFormat outputFormat2 = this.n.getOutputFormat();
                        if (this.v == -5) {
                            this.v = this.s.a(outputFormat2, true);
                        }
                    } else if (iDequeueOutputBuffer2 < 0) {
                        continue;
                    } else {
                        ByteBuffer outputBuffer2 = this.n.getOutputBuffer(iDequeueOutputBuffer2);
                        if (outputBuffer2 == null) {
                            throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer2 + " was null");
                        }
                        MediaCodec.BufferInfo bufferInfo5 = this.r;
                        if ((bufferInfo5.flags & 2) != 0) {
                            bufferInfo5.size = 0;
                        }
                        if (bufferInfo5.size != 0) {
                            final MediaCodec.BufferInfo bufferInfo6 = new MediaCodec.BufferInfo();
                            MediaCodec.BufferInfo bufferInfo7 = this.r;
                            bufferInfo6.size = bufferInfo7.size;
                            bufferInfo6.offset = bufferInfo7.offset;
                            bufferInfo6.flags = bufferInfo7.flags;
                            bufferInfo6.presentationTimeUs = bufferInfo7.presentationTimeUs;
                            final ByteBuffer byteBufferY2 = AbstractC21455b.y(outputBuffer2);
                            this.a1.i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.camera.g
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.a.t(byteBufferY2, bufferInfo6);
                                }
                            });
                        }
                        this.n.releaseOutputBuffer(iDequeueOutputBuffer2, false);
                        if ((this.r.flags & 4) != 0) {
                            return;
                        }
                    }
                }
            }
        }

        public void o(SurfaceTexture surfaceTexture, Integer num, long j) {
            synchronized (this.B) {
                try {
                    if (this.D) {
                        long timestamp = surfaceTexture.getTimestamp();
                        if (timestamp == 0) {
                            int i = this.U0 + 1;
                            this.U0 = i;
                            if (i <= 1) {
                                return;
                            }
                            if (AbstractC8814Xl0.b) {
                                AbstractC6403Nl2.a("CameraView fix timestamp enabled");
                            }
                        } else {
                            this.U0 = 0;
                            j = timestamp;
                        }
                        this.A.sendMessage(this.A.obtainMessage(2, (int) (j >> 32), (int) j, num));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (this.B) {
                this.A = new g(this);
                this.D = true;
                this.B.notify();
            }
            Looper.loop();
            synchronized (this.B) {
                this.D = false;
            }
        }

        public void x(File file, android.opengl.EGLContext eGLContext) {
            String str = Build.DEVICE;
            RD6 rd6 = CameraView.this.c[0];
            int i = Math.min(rd6.b, rd6.a) >= 720 ? 3500000 : 1800000;
            this.a = file;
            if (CameraView.this.j[0].w() == 90 || CameraView.this.j[0].w() == 270) {
                CameraView.this.k1 = rd6.b();
                CameraView.this.l1 = rd6.a();
            } else {
                CameraView.this.k1 = rd6.a();
                CameraView.this.l1 = rd6.b();
            }
            this.d = i;
            this.j = eGLContext;
            synchronized (this.B) {
                try {
                    if (this.G) {
                        return;
                    }
                    this.G = true;
                    Thread thread = new Thread(this, "TextureMovieEncoder");
                    thread.setPriority(10);
                    thread.start();
                    while (!this.D) {
                        try {
                            this.B.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    HU1 hu1 = new HU1("VR_FileWriteQueue");
                    this.a1 = hu1;
                    hu1.setPriority(10);
                    this.Z0.clear();
                    this.A.sendMessage(this.A.obtainMessage(0));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void y(int i) {
            this.A.sendMessage(this.A.obtainMessage(1, i, 0));
        }

        private h() {
            this.e = true;
            this.h = EGL14.EGL_NO_DISPLAY;
            this.i = EGL14.EGL_NO_CONTEXT;
            this.l = EGL14.EGL_NO_SURFACE;
            this.t = new ArrayList();
            this.u = -5;
            this.v = -5;
            this.x = -1L;
            this.y = 0L;
            this.z = -1L;
            this.B = new Object();
            this.z0 = -1L;
            this.B0 = -1L;
            this.V0 = 0;
            this.Y0 = new ArrayBlockingQueue(10);
            this.Z0 = new ArrayList();
            this.b1 = new a();
        }
    }

    public CameraView(Context context, boolean z, boolean z2) {
        super(context, null);
        this.a = true;
        this.c = new RD6[2];
        this.d = new RD6[2];
        this.e = new ir.nasim.tgwidgets.editor.messenger.camera.b[2];
        this.j = new ir.nasim.tgwidgets.editor.messenger.camera.c[2];
        this.p = new Matrix();
        this.q = new Matrix();
        this.v = 1.0f;
        this.B = new Paint(1);
        this.D = new Paint(1);
        this.J = new DecelerateInterpolator();
        this.D0 = new Object();
        Class cls = Float.TYPE;
        this.E0 = (float[][]) Array.newInstance((Class<?>) cls, 2, 16);
        this.F0 = (float[][]) Array.newInstance((Class<?>) cls, 2, 16);
        this.G0 = (float[][]) Array.newInstance((Class<?>) cls, 2, 16);
        this.J0 = (float[][]) Array.newInstance((Class<?>) cls, 2, 16);
        this.K0 = 0.0f;
        this.P0 = false;
        this.Q0 = -1;
        this.U0 = new Matrix();
        this.Z0 = false;
        this.a1 = new Rect();
        this.b1 = 0;
        this.c1 = -1;
        this.d1 = -1;
        this.i1 = new Runnable() { // from class: ir.nasim.aE0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y0();
            }
        };
        this.j1 = 1.0f;
        this.m1 = new int[2];
        this.n1 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 1);
        this.o1 = new int[1];
        this.o = z;
        this.y = z;
        this.h = new TextureView(context);
        this.g = z2;
        if (!z2) {
            o0();
        }
        setWillNotDraw(!z2);
        ImageView imageView = new ImageView(context);
        this.i = imageView;
        addView(imageView, AbstractC13840gu3.d(-1, -1, 17));
        this.i.setVisibility(8);
        this.r = AbstractC21455b.F(96.0f);
        this.B.setColor(-1);
        this.B.setStyle(Paint.Style.STROKE);
        this.B.setStrokeWidth(AbstractC21455b.F(2.0f));
        this.D.setColor(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0() {
        this.k = false;
        synchronized (this.D0) {
            this.B0 = false;
        }
        Q0(0);
        this.g1.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(ValueAnimator valueAnimator) {
        this.h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0() {
        this.k = false;
        synchronized (this.D0) {
            this.B0 = false;
        }
        Q0(0);
        this.g1.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0() {
        this.W0 = false;
        this.T0 = false;
        c0(400L);
        Handler handlerD = this.g1.d();
        if (handlerD != null) {
            e eVar = this.g1;
            Objects.requireNonNull(eVar);
            eVar.l(handlerD.obtainMessage(10), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E0(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.b(GLES20.glGetShaderInfoLog(iGlCreateShader));
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(int i) {
        if (i != 0) {
            F0();
            return;
        }
        this.P0 = false;
        if (this.i.getVisibility() == 0) {
            this.i.animate().alpha(0.0f).setListener(new d()).setDuration(120L).start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Q0(int r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.CameraView.Q0(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.V0;
        if (j2 < jCurrentTimeMillis) {
            this.V0 = jCurrentTimeMillis + j;
        } else {
            this.V0 = j2 + j;
        }
    }

    private Rect d0(float f2, float f3, float f4) {
        int iIntValue = Float.valueOf(this.r * f4).intValue();
        int i = iIntValue / 2;
        RectF rectF = new RectF(f0(((int) f2) - i, 0, getWidth() - iIntValue), f0(((int) f3) - i, 0, getHeight() - iIntValue), r4 + iIntValue, r5 + iIntValue);
        this.q.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private void e0() {
        TextureView textureView;
        if (this.c[0] == null || (textureView = this.h) == null) {
            return;
        }
        int width = textureView.getWidth();
        int height = this.h.getHeight();
        Matrix matrix = new Matrix();
        if (this.j[0] != null) {
            matrix.postRotate(r1.s());
        }
        float f2 = width;
        float f3 = height;
        matrix.postScale(f2 / 2000.0f, f3 / 2000.0f);
        matrix.postTranslate(f2 / 2.0f, f3 / 2.0f);
        matrix.invert(this.q);
        e eVar = this.g1;
        if (eVar != null) {
            if (eVar.g()) {
                this.g1.i(this.i1);
            } else {
                this.i1.run();
            }
        }
    }

    private int f0(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(final SurfaceTexture surfaceTexture, final int i) {
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.XD0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t0(i, surfaceTexture);
            }
        });
    }

    private void j0() {
        if (this.j[1] != null) {
            if (this.W0) {
                return;
            }
            this.W0 = true;
            ir.nasim.tgwidgets.editor.messenger.camera.a.x().t(this.j[1], null, null, new Runnable() { // from class: ir.nasim.TD0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.w0();
                }
            });
            ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.M0;
            ir.nasim.tgwidgets.editor.messenger.camera.c[] cVarArr = this.j;
            if (cVar == cVarArr[1]) {
                this.M0 = null;
            }
            cVarArr[1] = null;
            c0(400L);
            return;
        }
        if (this.o || !"samsung".equalsIgnoreCase(Build.MANUFACTURER) || this.Y0 || this.j[0] == null) {
            Q0(1);
            Handler handlerD = this.g1.d();
            if (handlerD != null) {
                e eVar = this.g1;
                Objects.requireNonNull(eVar);
                eVar.l(handlerD.obtainMessage(6, this.e[1].a, 0, this.U0), 0);
            }
            c0(800L);
            return;
        }
        final Handler handlerD2 = this.g1.d();
        if (handlerD2 != null) {
            e eVar2 = this.g1;
            Objects.requireNonNull(eVar2);
            eVar2.l(handlerD2.obtainMessage(11), 0);
        }
        ir.nasim.tgwidgets.editor.messenger.camera.a.x().t(this.j[0], null, null, new Runnable() { // from class: ir.nasim.UD0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x0(handlerD2);
            }
        });
        this.j[0] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(e eVar, int i) {
        eVar.I(this.j[i], i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(final int i, SurfaceTexture surfaceTexture) {
        final e eVar = this.g1;
        if (eVar == null) {
            return;
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("CameraView create camera session " + i);
        }
        if (this.c[i] == null) {
            Q0(i);
        }
        RD6 rd6 = this.c[i];
        if (rd6 == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(rd6.b(), this.c[i].a());
        this.j[i] = new ir.nasim.tgwidgets.editor.messenger.camera.c(this.e[i], this.c[i], this.d[i], 256, false);
        this.j[i].C("off");
        eVar.I(this.j[i], i);
        requestLayout();
        ir.nasim.tgwidgets.editor.messenger.camera.a.x().S(this.j[i], surfaceTexture, new Runnable() { // from class: ir.nasim.YD0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v0(i, eVar);
            }
        }, new Runnable() { // from class: ir.nasim.ZD0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s0(eVar, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(e eVar) {
        Q0(0);
        eVar.G();
        c0(350L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(int i, final e eVar) {
        if (this.j[i] != null) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.a("CameraView camera initied " + i);
            }
            this.j[i].D();
            requestLayout();
        }
        if (this.S0 && i == 1 && this.X0) {
            this.X0 = false;
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.bE0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u0(eVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0() {
        this.W0 = false;
        j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Handler handler) {
        this.X0 = true;
        Q0(1);
        if (handler != null) {
            e eVar = this.g1;
            Objects.requireNonNull(eVar);
            eVar.l(handler.obtainMessage(6, this.e[1].a, 0, this.U0), 0);
        }
        c0(1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0() {
        e eVar = this.g1;
        if (eVar != null) {
            for (int i = 0; i < 2; i++) {
                if (eVar.n[i] != null) {
                    int iW = eVar.n[i].w();
                    android.opengl.Matrix.setIdentityM(this.E0[i], 0);
                    if (iW != 0) {
                        android.opengl.Matrix.rotateM(this.E0[i], 0, iW, 0.0f, 0.0f, 1.0f);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0() {
        this.g1 = null;
    }

    protected void F0() {
    }

    public void H0() {
        e eVar = this.g1;
        if (eVar != null) {
            eVar.F(600L);
        }
    }

    public void I0() {
        ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.j[0];
        if (cVar != null) {
            if (this.M0 == cVar) {
                this.M0 = null;
            }
            Handler handlerD = this.g1.d();
            if (handlerD != null) {
                e eVar = this.g1;
                Objects.requireNonNull(eVar);
                eVar.l(handlerD.obtainMessage(11), 0);
            }
            ir.nasim.tgwidgets.editor.messenger.camera.a.x().t(this.j[0], null, null, new Runnable() { // from class: ir.nasim.cE0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.A0();
                }
            });
            this.j[0] = null;
        }
    }

    public void J0() {
        long[] jArr = {0, 1};
        if (Build.VERSION.SDK_INT < 26) {
            performHapticFeedback(3, 2);
            return;
        }
        Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
        VibrationEffect vibrationEffectCreateWaveform = VibrationEffect.createWaveform(jArr, -1);
        vibrator.cancel();
        vibrator.vibrate(vibrationEffectCreateWaveform);
    }

    public void K0(boolean z, boolean z2) {
        if (this.h == null) {
            return;
        }
        ValueAnimator valueAnimator = this.h1;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.h1 = null;
        }
        if (!z2) {
            this.h.setAlpha(z ? 1.0f : 0.0f);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.h.getAlpha(), z ? 1.0f : 0.0f);
        this.h1 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.SD0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.B0(valueAnimator2);
            }
        });
        this.h1.addListener(new c(z));
        this.h1.start();
    }

    public void L0() {
        Bitmap bitmap;
        ValueAnimator valueAnimator = this.N0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.i.animate().setListener(null).cancel();
        if (this.B0 && (bitmap = this.h.getBitmap(100, 100)) != null) {
            Utilities.blurBitmap(bitmap, 3, 1, bitmap.getWidth(), bitmap.getHeight(), bitmap.getRowBytes());
            this.i.setBackground(new BitmapDrawable(bitmap));
        }
        this.i.setAlpha(1.0f);
        this.i.setVisibility(0);
        this.O0 = false;
        this.P0 = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.N0 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new a());
        this.N0.addListener(new b());
        this.N0.setDuration(500L);
        this.N0.setInterpolator(InterpolatorC12631ew1.f);
        this.N0.start();
        invalidate();
    }

    public void M0() {
        this.j1 = 0.0f;
        invalidate();
        J0();
    }

    public void N0() {
        if (this.P0) {
            return;
        }
        if (System.currentTimeMillis() >= this.V0 || this.T0) {
            if (!this.S0) {
                L0();
                ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.j[0];
                if (cVar != null) {
                    if (this.M0 == cVar) {
                        this.M0 = null;
                    }
                    ir.nasim.tgwidgets.editor.messenger.camera.a.x().t(this.j[0], null, null, new Runnable() { // from class: ir.nasim.WD0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.C0();
                        }
                    });
                    this.j[0] = null;
                }
                this.o = !this.o;
                return;
            }
            if (!this.T0 || System.currentTimeMillis() - this.f1 < 420) {
                return;
            }
            this.f1 = System.currentTimeMillis();
            ir.nasim.tgwidgets.editor.messenger.camera.b[] bVarArr = this.e;
            ir.nasim.tgwidgets.editor.messenger.camera.b bVar = bVarArr[0];
            bVarArr[0] = bVarArr[1];
            bVarArr[1] = bVar;
            RD6[] rd6Arr = this.c;
            RD6 rd6 = rd6Arr[0];
            rd6Arr[0] = rd6Arr[1];
            rd6Arr[1] = rd6;
            RD6[] rd6Arr2 = this.d;
            RD6 rd62 = rd6Arr2[0];
            rd6Arr2[0] = rd6Arr2[1];
            rd6Arr2[1] = rd62;
            ir.nasim.tgwidgets.editor.messenger.camera.c[] cVarArr = this.j;
            ir.nasim.tgwidgets.editor.messenger.camera.c cVar2 = cVarArr[0];
            cVarArr[0] = cVarArr[1];
            cVarArr[1] = cVar2;
            this.o = !this.o;
            Handler handlerD = this.g1.d();
            if (handlerD != null) {
                Objects.requireNonNull(this.g1);
                handlerD.sendMessage(handlerD.obtainMessage(8));
            }
        }
    }

    public void O0() {
        P0(false);
    }

    public void P0(boolean z) {
        Handler handlerD;
        if (!z) {
            if (this.P0 || this.W0) {
                return;
            }
            if ((System.currentTimeMillis() < this.V0 || this.S0 != this.T0) && !this.S0) {
                return;
            }
        }
        c0(200L);
        boolean z2 = !this.S0;
        this.S0 = z2;
        if (z2) {
            ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.j[0];
            if (cVar != null) {
                cVar.C("off");
            }
            j0();
        } else {
            ir.nasim.tgwidgets.editor.messenger.camera.c cVar2 = this.j[1];
            if (cVar2 == null || !cVar2.y()) {
                this.S0 = !this.S0;
                return;
            }
            ir.nasim.tgwidgets.editor.messenger.camera.c cVar3 = this.j[1];
            if (cVar3 != null) {
                this.W0 = true;
                if (this.M0 == cVar3) {
                    this.M0 = null;
                }
                ir.nasim.tgwidgets.editor.messenger.camera.a.x().t(this.j[1], null, null, new Runnable() { // from class: ir.nasim.dE0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.D0();
                    }
                });
                this.j[1] = null;
                this.c[1] = null;
                this.d[1] = null;
                this.e[1] = null;
            } else {
                this.T0 = false;
            }
            if (!this.W0 && (handlerD = this.g1.d()) != null) {
                e eVar = this.g1;
                Objects.requireNonNull(eVar);
                eVar.l(handlerD.obtainMessage(10), 0);
            }
        }
        this.Y0 = false;
    }

    public void R0() {
        Handler handlerD;
        e eVar = this.g1;
        if (eVar == null || (handlerD = eVar.d()) == null) {
            return;
        }
        e eVar2 = this.g1;
        Objects.requireNonNull(eVar2);
        eVar2.l(handlerD.obtainMessage(7, this.U0), 0);
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.a.c
    public void a() {
        this.g1.L();
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.a.c
    public boolean b(File file, Runnable runnable) {
        this.M0 = this.j[0];
        this.g1.K(file);
        this.L0 = runnable;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.N0 != null) {
            canvas.drawColor(-16777216);
        }
        super.dispatchDraw(canvas);
        float f2 = this.j1;
        if (f2 != 1.0f) {
            float f3 = f2 + 0.10666667f;
            this.j1 = f3;
            if (f3 > 1.0f) {
                this.j1 = 1.0f;
            } else {
                invalidate();
            }
            canvas.drawColor(QY0.k(-16777216, (int) ((1.0f - this.j1) * 150.0f)));
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.v != 1.0f || this.w != 0.0f || this.x != 0.0f) {
            int iF = AbstractC21455b.F(30.0f);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis - this.u;
            if (j2 < 0 || j2 > 17) {
                j2 = 17;
            }
            this.u = jCurrentTimeMillis;
            this.B.setAlpha((int) (this.J.getInterpolation(this.x) * 255.0f));
            this.D.setAlpha((int) (this.J.getInterpolation(this.w) * 127.0f));
            float interpolation = this.J.getInterpolation(this.v);
            float f2 = iF;
            canvas.drawCircle(this.z, this.A, ((1.0f - interpolation) * f2) + f2, this.B);
            canvas.drawCircle(this.z, this.A, f2 * interpolation, this.D);
            float f3 = this.v;
            if (f3 < 1.0f) {
                float f4 = f3 + (j2 / 200.0f);
                this.v = f4;
                if (f4 > 1.0f) {
                    this.v = 1.0f;
                }
                invalidate();
            } else {
                float f5 = this.w;
                if (f5 != 0.0f) {
                    float f6 = f5 - (j2 / 150.0f);
                    this.w = f6;
                    if (f6 < 0.0f) {
                        this.w = 0.0f;
                    }
                    invalidate();
                } else {
                    float f7 = this.x;
                    if (f7 != 0.0f) {
                        float f8 = f7 - (j2 / 150.0f);
                        this.x = f8;
                        if (f8 < 0.0f) {
                            this.x = 0.0f;
                        }
                        invalidate();
                    }
                }
            }
        }
        return zDrawChild;
    }

    public ir.nasim.tgwidgets.editor.messenger.camera.c getCameraSession() {
        return n0(0);
    }

    public ir.nasim.tgwidgets.editor.messenger.camera.c getCameraSessionRecording() {
        return this.M0;
    }

    public Matrix getDualPosition() {
        return this.U0;
    }

    public int getDualShape() {
        if (this.e1 == null) {
            this.e1 = Integer.valueOf(C.m().getInt("dualshape", 0));
        }
        return this.e1.intValue();
    }

    @Override // android.view.View
    public Matrix getMatrix() {
        return this.p;
    }

    public RD6 getPreviewSize() {
        return this.c[0];
    }

    public TextureView getTextureView() {
        return this.h;
    }

    public int getVideoHeight() {
        return this.l1;
    }

    public int getVideoWidth() {
        return this.k1;
    }

    public void h0(boolean z, Runnable runnable) {
        for (int i = 0; i < 2; i++) {
            ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.j[i];
            if (cVar != null) {
                cVar.p();
                ir.nasim.tgwidgets.editor.messenger.camera.a.x().s(this.j[i], !z ? new CountDownLatch(1) : null, runnable);
            }
        }
    }

    public void i0() {
        if (this.P0 || !this.S0) {
            return;
        }
        Handler handlerD = this.g1.d();
        if (this.e1 == null) {
            this.e1 = Integer.valueOf(C.m().getInt("dualshape", 0));
        }
        this.e1 = Integer.valueOf(this.e1.intValue() + 1);
        C.m().edit().putInt("dualshape", this.e1.intValue()).apply();
        if (handlerD != null) {
            Objects.requireNonNull(this.g1);
            handlerD.sendMessage(handlerD.obtainMessage(9));
        }
    }

    public void k0(int i, int i2) {
        m0(i, i2, true);
    }

    public void l0(int i, int i2, int i3, int i4, int i5, boolean z) {
        float f2 = i2;
        float f3 = i3;
        Rect rectD0 = d0(f2, f3, 1.0f);
        Rect rectD02 = d0(f2, f3, 1.5f);
        ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.j[i];
        if (cVar != null) {
            cVar.q(rectD0, rectD02);
        }
        if (z) {
            this.v = 0.0f;
            this.w = 1.0f;
            this.x = 1.0f;
            this.z = i4;
            this.A = i5;
            this.u = System.currentTimeMillis();
            invalidate();
        }
    }

    public void m0(int i, int i2, boolean z) {
        l0(0, i, i2, i, i2, z);
    }

    public ir.nasim.tgwidgets.editor.messenger.camera.c n0(int i) {
        return this.j[i];
    }

    public void o0() {
        if (this.Z0) {
            return;
        }
        this.h.setSurfaceTextureListener(this);
        addView(this.h, 0, AbstractC13840gu3.d(-1, -1, 17));
        this.Z0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b1 = 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.s != null) {
            this.a1.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
            float intrinsicWidth = this.s.getIntrinsicWidth();
            float intrinsicHeight = this.s.getIntrinsicHeight();
            float fMin = 1.0f / Math.min(intrinsicWidth / Math.max(1, this.a1.width()), intrinsicHeight / Math.max(1, this.a1.height()));
            float f2 = (intrinsicWidth * fMin) / 2.0f;
            float f3 = (intrinsicHeight * fMin) / 2.0f;
            this.s.setBounds((int) (this.a1.centerX() - f2), (int) (this.a1.centerY() - f3), (int) (this.a1.centerX() + f2), (int) (this.a1.centerY() + f3));
            this.s.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        e0();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ir.nasim.tgwidgets.editor.messenger.camera.c cVar;
        int iB;
        int iA;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.c[0] != null && (cVar = this.j[0]) != null) {
            if ((this.c1 != size || this.d1 != size2) && this.b1 > 1) {
                cVar.I();
            }
            this.b1++;
            if (this.j[0].w() == 90 || this.j[0].w() == 270) {
                iB = this.c[0].b();
                iA = this.c[0].a();
            } else {
                iB = this.c[0].a();
                iA = this.c[0].b();
            }
            float f2 = iB;
            float f3 = iA;
            float fMax = Math.max(View.MeasureSpec.getSize(i) / f2, View.MeasureSpec.getSize(i2) / f3);
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            int i3 = (int) (f2 * fMax);
            this.h.getLayoutParams().width = i3;
            layoutParams.width = i3;
            ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
            int i4 = (int) (fMax * f3);
            this.h.getLayoutParams().height = i4;
            layoutParams2.height = i4;
        }
        super.onMeasure(i, i2);
        e0();
        this.c1 = size;
        this.d1 = size2;
        this.q1 = getMeasuredWidth();
        this.r1 = getMeasuredHeight();
        if (this.s1 <= 0.0f) {
            this.s1 = getMeasuredWidth();
            this.t1 = getMeasuredHeight();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Q0(0);
        if (this.S0) {
            Q0(1);
        }
        this.A0 = i2;
        this.z0 = i;
        if (this.g1 != null || surfaceTexture == null) {
            return;
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("CameraView start create thread");
        }
        this.g1 = new e(surfaceTexture);
        e0();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        e eVar = this.g1;
        if (eVar != null) {
            eVar.J(0);
            this.g1.i(new Runnable() { // from class: ir.nasim.VD0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.z0();
                }
            });
        }
        if (this.j[0] != null) {
            ir.nasim.tgwidgets.editor.messenger.camera.a.x().s(this.j[0], null, null);
        }
        if (this.j[1] != null) {
            ir.nasim.tgwidgets.editor.messenger.camera.a.x().s(this.j[1], null, null);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.A0 = i2;
        this.z0 = i;
        e0();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        ir.nasim.tgwidgets.editor.messenger.camera.c cVar;
        if (this.k || (cVar = this.j[0]) == null || !cVar.y()) {
            return;
        }
        f fVar = this.l;
        if (fVar != null) {
            fVar.a();
        }
        this.k = true;
        if (this.g) {
            this.h.setAlpha(0.0f);
            K0(true, true);
        }
    }

    public boolean p0() {
        return this.S0;
    }

    public boolean q0() {
        return this.o;
    }

    public boolean r0() {
        return this.k;
    }

    public void setClipBottom(int i) {
        this.n = i;
    }

    public void setClipTop(int i) {
        this.m = i;
    }

    public void setDelegate(f fVar) {
        this.l = fVar;
    }

    public void setFpsLimit(int i) {
        this.Q0 = i;
    }

    public void setMirror(boolean z) {
        this.f = z;
    }

    public void setOptimizeForBarcode(boolean z) {
        this.G = z;
        ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.j[0];
        if (cVar != null) {
            cVar.E(true);
        }
    }

    public void setRecordFile(File file) {
        this.H = file;
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.s;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.s = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (this.B0) {
            return;
        }
        this.i.animate().setListener(null).cancel();
        this.i.setBackground(this.s);
        this.i.setAlpha(1.0f);
        this.i.setVisibility(0);
    }

    public void setUseMaxPreview(boolean z) {
        this.t = z;
    }

    public void setZoom(float f2) {
        ir.nasim.tgwidgets.editor.messenger.camera.c cVar = this.j[0];
        if (cVar != null) {
            cVar.F(f2);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.s || super.verifyDrawable(drawable);
    }
}
