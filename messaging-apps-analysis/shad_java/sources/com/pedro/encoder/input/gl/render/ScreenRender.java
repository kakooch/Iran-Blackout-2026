package com.pedro.encoder.input.gl.render;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.pedro.encoder.input.video.CameraHelper;
import com.pedro.encoder.utils.gl.GlUtil;
import com.pedro.encoder.utils.gl.SizeCalculator;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public class ScreenRender {
    private boolean isPortrait;
    private FloatBuffer squareVertex;
    private final float[] squareVertexData;
    private int streamHeight;
    private int streamWidth;
    private int texId;
    private float[] MVPMatrix = new float[16];
    private float[] STMatrix = new float[16];
    private boolean AAEnabled = false;
    private int program = -1;
    private int uMVPMatrixHandle = -1;
    private int uSTMatrixHandle = -1;
    private int aPositionHandle = -1;
    private int aTextureHandle = -1;
    private int uSamplerHandle = -1;
    private int uResolutionHandle = -1;
    private int uAAEnabledHandle = -1;

    public ScreenRender() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.squareVertexData = fArr;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.squareVertex = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.MVPMatrix, 0);
        Matrix.setIdentityM(this.STMatrix, 0);
    }

    public void initGl(Context context) {
        this.isPortrait = CameraHelper.isPortrait(context);
        this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
        this.aTextureHandle = GLES20.glGetAttribLocation(this.program, "aTextureCoord");
        this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMVPMatrix");
        this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.program, "uSTMatrix");
        this.uSamplerHandle = GLES20.glGetUniformLocation(this.program, "uSampler");
        this.uResolutionHandle = GLES20.glGetUniformLocation(this.program, "uResolution");
        this.uAAEnabledHandle = GLES20.glGetUniformLocation(this.program, "uAAEnabled");
        GlUtil.checkGlError("initGl end");
    }

    public void draw(int i, int i2, boolean z, int i3, int i4, boolean z2) {
        GlUtil.checkGlError("drawScreen start");
        SizeCalculator.updateMatrix(i4, i, i2, z2, this.isPortrait, this.MVPMatrix);
        SizeCalculator.calculateViewPort(z, i3, i, i2, this.streamWidth, this.streamHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.program);
        this.squareVertex.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, 20, (Buffer) this.squareVertex);
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        this.squareVertex.position(3);
        GLES20.glVertexAttribPointer(this.aTextureHandle, 2, 5126, false, 20, (Buffer) this.squareVertex);
        GLES20.glEnableVertexAttribArray(this.aTextureHandle);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, this.MVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uSTMatrixHandle, 1, false, this.STMatrix, 0);
        GLES20.glUniform2f(this.uResolutionHandle, i, i2);
        GLES20.glUniform1f(this.uAAEnabledHandle, this.AAEnabled ? 1.0f : 0.0f);
        GLES20.glUniform1i(this.uSamplerHandle, 5);
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(3553, this.texId);
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError("drawScreen end");
    }

    public void release() {
        GLES20.glDeleteProgram(this.program);
    }

    public void setTexId(int i) {
        this.texId = i;
    }

    public void setAAEnabled(boolean z) {
        this.AAEnabled = z;
    }

    public void setStreamSize(int i, int i2) {
        this.streamWidth = i;
        this.streamHeight = i2;
    }
}
