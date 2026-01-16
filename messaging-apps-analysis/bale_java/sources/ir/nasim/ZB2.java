package ir.nasim;

import android.opengl.GLES20;

/* loaded from: classes8.dex */
public final class ZB2 {
    public static final ZB2 a = new ZB2();

    private ZB2() {
    }

    public static final void a(String str) {
        AbstractC13042fc3.i(str, "op");
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public static final int b(String str, String str2) {
        int iD;
        AbstractC13042fc3.i(str, "vertexSource");
        AbstractC13042fc3.i(str2, "fragmentSource");
        ZB2 zb2 = a;
        int iD2 = zb2.d(35633, str);
        if (iD2 == 0 || (iD = zb2.d(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, iD2);
            a("glAttachShader");
            GLES20.glAttachShader(iGlCreateProgram, iD);
            a("glAttachShader");
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String strGlGetProgramInfoLog = GLES20.glGetProgramInfoLog(iGlCreateProgram);
                GLES20.glDeleteProgram(iGlCreateProgram);
                throw new RuntimeException(AbstractC13042fc3.q("Could not link program: ", strGlGetProgramInfoLog));
            }
        }
        return iGlCreateProgram;
    }

    public static final void c() {
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
    }

    private final int d(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
                GLES20.glDeleteShader(iGlCreateShader);
                throw new RuntimeException("Could not compile shader " + i + ':' + ((Object) strGlGetShaderInfoLog));
            }
        }
        return iGlCreateShader;
    }
}
