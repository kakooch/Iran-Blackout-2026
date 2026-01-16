package com.pedro.encoder.utils.gl;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class GlUtil {
    public static void createExternalTextures(int i, int[] iArr, int i2) {
        GLES20.glGenTextures(i, iArr, i2);
        for (int i3 = 0; i3 < i; i3++) {
            GLES20.glActiveTexture(33984 + i2 + i3);
            GLES20.glBindTexture(36197, iArr[i2 + i3]);
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
        }
    }

    public static void checkGlError(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        Log.e("GlUtil", str + ": glError " + iGlGetError);
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public static void checkEglError(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    public static Bitmap getBitmap(int i, int i2, int i3, int i4) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, byteBufferAllocateDirect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        return flipVerticalBitmap(Bitmap.createScaledBitmap(bitmapCreateBitmap, i3, i4, false), i3, i4);
    }

    private static Bitmap flipVerticalBitmap(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, i / 2.0f, i2 / 2.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, i, i2, matrix, true);
    }
}
