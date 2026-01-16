package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b {
    private final int a;
    private final a[] b;
    private final C0167b[] c;
    private final Map d;
    private final Map e;

    private static final class a {
        public final String a;
        private final int b;
        private final int c;

        private a(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public static a a(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35722, iArr, 0);
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            GLES20.glGetActiveAttrib(i, i2, i3, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, b.h(bArr));
            return new a(str, i2, b.f(i, str));
        }
    }

    /* renamed from: com.google.android.exoplayer2.util.b$b, reason: collision with other inner class name */
    private static final class C0167b {
        public final String a;
        private final int b;
        private final int c;
        private final float[] d = new float[16];

        private C0167b(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public static C0167b a(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            GLES20.glGetActiveUniform(i, i2, i3, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, b.h(bArr));
            return new C0167b(str, b.i(i, str), iArr2[0]);
        }
    }

    public b(String str, String str2) throws GlUtil.GlException {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.a = iGlCreateProgram;
        GlUtil.b();
        d(iGlCreateProgram, 35633, str);
        d(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        GlUtil.c(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glUseProgram(iGlCreateProgram);
        this.d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.b = new a[iArr2[0]];
        for (int i = 0; i < iArr2[0]; i++) {
            a aVarA = a.a(this.a, i);
            this.b[i] = aVarA;
            this.d.put(aVarA.a, aVarA);
        }
        this.e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.a, 35718, iArr3, 0);
        this.c = new C0167b[iArr3[0]];
        for (int i2 = 0; i2 < iArr3[0]; i2++) {
            C0167b c0167bA = C0167b.a(this.a, i2);
            this.c[i2] = c0167bA;
            this.e.put(c0167bA.a, c0167bA);
        }
        GlUtil.b();
    }

    private static void d(int i, int i2, String str) throws GlUtil.GlException {
        int iGlCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        GlUtil.c(iArr[0] == 1, GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        GlUtil.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i, String str) {
        return GLES20.glGetAttribLocation(i, str);
    }

    private int g(String str) {
        return f(this.a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    public int e(String str) throws GlUtil.GlException {
        int iG = g(str);
        GLES20.glEnableVertexAttribArray(iG);
        GlUtil.b();
        return iG;
    }

    public int j(String str) {
        return i(this.a, str);
    }
}
