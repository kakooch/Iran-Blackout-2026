package org.webrtc;

import android.opengl.GLES20;
import ir.eitaa.messenger.FileLog;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public class GlShader {
    private static final String TAG = "GlShader";
    private int program;

    private static int compileShader(int shaderType, String source) {
        int iGlCreateShader = GLES20.glCreateShader(shaderType);
        if (iGlCreateShader == 0) {
            throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glShaderSource(iGlCreateShader, source);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            Logging.e(TAG, "Compile error " + GLES20.glGetShaderInfoLog(iGlCreateShader) + " in shader:\n" + source);
            throw new RuntimeException(GLES20.glGetShaderInfoLog(iGlCreateShader));
        }
        GlUtil.checkNoGLES2Error("compileShader");
        return iGlCreateShader;
    }

    public GlShader(String vertexSource, String fragmentSource) {
        int iCompileShader = compileShader(35633, vertexSource);
        int iCompileShader2 = compileShader(35632, fragmentSource);
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.program = iGlCreateProgram;
        if (iGlCreateProgram == 0) {
            throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glAttachShader(iGlCreateProgram, iCompileShader);
        GLES20.glAttachShader(this.program, iCompileShader2);
        GLES20.glLinkProgram(this.program);
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.program, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return;
        }
        Logging.e(TAG, "Could not link program: " + GLES20.glGetProgramInfoLog(this.program));
        throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
    }

    public int getAttribLocation(String label) {
        int i = this.program;
        if (i == -1) {
            throw new RuntimeException("The program has been released");
        }
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(i, label);
        if (iGlGetAttribLocation >= 0) {
            return iGlGetAttribLocation;
        }
        throw new RuntimeException("Could not locate '" + label + "' in program");
    }

    public void setVertexAttribArray(String label, int dimension, FloatBuffer buffer) {
        setVertexAttribArray(label, dimension, 0, buffer);
    }

    public void setVertexAttribArray(String label, int dimension, int stride, FloatBuffer buffer) {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        int attribLocation = getAttribLocation(label);
        GLES20.glEnableVertexAttribArray(attribLocation);
        GLES20.glVertexAttribPointer(attribLocation, dimension, 5126, false, stride, (Buffer) buffer);
        GlUtil.checkNoGLES2Error("setVertexAttribArray");
    }

    public int getUniformLocation(String label) {
        int i = this.program;
        if (i == -1) {
            throw new RuntimeException("The program has been released");
        }
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(i, label);
        if (iGlGetUniformLocation >= 0) {
            return iGlGetUniformLocation;
        }
        throw new RuntimeException("Could not locate uniform '" + label + "' in program");
    }

    public void useProgram() {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        synchronized (EglBase.lock) {
            GLES20.glUseProgram(this.program);
        }
        try {
            GlUtil.checkNoGLES2Error("glUseProgram");
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void release() {
        Logging.d(TAG, "Deleting shader.");
        int i = this.program;
        if (i != -1) {
            GLES20.glDeleteProgram(i);
            this.program = -1;
        }
    }
}
