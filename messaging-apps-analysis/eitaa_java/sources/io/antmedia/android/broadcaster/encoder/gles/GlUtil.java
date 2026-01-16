package io.antmedia.android.broadcaster.encoder.gles;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX;

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static int createProgram(String vertexSource, String fragmentSource) {
        int iLoadShader;
        int iLoadShader2 = loadShader(35633, vertexSource);
        if (iLoadShader2 == 0 || (iLoadShader = loadShader(35632, fragmentSource)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        if (iGlCreateProgram == 0) {
            Log.e("Grafika", "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        Log.e("Grafika", "Could not link program: ");
        Log.e("Grafika", GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public static int loadShader(int shaderType, String source) {
        int iGlCreateShader = GLES20.glCreateShader(shaderType);
        checkGlError("glCreateShader type=" + shaderType);
        GLES20.glShaderSource(iGlCreateShader, source);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.e("Grafika", "Could not compile shader " + shaderType + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.e("Grafika", sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static void checkGlError(String op) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str = op + ": glError 0x" + Integer.toHexString(iGlGetError);
        Log.e("Grafika", str);
        throw new RuntimeException(str);
    }

    public static void checkLocation(int location, String label) {
        if (location >= 0) {
            return;
        }
        throw new RuntimeException("Unable to locate '" + label + "' in program");
    }

    public static FloatBuffer createFloatBuffer(float[] coords) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(coords.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(coords);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
