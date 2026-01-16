package com.pedro.encoder.input.gl.render;

import android.opengl.GLES20;
import com.pedro.encoder.utils.gl.GlUtil;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public abstract class BaseRenderOffScreen {
    protected int height;
    protected FloatBuffer squareVertex;
    protected int width;
    protected float[] MVPMatrix = new float[16];
    protected float[] STMatrix = new float[16];
    protected RenderHandler renderHandler = new RenderHandler();

    public abstract void release();

    public int getTexId() {
        return this.renderHandler.getTexId()[0];
    }

    protected void initFBO(int i, int i2) {
        initFBO(i, i2, this.renderHandler.getFboId(), this.renderHandler.getRboId(), this.renderHandler.getTexId());
    }

    protected void initFBO(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        GlUtil.checkGlError("initFBO_S");
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glGenRenderbuffers(1, iArr2, 0);
        GLES20.glGenTextures(1, iArr3, 0);
        GLES20.glBindRenderbuffer(36161, iArr2[0]);
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, iArr2[0]);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, iArr3[0]);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr3[0], 0);
        int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (iGlCheckFramebufferStatus != 36053) {
            throw new RuntimeException("FrameBuffer uncompleted code: " + iGlCheckFramebufferStatus);
        }
        GlUtil.checkGlError("initFBO_E");
    }
}
