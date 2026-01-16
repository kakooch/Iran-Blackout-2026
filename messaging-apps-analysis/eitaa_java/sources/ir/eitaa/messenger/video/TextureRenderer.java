package ir.eitaa.messenger.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.ui.Components.FilterShaders;
import ir.eitaa.ui.Components.Paint.Views.EditTextOutline;
import ir.eitaa.ui.Components.RLottieDrawable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TextureRenderer {
    private static final String FRAGMENT_EXTERNAL_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private FloatBuffer bitmapVerticesBuffer;
    private boolean blendEnabled;
    private FilterShaders filterShaders;
    private int imageOrientation;
    private String imagePath;
    private boolean isPhoto;
    private int[] mProgram;
    private int mTextureID;
    private int[] maPositionHandle;
    private int[] maTextureHandle;
    private ArrayList<VideoEditedInfo.MediaEntity> mediaEntities;
    private int[] muMVPMatrixHandle;
    private int[] muSTMatrixHandle;
    private int originalHeight;
    private int originalWidth;
    private String paintPath;
    private int[] paintTexture;
    private FloatBuffer renderTextureBuffer;
    private int simpleInputTexCoordHandle;
    private int simplePositionHandle;
    private int simpleShaderProgram;
    private int simpleSourceImageHandle;
    private Bitmap stickerBitmap;
    private int[] stickerTexture;
    private FloatBuffer textureBuffer;
    private int transformedHeight;
    private int transformedWidth;
    private FloatBuffer verticesBuffer;
    private float videoFps;
    float[] bitmapData = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private float[] mMVPMatrix = new float[16];
    private float[] mSTMatrix = new float[16];
    private float[] mSTMatrixIdentity = new float[16];
    private boolean firstFrame = true;

    public TextureRenderer(MediaController.SavedFilterState savedFilterState, String image, String paint, ArrayList<VideoEditedInfo.MediaEntity> entities, MediaController.CropState cropState, int w, int h, int rotation, float fps, boolean photo) {
        int i;
        int i2 = w;
        int i3 = h;
        float f = fps;
        this.isPhoto = photo;
        float[] fArr = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("start textureRenderer w = " + i2 + " h = " + i3 + " r = " + rotation + " fps = " + f);
            if (cropState != null) {
                FileLog.d("cropState px = " + cropState.cropPx + " py = " + cropState.cropPy + " cScale = " + cropState.cropScale + " cropRotate = " + cropState.cropRotate + " pw = " + cropState.cropPw + " ph = " + cropState.cropPh + " tw = " + cropState.transformWidth + " th = " + cropState.transformHeight + " tr = " + cropState.transformRotation + " mirror = " + cropState.mirrored);
            }
        }
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textureBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(this.bitmapData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.bitmapVerticesBuffer = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(this.bitmapData).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
        Matrix.setIdentityM(this.mSTMatrixIdentity, 0);
        if (savedFilterState != null) {
            FilterShaders filterShaders = new FilterShaders(true);
            this.filterShaders = filterShaders;
            filterShaders.setDelegate(FilterShaders.getFilterShadersDelegate(savedFilterState));
        }
        this.originalWidth = i2;
        this.transformedWidth = i2;
        this.originalHeight = i3;
        this.transformedHeight = i3;
        this.imagePath = image;
        this.paintPath = paint;
        this.mediaEntities = entities;
        this.videoFps = f == 0.0f ? 30.0f : f;
        int i4 = this.filterShaders != null ? 2 : 1;
        this.mProgram = new int[i4];
        this.muMVPMatrixHandle = new int[i4];
        this.muSTMatrixHandle = new int[i4];
        this.maPositionHandle = new int[i4];
        this.maTextureHandle = new int[i4];
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        if (cropState != null) {
            float[] fArr2 = new float[8];
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            float f2 = i2;
            fArr2[2] = f2;
            fArr2[3] = 0.0f;
            fArr2[4] = 0.0f;
            float f3 = i3;
            fArr2[5] = f3;
            fArr2[6] = f2;
            fArr2[7] = f3;
            i = cropState.transformRotation;
            if (i == 90 || i == 270) {
                int i5 = this.originalWidth;
                this.originalWidth = this.originalHeight;
                this.originalHeight = i5;
            }
            this.transformedWidth = (int) (this.transformedWidth * cropState.cropPw);
            this.transformedHeight = (int) (this.transformedHeight * cropState.cropPh);
            double d = -cropState.cropRotate;
            Double.isNaN(d);
            float f4 = (float) (d * 0.017453292519943295d);
            int i6 = 0;
            for (int i7 = 4; i6 < i7; i7 = 4) {
                int i8 = i6 * 2;
                float f5 = fArr2[i8] - (i2 / 2);
                int i9 = i8 + 1;
                float f6 = fArr2[i9] - (i3 / 2);
                float f7 = f2;
                double d2 = f5;
                double d3 = f4;
                double dCos = Math.cos(d3);
                Double.isNaN(d2);
                double d4 = f6;
                double dSin = Math.sin(d3);
                Double.isNaN(d4);
                double d5 = cropState.cropPx * f7;
                Double.isNaN(d5);
                float f8 = ((float) (((dCos * d2) - (dSin * d4)) + d5)) * cropState.cropScale;
                double dSin2 = Math.sin(d3);
                Double.isNaN(d2);
                double dCos2 = Math.cos(d3);
                Double.isNaN(d4);
                double d6 = (d2 * dSin2) + (d4 * dCos2);
                double d7 = cropState.cropPy * f3;
                Double.isNaN(d7);
                float f9 = ((float) (d6 - d7)) * cropState.cropScale;
                fArr2[i8] = (f8 / this.transformedWidth) * 2.0f;
                fArr2[i9] = (f9 / this.transformedHeight) * 2.0f;
                i6++;
                f2 = f7;
                i2 = w;
                i3 = h;
            }
            FloatBuffer floatBufferAsFloatBuffer3 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.verticesBuffer = floatBufferAsFloatBuffer3;
            floatBufferAsFloatBuffer3.put(fArr2).position(0);
        } else {
            FloatBuffer floatBufferAsFloatBuffer4 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.verticesBuffer = floatBufferAsFloatBuffer4;
            floatBufferAsFloatBuffer4.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
            i = 0;
        }
        float[] fArr3 = this.filterShaders != null ? i == 90 ? new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f} : i == 180 ? new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f} : i == 270 ? new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f} : new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f} : i == 90 ? new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f} : i == 180 ? new float[]{1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f} : i == 270 ? new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f} : new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        if (cropState != null && cropState.mirrored) {
            int i10 = 0;
            for (int i11 = 4; i10 < i11; i11 = 4) {
                int i12 = i10 * 2;
                if (fArr3[i12] > 0.5f) {
                    fArr3[i12] = 0.0f;
                } else {
                    fArr3[i12] = 1.0f;
                }
                i10++;
            }
        }
        FloatBuffer floatBufferAsFloatBuffer5 = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.renderTextureBuffer = floatBufferAsFloatBuffer5;
        floatBufferAsFloatBuffer5.put(fArr3).position(0);
    }

    public int getTextureId() {
        return this.mTextureID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void drawFrame(SurfaceTexture surfaceTexture) {
        int renderTexture;
        int i;
        float[] fArr;
        char c;
        if (this.isPhoto) {
            GLES20.glUseProgram(this.simpleShaderProgram);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.simpleSourceImageHandle, 0);
            GLES20.glEnableVertexAttribArray(this.simpleInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.simplePositionHandle);
        } else {
            surfaceTexture.getTransformMatrix(this.mSTMatrix);
            if (BuildVars.LOGS_ENABLED && this.firstFrame) {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    float[] fArr2 = this.mSTMatrix;
                    if (i2 >= fArr2.length) {
                        break;
                    }
                    sb.append(fArr2[i2]);
                    sb.append(", ");
                    i2++;
                }
                FileLog.d("stMatrix = " + ((Object) sb));
                this.firstFrame = false;
            }
            if (this.blendEnabled) {
                GLES20.glDisable(3042);
                this.blendEnabled = false;
            }
            FilterShaders filterShaders = this.filterShaders;
            if (filterShaders != null) {
                filterShaders.onVideoFrameUpdate(this.mSTMatrix);
                GLES20.glViewport(0, 0, this.originalWidth, this.originalHeight);
                this.filterShaders.drawSkinSmoothPass();
                this.filterShaders.drawEnhancePass();
                this.filterShaders.drawSharpenPass();
                this.filterShaders.drawCustomParamsPass();
                boolean zDrawBlurPass = this.filterShaders.drawBlurPass();
                GLES20.glBindFramebuffer(36160, 0);
                int i3 = this.transformedWidth;
                if (i3 != this.originalWidth || this.transformedHeight != this.originalHeight) {
                    GLES20.glViewport(0, 0, i3, this.transformedHeight);
                }
                renderTexture = this.filterShaders.getRenderTexture(!zDrawBlurPass ? 1 : 0);
                fArr = this.mSTMatrixIdentity;
                i = 3553;
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
        }
        if (this.paintTexture != null || this.stickerTexture != null) {
            GLES20.glUseProgram(this.simpleShaderProgram);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.simpleSourceImageHandle, 0);
            GLES20.glEnableVertexAttribArray(this.simpleInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.simplePositionHandle);
        }
        if (this.paintTexture != null) {
            int i4 = 0;
            while (true) {
                int[] iArr = this.paintTexture;
                if (i4 >= iArr.length) {
                    break;
                }
                drawTexture(true, iArr[i4]);
                i4++;
            }
        }
        if (this.stickerTexture != null) {
            int size = this.mediaEntities.size();
            for (int i5 = 0; i5 < size; i5++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.mediaEntities.get(i5);
                long j = mediaEntity.ptr;
                if (j != 0) {
                    int i6 = (int) mediaEntity.currentFrame;
                    Bitmap bitmap = this.stickerBitmap;
                    RLottieDrawable.getFrame(j, i6, bitmap, Factory.DEVICE_USE_ANDROID_CAMCORDER, Factory.DEVICE_USE_ANDROID_CAMCORDER, bitmap.getRowBytes(), true);
                    GLES20.glBindTexture(3553, this.stickerTexture[0]);
                    GLUtils.texImage2D(3553, 0, this.stickerBitmap, 0);
                    float f = mediaEntity.currentFrame + mediaEntity.framesPerDraw;
                    mediaEntity.currentFrame = f;
                    if (f >= mediaEntity.metadata[0]) {
                        mediaEntity.currentFrame = 0.0f;
                    }
                    drawTexture(false, this.stickerTexture[0], mediaEntity.x, mediaEntity.y, mediaEntity.width, mediaEntity.height, mediaEntity.rotation, (mediaEntity.subType & 2) != 0);
                } else if (mediaEntity.bitmap != null) {
                    GLES20.glBindTexture(3553, this.stickerTexture[0]);
                    GLUtils.texImage2D(3553, 0, mediaEntity.bitmap, 0);
                    drawTexture(false, this.stickerTexture[0], mediaEntity.x, mediaEntity.y, mediaEntity.width, mediaEntity.height, mediaEntity.rotation, (mediaEntity.subType & 2) != 0);
                }
            }
        }
        GLES20.glFinish();
    }

    private void drawTexture(boolean bind, int texture) {
        drawTexture(bind, texture, -10000.0f, -10000.0f, -10000.0f, -10000.0f, 0.0f, false);
    }

    private void drawTexture(boolean bind, int texture, float x, float y, float w, float h, float rotation, boolean mirror) {
        if (!this.blendEnabled) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            this.blendEnabled = true;
        }
        if (x <= -10000.0f) {
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
            float f = (x * 2.0f) - 1.0f;
            float f2 = ((1.0f - y) * 2.0f) - 1.0f;
            float[] fArr2 = this.bitmapData;
            fArr2[0] = f;
            fArr2[1] = f2;
            float f3 = (w * 2.0f) + f;
            fArr2[2] = f3;
            fArr2[3] = f2;
            fArr2[4] = f;
            float f4 = f2 - (h * 2.0f);
            fArr2[5] = f4;
            fArr2[6] = f3;
            fArr2[7] = f4;
        }
        float[] fArr3 = this.bitmapData;
        float f5 = (fArr3[0] + fArr3[2]) / 2.0f;
        if (mirror) {
            float f6 = fArr3[2];
            fArr3[2] = fArr3[0];
            fArr3[0] = f6;
            float f7 = fArr3[6];
            fArr3[6] = fArr3[4];
            fArr3[4] = f7;
        }
        if (rotation != 0.0f) {
            float f8 = this.transformedWidth / this.transformedHeight;
            float f9 = (fArr3[5] + fArr3[1]) / 2.0f;
            int i = 0;
            for (int i2 = 4; i < i2; i2 = 4) {
                float[] fArr4 = this.bitmapData;
                int i3 = i * 2;
                float f10 = fArr4[i3] - f5;
                int i4 = i3 + 1;
                float f11 = (fArr4[i4] - f9) / f8;
                double d = f10;
                double d2 = rotation;
                double dCos = Math.cos(d2);
                Double.isNaN(d);
                double d3 = f11;
                double dSin = Math.sin(d2);
                Double.isNaN(d3);
                fArr4[i3] = ((float) ((dCos * d) - (dSin * d3))) + f5;
                float[] fArr5 = this.bitmapData;
                double dSin2 = Math.sin(d2);
                Double.isNaN(d);
                double dCos2 = Math.cos(d2);
                Double.isNaN(d3);
                fArr5[i4] = (((float) ((d * dSin2) + (d3 * dCos2))) * f8) + f9;
                i++;
            }
        }
        this.bitmapVerticesBuffer.put(this.bitmapData).position(0);
        GLES20.glVertexAttribPointer(this.simplePositionHandle, 2, 5126, false, 8, (Buffer) this.bitmapVerticesBuffer);
        if (bind) {
            GLES20.glBindTexture(3553, texture);
        }
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void setBreakStrategy(EditTextOutline editText) {
        editText.setBreakStrategy(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0206 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0166  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void surfaceCreated() {
        /*
            Method dump skipped, instructions count: 1025
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.video.TextureRenderer.surfaceCreated():void");
    }

    private int createProgram(String vertexSource, String fragmentSource) {
        int iLoadShader;
        int iGlCreateProgram;
        int iLoadShader2 = FilterShaders.loadShader(35633, vertexSource);
        if (iLoadShader2 == 0 || (iLoadShader = FilterShaders.loadShader(35632, fragmentSource)) == 0 || (iGlCreateProgram = GLES20.glCreateProgram()) == 0) {
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

    public void release() {
        ArrayList<VideoEditedInfo.MediaEntity> arrayList = this.mediaEntities;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                long j = this.mediaEntities.get(i).ptr;
                if (j != 0) {
                    RLottieDrawable.destroy(j);
                }
            }
        }
    }
}
