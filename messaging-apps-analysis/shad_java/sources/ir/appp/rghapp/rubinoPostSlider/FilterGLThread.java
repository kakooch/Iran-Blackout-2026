package ir.appp.rghapp.rubinoPostSlider;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import ir.appp.rghapp.ColorPickerListener;
import ir.appp.rghapp.DispatchQueue;
import ir.appp.rghapp.Utils;
import ir.resaneh1.iptv.fragment.AddStoryMediaType;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class FilterGLThread extends DispatchQueue implements BackgroundGenerationListener2 {
    private boolean blurred;
    public ColorPickerListener colorPickerListener;
    private Queue<Pair<Integer, Integer>> colorPickerQueue;
    private Bitmap currentBitmap;
    private final Runnable drawRunnable;
    private EGL10 egl10;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private FilterShaders filterShaders;
    private boolean initied;
    public boolean isColorPickingModeEnabled;
    private long lastRenderCallTime;
    private AddStoryMediaType mediaType;
    private int orientation;
    private int renderBufferHeight;
    private int renderBufferWidth;
    private boolean renderDataSet;
    private int simpleInputTexCoordHandle;
    private int simplePositionHandle;
    private int simpleShaderProgram;
    private int simpleSourceImageHandle;
    private volatile int surfaceHeight;
    private SurfaceTexture surfaceTexture;
    private volatile int surfaceWidth;
    private FloatBuffer textureBuffer;
    private boolean updateSurface;
    private FilterGLThreadVideoDelegate videoDelegate;
    private boolean videoFrameAvailable;
    private int videoHeight;
    private VideoPlayer videoPlayerInCharge;
    private SurfaceTexture videoSurfaceTexture;
    private final int[] videoTexture;
    private final float[] videoTextureMatrix;
    private int videoWidth;

    public interface FilterGLThreadVideoDelegate {
        void onVideoSurfaceCreated(SurfaceTexture surfaceTexture);
    }

    public FilterGLThread(SurfaceTexture surfaceTexture, String str, int i, int i2) {
        super("NoMediaGLThread", false);
        this.videoTextureMatrix = new float[16];
        this.videoTexture = new int[1];
        this.isColorPickingModeEnabled = false;
        this.drawRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (FilterGLThread.this.initied) {
                    if ((FilterGLThread.this.eglContext.equals(FilterGLThread.this.egl10.eglGetCurrentContext()) && FilterGLThread.this.eglSurface.equals(FilterGLThread.this.egl10.eglGetCurrentSurface(12377))) || FilterGLThread.this.egl10.eglMakeCurrent(FilterGLThread.this.eglDisplay, FilterGLThread.this.eglSurface, FilterGLThread.this.eglSurface, FilterGLThread.this.eglContext)) {
                        if (FilterGLThread.this.updateSurface) {
                            FilterGLThread.this.videoSurfaceTexture.updateTexImage();
                            FilterGLThread.this.videoSurfaceTexture.getTransformMatrix(FilterGLThread.this.videoTextureMatrix);
                            FilterGLThread.this.setRenderData();
                            FilterGLThread.this.updateSurface = false;
                            FilterGLThread.this.filterShaders.onVideoFrameUpdate(FilterGLThread.this.videoTextureMatrix);
                            FilterGLThread.this.videoFrameAvailable = true;
                        }
                        if (FilterGLThread.this.renderDataSet) {
                            if (FilterGLThread.this.videoDelegate == null || FilterGLThread.this.videoFrameAvailable) {
                                GLES20.glViewport(0, 0, FilterGLThread.this.renderBufferWidth, FilterGLThread.this.renderBufferHeight);
                                FilterGLThread.this.filterShaders.drawEnhancePass();
                            }
                            GLES20.glViewport(0, 0, FilterGLThread.this.surfaceWidth, FilterGLThread.this.surfaceHeight);
                            GLES20.glBindFramebuffer(36160, 0);
                            GLES20.glUseProgram(FilterGLThread.this.simpleShaderProgram);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, FilterGLThread.this.filterShaders.getRenderTexture(1 ^ (FilterGLThread.this.blurred ? 1 : 0)));
                            GLES20.glUniform1i(FilterGLThread.this.simpleSourceImageHandle, 0);
                            GLES20.glEnableVertexAttribArray(FilterGLThread.this.simpleInputTexCoordHandle);
                            GLES20.glVertexAttribPointer(FilterGLThread.this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) (FilterGLThread.this.textureBuffer != null ? FilterGLThread.this.textureBuffer : FilterGLThread.this.filterShaders.getTextureBuffer()));
                            GLES20.glEnableVertexAttribArray(FilterGLThread.this.simplePositionHandle);
                            GLES20.glVertexAttribPointer(FilterGLThread.this.simplePositionHandle, 2, 5126, false, 8, (Buffer) FilterGLThread.this.filterShaders.getVertexBuffer());
                            GLES20.glDrawArrays(5, 0, 4);
                            FilterGLThread.this.egl10.eglSwapBuffers(FilterGLThread.this.eglDisplay, FilterGLThread.this.eglSurface);
                            return;
                        }
                        return;
                    }
                    Log.e("FilterGLThread", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(FilterGLThread.this.egl10.eglGetError()));
                }
            }
        };
        this.mediaType = AddStoryMediaType.None;
        commonInitForImageMedia(surfaceTexture, str, i, i2, false);
    }

    public FilterGLThread(SurfaceTexture surfaceTexture, Bitmap bitmap, String str, int i, boolean z, int i2, int i3) {
        super("PhotoFilterGLThread", false);
        this.videoTextureMatrix = new float[16];
        this.videoTexture = new int[1];
        this.isColorPickingModeEnabled = false;
        this.drawRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (FilterGLThread.this.initied) {
                    if ((FilterGLThread.this.eglContext.equals(FilterGLThread.this.egl10.eglGetCurrentContext()) && FilterGLThread.this.eglSurface.equals(FilterGLThread.this.egl10.eglGetCurrentSurface(12377))) || FilterGLThread.this.egl10.eglMakeCurrent(FilterGLThread.this.eglDisplay, FilterGLThread.this.eglSurface, FilterGLThread.this.eglSurface, FilterGLThread.this.eglContext)) {
                        if (FilterGLThread.this.updateSurface) {
                            FilterGLThread.this.videoSurfaceTexture.updateTexImage();
                            FilterGLThread.this.videoSurfaceTexture.getTransformMatrix(FilterGLThread.this.videoTextureMatrix);
                            FilterGLThread.this.setRenderData();
                            FilterGLThread.this.updateSurface = false;
                            FilterGLThread.this.filterShaders.onVideoFrameUpdate(FilterGLThread.this.videoTextureMatrix);
                            FilterGLThread.this.videoFrameAvailable = true;
                        }
                        if (FilterGLThread.this.renderDataSet) {
                            if (FilterGLThread.this.videoDelegate == null || FilterGLThread.this.videoFrameAvailable) {
                                GLES20.glViewport(0, 0, FilterGLThread.this.renderBufferWidth, FilterGLThread.this.renderBufferHeight);
                                FilterGLThread.this.filterShaders.drawEnhancePass();
                            }
                            GLES20.glViewport(0, 0, FilterGLThread.this.surfaceWidth, FilterGLThread.this.surfaceHeight);
                            GLES20.glBindFramebuffer(36160, 0);
                            GLES20.glUseProgram(FilterGLThread.this.simpleShaderProgram);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, FilterGLThread.this.filterShaders.getRenderTexture(1 ^ (FilterGLThread.this.blurred ? 1 : 0)));
                            GLES20.glUniform1i(FilterGLThread.this.simpleSourceImageHandle, 0);
                            GLES20.glEnableVertexAttribArray(FilterGLThread.this.simpleInputTexCoordHandle);
                            GLES20.glVertexAttribPointer(FilterGLThread.this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) (FilterGLThread.this.textureBuffer != null ? FilterGLThread.this.textureBuffer : FilterGLThread.this.filterShaders.getTextureBuffer()));
                            GLES20.glEnableVertexAttribArray(FilterGLThread.this.simplePositionHandle);
                            GLES20.glVertexAttribPointer(FilterGLThread.this.simplePositionHandle, 2, 5126, false, 8, (Buffer) FilterGLThread.this.filterShaders.getVertexBuffer());
                            GLES20.glDrawArrays(5, 0, 4);
                            FilterGLThread.this.egl10.eglSwapBuffers(FilterGLThread.this.eglDisplay, FilterGLThread.this.eglSurface);
                            return;
                        }
                        return;
                    }
                    Log.e("FilterGLThread", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(FilterGLThread.this.egl10.eglGetError()));
                }
            }
        };
        this.mediaType = AddStoryMediaType.Picture;
        this.currentBitmap = bitmap;
        this.orientation = i;
        commonInitForImageMedia(surfaceTexture, str, i2, i3, z);
    }

    private void commonInitForImageMedia(SurfaceTexture surfaceTexture, String str, int i, int i2, boolean z) {
        this.surfaceTexture = surfaceTexture;
        this.filterShaders = new FilterShaders(str, i, i2);
        float[] fArr = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        if (z) {
            float f = fArr[2];
            fArr[2] = fArr[0];
            fArr[0] = f;
            float f2 = fArr[6];
            fArr[6] = fArr[4];
            fArr[4] = f2;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.textureBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr);
        this.textureBuffer.position(0);
        Utils.createGradientBackground(str, true, this);
        start();
    }

    public FilterGLThread(VideoPlayer videoPlayer, SurfaceTexture surfaceTexture, FilterGLThreadVideoDelegate filterGLThreadVideoDelegate) {
        super("VideoFilterGLThread", false);
        this.videoTextureMatrix = new float[16];
        this.videoTexture = new int[1];
        this.isColorPickingModeEnabled = false;
        this.drawRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (FilterGLThread.this.initied) {
                    if ((FilterGLThread.this.eglContext.equals(FilterGLThread.this.egl10.eglGetCurrentContext()) && FilterGLThread.this.eglSurface.equals(FilterGLThread.this.egl10.eglGetCurrentSurface(12377))) || FilterGLThread.this.egl10.eglMakeCurrent(FilterGLThread.this.eglDisplay, FilterGLThread.this.eglSurface, FilterGLThread.this.eglSurface, FilterGLThread.this.eglContext)) {
                        if (FilterGLThread.this.updateSurface) {
                            FilterGLThread.this.videoSurfaceTexture.updateTexImage();
                            FilterGLThread.this.videoSurfaceTexture.getTransformMatrix(FilterGLThread.this.videoTextureMatrix);
                            FilterGLThread.this.setRenderData();
                            FilterGLThread.this.updateSurface = false;
                            FilterGLThread.this.filterShaders.onVideoFrameUpdate(FilterGLThread.this.videoTextureMatrix);
                            FilterGLThread.this.videoFrameAvailable = true;
                        }
                        if (FilterGLThread.this.renderDataSet) {
                            if (FilterGLThread.this.videoDelegate == null || FilterGLThread.this.videoFrameAvailable) {
                                GLES20.glViewport(0, 0, FilterGLThread.this.renderBufferWidth, FilterGLThread.this.renderBufferHeight);
                                FilterGLThread.this.filterShaders.drawEnhancePass();
                            }
                            GLES20.glViewport(0, 0, FilterGLThread.this.surfaceWidth, FilterGLThread.this.surfaceHeight);
                            GLES20.glBindFramebuffer(36160, 0);
                            GLES20.glUseProgram(FilterGLThread.this.simpleShaderProgram);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, FilterGLThread.this.filterShaders.getRenderTexture(1 ^ (FilterGLThread.this.blurred ? 1 : 0)));
                            GLES20.glUniform1i(FilterGLThread.this.simpleSourceImageHandle, 0);
                            GLES20.glEnableVertexAttribArray(FilterGLThread.this.simpleInputTexCoordHandle);
                            GLES20.glVertexAttribPointer(FilterGLThread.this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) (FilterGLThread.this.textureBuffer != null ? FilterGLThread.this.textureBuffer : FilterGLThread.this.filterShaders.getTextureBuffer()));
                            GLES20.glEnableVertexAttribArray(FilterGLThread.this.simplePositionHandle);
                            GLES20.glVertexAttribPointer(FilterGLThread.this.simplePositionHandle, 2, 5126, false, 8, (Buffer) FilterGLThread.this.filterShaders.getVertexBuffer());
                            GLES20.glDrawArrays(5, 0, 4);
                            FilterGLThread.this.egl10.eglSwapBuffers(FilterGLThread.this.eglDisplay, FilterGLThread.this.eglSurface);
                            return;
                        }
                        return;
                    }
                    Log.e("FilterGLThread", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(FilterGLThread.this.egl10.eglGetError()));
                }
            }
        };
        this.mediaType = AddStoryMediaType.Video;
        this.surfaceTexture = surfaceTexture;
        this.videoDelegate = filterGLThreadVideoDelegate;
        this.videoPlayerInCharge = videoPlayer;
        String path = Utils.getPath(ApplicationLoader.applicationContext, this.videoPlayerInCharge.getCurrentUri());
        FilterShaders filterShaders = new FilterShaders(path);
        this.filterShaders = filterShaders;
        filterShaders.setExoMediaPlayer(this.videoPlayerInCharge.getInternalVideoPlayer());
        Utils.createGradientBackground(path, false, this);
        start();
    }

    private boolean initGL() {
        int storyViewWidthPx;
        int storyViewHeightPx;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl10 = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.eglDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            Log.e("FilterGLThread", "eglGetDisplay failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            finish();
            return false;
        }
        if (!this.egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
            Log.e("FilterGLThread", "eglInitialize failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            finish();
            return false;
        }
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.egl10.eglChooseConfig(this.eglDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
            Log.e("FilterGLThread", "eglChooseConfig failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            finish();
            return false;
        }
        if (iArr[0] > 0) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eGLContextEglCreateContext = this.egl10.eglCreateContext(this.eglDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.eglContext = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext == null) {
                Log.e("FilterGLThread", "eglCreateContext failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                finish();
                return false;
            }
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture instanceof SurfaceTexture) {
                EGLSurface eGLSurfaceEglCreateWindowSurface = this.egl10.eglCreateWindowSurface(this.eglDisplay, eGLConfig, surfaceTexture, null);
                this.eglSurface = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                    Log.e("FilterGLThread", "createWindowSurface failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                    finish();
                    return false;
                }
                if (!this.egl10.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext)) {
                    Log.e("FilterGLThread", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                    finish();
                    return false;
                }
                int iLoadShader = FilterShaders.loadShader(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
                int iLoadShader2 = FilterShaders.loadShader(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;void main() {gl_FragColor = texture2D(sourceImage, texCoord);}");
                if (iLoadShader == 0 || iLoadShader2 == 0) {
                    return false;
                }
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.simpleShaderProgram = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                GLES20.glAttachShader(this.simpleShaderProgram, iLoadShader2);
                GLES20.glBindAttribLocation(this.simpleShaderProgram, 0, "position");
                GLES20.glBindAttribLocation(this.simpleShaderProgram, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.simpleShaderProgram);
                int[] iArr2 = new int[1];
                GLES20.glGetProgramiv(this.simpleShaderProgram, 35714, iArr2, 0);
                if (iArr2[0] == 0) {
                    GLES20.glDeleteProgram(this.simpleShaderProgram);
                    this.simpleShaderProgram = 0;
                } else {
                    this.simplePositionHandle = GLES20.glGetAttribLocation(this.simpleShaderProgram, "position");
                    this.simpleInputTexCoordHandle = GLES20.glGetAttribLocation(this.simpleShaderProgram, "inputTexCoord");
                    this.simpleSourceImageHandle = GLES20.glGetUniformLocation(this.simpleShaderProgram, "sourceImage");
                }
                AddStoryMediaType addStoryMediaType = this.mediaType;
                if (addStoryMediaType == AddStoryMediaType.Picture) {
                    storyViewWidthPx = this.currentBitmap.getWidth();
                    storyViewHeightPx = this.currentBitmap.getHeight();
                } else if (addStoryMediaType == AddStoryMediaType.Video) {
                    storyViewWidthPx = this.videoWidth;
                    storyViewHeightPx = this.videoHeight;
                } else {
                    storyViewWidthPx = (int) DimensionHelper.getStoryViewWidthPx(ApplicationLoader.applicationActivity);
                    storyViewHeightPx = (int) DimensionHelper.getStoryViewHeightPx(ApplicationLoader.applicationActivity);
                }
                int i = storyViewWidthPx;
                int i2 = storyViewHeightPx;
                if (this.videoDelegate != null) {
                    GLES20.glGenTextures(1, this.videoTexture, 0);
                    Matrix.setIdentityM(this.videoTextureMatrix, 0);
                    SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.videoTexture[0]);
                    this.videoSurfaceTexture = surfaceTexture2;
                    surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda0
                        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                        public final void onFrameAvailable(SurfaceTexture surfaceTexture3) {
                            this.f$0.lambda$initGL$0(surfaceTexture3);
                        }
                    });
                    GLES20.glBindTexture(36197, this.videoTexture[0]);
                    GLES20.glTexParameterf(36197, 10240, 9729.0f);
                    GLES20.glTexParameterf(36197, 10241, 9728.0f);
                    GLES20.glTexParameteri(36197, 10242, 33071);
                    GLES20.glTexParameteri(36197, 10243, 33071);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$initGL$1();
                        }
                    });
                }
                if (!this.filterShaders.create()) {
                    finish();
                    return false;
                }
                if (i != 0 && i2 != 0) {
                    this.filterShaders.setRenderData(this.currentBitmap, this.orientation, this.videoTexture[0], i, i2);
                    this.renderDataSet = true;
                    this.renderBufferWidth = this.filterShaders.getRenderBufferWidth();
                    this.renderBufferHeight = this.filterShaders.getRenderBufferHeight();
                }
                return true;
            }
            finish();
            return false;
        }
        Log.e("FilterGLThread", "eglConfig not initialized");
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGL$0(SurfaceTexture surfaceTexture) {
        requestRender(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGL$1() {
        this.videoDelegate.onVideoSurfaceCreated(this.videoSurfaceTexture);
    }

    public void setVideoSize(final int i, final int i2) {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setVideoSize$2(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideoSize$2(int i, int i2) {
        if ((this.videoWidth == i && this.videoHeight == i2) || ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.videoWidth = (int) DimensionHelper.getStoryViewWidthPx(ApplicationLoader.applicationActivity);
        this.videoHeight = (int) DimensionHelper.getStoryViewHeightPx(ApplicationLoader.applicationActivity);
        this.renderDataSet = false;
        setRenderData();
        this.drawRunnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRenderData() {
        int i;
        int i2;
        if (this.renderDataSet || (i = this.videoWidth) <= 0 || (i2 = this.videoHeight) <= 0) {
            return;
        }
        this.filterShaders.setRenderData(this.currentBitmap, this.orientation, this.videoTexture[0], i, i2);
        this.renderDataSet = true;
        this.renderBufferWidth = this.filterShaders.getRenderBufferWidth();
        this.renderBufferHeight = this.filterShaders.getRenderBufferHeight();
    }

    public void finish() {
        SurfaceTexture surfaceTexture;
        this.currentBitmap = null;
        if (this.eglSurface != null) {
            EGL10 egl10 = this.egl10;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.egl10.eglDestroySurface(this.eglDisplay, this.eglSurface);
            this.eglSurface = null;
        }
        EGLContext eGLContext = this.eglContext;
        if (eGLContext != null) {
            this.egl10.eglDestroyContext(this.eglDisplay, eGLContext);
            this.eglContext = null;
        }
        EGLDisplay eGLDisplay2 = this.eglDisplay;
        if (eGLDisplay2 != null) {
            this.egl10.eglTerminate(eGLDisplay2);
            this.eglDisplay = null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21 && (surfaceTexture = this.surfaceTexture) != null) {
                surfaceTexture.release();
            }
            SurfaceTexture surfaceTexture2 = this.videoSurfaceTexture;
            if (surfaceTexture2 != null) {
                surfaceTexture2.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getRenderBufferBitmap() {
        int i;
        int i2 = this.renderBufferWidth;
        if (i2 == 0 || (i = this.renderBufferHeight) == 0) {
            return null;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i2 * i * 4);
        GLES20.glReadPixels(0, 0, this.renderBufferWidth, this.renderBufferHeight, 6408, 5121, byteBufferAllocateDirect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.renderBufferWidth, this.renderBufferHeight, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        return bitmapCreateBitmap;
    }

    public Bitmap getTexture() throws InterruptedException {
        if (!this.initied || !isAlive()) {
            return null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Bitmap[] bitmapArr = new Bitmap[1];
        try {
            if (postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getTexture$3(bitmapArr, countDownLatch);
                }
            })) {
                countDownLatch.await();
            }
        } catch (Exception e) {
            String message = e.getMessage();
            message.getClass();
            Log.e("FilterGLThread", message);
        }
        return bitmapArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTexture$3(Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
        GLES20.glBindFramebuffer(36160, this.filterShaders.getRenderFrameBuffer());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.filterShaders.getRenderTexture(!this.blurred ? 1 : 0), 0);
        GLES20.glClear(0);
        bitmapArr[0] = getRenderBufferBitmap();
        countDownLatch.countDown();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClear(0);
    }

    public void shutdown() {
        if (isAlive()) {
            postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$shutdown$4();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shutdown$4() {
        finish();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    public void setSurfaceTextureSize(final int i, final int i2) {
        if (isAlive()) {
            postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setSurfaceTextureSize$5(i, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSurfaceTextureSize$5(int i, int i2) {
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
        FilterShaders filterShaders = this.filterShaders;
        if (filterShaders != null) {
            filterShaders.onSurfaceSizeChanged(i, i2);
        }
    }

    public int getRenderBufferWidth() {
        return this.renderBufferWidth;
    }

    public int getRenderBufferHeight() {
        return this.renderBufferHeight;
    }

    @Override // ir.appp.rghapp.DispatchQueue, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.initied = initGL();
        super.run();
    }

    public void requestRender() {
        requestRender(false, false);
    }

    public void requestRender(final boolean z, final boolean z2) {
        if (isAlive()) {
            postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$requestRender$6(z2, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestRender$6(boolean z, boolean z2) {
        if (z) {
            this.updateSurface = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z2 || Math.abs(this.lastRenderCallTime - jCurrentTimeMillis) > 30) {
            this.lastRenderCallTime = jCurrentTimeMillis;
            this.drawRunnable.run();
        }
    }

    public FilterShaders getFilterShader() {
        return this.filterShaders;
    }

    @Override // ir.appp.rghapp.rubinoPostSlider.BackgroundGenerationListener2
    public void onGradientBackgroundGenerated(int i, int i2) {
        this.filterShaders.setGradientBackground(i, i2);
        if (this.mediaType == AddStoryMediaType.None) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onGradientBackgroundGenerated$8();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGradientBackgroundGenerated$8() {
        requestRender(true, false);
    }

    public void setColorPickerListener(ColorPickerListener colorPickerListener) {
        this.colorPickerListener = colorPickerListener;
    }

    public void setColorPickingMode(boolean z) {
        if (this.videoDelegate != null) {
            if (z) {
                this.filterShaders.pauseMediaPlayback();
            } else {
                this.filterShaders.resumeMediaPlayback();
            }
        }
        this.isColorPickingModeEnabled = z;
        if (z) {
            if (this.colorPickerQueue == null) {
                this.colorPickerQueue = new LinkedList();
            }
        } else {
            Queue<Pair<Integer, Integer>> queue = this.colorPickerQueue;
            if (queue != null) {
                queue.clear();
            }
        }
    }

    public void getPixelColor(int i, int i2) {
        Pair<Integer, Integer> pairPoll;
        Bitmap singlePixel;
        if (this.isColorPickingModeEnabled) {
            this.colorPickerQueue.add(new Pair<>(Integer.valueOf(i), Integer.valueOf(i2)));
            if (this.colorPickerQueue.size() > 50) {
                this.colorPickerQueue.poll();
            }
            if (this.isColorPickingModeEnabled && (pairPoll = this.colorPickerQueue.poll()) != null && (singlePixel = getSinglePixel(((Integer) pairPoll.first).intValue(), ((Integer) pairPoll.second).intValue())) != null) {
                int pixel = singlePixel.getPixel(0, 0);
                singlePixel.recycle();
                ColorPickerListener colorPickerListener = this.colorPickerListener;
                if (colorPickerListener != null) {
                    colorPickerListener.onColorPickerResult(((Integer) pairPoll.first).intValue(), ((Integer) pairPoll.second).intValue(), pixel);
                }
            }
            MyLog.e("FilterGLThread", "color picking queue size = " + this.colorPickerQueue.size());
        }
    }

    private Bitmap getSinglePixel(final int i, final int i2) throws InterruptedException {
        if (!this.initied || !isAlive()) {
            return null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Bitmap[] bitmapArr = new Bitmap[1];
        try {
            if (postRunnable(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.FilterGLThread$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getSinglePixel$9(i, i2, bitmapArr, countDownLatch);
                }
            })) {
                countDownLatch.await();
            }
        } catch (Exception e) {
            String message = e.getMessage();
            message.getClass();
            Log.e("FilterGLThread", message);
        }
        return bitmapArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getSinglePixel$9(int i, int i2, Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
        GLES20.glBindFramebuffer(36160, this.filterShaders.getRenderFrameBuffer());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.filterShaders.getRenderTexture(!this.blurred ? 1 : 0), 0);
        GLES20.glClear(0);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(4);
        GLES20.glReadPixels(i, i2, 1, 1, 6408, 5121, byteBufferAllocateDirect);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        bitmapArr[0] = bitmapCreateBitmap;
        countDownLatch.countDown();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClear(0);
    }
}
