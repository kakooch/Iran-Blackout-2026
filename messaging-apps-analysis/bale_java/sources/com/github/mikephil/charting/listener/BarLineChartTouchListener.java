package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* loaded from: classes2.dex */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private Matrix a;
    private Matrix b;
    private MPPointF c;
    private MPPointF d;
    private float e;
    private float f;
    private float g;
    private IDataSet h;
    private VelocityTracker i;
    private long j;
    private MPPointF k;
    private MPPointF l;
    private float m;
    private float n;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix, float f) {
        super(barLineChartBase);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = MPPointF.getInstance(0.0f, 0.0f);
        this.d = MPPointF.getInstance(0.0f, 0.0f);
        this.e = 1.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.j = 0L;
        this.k = MPPointF.getInstance(0.0f, 0.0f);
        this.l = MPPointF.getInstance(0.0f, 0.0f);
        this.a = matrix;
        this.m = Utils.convertDpToPixel(f);
        this.n = Utils.convertDpToPixel(3.5f);
    }

    private static float a(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float b(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    private boolean c() {
        IDataSet iDataSet;
        return (this.h == null && ((BarLineChartBase) this.mChart).isAnyAxisInverted()) || ((iDataSet = this.h) != null && ((BarLineChartBase) this.mChart).isInverted(iDataSet.getAxisDependency()));
    }

    private static void d(MPPointF mPPointF, MotionEvent motionEvent) {
        float x = motionEvent.getX(0) + motionEvent.getX(1);
        float y = motionEvent.getY(0) + motionEvent.getY(1);
        mPPointF.x = x / 2.0f;
        mPPointF.y = y / 2.0f;
    }

    private void e(MotionEvent motionEvent, float f, float f2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.a.set(this.b);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (c()) {
            if (this.mChart instanceof HorizontalBarChart) {
                f = -f;
            } else {
                f2 = -f2;
            }
        }
        this.a.postTranslate(f, f2);
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartTranslate(motionEvent, f, f2);
        }
    }

    private void f(MotionEvent motionEvent) {
        Highlight highlightByTouchPoint = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            return;
        }
        this.mLastHighlighted = highlightByTouchPoint;
        ((BarLineChartBase) this.mChart).highlightValue(highlightByTouchPoint, true);
    }

    private void g(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float fI = i(motionEvent);
            if (fI > this.n) {
                MPPointF mPPointF = this.d;
                MPPointF trans = getTrans(mPPointF.x, mPPointF.y);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
                int i = this.mTouchMode;
                if (i == 4) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f = fI / this.g;
                    boolean z = f < 1.0f;
                    boolean zCanZoomOutMoreX = z ? viewPortHandler.canZoomOutMoreX() : viewPortHandler.canZoomInMoreX();
                    boolean zCanZoomOutMoreY = z ? viewPortHandler.canZoomOutMoreY() : viewPortHandler.canZoomInMoreY();
                    float f2 = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? f : 1.0f;
                    float f3 = ((BarLineChartBase) this.mChart).isScaleYEnabled() ? f : 1.0f;
                    if (zCanZoomOutMoreY || zCanZoomOutMoreX) {
                        this.a.set(this.b);
                        this.a.postScale(f2, f3, trans.x, trans.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, f2, f3);
                        }
                    }
                } else if (i == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
                    float fA = a(motionEvent) / this.e;
                    if (fA < 1.0f ? viewPortHandler.canZoomOutMoreX() : viewPortHandler.canZoomInMoreX()) {
                        this.a.set(this.b);
                        this.a.postScale(fA, 1.0f, trans.x, trans.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, fA, 1.0f);
                        }
                    }
                } else if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float fB = b(motionEvent) / this.f;
                    if (fB < 1.0f ? viewPortHandler.canZoomOutMoreY() : viewPortHandler.canZoomInMoreY()) {
                        this.a.set(this.b);
                        this.a.postScale(1.0f, fB, trans.x, trans.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, 1.0f, fB);
                        }
                    }
                }
                MPPointF.recycleInstance(trans);
            }
        }
    }

    private void h(MotionEvent motionEvent) {
        this.b.set(this.a);
        this.c.x = motionEvent.getX();
        this.c.y = motionEvent.getY();
        this.h = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    private static float i(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void computeScroll() {
        MPPointF mPPointF = this.l;
        if (mPPointF.x == 0.0f && mPPointF.y == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.l.x *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        this.l.y *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        float f = (jCurrentAnimationTimeMillis - this.j) / 1000.0f;
        MPPointF mPPointF2 = this.l;
        float f2 = mPPointF2.x * f;
        float f3 = mPPointF2.y * f;
        MPPointF mPPointF3 = this.k;
        float f4 = mPPointF3.x + f2;
        mPPointF3.x = f4;
        float f5 = mPPointF3.y + f3;
        mPPointF3.y = f5;
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, f4, f5, 0);
        e(motionEventObtain, ((BarLineChartBase) this.mChart).isDragXEnabled() ? this.k.x - this.c.x : 0.0f, ((BarLineChartBase) this.mChart).isDragYEnabled() ? this.k.y - this.c.y : 0.0f);
        motionEventObtain.recycle();
        this.a = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.a, this.mChart, false);
        this.j = jCurrentAnimationTimeMillis;
        if (Math.abs(this.l.x) >= 0.01d || Math.abs(this.l.y) >= 0.01d) {
            Utils.postInvalidateOnAnimation(this.mChart);
            return;
        }
        ((BarLineChartBase) this.mChart).calculateOffsets();
        ((BarLineChartBase) this.mChart).postInvalidate();
        stopDeceleration();
    }

    public Matrix getMatrix() {
        return this.a;
    }

    public MPPointF getTrans(float f, float f2) {
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
        return MPPointF.getInstance(f - viewPortHandler.offsetLeft(), c() ? -(f2 - viewPortHandler.offsetTop()) : -((((BarLineChartBase) this.mChart).getMeasuredHeight() - f2) - viewPortHandler.offsetBottom()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.mChart).getData()).getEntryCount() > 0) {
            MPPointF trans = getTrans(motionEvent.getX(), motionEvent.getY());
            T t = this.mChart;
            ((BarLineChartBase) t).zoom(((BarLineChartBase) t).isScaleXEnabled() ? 1.4f : 1.0f, ((BarLineChartBase) this.mChart).isScaleYEnabled() ? 1.4f : 1.0f, trans.x, trans.y);
            if (((BarLineChartBase) this.mChart).isLogEnabled()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + trans.x + ", y: " + trans.y);
            }
            MPPointF.recycleInstance(trans);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f, f2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.i == null) {
            this.i = VelocityTracker.obtain();
        }
        this.i.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.i) != null) {
            velocityTracker.recycle();
            this.i = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.mChart).isDragEnabled() && !((BarLineChartBase) this.mChart).isScaleXEnabled() && !((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            startAction(motionEvent);
            stopDeceleration();
            h(motionEvent);
        } else if (action == 1) {
            VelocityTracker velocityTracker2 = this.i;
            int pointerId = motionEvent.getPointerId(0);
            velocityTracker2.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, Utils.getMaximumFlingVelocity());
            float yVelocity = velocityTracker2.getYVelocity(pointerId);
            float xVelocity = velocityTracker2.getXVelocity(pointerId);
            if ((Math.abs(xVelocity) > Utils.getMinimumFlingVelocity() || Math.abs(yVelocity) > Utils.getMinimumFlingVelocity()) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                stopDeceleration();
                this.j = AnimationUtils.currentAnimationTimeMillis();
                this.k.x = motionEvent.getX();
                this.k.y = motionEvent.getY();
                MPPointF mPPointF = this.l;
                mPPointF.x = xVelocity;
                mPPointF.y = yVelocity;
                Utils.postInvalidateOnAnimation(this.mChart);
            }
            int i = this.mTouchMode;
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                ((BarLineChartBase) this.mChart).calculateOffsets();
                ((BarLineChartBase) this.mChart).postInvalidate();
            }
            this.mTouchMode = 0;
            ((BarLineChartBase) this.mChart).enableScroll();
            VelocityTracker velocityTracker3 = this.i;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.i = null;
            }
            endAction(motionEvent);
        } else if (action == 2) {
            int i2 = this.mTouchMode;
            if (i2 == 1) {
                ((BarLineChartBase) this.mChart).disableScroll();
                e(motionEvent, ((BarLineChartBase) this.mChart).isDragXEnabled() ? motionEvent.getX() - this.c.x : 0.0f, ((BarLineChartBase) this.mChart).isDragYEnabled() ? motionEvent.getY() - this.c.y : 0.0f);
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                ((BarLineChartBase) this.mChart).disableScroll();
                if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    g(motionEvent);
                }
            } else if (i2 == 0 && Math.abs(ChartTouchListener.distance(motionEvent.getX(), this.c.x, motionEvent.getY(), this.c.y)) > this.m && ((BarLineChartBase) this.mChart).isDragEnabled()) {
                if (!((BarLineChartBase) this.mChart).isFullyZoomedOut() || !((BarLineChartBase) this.mChart).hasNoDragOffset()) {
                    float fAbs = Math.abs(motionEvent.getX() - this.c.x);
                    float fAbs2 = Math.abs(motionEvent.getY() - this.c.y);
                    if ((((BarLineChartBase) this.mChart).isDragXEnabled() || fAbs2 >= fAbs) && (((BarLineChartBase) this.mChart).isDragYEnabled() || fAbs2 <= fAbs)) {
                        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                        this.mTouchMode = 1;
                    }
                } else if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                    if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                        f(motionEvent);
                    }
                }
            }
        } else if (action == 3) {
            this.mTouchMode = 0;
            endAction(motionEvent);
        } else if (action != 5) {
            if (action == 6) {
                Utils.velocityTrackerPointerUpCleanUpIfNecessary(motionEvent, this.i);
                this.mTouchMode = 5;
            }
        } else if (motionEvent.getPointerCount() >= 2) {
            ((BarLineChartBase) this.mChart).disableScroll();
            h(motionEvent);
            this.e = a(motionEvent);
            this.f = b(motionEvent);
            float fI = i(motionEvent);
            this.g = fI;
            if (fI > 10.0f) {
                if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                    this.mTouchMode = 4;
                } else if (((BarLineChartBase) this.mChart).isScaleXEnabled() != ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mTouchMode = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? 2 : 3;
                } else {
                    this.mTouchMode = this.e > this.f ? 2 : 3;
                }
            }
            d(this.d, motionEvent);
        }
        this.a = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.a, this.mChart, true);
        return true;
    }

    public void setDragTriggerDist(float f) {
        this.m = Utils.convertDpToPixel(f);
    }

    public void stopDeceleration() {
        MPPointF mPPointF = this.l;
        mPPointF.x = 0.0f;
        mPPointF.y = 0.0f;
    }
}
