package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
    private MPPointF a;
    private float b;
    private ArrayList c;
    private long d;
    private float e;

    private class a {
        public long a;
        public float b;

        public a(long j, float f) {
            this.a = j;
            this.b = f;
        }
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
        this.a = MPPointF.getInstance(0.0f, 0.0f);
        this.b = 0.0f;
        this.c = new ArrayList();
        this.d = 0L;
        this.e = 0.0f;
    }

    private float a() {
        if (this.c.isEmpty()) {
            return 0.0f;
        }
        a aVar = (a) this.c.get(0);
        ArrayList arrayList = this.c;
        a aVar2 = (a) arrayList.get(arrayList.size() - 1);
        a aVar3 = aVar;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            aVar3 = (a) this.c.get(size);
            if (aVar3.b != aVar2.b) {
                break;
            }
        }
        float f = (aVar2.a - aVar.a) / 1000.0f;
        if (f == 0.0f) {
            f = 0.1f;
        }
        boolean z = aVar2.b >= aVar3.b;
        if (Math.abs(r1 - r6) > 270.0d) {
            z = !z;
        }
        float f2 = aVar2.b;
        float f3 = aVar.b;
        if (f2 - f3 > 180.0d) {
            aVar.b = (float) (f3 + 360.0d);
        } else if (f3 - f2 > 180.0d) {
            aVar2.b = (float) (f2 + 360.0d);
        }
        float fAbs = Math.abs((aVar2.b - aVar.b) / f);
        return !z ? -fAbs : fAbs;
    }

    private void b() {
        this.c.clear();
    }

    private void c(float f, float f2) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.c.add(new a(jCurrentAnimationTimeMillis, ((PieRadarChartBase) this.mChart).getAngleForPoint(f, f2)));
        for (int size = this.c.size(); size - 2 > 0 && jCurrentAnimationTimeMillis - ((a) this.c.get(0)).a > 1000; size--) {
            this.c.remove(0);
        }
    }

    public void computeScroll() {
        if (this.e == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.e *= ((PieRadarChartBase) this.mChart).getDragDecelerationFrictionCoef();
        T t = this.mChart;
        ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).getRotationAngle() + (this.e * ((jCurrentAnimationTimeMillis - this.d) / 1000.0f)));
        this.d = jCurrentAnimationTimeMillis;
        if (Math.abs(this.e) >= 0.001d) {
            Utils.postInvalidateOnAnimation(this.mChart);
        } else {
            stopDeceleration();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((PieRadarChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((PieRadarChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            android.view.GestureDetector r6 = r5.mGestureDetector
            boolean r6 = r6.onTouchEvent(r7)
            r0 = 1
            if (r6 == 0) goto La
            return r0
        La:
            T extends com.github.mikephil.charting.charts.Chart<?> r6 = r5.mChart
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            boolean r6 = r6.isRotationEnabled()
            if (r6 == 0) goto Lc2
            float r6 = r7.getX()
            float r1 = r7.getY()
            int r2 = r7.getAction()
            if (r2 == 0) goto La3
            if (r2 == r0) goto L6f
            r3 = 2
            if (r2 == r3) goto L29
            goto Lc2
        L29:
            T extends com.github.mikephil.charting.charts.Chart<?> r2 = r5.mChart
            com.github.mikephil.charting.charts.PieRadarChartBase r2 = (com.github.mikephil.charting.charts.PieRadarChartBase) r2
            boolean r2 = r2.isDragDecelerationEnabled()
            if (r2 == 0) goto L36
            r5.c(r6, r1)
        L36:
            int r2 = r5.mTouchMode
            r3 = 6
            if (r2 != 0) goto L5d
            com.github.mikephil.charting.utils.MPPointF r2 = r5.a
            float r4 = r2.x
            float r2 = r2.y
            float r2 = com.github.mikephil.charting.listener.ChartTouchListener.distance(r6, r4, r1, r2)
            r4 = 1090519040(0x41000000, float:8.0)
            float r4 = com.github.mikephil.charting.utils.Utils.convertDpToPixel(r4)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L5d
            com.github.mikephil.charting.listener.ChartTouchListener$ChartGesture r6 = com.github.mikephil.charting.listener.ChartTouchListener.ChartGesture.ROTATE
            r5.mLastGesture = r6
            r5.mTouchMode = r3
            T extends com.github.mikephil.charting.charts.Chart<?> r6 = r5.mChart
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            r6.disableScroll()
            goto L6b
        L5d:
            int r2 = r5.mTouchMode
            if (r2 != r3) goto L6b
            r5.updateGestureRotation(r6, r1)
            T extends com.github.mikephil.charting.charts.Chart<?> r6 = r5.mChart
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            r6.invalidate()
        L6b:
            r5.endAction(r7)
            goto Lc2
        L6f:
            T extends com.github.mikephil.charting.charts.Chart<?> r2 = r5.mChart
            com.github.mikephil.charting.charts.PieRadarChartBase r2 = (com.github.mikephil.charting.charts.PieRadarChartBase) r2
            boolean r2 = r2.isDragDecelerationEnabled()
            if (r2 == 0) goto L95
            r5.stopDeceleration()
            r5.c(r6, r1)
            float r6 = r5.a()
            r5.e = r6
            r1 = 0
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 == 0) goto L95
            long r1 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r5.d = r1
            T extends com.github.mikephil.charting.charts.Chart<?> r6 = r5.mChart
            com.github.mikephil.charting.utils.Utils.postInvalidateOnAnimation(r6)
        L95:
            T extends com.github.mikephil.charting.charts.Chart<?> r6 = r5.mChart
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            r6.enableScroll()
            r6 = 0
            r5.mTouchMode = r6
            r5.endAction(r7)
            goto Lc2
        La3:
            r5.startAction(r7)
            r5.stopDeceleration()
            r5.b()
            T extends com.github.mikephil.charting.charts.Chart<?> r7 = r5.mChart
            com.github.mikephil.charting.charts.PieRadarChartBase r7 = (com.github.mikephil.charting.charts.PieRadarChartBase) r7
            boolean r7 = r7.isDragDecelerationEnabled()
            if (r7 == 0) goto Lb9
            r5.c(r6, r1)
        Lb9:
            r5.setGestureStartAngle(r6, r1)
            com.github.mikephil.charting.utils.MPPointF r7 = r5.a
            r7.x = r6
            r7.y = r1
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.PieRadarChartTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setGestureStartAngle(float f, float f2) {
        this.b = ((PieRadarChartBase) this.mChart).getAngleForPoint(f, f2) - ((PieRadarChartBase) this.mChart).getRawRotationAngle();
    }

    public void stopDeceleration() {
        this.e = 0.0f;
    }

    public void updateGestureRotation(float f, float f2) {
        T t = this.mChart;
        ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).getAngleForPoint(f, f2) - this.b);
    }
}
