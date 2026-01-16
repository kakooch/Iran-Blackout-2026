package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Looper;
import android.util.Log;
import ir.appp.rghapp.DispatchQueue;
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

/* loaded from: classes3.dex */
public class SSHThumbnailFilterGLThread extends DispatchQueue {
    private final boolean blur;
    public Bitmap currentBitmap;
    private final Runnable drawRunnable;
    private EGL10 egl10;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int id;
    private boolean initied;
    private long lastRenderCallTime;
    private final ThumbnailGLThreadListener listener;
    private final int orientation;
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
    private final FloatBuffer textureBuffer;
    private final SSHThumbnailFilterShader thumbnailFilterShader;

    public interface ThumbnailGLThreadListener {
        void onRenderDataAvailable(int i);
    }

    public SSHThumbnailFilterGLThread(int i, Context context, SurfaceTexture surfaceTexture, Bitmap bitmap, boolean z, int i2, ThumbnailGLThreadListener thumbnailGLThreadListener) {
        super("THGLThread" + i, false);
        this.drawRunnable = new Runnable() { // from class: ir.appp.rghapp.components.SSHThumbnailFilterGLThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (SSHThumbnailFilterGLThread.this.initied) {
                    if ((SSHThumbnailFilterGLThread.this.eglContext.equals(SSHThumbnailFilterGLThread.this.egl10.eglGetCurrentContext()) && SSHThumbnailFilterGLThread.this.eglSurface.equals(SSHThumbnailFilterGLThread.this.egl10.eglGetCurrentSurface(12377))) || SSHThumbnailFilterGLThread.this.egl10.eglMakeCurrent(SSHThumbnailFilterGLThread.this.eglDisplay, SSHThumbnailFilterGLThread.this.eglSurface, SSHThumbnailFilterGLThread.this.eglSurface, SSHThumbnailFilterGLThread.this.eglContext)) {
                        if (SSHThumbnailFilterGLThread.this.renderDataSet) {
                            GLES20.glViewport(0, 0, SSHThumbnailFilterGLThread.this.renderBufferWidth, SSHThumbnailFilterGLThread.this.renderBufferHeight);
                            SSHThumbnailFilterGLThread.this.thumbnailFilterShader.drawFilters(SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getRenderFrameBuffer(1), SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getRenderTexture(1), SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getBitmapTexture(), null);
                            if (SSHThumbnailFilterGLThread.this.blur) {
                                SSHThumbnailFilterGLThread.this.thumbnailFilterShader.drawBlurPass(SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getRenderFrameBuffer(0), SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getRenderTexture(0), SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getRenderFrameBuffer(1), SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getRenderTexture(1));
                            }
                            GLES20.glViewport(0, 0, SSHThumbnailFilterGLThread.this.surfaceWidth, SSHThumbnailFilterGLThread.this.surfaceHeight);
                            GLES20.glBindFramebuffer(36160, 0);
                            GLES20.glUseProgram(SSHThumbnailFilterGLThread.this.simpleShaderProgram);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getRenderTexture(1));
                            GLES20.glUniform1i(SSHThumbnailFilterGLThread.this.simpleSourceImageHandle, 0);
                            GLES20.glEnableVertexAttribArray(SSHThumbnailFilterGLThread.this.simpleInputTexCoordHandle);
                            GLES20.glVertexAttribPointer(SSHThumbnailFilterGLThread.this.simpleInputTexCoordHandle, 2, 5126, false, 8, (Buffer) (SSHThumbnailFilterGLThread.this.textureBuffer != null ? SSHThumbnailFilterGLThread.this.textureBuffer : SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getTextureBuffer()));
                            GLES20.glEnableVertexAttribArray(SSHThumbnailFilterGLThread.this.simplePositionHandle);
                            GLES20.glVertexAttribPointer(SSHThumbnailFilterGLThread.this.simplePositionHandle, 2, 5126, false, 8, (Buffer) SSHThumbnailFilterGLThread.this.thumbnailFilterShader.getVertexBuffer());
                            GLES20.glDrawArrays(5, 0, 4);
                            SSHThumbnailFilterGLThread.this.egl10.eglSwapBuffers(SSHThumbnailFilterGLThread.this.eglDisplay, SSHThumbnailFilterGLThread.this.eglSurface);
                            if (SSHThumbnailFilterGLThread.this.listener != null) {
                                SSHThumbnailFilterGLThread.this.listener.onRenderDataAvailable(SSHThumbnailFilterGLThread.this.id);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Log.e("ThumbnailGLThread", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(SSHThumbnailFilterGLThread.this.egl10.eglGetError()));
                }
            }
        };
        this.id = i;
        this.currentBitmap = bitmap;
        this.surfaceTexture = surfaceTexture;
        this.blur = z;
        this.orientation = i2;
        this.thumbnailFilterShader = new SSHThumbnailFilterShader(context, false, 0, z);
        this.listener = thumbnailGLThreadListener;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.textureBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer.position(0);
        start();
    }

    private boolean initGL() throws IOException {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl10 = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.eglDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            Log.e("ThumbnailGLThread", "eglGetDisplay failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            finish();
            return false;
        }
        if (!this.egl10.eglInitialize(eGLDisplayEglGetDisplay, null)) {
            Log.e("ThumbnailGLThread", "eglInitialize failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            finish();
            return false;
        }
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.egl10.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, iArr)) {
            Log.e("ThumbnailGLThread", "eglChooseConfig failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
            finish();
            return false;
        }
        if (iArr[0] > 0) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            this.eglConfig = eGLConfig;
            EGLContext eGLContextEglCreateContext = this.egl10.eglCreateContext(this.eglDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.eglContext = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext == null) {
                Log.e("ThumbnailGLThread", "eglCreateContext failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                finish();
                return false;
            }
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                this.eglSurface = this.egl10.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surfaceTexture, null);
            } else {
                this.eglSurface = this.egl10.eglCreatePbufferSurface(this.eglDisplay, eGLConfigArr[0], new int[]{12375, this.surfaceWidth, 12374, this.surfaceHeight, 12344});
            }
            EGLSurface eGLSurface = this.eglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                Log.e("ThumbnailGLThread", "createWindowSurface failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                finish();
                return false;
            }
            if (!this.egl10.eglMakeCurrent(this.eglDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                Log.e("ThumbnailGLThread", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
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
            int width = this.currentBitmap.getWidth();
            int height = this.currentBitmap.getHeight();
            if (!this.thumbnailFilterShader.create()) {
                finish();
                return false;
            }
            if (width != 0 && height != 0) {
                this.thumbnailFilterShader.setRenderData(this.currentBitmap, this.orientation, width, height);
                this.renderDataSet = true;
                this.surfaceWidth = this.thumbnailFilterShader.getRenderBufferWidth();
                this.surfaceHeight = this.thumbnailFilterShader.getRenderBufferHeight();
                this.renderBufferWidth = this.thumbnailFilterShader.getRenderBufferWidth();
                this.renderBufferHeight = this.thumbnailFilterShader.getRenderBufferHeight();
            }
            return true;
        }
        Log.e("ThumbnailGLThread", "eglConfig not initialized");
        finish();
        return false;
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
            if (postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHThumbnailFilterGLThread$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getTexture$0(bitmapArr, countDownLatch);
                }
            })) {
                countDownLatch.await();
            }
        } catch (Exception e) {
            String message = e.getMessage();
            message.getClass();
            Log.e("ThumbnailGLThread", message);
        }
        return bitmapArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTexture$0(Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
        GLES20.glBindFramebuffer(36160, this.thumbnailFilterShader.getRenderFrameBuffer());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.thumbnailFilterShader.getRenderTexture(1), 0);
        GLES20.glClear(0);
        bitmapArr[0] = getRenderBufferBitmap();
        countDownLatch.countDown();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClear(0);
    }

    public void shutdown() {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHThumbnailFilterGLThread$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$shutdown$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shutdown$1() {
        finish();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    @Override // ir.appp.rghapp.DispatchQueue, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.initied = initGL();
        super.run();
    }

    public void requestRender(final boolean z, boolean z2) {
        postRunnable(new Runnable() { // from class: ir.appp.rghapp.components.SSHThumbnailFilterGLThread$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$requestRender$5(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestRender$5(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z || Math.abs(this.lastRenderCallTime - jCurrentTimeMillis) > 30) {
            this.lastRenderCallTime = jCurrentTimeMillis;
            this.drawRunnable.run();
        }
    }

    public SSHThumbnailFilterShader getThumbnailFilterShader() {
        return this.thumbnailFilterShader;
    }
}
