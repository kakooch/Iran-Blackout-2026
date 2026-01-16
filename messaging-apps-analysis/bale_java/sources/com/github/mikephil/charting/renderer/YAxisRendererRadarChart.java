package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes2.dex */
public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart a;
    private Path b;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.b = new Path();
        this.a = radarChart;
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    protected void computeAxisValues(float f, float f2) {
        int i;
        float f3 = f;
        int labelCount = this.mAxis.getLabelCount();
        double dAbs = Math.abs(f2 - f3);
        if (labelCount == 0 || dAbs <= 0.0d || Double.isInfinite(dAbs)) {
            AxisBase axisBase = this.mAxis;
            axisBase.mEntries = new float[0];
            axisBase.mCenteredEntries = new float[0];
            axisBase.mEntryCount = 0;
            return;
        }
        double dRoundToNextSignificant = Utils.roundToNextSignificant(dAbs / labelCount);
        if (this.mAxis.isGranularityEnabled() && dRoundToNextSignificant < this.mAxis.getGranularity()) {
            dRoundToNextSignificant = this.mAxis.getGranularity();
        }
        double dRoundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(dRoundToNextSignificant)));
        if (((int) (dRoundToNextSignificant / dRoundToNextSignificant2)) > 5) {
            dRoundToNextSignificant = Math.floor(dRoundToNextSignificant2 * 10.0d);
        }
        boolean zIsCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled()) {
            float f4 = ((float) dAbs) / (labelCount - 1);
            AxisBase axisBase2 = this.mAxis;
            axisBase2.mEntryCount = labelCount;
            if (axisBase2.mEntries.length < labelCount) {
                axisBase2.mEntries = new float[labelCount];
            }
            for (int i2 = 0; i2 < labelCount; i2++) {
                this.mAxis.mEntries[i2] = f3;
                f3 += f4;
            }
        } else {
            double dCeil = dRoundToNextSignificant == 0.0d ? 0.0d : Math.ceil(f3 / dRoundToNextSignificant) * dRoundToNextSignificant;
            if (zIsCenterAxisLabelsEnabled) {
                dCeil -= dRoundToNextSignificant;
            }
            double dNextUp = dRoundToNextSignificant == 0.0d ? 0.0d : Utils.nextUp(Math.floor(f2 / dRoundToNextSignificant) * dRoundToNextSignificant);
            if (dRoundToNextSignificant != 0.0d) {
                i = zIsCenterAxisLabelsEnabled ? 1 : 0;
                for (double d = dCeil; d <= dNextUp; d += dRoundToNextSignificant) {
                    i++;
                }
            } else {
                i = zIsCenterAxisLabelsEnabled ? 1 : 0;
            }
            int i3 = i + 1;
            AxisBase axisBase3 = this.mAxis;
            axisBase3.mEntryCount = i3;
            if (axisBase3.mEntries.length < i3) {
                axisBase3.mEntries = new float[i3];
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (dCeil == 0.0d) {
                    dCeil = 0.0d;
                }
                this.mAxis.mEntries[i4] = (float) dCeil;
                dCeil += dRoundToNextSignificant;
            }
            labelCount = i3;
        }
        if (dRoundToNextSignificant < 1.0d) {
            this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(dRoundToNextSignificant));
        } else {
            this.mAxis.mDecimals = 0;
        }
        if (zIsCenterAxisLabelsEnabled) {
            AxisBase axisBase4 = this.mAxis;
            if (axisBase4.mCenteredEntries.length < labelCount) {
                axisBase4.mCenteredEntries = new float[labelCount];
            }
            float[] fArr = axisBase4.mEntries;
            float f5 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i5 = 0; i5 < labelCount; i5++) {
                AxisBase axisBase5 = this.mAxis;
                axisBase5.mCenteredEntries[i5] = axisBase5.mEntries[i5] + f5;
            }
        }
        AxisBase axisBase6 = this.mAxis;
        float[] fArr2 = axisBase6.mEntries;
        float f6 = fArr2[0];
        axisBase6.mAxisMinimum = f6;
        float f7 = fArr2[labelCount - 1];
        axisBase6.mAxisMaximum = f7;
        axisBase6.mAxisRange = Math.abs(f7 - f6);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            MPPointF centerOffsets = this.a.getCenterOffsets();
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            float factor = this.a.getFactor();
            int i = this.mYAxis.isDrawTopYLabelEntryEnabled() ? this.mYAxis.mEntryCount : this.mYAxis.mEntryCount - 1;
            for (int i2 = !this.mYAxis.isDrawBottomYLabelEntryEnabled() ? 1 : 0; i2 < i; i2++) {
                YAxis yAxis = this.mYAxis;
                Utils.getPosition(centerOffsets, (yAxis.mEntries[i2] - yAxis.mAxisMinimum) * factor, this.a.getRotationAngle(), mPPointF);
                canvas.drawText(this.mYAxis.getFormattedLabel(i2), mPPointF.x + 10.0f, mPPointF.y, this.mAxisLabelPaint);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines == null) {
            return;
        }
        float sliceAngle = this.a.getSliceAngle();
        float factor = this.a.getFactor();
        MPPointF centerOffsets = this.a.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i = 0; i < limitLines.size(); i++) {
            LimitLine limitLine = limitLines.get(i);
            if (limitLine.isEnabled()) {
                this.mLimitLinePaint.setColor(limitLine.getLineColor());
                this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                float limit = (limitLine.getLimit() - this.a.getYChartMin()) * factor;
                Path path = this.b;
                path.reset();
                for (int i2 = 0; i2 < ((RadarData) this.a.getData()).getMaxEntryCountSet().getEntryCount(); i2++) {
                    Utils.getPosition(centerOffsets, limit, (i2 * sliceAngle) + this.a.getRotationAngle(), mPPointF);
                    if (i2 == 0) {
                        path.moveTo(mPPointF.x, mPPointF.y);
                    } else {
                        path.lineTo(mPPointF.x, mPPointF.y);
                    }
                }
                path.close();
                canvas.drawPath(path, this.mLimitLinePaint);
            }
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }
}
