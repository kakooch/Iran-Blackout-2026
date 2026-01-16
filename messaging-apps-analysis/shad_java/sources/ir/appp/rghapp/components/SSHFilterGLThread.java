package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Looper;
import ir.appp.rghapp.DispatchQueue;
import ir.appp.rghapp.components.SSHFilterShaders;
import ir.appp.rghapp.rubinoPostSlider.FilterShaders;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;

/* loaded from: classes3.dex */
public class SSHFilterGLThread extends DispatchQueue {
    private boolean blurred;
    private final Context context;
    public Bitmap currentBitmap;
    private final Runnable drawRunnable;
    private EGL10 egl10;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private final SSHFilterShaders filterShaders;
    private int id;
    private boolean initied;
    private boolean isVideo;
    private long lastRenderCallTime;
    private boolean needRenderFirstFrameFromBitmap;
    private final int orientation;
    private int renderBufferHeight;
    private int renderBufferWidth;
    private boolean renderDataSet;
    private final FilterGLThreadRenderDelegate renderDelegate;
    private int simpleInputTexCoordHandle;
    private int simplePositionHandle;
    private int simpleShaderProgram;
    private int simpleSourceImageHandle;
    private volatile int surfaceHeight;
    private SurfaceTexture surfaceTexture;
    private volatile int surfaceWidth;
    private SSHFilterShaders tempFilterShaders;
    private final FloatBuffer textureBuffer;
    private boolean updateSurface;
    private FilterGLThreadVideoDelegate videoDelegate;
    private boolean videoFrameAvailable;
    private int videoHeight;
    private SurfaceTexture videoSurfaceTexture;
    private final int[] videoTexture;
    private final float[] videoTextureMatrix;
    private int videoWidth;

    public interface FilterGLThreadRenderDelegate {
        void onRenderDataAvailable(int i);
    }

    public interface FilterGLThreadVideoDelegate {
        void onVideoSurfaceCreated(SurfaceTexture surfaceTexture);
    }

    public SSHFilterGLThread(int i, Context context, SurfaceTexture surfaceTexture, boolean z, Bitmap bitmap, int i2, boolean z2, FilterGLThreadVideoDelegate filterGLThreadVideoDelegate, FilterGLThreadRenderDelegate filterGLThreadRenderDelegate) {
        this(i, context, surfaceTexture, z, bitmap, i2, z2, filterGLThreadVideoDelegate, filterGLThreadRenderDelegate, false);
    }

    public SSHFilterGLThread(int i, Context context, SurfaceTexture surfaceTexture, boolean z, Bitmap bitmap, int i2, boolean z2, FilterGLThreadVideoDelegate filterGLThreadVideoDelegate, FilterGLThreadRenderDelegate filterGLThreadRenderDelegate, boolean z3) {
        super("GLThread" + i, false);
        this.videoTextureMatrix = new float[16];
        this.videoTexture = new int[1];
        this.drawRunnable = new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                if (SSHFilterGLThread.this.initied) {
                    if ((SSHFilterGLThread.this.eglContext.equals(SSHFilterGLThread.this.egl10.eglGetCurrentContext()) && SSHFilterGLThread.this.eglSurface.equals(SSHFilterGLThread.this.egl10.eglGetCurrentSurface(12377))) || SSHFilterGLThread.this.egl10.eglMakeCurrent(SSHFilterGLThread.this.eglDisplay, SSHFilterGLThread.this.eglSurface, SSHFilterGLThread.this.eglSurface, SSHFilterGLThread.this.eglContext)) {
                        if (!SSHFilterGLThread.this.isVideo || !SSHFilterGLThread.this.needRenderFirstFrameFromBitmap) {
                            if (SSHFilterGLThread.this.updateSurface) {
                                SSHFilterGLThread.this.videoSurfaceTexture.updateTexImage();
                                SSHFilterGLThread.this.videoSurfaceTexture.getTransformMatrix(SSHFilterGLThread.this.videoTextureMatrix);
                                SSHFilterGLThread sSHFilterGLThread = SSHFilterGLThread.this;
                                sSHFilterGLThread.setRenderData(sSHFilterGLThread.videoWidth, SSHFilterGLThread.this.videoHeight);
                                SSHFilterGLThread.this.updateSurface = false;
                                SSHFilterGLThread.this.filterShaders.onVideoFrameUpdate(SSHFilterGLThread.this.videoTextureMatrix);
                                SSHFilterGLThread.this.videoFrameAvailable = true;
                            }
                            if (!SSHFilterGLThread.this.renderDataSet) {
                                return;
                            }
                            if (!SSHFilterGLThread.this.isVideo || SSHFilterGLThread.this.videoFrameAvailable) {
                                GLES20.glViewport(0, 0, SSHFilterGLThread.this.renderBufferWidth, SSHFilterGLThread.this.renderBufferHeight);
                                SSHFilterGLThread.this.filterShaders.drawLuxPass();
                                SSHFilterGLThread.this.filterShaders.drawSharpenPass();
                                SSHFilterGLThread.this.filterShaders.drawCustomParamsPass();
                                SSHFilterGLThread sSHFilterGLThread2 = SSHFilterGLThread.this;
                                sSHFilterGLThread2.blurred = sSHFilterGLThread2.filterShaders.drawBlurPass();
                            }
                            GLES20.glViewport(0, 0, SSHFilterGLThread.this.surfaceWidth, SSHFilterGLThread.this.surfaceHeight);
                            GLES20.glBindFramebuffer(36160, 0);
                            GLES20.glUseProgram(SSHFilterGLThread.this.simpleShaderProgram);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, SSHFilterGLThread.this.filterShaders.getRenderTexture(!SSHFilterGLThread.this.blurred ? 1 : 0));
                            GLES20.glUniform1i(SSHFilterGLThread.this.simpleSourceImageHandle, 0);
                            GLES20.glEnableVertexAttribArray(SSHFilterGLThread.this.simpleInputTexCoordHandle);
                            GLES20.glVertexAttribPointer(SSHFilterGLThread.this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) (SSHFilterGLThread.this.textureBuffer != null ? SSHFilterGLThread.this.textureBuffer : SSHFilterGLThread.this.filterShaders.getTextureBuffer()));
                            GLES20.glEnableVertexAttribArray(SSHFilterGLThread.this.simplePositionHandle);
                            GLES20.glVertexAttribPointer(SSHFilterGLThread.this.simplePositionHandle, 2, 5126, false, 8, (Buffer) SSHFilterGLThread.this.filterShaders.getVertexBuffer());
                        } else {
                            GLES20.glViewport(0, 0, SSHFilterGLThread.this.renderBufferWidth, SSHFilterGLThread.this.renderBufferHeight);
                            SSHFilterGLThread.this.tempFilterShaders.drawLuxPass();
                            SSHFilterGLThread.this.tempFilterShaders.drawSharpenPass();
                            SSHFilterGLThread.this.tempFilterShaders.drawCustomParamsPass();
                            SSHFilterGLThread.this.tempFilterShaders.drawBlurPass();
                            GLES20.glViewport(0, 0, SSHFilterGLThread.this.surfaceWidth, SSHFilterGLThread.this.surfaceHeight);
                            GLES20.glBindFramebuffer(36160, 0);
                            GLES20.glUseProgram(SSHFilterGLThread.this.simpleShaderProgram);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, SSHFilterGLThread.this.tempFilterShaders.getRenderTexture(1));
                            GLES20.glUniform1i(SSHFilterGLThread.this.simpleSourceImageHandle, 0);
                            GLES20.glEnableVertexAttribArray(SSHFilterGLThread.this.simpleInputTexCoordHandle);
                            GLES20.glVertexAttribPointer(SSHFilterGLThread.this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) (SSHFilterGLThread.this.textureBuffer != null ? SSHFilterGLThread.this.textureBuffer : SSHFilterGLThread.this.tempFilterShaders.getTextureBuffer()));
                            GLES20.glEnableVertexAttribArray(SSHFilterGLThread.this.simplePositionHandle);
                            GLES20.glVertexAttribPointer(SSHFilterGLThread.this.simplePositionHandle, 2, 5126, false, 8, (Buffer) SSHFilterGLThread.this.tempFilterShaders.getVertexBuffer());
                        }
                        GLES20.glDrawArrays(5, 0, 4);
                        SSHFilterGLThread.this.egl10.eglSwapBuffers(SSHFilterGLThread.this.eglDisplay, SSHFilterGLThread.this.eglSurface);
                        if (SSHFilterGLThread.this.renderDelegate != null) {
                            SSHFilterGLThread.this.renderDelegate.onRenderDataAvailable(SSHFilterGLThread.this.id);
                            return;
                        }
                        return;
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(SSHFilterGLThread.this.egl10.eglGetError()));
                    }
                }
            }
        };
        this.context = context;
        this.id = i;
        this.isVideo = z;
        this.surfaceTexture = surfaceTexture;
        this.videoDelegate = filterGLThreadVideoDelegate;
        this.renderDelegate = filterGLThreadRenderDelegate;
        this.currentBitmap = bitmap;
        this.orientation = i2;
        this.filterShaders = new SSHFilterShaders(context, z, i2);
        if (z3 && z) {
            this.needRenderFirstFrameFromBitmap = true;
            this.tempFilterShaders = new SSHFilterShaders(context, false, 0);
        } else {
            this.needRenderFirstFrameFromBitmap = false;
        }
        float[] fArr = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        if (z2) {
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
        floatBufferAsFloatBuffer.position(0);
        start();
    }

    public void setNeedRenderFirstFrameFromBitmap(final boolean z) {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNeedRenderFirstFrameFromBitmap$0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNeedRenderFirstFrameFromBitmap$0(boolean z) {
        this.needRenderFirstFrameFromBitmap = z;
        if (z) {
            return;
        }
        this.tempFilterShaders = null;
    }

    public void setFilterGLThreadDelegate(final SSHFilterShaders.FilterShadersDelegate filterShadersDelegate) {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setFilterGLThreadDelegate$1(filterShadersDelegate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFilterGLThreadDelegate$1(SSHFilterShaders.FilterShadersDelegate filterShadersDelegate) {
        if (this.isVideo && this.needRenderFirstFrameFromBitmap) {
            this.tempFilterShaders.setDelegate(filterShadersDelegate);
        }
        this.filterShaders.setDelegate(filterShadersDelegate);
    }

    private boolean initGL() throws IOException {
        int width;
        int height;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl10 = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.eglDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            }
            finish();
            return false;
        }
        if (!this.egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("eglInitialize failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            }
            finish();
            return false;
        }
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.egl10.eglChooseConfig(this.eglDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            }
            finish();
            return false;
        }
        if (iArr[0] > 0) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            this.eglConfig = eGLConfig;
            EGLContext eGLContextEglCreateContext = this.egl10.eglCreateContext(this.eglDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.eglContext = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext == null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglCreateContext failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                EGLSurface eGLSurfaceEglCreateWindowSurface = this.egl10.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surfaceTexture, null);
                this.eglSurface = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("createWindowSurface failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                    }
                    finish();
                    return false;
                }
                if (!this.egl10.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext)) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                    }
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
                Bitmap bitmap = this.currentBitmap;
                if (bitmap != null) {
                    width = bitmap.getWidth();
                    height = this.currentBitmap.getHeight();
                } else {
                    width = this.videoWidth;
                    height = this.videoHeight;
                }
                if (this.isVideo && this.videoDelegate != null) {
                    GLES20.glGenTextures(1, this.videoTexture, 0);
                    Matrix.setIdentityM(this.videoTextureMatrix, 0);
                    SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.videoTexture[0]);
                    this.videoSurfaceTexture = surfaceTexture2;
                    surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda0
                        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                        public final void onFrameAvailable(SurfaceTexture surfaceTexture3) {
                            this.f$0.lambda$initGL$2(surfaceTexture3);
                        }
                    });
                    GLES20.glBindTexture(36197, this.videoTexture[0]);
                    GLES20.glTexParameterf(36197, 10240, 9729.0f);
                    GLES20.glTexParameterf(36197, 10241, 9728.0f);
                    GLES20.glTexParameteri(36197, 10242, 33071);
                    GLES20.glTexParameteri(36197, 10243, 33071);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$initGL$3();
                        }
                    });
                }
                if (this.isVideo && this.needRenderFirstFrameFromBitmap && !this.tempFilterShaders.create()) {
                    finish();
                    return false;
                }
                if (!this.filterShaders.create()) {
                    finish();
                    return false;
                }
                setRenderData(width, height);
                return true;
            }
            finish();
            return false;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("eglConfig not initialized");
        }
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGL$2(SurfaceTexture surfaceTexture) {
        requestRender(false, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGL$3() {
        this.videoDelegate.onVideoSurfaceCreated(this.videoSurfaceTexture);
    }

    public void setVideoSize(final int i, final int i2) {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.f$0.lambda$setVideoSize$7(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVideoSize$7(int i, int i2) throws IOException {
        if (this.videoWidth == i && this.videoHeight == i2) {
            return;
        }
        this.videoWidth = i;
        this.videoHeight = i2;
        if (i > 1280 || i2 > 1280) {
            this.videoWidth = i / 2;
            this.videoHeight = i2 / 2;
        }
        this.renderDataSet = false;
        setRenderData(this.videoWidth, this.videoHeight);
        this.drawRunnable.run();
    }

    public void finish() {
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
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setRenderData(int i, int i2) throws IOException {
        if (this.renderDataSet || i <= 0 || i2 <= 0) {
            return;
        }
        if (this.isVideo && this.needRenderFirstFrameFromBitmap) {
            this.tempFilterShaders.setRenderData(this.context, this.currentBitmap, this.orientation, this.videoTexture[0], i, i2, true);
        }
        this.filterShaders.setRenderData(this.context, this.currentBitmap, this.orientation, this.videoTexture[0], i, i2, true);
        this.renderDataSet = true;
        this.renderBufferWidth = this.filterShaders.getRenderBufferWidth();
        this.renderBufferHeight = this.filterShaders.getRenderBufferHeight();
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
            if (postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getTexture$8(bitmapArr, countDownLatch);
                }
            })) {
                countDownLatch.await();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return bitmapArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTexture$8(Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
        GLES20.glBindFramebuffer(36160, this.filterShaders.getRenderFrameBuffer());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.filterShaders.getRenderTexture(!this.blurred ? 1 : 0), 0);
        GLES20.glClear(0);
        bitmapArr[0] = getRenderBufferBitmap();
        countDownLatch.countDown();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClear(0);
    }

    public void shutdown() {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$shutdown$9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shutdown$9() {
        finish();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    public void setSurfaceTextureSize(final int i, final int i2) {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setSurfaceTextureSize$11(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSurfaceTextureSize$11(int i, int i2) {
        this.surfaceWidth = i;
        this.surfaceHeight = i2;
    }

    @Override // ir.appp.rghapp.DispatchQueue, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.initied = initGL();
        super.run();
    }

    public void requestRender(boolean z) {
        requestRender(z, false, false);
    }

    public void requestRender(final boolean z, final boolean z2, final boolean z3) {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHFilterGLThread$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$requestRender$14(z, z3, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestRender$14(boolean z, boolean z2, boolean z3) {
        if (this.isVideo && this.needRenderFirstFrameFromBitmap) {
            this.tempFilterShaders.requestUpdateBlurTexture();
        } else if (z) {
            this.filterShaders.requestUpdateBlurTexture();
        }
        if (z2) {
            this.updateSurface = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z3 || Math.abs(this.lastRenderCallTime - jCurrentTimeMillis) > 10) {
            this.lastRenderCallTime = jCurrentTimeMillis;
            this.drawRunnable.run();
        }
    }
}
