package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.camera.CameraController;
import org.rbmain.messenger.camera.CameraInfo;
import org.rbmain.messenger.camera.CameraSession;
import org.rbmain.messenger.camera.Size;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
public class AddPostCameraView extends FrameLayout implements TextureView.SurfaceTextureListener {
    private CameraSession cameraSession;
    private int clipBottom;
    private int clipTop;
    private int cx;
    private int cy;
    private CameraViewDelegate delegate;
    private float focusProgress;
    private final boolean initialFrontface;
    private boolean initied;
    private float innerAlpha;
    private final Paint innerPaint;
    private final DecelerateInterpolator interpolator;
    private boolean isFrontface;
    private long lastDrawTime;
    private final Matrix matrix;
    private boolean mirror;
    private float outerAlpha;
    private final Paint outerPaint;
    private Size previewSize;
    private Size selectedSize;
    private final TextureView textureView;
    private final Matrix txform;
    private boolean useMaxPreview;

    public interface CameraViewDelegate {
        void onCameraCreated(Camera camera);

        void onCameraInit();
    }

    public void setOptimizeForBarcode(boolean z) {
    }

    public void setZoom(float f) {
    }

    public AddPostCameraView(Context context, boolean z) {
        super(context, null);
        this.txform = new Matrix();
        this.matrix = new Matrix();
        this.focusProgress = 1.0f;
        Paint paint = new Paint(1);
        this.outerPaint = paint;
        Paint paint2 = new Paint(1);
        this.innerPaint = paint2;
        this.interpolator = new DecelerateInterpolator();
        this.isFrontface = z;
        this.initialFrontface = z;
        TextureView textureView = new TextureView(context);
        this.textureView = textureView;
        textureView.setSurfaceTextureListener(this);
        addView(textureView);
        AndroidUtilities.dp(96.0f);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        paint2.setColor(ConnectionsManager.DEFAULT_DATACENTER_ID);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkPreviewMatrix();
    }

    public void setMirror(boolean z) {
        this.mirror = z;
    }

    public boolean isFrontface() {
        return this.isFrontface;
    }

    public TextureView getTextureView() {
        return this.textureView;
    }

    public void setUseMaxPreview(boolean z) {
        this.useMaxPreview = z;
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

    public void switchCamera() {
        if (this.cameraSession != null) {
            CameraController.getInstance().close(this.cameraSession, null, null);
            this.cameraSession = null;
        }
        this.initied = false;
        this.isFrontface = !this.isFrontface;
        initCamera();
    }

    public void initCamera() {
        CameraInfo cameraInfo;
        Size size;
        Size size2;
        int iMin;
        ArrayList<CameraInfo> cameras = CameraController.getInstance().getCameras();
        if (cameras == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= cameras.size()) {
                cameraInfo = null;
                break;
            }
            cameraInfo = cameras.get(i);
            boolean z = this.isFrontface;
            if ((z && cameraInfo.frontCamera != 0) || (!z && cameraInfo.frontCamera == 0)) {
                break;
            } else {
                i++;
            }
        }
        if (cameraInfo == null) {
            return;
        }
        Point point = AndroidUtilities.displaySize;
        float fMax = Math.max(point.x, point.y);
        Point point2 = AndroidUtilities.displaySize;
        float fMin = fMax / Math.min(point2.x, point2.y);
        new Size(1, 1);
        this.selectedSize = null;
        int i2 = 1080;
        int i3 = 1920;
        if (this.initialFrontface) {
            size = new Size(16, 9);
            i3 = 480;
            i2 = 270;
        } else if (Math.abs(fMin - 1.3333334f) < 0.1f) {
            size = new Size(4, 3);
        } else {
            size = new Size(16, 9);
        }
        if (this.textureView.getWidth() > 0 && this.textureView.getHeight() > 0) {
            if (size.getWidth() != size.getHeight()) {
                if (this.useMaxPreview) {
                    Point point3 = AndroidUtilities.displaySize;
                    iMin = Math.max(point3.x, point3.y);
                } else {
                    Point point4 = AndroidUtilities.displaySize;
                    iMin = Math.min(point4.x, point4.y);
                }
                this.previewSize = CameraController.chooseOptimalSize(cameraInfo.getPreviewSizes(), iMin, (size.getHeight() * iMin) / size.getWidth(), size);
            } else {
                int i4 = AndroidUtilities.displaySize.x;
                this.previewSize = CameraController.chooseOptimalSize(cameraInfo.getPreviewSizes(), i4, i4, size);
            }
        }
        Size sizeChooseOptimalSize = CameraController.chooseOptimalSize(cameraInfo.getPictureSizes(), i3, i2, size);
        if (i2 != i3 && sizeChooseOptimalSize.getWidth() >= 1280 && sizeChooseOptimalSize.getHeight() >= 1280) {
            if (Math.abs(fMin - 1.3333334f) < 0.1f) {
                size2 = new Size(3, 4);
            } else {
                size2 = new Size(9, 16);
            }
            Size sizeChooseOptimalSize2 = CameraController.chooseOptimalSize(cameraInfo.getPictureSizes(), i2, i3, size2);
            if (sizeChooseOptimalSize2.getWidth() < 1280 || sizeChooseOptimalSize2.getHeight() < 1280) {
                sizeChooseOptimalSize = sizeChooseOptimalSize2;
            }
        }
        this.selectedSize = sizeChooseOptimalSize;
        SurfaceTexture surfaceTexture = this.textureView.getSurfaceTexture();
        Size size3 = this.previewSize;
        if (size3 == null || surfaceTexture == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size3.getWidth(), this.previewSize.getHeight());
        this.cameraSession = new CameraSession(cameraInfo, this.previewSize, sizeChooseOptimalSize, 256);
        CameraController.getInstance().open(this.cameraSession, surfaceTexture, new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCameraView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initCamera$0();
            }
        }, new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCameraView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initCamera$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCamera$0() {
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.setInitied();
        }
        checkPreviewMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCamera$1() {
        CameraViewDelegate cameraViewDelegate = this.delegate;
        if (cameraViewDelegate != null) {
            cameraViewDelegate.onCameraCreated(this.cameraSession.cameraInfo.camera);
        }
    }

    public Size getPreviewSize() {
        return this.previewSize;
    }

    public Size getSelectedSize() {
        return this.selectedSize;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        initCamera();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        checkPreviewMatrix();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.cameraSession == null) {
            return false;
        }
        CameraController.getInstance().close(this.cameraSession, null, null);
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
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

    public void setClipTop(int i) {
        this.clipTop = i;
    }

    public void setClipBottom(int i) {
        this.clipBottom = i;
    }

    private void checkPreviewMatrix() {
        if (this.previewSize == null) {
            return;
        }
        adjustAspectRatio(this.previewSize.getWidth(), this.previewSize.getHeight(), ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation());
    }

    private void adjustAspectRatio(int i, int i2, int i3) {
        float fMax;
        this.txform.reset();
        int width = getWidth();
        int height = getHeight();
        float f = width / 2;
        float f2 = height / 2;
        if (i3 == 0 || i3 == 2) {
            fMax = Math.max(((this.clipTop + height) + this.clipBottom) / i, width / i2);
        } else {
            fMax = Math.max(((this.clipTop + height) + this.clipBottom) / i2, width / i);
        }
        float f3 = width;
        float f4 = height;
        this.txform.postScale((i2 * fMax) / f3, (i * fMax) / f4, f, f2);
        if (1 == i3 || 3 == i3) {
            this.txform.postRotate((i3 - 2) * 90, f, f2);
        } else if (2 == i3) {
            this.txform.postRotate(180.0f, f, f2);
        }
        if (this.mirror) {
            this.txform.postScale(-1.0f, 1.0f, f, f2);
        }
        if (this.clipTop != 0) {
            this.txform.postTranslate(0.0f, (-r9) / 2);
        } else {
            if (this.clipBottom != 0) {
                this.txform.postTranslate(0.0f, r9 / 2);
            }
        }
        this.textureView.setTransform(this.txform);
        Matrix matrix = new Matrix();
        if (this.cameraSession != null) {
            matrix.postRotate(r10.getDisplayOrientation());
        }
        matrix.postScale(f3 / 2000.0f, f4 / 2000.0f);
        matrix.postTranslate(f3 / 2.0f, f4 / 2.0f);
        matrix.invert(this.matrix);
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

    public void destroy(boolean z, Runnable runnable) {
        CameraSession cameraSession = this.cameraSession;
        if (cameraSession != null) {
            cameraSession.destroy();
            CameraController.getInstance().close(this.cameraSession, !z ? new CountDownLatch(1) : null, runnable);
        }
    }

    @Override // android.view.View
    public Matrix getMatrix() {
        return this.txform;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.focusProgress != 1.0f || this.innerAlpha != 0.0f || this.outerAlpha != 0.0f) {
            int iDp = AndroidUtilities.dp(30.0f);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis - this.lastDrawTime;
            if (j2 < 0 || j2 > 17) {
                j2 = 17;
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
                float f3 = f2 + (j2 / 200.0f);
                this.focusProgress = f3;
                if (f3 > 1.0f) {
                    this.focusProgress = 1.0f;
                }
                invalidate();
            } else {
                float f4 = this.innerAlpha;
                if (f4 != 0.0f) {
                    float f5 = f4 - (j2 / 150.0f);
                    this.innerAlpha = f5;
                    if (f5 < 0.0f) {
                        this.innerAlpha = 0.0f;
                    }
                    invalidate();
                } else {
                    float f6 = this.outerAlpha;
                    if (f6 != 0.0f) {
                        float f7 = f6 - (j2 / 150.0f);
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
}
