package ir.eitaa.ui.Components.Paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.TextureView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.ui.Components.Paint.Painting;
import ir.eitaa.ui.Components.Size;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes3.dex */
public class RenderView extends TextureView {
    private Bitmap bitmap;
    private Brush brush;
    private int color;
    private RenderViewDelegate delegate;
    private boolean firstDrawSent;
    private Input input;
    private CanvasInternal internal;
    private Painting painting;
    private DispatchQueue queue;
    private boolean shuttingDown;
    private boolean transformedBitmap;
    private UndoStore undoStore;
    private float weight;

    public interface RenderViewDelegate {
        void onBeganDrawing();

        void onFinishedDrawing(boolean moved);

        void onFirstDraw();

        boolean shouldDraw();
    }

    public RenderView(Context context, Painting paint, Bitmap b) {
        super(context);
        setOpaque(false);
        this.bitmap = b;
        this.painting = paint;
        paint.setRenderView(this);
        setSurfaceTextureListener(new AnonymousClass1());
        this.input = new Input(this);
        this.painting.setDelegate(new Painting.PaintingDelegate() { // from class: ir.eitaa.ui.Components.Paint.RenderView.2
            @Override // ir.eitaa.ui.Components.Paint.Painting.PaintingDelegate
            public void contentChanged() throws InterruptedException {
                if (RenderView.this.internal != null) {
                    RenderView.this.internal.scheduleRedraw();
                }
            }

            @Override // ir.eitaa.ui.Components.Paint.Painting.PaintingDelegate
            public UndoStore requestUndoStore() {
                return RenderView.this.undoStore;
            }

            @Override // ir.eitaa.ui.Components.Paint.Painting.PaintingDelegate
            public DispatchQueue requestDispatchQueue() {
                return RenderView.this.queue;
            }
        });
    }

    /* renamed from: ir.eitaa.ui.Components.Paint.RenderView$1, reason: invalid class name */
    class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }

        AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            if (surface == null || RenderView.this.internal != null) {
                return;
            }
            RenderView.this.internal = RenderView.this.new CanvasInternal(surface);
            RenderView.this.internal.setBufferSize(width, height);
            RenderView.this.updateTransform();
            RenderView.this.internal.requestRender();
            if (RenderView.this.painting.isPaused()) {
                RenderView.this.painting.onResume();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            if (RenderView.this.internal == null) {
                return;
            }
            RenderView.this.internal.setBufferSize(width, height);
            RenderView.this.updateTransform();
            RenderView.this.internal.requestRender();
            RenderView.this.internal.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$1$l_l3itwTdrPSidjSlJV4tGSUECs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSurfaceTextureSizeChanged$0$RenderView$1();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSurfaceTextureSizeChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSurfaceTextureSizeChanged$0$RenderView$1() {
            if (RenderView.this.internal != null) {
                RenderView.this.internal.requestRender();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            if (RenderView.this.internal != null && !RenderView.this.shuttingDown) {
                RenderView.this.painting.onPause(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$1$eHPtWjuXA8Wh9Da9v3FTekoNLpw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onSurfaceTextureDestroyed$1$RenderView$1();
                    }
                });
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSurfaceTextureDestroyed$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSurfaceTextureDestroyed$1$RenderView$1() {
            RenderView.this.internal.shutdown();
            RenderView.this.internal = null;
        }
    }

    public void redraw() {
        CanvasInternal canvasInternal = this.internal;
        if (canvasInternal == null) {
            return;
        }
        canvasInternal.requestRender();
    }

    public boolean onTouch(MotionEvent event) {
        if (event.getPointerCount() > 1) {
            return false;
        }
        CanvasInternal canvasInternal = this.internal;
        if (canvasInternal != null && canvasInternal.initialized && this.internal.ready) {
            this.input.process(event, getScaleX());
        }
        return true;
    }

    public void setUndoStore(UndoStore store) {
        this.undoStore = store;
    }

    public void setQueue(DispatchQueue dispatchQueue) {
        this.queue = dispatchQueue;
    }

    public void setDelegate(RenderViewDelegate renderViewDelegate) {
        this.delegate = renderViewDelegate;
    }

    public Painting getPainting() {
        return this.painting;
    }

    private float brushWeightForSize(float size) {
        float f = this.painting.getSize().width;
        return (0.00390625f * f) + (f * 0.043945312f * size);
    }

    public int getCurrentColor() {
        return this.color;
    }

    public void setColor(int value) {
        this.color = value;
    }

    public float getCurrentWeight() {
        return this.weight;
    }

    public void setBrushSize(float size) {
        this.weight = brushWeightForSize(size);
    }

    public Brush getCurrentBrush() {
        return this.brush;
    }

    public void setBrush(Brush value) {
        Painting painting = this.painting;
        this.brush = value;
        painting.setBrush(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTransform() {
        Matrix matrix = new Matrix();
        float width = this.painting != null ? getWidth() / this.painting.getSize().width : 1.0f;
        float f = width > 0.0f ? width : 1.0f;
        Size size = getPainting().getSize();
        matrix.preTranslate(getWidth() / 2.0f, getHeight() / 2.0f);
        matrix.preScale(f, -f);
        matrix.preTranslate((-size.width) / 2.0f, (-size.height) / 2.0f);
        this.input.setMatrix(matrix);
        this.painting.setRenderProjection(GLMatrix.MultiplyMat4f(GLMatrix.LoadOrtho(0.0f, this.internal.bufferWidth, 0.0f, this.internal.bufferHeight, -1.0f, 1.0f), GLMatrix.LoadGraphicsMatrix(matrix)));
    }

    public boolean shouldDraw() {
        RenderViewDelegate renderViewDelegate = this.delegate;
        return renderViewDelegate == null || renderViewDelegate.shouldDraw();
    }

    public void onBeganDrawing() {
        RenderViewDelegate renderViewDelegate = this.delegate;
        if (renderViewDelegate != null) {
            renderViewDelegate.onBeganDrawing();
        }
    }

    public void onFinishedDrawing(boolean moved) {
        RenderViewDelegate renderViewDelegate = this.delegate;
        if (renderViewDelegate != null) {
            renderViewDelegate.onFinishedDrawing(moved);
        }
    }

    public void shutdown() {
        this.shuttingDown = true;
        if (this.internal != null) {
            performInContext(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$kdIJYQhUMp_VXcDvJjka2D_fXPM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$shutdown$0$RenderView();
                }
            });
        }
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$shutdown$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$shutdown$0$RenderView() {
        this.painting.cleanResources(this.transformedBitmap);
        this.internal.shutdown();
        this.internal = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class CanvasInternal extends DispatchQueue {
        private int bufferHeight;
        private int bufferWidth;
        private Runnable drawRunnable;
        private EGL10 egl10;
        private EGLContext eglContext;
        private EGLDisplay eglDisplay;
        private EGLSurface eglSurface;
        private boolean initialized;
        private boolean ready;
        private Runnable scheduledRunnable;
        private SurfaceTexture surfaceTexture;

        public CanvasInternal(SurfaceTexture surface) {
            super("CanvasInternal");
            this.drawRunnable = new AnonymousClass1();
            this.surfaceTexture = surface;
        }

        @Override // ir.eitaa.messenger.DispatchQueue, java.lang.Thread, java.lang.Runnable
        public void run() {
            if (RenderView.this.bitmap == null || RenderView.this.bitmap.isRecycled()) {
                return;
            }
            this.initialized = initGL();
            super.run();
        }

        private boolean initGL() {
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
                if (surfaceTexture instanceof SurfaceTexture) {
                    EGLSurface eGLSurfaceEglCreateWindowSurface = this.egl10.eglCreateWindowSurface(this.eglDisplay, eGLConfig, surfaceTexture, null);
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
                    GLES20.glEnable(3042);
                    GLES20.glDisable(3024);
                    GLES20.glDisable(2960);
                    GLES20.glDisable(2929);
                    RenderView.this.painting.setupShaders();
                    checkBitmap();
                    RenderView.this.painting.setBitmap(RenderView.this.bitmap);
                    Utils.HasGLError();
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

        private void checkBitmap() {
            Size size = RenderView.this.painting.getSize();
            if (RenderView.this.bitmap.getWidth() == size.width && RenderView.this.bitmap.getHeight() == size.height) {
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) size.width, (int) size.height, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(RenderView.this.bitmap, (Rect) null, new RectF(0.0f, 0.0f, size.width, size.height), (Paint) null);
            RenderView.this.bitmap = bitmapCreateBitmap;
            RenderView.this.transformedBitmap = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean setCurrentContext() {
            if (!this.initialized) {
                return false;
            }
            if (this.eglContext.equals(this.egl10.eglGetCurrentContext()) && this.eglSurface.equals(this.egl10.eglGetCurrentSurface(12377))) {
                return true;
            }
            EGL10 egl10 = this.egl10;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = this.eglSurface;
            return egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext);
        }

        /* renamed from: ir.eitaa.ui.Components.Paint.RenderView$CanvasInternal$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                if (!CanvasInternal.this.initialized || RenderView.this.shuttingDown) {
                    return;
                }
                CanvasInternal.this.setCurrentContext();
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glViewport(0, 0, CanvasInternal.this.bufferWidth, CanvasInternal.this.bufferHeight);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
                RenderView.this.painting.render();
                GLES20.glBlendFunc(1, 771);
                CanvasInternal.this.egl10.eglSwapBuffers(CanvasInternal.this.eglDisplay, CanvasInternal.this.eglSurface);
                if (!RenderView.this.firstDrawSent) {
                    RenderView.this.firstDrawSent = true;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$CanvasInternal$1$duwwThHv7lZxyGcxHRbM9dn9kfs
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$run$0$RenderView$CanvasInternal$1();
                        }
                    });
                }
                if (CanvasInternal.this.ready) {
                    return;
                }
                RenderView.this.queue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$CanvasInternal$1$C54BSG6JDJU2QOrq0LEncYx1jIk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$1$RenderView$CanvasInternal$1();
                    }
                }, 200L);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$RenderView$CanvasInternal$1() {
                RenderView.this.delegate.onFirstDraw();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$1$RenderView$CanvasInternal$1() {
                CanvasInternal.this.ready = true;
            }
        }

        public void setBufferSize(int width, int height) {
            this.bufferWidth = width;
            this.bufferHeight = height;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$requestRender$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$requestRender$0$RenderView$CanvasInternal() {
            this.drawRunnable.run();
        }

        public void requestRender() {
            postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$CanvasInternal$pVW0OQbGKdsiOAQKQ43Gaol5DpM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$requestRender$0$RenderView$CanvasInternal();
                }
            });
        }

        public void scheduleRedraw() throws InterruptedException {
            Runnable runnable = this.scheduledRunnable;
            if (runnable != null) {
                cancelRunnable(runnable);
                this.scheduledRunnable = null;
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$CanvasInternal$erSHDhnKWoTD2_WsdGMn-o6yh6k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scheduleRedraw$1$RenderView$CanvasInternal();
                }
            };
            this.scheduledRunnable = runnable2;
            postRunnable(runnable2, 1L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$scheduleRedraw$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$scheduleRedraw$1$RenderView$CanvasInternal() {
            this.scheduledRunnable = null;
            this.drawRunnable.run();
        }

        public void finish() {
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

        public void shutdown() {
            postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$CanvasInternal$SGkZVT0hRa4daPQhzi7LIrxVVK4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$shutdown$2$RenderView$CanvasInternal();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$shutdown$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$shutdown$2$RenderView$CanvasInternal() {
            finish();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null) {
                looperMyLooper.quit();
            }
        }

        public Bitmap getTexture() throws InterruptedException {
            if (!this.initialized) {
                return null;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Bitmap[] bitmapArr = new Bitmap[1];
            try {
                postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$CanvasInternal$sLeQtYnbXg1pdWTBD5ilti63nfA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$getTexture$3$RenderView$CanvasInternal(bitmapArr, countDownLatch);
                    }
                });
                countDownLatch.await();
            } catch (Exception e) {
                FileLog.e(e);
            }
            return bitmapArr[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$getTexture$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$getTexture$3$RenderView$CanvasInternal(Bitmap[] bitmapArr, CountDownLatch countDownLatch) {
            Painting.PaintingData paintingData = RenderView.this.painting.getPaintingData(new RectF(0.0f, 0.0f, RenderView.this.painting.getSize().width, RenderView.this.painting.getSize().height), false);
            if (paintingData != null) {
                bitmapArr[0] = paintingData.bitmap;
            }
            countDownLatch.countDown();
        }
    }

    public Bitmap getResultBitmap() {
        CanvasInternal canvasInternal = this.internal;
        if (canvasInternal != null) {
            return canvasInternal.getTexture();
        }
        return null;
    }

    public void performInContext(final Runnable action) {
        CanvasInternal canvasInternal = this.internal;
        if (canvasInternal == null) {
            return;
        }
        canvasInternal.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.Paint.-$$Lambda$RenderView$P07RR1e_MZ43HDc2HnE-DrBMXXs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$performInContext$1$RenderView(action);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$performInContext$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$performInContext$1$RenderView(Runnable runnable) {
        CanvasInternal canvasInternal = this.internal;
        if (canvasInternal == null || !canvasInternal.initialized) {
            return;
        }
        this.internal.setCurrentContext();
        runnable.run();
    }
}
