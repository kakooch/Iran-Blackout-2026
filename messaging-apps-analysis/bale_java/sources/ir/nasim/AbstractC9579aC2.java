package ir.nasim;

import android.gov.nist.core.Separators;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.aC2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9579aC2 {
    public static final int[] a = {12344};
    public static final int[] b = {12445, 13632, 12344};
    public static final String c;
    public static final String d;
    private static final InterfaceC4864Gw6 e;
    private static final InterfaceC4864Gw6 f;
    private static final InterfaceC4864Gw6 g;
    public static final float[] h;
    public static final FloatBuffer i;
    public static final float[] j;
    public static final FloatBuffer k;
    public static final HN4 l;

    /* renamed from: ir.nasim.aC2$a */
    class a implements InterfaceC4864Gw6 {
        a() {
        }

        @Override // ir.nasim.InterfaceC4864Gw6
        public String a(String str, String str2) {
            return String.format(Locale.US, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 %s;\nuniform samplerExternalOES %s;\nuniform float uAlphaScale;\nvoid main() {\n    vec4 src = texture2D(%s, %s);\n    gl_FragColor = vec4(src.rgb, src.a * uAlphaScale);\n}\n", str2, str, str, str2);
        }
    }

    /* renamed from: ir.nasim.aC2$b */
    class b implements InterfaceC4864Gw6 {
        b() {
        }

        @Override // ir.nasim.InterfaceC4864Gw6
        public String a(String str, String str2) {
            return String.format(Locale.US, "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nuniform samplerExternalOES %s;\nuniform float uAlphaScale;\nin vec2 %s;\nout vec4 outColor;\n\nvoid main() {\n  vec4 src = texture(%s, %s);\n  outColor = vec4(src.rgb, src.a * uAlphaScale);\n}", str, str2, str, str2);
        }
    }

    /* renamed from: ir.nasim.aC2$c */
    class c implements InterfaceC4864Gw6 {
        c() {
        }

        @Override // ir.nasim.InterfaceC4864Gw6
        public String a(String str, String str2) {
            return String.format(Locale.US, "#version 300 es\n#extension GL_EXT_YUV_target : require\nprecision mediump float;\nuniform __samplerExternal2DY2YEXT %s;\nuniform float uAlphaScale;\nin vec2 %s;\nout vec4 outColor;\n\nvec3 yuvToRgb(vec3 yuv) {\n  const vec3 yuvOffset = vec3(0.0625, 0.5, 0.5);\n  const mat3 yuvToRgbColorMat = mat3(\n    1.1689f, 1.1689f, 1.1689f,\n    0.0000f, -0.1881f, 2.1502f,\n    1.6853f, -0.6530f, 0.0000f\n  );\n  return clamp(yuvToRgbColorMat * (yuv - yuvOffset), 0.0, 1.0);\n}\n\nvoid main() {\n  vec3 srcYuv = texture(%s, %s).xyz;\n  vec3 srcRgb = yuvToRgb(srcYuv);\n  outColor = vec4(srcRgb, uAlphaScale);\n}", str, str2, str, str2);
        }
    }

    /* renamed from: ir.nasim.aC2$d */
    public static class d extends f {
        public d() {
            super("uniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n}\n", "precision mediump float;\nuniform float uAlphaScale;\nvoid main() {\n    gl_FragColor = vec4(0.0, 0.0, 0.0, uAlphaScale);\n}\n");
        }
    }

    /* renamed from: ir.nasim.aC2$e */
    public enum e {
        UNKNOWN,
        DEFAULT,
        YUV
    }

    /* renamed from: ir.nasim.aC2$f */
    public static abstract class f {
        protected int a;
        protected int b = -1;
        protected int c = -1;
        protected int d = -1;

        /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected f(java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.String r0 = "glAttachShader"
                r6.<init>()
                r1 = -1
                r6.b = r1
                r6.c = r1
                r6.d = r1
                r2 = 35633(0x8b31, float:4.9932E-41)
                int r7 = ir.nasim.AbstractC9579aC2.y(r2, r7)     // Catch: java.lang.IllegalArgumentException -> L70 java.lang.IllegalStateException -> L74
                r2 = 35632(0x8b30, float:4.9931E-41)
                int r8 = ir.nasim.AbstractC9579aC2.y(r2, r8)     // Catch: java.lang.IllegalArgumentException -> L6a java.lang.IllegalStateException -> L6e
                int r2 = android.opengl.GLES20.glCreateProgram()     // Catch: java.lang.IllegalArgumentException -> L65 java.lang.IllegalStateException -> L68
                java.lang.String r3 = "glCreateProgram"
                ir.nasim.AbstractC9579aC2.g(r3)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                android.opengl.GLES20.glAttachShader(r2, r7)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                ir.nasim.AbstractC9579aC2.g(r0)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                android.opengl.GLES20.glAttachShader(r2, r8)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                ir.nasim.AbstractC9579aC2.g(r0)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                android.opengl.GLES20.glLinkProgram(r2)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                r0 = 1
                int[] r3 = new int[r0]     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                r4 = 35714(0x8b82, float:5.0046E-41)
                r5 = 0
                android.opengl.GLES20.glGetProgramiv(r2, r4, r3, r5)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                r3 = r3[r5]     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                if (r3 != r0) goto L4a
                r6.a = r2     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                r6.c()
                return
            L46:
                r0 = move-exception
                goto L76
            L48:
                r0 = move-exception
                goto L76
            L4a:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                r3.<init>()     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                java.lang.String r4 = "Could not link program: "
                r3.append(r4)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                java.lang.String r4 = android.opengl.GLES20.glGetProgramInfoLog(r2)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                r3.append(r4)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                java.lang.String r3 = r3.toString()     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                r0.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
                throw r0     // Catch: java.lang.IllegalArgumentException -> L46 java.lang.IllegalStateException -> L48
            L65:
                r0 = move-exception
            L66:
                r2 = r1
                goto L76
            L68:
                r0 = move-exception
                goto L66
            L6a:
                r0 = move-exception
            L6b:
                r8 = r1
            L6c:
                r2 = r8
                goto L76
            L6e:
                r0 = move-exception
                goto L6b
            L70:
                r0 = move-exception
            L71:
                r7 = r1
                r8 = r7
                goto L6c
            L74:
                r0 = move-exception
                goto L71
            L76:
                if (r7 == r1) goto L7b
                android.opengl.GLES20.glDeleteShader(r7)
            L7b:
                if (r8 == r1) goto L80
                android.opengl.GLES20.glDeleteShader(r8)
            L80:
                if (r2 == r1) goto L85
                android.opengl.GLES20.glDeleteProgram(r2)
            L85:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9579aC2.f.<init>(java.lang.String, java.lang.String):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.a, "aPosition");
            this.d = iGlGetAttribLocation;
            AbstractC9579aC2.j(iGlGetAttribLocation, "aPosition");
            int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.a, "uTransMatrix");
            this.b = iGlGetUniformLocation;
            AbstractC9579aC2.j(iGlGetUniformLocation, "uTransMatrix");
            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.a, "uAlphaScale");
            this.c = iGlGetUniformLocation2;
            AbstractC9579aC2.j(iGlGetUniformLocation2, "uAlphaScale");
        }

        public void b() {
            GLES20.glDeleteProgram(this.a);
        }

        public void d(float f) {
            GLES20.glUniform1f(this.c, f);
            AbstractC9579aC2.g("glUniform1f");
        }

        public void e(float[] fArr) {
            GLES20.glUniformMatrix4fv(this.b, 1, false, fArr, 0);
            AbstractC9579aC2.g("glUniformMatrix4fv");
        }

        public void f() {
            GLES20.glUseProgram(this.a);
            AbstractC9579aC2.g("glUseProgram");
            GLES20.glEnableVertexAttribArray(this.d);
            AbstractC9579aC2.g("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, (Buffer) AbstractC9579aC2.i);
            AbstractC9579aC2.g("glVertexAttribPointer");
            e(AbstractC9579aC2.l());
            d(1.0f);
        }
    }

    /* renamed from: ir.nasim.aC2$g */
    public static class g extends f {
        private int e;
        private int f;
        private int g;

        public g(C15116j22 c15116j22, e eVar) {
            this(c15116j22, g(c15116j22, eVar));
        }

        private void c() {
            c();
            int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.a, "sTexture");
            this.e = iGlGetUniformLocation;
            AbstractC9579aC2.j(iGlGetUniformLocation, "sTexture");
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
            this.g = iGlGetAttribLocation;
            AbstractC9579aC2.j(iGlGetAttribLocation, "aTextureCoord");
            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.a, "uTexMatrix");
            this.f = iGlGetUniformLocation2;
            AbstractC9579aC2.j(iGlGetUniformLocation2, "uTexMatrix");
        }

        private static InterfaceC4864Gw6 g(C15116j22 c15116j22, e eVar) {
            if (!c15116j22.d()) {
                return AbstractC9579aC2.e;
            }
            AbstractC4980Hj5.b(eVar != e.UNKNOWN, "No default sampler shader available for" + eVar);
            return eVar == e.YUV ? AbstractC9579aC2.g : AbstractC9579aC2.f;
        }

        @Override // ir.nasim.AbstractC9579aC2.f
        public void f() {
            super.f();
            GLES20.glUniform1i(this.e, 0);
            GLES20.glEnableVertexAttribArray(this.g);
            AbstractC9579aC2.g("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 0, (Buffer) AbstractC9579aC2.k);
            AbstractC9579aC2.g("glVertexAttribPointer");
        }

        public void h(float[] fArr) {
            GLES20.glUniformMatrix4fv(this.f, 1, false, fArr, 0);
            AbstractC9579aC2.g("glUniformMatrix4fv");
        }

        public g(C15116j22 c15116j22, InterfaceC4864Gw6 interfaceC4864Gw6) {
            super(c15116j22.d() ? AbstractC9579aC2.d : AbstractC9579aC2.c, AbstractC9579aC2.v(interfaceC4864Gw6));
            this.e = -1;
            this.f = -1;
            this.g = -1;
            c();
        }
    }

    static {
        Locale locale = Locale.US;
        c = String.format(locale, "uniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", "vTextureCoord", "vTextureCoord");
        d = String.format(locale, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = uTransMatrix * aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", "vTextureCoord", "vTextureCoord");
        e = new a();
        f = new b();
        g = new c();
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        h = fArr;
        i = m(fArr);
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        j = fArr2;
        k = m(fArr2);
        l = HN4.d(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    public static void e(String str) {
        try {
            f(str);
        } catch (IllegalStateException e2) {
            PI3.d("GLUtils", e2.toString(), e2);
        }
    }

    public static void f(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    public static void g(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(iGlGetError));
    }

    public static void h(Thread thread) {
        AbstractC4980Hj5.j(thread == Thread.currentThread(), "Method call must be called on the GL thread.");
    }

    public static void i(AtomicBoolean atomicBoolean, boolean z) {
        AbstractC4980Hj5.j(z == atomicBoolean.get(), z ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized");
    }

    public static void j(int i2, String str) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalStateException("Unable to locate '" + str + "' in program");
    }

    public static int[] k(String str, C15116j22 c15116j22) {
        int[] iArr = a;
        if (c15116j22.b() != 3) {
            return iArr;
        }
        if (str.contains("EGL_EXT_gl_colorspace_bt2020_hlg")) {
            return b;
        }
        PI3.l("GLUtils", "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        return iArr;
    }

    public static float[] l() {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        return fArr;
    }

    public static FloatBuffer m(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public static EGLSurface n(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, i2, 12374, i3, 12344}, 0);
        f("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface != null) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    public static Map o(C15116j22 c15116j22, Map map) {
        Object gVar;
        e eVar;
        HashMap map2 = new HashMap();
        e[] eVarArrValues = e.values();
        int length = eVarArrValues.length;
        for (int i2 = 0; i2 < length; i2++) {
            e eVar2 = eVarArrValues[i2];
            InterfaceC4864Gw6 interfaceC4864Gw6 = (InterfaceC4864Gw6) map.get(eVar2);
            if (interfaceC4864Gw6 != null) {
                gVar = new g(c15116j22, interfaceC4864Gw6);
            } else if (eVar2 == e.YUV || eVar2 == (eVar = e.DEFAULT)) {
                gVar = new g(c15116j22, eVar2);
            } else {
                AbstractC4980Hj5.j(eVar2 == e.UNKNOWN, "Unhandled input format: " + eVar2);
                if (c15116j22.d()) {
                    gVar = new d();
                } else {
                    InterfaceC4864Gw6 interfaceC4864Gw62 = (InterfaceC4864Gw6) map.get(eVar);
                    gVar = interfaceC4864Gw62 != null ? new g(c15116j22, interfaceC4864Gw62) : new g(c15116j22, eVar);
                }
            }
            Log.d("GLUtils", "Shader program for input format " + eVar2 + " created: " + gVar);
            map2.put(eVar2, gVar);
        }
        return map2;
    }

    public static int p() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g("glGenTextures");
        int i2 = iArr[0];
        GLES20.glBindTexture(36197, i2);
        g("glBindTexture " + i2);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        g("glTexParameter");
        return i2;
    }

    public static EGLSurface q(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Surface surface, int[] iArr) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, iArr, 0);
        f("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    public static void r(int i2) {
        GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
        g("glDeleteFramebuffers");
    }

    public static void s(int i2) {
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
        g("glDeleteTextures");
    }

    public static int t() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        g("glGenFramebuffers");
        return iArr[0];
    }

    public static int u() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g("glGenTextures");
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String v(InterfaceC4864Gw6 interfaceC4864Gw6) {
        try {
            String strA = interfaceC4864Gw6.a("sTexture", "vTextureCoord");
            if (strA != null && strA.contains("vTextureCoord") && strA.contains("sTexture")) {
                return strA;
            }
            throw new IllegalArgumentException("Invalid fragment shader");
        } catch (Throwable th) {
            if (th instanceof IllegalArgumentException) {
                throw th;
            }
            throw new IllegalArgumentException("Unable retrieve fragment shader source", th);
        }
    }

    public static String w() {
        Matcher matcher = Pattern.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (!matcher.find()) {
            return "0.0";
        }
        return ((String) AbstractC4980Hj5.g(matcher.group(1))) + Separators.DOT + ((String) AbstractC4980Hj5.g(matcher.group(2)));
    }

    public static Size x(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        return new Size(z(eGLDisplay, eGLSurface, 12375), z(eGLDisplay, eGLSurface, 12374));
    }

    public static int y(int i2, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        g("glCreateShader type=" + i2);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        PI3.l("GLUtils", "Could not compile shader: " + str);
        GLES20.glDeleteShader(iGlCreateShader);
        throw new IllegalStateException("Could not compile shader type " + i2 + ":" + GLES20.glGetShaderInfoLog(iGlCreateShader));
    }

    public static int z(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i2) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i2, iArr, 0);
        return iArr[0];
    }
}
