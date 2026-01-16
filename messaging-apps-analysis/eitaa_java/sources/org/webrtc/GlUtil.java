package org.webrtc;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public class GlUtil {
    public static void checkNoGLES2Error(String msg) {
    }

    private GlUtil() {
    }

    public static class GlOutOfMemoryException extends RuntimeException {
        public GlOutOfMemoryException(String msg) {
            super(msg);
        }
    }

    public static FloatBuffer createFloatBuffer(float[] coords) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(coords.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(coords);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public static int generateTexture(int target) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glBindTexture(target, i);
        GLES20.glTexParameterf(target, 10241, 9729.0f);
        GLES20.glTexParameterf(target, 10240, 9729.0f);
        GLES20.glTexParameterf(target, 10242, 33071.0f);
        GLES20.glTexParameterf(target, 10243, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return i;
    }
}
