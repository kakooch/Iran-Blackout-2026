package ir.appp.rghapp.rubinoPostSlider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import androidx.exifinterface.media.ExifInterface;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.GLSceneState;
import ir.resaneh1.iptv.logger.MyLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public class StoryTextureRenderer {
    private FloatBuffer bitmapVerticesBuffer;
    private boolean blendEnabled;
    private FilterShaders filterShaders;
    private GLSceneState glFilterState;
    private String imagePath;
    private boolean isPhoto;
    private int[] mProgram;
    private int mTextureID;
    private int[] maPositionHandle;
    private int[] maTextureHandle;
    private Bitmap mediaOverlay;
    private int[] muMVPMatrixHandle;
    private int[] muSTMatrixHandle;
    private int originalHeight;
    private int originalWidth;
    private int[] overlayTexture;
    private int[] paintTexture;
    private FloatBuffer renderTextureBuffer;
    private int simpleInputTexCoordHandle;
    private int simplePositionHandle;
    private int simpleShaderProgram;
    private int simpleSourceImageHandle;
    private FloatBuffer textureBuffer;
    private int transformedHeight;
    private int transformedWidth;
    private FloatBuffer verticesBuffer;
    float[] bitmapData = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private float[] mMVPMatrix = new float[16];
    private float[] mSTMatrix = new float[16];
    private float[] mSTMatrixIdentity = new float[16];
    boolean logPrinted = false;

    public void release() {
    }

    public StoryTextureRenderer(GLSceneState gLSceneState, String str, int i, int i2, int i3, float f, Bitmap bitmap, boolean z) {
        this.isPhoto = z;
        this.glFilterState = gLSceneState;
        this.mediaOverlay = bitmap;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textureBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(this.bitmapData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.bitmapVerticesBuffer = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(this.bitmapData).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
        Matrix.setIdentityM(this.mSTMatrixIdentity, 0);
        GLSceneState gLSceneState2 = this.glFilterState;
        if (gLSceneState2 != null) {
            this.filterShaders = new FilterShaders(gLSceneState2.getMediaPath());
        }
        this.originalWidth = i;
        this.transformedWidth = i;
        this.originalHeight = i2;
        this.transformedHeight = i2;
        this.imagePath = str;
        int i4 = this.filterShaders != null ? 2 : 1;
        this.mProgram = new int[i4];
        this.muMVPMatrixHandle = new int[i4];
        this.muSTMatrixHandle = new int[i4];
        this.maPositionHandle = new int[i4];
        this.maTextureHandle = new int[i4];
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        FloatBuffer floatBufferAsFloatBuffer3 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.verticesBuffer = floatBufferAsFloatBuffer3;
        floatBufferAsFloatBuffer3.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
        FloatBuffer floatBufferAsFloatBuffer4 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.renderTextureBuffer = floatBufferAsFloatBuffer4;
        floatBufferAsFloatBuffer4.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
    }

    public int getTextureId() {
        return this.mTextureID;
    }

    public void drawFrame(SurfaceTexture surfaceTexture) {
        int renderTexture;
        int i;
        float[] fArr;
        char c;
        if (!this.logPrinted) {
            MyLog.e("SaveStory", "afterSave = " + this.filterShaders.toString());
            this.logPrinted = true;
        }
        if (this.isPhoto) {
            GLES20.glUseProgram(this.simpleShaderProgram);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.simpleSourceImageHandle, 0);
            GLES20.glEnableVertexAttribArray(this.simpleInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.simplePositionHandle);
        } else {
            surfaceTexture.getTransformMatrix(this.mSTMatrix);
            if (this.blendEnabled) {
                GLES20.glDisable(3042);
                this.blendEnabled = false;
            }
            FilterShaders filterShaders = this.filterShaders;
            if (filterShaders != null) {
                filterShaders.onVideoFrameUpdate(this.mSTMatrix);
                GLES20.glViewport(0, 0, this.originalWidth, this.originalHeight);
                this.filterShaders.drawEnhancePass();
                MyLog.e("StoryTextureRenderer", "drawEnhancePass");
                GLES20.glBindFramebuffer(36160, 0);
                int i2 = this.transformedWidth;
                if (i2 != this.originalWidth || this.transformedHeight != this.originalHeight) {
                    GLES20.glViewport(0, 0, i2, this.transformedHeight);
                }
                renderTexture = this.filterShaders.getRenderTexture(1);
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
        if (this.overlayTexture != null && this.mediaOverlay != null) {
            GLES20.glUseProgram(this.simpleShaderProgram);
            GLES20.glActiveTexture(33984);
            GLES20.glUniform1i(this.simpleSourceImageHandle, 0);
            GLES20.glEnableVertexAttribArray(this.simpleInputTexCoordHandle);
            GLES20.glVertexAttribPointer(this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.simplePositionHandle);
            GLES20.glBindTexture(3553, this.overlayTexture[0]);
            GLUtils.texImage2D(3553, 0, this.mediaOverlay, 0);
            drawTexture(true, this.overlayTexture[0]);
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

    public void surfaceCreated() throws IllegalArgumentException {
        int i;
        float fMax;
        String str;
        int i2 = 0;
        while (true) {
            int[] iArr = this.mProgram;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\nvec2 temp = (uSTMatrix * aTextureCoord).xy;temp.y = 1.0 - temp.y;  vTextureCoord = temp;\n}\n", i2 == 0 ? "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n" : "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
            this.maPositionHandle[i2] = GLES20.glGetAttribLocation(this.mProgram[i2], "aPosition");
            this.maTextureHandle[i2] = GLES20.glGetAttribLocation(this.mProgram[i2], "aTextureCoord");
            this.muMVPMatrixHandle[i2] = GLES20.glGetUniformLocation(this.mProgram[i2], "uMVPMatrix");
            this.muSTMatrixHandle[i2] = GLES20.glGetUniformLocation(this.mProgram[i2], "uSTMatrix");
            i2++;
        }
        int i3 = 1;
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        int i4 = iArr2[0];
        this.mTextureID = i4;
        GLES20.glBindTexture(36197, i4);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        if (this.filterShaders != null || this.imagePath != null) {
            int iLoadShader = FilterShaders.loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
            int iLoadShader2 = FilterShaders.loadShader(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;void main() {gl_FragColor = texture2D(sourceImage, texCoord);}");
            if (iLoadShader != 0 && iLoadShader2 != 0) {
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.simpleShaderProgram = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                GLES20.glAttachShader(this.simpleShaderProgram, iLoadShader2);
                GLES20.glBindAttribLocation(this.simpleShaderProgram, 0, "position");
                GLES20.glBindAttribLocation(this.simpleShaderProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.simpleShaderProgram);
                int[] iArr3 = new int[1];
                GLES20.glGetProgramiv(this.simpleShaderProgram, 35714, iArr3, 0);
                if (iArr3[0] == 0) {
                    GLES20.glDeleteProgram(this.simpleShaderProgram);
                    this.simpleShaderProgram = 0;
                } else {
                    this.simplePositionHandle = GLES20.glGetAttribLocation(this.simpleShaderProgram, "position");
                    this.simpleInputTexCoordHandle = GLES20.glGetAttribLocation(this.simpleShaderProgram, "inputTexCoord");
                    this.simpleSourceImageHandle = GLES20.glGetUniformLocation(this.simpleShaderProgram, "sourceImage");
                }
            }
        }
        FilterShaders filterShaders = this.filterShaders;
        if (filterShaders != null) {
            filterShaders.create();
            this.filterShaders.setRenderData(null, 0, this.mTextureID, this.originalWidth, this.originalHeight, true);
            this.filterShaders.loadSceneFromState(this.glFilterState);
        }
        if (this.imagePath != null) {
            int[] iArr4 = new int[1];
            this.paintTexture = iArr4;
            GLES20.glGenTextures(1, iArr4, 0);
            int i5 = 0;
            while (i5 < this.paintTexture.length) {
                try {
                    String str2 = BuildConfig.FLAVOR;
                    if (i5 != 0 || (str = this.imagePath) == null) {
                        i = 0;
                    } else {
                        try {
                            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", i3);
                            i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                            str2 = str;
                        } catch (Throwable unused) {
                            str2 = str;
                        }
                    }
                    if (str2.isEmpty()) {
                        return;
                    }
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str2);
                    if (bitmapDecodeFile != null) {
                        if (i5 == 0 && this.imagePath != null) {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.transformedWidth, this.transformedHeight, Bitmap.Config.ARGB_8888);
                            bitmapCreateBitmap.eraseColor(-16777216);
                            Canvas canvas = new Canvas(bitmapCreateBitmap);
                            if (i == 90 || i == 270) {
                                fMax = Math.max(bitmapDecodeFile.getHeight() / this.transformedWidth, bitmapDecodeFile.getWidth() / this.transformedHeight);
                            } else {
                                fMax = Math.max(bitmapDecodeFile.getWidth() / this.transformedWidth, bitmapDecodeFile.getHeight() / this.transformedHeight);
                            }
                            android.graphics.Matrix matrix = new android.graphics.Matrix();
                            matrix.postTranslate((-bitmapDecodeFile.getWidth()) / 2, (-bitmapDecodeFile.getHeight()) / 2);
                            float f = 1.0f / fMax;
                            matrix.postScale(f, f);
                            matrix.postRotate(i);
                            matrix.postTranslate(bitmapCreateBitmap.getWidth() / 2, bitmapCreateBitmap.getHeight() / 2);
                            canvas.drawBitmap(bitmapDecodeFile, matrix, new Paint(2));
                            bitmapDecodeFile = bitmapCreateBitmap;
                        }
                        GLES20.glBindTexture(3553, this.paintTexture[i5]);
                        GLES20.glTexParameteri(3553, 10241, 9729);
                        GLES20.glTexParameteri(3553, 10240, 9729);
                        GLES20.glTexParameteri(3553, 10242, 33071);
                        GLES20.glTexParameteri(3553, 10243, 33071);
                        GLUtils.texImage2D(3553, 0, bitmapDecodeFile, 0);
                    }
                    i5++;
                    i3 = 1;
                } catch (Throwable unused2) {
                }
            }
        }
        if (this.mediaOverlay != null) {
            int[] iArr5 = new int[1];
            this.overlayTexture = iArr5;
            GLES20.glGenTextures(1, iArr5, 0);
            GLES20.glBindTexture(3553, this.overlayTexture[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
        }
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
