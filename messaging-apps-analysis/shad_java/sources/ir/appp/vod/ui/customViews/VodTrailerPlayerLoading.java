package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import ir.medu.shad.R;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;

/* compiled from: VodTrailerPlayerLoading.kt */
/* loaded from: classes3.dex */
public final class VodTrailerPlayerLoading extends FrameLayout {
    private AccelerateInterpolator accelerateInterpolator;
    private boolean changeRetryToLoad;
    private final RectF circleRect;
    private float currentCircleLength;
    private float currentProgressTime;
    private float currentRetryScale;
    private DecelerateInterpolator decelerateInterpolator;
    private boolean indeterminate;
    private long lastUpdateTime;
    private int loadingCircleSize;
    private LoadingMode loadingMode;
    private VectorDrawableCompat playIcon;
    private int progressBackgroundColor;
    private Paint progressBackgroundPaint;
    private int progressBackgroundShadowColor;
    private Paint progressBackgroundShadowPaint;
    private int progressColor;
    private Paint progressPaint;
    private float radOffset;
    private VectorDrawableCompat retryIcon;
    private boolean risingCircleLength;
    private final float risingTime;
    private final float rotationTime;
    private final int strokeSize;

    /* compiled from: VodTrailerPlayerLoading.kt */
    public enum LoadingMode {
        LOADING,
        RETRY
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodTrailerPlayerLoading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.loadingMode = LoadingMode.LOADING;
        this.indeterminate = true;
        this.circleRect = new RectF();
        this.progressColor = -1;
        this.progressBackgroundColor = -1157627904;
        this.progressBackgroundShadowColor = -1152956601;
        int iDp = AndroidUtilities.dp(1.5f);
        this.strokeSize = iDp;
        this.rotationTime = 2000.0f;
        this.risingTime = 500.0f;
        setWillNotDraw(false);
        this.decelerateInterpolator = new DecelerateInterpolator();
        this.accelerateInterpolator = new AccelerateInterpolator();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(iDp);
        paint.setColor(this.progressColor);
        this.progressPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(this.progressBackgroundColor);
        this.progressBackgroundPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(iDp);
        paint3.setColor(this.progressBackgroundShadowColor);
        this.progressBackgroundShadowPaint = paint3;
        this.playIcon = VectorDrawableCompat.create(getContext().getResources(), R.drawable.trailer_play, null);
        this.retryIcon = VectorDrawableCompat.create(getContext().getResources(), R.drawable.vod_retry, null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.loadingCircleSize = View.MeasureSpec.getSize(i) - (this.strokeSize * 2);
        super.onMeasure(i, i2);
    }

    private final void updateAnimationIfNeeded() {
        float interpolation;
        LoadingMode loadingMode = this.loadingMode;
        LoadingMode loadingMode2 = LoadingMode.LOADING;
        long j = 0;
        if (loadingMode == loadingMode2 && this.changeRetryToLoad) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis - this.lastUpdateTime;
            if (j2 == jCurrentTimeMillis) {
                this.lastUpdateTime = jCurrentTimeMillis;
            } else {
                j = j2;
            }
            float f = 1 - (j / this.risingTime);
            this.currentRetryScale = f;
            if (f <= 0.0f) {
                this.changeRetryToLoad = false;
            }
            invalidate();
            return;
        }
        if (loadingMode == loadingMode2 && this.indeterminate) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            long j3 = jCurrentTimeMillis2 - this.lastUpdateTime;
            if (j3 > 17) {
                j3 = 17;
            }
            this.lastUpdateTime = jCurrentTimeMillis2;
            float f2 = this.radOffset + ((360 * j3) / this.rotationTime);
            this.radOffset = f2;
            this.radOffset = f2 - (((int) (f2 / 360)) * 360);
            float f3 = this.currentProgressTime + j3;
            this.currentProgressTime = f3;
            float f4 = this.risingTime;
            if (f3 >= f4) {
                this.currentProgressTime = f4;
            }
            if (this.risingCircleLength) {
                AccelerateInterpolator accelerateInterpolator = this.accelerateInterpolator;
                Intrinsics.checkNotNull(accelerateInterpolator);
                interpolation = 4 + (266 * accelerateInterpolator.getInterpolation(this.currentProgressTime / this.risingTime));
            } else {
                DecelerateInterpolator decelerateInterpolator = this.decelerateInterpolator;
                Intrinsics.checkNotNull(decelerateInterpolator);
                interpolation = 4 - (270 * (1.0f - decelerateInterpolator.getInterpolation(this.currentProgressTime / this.risingTime)));
            }
            this.currentCircleLength = interpolation;
            if (this.currentProgressTime == this.risingTime) {
                boolean z = this.risingCircleLength;
                if (z) {
                    this.radOffset += 270.0f;
                    this.currentCircleLength = -266.0f;
                }
                this.risingCircleLength = !z;
                this.currentProgressTime = 0.0f;
            }
            invalidate();
            return;
        }
        if (loadingMode != LoadingMode.RETRY || this.currentCircleLength > 360.0f) {
            return;
        }
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        long j4 = jCurrentTimeMillis3 - this.lastUpdateTime;
        if (j4 == jCurrentTimeMillis3) {
            this.lastUpdateTime = jCurrentTimeMillis3;
        } else {
            j = j4;
        }
        this.radOffset = -90.0f;
        float f5 = this.risingTime;
        this.currentCircleLength = (360 * j) / f5;
        this.currentRetryScale = j / f5;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Paint paint = this.progressBackgroundShadowPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.loadingCircleSize / 2.0f, paint);
        RectF rectF = this.circleRect;
        int i = this.loadingCircleSize;
        rectF.set((-i) / 2.0f, (-i) / 2.0f, i / 2.0f, i / 2.0f);
        Paint paint2 = this.progressBackgroundPaint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, (this.loadingCircleSize - this.strokeSize) / 2.0f, paint2);
        VectorDrawableCompat vectorDrawableCompat = this.playIcon;
        if (vectorDrawableCompat != null) {
            int i2 = this.loadingCircleSize;
            vectorDrawableCompat.setBounds((-i2) / 4, (-i2) / 4, i2 / 4, i2 / 4);
        }
        VectorDrawableCompat vectorDrawableCompat2 = this.retryIcon;
        if (vectorDrawableCompat2 != null) {
            int i3 = this.loadingCircleSize;
            vectorDrawableCompat2.setBounds((-i3) / 6, (-i3) / 6, i3 / 6, i3 / 6);
        }
        canvas.save();
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        RectF rectF2 = this.circleRect;
        float f = this.radOffset;
        float f2 = this.currentCircleLength;
        Paint paint3 = this.progressPaint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawArc(rectF2, f, f2, false, paint3);
        if (this.changeRetryToLoad) {
            float f3 = this.currentRetryScale;
            canvas.scale(f3, f3);
            VectorDrawableCompat vectorDrawableCompat3 = this.retryIcon;
            if (vectorDrawableCompat3 != null) {
                vectorDrawableCompat3.draw(canvas);
            }
            float f4 = 1;
            float f5 = this.currentRetryScale;
            canvas.scale((f4 - f5) / f5, (f4 - f5) / f5);
            VectorDrawableCompat vectorDrawableCompat4 = this.playIcon;
            if (vectorDrawableCompat4 != null) {
                vectorDrawableCompat4.draw(canvas);
            }
        } else {
            LoadingMode loadingMode = this.loadingMode;
            if (loadingMode == LoadingMode.LOADING) {
                VectorDrawableCompat vectorDrawableCompat5 = this.playIcon;
                if (vectorDrawableCompat5 != null) {
                    vectorDrawableCompat5.draw(canvas);
                }
            } else if (loadingMode == LoadingMode.RETRY) {
                canvas.rotate((this.currentCircleLength / 2) - 135.0f);
                float f6 = this.currentRetryScale;
                canvas.scale(f6, f6);
                VectorDrawableCompat vectorDrawableCompat6 = this.retryIcon;
                if (vectorDrawableCompat6 != null) {
                    vectorDrawableCompat6.draw(canvas);
                }
            }
        }
        canvas.restore();
        updateAnimationIfNeeded();
    }

    public final void setIndeterminateState(boolean z) {
        this.indeterminate = z;
        resetAnimationValues();
    }

    public final void setLoadingMode(LoadingMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.changeRetryToLoad = this.loadingMode == LoadingMode.RETRY && mode == LoadingMode.LOADING;
        this.loadingMode = mode;
        resetAnimationValues();
    }

    private final void resetAnimationValues() {
        this.lastUpdateTime = 0L;
        this.currentRetryScale = 0.0f;
        this.currentCircleLength = this.loadingMode == LoadingMode.LOADING ? 360.0f : 0.0f;
        invalidate();
    }
}
