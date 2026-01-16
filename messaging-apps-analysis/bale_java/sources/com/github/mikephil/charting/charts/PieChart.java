package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* loaded from: classes2.dex */
public class PieChart extends PieRadarChartBase<PieData> {
    private RectF m;
    protected float mMaxAngle;
    protected float mTransparentCircleRadiusPercent;
    private boolean n;
    private float[] o;
    private float[] p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private CharSequence u;
    private MPPointF v;
    private float w;
    private boolean x;
    private float y;
    private float z;

    public PieChart(Context context) {
        super(context);
        this.m = new RectF();
        this.n = true;
        this.o = new float[1];
        this.p = new float[1];
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = "";
        this.v = MPPointF.getInstance(0.0f, 0.0f);
        this.w = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.x = true;
        this.y = 100.0f;
        this.mMaxAngle = 360.0f;
        this.z = 0.0f;
    }

    private float b(float f, float f2) {
        return (f / f2) * this.mMaxAngle;
    }

    private void c() {
        int entryCount = ((PieData) this.mData).getEntryCount();
        if (this.o.length != entryCount) {
            this.o = new float[entryCount];
        } else {
            for (int i = 0; i < entryCount; i++) {
                this.o[i] = 0.0f;
            }
        }
        if (this.p.length != entryCount) {
            this.p = new float[entryCount];
        } else {
            for (int i2 = 0; i2 < entryCount; i2++) {
                this.p[i2] = 0.0f;
            }
        }
        float yValueSum = ((PieData) this.mData).getYValueSum();
        List<IPieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        float f = this.z;
        boolean z = f != 0.0f && ((float) entryCount) * f <= this.mMaxAngle;
        float[] fArr = new float[entryCount];
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < ((PieData) this.mData).getDataSetCount(); i4++) {
            IPieDataSet iPieDataSet = dataSets.get(i4);
            for (int i5 = 0; i5 < iPieDataSet.getEntryCount(); i5++) {
                float fB = b(Math.abs(iPieDataSet.getEntryForIndex(i5).getY()), yValueSum);
                if (z) {
                    float f4 = this.z;
                    float f5 = fB - f4;
                    if (f5 <= 0.0f) {
                        fArr[i3] = f4;
                        f2 += -f5;
                    } else {
                        fArr[i3] = fB;
                        f3 += f5;
                    }
                }
                this.o[i3] = fB;
                if (i3 == 0) {
                    this.p[i3] = fB;
                } else {
                    float[] fArr2 = this.p;
                    fArr2[i3] = fArr2[i3 - 1] + fB;
                }
                i3++;
            }
        }
        if (z) {
            for (int i6 = 0; i6 < entryCount; i6++) {
                float f6 = fArr[i6];
                float f7 = f6 - (((f6 - this.z) / f3) * f2);
                fArr[i6] = f7;
                if (i6 == 0) {
                    this.p[0] = fArr[0];
                } else {
                    float[] fArr3 = this.p;
                    fArr3[i6] = fArr3[i6 - 1] + f7;
                }
            }
            this.o = fArr;
        }
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        c();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData == 0) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        MPPointF centerOffsets = getCenterOffsets();
        float selectionShift = ((PieData) this.mData).getDataSet().getSelectionShift();
        RectF rectF = this.m;
        float f = centerOffsets.x;
        float f2 = centerOffsets.y;
        rectF.set((f - diameter) + selectionShift, (f2 - diameter) + selectionShift, (f + diameter) - selectionShift, (f2 + diameter) - selectionShift);
        MPPointF.recycleInstance(centerOffsets);
    }

    public float[] getAbsoluteAngles() {
        return this.p;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getInstance(this.m.centerX(), this.m.centerY());
    }

    public CharSequence getCenterText() {
        return this.u;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.v;
        return MPPointF.getInstance(mPPointF.x, mPPointF.y);
    }

    public float getCenterTextRadiusPercent() {
        return this.y;
    }

    public RectF getCircleBox() {
        return this.m;
    }

    public int getDataSetIndexForIndex(int i) {
        List<IPieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        for (int i2 = 0; i2 < dataSets.size(); i2++) {
            if (dataSets.get(i2).getEntryForXValue(i, Float.NaN) != null) {
                return i2;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.o;
    }

    public float getHoleRadius() {
        return this.w;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f) {
        float normalizedAngle = Utils.getNormalizedAngle(f - getRotationAngle());
        int i = 0;
        while (true) {
            float[] fArr = this.p;
            if (i >= fArr.length) {
                return -1;
            }
            if (fArr[i] > normalizedAngle) {
                return i;
            }
            i++;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] getMarkerPosition(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float holeRadius = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            holeRadius = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f = radius - holeRadius;
        float rotationAngle = getRotationAngle();
        float f2 = this.o[(int) highlight.getX()] / 2.0f;
        double d = f;
        float fCos = (float) ((Math.cos(Math.toRadians(((this.p[r11] + rotationAngle) - f2) * this.mAnimator.getPhaseY())) * d) + centerCircleBox.x);
        float fSin = (float) ((d * Math.sin(Math.toRadians(((rotationAngle + this.p[r11]) - f2) * this.mAnimator.getPhaseY()))) + centerCircleBox.y);
        MPPointF.recycleInstance(centerCircleBox);
        return new float[]{fCos, fSin};
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public float getMinAngleForSlices() {
        return this.z;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.m;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.m.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    public boolean isDrawCenterTextEnabled() {
        return this.x;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.n;
    }

    public boolean isDrawHoleEnabled() {
        return this.q;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.t;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.r;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.s;
    }

    public boolean needsHighlight(int i) {
        if (!valuesToHighlight()) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i2 >= highlightArr.length) {
                return false;
            }
            if (((int) highlightArr[i2].getX()) == i) {
                return true;
            }
            i2++;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == 0) {
            return;
        }
        this.mRenderer.drawData(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
        }
        this.mRenderer.drawExtras(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.u = "";
        } else {
            this.u = charSequence;
        }
    }

    public void setCenterTextColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i);
    }

    public void setCenterTextOffset(float f, float f2) {
        this.v.x = Utils.convertDpToPixel(f);
        this.v.y = Utils.convertDpToPixel(f2);
    }

    public void setCenterTextRadiusPercent(float f) {
        this.y = f;
    }

    public void setCenterTextSize(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.x = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.n = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.q = z;
    }

    public void setDrawRoundedSlices(boolean z) {
        this.t = z;
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.n = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.r = z;
    }

    public void setEntryLabelColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setColor(i);
    }

    public void setEntryLabelTextSize(float f) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(f));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTypeface(typeface);
    }

    public void setHoleColor(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.w = f;
    }

    public void setMaxAngle(float f) {
        if (f > 360.0f) {
            f = 360.0f;
        }
        if (f < 90.0f) {
            f = 90.0f;
        }
        this.mMaxAngle = f;
    }

    public void setMinAngleForSlices(float f) {
        float f2 = this.mMaxAngle;
        if (f > f2 / 2.0f) {
            f = f2 / 2.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.z = f;
    }

    public void setTransparentCircleAlpha(int i) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(i);
    }

    public void setTransparentCircleColor(int i) {
        Paint paintTransparentCircle = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int alpha = paintTransparentCircle.getAlpha();
        paintTransparentCircle.setColor(i);
        paintTransparentCircle.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.mTransparentCircleRadiusPercent = f;
    }

    public void setUsePercentValues(boolean z) {
        this.s = z;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new RectF();
        this.n = true;
        this.o = new float[1];
        this.p = new float[1];
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = "";
        this.v = MPPointF.getInstance(0.0f, 0.0f);
        this.w = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.x = true;
        this.y = 100.0f;
        this.mMaxAngle = 360.0f;
        this.z = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new RectF();
        this.n = true;
        this.o = new float[1];
        this.p = new float[1];
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = "";
        this.v = MPPointF.getInstance(0.0f, 0.0f);
        this.w = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.x = true;
        this.y = 100.0f;
        this.mMaxAngle = 360.0f;
        this.z = 0.0f;
    }
}
