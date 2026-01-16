package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import ir.appp.rghapp.components.SSHScaleGestureDetector;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.Rect;
import org.rbmain.ui.Components.Size;

/* loaded from: classes3.dex */
public class SSHPhotoFilterBlurControl extends FrameLayout {
    private BlurViewActiveControl activeControl;
    private final Size actualAreaSize;
    private float alpha;
    public float angle;
    private final Paint arcPaint;
    public Point centerPoint;
    public Size contentSize;
    private int currentAlpha;
    private PhotoFilterLinearBlurControlDelegate delegate;
    private Runnable fadeRunnable;
    public float falloff;
    public boolean isRotateEnabled;
    public boolean isScaleEnabled;
    public boolean isTranslateEnabled;
    private final SSHScaleGestureDetector mScaleGestureDetector;
    public float maximumScale;
    public float minimumScale;
    private final Paint paint;
    private float pointerScale;
    private float pointerStartX;
    private float pointerStartY;
    public float size;
    private Point startCenterPoint;
    private float startPointerDistance;
    private int type;

    private enum BlurViewActiveControl {
        BlurViewActiveControlNone,
        BlurViewActiveControlCenter,
        BlurViewActiveControlInnerRadius,
        BlurViewActiveControlOuterRadius,
        BlurViewActiveControlWholeArea,
        BlurViewActiveControlRotation
    }

    public interface PhotoFilterLinearBlurControlDelegate {
        void valueChanged(Point point, float f, float f2, float f3, boolean z, float f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float adjustAngle(float f) {
        return f > 180.0f ? f - 360.0f : f < -180.0f ? f + 360.0f : f;
    }

    private float degreesToRadians(float f) {
        return (f * 3.1415927f) / 180.0f;
    }

    public SSHPhotoFilterBlurControl(Context context) {
        super(context);
        this.centerPoint = new Point(0.5f, 0.5f);
        this.falloff = 0.15f;
        this.size = 0.25f;
        this.angle = 0.0f;
        this.isRotateEnabled = true;
        this.isTranslateEnabled = true;
        this.isScaleEnabled = true;
        this.minimumScale = 0.5f;
        this.maximumScale = 10.0f;
        this.actualAreaSize = new Size();
        this.currentAlpha = 255;
        this.alpha = 0.5f;
        this.startCenterPoint = new Point();
        Paint paint = new Paint(1);
        this.paint = paint;
        this.pointerScale = 1.0f;
        Paint paint2 = new Paint(1);
        this.arcPaint = paint2;
        this.contentSize = new Size();
        setWillNotDraw(false);
        paint.setColor(-65536);
        paint2.setColor(-65536);
        paint2.setStrokeWidth(AndroidUtilities.dp(2.0f));
        paint2.setStyle(Paint.Style.STROKE);
        this.mScaleGestureDetector = new SSHScaleGestureDetector(new ScaleGestureListener(this, null));
    }

    public void setType(int i, boolean z) {
        this.type = i;
        this.alpha = 0.5f;
        this.currentAlpha = 255;
        if (z) {
            PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate = this.delegate;
            if (photoFilterLinearBlurControlDelegate != null) {
                photoFilterLinearBlurControlDelegate.valueChanged(this.centerPoint, this.falloff, this.size, degreesToRadians(this.angle) + 1.5707964f, false, this.alpha);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.components.SSHPhotoFilterBlurControl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setType$0();
                }
            }, 400L);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setType$0() {
        setSelected(false, false);
    }

    public void setDelegate(PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate) {
        this.delegate = photoFilterLinearBlurControlDelegate;
    }

    private float getDistance(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        float x2 = x - motionEvent.getX(1);
        float y2 = y - motionEvent.getY(1);
        return (float) Math.sqrt((x2 * x2) + (y2 * y2));
    }

    private void setSelected(final boolean z, boolean z2) {
        Runnable runnable = new Runnable() { // from class: ir.appp.rghapp.components.SSHPhotoFilterBlurControl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setSelected$1(z);
            }
        };
        this.fadeRunnable = runnable;
        AndroidUtilities.runOnUIThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSelected$1(boolean z) {
        if (!z) {
            int i = this.currentAlpha;
            if (i >= 0 && i < 255) {
                this.alpha = i / 510.0f;
                this.currentAlpha = i + 9;
                AndroidUtilities.runOnUIThread(this.fadeRunnable, 10L);
                return;
            } else {
                if (i < 510) {
                    this.alpha = (510 - i) / 510.0f;
                    this.currentAlpha = i + 9;
                    PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate = this.delegate;
                    if (photoFilterLinearBlurControlDelegate != null) {
                        photoFilterLinearBlurControlDelegate.valueChanged(this.centerPoint, this.falloff, this.size, 1.5707964f + degreesToRadians(this.angle), false, this.alpha);
                    }
                    AndroidUtilities.runOnUIThread(this.fadeRunnable, 15L);
                    return;
                }
                return;
            }
        }
        this.alpha = 0.5f;
        this.currentAlpha = 255;
    }

    public void setActualAreaSize(float f, float f2) {
        Size size = this.actualAreaSize;
        size.width = f;
        size.height = f2;
    }

    public void setContentSize(float f, float f2) {
        Size size = this.contentSize;
        size.width = f;
        size.height = f2;
    }

    private Point getActualCenterPoint() {
        float width = getWidth();
        float f = this.actualAreaSize.width;
        float f2 = ((width - f) / 2.0f) + (this.centerPoint.x * f);
        float height = getHeight();
        float f3 = this.actualAreaSize.height;
        return new Point(f2, ((height - f3) / 2.0f) + (this.centerPoint.y * f3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePan(int i, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Point actualCenterPoint = getActualCenterPoint();
        float f = actualCenterPoint.x;
        if (i == 1) {
            this.pointerStartX = motionEvent.getX();
            this.pointerStartY = motionEvent.getY();
            this.activeControl = BlurViewActiveControl.BlurViewActiveControlCenter;
            this.startCenterPoint = actualCenterPoint;
            setSelected(true, true);
            return;
        }
        if (i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate = this.delegate;
                if (photoFilterLinearBlurControlDelegate != null) {
                    photoFilterLinearBlurControlDelegate.valueChanged(this.centerPoint, this.falloff, this.size, degreesToRadians(this.angle) + 1.5707964f, true, this.alpha);
                }
                this.activeControl = BlurViewActiveControl.BlurViewActiveControlNone;
                setSelected(false, true);
                return;
            }
            return;
        }
        int i2 = this.type;
        if (i2 == 0) {
            if (AnonymousClass1.$SwitchMap$ir$appp$rghapp$components$SSHPhotoFilterBlurControl$BlurViewActiveControl[this.activeControl.ordinal()] == 1) {
                float f2 = x - this.pointerStartX;
                float f3 = y - this.pointerStartY;
                float width = (getWidth() - this.actualAreaSize.width) / 2.0f;
                float height = getHeight();
                Size size = this.actualAreaSize;
                float f4 = size.height;
                Rect rect = new Rect(width, (height - f4) / 2.0f, size.width, f4);
                float f5 = rect.x;
                float fMax = Math.max(f5, Math.min(rect.width + f5, this.startCenterPoint.x + f2));
                float f6 = rect.y;
                Point point = new Point(fMax, Math.max(f6, Math.min(rect.height + f6, this.startCenterPoint.y + f3)));
                float f7 = point.x - rect.x;
                Size size2 = this.actualAreaSize;
                float f8 = size2.width;
                this.centerPoint = new Point(f7 / f8, ((point.y - rect.y) + ((f8 - size2.height) / 2.0f)) / f8);
            }
            invalidate();
            PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate2 = this.delegate;
            if (photoFilterLinearBlurControlDelegate2 != null) {
                photoFilterLinearBlurControlDelegate2.valueChanged(this.centerPoint, this.falloff, this.size, degreesToRadians(this.angle) + 1.5707964f, false, this.alpha);
            }
        } else if (i2 == 1 && AnonymousClass1.$SwitchMap$ir$appp$rghapp$components$SSHPhotoFilterBlurControl$BlurViewActiveControl[this.activeControl.ordinal()] == 1) {
            float f9 = x - this.pointerStartX;
            float f10 = y - this.pointerStartY;
            float width2 = (getWidth() - this.actualAreaSize.width) / 2.0f;
            float height2 = getHeight();
            Size size3 = this.actualAreaSize;
            float f11 = size3.height;
            Rect rect2 = new Rect(width2, (height2 - f11) / 2.0f, size3.width, f11);
            float f12 = rect2.x;
            float fMax2 = Math.max(f12, Math.min(rect2.width + f12, this.startCenterPoint.x + f9));
            float f13 = rect2.y;
            Point point2 = new Point(fMax2, Math.max(f13, Math.min(rect2.height + f13, this.startCenterPoint.y + f10)));
            float f14 = point2.x - rect2.x;
            Size size4 = this.actualAreaSize;
            this.centerPoint = new Point(f14 / size4.width, (point2.y - rect2.y) / size4.height);
        }
        invalidate();
        PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate3 = this.delegate;
        if (photoFilterLinearBlurControlDelegate3 != null) {
            photoFilterLinearBlurControlDelegate3.valueChanged(this.centerPoint, this.falloff, this.size, degreesToRadians(this.angle) + 1.5707964f, false, this.alpha);
        }
    }

    /* renamed from: ir.appp.rghapp.components.SSHPhotoFilterBlurControl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ir$appp$rghapp$components$SSHPhotoFilterBlurControl$BlurViewActiveControl;

        static {
            int[] iArr = new int[BlurViewActiveControl.values().length];
            $SwitchMap$ir$appp$rghapp$components$SSHPhotoFilterBlurControl$BlurViewActiveControl = iArr;
            try {
                iArr[BlurViewActiveControl.BlurViewActiveControlCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePinch(int i, MotionEvent motionEvent) {
        if (i == 1) {
            this.startPointerDistance = getDistance(motionEvent);
            this.pointerScale = 1.0f;
            this.activeControl = BlurViewActiveControl.BlurViewActiveControlWholeArea;
            setSelected(true, true);
        } else if (i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                this.activeControl = BlurViewActiveControl.BlurViewActiveControlNone;
                setSelected(false, true);
                return;
            }
            return;
        }
        float distance = getDistance(motionEvent);
        float f = this.pointerScale + (((distance - this.startPointerDistance) / AndroidUtilities.density) * 0.01f);
        this.pointerScale = f;
        float fMin = Math.min(0.38f, Math.max(0.06f, this.falloff * f));
        this.falloff = fMin;
        this.size = Math.min(0.64f, Math.max(fMin + 0.04f, this.size * this.pointerScale));
        Log.d("SANA", "handlePinch: " + this.falloff + "  size:" + this.size);
        this.pointerScale = 1.0f;
        this.startPointerDistance = distance;
        invalidate();
        PhotoFilterLinearBlurControlDelegate photoFilterLinearBlurControlDelegate = this.delegate;
        if (photoFilterLinearBlurControlDelegate != null) {
            photoFilterLinearBlurControlDelegate.valueChanged(this.centerPoint, this.falloff, this.size, degreesToRadians(this.angle) + 1.5707964f, false, this.alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustTranslation(float f, float f2) {
        float width = (getWidth() - this.actualAreaSize.width) / 2.0f;
        float height = getHeight();
        Size size = this.actualAreaSize;
        float f3 = size.height;
        Rect rect = new Rect(width, (height - f3) / 2.0f, size.width, f3);
        float f4 = rect.x;
        float fMax = Math.max(f4, Math.min(rect.width + f4, this.startCenterPoint.x + f));
        float f5 = rect.y;
        Point point = new Point(fMax, Math.max(f5, Math.min(rect.height + f5, this.startCenterPoint.y + f2)));
        float f6 = point.x - rect.x;
        Size size2 = this.actualAreaSize;
        this.centerPoint = new Point(f6 / size2.width, (point.y - rect.y) / size2.height);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            ir.appp.rghapp.components.SSHScaleGestureDetector r0 = r4.mScaleGestureDetector
            r0.onTouchEvent(r5)
            boolean r0 = r4.isTranslateEnabled
            r1 = 1
            if (r0 != 0) goto Lb
            return r1
        Lb:
            int r0 = r5.getAction()
            int r2 = r5.getActionMasked()
            r0 = r0 & r2
            if (r0 == 0) goto L2f
            r2 = 3
            if (r0 == r1) goto L2b
            r3 = 2
            if (r0 == r3) goto L1f
            if (r0 == r2) goto L2b
            goto L32
        L1f:
            ir.appp.rghapp.components.SSHScaleGestureDetector r0 = r4.mScaleGestureDetector
            boolean r0 = r0.isInProgress()
            if (r0 != 0) goto L32
            r4.handlePan(r3, r5)
            goto L32
        L2b:
            r4.handlePan(r2, r5)
            goto L32
        L2f:
            r4.handlePan(r1, r5)
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.components.SSHPhotoFilterBlurControl.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private class ScaleGestureListener extends SSHScaleGestureDetector.SimpleOnScaleGestureListener {
        TransformInfo info;
        private float mPivotX;
        private float mPivotY;
        private final SSHVector2D mPrevSpanVector;

        private ScaleGestureListener() {
            this.mPrevSpanVector = new SSHVector2D();
            this.info = new TransformInfo(SSHPhotoFilterBlurControl.this, null);
        }

        /* synthetic */ ScaleGestureListener(SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // ir.appp.rghapp.components.SSHScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(SSHScaleGestureDetector sSHScaleGestureDetector) {
            this.mPivotX = sSHScaleGestureDetector.getFocusX();
            this.mPivotY = sSHScaleGestureDetector.getFocusY();
            this.mPrevSpanVector.set(sSHScaleGestureDetector.getCurrentSpanVector());
            if (SSHPhotoFilterBlurControl.this.type == 0) {
                this.info.startAngle = SSHPhotoFilterBlurControl.this.angle;
            }
            SSHPhotoFilterBlurControl.this.handlePan(2, sSHScaleGestureDetector.mCurrEvent);
            SSHPhotoFilterBlurControl.this.handlePinch(1, sSHScaleGestureDetector.mCurrEvent);
            return true;
        }

        @Override // ir.appp.rghapp.components.SSHScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(SSHScaleGestureDetector sSHScaleGestureDetector) {
            this.info.deltaScale = SSHPhotoFilterBlurControl.this.isScaleEnabled ? sSHScaleGestureDetector.getScaleFactor() : 1.0f;
            if (SSHPhotoFilterBlurControl.this.type == 0) {
                TransformInfo transformInfo = this.info;
                transformInfo.deltaAngle = SSHPhotoFilterBlurControl.this.isRotateEnabled ? transformInfo.startAngle + SSHVector2D.getAngle(this.mPrevSpanVector, sSHScaleGestureDetector.getCurrentSpanVector()) : 0.0f;
            }
            this.info.deltaX = SSHPhotoFilterBlurControl.this.isTranslateEnabled ? sSHScaleGestureDetector.getFocusX() - this.mPivotX : 0.0f;
            this.info.deltaY = SSHPhotoFilterBlurControl.this.isTranslateEnabled ? sSHScaleGestureDetector.getFocusY() - this.mPivotY : 0.0f;
            TransformInfo transformInfo2 = this.info;
            transformInfo2.pivotX = this.mPivotX;
            transformInfo2.pivotY = this.mPivotY;
            SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl = SSHPhotoFilterBlurControl.this;
            transformInfo2.minimumScale = sSHPhotoFilterBlurControl.minimumScale;
            transformInfo2.maximumScale = sSHPhotoFilterBlurControl.maximumScale;
            sSHPhotoFilterBlurControl.handlePan(2, sSHScaleGestureDetector.mCurrEvent);
            SSHPhotoFilterBlurControl.this.handlePinch(2, sSHScaleGestureDetector.mCurrEvent);
            if (SSHPhotoFilterBlurControl.this.type == 0) {
                SSHPhotoFilterBlurControl.this.angle = SSHPhotoFilterBlurControl.adjustAngle(this.info.deltaAngle);
            }
            SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl2 = SSHPhotoFilterBlurControl.this;
            TransformInfo transformInfo3 = this.info;
            sSHPhotoFilterBlurControl2.adjustTranslation(transformInfo3.deltaX, transformInfo3.deltaY);
            return false;
        }

        @Override // ir.appp.rghapp.components.SSHScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(SSHScaleGestureDetector sSHScaleGestureDetector) {
            SSHPhotoFilterBlurControl.this.handlePan(3, sSHScaleGestureDetector.mCurrEvent);
            SSHPhotoFilterBlurControl.this.handlePinch(3, sSHScaleGestureDetector.mCurrEvent);
        }
    }

    private class TransformInfo {
        public float deltaAngle;
        public float deltaScale;
        public float deltaX;
        public float deltaY;
        public float maximumScale;
        public float minimumScale;
        public float pivotX;
        public float pivotY;
        public float startAngle;

        private TransformInfo(SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl) {
        }

        /* synthetic */ TransformInfo(SSHPhotoFilterBlurControl sSHPhotoFilterBlurControl, AnonymousClass1 anonymousClass1) {
            this(sSHPhotoFilterBlurControl);
        }

        public String toString() {
            return "TransformInfo{deltaX=" + this.deltaX + ", deltaY=" + this.deltaY + ", deltaScale=" + this.deltaScale + ", deltaAngle=" + this.deltaAngle + ", pivotX=" + this.pivotX + ", pivotY=" + this.pivotY + ", minimumScale=" + this.minimumScale + ", maximumScale=" + this.maximumScale + '}';
        }
    }
}
