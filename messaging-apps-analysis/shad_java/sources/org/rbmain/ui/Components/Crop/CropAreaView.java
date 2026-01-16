package org.rbmain.ui.Components.Crop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.BubbleActivity;

/* loaded from: classes5.dex */
public class CropAreaView extends View {
    private Control activeControl;
    private RectF actualRect;
    private Animator animator;
    private Paint bitmapPaint;
    private RectF bottomEdge;
    private RectF bottomLeftCorner;
    private float bottomPadding;
    private RectF bottomRightCorner;
    private Bitmap circleBitmap;
    private Paint dimPaint;
    private boolean dimVisibile;
    private Paint eraserPaint;
    private float frameAlpha;
    private Paint framePaint;
    private boolean frameVisible;
    private boolean freeform;
    private Animator gridAnimator;
    private float gridProgress;
    private GridType gridType;
    private Paint handlePaint;
    private boolean inBubbleMode;
    private AccelerateDecelerateInterpolator interpolator;
    private boolean isDragging;
    private long lastUpdateTime;
    private RectF leftEdge;
    private Paint linePaint;
    private AreaViewListener listener;
    private float lockAspectRatio;
    private float minWidth;
    private GridType previousGridType;
    private int previousX;
    private int previousY;
    private RectF rightEdge;
    private Paint shadowPaint;
    private float sidePadding;
    private RectF targetRect;
    private RectF tempRect;
    private RectF topEdge;
    private RectF topLeftCorner;
    private RectF topRightCorner;

    interface AreaViewListener {
        void onAreaChange();

        void onAreaChangeBegan();

        void onAreaChangeEnded();
    }

    private enum Control {
        NONE,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        LEFT,
        BOTTOM,
        RIGHT
    }

    enum GridType {
        NONE,
        MINOR,
        MAJOR
    }

    public CropAreaView(Context context) {
        super(context);
        this.topLeftCorner = new RectF();
        this.topRightCorner = new RectF();
        this.bottomLeftCorner = new RectF();
        this.bottomRightCorner = new RectF();
        this.topEdge = new RectF();
        this.leftEdge = new RectF();
        this.bottomEdge = new RectF();
        this.rightEdge = new RectF();
        this.actualRect = new RectF();
        this.tempRect = new RectF();
        this.frameAlpha = 1.0f;
        this.interpolator = new AccelerateDecelerateInterpolator();
        this.freeform = true;
        this.targetRect = new RectF();
        this.inBubbleMode = context instanceof BubbleActivity;
        this.frameVisible = true;
        this.dimVisibile = true;
        this.sidePadding = AndroidUtilities.dp(16.0f);
        this.minWidth = AndroidUtilities.dp(32.0f);
        this.gridType = GridType.NONE;
        Paint paint = new Paint();
        this.dimPaint = paint;
        paint.setColor(2130706432);
        Paint paint2 = new Paint();
        this.shadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.shadowPaint.setColor(436207616);
        this.shadowPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        Paint paint3 = new Paint();
        this.linePaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.linePaint.setColor(-1);
        this.linePaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
        Paint paint4 = new Paint();
        this.handlePaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.handlePaint.setColor(-1);
        Paint paint5 = new Paint();
        this.framePaint = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.framePaint.setColor(-1291845633);
        Paint paint6 = new Paint(1);
        this.eraserPaint = paint6;
        paint6.setColor(0);
        this.eraserPaint.setStyle(Paint.Style.FILL);
        this.eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint7 = new Paint(2);
        this.bitmapPaint = paint7;
        paint7.setColor(-1);
    }

    public void setIsVideo(boolean z) {
        this.minWidth = AndroidUtilities.dp(z ? 64.0f : 32.0f);
    }

    public boolean isDragging() {
        return this.isDragging;
    }

    public void setDimVisibility(boolean z) {
        this.dimVisibile = z;
    }

    public void setFrameVisibility(boolean z, boolean z2) {
        this.frameVisible = z;
        if (z) {
            this.frameAlpha = z2 ? 0.0f : 1.0f;
            this.lastUpdateTime = SystemClock.elapsedRealtime();
            invalidate();
            return;
        }
        this.frameAlpha = 1.0f;
    }

    public void setBottomPadding(float f) {
        this.bottomPadding = f;
    }

    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    public void setListener(AreaViewListener areaViewListener) {
        this.listener = areaViewListener;
    }

    public void setBitmap(int i, int i2, boolean z, boolean z2) {
        this.freeform = z2;
        float f = z ? i2 / i : i / i2;
        if (!z2) {
            this.lockAspectRatio = 1.0f;
            f = 1.0f;
        }
        setActualRect(f);
    }

    public void setFreeform(boolean z) {
        this.freeform = z;
    }

    public void setActualRect(float f) {
        calculateRect(this.actualRect, f);
        updateTouchAreas();
        invalidate();
    }

    public void setActualRect(RectF rectF) {
        this.actualRect.set(rectF);
        updateTouchAreas();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.freeform) {
            int iDp = AndroidUtilities.dp(2.0f);
            int iDp2 = AndroidUtilities.dp(16.0f);
            int iDp3 = AndroidUtilities.dp(3.0f);
            RectF rectF = this.actualRect;
            float f = rectF.left;
            int i9 = ((int) f) - iDp;
            float f2 = rectF.top;
            int i10 = ((int) f2) - iDp;
            int i11 = iDp * 2;
            int i12 = ((int) (rectF.right - f)) + i11;
            int i13 = ((int) (rectF.bottom - f2)) + i11;
            if (this.dimVisibile) {
                float f3 = i10 + iDp;
                canvas.drawRect(0.0f, 0.0f, getWidth(), f3, this.dimPaint);
                float f4 = (i10 + i13) - iDp;
                canvas.drawRect(0.0f, f3, i9 + iDp, f4, this.dimPaint);
                canvas.drawRect((i9 + i12) - iDp, f3, getWidth(), f4, this.dimPaint);
                canvas.drawRect(0.0f, f4, getWidth(), getHeight(), this.dimPaint);
            }
            if (!this.frameVisible) {
                return;
            }
            int i14 = iDp3 - iDp;
            int i15 = iDp3 * 2;
            int i16 = i12 - i15;
            int i17 = i13 - i15;
            GridType gridType = this.gridType;
            if (gridType == GridType.NONE && this.gridProgress > 0.0f) {
                gridType = this.previousGridType;
            }
            this.shadowPaint.setAlpha((int) (this.gridProgress * 26.0f * this.frameAlpha));
            this.linePaint.setAlpha((int) (this.gridProgress * 178.0f * this.frameAlpha));
            this.framePaint.setAlpha((int) (this.frameAlpha * 178.0f));
            this.handlePaint.setAlpha((int) (this.frameAlpha * 255.0f));
            int i18 = 0;
            while (true) {
                int i19 = 3;
                if (i18 >= 3) {
                    break;
                }
                if (gridType == GridType.MINOR) {
                    int i20 = 1;
                    while (i20 < 4) {
                        if (i18 == 2 && i20 == i19) {
                            i7 = iDp;
                            i5 = iDp2;
                            i6 = i13;
                            i8 = i12;
                        } else {
                            int i21 = i9 + iDp3;
                            int i22 = i16 / 3;
                            float f5 = i21 + ((i22 / 3) * i20) + (i22 * i18);
                            i5 = iDp2;
                            int i23 = i10 + iDp3;
                            i6 = i13;
                            float f6 = i23;
                            i7 = iDp;
                            float f7 = i23 + i17;
                            i8 = i12;
                            canvas.drawLine(f5, f6, f5, f7, this.shadowPaint);
                            canvas.drawLine(f5, f6, f5, f7, this.linePaint);
                            int i24 = i17 / 3;
                            int i25 = i23 + ((i24 / 3) * i20) + (i24 * i18);
                            float f8 = i21;
                            float f9 = i25;
                            float f10 = i21 + i16;
                            canvas.drawLine(f8, f9, f10, f9, this.shadowPaint);
                            canvas.drawLine(f8, f9, f10, f9, this.linePaint);
                        }
                        i20++;
                        iDp2 = i5;
                        i13 = i6;
                        iDp = i7;
                        i12 = i8;
                        i19 = 3;
                    }
                    i = iDp;
                    i2 = iDp2;
                    i3 = i13;
                    i4 = i12;
                } else {
                    i = iDp;
                    i2 = iDp2;
                    i3 = i13;
                    i4 = i12;
                    if (gridType == GridType.MAJOR && i18 > 0) {
                        int i26 = i9 + iDp3;
                        float f11 = ((i16 / 3) * i18) + i26;
                        int i27 = i10 + iDp3;
                        float f12 = i27;
                        float f13 = i27 + i17;
                        canvas.drawLine(f11, f12, f11, f13, this.shadowPaint);
                        canvas.drawLine(f11, f12, f11, f13, this.linePaint);
                        float f14 = i26;
                        float f15 = i27 + ((i17 / 3) * i18);
                        float f16 = i26 + i16;
                        canvas.drawLine(f14, f15, f16, f15, this.shadowPaint);
                        canvas.drawLine(f14, f15, f16, f15, this.linePaint);
                    }
                }
                i18++;
                iDp2 = i2;
                i13 = i3;
                iDp = i;
                i12 = i4;
            }
            int i28 = iDp;
            int i29 = iDp2;
            int i30 = i13;
            float f17 = i9 + i14;
            float f18 = i10 + i14;
            int i31 = i9 + i12;
            float f19 = i31 - i14;
            canvas.drawRect(f17, f18, f19, r3 + i28, this.framePaint);
            int i32 = i10 + i30;
            float f20 = i32 - i14;
            canvas.drawRect(f17, f18, r1 + i28, f20, this.framePaint);
            canvas.drawRect(f17, r4 - i28, f19, f20, this.framePaint);
            canvas.drawRect(r6 - i28, f18, f19, f20, this.framePaint);
            float f21 = i9;
            float f22 = i10;
            float f23 = i9 + i29;
            float f24 = i10 + iDp3;
            canvas.drawRect(f21, f22, f23, f24, this.handlePaint);
            float f25 = i9 + iDp3;
            float f26 = i10 + i29;
            canvas.drawRect(f21, f22, f25, f26, this.handlePaint);
            float f27 = i31 - i29;
            float f28 = i31;
            canvas.drawRect(f27, f22, f28, f24, this.handlePaint);
            float f29 = i31 - iDp3;
            canvas.drawRect(f29, f22, f28, f26, this.handlePaint);
            float f30 = i32 - iDp3;
            float f31 = i32;
            canvas.drawRect(f21, f30, f23, f31, this.handlePaint);
            float f32 = i32 - i29;
            canvas.drawRect(f21, f32, f25, f31, this.handlePaint);
            canvas.drawRect(f27, f30, f28, f31, this.handlePaint);
            canvas.drawRect(f29, f32, f28, f31, this.handlePaint);
        } else {
            float measuredWidth = getMeasuredWidth() - (this.sidePadding * 2.0f);
            float measuredHeight = ((getMeasuredHeight() - this.bottomPadding) - ((Build.VERSION.SDK_INT < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight)) - (this.sidePadding * 2.0f);
            int iMin = (int) Math.min(measuredWidth, measuredHeight);
            Bitmap bitmap = this.circleBitmap;
            if (bitmap == null || bitmap.getWidth() != iMin) {
                Bitmap bitmap2 = this.circleBitmap;
                boolean z = bitmap2 != null;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                    this.circleBitmap = null;
                }
                try {
                    this.circleBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(this.circleBitmap);
                    float f33 = iMin;
                    canvas2.drawRect(0.0f, 0.0f, f33, f33, this.dimPaint);
                    canvas2.drawCircle(iMin / 2, iMin / 2, iMin / 2, this.eraserPaint);
                    canvas2.setBitmap(null);
                    if (!z) {
                        this.frameAlpha = 0.0f;
                        this.lastUpdateTime = SystemClock.elapsedRealtime();
                    }
                } catch (Throwable unused) {
                }
            }
            if (this.circleBitmap != null) {
                this.bitmapPaint.setAlpha((int) (this.frameAlpha * 255.0f));
                this.dimPaint.setAlpha((int) (this.frameAlpha * 127.0f));
                float f34 = this.sidePadding;
                float f35 = iMin;
                float f36 = ((measuredWidth - f35) / 2.0f) + f34;
                float f37 = f34 + ((measuredHeight - f35) / 2.0f) + ((Build.VERSION.SDK_INT < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight);
                float f38 = f36 + f35;
                float f39 = f35 + f37;
                float f40 = (int) f37;
                canvas.drawRect(0.0f, 0.0f, getWidth(), f40, this.dimPaint);
                float f41 = (int) f36;
                float f42 = (int) f39;
                canvas.drawRect(0.0f, f40, f41, f42, this.dimPaint);
                canvas.drawRect((int) f38, f40, getWidth(), f42, this.dimPaint);
                canvas.drawRect(0.0f, f42, getWidth(), getHeight(), this.dimPaint);
                canvas.drawBitmap(this.circleBitmap, f41, f40, this.bitmapPaint);
            }
        }
        if (this.frameAlpha < 1.0f) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.lastUpdateTime;
            if (j > 17) {
                j = 17;
            }
            this.lastUpdateTime = jElapsedRealtime;
            float f43 = this.frameAlpha + (j / 180.0f);
            this.frameAlpha = f43;
            if (f43 > 1.0f) {
                this.frameAlpha = 1.0f;
            }
            invalidate();
        }
    }

    public void updateTouchAreas() {
        int iDp = AndroidUtilities.dp(16.0f);
        RectF rectF = this.topLeftCorner;
        RectF rectF2 = this.actualRect;
        float f = rectF2.left;
        float f2 = iDp;
        float f3 = rectF2.top;
        rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
        RectF rectF3 = this.topRightCorner;
        RectF rectF4 = this.actualRect;
        float f4 = rectF4.right;
        float f5 = rectF4.top;
        rectF3.set(f4 - f2, f5 - f2, f4 + f2, f5 + f2);
        RectF rectF5 = this.bottomLeftCorner;
        RectF rectF6 = this.actualRect;
        float f6 = rectF6.left;
        float f7 = rectF6.bottom;
        rectF5.set(f6 - f2, f7 - f2, f6 + f2, f7 + f2);
        RectF rectF7 = this.bottomRightCorner;
        RectF rectF8 = this.actualRect;
        float f8 = rectF8.right;
        float f9 = rectF8.bottom;
        rectF7.set(f8 - f2, f9 - f2, f8 + f2, f9 + f2);
        RectF rectF9 = this.topEdge;
        RectF rectF10 = this.actualRect;
        float f10 = rectF10.left + f2;
        float f11 = rectF10.top;
        rectF9.set(f10, f11 - f2, rectF10.right - f2, f11 + f2);
        RectF rectF11 = this.leftEdge;
        RectF rectF12 = this.actualRect;
        float f12 = rectF12.left;
        rectF11.set(f12 - f2, rectF12.top + f2, f12 + f2, rectF12.bottom - f2);
        RectF rectF13 = this.rightEdge;
        RectF rectF14 = this.actualRect;
        float f13 = rectF14.right;
        rectF13.set(f13 - f2, rectF14.top + f2, f13 + f2, rectF14.bottom - f2);
        RectF rectF15 = this.bottomEdge;
        RectF rectF16 = this.actualRect;
        float f14 = rectF16.left + f2;
        float f15 = rectF16.bottom;
        rectF15.set(f14, f15 - f2, rectF16.right - f2, f15 + f2);
    }

    public float getLockAspectRatio() {
        return this.lockAspectRatio;
    }

    public void setLockedAspectRatio(float f) {
        this.lockAspectRatio = f;
    }

    public void setGridType(GridType gridType, boolean z) {
        Animator animator = this.gridAnimator;
        if (animator != null && (!z || this.gridType != gridType)) {
            animator.cancel();
            this.gridAnimator = null;
        }
        GridType gridType2 = this.gridType;
        if (gridType2 == gridType) {
            return;
        }
        this.previousGridType = gridType2;
        this.gridType = gridType;
        GridType gridType3 = GridType.NONE;
        float f = gridType == gridType3 ? 0.0f : 1.0f;
        if (!z) {
            this.gridProgress = f;
            invalidate();
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "gridProgress", this.gridProgress, f);
        this.gridAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
        this.gridAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.Crop.CropAreaView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                CropAreaView.this.gridAnimator = null;
            }
        });
        if (gridType == gridType3) {
            this.gridAnimator.setStartDelay(200L);
        }
        this.gridAnimator.start();
    }

    @Keep
    private void setGridProgress(float f) {
        this.gridProgress = f;
        invalidate();
    }

    @Keep
    private float getGridProgress() {
        return this.gridProgress;
    }

    public float getAspectRatio() {
        RectF rectF = this.actualRect;
        return (rectF.right - rectF.left) / (rectF.bottom - rectF.top);
    }

    public void fill(final RectF rectF, Animator animator, boolean z) {
        if (z) {
            Animator animator2 = this.animator;
            if (animator2 != null) {
                animator2.cancel();
                this.animator = null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.animator = animatorSet;
            animatorSet.setDuration(300L);
            float[] fArr = {rectF.left};
            animatorArr[0].setInterpolator(this.interpolator);
            float[] fArr2 = {rectF.top};
            animatorArr[1].setInterpolator(this.interpolator);
            float[] fArr3 = {rectF.right};
            animatorArr[2].setInterpolator(this.interpolator);
            float[] fArr4 = {rectF.bottom};
            animatorArr[3].setInterpolator(this.interpolator);
            Animator[] animatorArr = {ObjectAnimator.ofFloat(this, "cropLeft", fArr), ObjectAnimator.ofFloat(this, "cropTop", fArr2), ObjectAnimator.ofFloat(this, "cropRight", fArr3), ObjectAnimator.ofFloat(this, "cropBottom", fArr4), animator};
            animatorArr[4].setInterpolator(this.interpolator);
            animatorSet.playTogether(animatorArr);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.Crop.CropAreaView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator3) {
                    CropAreaView.this.setActualRect(rectF);
                    CropAreaView.this.animator = null;
                }
            });
            animatorSet.start();
            return;
        }
        setActualRect(rectF);
    }

    public void resetAnimator() {
        Animator animator = this.animator;
        if (animator != null) {
            animator.cancel();
            this.animator = null;
        }
    }

    @Keep
    private void setCropLeft(float f) {
        this.actualRect.left = f;
        invalidate();
    }

    @Keep
    public float getCropLeft() {
        return this.actualRect.left;
    }

    @Keep
    private void setCropTop(float f) {
        this.actualRect.top = f;
        invalidate();
    }

    @Keep
    public float getCropTop() {
        return this.actualRect.top;
    }

    @Keep
    private void setCropRight(float f) {
        this.actualRect.right = f;
        invalidate();
    }

    @Keep
    public float getCropRight() {
        return this.actualRect.right;
    }

    @Keep
    private void setCropBottom(float f) {
        this.actualRect.bottom = f;
        invalidate();
    }

    @Keep
    public float getCropBottom() {
        return this.actualRect.bottom;
    }

    public float getCropCenterX() {
        RectF rectF = this.actualRect;
        return (rectF.left + rectF.right) / 2.0f;
    }

    public float getCropCenterY() {
        RectF rectF = this.actualRect;
        return (rectF.top + rectF.bottom) / 2.0f;
    }

    public float getCropWidth() {
        RectF rectF = this.actualRect;
        return rectF.right - rectF.left;
    }

    public float getCropHeight() {
        RectF rectF = this.actualRect;
        return rectF.bottom - rectF.top;
    }

    public RectF getTargetRectToFill() {
        return getTargetRectToFill(getAspectRatio());
    }

    public RectF getTargetRectToFill(float f) {
        calculateRect(this.targetRect, f);
        return this.targetRect;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void calculateRect(android.graphics.RectF r13, float r14) {
        /*
            r12 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto Ld
            boolean r0 = r12.inBubbleMode
            if (r0 != 0) goto Ld
            int r0 = org.rbmain.messenger.AndroidUtilities.statusBarHeight
            goto Le
        Ld:
            r0 = 0
        Le:
            float r0 = (float) r0
            int r1 = r12.getMeasuredHeight()
            float r1 = (float) r1
            float r2 = r12.bottomPadding
            float r1 = r1 - r2
            float r1 = r1 - r0
            int r2 = r12.getMeasuredWidth()
            float r2 = (float) r2
            float r2 = r2 / r1
            int r3 = r12.getMeasuredWidth()
            float r3 = (float) r3
            float r3 = java.lang.Math.min(r3, r1)
            float r4 = r12.sidePadding
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 * r5
            float r3 = r3 - r4
            int r4 = r12.getMeasuredWidth()
            float r4 = (float) r4
            float r6 = r12.sidePadding
            float r7 = r6 * r5
            float r4 = r4 - r7
            float r6 = r6 * r5
            float r6 = r1 - r6
            int r7 = r12.getMeasuredWidth()
            float r7 = (float) r7
            float r7 = r7 / r5
            float r1 = r1 / r5
            float r0 = r0 + r1
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r14
            float r1 = java.lang.Math.abs(r1)
            double r8 = (double) r1
            r10 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 >= 0) goto L5d
            float r3 = r3 / r5
            float r14 = r7 - r3
            float r1 = r0 - r3
            float r7 = r7 + r3
            float r0 = r0 + r3
            goto L81
        L5d:
            float r1 = r14 - r2
            double r1 = (double) r1
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 > 0) goto L75
            float r1 = r6 * r14
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 <= 0) goto L6b
            goto L75
        L6b:
            float r1 = r1 / r5
            float r14 = r7 - r1
            float r6 = r6 / r5
            float r2 = r0 - r6
            float r7 = r7 + r1
            float r0 = r0 + r6
            r1 = r2
            goto L81
        L75:
            float r1 = r4 / r5
            float r2 = r7 - r1
            float r4 = r4 / r14
            float r4 = r4 / r5
            float r14 = r0 - r4
            float r7 = r7 + r1
            float r0 = r0 + r4
            r1 = r14
            r14 = r2
        L81:
            r13.set(r14, r1, r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.Crop.CropAreaView.calculateRect(android.graphics.RectF, float):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() - ((ViewGroup) getParent()).getX());
        int y = (int) (motionEvent.getY() - ((ViewGroup) getParent()).getY());
        float f = (Build.VERSION.SDK_INT < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (this.freeform) {
                float f2 = x;
                float f3 = y;
                if (this.topLeftCorner.contains(f2, f3)) {
                    this.activeControl = Control.TOP_LEFT;
                } else if (this.topRightCorner.contains(f2, f3)) {
                    this.activeControl = Control.TOP_RIGHT;
                } else if (this.bottomLeftCorner.contains(f2, f3)) {
                    this.activeControl = Control.BOTTOM_LEFT;
                } else if (this.bottomRightCorner.contains(f2, f3)) {
                    this.activeControl = Control.BOTTOM_RIGHT;
                } else if (this.leftEdge.contains(f2, f3)) {
                    this.activeControl = Control.LEFT;
                } else if (this.topEdge.contains(f2, f3)) {
                    this.activeControl = Control.TOP;
                } else if (this.rightEdge.contains(f2, f3)) {
                    this.activeControl = Control.RIGHT;
                } else if (this.bottomEdge.contains(f2, f3)) {
                    this.activeControl = Control.BOTTOM;
                } else {
                    this.activeControl = Control.NONE;
                    return false;
                }
                this.previousX = x;
                this.previousY = y;
                setGridType(GridType.MAJOR, false);
                this.isDragging = true;
                AreaViewListener areaViewListener = this.listener;
                if (areaViewListener != null) {
                    areaViewListener.onAreaChangeBegan();
                }
                return true;
            }
            this.activeControl = Control.NONE;
            return false;
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.isDragging = false;
            Control control = this.activeControl;
            Control control2 = Control.NONE;
            if (control == control2) {
                return false;
            }
            this.activeControl = control2;
            AreaViewListener areaViewListener2 = this.listener;
            if (areaViewListener2 != null) {
                areaViewListener2.onAreaChangeEnded();
            }
            return true;
        }
        if (actionMasked != 2 || this.activeControl == Control.NONE) {
            return false;
        }
        this.tempRect.set(this.actualRect);
        float f4 = x - this.previousX;
        float f5 = y - this.previousY;
        this.previousX = x;
        this.previousY = y;
        boolean z = Math.abs(f4) > Math.abs(f5);
        switch (AnonymousClass3.$SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[this.activeControl.ordinal()]) {
            case 1:
                RectF rectF = this.tempRect;
                rectF.left += f4;
                rectF.top += f5;
                if (this.lockAspectRatio > 0.0f) {
                    float fWidth = rectF.width();
                    float fHeight = this.tempRect.height();
                    if (z) {
                        constrainRectByWidth(this.tempRect, this.lockAspectRatio);
                    } else {
                        constrainRectByHeight(this.tempRect, this.lockAspectRatio);
                    }
                    RectF rectF2 = this.tempRect;
                    rectF2.left -= rectF2.width() - fWidth;
                    RectF rectF3 = this.tempRect;
                    rectF3.top -= rectF3.width() - fHeight;
                    break;
                }
                break;
            case 2:
                RectF rectF4 = this.tempRect;
                rectF4.right += f4;
                rectF4.top += f5;
                if (this.lockAspectRatio > 0.0f) {
                    float fHeight2 = rectF4.height();
                    if (z) {
                        constrainRectByWidth(this.tempRect, this.lockAspectRatio);
                    } else {
                        constrainRectByHeight(this.tempRect, this.lockAspectRatio);
                    }
                    RectF rectF5 = this.tempRect;
                    rectF5.top -= rectF5.width() - fHeight2;
                    break;
                }
                break;
            case 3:
                RectF rectF6 = this.tempRect;
                rectF6.left += f4;
                rectF6.bottom += f5;
                if (this.lockAspectRatio > 0.0f) {
                    float fWidth2 = rectF6.width();
                    if (z) {
                        constrainRectByWidth(this.tempRect, this.lockAspectRatio);
                    } else {
                        constrainRectByHeight(this.tempRect, this.lockAspectRatio);
                    }
                    RectF rectF7 = this.tempRect;
                    rectF7.left -= rectF7.width() - fWidth2;
                    break;
                }
                break;
            case 4:
                RectF rectF8 = this.tempRect;
                rectF8.right += f4;
                rectF8.bottom += f5;
                float f6 = this.lockAspectRatio;
                if (f6 > 0.0f) {
                    if (z) {
                        constrainRectByWidth(rectF8, f6);
                        break;
                    } else {
                        constrainRectByHeight(rectF8, f6);
                        break;
                    }
                }
                break;
            case 5:
                RectF rectF9 = this.tempRect;
                rectF9.top += f5;
                float f7 = this.lockAspectRatio;
                if (f7 > 0.0f) {
                    constrainRectByHeight(rectF9, f7);
                    break;
                }
                break;
            case 6:
                RectF rectF10 = this.tempRect;
                rectF10.left += f4;
                float f8 = this.lockAspectRatio;
                if (f8 > 0.0f) {
                    constrainRectByWidth(rectF10, f8);
                    break;
                }
                break;
            case 7:
                RectF rectF11 = this.tempRect;
                rectF11.right += f4;
                float f9 = this.lockAspectRatio;
                if (f9 > 0.0f) {
                    constrainRectByWidth(rectF11, f9);
                    break;
                }
                break;
            case 8:
                RectF rectF12 = this.tempRect;
                rectF12.bottom += f5;
                float f10 = this.lockAspectRatio;
                if (f10 > 0.0f) {
                    constrainRectByHeight(rectF12, f10);
                    break;
                }
                break;
        }
        RectF rectF13 = this.tempRect;
        float f11 = rectF13.left;
        float f12 = this.sidePadding;
        if (f11 < f12) {
            float f13 = this.lockAspectRatio;
            if (f13 > 0.0f) {
                rectF13.bottom = rectF13.top + ((rectF13.right - f12) / f13);
            }
            rectF13.left = f12;
        } else if (rectF13.right > getWidth() - this.sidePadding) {
            this.tempRect.right = getWidth() - this.sidePadding;
            if (this.lockAspectRatio > 0.0f) {
                RectF rectF14 = this.tempRect;
                rectF14.bottom = rectF14.top + (rectF14.width() / this.lockAspectRatio);
            }
        }
        float f14 = this.sidePadding;
        float f15 = f + f14;
        float f16 = this.bottomPadding + f14;
        RectF rectF15 = this.tempRect;
        if (rectF15.top < f15) {
            float f17 = this.lockAspectRatio;
            if (f17 > 0.0f) {
                rectF15.right = rectF15.left + ((rectF15.bottom - f15) * f17);
            }
            rectF15.top = f15;
        } else if (rectF15.bottom > getHeight() - f16) {
            this.tempRect.bottom = getHeight() - f16;
            if (this.lockAspectRatio > 0.0f) {
                RectF rectF16 = this.tempRect;
                rectF16.right = rectF16.left + (rectF16.height() * this.lockAspectRatio);
            }
        }
        float fWidth3 = this.tempRect.width();
        float f18 = this.minWidth;
        if (fWidth3 < f18) {
            RectF rectF17 = this.tempRect;
            rectF17.right = rectF17.left + f18;
        }
        float fHeight3 = this.tempRect.height();
        float f19 = this.minWidth;
        if (fHeight3 < f19) {
            RectF rectF18 = this.tempRect;
            rectF18.bottom = rectF18.top + f19;
        }
        float f20 = this.lockAspectRatio;
        if (f20 > 0.0f) {
            if (f20 < 1.0f) {
                float fWidth4 = this.tempRect.width();
                float f21 = this.minWidth;
                if (fWidth4 <= f21) {
                    RectF rectF19 = this.tempRect;
                    rectF19.right = rectF19.left + f21;
                    rectF19.bottom = rectF19.top + (rectF19.width() / this.lockAspectRatio);
                }
            } else {
                float fHeight4 = this.tempRect.height();
                float f22 = this.minWidth;
                if (fHeight4 <= f22) {
                    RectF rectF20 = this.tempRect;
                    rectF20.bottom = rectF20.top + f22;
                    rectF20.right = rectF20.left + (rectF20.height() * this.lockAspectRatio);
                }
            }
        }
        setActualRect(this.tempRect);
        AreaViewListener areaViewListener3 = this.listener;
        if (areaViewListener3 != null) {
            areaViewListener3.onAreaChange();
        }
        return true;
    }

    /* renamed from: org.rbmain.ui.Components.Crop.CropAreaView$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control;

        static {
            int[] iArr = new int[Control.values().length];
            $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control = iArr;
            try {
                iArr[Control.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[Control.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[Control.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[Control.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[Control.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[Control.LEFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[Control.RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$Crop$CropAreaView$Control[Control.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void constrainRectByWidth(RectF rectF, float f) {
        float fWidth = rectF.width();
        rectF.right = rectF.left + fWidth;
        rectF.bottom = rectF.top + (fWidth / f);
    }

    private void constrainRectByHeight(RectF rectF, float f) {
        float fHeight = rectF.height();
        rectF.right = rectF.left + (f * fHeight);
        rectF.bottom = rectF.top + fHeight;
    }

    public void getCropRect(RectF rectF) {
        rectF.set(this.actualRect);
    }
}
