package ir.appp.rghapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.core.util.Pair;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2t.SimpleExoPlayer;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.RGHFilter;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes3.dex */
public class GLMediaRenderer implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener, BackgroundGenerationListener {
    public static String backgroundPath = "/storage/emulated/0/white_frame.png";
    public static int screenHeight = 1920;
    public static int screenWidth = 1080;
    private int aPositionLocation;
    private int aTextureCoordLocation;
    private int backgroundTextureId;
    private int backgroundTextureLocation;
    private ColorPickerListener colorPickerListener;
    private Queue<Pair<Integer, Integer>> colorPickerQueue;
    private final Context context;
    private SimpleExoPlayer exoMediaPlayer;
    private GLSurfaceView glSurfaceView;
    private ImageCaptureListener imageCaptureListener;
    private String imageMediaFilePath;
    private boolean isImageMedia;
    private int maxScreenWidth;
    String mediaPath;
    private int mediaTextureId;
    private int mediaTextureLocation;
    private float originalMediaRotation;
    private int programId;
    private int refBrightness;
    private int refContrast;
    private int refFilterChangeDirection;
    private int refFilterId;
    private int refHasRotation;
    private int refIsBackgroundGenerated;
    private int refNewFilterPos;
    private int refNextBrightness;
    private int refNextContrast;
    private int refNextSaturation;
    private int refRotationMatrix;
    private int refSaturation;
    private int refScaleMatrix;
    private int refTranslationMatrix;
    private SurfaceTexture surfaceTexture;
    private final FloatBuffer textureVertexBuffer;
    private final float[] textureVertexData;
    private float translateXinGlCoordination;
    private float translateYinGlCoordination;
    private boolean updateSurface;
    private final FloatBuffer vertexBuffer;
    private final float[] vertexData;
    private Surface videoSurface;

    @Keep
    private final float[] rotationMatrix = new float[16];
    private final float[] tempRotationMatrix2 = new float[16];
    private float[] scaleMatrix = new float[16];
    private float[] translationMatrix = new float[16];
    private float mediaRotation = 0.0f;
    private int filterId = 0;
    private float scaleX = 0.0f;
    private float scaleY = 0.0f;
    private float scaleXOriginal = 0.0f;
    private float scaleYOriginal = 0.0f;
    private float sxRatio = 1.0f;
    private float syRatio = 1.0f;
    private float xPosInNormalCoordination = 0.0f;
    private float yPosInNormalCoordination = 0.0f;
    private float xPosInNormalCoordinationOriginal = 0.0f;
    private float yPosInNormalCoordinationOriginal = 0.0f;
    private float xPosCorrection = 0.0f;
    private float yPosCorrection = 0.0f;
    private float newFilterXPositionRatio = 0.0f;
    private float mediaAspectRatio = 1.0f;
    private int filterChangeDirection = 1;
    private float saturation = 1.0f;
    private float contrast = 1.0f;
    private float brightness = 0.0f;
    private float nextSaturation = 1.0f;
    private float nextContrast = 1.0f;
    private float nextBrightness = 0.0f;
    private boolean mCaptureEnabled = false;
    private long videoPlaybackStartTime = -1;
    private long videoPlaybackEndTime = -1;
    private boolean isUpdatingState = false;
    private boolean isSceneCreated = false;
    private boolean isBackgroundGenerated = false;
    private boolean isColorPickingModeEnabled = false;
    private boolean isSupportingNPOT = true;

    public static native int getVideoRotation(String str);

    public GLMediaRenderer(Context context, String str, boolean z) throws IllegalArgumentException {
        float[] fArr = {1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f};
        this.vertexData = fArr;
        float[] fArr2 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        this.textureVertexData = fArr2;
        this.originalMediaRotation = 0.0f;
        this.context = context;
        this.isImageMedia = z;
        FloatBuffer floatBufferPut = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        this.vertexBuffer = floatBufferPut;
        floatBufferPut.position(0);
        FloatBuffer floatBufferPut2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.textureVertexBuffer = floatBufferPut2;
        floatBufferPut2.position(0);
        this.mediaPath = str;
        if (!this.isImageMedia) {
            synchronized (this) {
                this.updateSurface = false;
            }
            int videoRotation = getVideoRotation(str);
            if (videoRotation != -1) {
                this.originalMediaRotation = videoRotation;
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 17) {
                        new MediaMetadataRetriever().setDataSource(str);
                        this.originalMediaRotation = Integer.parseInt(r9.extractMetadata(24));
                    } else {
                        this.originalMediaRotation = 0.0f;
                    }
                } catch (Exception unused) {
                }
            }
            Log.d("GLRenderer", "Original Video Rotation = " + this.originalMediaRotation);
            this.imageMediaFilePath = BuildConfig.FLAVOR;
        } else {
            this.imageMediaFilePath = str;
            this.originalMediaRotation = Utils.getImageRotation(str);
            Log.d("GLRenderer", "GLVideoRenderer: Orientation = " + this.originalMediaRotation);
        }
        if (this.originalMediaRotation == 270.0f) {
            this.originalMediaRotation = -90.0f;
        }
    }

    public void setGlSurfaceView(GLSurfaceView gLSurfaceView) {
        this.glSurfaceView = gLSurfaceView;
    }

    public void loadSceneFromState(final GLSceneState gLSceneState) {
        GLSurfaceView gLSurfaceView = this.glSurfaceView;
        if (gLSurfaceView != null) {
            this.isUpdatingState = true;
            gLSurfaceView.queueEvent(new Runnable() { // from class: ir.appp.rghapp.GLMediaRenderer.1
                @Override // java.lang.Runnable
                public void run() throws IOException {
                    GLMediaRenderer.this.isSceneCreated = false;
                    GLMediaRenderer.this.filterId = gLSceneState.getFilterId();
                    GLMediaRenderer.this.mediaPath = gLSceneState.getMediaPath();
                    GLMediaRenderer gLMediaRenderer = GLMediaRenderer.this;
                    gLMediaRenderer.imageMediaFilePath = gLMediaRenderer.mediaPath;
                    GLMediaRenderer.backgroundPath = gLSceneState.getBackgroundFilePath();
                    GLMediaRenderer.this.originalMediaRotation = gLSceneState.getOriginalMediaRotation();
                    GLMediaRenderer.this.videoPlaybackStartTime = gLSceneState.getVideoPlaybackStartTime();
                    GLMediaRenderer.this.videoPlaybackEndTime = gLSceneState.getVideoPlaybackEndTime();
                    GLMediaRenderer.this.saturation = gLSceneState.getSaturation();
                    GLMediaRenderer.this.brightness = gLSceneState.getBrightness();
                    GLMediaRenderer.this.contrast = gLSceneState.getContrast();
                    GLMediaRenderer.this.nextBrightness = gLSceneState.getNextBrightness();
                    GLMediaRenderer.this.nextContrast = gLSceneState.getNextContrast();
                    GLMediaRenderer.this.nextSaturation = gLSceneState.getNextSaturation();
                    GLMediaRenderer.this.isImageMedia = gLSceneState.isImageMedia();
                    GLMediaRenderer.this.updateSurface = false;
                    GLMediaRenderer.this.setMediaCoordinationInfo(gLSceneState.getScaleX(), gLSceneState.getScaleY(), gLSceneState.getxPosInNormalCoordination(), gLSceneState.getyPosInNormalCoordination(), gLSceneState.getMediaRotation());
                    GLMediaRenderer.this.initiateGLScene();
                    if (!gLSceneState.isBackgroundGenerated()) {
                        Context context = GLMediaRenderer.this.context;
                        GLMediaRenderer gLMediaRenderer2 = GLMediaRenderer.this;
                        Utils.createGradientBackground(context, gLMediaRenderer2.mediaPath, gLMediaRenderer2.isImageMedia, GLMediaRenderer.this);
                    } else {
                        GLMediaRenderer.this.setGradientBackground(gLSceneState.getBackgroundFilePath());
                        GLMediaRenderer.this.isBackgroundGenerated = gLSceneState.isBackgroundGenerated();
                    }
                    GLMediaRenderer.this.createCoordinationMatrices();
                    GLMediaRenderer.this.isSceneCreated = true;
                    GLMediaRenderer.this.isUpdatingState = false;
                }
            });
        }
    }

    public GLSceneState getCurrentSceneState() {
        return new GLSceneState(this.filterId, this.saturation, this.contrast, this.brightness, this.nextSaturation, this.nextContrast, this.nextBrightness, this.mediaRotation, this.originalMediaRotation, isAdjustmentNeeded() ? this.scaleXOriginal : this.scaleX, isAdjustmentNeeded() ? this.scaleYOriginal : this.scaleY, isAdjustmentNeeded() ? this.xPosInNormalCoordinationOriginal : this.xPosInNormalCoordination, isAdjustmentNeeded() ? this.yPosInNormalCoordinationOriginal : this.yPosInNormalCoordination, this.isBackgroundGenerated, backgroundPath, this.isImageMedia, this.mediaPath, this.videoPlaybackStartTime, this.videoPlaybackEndTime);
    }

    public void setMaxScreenWidth(int i) {
        this.maxScreenWidth = i;
    }

    public void setExoMediaPlayer(SimpleExoPlayer simpleExoPlayer) {
        SimpleExoPlayer simpleExoPlayer2 = this.exoMediaPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.stop();
            this.exoMediaPlayer.release(false);
        }
        this.exoMediaPlayer = simpleExoPlayer;
        simpleExoPlayer.setVideoScalingMode(1);
    }

    public void setVideoTimeLimit(int i, int i2) {
        if (this.isImageMedia) {
            return;
        }
        this.videoPlaybackStartTime = i * CloseCodes.NORMAL_CLOSURE;
        this.videoPlaybackEndTime = i2 * CloseCodes.NORMAL_CLOSURE;
    }

    public void setMediaRotation(float f) {
        this.mediaRotation = f;
        if (this.isSceneCreated) {
            createCoordinationMatrices();
        }
    }

    public void setFilterType(RGHFilter.FilterType filterType) {
        if (filterType == RGHFilter.FilterType.None) {
            this.filterId = 0;
            return;
        }
        if (filterType == RGHFilter.FilterType.BlackAndWhite) {
            this.filterId = 1;
            return;
        }
        if (filterType == RGHFilter.FilterType.Greish) {
            this.filterId = 2;
            return;
        }
        if (filterType == RGHFilter.FilterType.Happy) {
            this.filterId = 3;
            return;
        }
        if (filterType == RGHFilter.FilterType.Dark) {
            this.filterId = 4;
            return;
        }
        if (filterType == RGHFilter.FilterType.BuenosAires) {
            this.filterId = 5;
            return;
        }
        if (filterType == RGHFilter.FilterType.Tokyo) {
            this.filterId = 6;
            return;
        }
        if (filterType == RGHFilter.FilterType.Menegol) {
            this.filterId = 7;
            return;
        }
        if (filterType == RGHFilter.FilterType.Cold) {
            this.filterId = 8;
        } else if (filterType == RGHFilter.FilterType.Pinky) {
            this.filterId = 9;
        } else if (filterType == RGHFilter.FilterType.Sepia) {
            this.filterId = 10;
        }
    }

    public void setScale(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
        if (!isAdjustmentNeeded()) {
            float f3 = this.scaleX;
            float f4 = this.scaleY;
            this.mediaAspectRatio = f3 / f4;
            int i = screenWidth;
            if (i != 0) {
                this.sxRatio = f3 / i;
                this.syRatio = f4 / screenHeight;
                computeGlCoordination();
            }
        } else {
            this.scaleXOriginal = f;
            this.scaleYOriginal = f2;
            makeAdjustmentForBaseRotation();
        }
        if (this.isSceneCreated) {
            createCoordinationMatrices();
        }
        Log.d("GLRenderer", "setScale: sxRatio = " + this.sxRatio + " - syRatio = " + this.syRatio);
    }

    public void setMediaPosition(float f, float f2) {
        this.xPosInNormalCoordination = f;
        this.yPosInNormalCoordination = f2;
        if (isAdjustmentNeeded()) {
            float f3 = this.xPosInNormalCoordination;
            this.xPosInNormalCoordinationOriginal = f3;
            float f4 = this.yPosInNormalCoordination;
            this.yPosInNormalCoordinationOriginal = f4;
            this.xPosInNormalCoordination = f3 - this.xPosCorrection;
            this.yPosInNormalCoordination = f4 + this.yPosCorrection;
        }
        computeGlCoordination();
        if (this.isSceneCreated) {
            createCoordinationMatrices();
        }
    }

    public void updateFilterInfo(int i, float f) {
        double d = f;
        Double.isNaN(d);
        float f2 = (float) (d + 1.0E-4d);
        int i2 = screenWidth;
        this.newFilterXPositionRatio = ((f2 * i2) / 100.0f) / i2;
        this.filterChangeDirection = i > 0 ? 1 : 2;
    }

    public void setMediaCoordinationInfo(float f, float f2, float f3, float f4, float f5) {
        setScale(f, f2);
        setMediaPosition(f3, f4);
        setMediaRotation(f5);
    }

    public void setSaturation(float f) {
        this.saturation = f;
    }

    public void setContrast(float f) {
        this.contrast = f;
    }

    public void setBrightness(float f) {
        this.brightness = f / 255.0f;
    }

    public void setNextFilterValues(float f, float f2, float f3) {
        this.nextSaturation = f;
        this.nextContrast = f2;
        this.nextBrightness = f3 / 255.0f;
    }

    public void pauseMediaPlayback() {
        SimpleExoPlayer simpleExoPlayer = this.exoMediaPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public void resumeMediaPlayback() {
        MyLog.e("Ui_storyGlSurfaceView", "resumeMediaPlayback");
        SimpleExoPlayer simpleExoPlayer = this.exoMediaPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    public void destroyGLComponents(boolean z) {
        SimpleExoPlayer simpleExoPlayer;
        try {
            this.glSurfaceView.queueEvent(new Runnable() { // from class: ir.appp.rghapp.GLMediaRenderer.2
                @Override // java.lang.Runnable
                public void run() {
                    GLES20.glDeleteTextures(2, new int[]{GLMediaRenderer.this.mediaTextureId, GLMediaRenderer.this.backgroundTextureId}, 0);
                    GLES20.glDeleteProgram(GLMediaRenderer.this.programId);
                    GLMediaRenderer.this.clearBuffers();
                }
            });
            if (!this.isImageMedia && (simpleExoPlayer = this.exoMediaPlayer) != null) {
                simpleExoPlayer.setVideoSurface(null);
                this.exoMediaPlayer.stop();
                this.exoMediaPlayer.release(false);
                this.exoMediaPlayer = null;
                this.videoSurface.release();
                try {
                    this.surfaceTexture.release();
                    this.surfaceTexture.setOnFrameAvailableListener(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.gc();
            if (z) {
                this.glSurfaceView = null;
            }
        } catch (Exception unused) {
        }
    }

    public void setGradientBackground(String str) {
        Bitmap bitmapLoadBitmapForOpenGL;
        if (str.isEmpty() || (bitmapLoadBitmapForOpenGL = Utils.loadBitmapForOpenGL(this.context, str, true, this.maxScreenWidth, this.isSupportingNPOT)) == null) {
            return;
        }
        GLES20.glBindTexture(3553, this.backgroundTextureId);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, 6408, bitmapLoadBitmapForOpenGL, 0);
        bitmapLoadBitmapForOpenGL.recycle();
        ShaderUtils.checkGlError("glBindTexture background image texture");
        backgroundPath = str;
        this.isBackgroundGenerated = true;
    }

    public void setColorPickerListener(ColorPickerListener colorPickerListener) {
        this.colorPickerListener = colorPickerListener;
    }

    public void setColorPickingMode(boolean z) {
        if (z) {
            if (!this.isImageMedia && this.exoMediaPlayer != null) {
                pauseMediaPlayback();
            }
        } else if (!this.isImageMedia && this.exoMediaPlayer != null) {
            resumeMediaPlayback();
        }
        this.isColorPickingModeEnabled = z;
        if (z) {
            if (this.colorPickerQueue == null) {
                this.colorPickerQueue = new LinkedList();
                return;
            }
            return;
        }
        this.colorPickerQueue.clear();
    }

    public void getPixelColor(int i, int i2) {
        if (this.isColorPickingModeEnabled) {
            this.colorPickerQueue.add(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            if (this.colorPickerQueue.size() > 50) {
                this.colorPickerQueue.poll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBuffers() {
        GLES20.glClear(17664);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCoordinationMatrices() {
        float f = this.mediaRotation;
        float f2 = this.originalMediaRotation;
        if (f + f2 != 0.0f) {
            double d = ((f + f2) / 180.0f) * 3.14159f;
            double dCos = Math.cos(d);
            double dSin = Math.sin(d);
            float f3 = this.mediaAspectRatio;
            float[] fArr = {f3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            float[] fArr2 = {1.0f / f3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            float f4 = (float) dCos;
            Matrix.multiplyMM(this.tempRotationMatrix2, 0, fArr2, 0, new float[]{f4, (float) (-dSin), 0.0f, 0.0f, (float) dSin, f4, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0);
            Matrix.multiplyMM(this.rotationMatrix, 0, this.tempRotationMatrix2, 0, fArr, 0);
        }
        this.scaleMatrix = new float[]{1.0f / this.sxRatio, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f / this.syRatio, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.translationMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, this.translateXinGlCoordination, this.translateYinGlCoordination, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        Log.e("GLRenderer", "createCoordinationMatrices: ");
    }

    private void computeGlCoordination() {
        int i = screenWidth;
        if (i != 0) {
            float f = this.scaleX;
            if (f == 0.0f) {
                f = i;
            }
            float f2 = this.scaleY;
            if (f2 == 0.0f) {
                f2 = screenHeight;
            }
            float f3 = (this.xPosInNormalCoordination + (f / 2.0f)) / i;
            float f4 = this.sxRatio;
            this.translateXinGlCoordination = ((1.0f / f4) * 0.5f) - (f3 * (((1.0f / f4) * 0.5f) - ((1.0f / f4) * (-0.5f))));
            float f5 = (this.yPosInNormalCoordination + (f2 / 2.0f)) / screenHeight;
            float f6 = this.syRatio;
            this.translateYinGlCoordination = ((1.0f / f6) * 0.5f) - (f5 * (((1.0f / f6) * 0.5f) - ((1.0f / f6) * (-0.5f))));
            Log.d("GLRenderer", "computeGlCoordination: " + this.translateXinGlCoordination + "  -  " + this.translateYinGlCoordination);
        }
    }

    private void makeAdjustmentForBaseRotation() {
        float f = this.scaleX;
        float f2 = this.scaleY;
        float f3 = ((f - f2) / 2.0f) - (f - f2);
        this.xPosCorrection = f3;
        float f4 = (f2 - f) / 2.0f;
        this.yPosCorrection = f4;
        this.xPosInNormalCoordination = this.xPosInNormalCoordinationOriginal - f3;
        this.yPosInNormalCoordination = this.yPosInNormalCoordinationOriginal + f4;
        this.scaleX = f2;
        this.scaleY = f;
        this.mediaAspectRatio = f2 / f;
        int i = screenWidth;
        if (i != 0) {
            this.sxRatio = f2 / i;
            this.syRatio = f / screenHeight;
            computeGlCoordination();
        }
    }

    private boolean isAdjustmentNeeded() {
        float f = this.originalMediaRotation;
        return (f == 90.0f || f == -90.0f) && this.scaleX != this.scaleY;
    }

    private void seekMediaPlayer(long j) {
        this.exoMediaPlayer.seekTo(j);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) throws IOException {
        Log.d("GLRenderer", "onSurfaceCreated: ");
        String strGlGetString = gl10.glGetString(7939);
        this.isSupportingNPOT = strGlGetString.contains("GL_OES_texture_npot") || strGlGetString.contains("GL_IMG_texture_npot");
        initiateGLScene();
        Utils.createGradientBackground(this.context, this.mediaPath, this.isImageMedia, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initiateGLScene() {
        GLES20.glDisable(2884);
        int iCreateProgram = ShaderUtils.createProgram(this.isImageMedia);
        this.programId = iCreateProgram;
        this.aPositionLocation = GLES20.glGetAttribLocation(iCreateProgram, "aPosition");
        this.mediaTextureLocation = GLES20.glGetUniformLocation(this.programId, this.isImageMedia ? "mediaTexture" : "sTexture");
        this.backgroundTextureLocation = GLES20.glGetUniformLocation(this.programId, "backgroundTexture");
        this.aTextureCoordLocation = GLES20.glGetAttribLocation(this.programId, "aTexCoord");
        this.refFilterId = GLES20.glGetUniformLocation(this.programId, "filterType");
        this.refNewFilterPos = GLES20.glGetUniformLocation(this.programId, "newFilterPos");
        this.refSaturation = GLES20.glGetUniformLocation(this.programId, "saturationValue");
        this.refContrast = GLES20.glGetUniformLocation(this.programId, "contrastValue");
        this.refBrightness = GLES20.glGetUniformLocation(this.programId, "brightnessValue");
        this.refNextSaturation = GLES20.glGetUniformLocation(this.programId, "saturationValueN");
        this.refNextContrast = GLES20.glGetUniformLocation(this.programId, "contrastValueN");
        this.refNextBrightness = GLES20.glGetUniformLocation(this.programId, "brightnessValueN");
        this.refFilterChangeDirection = GLES20.glGetUniformLocation(this.programId, "filterChangeDirection");
        this.refRotationMatrix = GLES20.glGetUniformLocation(this.programId, "rotationMatrix");
        this.refHasRotation = GLES20.glGetUniformLocation(this.programId, "hasRotation");
        this.refScaleMatrix = GLES20.glGetUniformLocation(this.programId, "scaleMatrix");
        this.refTranslationMatrix = GLES20.glGetUniformLocation(this.programId, "translationMatrix");
        this.refIsBackgroundGenerated = GLES20.glGetUniformLocation(this.programId, "isBackgroundGenerated");
        int[] iArr = new int[2];
        GLES20.glGenTextures(2, iArr, 0);
        this.mediaTextureId = iArr[0];
        this.backgroundTextureId = iArr[1];
        if (this.isImageMedia && !this.imageMediaFilePath.isEmpty()) {
            Bitmap bitmapLoadBitmapForOpenGL = Utils.loadBitmapForOpenGL(this.context, this.imageMediaFilePath, false, this.maxScreenWidth, this.isSupportingNPOT);
            if (bitmapLoadBitmapForOpenGL != null) {
                GLES20.glBindTexture(3553, this.mediaTextureId);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLUtils.texImage2D(3553, 0, 6408, bitmapLoadBitmapForOpenGL, 0);
                bitmapLoadBitmapForOpenGL.recycle();
                ShaderUtils.checkGlError("glBindTexture media image texture");
                return;
            }
            return;
        }
        GLES20.glBindTexture(36197, this.mediaTextureId);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        ShaderUtils.checkGlError("glBindTexture video texture");
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mediaTextureId);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        Surface surface = new Surface(this.surfaceTexture);
        this.videoSurface = surface;
        this.exoMediaPlayer.setVideoSurface(surface);
        seekMediaPlayer(this.videoPlaybackStartTime);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.d("GLRenderer", "onSurfaceChanged: " + i + " " + i2);
        screenWidth = i;
        screenHeight = i2;
        float f = this.scaleX;
        if (f != 0.0f) {
            this.sxRatio = f / i;
            this.syRatio = this.scaleY / i2;
        }
        this.isSceneCreated = true;
        computeGlCoordination();
        createCoordinationMatrices();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) throws IOException {
        Pair<Integer, Integer> pairPoll;
        SimpleExoPlayer simpleExoPlayer;
        Log.e("GLRenderer", "onDrawFrame: ");
        if (this.isUpdatingState) {
            return;
        }
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (!this.isImageMedia) {
            synchronized (this) {
                if (this.updateSurface) {
                    try {
                        this.surfaceTexture.updateTexImage();
                        this.updateSurface = false;
                    } catch (Exception unused) {
                    }
                }
            }
        }
        GLES20.glUseProgram(this.programId);
        this.vertexBuffer.position(0);
        GLES20.glEnableVertexAttribArray(this.aPositionLocation);
        GLES20.glVertexAttribPointer(this.aPositionLocation, 3, 5126, false, 12, (Buffer) this.vertexBuffer);
        this.textureVertexBuffer.position(0);
        GLES20.glEnableVertexAttribArray(this.aTextureCoordLocation);
        GLES20.glVertexAttribPointer(this.aTextureCoordLocation, 2, 5126, false, 8, (Buffer) this.textureVertexBuffer);
        GLES20.glUniform1i(this.refFilterId, this.filterId);
        GLES20.glUniform1i(this.refFilterChangeDirection, this.filterChangeDirection);
        GLES20.glUniform1f(this.refNewFilterPos, this.newFilterXPositionRatio);
        GLES20.glUniform1f(this.refSaturation, this.saturation);
        GLES20.glUniform1f(this.refContrast, this.contrast);
        GLES20.glUniform1f(this.refBrightness, this.brightness);
        GLES20.glUniform1f(this.refNextSaturation, this.nextSaturation);
        GLES20.glUniform1f(this.refNextContrast, this.nextContrast);
        GLES20.glUniform1f(this.refNextBrightness, this.nextBrightness);
        GLES20.glUniform1i(this.refHasRotation, this.mediaRotation + this.originalMediaRotation != 0.0f ? 1 : 0);
        GLES20.glUniform1i(this.refIsBackgroundGenerated, this.isBackgroundGenerated ? 1 : 0);
        GLES20.glUniformMatrix4fv(this.refRotationMatrix, 1, false, this.rotationMatrix, 0);
        GLES20.glUniformMatrix4fv(this.refScaleMatrix, 1, false, this.scaleMatrix, 0);
        GLES20.glUniformMatrix4fv(this.refTranslationMatrix, 1, false, this.translationMatrix, 0);
        GLES20.glActiveTexture(33984);
        if (this.isImageMedia) {
            GLES20.glBindTexture(3553, this.mediaTextureId);
        } else {
            GLES20.glBindTexture(36197, this.mediaTextureId);
        }
        if (this.isBackgroundGenerated) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.backgroundTextureId);
        }
        GLES20.glUniform1i(this.mediaTextureLocation, 0);
        GLES20.glUniform1i(this.backgroundTextureLocation, 1);
        GLES20.glViewport(0, 0, screenWidth, screenHeight);
        GLES20.glDrawArrays(5, 0, 4);
        if (!this.isImageMedia && this.videoPlaybackEndTime != -1 && (simpleExoPlayer = this.exoMediaPlayer) != null && simpleExoPlayer.getCurrentPosition() >= this.videoPlaybackEndTime) {
            seekMediaPlayer(this.videoPlaybackStartTime);
        }
        if (this.mCaptureEnabled && this.isImageMedia) {
            this.mCaptureEnabled = false;
            String strSaveBitmap = Utils.saveBitmap(getRenderBufferBitmap());
            ImageCaptureListener imageCaptureListener = this.imageCaptureListener;
            if (imageCaptureListener != null) {
                imageCaptureListener.onImageCaptured(strSaveBitmap);
            }
        }
        if (!this.isColorPickingModeEnabled || (pairPoll = this.colorPickerQueue.poll()) == null) {
            return;
        }
        Bitmap singlePixel = getSinglePixel(pairPoll.first.intValue(), screenHeight - pairPoll.second.intValue(), gl10);
        int pixel = singlePixel.getPixel(0, 0);
        singlePixel.recycle();
        ColorPickerListener colorPickerListener = this.colorPickerListener;
        if (colorPickerListener != null) {
            colorPickerListener.onColorPickerResult(pairPoll.first.intValue(), pairPoll.second.intValue(), pixel);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.updateSurface = true;
    }

    @Override // ir.appp.rghapp.BackgroundGenerationListener
    public void onGradientBackgroundGenerated(final String str) {
        GLSurfaceView gLSurfaceView = this.glSurfaceView;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: ir.appp.rghapp.GLMediaRenderer.3
                @Override // java.lang.Runnable
                public void run() {
                    GLMediaRenderer.this.setGradientBackground(str);
                }
            });
        }
    }

    private Bitmap getSinglePixel(int i, int i2, GL10 gl10) {
        int[] iArr = new int[(i2 + 1) * 1];
        int[] iArr2 = new int[1];
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        intBufferWrap.position(0);
        gl10.glReadPixels(i, i2, 1, i2, 6408, 5121, intBufferWrap);
        int i3 = 0;
        int i4 = 0;
        while (i3 < 1) {
            for (int i5 = 0; i5 < 1; i5++) {
                int i6 = iArr[(i3 * 1) + i5];
                iArr2[(((1 - i4) - 1) * 1) + i5] = (i6 & (-16711936)) | ((i6 << 16) & 16711680) | ((i6 >> 16) & 255);
            }
            i3++;
            i4++;
        }
        return Bitmap.createBitmap(iArr2, 1, 1, Bitmap.Config.RGB_565);
    }

    private Bitmap getRenderBufferBitmap() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(screenWidth * screenHeight * 4);
        GLES20.glReadPixels(0, 0, screenWidth, screenHeight, 6408, 5121, byteBufferAllocateDirect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        return bitmapCreateBitmap;
    }
}
