package ir.appp.rghapp.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import ir.appp.rghapp.RGHMediaHelper$SavedFilterState;
import ir.appp.rghapp.components.SSHFilterShaders;
import ir.appp.rghapp.rubinoPostSlider.FilterShaders;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class SSHTextureRenderer {
    private final FloatBuffer bitmapVerticesBuffer;
    private boolean blendEnabled;
    private final Context context;
    private SSHFilterShaders filterShaders;
    private final String imagePath;
    private final float[] mMVPMatrix;
    private final int[] mProgram;
    private final float[] mSTMatrix;
    private final float[] mSTMatrixIdentity;
    private int mTextureID;
    private final int[] maPositionHandle;
    private final int[] maTextureHandle;
    private final int[] muMVPMatrixHandle;
    private final int[] muSTMatrixHandle;
    private int originalHeight;
    private int originalWidth;
    private final String paintPath;
    private int[] paintTexture;
    private final FloatBuffer renderTextureBuffer;
    private int simpleInputTexCoordHandle;
    private int simplePositionHandle;
    private int simpleShaderProgram;
    private int simpleSourceImageHandle;
    private final FloatBuffer textureBuffer;
    private int transformedHeight;
    private int transformedWidth;
    private final FloatBuffer verticesBuffer;
    float[] bitmapData = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private boolean firstFrame = true;

    public SSHTextureRenderer(Context context, RGHMediaHelper$SavedFilterState rGHMediaHelper$SavedFilterState, String str, String str2, MediaController.CropState cropState, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i;
        int i7 = i2;
        float[] fArr = new float[16];
        this.mMVPMatrix = fArr;
        float[] fArr2 = new float[16];
        this.mSTMatrix = fArr2;
        float[] fArr3 = new float[16];
        this.mSTMatrixIdentity = fArr3;
        this.context = context;
        float[] fArr4 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start textureRenderer w = " + i6 + " h = " + i7 + " r = " + i3);
            if (cropState != null) {
                FileLog.d("cropState px = " + cropState.cropPx + " py = " + cropState.cropPy + " cScale = " + cropState.cropScale + " cropRotate = " + cropState.cropRotate + " pw = " + cropState.cropPw + " ph = " + cropState.cropPh + " tw = " + cropState.transformWidth + " th = " + cropState.transformHeight + " tr = " + cropState.transformRotation + " mirror = " + cropState.mirrored);
            }
        }
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textureBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr4).position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(this.bitmapData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.bitmapVerticesBuffer = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(this.bitmapData).position(0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        if (rGHMediaHelper$SavedFilterState != null) {
            SSHFilterShaders sSHFilterShaders = new SSHFilterShaders(context, true, i4);
            this.filterShaders = sSHFilterShaders;
            sSHFilterShaders.setDelegate(SSHFilterShaders.getFilterShadersDelegate(rGHMediaHelper$SavedFilterState));
        }
        this.originalWidth = i6;
        this.transformedWidth = i6;
        this.originalHeight = i7;
        this.transformedHeight = i7;
        this.imagePath = str;
        this.paintPath = str2;
        int i8 = this.filterShaders != null ? 2 : 1;
        this.mProgram = new int[i8];
        this.muMVPMatrixHandle = new int[i8];
        this.muSTMatrixHandle = new int[i8];
        this.maPositionHandle = new int[i8];
        this.maTextureHandle = new int[i8];
        Matrix.setIdentityM(fArr, 0);
        if (cropState != null) {
            float[] fArr5 = new float[8];
            fArr5[0] = 0.0f;
            fArr5[1] = 0.0f;
            float f = i6;
            fArr5[2] = f;
            fArr5[3] = 0.0f;
            fArr5[4] = 0.0f;
            float f2 = i7;
            fArr5[5] = f2;
            fArr5[6] = f;
            fArr5[7] = f2;
            i5 = cropState.transformRotation;
            if (i5 == 90 || i5 == 270) {
                int i9 = this.originalWidth;
                this.originalWidth = this.originalHeight;
                this.originalHeight = i9;
            }
            this.transformedWidth = (int) (this.transformedWidth * cropState.cropPw);
            this.transformedHeight = (int) (this.transformedHeight * cropState.cropPh);
            double d = -cropState.cropRotate;
            Double.isNaN(d);
            float f3 = (float) (d * 0.017453292519943295d);
            int i10 = 0;
            for (int i11 = 4; i10 < i11; i11 = 4) {
                int i12 = i10 * 2;
                float f4 = fArr5[i12] - (i6 / 2);
                int i13 = i12 + 1;
                float f5 = fArr5[i13] - (i7 / 2);
                double d2 = f4;
                double d3 = f3;
                double dCos = Math.cos(d3);
                Double.isNaN(d2);
                double d4 = f5;
                double dSin = Math.sin(d3);
                Double.isNaN(d4);
                double d5 = cropState.cropPx * f;
                Double.isNaN(d5);
                float f6 = ((float) (((dCos * d2) - (dSin * d4)) + d5)) * cropState.cropScale;
                double dSin2 = Math.sin(d3);
                Double.isNaN(d2);
                double dCos2 = Math.cos(d3);
                Double.isNaN(d4);
                double d6 = (dSin2 * d2) + (d4 * dCos2);
                double d7 = cropState.cropPy * f2;
                Double.isNaN(d7);
                float f7 = ((float) (d6 - d7)) * cropState.cropScale;
                fArr5[i12] = (f6 / this.transformedWidth) * 2.0f;
                fArr5[i13] = (f7 / this.transformedHeight) * 2.0f;
                i10++;
                i6 = i;
                i7 = i2;
            }
            FloatBuffer floatBufferAsFloatBuffer3 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.verticesBuffer = floatBufferAsFloatBuffer3;
            floatBufferAsFloatBuffer3.put(fArr5).position(0);
        } else {
            FloatBuffer floatBufferAsFloatBuffer4 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.verticesBuffer = floatBufferAsFloatBuffer4;
            floatBufferAsFloatBuffer4.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
            i5 = 0;
        }
        float[] fArr6 = this.filterShaders != null ? i5 == 90 ? new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f} : i5 == 180 ? new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f} : i5 == 270 ? new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f} : new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f} : i5 == 90 ? new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f} : i5 == 180 ? new float[]{1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f} : i5 == 270 ? new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f} : new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        if (cropState != null && cropState.mirrored) {
            int i14 = 0;
            for (int i15 = 4; i14 < i15; i15 = 4) {
                int i16 = i14 * 2;
                if (fArr6[i16] > 0.5f) {
                    fArr6[i16] = 0.0f;
                } else {
                    fArr6[i16] = 1.0f;
                }
                i14++;
            }
        }
        FloatBuffer floatBufferAsFloatBuffer5 = ByteBuffer.allocateDirect(fArr6.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.renderTextureBuffer = floatBufferAsFloatBuffer5;
        floatBufferAsFloatBuffer5.put(fArr6).position(0);
    }

    public int getTextureId() {
        return this.mTextureID;
    }

    public void drawFrame(SurfaceTexture surfaceTexture) {
        int renderTexture;
        int i;
        float[] fArr;
        char c;
        surfaceTexture.getTransformMatrix(this.mSTMatrix);
        int i2 = 0;
        if (BuildVars.LOGS_ENABLED && this.firstFrame) {
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            while (true) {
                float[] fArr2 = this.mSTMatrix;
                if (i3 >= fArr2.length) {
                    break;
                }
                sb.append(fArr2[i3]);
                sb.append(", ");
                i3++;
            }
            FileLog.d("stMatrix = " + ((Object) sb));
            this.firstFrame = false;
        }
        if (this.blendEnabled) {
            GLES20.glDisable(3042);
            this.blendEnabled = false;
        }
        SSHFilterShaders sSHFilterShaders = this.filterShaders;
        if (sSHFilterShaders != null) {
            sSHFilterShaders.onVideoFrameUpdate(this.mSTMatrix);
            GLES20.glViewport(0, 0, this.originalWidth, this.originalHeight);
            this.filterShaders.drawCustomParamsPass();
            boolean zDrawBlurPass = this.filterShaders.drawBlurPass();
            GLES20.glBindFramebuffer(36160, 0);
            int i4 = this.transformedWidth;
            if (i4 != this.originalWidth || this.transformedHeight != this.originalHeight) {
                GLES20.glViewport(0, 0, i4, this.transformedHeight);
            }
            renderTexture = this.filterShaders.getRenderTexture(!zDrawBlurPass ? 1 : 0);
            i = 3553;
            fArr = this.mSTMatrixIdentity;
            c = 1;
        } else {
            renderTexture = this.mTextureID;
            i = 36197;
            fArr = this.mSTMatrix;
            c = 0;
        }
        GLES20.glUseProgram(this.mProgram[c]);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(i, renderTexture);
        GLES20.glVertexAttribPointer(this.maPositionHandle[c], 2, 5126, false, 8, (Buffer) this.verticesBuffer);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle[c]);
        GLES20.glVertexAttribPointer(this.maTextureHandle[c], 2, 5126, false, 8, (Buffer) this.renderTextureBuffer);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle[c]);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle[c], 1, false, fArr, 0);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle[c], 1, false, this.mMVPMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        if (this.paintTexture != null) {
            GLES20.glUseProgram(this.simpleShaderProgram);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.simpleSourceImageHandle, 0);
            GLES20.glEnableVertexAttribArray(this.simpleInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.simplePositionHandle);
        }
        if (this.paintTexture != null) {
            while (true) {
                int[] iArr = this.paintTexture;
                if (i2 >= iArr.length) {
                    break;
                }
                drawTexture(true, iArr[i2]);
                i2++;
            }
        }
        GLES20.glFinish();
    }

    private void drawTexture(boolean z, int i) {
        drawTexture(z, i, -10000.0f, -10000.0f, -10000.0f, -10000.0f, 0.0f, false);
    }

    private void drawTexture(boolean z, int i, float f, float f2, float f3, float f4, float f5, boolean z2) {
        if (!this.blendEnabled) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            this.blendEnabled = true;
        }
        if (f <= -10000.0f) {
            float[] fArr = this.bitmapData;
            fArr[0] = -1.0f;
            fArr[1] = 1.0f;
            fArr[2] = 1.0f;
            fArr[3] = 1.0f;
            fArr[4] = -1.0f;
            fArr[5] = -1.0f;
            fArr[6] = 1.0f;
            fArr[7] = -1.0f;
        } else {
            float f6 = (f * 2.0f) - 1.0f;
            float f7 = ((1.0f - f2) * 2.0f) - 1.0f;
            float[] fArr2 = this.bitmapData;
            fArr2[0] = f6;
            fArr2[1] = f7;
            float f8 = (f3 * 2.0f) + f6;
            fArr2[2] = f8;
            fArr2[3] = f7;
            fArr2[4] = f6;
            float f9 = f7 - (f4 * 2.0f);
            fArr2[5] = f9;
            fArr2[6] = f8;
            fArr2[7] = f9;
        }
        float[] fArr3 = this.bitmapData;
        float f10 = (fArr3[0] + fArr3[2]) / 2.0f;
        if (z2) {
            float f11 = fArr3[2];
            fArr3[2] = fArr3[0];
            fArr3[0] = f11;
            float f12 = fArr3[6];
            fArr3[6] = fArr3[4];
            fArr3[4] = f12;
        }
        if (f5 != 0.0f) {
            float f13 = this.transformedWidth / this.transformedHeight;
            float f14 = (fArr3[5] + fArr3[1]) / 2.0f;
            int i2 = 0;
            for (int i3 = 4; i2 < i3; i3 = 4) {
                float[] fArr4 = this.bitmapData;
                int i4 = i2 * 2;
                float f15 = fArr4[i4] - f10;
                int i5 = i4 + 1;
                float f16 = (fArr4[i5] - f14) / f13;
                double d = f15;
                double d2 = f5;
                double dCos = Math.cos(d2);
                Double.isNaN(d);
                double d3 = f16;
                double dSin = Math.sin(d2);
                Double.isNaN(d3);
                fArr4[i4] = ((float) ((dCos * d) - (dSin * d3))) + f10;
                float[] fArr5 = this.bitmapData;
                double dSin2 = Math.sin(d2);
                Double.isNaN(d);
                double dCos2 = Math.cos(d2);
                Double.isNaN(d3);
                fArr5[i5] = (((float) ((d * dSin2) + (d3 * dCos2))) * f13) + f14;
                i2++;
            }
        }
        this.bitmapVerticesBuffer.put(this.bitmapData).position(0);
        GLES20.glVertexAttribPointer(this.simplePositionHandle, 2, 5126, false, 8, (Buffer) this.bitmapVerticesBuffer);
        if (z) {
            GLES20.glBindTexture(3553, i);
        }
        GLES20.glDrawArrays(5, 0, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void surfaceCreated() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.video.SSHTextureRenderer.surfaceCreated():void");
    }

    private int createProgram(String str, String str2) {
        int iLoadShader;
        int iGlCreateProgram;
        int iLoadShader2 = FilterShaders.loadShader(35633, str);
        if (iLoadShader2 == 0 || (iLoadShader = FilterShaders.loadShader(35632, str2)) == 0 || (iGlCreateProgram = GLES20.glCreateProgram()) == 0) {
            return 0;
        }
        GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
        GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }
}
