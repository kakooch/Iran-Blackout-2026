package com.pedro.encoder.input.gl.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.pedro.encoder.input.video.CameraHelper;
import com.pedro.encoder.utils.gl.GlUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public class CameraRender extends BaseRenderOffScreen {
    private SurfaceTexture surfaceTexture;
    private int[] textureID = new int[1];
    private float[] rotationMatrix = new float[16];
    private float[] scaleMatrix = new float[16];
    private int program = -1;
    private int uMVPMatrixHandle = -1;
    private int uSTMatrixHandle = -1;
    private int aPositionHandle = -1;
    private int aTextureCameraHandle = -1;

    public CameraRender() {
        Matrix.setIdentityM(this.MVPMatrix, 0);
        Matrix.setIdentityM(this.STMatrix, 0);
        float[] verticesData = CameraHelper.getVerticesData();
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(verticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.squareVertex = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(verticesData).position(0);
        setRotation(0);
        setFlip(false, false);
    }

    public void initGl(int i, int i2, Context context, int i3, int i4) {
        this.width = i;
        this.height = i2;
        GlUtil.checkGlError("initGl start");
        this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
        this.aTextureCameraHandle = GLES20.glGetAttribLocation(this.program, "aTextureCoord");
        this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMVPMatrix");
        this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.program, "uSTMatrix");
        this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.program, "uSTMatrix");
        GlUtil.createExternalTextures(1, this.textureID, 0);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureID[0]);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(i, i2);
        new Surface(this.surfaceTexture);
        initFBO(i, i2);
        GlUtil.checkGlError("initGl end");
    }

    public void draw() {
        GlUtil.checkGlError("drawCamera start");
        GLES20.glBindFramebuffer(36160, this.renderHandler.getFboId()[0]);
        this.surfaceTexture.getTransformMatrix(this.STMatrix);
        GLES20.glViewport(0, 0, this.width, this.height);
        GLES20.glUseProgram(this.program);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        this.squareVertex.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, 20, (Buffer) this.squareVertex);
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        this.squareVertex.position(3);
        GLES20.glVertexAttribPointer(this.aTextureCameraHandle, 2, 5126, false, 20, (Buffer) this.squareVertex);
        GLES20.glEnableVertexAttribArray(this.aTextureCameraHandle);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, this.MVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uSTMatrixHandle, 1, false, this.STMatrix, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.textureID[0]);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkGlError("drawCamera end");
    }

    @Override // com.pedro.encoder.input.gl.render.BaseRenderOffScreen
    public void release() {
        GLES20.glDeleteProgram(this.program);
        this.surfaceTexture = null;
    }

    public void updateTexImage() {
        this.surfaceTexture.updateTexImage();
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public void setRotation(int i) {
        Matrix.setIdentityM(this.rotationMatrix, 0);
        Matrix.rotateM(this.rotationMatrix, 0, i, 0.0f, 0.0f, -1.0f);
        update();
    }

    public void setFlip(boolean z, boolean z2) {
        Matrix.setIdentityM(this.scaleMatrix, 0);
        Matrix.scaleM(this.scaleMatrix, 0, z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, 1.0f);
        update();
    }

    private void update() {
        Matrix.setIdentityM(this.MVPMatrix, 0);
        float[] fArr = this.MVPMatrix;
        Matrix.multiplyMM(fArr, 0, this.scaleMatrix, 0, fArr, 0);
        float[] fArr2 = this.MVPMatrix;
        Matrix.multiplyMM(fArr2, 0, this.rotationMatrix, 0, fArr2, 0);
    }
}
