package ir.eitaa.messenger.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.video.MP4Builder;
import ir.eitaa.messenger.video.Mp4Movie;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.InstantCameraView;
import ir.eitaa.ui.Components.LayoutHelper;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.linphone.mediastream.Factory;
import org.webrtc.EglBase;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class CameraView extends FrameLayout implements TextureView.SurfaceTextureListener {
    private static final String FRAGMENT_SCREEN_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision lowp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n   gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final int MSG_AUDIOFRAME_AVAILABLE = 3;
    private static final int MSG_START_RECORDING = 0;
    private static final int MSG_STOP_RECORDING = 1;
    private static final int MSG_VIDEOFRAME_AVAILABLE = 2;
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private ImageView blurredStubView;
    private File cameraFile;
    private CameraSession cameraSession;
    private int[] cameraTexture;
    CameraGLThread cameraThread;
    private int clipBottom;
    private int clipTop;
    private int cx;
    private int cy;
    private CameraViewDelegate delegate;
    boolean firstFrameRendered;
    ValueAnimator flipAnimator;
    boolean flipHalfReached;
    private int focusAreaSize;
    private float focusProgress;
    private int fpsLimit;
    CameraInfo info;
    private boolean initialFrontface;
    private boolean initied;
    private float innerAlpha;
    private Paint innerPaint;
    private DecelerateInterpolator interpolator;
    private boolean isFrontface;
    private long lastDrawTime;
    private final Object layoutLock;
    private float[] mMVPMatrix;
    private float[] mSTMatrix;
    private Matrix matrix;
    private boolean mirror;
    private float[] moldSTMatrix;
    long nextFrameTimeNs;
    private int[] oldCameraTexture;
    Runnable onRecordingFinishRunnable;
    private boolean optimizeForBarcode;
    private float outerAlpha;
    private Paint outerPaint;
    private Size pictureSize;
    private int[] position;
    private Size previewSize;
    File recordFile;
    private volatile int surfaceHeight;
    private volatile int surfaceWidth;
    private float takePictureProgress;
    private FloatBuffer textureBuffer;
    private TextureView textureView;
    private Matrix txform;
    private boolean useMaxPreview;
    private FloatBuffer vertexBuffer;
    private VideoRecorder videoEncoder;

    public interface CameraViewDelegate {
        void onCameraCreated(Camera camera);

        void onCameraInit();
    }

    private int clamp(int x, int min, int max) {
        return x > max ? max : x < min ? min : x;
    }

    public void setRecordFile(File generateVideoPath) {
        this.recordFile = generateVideoPath;
    }

    public boolean startRecording(File path, Runnable onFinished) throws InterruptedException {
        this.cameraThread.startRecording(path);
        this.onRecordingFinishRunnable = onFinished;
        return true;
    }

    public void stopRecording() throws InterruptedException {
        this.cameraThread.stopRecording();
    }

    public void startSwitchingAnimation() {
        ValueAnimator valueAnimator = this.flipAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.blurredStubView.animate().setListener(null).cancel();
        if (this.firstFrameRendered) {
            Bitmap bitmap = this.textureView.getBitmap(100, 100);
            if (bitmap != null) {
                Utilities.blurBitmap(bitmap, 3, 1, bitmap.getWidth(), bitmap.getHeight(), bitmap.getRowBytes());
                this.blurredStubView.setBackground(new BitmapDrawable(bitmap));
            }
            this.blurredStubView.setAlpha(0.0f);
        } else {
            this.blurredStubView.setAlpha(1.0f);
        }
        this.blurredStubView.setVisibility(0);
        synchronized (this.layoutLock) {
            this.firstFrameRendered = false;
        }
        this.flipHalfReached = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.flipAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.messenger.camera.CameraView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                boolean z;
                float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (fFloatValue < 0.5f) {
                    z = false;
                } else {
                    fFloatValue -= 1.0f;
                    z = true;
                }
                float f = fFloatValue * 180.0f;
                CameraView.this.textureView.setRotationY(f);
                CameraView.this.blurredStubView.setRotationY(f);
                if (z) {
                    CameraView cameraView = CameraView.this;
                    if (cameraView.flipHalfReached) {
                        return;
                    }
                    cameraView.blurredStubView.setAlpha(1.0f);
                    CameraView.this.flipHalfReached = true;
                }
            }
        });
        this.flipAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.messenger.camera.CameraView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                CameraView cameraView = CameraView.this;
                cameraView.flipAnimator = null;
                cameraView.textureView.setTranslationY(0.0f);
                CameraView.this.textureView.setRotationX(0.0f);
                CameraView.this.textureView.setRotationY(0.0f);
                CameraView.this.textureView.setScaleX(1.0f);
                CameraView.this.textureView.setScaleY(1.0f);
                CameraView.this.blurredStubView.setRotationY(0.0f);
                CameraView cameraView2 = CameraView.this;
                if (!cameraView2.flipHalfReached) {
                    cameraView2.blurredStubView.setAlpha(1.0f);
                    CameraView.this.flipHalfReached = true;
                }
                CameraView.this.invalidate();
            }
        });
        this.flipAnimator.setDuration(400L);
        this.flipAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.flipAnimator.start();
        invalidate();
    }

    public CameraView(Context context, boolean frontface) {
        super(context, null);
        this.txform = new Matrix();
        this.matrix = new Matrix();
        this.focusProgress = 1.0f;
        this.outerPaint = new Paint(1);
        this.innerPaint = new Paint(1);
        this.interpolator = new DecelerateInterpolator();
        this.layoutLock = new Object();
        this.mMVPMatrix = new float[16];
        this.mSTMatrix = new float[16];
        this.moldSTMatrix = new float[16];
        this.fpsLimit = -1;
        this.takePictureProgress = 1.0f;
        this.position = new int[2];
        this.cameraTexture = new int[1];
        this.oldCameraTexture = new int[1];
        this.isFrontface = frontface;
        this.initialFrontface = frontface;
        TextureView textureView = new TextureView(context);
        this.textureView = textureView;
        textureView.setSurfaceTextureListener(this);
        addView(this.textureView, LayoutHelper.createFrame(-1, -1, 17));
        ImageView imageView = new ImageView(context);
        this.blurredStubView = imageView;
        addView(imageView, LayoutHelper.createFrame(-1, -1, 17));
        this.blurredStubView.setVisibility(8);
        this.focusAreaSize = AndroidUtilities.dp(96.0f);
        this.outerPaint.setColor(-1);
        this.outerPaint.setStyle(Paint.Style.STROKE);
        this.outerPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.innerPaint.setColor(ConnectionsManager.DEFAULT_DATACENTER_ID);
    }

    public void setOptimizeForBarcode(boolean value) {
        this.optimizeForBarcode = value;
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.setOptimizeForBarcode(true);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        CameraSession cameraSession;
        int width;
        int height;
        if (this.previewSize != null && (cameraSession = this.cameraSession) != null) {
            cameraSession.updateRotation();
            if (this.cameraSession.getWorldAngle() == 90 || this.cameraSession.getWorldAngle() == 270) {
                width = this.previewSize.getWidth();
                height = this.previewSize.getHeight();
            } else {
                width = this.previewSize.getHeight();
                height = this.previewSize.getWidth();
            }
            float f = width;
            float f2 = height;
            float fMax = Math.max(View.MeasureSpec.getSize(widthMeasureSpec) / f, View.MeasureSpec.getSize(heightMeasureSpec) / f2);
            ViewGroup.LayoutParams layoutParams = this.blurredStubView.getLayoutParams();
            int i = (int) (f * fMax);
            this.textureView.getLayoutParams().width = i;
            layoutParams.width = i;
            ViewGroup.LayoutParams layoutParams2 = this.blurredStubView.getLayoutParams();
            int i2 = (int) (fMax * f2);
            this.textureView.getLayoutParams().height = i2;
            layoutParams2.height = i2;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        checkPreviewMatrix();
    }

    public float getTextureHeight(float width, float height) {
        CameraSession cameraSession;
        int width2;
        int height2;
        if (this.previewSize == null || (cameraSession = this.cameraSession) == null) {
            return height;
        }
        if (cameraSession.getWorldAngle() == 90 || this.cameraSession.getWorldAngle() == 270) {
            width2 = this.previewSize.getWidth();
            height2 = this.previewSize.getHeight();
        } else {
            width2 = this.previewSize.getHeight();
            height2 = this.previewSize.getWidth();
        }
        float f = width / width2;
        float f2 = height2;
        return (int) (Math.max(f, height / f2) * f2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        checkPreviewMatrix();
    }

    public void setMirror(boolean value) {
        this.mirror = value;
    }

    public boolean isFrontface() {
        return this.isFrontface;
    }

    public TextureView getTextureView() {
        return this.textureView;
    }

    public void setUseMaxPreview(boolean value) {
        this.useMaxPreview = value;
    }

    public boolean hasFrontFaceCamera() {
        ArrayList<CameraInfo> cameras = CameraController.getInstance().getCameras();
        for (int i = 0; i < cameras.size(); i++) {
            if (cameras.get(i).frontCamera != 0) {
                return true;
            }
        }
        return false;
    }

    public void switchCamera() throws InterruptedException {
        if (this.cameraSession != null) {
            CameraController.getInstance().close(this.cameraSession, new CountDownLatch(1), null);
            this.cameraSession = null;
        }
        this.initied = false;
        this.isFrontface = !this.isFrontface;
        updateCameraInfoSize();
        this.cameraThread.reinitForNewCamera();
    }

    public Size getPreviewSize() {
        return this.previewSize;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        updateCameraInfoSize();
        this.surfaceHeight = height;
        this.surfaceWidth = width;
        if (this.cameraThread != null || surface == null) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("CameraView start create thread");
        }
        this.cameraThread = new CameraGLThread(surface);
        checkPreviewMatrix();
    }

    private void updateCameraInfoSize() {
        Size size;
        int i;
        ArrayList<CameraInfo> cameras = CameraController.getInstance().getCameras();
        if (cameras == null) {
            return;
        }
        for (int i2 = 0; i2 < cameras.size(); i2++) {
            CameraInfo cameraInfo = cameras.get(i2);
            boolean z = this.isFrontface;
            if ((z && cameraInfo.frontCamera != 0) || (!z && cameraInfo.frontCamera == 0)) {
                this.info = cameraInfo;
                break;
            }
        }
        if (this.info == null) {
            return;
        }
        Point point = AndroidUtilities.displaySize;
        float fMax = Math.max(point.x, point.y);
        Point point2 = AndroidUtilities.displaySize;
        float fMin = fMax / Math.min(point2.x, point2.y);
        int i3 = 1920;
        int i4 = 960;
        int i5 = 1280;
        if (this.initialFrontface) {
            size = new Size(16, 9);
            i3 = 480;
            i4 = 270;
            i = 270;
            i5 = 480;
        } else if (Math.abs(fMin - 1.3333334f) < 0.1f) {
            size = new Size(4, 3);
            if (SharedConfig.getDevicePerformanceClass() == 0) {
                i = 960;
                i3 = 1280;
            } else {
                i = 1440;
            }
        } else {
            size = new Size(16, 9);
            if (SharedConfig.getDevicePerformanceClass() == 0) {
                i = 960;
                i3 = 1280;
            } else {
                i = 1080;
            }
            i4 = 720;
        }
        this.previewSize = CameraController.chooseOptimalSize(this.info.getPreviewSizes(), i5, i4, size);
        this.pictureSize = CameraController.chooseOptimalSize(this.info.getPictureSizes(), i3, i, size);
        requestLayout();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int surfaceW, int surfaceH) {
        this.surfaceHeight = surfaceH;
        this.surfaceWidth = surfaceW;
        checkPreviewMatrix();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) throws InterruptedException {
        CameraGLThread cameraGLThread = this.cameraThread;
        if (cameraGLThread != null) {
            cameraGLThread.shutdown(0);
            this.cameraThread = null;
        }
        if (this.cameraSession != null) {
            CameraController.getInstance().close(this.cameraSession, null, null);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        CameraSession cameraSession;
        if (this.initied || (cameraSession = this.cameraSession) == null || !cameraSession.isInitied()) {
            return;
        }
        CameraViewDelegate cameraViewDelegate = this.delegate;
        if (cameraViewDelegate != null) {
            cameraViewDelegate.onCameraInit();
        }
        this.initied = true;
    }

    public void setClipTop(int value) {
        this.clipTop = value;
    }

    public void setClipBottom(int value) {
        this.clipBottom = value;
    }

    private void checkPreviewMatrix() {
        if (this.previewSize == null) {
            return;
        }
        int width = this.textureView.getWidth();
        int height = this.textureView.getHeight();
        Matrix matrix = new Matrix();
        if (this.cameraSession != null) {
            matrix.postRotate(r3.getDisplayOrientation());
        }
        float f = width;
        float f2 = height;
        matrix.postScale(f / 2000.0f, f2 / 2000.0f);
        matrix.postTranslate(f / 2.0f, f2 / 2.0f);
        matrix.invert(this.matrix);
        CameraGLThread cameraGLThread = this.cameraThread;
        if (cameraGLThread != null) {
            cameraGLThread.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$AvU6ipEPPVgH0aN5y6hUt26-kpY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkPreviewMatrix$0$CameraView();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPreviewMatrix$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPreviewMatrix$0$CameraView() {
        CameraGLThread cameraGLThread = this.cameraThread;
        if (cameraGLThread == null || cameraGLThread.currentSession == null) {
            return;
        }
        int worldAngle = cameraGLThread.currentSession.getWorldAngle();
        android.opengl.Matrix.setIdentityM(this.mMVPMatrix, 0);
        if (worldAngle != 0) {
            android.opengl.Matrix.rotateM(this.mMVPMatrix, 0, worldAngle, 0.0f, 0.0f, 1.0f);
        }
    }

    private Rect calculateTapArea(float x, float y, float coefficient) {
        int iIntValue = Float.valueOf(this.focusAreaSize * coefficient).intValue();
        int i = iIntValue / 2;
        RectF rectF = new RectF(clamp(((int) x) - i, 0, getWidth() - iIntValue), clamp(((int) y) - i, 0, getHeight() - iIntValue), r4 + iIntValue, r5 + iIntValue);
        this.matrix.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public void focusToPoint(int x, int y) {
        float f = x;
        float f2 = y;
        Rect rectCalculateTapArea = calculateTapArea(f, f2, 1.0f);
        Rect rectCalculateTapArea2 = calculateTapArea(f, f2, 1.5f);
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.focusToRect(rectCalculateTapArea, rectCalculateTapArea2);
        }
        this.focusProgress = 0.0f;
        this.innerAlpha = 1.0f;
        this.outerAlpha = 1.0f;
        this.cx = x;
        this.cy = y;
        this.lastDrawTime = System.currentTimeMillis();
        invalidate();
    }

    public void setZoom(float value) {
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.setZoom(value);
        }
    }

    public void setDelegate(CameraViewDelegate cameraViewDelegate) {
        this.delegate = cameraViewDelegate;
    }

    public boolean isInitied() {
        return this.initied;
    }

    public CameraSession getCameraSession() {
        return this.cameraSession;
    }

    public void destroy(boolean async, final Runnable beforeDestroyRunnable) {
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.destroy();
            CameraController.getInstance().close(this.cameraSession, !async ? new CountDownLatch(1) : null, beforeDestroyRunnable);
        }
    }

    @Override // android.view.View
    public Matrix getMatrix() {
        return this.txform;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        if (this.focusProgress != 1.0f || this.innerAlpha != 0.0f || this.outerAlpha != 0.0f) {
            int iDp = AndroidUtilities.dp(30.0f);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.lastDrawTime;
            if (j < 0 || j > 17) {
                j = 17;
            }
            this.lastDrawTime = jCurrentTimeMillis;
            this.outerPaint.setAlpha((int) (this.interpolator.getInterpolation(this.outerAlpha) * 255.0f));
            this.innerPaint.setAlpha((int) (this.interpolator.getInterpolation(this.innerAlpha) * 127.0f));
            float interpolation = this.interpolator.getInterpolation(this.focusProgress);
            float f = iDp;
            canvas.drawCircle(this.cx, this.cy, ((1.0f - interpolation) * f) + f, this.outerPaint);
            canvas.drawCircle(this.cx, this.cy, f * interpolation, this.innerPaint);
            float f2 = this.focusProgress;
            if (f2 < 1.0f) {
                float f3 = f2 + (j / 200.0f);
                this.focusProgress = f3;
                if (f3 > 1.0f) {
                    this.focusProgress = 1.0f;
                }
                invalidate();
            } else {
                float f4 = this.innerAlpha;
                if (f4 != 0.0f) {
                    float f5 = f4 - (j / 150.0f);
                    this.innerAlpha = f5;
                    if (f5 < 0.0f) {
                        this.innerAlpha = 0.0f;
                    }
                    invalidate();
                } else {
                    float f6 = this.outerAlpha;
                    if (f6 != 0.0f) {
                        float f7 = f6 - (j / 150.0f);
                        this.outerAlpha = f7;
                        if (f7 < 0.0f) {
                            this.outerAlpha = 0.0f;
                        }
                        invalidate();
                    }
                }
            }
        }
        return zDrawChild;
    }

    public void startTakePictureAnimation() {
        this.takePictureProgress = 0.0f;
        invalidate();
        runHaptic();
    }

    public void runHaptic() {
        long[] jArr = {0, 1};
        if (Build.VERSION.SDK_INT >= 26) {
            Vibrator vibrator = (Vibrator) getContext().getSystemService("vibrator");
            VibrationEffect vibrationEffectCreateWaveform = VibrationEffect.createWaveform(jArr, -1);
            vibrator.cancel();
            vibrator.vibrate(vibrationEffectCreateWaveform);
            return;
        }
        performHapticFeedback(3, 2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.flipAnimator != null) {
            canvas.drawColor(-16777216);
        }
        super.dispatchDraw(canvas);
        float f = this.takePictureProgress;
        if (f != 1.0f) {
            float f2 = f + 0.10666667f;
            this.takePictureProgress = f2;
            if (f2 > 1.0f) {
                this.takePictureProgress = 1.0f;
            } else {
                invalidate();
            }
            canvas.drawColor(ColorUtils.setAlphaComponent(-16777216, (int) ((1.0f - this.takePictureProgress) * 150.0f)));
        }
    }

    public class CameraGLThread extends DispatchQueue {
        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
        private static final int EGL_OPENGL_ES2_BIT = 4;
        private final int DO_REINIT_MESSAGE;
        private final int DO_RENDER_MESSAGE;
        private final int DO_SETSESSION_MESSAGE;
        private final int DO_SHUTDOWN_MESSAGE;
        private final int DO_START_RECORDING;
        private final int DO_STOP_RECORDING;
        final int[] array;
        private Integer cameraId;
        private SurfaceTexture cameraSurface;
        private CameraSession currentSession;
        private int drawProgram;
        private EGL10 egl10;
        private EGLConfig eglConfig;
        private EGLContext eglContext;
        private EGLDisplay eglDisplay;
        private EGLSurface eglSurface;
        private boolean initied;
        private boolean needRecord;
        private int positionHandle;
        private boolean recording;
        private SurfaceTexture surfaceTexture;
        private int textureHandle;
        private int textureMatrixHandle;
        private int vertexMatrixHandle;

        public CameraGLThread(SurfaceTexture surface) {
            super("CameraGLThread");
            this.DO_RENDER_MESSAGE = 0;
            this.DO_SHUTDOWN_MESSAGE = 1;
            this.DO_REINIT_MESSAGE = 2;
            this.DO_SETSESSION_MESSAGE = 3;
            this.DO_START_RECORDING = 4;
            this.DO_STOP_RECORDING = 5;
            this.cameraId = 0;
            this.array = new int[1];
            this.surfaceTexture = surface;
        }

        private boolean initGL() {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("CameraView start init gl");
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.egl10 = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.eglDisplay = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                this.eglDisplay = null;
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
            if (!this.egl10.eglChooseConfig(this.eglDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                }
                finish();
                return false;
            }
            if (iArr[0] > 0) {
                EGLConfig eGLConfig = eGLConfigArr[0];
                this.eglConfig = eGLConfig;
                EGLContext eGLContextEglCreateContext = this.egl10.eglCreateContext(this.eglDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                this.eglContext = eGLContextEglCreateContext;
                if (eGLContextEglCreateContext == null || eGLContextEglCreateContext == EGL10.EGL_NO_CONTEXT) {
                    this.eglContext = null;
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
                    this.eglContext.getGL();
                    android.opengl.Matrix.setIdentityM(CameraView.this.mSTMatrix, 0);
                    int iLoadShader = CameraView.this.loadShader(35633, CameraView.VERTEX_SHADER);
                    int iLoadShader2 = CameraView.this.loadShader(35632, CameraView.FRAGMENT_SCREEN_SHADER);
                    if (iLoadShader != 0 && iLoadShader2 != 0) {
                        int iGlCreateProgram = GLES20.glCreateProgram();
                        this.drawProgram = iGlCreateProgram;
                        GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                        GLES20.glAttachShader(this.drawProgram, iLoadShader2);
                        GLES20.glLinkProgram(this.drawProgram);
                        int[] iArr2 = new int[1];
                        GLES20.glGetProgramiv(this.drawProgram, 35714, iArr2, 0);
                        if (iArr2[0] == 0) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.e("failed link shader");
                            }
                            GLES20.glDeleteProgram(this.drawProgram);
                            this.drawProgram = 0;
                        } else {
                            this.positionHandle = GLES20.glGetAttribLocation(this.drawProgram, "aPosition");
                            this.textureHandle = GLES20.glGetAttribLocation(this.drawProgram, "aTextureCoord");
                            this.vertexMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uMVPMatrix");
                            this.textureMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uSTMatrix");
                        }
                        GLES20.glGenTextures(1, CameraView.this.cameraTexture, 0);
                        GLES20.glBindTexture(36197, CameraView.this.cameraTexture[0]);
                        GLES20.glTexParameteri(36197, 10241, 9729);
                        GLES20.glTexParameteri(36197, 10240, 9729);
                        GLES20.glTexParameteri(36197, 10242, 33071);
                        GLES20.glTexParameteri(36197, 10243, 33071);
                        android.opengl.Matrix.setIdentityM(CameraView.this.mMVPMatrix, 0);
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("gl initied");
                        }
                        CameraView.this.vertexBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        CameraView.this.vertexBuffer.put(new float[]{-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f}).position(0);
                        CameraView.this.textureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                        CameraView.this.textureBuffer.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
                        SurfaceTexture surfaceTexture2 = new SurfaceTexture(CameraView.this.cameraTexture[0]);
                        this.cameraSurface = surfaceTexture2;
                        surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$CameraGLThread$N6EiVeDZ3Dh47IOUhFt2CHCZu28
                            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                            public final void onFrameAvailable(SurfaceTexture surfaceTexture3) throws InterruptedException {
                                this.f$0.lambda$initGL$0$CameraView$CameraGLThread(surfaceTexture3);
                            }
                        });
                        CameraView.this.createCamera(this.cameraSurface);
                        return true;
                    }
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("failed creating shader");
                    }
                    finish();
                    return false;
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
        /* renamed from: lambda$initGL$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$initGL$0$CameraView$CameraGLThread(SurfaceTexture surfaceTexture) throws InterruptedException {
            requestRender();
        }

        public void reinitForNewCamera() throws InterruptedException {
            Handler handler = CameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(2, Integer.valueOf(CameraView.this.info.cameraId)), 0);
            }
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

        public void setCurrentSession(CameraSession session) throws InterruptedException {
            Handler handler = CameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(3, session), 0);
            }
        }

        private void onDraw(Integer cameraId, boolean updateTexImage) {
            boolean z;
            if (this.initied) {
                if (!this.eglContext.equals(this.egl10.eglGetCurrentContext()) || !this.eglSurface.equals(this.egl10.eglGetCurrentSurface(12377))) {
                    EGL10 egl10 = this.egl10;
                    EGLDisplay eGLDisplay = this.eglDisplay;
                    EGLSurface eGLSurface = this.eglSurface;
                    if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                            return;
                        }
                        return;
                    }
                }
                if (updateTexImage) {
                    try {
                        this.cameraSurface.updateTexImage();
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                }
                synchronized (CameraView.this.layoutLock) {
                    if (CameraView.this.fpsLimit <= 0) {
                        z = true;
                    } else {
                        long jNanoTime = System.nanoTime();
                        CameraView cameraView = CameraView.this;
                        long j = cameraView.nextFrameTimeNs;
                        if (jNanoTime < j) {
                            z = false;
                        } else {
                            cameraView.nextFrameTimeNs = j + (TimeUnit.SECONDS.toNanos(1L) / CameraView.this.fpsLimit);
                            CameraView cameraView2 = CameraView.this;
                            cameraView2.nextFrameTimeNs = Math.max(cameraView2.nextFrameTimeNs, jNanoTime);
                            z = true;
                        }
                    }
                }
                CameraSession cameraSession = this.currentSession;
                if (cameraSession == null || cameraSession.cameraInfo.cameraId != cameraId.intValue()) {
                    return;
                }
                if (this.recording && CameraView.this.videoEncoder != null) {
                    CameraView.this.videoEncoder.frameAvailable(this.cameraSurface, cameraId, System.nanoTime());
                }
                if (z) {
                    this.cameraSurface.getTransformMatrix(CameraView.this.mSTMatrix);
                    this.egl10.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, this.array);
                    int[] iArr = this.array;
                    int i = iArr[0];
                    this.egl10.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr);
                    GLES20.glViewport(0, 0, i, this.array[0]);
                    GLES20.glUseProgram(this.drawProgram);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(36197, CameraView.this.cameraTexture[0]);
                    GLES20.glVertexAttribPointer(this.positionHandle, 3, 5126, false, 12, (Buffer) CameraView.this.vertexBuffer);
                    GLES20.glEnableVertexAttribArray(this.positionHandle);
                    GLES20.glVertexAttribPointer(this.textureHandle, 2, 5126, false, 8, (Buffer) CameraView.this.textureBuffer);
                    GLES20.glEnableVertexAttribArray(this.textureHandle);
                    GLES20.glUniformMatrix4fv(this.textureMatrixHandle, 1, false, CameraView.this.mSTMatrix, 0);
                    GLES20.glUniformMatrix4fv(this.vertexMatrixHandle, 1, false, CameraView.this.mMVPMatrix, 0);
                    GLES20.glDrawArrays(5, 0, 4);
                    GLES20.glDisableVertexAttribArray(this.positionHandle);
                    GLES20.glDisableVertexAttribArray(this.textureHandle);
                    GLES20.glBindTexture(36197, 0);
                    GLES20.glUseProgram(0);
                    this.egl10.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                    synchronized (CameraView.this.layoutLock) {
                        CameraView cameraView3 = CameraView.this;
                        if (!cameraView3.firstFrameRendered) {
                            cameraView3.firstFrameRendered = true;
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$CameraGLThread$MV5oDa14v_mlXfPLk1PGdFWBo78
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onDraw$1$CameraView$CameraGLThread();
                                }
                            });
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onDraw$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onDraw$1$CameraView$CameraGLThread() {
            CameraView.this.onFirstFrameRendered();
        }

        @Override // ir.eitaa.messenger.DispatchQueue, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.initied = initGL();
            super.run();
        }

        @Override // ir.eitaa.messenger.DispatchQueue
        public void handleMessage(Message inputMessage) throws InterruptedException {
            int i = inputMessage.what;
            if (i == 0) {
                onDraw((Integer) inputMessage.obj, true);
                return;
            }
            if (i == 1) {
                finish();
                if (this.recording) {
                    CameraView.this.videoEncoder.stopRecording(inputMessage.arg1);
                }
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    looperMyLooper.quit();
                    return;
                }
                return;
            }
            if (i == 2) {
                EGL10 egl10 = this.egl10;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = this.eglSurface;
                if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("CameraView eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.egl10.eglGetError()));
                        return;
                    }
                    return;
                }
                SurfaceTexture surfaceTexture = this.cameraSurface;
                if (surfaceTexture != null) {
                    surfaceTexture.getTransformMatrix(CameraView.this.moldSTMatrix);
                    this.cameraSurface.setOnFrameAvailableListener(null);
                    this.cameraSurface.release();
                }
                this.cameraId = (Integer) inputMessage.obj;
                GLES20.glBindTexture(36197, CameraView.this.cameraTexture[0]);
                GLES20.glTexParameteri(36197, 10241, 9729);
                GLES20.glTexParameteri(36197, 10240, 9729);
                GLES20.glTexParameteri(36197, 10242, 33071);
                GLES20.glTexParameteri(36197, 10243, 33071);
                SurfaceTexture surfaceTexture2 = new SurfaceTexture(CameraView.this.cameraTexture[0]);
                this.cameraSurface = surfaceTexture2;
                surfaceTexture2.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$CameraGLThread$XU5RlOsQzvndfyyHIwBq4acEBis
                    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                    public final void onFrameAvailable(SurfaceTexture surfaceTexture3) throws InterruptedException {
                        this.f$0.lambda$handleMessage$2$CameraView$CameraGLThread(surfaceTexture3);
                    }
                });
                CameraView.this.createCamera(this.cameraSurface);
                return;
            }
            if (i == 3) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("CameraView set gl rednderer session");
                }
                CameraSession cameraSession = (CameraSession) inputMessage.obj;
                if (this.currentSession != cameraSession) {
                    this.currentSession = cameraSession;
                    this.cameraId = Integer.valueOf(cameraSession.cameraInfo.cameraId);
                }
                this.currentSession.updateRotation();
                int worldAngle = this.currentSession.getWorldAngle();
                android.opengl.Matrix.setIdentityM(CameraView.this.mMVPMatrix, 0);
                if (worldAngle != 0) {
                    android.opengl.Matrix.rotateM(CameraView.this.mMVPMatrix, 0, worldAngle, 0.0f, 0.0f, 1.0f);
                    return;
                }
                return;
            }
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                if (CameraView.this.videoEncoder != null) {
                    CameraView.this.videoEncoder.stopRecording(0);
                    CameraView.this.videoEncoder = null;
                }
                this.recording = false;
                return;
            }
            if (this.initied) {
                CameraView cameraView = CameraView.this;
                cameraView.recordFile = (File) inputMessage.obj;
                cameraView.videoEncoder = new VideoRecorder();
                this.recording = true;
                CameraView.this.videoEncoder.startRecording(CameraView.this.recordFile, EGL14.eglGetCurrentContext());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleMessage$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleMessage$2$CameraView$CameraGLThread(SurfaceTexture surfaceTexture) throws InterruptedException {
            requestRender();
        }

        public void shutdown(int send) throws InterruptedException {
            Handler handler = CameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(1, send, 0), 0);
            }
        }

        public void requestRender() throws InterruptedException {
            Handler handler = CameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(0, this.cameraId), 0);
            }
        }

        public boolean startRecording(File path) throws InterruptedException {
            Handler handler = CameraView.this.getHandler();
            if (handler == null) {
                return true;
            }
            sendMessage(handler.obtainMessage(4, path), 0);
            return false;
        }

        public void stopRecording() throws InterruptedException {
            Handler handler = CameraView.this.getHandler();
            if (handler != null) {
                sendMessage(handler.obtainMessage(5), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirstFrameRendered() {
        if (this.blurredStubView.getVisibility() == 0) {
            this.blurredStubView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.messenger.camera.CameraView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    CameraView.this.blurredStubView.setVisibility(8);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int loadShader(int type, String shaderCode) {
        int iGlCreateShader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(iGlCreateShader, shaderCode);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e(GLES20.glGetShaderInfoLog(iGlCreateShader));
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCamera(final SurfaceTexture surfaceTexture) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$3EaWBGZgEb7xa7a-F2KB6OX5fwc
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$createCamera$3$CameraView(surfaceTexture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createCamera$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createCamera$3$CameraView(SurfaceTexture surfaceTexture) throws InterruptedException {
        if (this.cameraThread == null) {
            return;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("CameraView create camera session");
        }
        if (this.previewSize == null) {
            updateCameraInfoSize();
        }
        Size size = this.previewSize;
        if (size == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.previewSize.getHeight());
        CameraSession cameraSession = new CameraSession(this.info, this.previewSize, this.pictureSize, Factory.DEVICE_HAS_CRAPPY_OPENSLES, false);
        this.cameraSession = cameraSession;
        this.cameraThread.setCurrentSession(cameraSession);
        requestLayout();
        CameraController.getInstance().open(this.cameraSession, surfaceTexture, new Runnable() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$ftM6BWB5ZCGntdWHdzCtF0I_lfU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createCamera$1$CameraView();
            }
        }, new Runnable() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$5CHOxk3ItMtvYC9F-AyP0PwcVQM
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$createCamera$2$CameraView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createCamera$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createCamera$1$CameraView() {
        if (this.cameraSession != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("CameraView camera initied");
            }
            this.cameraSession.setInitied();
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createCamera$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createCamera$2$CameraView() throws InterruptedException {
        this.cameraThread.setCurrentSession(this.cameraSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class VideoRecorder implements Runnable {
        private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
        private static final int FRAME_RATE = 30;
        private static final int IFRAME_INTERVAL = 1;
        private static final String VIDEO_MIME_TYPE = "video/avc";
        private MediaCodec.BufferInfo audioBufferInfo;
        private MediaCodec audioEncoder;
        private long audioFirst;
        private AudioRecord audioRecorder;
        private long audioStartTime;
        private boolean audioStopedByTime;
        private int audioTrackIndex;
        private boolean blendEnabled;
        private ArrayBlockingQueue<InstantCameraView.AudioBufferInfo> buffers;
        private ArrayList<InstantCameraView.AudioBufferInfo> buffersToWrite;
        private long currentTimestamp;
        private long desyncTime;
        private int drawProgram;
        private android.opengl.EGLConfig eglConfig;
        private android.opengl.EGLContext eglContext;
        private android.opengl.EGLDisplay eglDisplay;
        private android.opengl.EGLSurface eglSurface;
        private boolean firstEncode;
        private int frameCount;
        private DispatchQueue generateKeyframeThumbsQueue;
        private volatile EncoderHandler handler;
        private ArrayList<Bitmap> keyframeThumbs;
        private Integer lastCameraId;
        private long lastCommitedFrameTime;
        private long lastTimestamp;
        private MP4Builder mediaMuxer;
        private int positionHandle;
        private int prependHeaderSize;
        private boolean ready;
        private Runnable recorderRunnable;
        private volatile boolean running;
        private volatile int sendWhenDone;
        private android.opengl.EGLContext sharedEglContext;
        private boolean skippedFirst;
        private long skippedTime;
        private Surface surface;
        private final Object sync;
        private FloatBuffer textureBuffer;
        private int textureHandle;
        private int textureMatrixHandle;
        private int vertexMatrixHandle;
        private int videoBitrate;
        private MediaCodec.BufferInfo videoBufferInfo;
        private boolean videoConvertFirstWrite;
        private MediaCodec videoEncoder;
        private File videoFile;
        private long videoFirst;
        private int videoHeight;
        private long videoLast;
        private int videoTrackIndex;
        private int videoWidth;
        private int zeroTimeStamps;

        private VideoRecorder() {
            this.videoConvertFirstWrite = true;
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
            this.eglContext = EGL14.EGL_NO_CONTEXT;
            this.eglSurface = EGL14.EGL_NO_SURFACE;
            this.buffersToWrite = new ArrayList<>();
            this.videoTrackIndex = -5;
            this.audioTrackIndex = -5;
            this.audioStartTime = -1L;
            this.currentTimestamp = 0L;
            this.lastTimestamp = -1L;
            this.sync = new Object();
            this.videoFirst = -1L;
            this.audioFirst = -1L;
            this.lastCameraId = 0;
            this.buffers = new ArrayBlockingQueue<>(10);
            this.keyframeThumbs = new ArrayList<>();
            this.recorderRunnable = new Runnable() { // from class: ir.eitaa.messenger.camera.CameraView.VideoRecorder.1
                /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
                
                    if (r13.this$1.sendWhenDone == 0) goto L54;
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() throws java.lang.IllegalStateException, java.lang.InterruptedException {
                    /*
                        Method dump skipped, instructions count: 268
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.camera.CameraView.VideoRecorder.AnonymousClass1.run():void");
                }
            };
        }

        public void startRecording(File outputFile, android.opengl.EGLContext sharedContext) throws InterruptedException {
            String str = Build.DEVICE;
            Size size = CameraView.this.previewSize;
            int i = Math.min(size.mHeight, size.mWidth) >= 720 ? 3500000 : 1800000;
            this.videoFile = outputFile;
            if (CameraView.this.cameraSession.getWorldAngle() == 90 || CameraView.this.cameraSession.getWorldAngle() == 270) {
                this.videoWidth = size.getWidth();
                this.videoHeight = size.getHeight();
            } else {
                this.videoWidth = size.getHeight();
                this.videoHeight = size.getWidth();
            }
            this.videoBitrate = i;
            this.sharedEglContext = sharedContext;
            synchronized (this.sync) {
                if (this.running) {
                    return;
                }
                this.running = true;
                Thread thread = new Thread(this, "TextureMovieEncoder");
                thread.setPriority(10);
                thread.start();
                while (!this.ready) {
                    try {
                        this.sync.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                this.keyframeThumbs.clear();
                this.frameCount = 0;
                DispatchQueue dispatchQueue = this.generateKeyframeThumbsQueue;
                if (dispatchQueue != null) {
                    dispatchQueue.cleanupQueue();
                    this.generateKeyframeThumbsQueue.recycle();
                }
                this.generateKeyframeThumbsQueue = new DispatchQueue("keyframes_thumb_queque");
                this.handler.sendMessage(this.handler.obtainMessage(0));
            }
        }

        public void stopRecording(int send) {
            this.handler.sendMessage(this.handler.obtainMessage(1, send, 0));
        }

        public void frameAvailable(SurfaceTexture st, Integer cameraId, long timestampInternal) {
            synchronized (this.sync) {
                if (this.ready) {
                    long timestamp = st.getTimestamp();
                    if (timestamp == 0) {
                        int i = this.zeroTimeStamps + 1;
                        this.zeroTimeStamps = i;
                        if (i <= 1) {
                            return;
                        }
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("CameraView fix timestamp enabled");
                        }
                    } else {
                        this.zeroTimeStamps = 0;
                        timestampInternal = timestamp;
                    }
                    this.handler.sendMessage(this.handler.obtainMessage(2, (int) (timestampInternal >> 32), (int) timestampInternal, cameraId));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            synchronized (this.sync) {
                this.handler = new EncoderHandler(this);
                this.ready = true;
                this.sync.notify();
            }
            Looper.loop();
            synchronized (this.sync) {
                this.ready = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:105:0x00fb A[EDGE_INSN: B:105:0x00fb->B:41:0x00fb BREAK  A[LOOP:0: B:13:0x0028->B:39:0x00ef], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleAudioFrameAvailable(ir.eitaa.ui.Components.InstantCameraView.AudioBufferInfo r17) {
            /*
                Method dump skipped, instructions count: 525
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.camera.CameraView.VideoRecorder.handleAudioFrameAvailable(ir.eitaa.ui.Components.InstantCameraView$AudioBufferInfo):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleVideoFrameAvailable(long timestampNanos, Integer cameraId) {
            try {
                drainEncoder(false);
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (!this.lastCameraId.equals(cameraId)) {
                this.lastTimestamp = -1L;
                this.lastCameraId = cameraId;
            }
            long j = this.lastTimestamp;
            long jCurrentTimeMillis = 0;
            if (j == -1) {
                this.lastTimestamp = timestampNanos;
                if (this.currentTimestamp != 0) {
                    jCurrentTimeMillis = 1000000 * (System.currentTimeMillis() - this.lastCommitedFrameTime);
                }
            } else {
                jCurrentTimeMillis = timestampNanos - j;
                this.lastTimestamp = timestampNanos;
            }
            this.lastCommitedFrameTime = System.currentTimeMillis();
            if (!this.skippedFirst) {
                long j2 = this.skippedTime + jCurrentTimeMillis;
                this.skippedTime = j2;
                if (j2 < 200000000) {
                    return;
                } else {
                    this.skippedFirst = true;
                }
            }
            this.currentTimestamp += jCurrentTimeMillis;
            if (this.videoFirst == -1) {
                this.videoFirst = timestampNanos / 1000;
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("CameraView first video frame was at " + this.videoFirst);
                }
            }
            this.videoLast = timestampNanos;
            GLES20.glUseProgram(this.drawProgram);
            GLES20.glVertexAttribPointer(this.positionHandle, 3, 5126, false, 12, (Buffer) CameraView.this.vertexBuffer);
            GLES20.glEnableVertexAttribArray(this.positionHandle);
            GLES20.glVertexAttribPointer(this.textureHandle, 2, 5126, false, 8, (Buffer) this.textureBuffer);
            GLES20.glEnableVertexAttribArray(this.textureHandle);
            GLES20.glUniformMatrix4fv(this.vertexMatrixHandle, 1, false, CameraView.this.mMVPMatrix, 0);
            GLES20.glActiveTexture(33984);
            if (CameraView.this.oldCameraTexture[0] != 0) {
                if (!this.blendEnabled) {
                    GLES20.glEnable(3042);
                    this.blendEnabled = true;
                }
                GLES20.glUniformMatrix4fv(this.textureMatrixHandle, 1, false, CameraView.this.moldSTMatrix, 0);
                GLES20.glBindTexture(36197, CameraView.this.oldCameraTexture[0]);
                GLES20.glDrawArrays(5, 0, 4);
            }
            GLES20.glUniformMatrix4fv(this.textureMatrixHandle, 1, false, CameraView.this.mSTMatrix, 0);
            GLES20.glBindTexture(36197, CameraView.this.cameraTexture[0]);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.positionHandle);
            GLES20.glDisableVertexAttribArray(this.textureHandle);
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
            EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, this.currentTimestamp);
            EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleStopRecording(final int send) {
            if (this.running) {
                this.sendWhenDone = send;
                this.running = false;
                return;
            }
            try {
                drainEncoder(true);
            } catch (Exception e) {
                FileLog.e(e);
            }
            MediaCodec mediaCodec = this.videoEncoder;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    this.videoEncoder.release();
                    this.videoEncoder = null;
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            MediaCodec mediaCodec2 = this.audioEncoder;
            if (mediaCodec2 != null) {
                try {
                    mediaCodec2.stop();
                    this.audioEncoder.release();
                    this.audioEncoder = null;
                } catch (Exception e3) {
                    FileLog.e(e3);
                }
            }
            MP4Builder mP4Builder = this.mediaMuxer;
            if (mP4Builder != null) {
                try {
                    mP4Builder.finishMovie();
                } catch (Exception e4) {
                    FileLog.e(e4);
                }
            }
            EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
            this.eglSurface = EGL14.EGL_NO_SURFACE;
            Surface surface = this.surface;
            if (surface != null) {
                surface.release();
                this.surface = null;
            }
            android.opengl.EGLDisplay eGLDisplay = this.eglDisplay;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.eglDisplay);
            }
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
            this.eglContext = EGL14.EGL_NO_CONTEXT;
            this.eglConfig = null;
            this.handler.exit();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraView$VideoRecorder$1DiqI6I0tFbo608RBGjqf9scF2I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleStopRecording$0$CameraView$VideoRecorder();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleStopRecording$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleStopRecording$0$CameraView$VideoRecorder() {
            CameraView.this.cameraSession.stopVideoRecording();
            CameraView.this.onRecordingFinishRunnable.run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void prepareEncoder() throws IllegalStateException, IOException {
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                if (minBufferSize <= 0) {
                    minBufferSize = 3584;
                }
                int i = 49152 < minBufferSize ? ((minBufferSize / Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) + 1) * Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS * 2 : 49152;
                for (int i2 = 0; i2 < 3; i2++) {
                    this.buffers.add(new InstantCameraView.AudioBufferInfo());
                }
                AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, i);
                this.audioRecorder = audioRecord;
                audioRecord.startRecording();
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("CameraView initied audio record with channels " + this.audioRecorder.getChannelCount() + " sample rate = " + this.audioRecorder.getSampleRate() + " bufferSize = " + i);
                }
                Thread thread = new Thread(this.recorderRunnable);
                thread.setPriority(10);
                thread.start();
                this.audioBufferInfo = new MediaCodec.BufferInfo();
                this.videoBufferInfo = new MediaCodec.BufferInfo();
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", "audio/mp4a-latm");
                mediaFormat.setInteger("sample-rate", 44100);
                mediaFormat.setInteger("channel-count", 1);
                mediaFormat.setInteger("bitrate", 32000);
                mediaFormat.setInteger("max-input-size", 20480);
                MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
                this.audioEncoder = mediaCodecCreateEncoderByType;
                mediaCodecCreateEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                this.audioEncoder.start();
                this.videoEncoder = MediaCodec.createEncoderByType("video/avc");
                this.firstEncode = true;
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", this.videoWidth, this.videoHeight);
                mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
                mediaFormatCreateVideoFormat.setInteger("bitrate", this.videoBitrate);
                mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
                mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
                this.videoEncoder.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.surface = this.videoEncoder.createInputSurface();
                this.videoEncoder.start();
                Mp4Movie mp4Movie = new Mp4Movie();
                mp4Movie.setCacheFile(this.videoFile);
                mp4Movie.setRotation(0);
                mp4Movie.setSize(this.videoWidth, this.videoHeight);
                this.mediaMuxer = new MP4Builder().createMovie(mp4Movie, false);
                if (this.eglDisplay != EGL14.EGL_NO_DISPLAY) {
                    throw new RuntimeException("EGL already set up");
                }
                android.opengl.EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                this.eglDisplay = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    throw new RuntimeException("unable to get EGL14 display");
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                    this.eglDisplay = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                if (this.eglContext == EGL14.EGL_NO_CONTEXT) {
                    android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
                    if (!EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                        throw new RuntimeException("Unable to find a suitable EGLConfig");
                    }
                    this.eglContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfigArr[0], this.sharedEglContext, new int[]{12440, 2, 12344}, 0);
                    this.eglConfig = eGLConfigArr[0];
                }
                EGL14.eglQueryContext(this.eglDisplay, this.eglContext, 12440, new int[1], 0);
                if (this.eglSurface != EGL14.EGL_NO_SURFACE) {
                    throw new IllegalStateException("surface already created");
                }
                android.opengl.EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, this.surface, new int[]{12344}, 0);
                this.eglSurface = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface == null) {
                    throw new RuntimeException("surface was null");
                }
                if (!EGL14.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext)) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("eglMakeCurrent failed " + GLUtils.getEGLErrorString(EGL14.eglGetError()));
                    }
                    throw new RuntimeException("eglMakeCurrent failed");
                }
                GLES20.glBlendFunc(770, 771);
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.textureBuffer = floatBufferAsFloatBuffer;
                floatBufferAsFloatBuffer.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
                int iLoadShader = CameraView.this.loadShader(35633, CameraView.VERTEX_SHADER);
                int iLoadShader2 = CameraView.this.loadShader(35632, CameraView.FRAGMENT_SCREEN_SHADER);
                if (iLoadShader == 0 || iLoadShader2 == 0) {
                    return;
                }
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.drawProgram = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                GLES20.glAttachShader(this.drawProgram, iLoadShader2);
                GLES20.glLinkProgram(this.drawProgram);
                int[] iArr2 = new int[1];
                GLES20.glGetProgramiv(this.drawProgram, 35714, iArr2, 0);
                if (iArr2[0] == 0) {
                    GLES20.glDeleteProgram(this.drawProgram);
                    this.drawProgram = 0;
                } else {
                    this.positionHandle = GLES20.glGetAttribLocation(this.drawProgram, "aPosition");
                    this.textureHandle = GLES20.glGetAttribLocation(this.drawProgram, "aTextureCoord");
                    this.vertexMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uMVPMatrix");
                    this.textureMatrixHandle = GLES20.glGetUniformLocation(this.drawProgram, "uSTMatrix");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public Surface getInputSurface() {
            return this.surface;
        }

        public void drainEncoder(boolean endOfStream) throws Exception {
            ByteBuffer outputBuffer;
            ByteBuffer outputBuffer2;
            ByteBuffer byteBufferAllocate;
            ByteBuffer byteBufferAllocate2;
            if (endOfStream) {
                this.videoEncoder.signalEndOfInputStream();
            }
            ByteBuffer[] outputBuffers = Build.VERSION.SDK_INT < 21 ? this.videoEncoder.getOutputBuffers() : null;
            while (true) {
                int iDequeueOutputBuffer = this.videoEncoder.dequeueOutputBuffer(this.videoBufferInfo, 10000L);
                byte b = 1;
                if (iDequeueOutputBuffer == -1) {
                    if (!endOfStream) {
                        break;
                    }
                } else if (iDequeueOutputBuffer == -3) {
                    if (Build.VERSION.SDK_INT < 21) {
                        outputBuffers = this.videoEncoder.getOutputBuffers();
                    }
                } else if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.videoEncoder.getOutputFormat();
                    if (this.videoTrackIndex == -5) {
                        this.videoTrackIndex = this.mediaMuxer.addTrack(outputFormat, false);
                        if (outputFormat.containsKey("prepend-sps-pps-to-idr-frames") && outputFormat.getInteger("prepend-sps-pps-to-idr-frames") == 1) {
                            this.prependHeaderSize = outputFormat.getByteBuffer("csd-0").limit() + outputFormat.getByteBuffer("csd-1").limit();
                        }
                    }
                } else if (iDequeueOutputBuffer < 0) {
                    continue;
                } else {
                    if (Build.VERSION.SDK_INT < 21) {
                        outputBuffer2 = outputBuffers[iDequeueOutputBuffer];
                    } else {
                        outputBuffer2 = this.videoEncoder.getOutputBuffer(iDequeueOutputBuffer);
                    }
                    if (outputBuffer2 == null) {
                        throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.videoBufferInfo;
                    int i = bufferInfo.size;
                    if (i > 1) {
                        int i2 = bufferInfo.flags;
                        if ((i2 & 2) == 0) {
                            int i3 = this.prependHeaderSize;
                            if (i3 != 0 && (i2 & 1) != 0) {
                                bufferInfo.offset += i3;
                                bufferInfo.size = i - i3;
                            }
                            if (this.firstEncode && (i2 & 1) != 0) {
                                if (bufferInfo.size > 100) {
                                    outputBuffer2.position(bufferInfo.offset);
                                    byte[] bArr = new byte[100];
                                    outputBuffer2.get(bArr);
                                    int i4 = 0;
                                    int i5 = 0;
                                    while (true) {
                                        if (i4 < 96) {
                                            if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 0 && bArr[i4 + 3] == 1 && (i5 = i5 + 1) > 1) {
                                                MediaCodec.BufferInfo bufferInfo2 = this.videoBufferInfo;
                                                bufferInfo2.offset += i4;
                                                bufferInfo2.size -= i4;
                                                break;
                                            }
                                            i4++;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                this.firstEncode = false;
                            }
                            this.mediaMuxer.writeSampleData(this.videoTrackIndex, outputBuffer2, this.videoBufferInfo, true);
                        } else if (this.videoTrackIndex == -5) {
                            byte[] bArr2 = new byte[i];
                            outputBuffer2.limit(bufferInfo.offset + i);
                            outputBuffer2.position(this.videoBufferInfo.offset);
                            outputBuffer2.get(bArr2);
                            int i6 = this.videoBufferInfo.size - 1;
                            while (i6 >= 0 && i6 > 3) {
                                if (bArr2[i6] == b && bArr2[i6 - 1] == 0 && bArr2[i6 - 2] == 0) {
                                    int i7 = i6 - 3;
                                    if (bArr2[i7] == 0) {
                                        byteBufferAllocate = ByteBuffer.allocate(i7);
                                        byteBufferAllocate2 = ByteBuffer.allocate(this.videoBufferInfo.size - i7);
                                        byteBufferAllocate.put(bArr2, 0, i7).position(0);
                                        byteBufferAllocate2.put(bArr2, i7, this.videoBufferInfo.size - i7).position(0);
                                        break;
                                    }
                                }
                                i6--;
                                b = 1;
                            }
                            byteBufferAllocate = null;
                            byteBufferAllocate2 = null;
                            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", this.videoWidth, this.videoHeight);
                            if (byteBufferAllocate != null && byteBufferAllocate2 != null) {
                                mediaFormatCreateVideoFormat.setByteBuffer("csd-0", byteBufferAllocate);
                                mediaFormatCreateVideoFormat.setByteBuffer("csd-1", byteBufferAllocate2);
                            }
                            this.videoTrackIndex = this.mediaMuxer.addTrack(mediaFormatCreateVideoFormat, false);
                        }
                    }
                    this.videoEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    if ((this.videoBufferInfo.flags & 4) != 0) {
                        break;
                    }
                }
            }
            if (Build.VERSION.SDK_INT < 21) {
                outputBuffers = this.audioEncoder.getOutputBuffers();
            }
            while (true) {
                int iDequeueOutputBuffer2 = this.audioEncoder.dequeueOutputBuffer(this.audioBufferInfo, 0L);
                if (iDequeueOutputBuffer2 == -1) {
                    if (!endOfStream) {
                        return;
                    }
                    if (!this.running && this.sendWhenDone == 0) {
                        return;
                    }
                } else if (iDequeueOutputBuffer2 == -3) {
                    if (Build.VERSION.SDK_INT < 21) {
                        outputBuffers = this.audioEncoder.getOutputBuffers();
                    }
                } else if (iDequeueOutputBuffer2 == -2) {
                    MediaFormat outputFormat2 = this.audioEncoder.getOutputFormat();
                    if (this.audioTrackIndex == -5) {
                        this.audioTrackIndex = this.mediaMuxer.addTrack(outputFormat2, true);
                    }
                } else if (iDequeueOutputBuffer2 < 0) {
                    continue;
                } else {
                    if (Build.VERSION.SDK_INT < 21) {
                        outputBuffer = outputBuffers[iDequeueOutputBuffer2];
                    } else {
                        outputBuffer = this.audioEncoder.getOutputBuffer(iDequeueOutputBuffer2);
                    }
                    if (outputBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer2 + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo3 = this.audioBufferInfo;
                    if ((bufferInfo3.flags & 2) != 0) {
                        bufferInfo3.size = 0;
                    }
                    if (bufferInfo3.size != 0) {
                        this.mediaMuxer.writeSampleData(this.audioTrackIndex, outputBuffer, bufferInfo3, false);
                    }
                    this.audioEncoder.releaseOutputBuffer(iDequeueOutputBuffer2, false);
                    if ((this.audioBufferInfo.flags & 4) != 0) {
                        return;
                    }
                }
            }
        }

        protected void finalize() throws Throwable {
            try {
                android.opengl.EGLDisplay eGLDisplay = this.eglDisplay;
                if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                    android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                    EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(this.eglDisplay);
                    this.eglDisplay = EGL14.EGL_NO_DISPLAY;
                    this.eglContext = EGL14.EGL_NO_CONTEXT;
                    this.eglConfig = null;
                }
            } finally {
                super.finalize();
            }
        }
    }

    private static class EncoderHandler extends Handler {
        private WeakReference<VideoRecorder> mWeakEncoder;

        public EncoderHandler(VideoRecorder encoder) {
            this.mWeakEncoder = new WeakReference<>(encoder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message inputMessage) {
            int i = inputMessage.what;
            VideoRecorder videoRecorder = this.mWeakEncoder.get();
            if (videoRecorder == null) {
                return;
            }
            if (i == 0) {
                try {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("start encoder");
                    }
                    videoRecorder.prepareEncoder();
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    videoRecorder.handleStopRecording(0);
                    Looper.myLooper().quit();
                    return;
                }
            }
            if (i == 1) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("stop encoder");
                }
                videoRecorder.handleStopRecording(inputMessage.arg1);
            } else if (i == 2) {
                videoRecorder.handleVideoFrameAvailable((inputMessage.arg1 << 32) | (inputMessage.arg2 & 4294967295L), (Integer) inputMessage.obj);
            } else {
                if (i != 3) {
                    return;
                }
                videoRecorder.handleAudioFrameAvailable((InstantCameraView.AudioBufferInfo) inputMessage.obj);
            }
        }

        public void exit() {
            Looper.myLooper().quit();
        }
    }

    public void setFpsLimit(int fpsLimit) {
        this.fpsLimit = fpsLimit;
    }
}
