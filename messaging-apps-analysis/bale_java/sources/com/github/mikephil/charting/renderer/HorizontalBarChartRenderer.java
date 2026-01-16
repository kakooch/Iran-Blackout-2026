package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes2.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF b;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.b = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        boolean z = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int iMin = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i2 = 0; i2 < iMin; i2++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i2)).getX();
                RectF rectF = this.b;
                rectF.top = x - barWidth;
                rectF.bottom = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsTop(this.b.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.b.top)) {
                        break;
                    }
                    this.b.left = this.mViewPortHandler.contentLeft();
                    this.b.right = this.mViewPortHandler.contentRight();
                    canvas.drawRect(this.b, this.mShadowPaint);
                }
            }
        }
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = iBarDataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        for (int i3 = 0; i3 < barBuffer.size(); i3 += 4) {
            int i4 = i3 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                return;
            }
            int i5 = i3 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i5])) {
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                float[] fArr = barBuffer.buffer;
                int i6 = i3 + 2;
                canvas.drawRect(fArr[i3], fArr[i5], fArr[i6], fArr[i4], this.mRenderPaint);
                if (z) {
                    float[] fArr2 = barBuffer.buffer;
                    canvas.drawRect(fArr2[i3], fArr2[i5], fArr2[i6], fArr2[i4], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        int i;
        MPPointF mPPointF;
        int i2;
        float f;
        float[] fArr;
        float f2;
        int i3;
        float[] fArr2;
        float f3;
        float f4;
        BarEntry barEntry;
        int i4;
        List list2;
        int i5;
        float f5;
        MPPointF mPPointF2;
        BarBuffer barBuffer;
        ValueFormatter valueFormatter;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean zIsDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i6);
                if (shouldDrawValues(iBarDataSet)) {
                    boolean zIsInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f6 = 2.0f;
                    float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, "10") / 2.0f;
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = this.mBarBuffers[i6];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.x = Utils.convertDpToPixel(mPPointF3.x);
                    mPPointF3.y = Utils.convertDpToPixel(mPPointF3.y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        i = i6;
                        mPPointF = mPPointF3;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i7 = 0;
                        int length = 0;
                        while (i7 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i7);
                            int valueTextColor = iBarDataSet.getValueTextColor(i7);
                            float[] yVals = barEntry2.getYVals();
                            if (yVals == null) {
                                int i8 = length + 1;
                                if (!this.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i8])) {
                                    break;
                                }
                                if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[length]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i8])) {
                                    String barLabel = valueFormatter2.getBarLabel(barEntry2);
                                    float fCalcTextWidth = Utils.calcTextWidth(this.mValuePaint, barLabel);
                                    float f7 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth + fConvertDpToPixel);
                                    float f8 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth + fConvertDpToPixel) : fConvertDpToPixel;
                                    if (zIsInverted) {
                                        f7 = (-f7) - fCalcTextWidth;
                                        f8 = (-f8) - fCalcTextWidth;
                                    }
                                    float f9 = f7;
                                    float f10 = f8;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        float f11 = barBuffer2.buffer[length + 2] + (barEntry2.getY() >= 0.0f ? f9 : f10);
                                        float f12 = barBuffer2.buffer[i8] + fCalcTextHeight;
                                        f = fCalcTextHeight;
                                        fArr = yVals;
                                        barEntry = barEntry2;
                                        i2 = i7;
                                        drawValue(canvas, barLabel, f11, f12, valueTextColor);
                                    } else {
                                        i2 = i7;
                                        f = fCalcTextHeight;
                                        fArr = yVals;
                                        barEntry = barEntry2;
                                    }
                                    if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon = barEntry.getIcon();
                                        float f13 = barBuffer2.buffer[length + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f9 = f10;
                                        }
                                        Utils.drawImage(canvas, icon, (int) (f13 + f9 + mPPointF.x), (int) (barBuffer2.buffer[i8] + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                i2 = i7;
                                f = fCalcTextHeight;
                                fArr = yVals;
                                int length2 = fArr.length * 2;
                                float[] fArr3 = new float[length2];
                                float f14 = -barEntry2.getNegativeSum();
                                float f15 = 0.0f;
                                int i9 = 0;
                                int i10 = 0;
                                while (i9 < length2) {
                                    float f16 = fArr[i10];
                                    if (f16 == 0.0f && (f15 == 0.0f || f14 == 0.0f)) {
                                        float f17 = f14;
                                        f14 = f16;
                                        f4 = f17;
                                    } else if (f16 >= 0.0f) {
                                        f15 += f16;
                                        f4 = f14;
                                        f14 = f15;
                                    } else {
                                        f4 = f14 - f16;
                                    }
                                    fArr3[i9] = f14 * phaseY;
                                    i9 += 2;
                                    i10++;
                                    f14 = f4;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i11 = 0;
                                while (i11 < length2) {
                                    float f18 = fArr[i11 / 2];
                                    String barStackedLabel = valueFormatter2.getBarStackedLabel(f18, barEntry2);
                                    float fCalcTextWidth2 = Utils.calcTextWidth(this.mValuePaint, barStackedLabel);
                                    float f19 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth2 + fConvertDpToPixel);
                                    int i12 = length2;
                                    float f20 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth2 + fConvertDpToPixel) : fConvertDpToPixel;
                                    if (zIsInverted) {
                                        f19 = (-f19) - fCalcTextWidth2;
                                        f20 = (-f20) - fCalcTextWidth2;
                                    }
                                    boolean z = (f18 == 0.0f && f14 == 0.0f && f15 > 0.0f) || f18 < 0.0f;
                                    float f21 = fArr3[i11];
                                    if (z) {
                                        f19 = f20;
                                    }
                                    float f22 = f21 + f19;
                                    float[] fArr4 = barBuffer2.buffer;
                                    float f23 = (fArr4[length + 1] + fArr4[length + 3]) / 2.0f;
                                    if (!this.mViewPortHandler.isInBoundsTop(f23)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsX(f22) && this.mViewPortHandler.isInBoundsBottom(f23)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            f2 = f23;
                                            i3 = i11;
                                            fArr2 = fArr3;
                                            f3 = f22;
                                            drawValue(canvas, barStackedLabel, f22, f23 + f, valueTextColor);
                                        } else {
                                            f2 = f23;
                                            i3 = i11;
                                            fArr2 = fArr3;
                                            f3 = f22;
                                        }
                                        if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry2.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f3 + mPPointF.x), (int) (f2 + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = i11;
                                        fArr2 = fArr3;
                                    }
                                    i11 = i3 + 2;
                                    length2 = i12;
                                    fArr3 = fArr2;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i7 = i2 + 1;
                            fCalcTextHeight = f;
                        }
                    } else {
                        int i13 = 0;
                        while (i13 < barBuffer2.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr5 = barBuffer2.buffer;
                            int i14 = i13 + 1;
                            float f24 = fArr5[i14];
                            float f25 = (fArr5[i13 + 3] + f24) / f6;
                            if (!this.mViewPortHandler.isInBoundsTop(f24)) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i13]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i14])) {
                                BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i13 / 4);
                                float y = barEntry3.getY();
                                String barLabel2 = valueFormatter2.getBarLabel(barEntry3);
                                float fCalcTextWidth3 = Utils.calcTextWidth(this.mValuePaint, barLabel2);
                                float f26 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth3 + fConvertDpToPixel);
                                float f27 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth3 + fConvertDpToPixel) : fConvertDpToPixel;
                                if (zIsInverted) {
                                    f26 = (-f26) - fCalcTextWidth3;
                                    f27 = (-f27) - fCalcTextWidth3;
                                }
                                float f28 = f26;
                                float f29 = f27;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    float f30 = barBuffer2.buffer[i13 + 2];
                                    float f31 = y >= 0.0f ? f28 : f29;
                                    i4 = i13;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                    f5 = f29;
                                    barBuffer = barBuffer2;
                                    i5 = i6;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, barLabel2, f30 + f31, f25 + fCalcTextHeight, iBarDataSet.getValueTextColor(i13 / 2));
                                } else {
                                    i4 = i13;
                                    list2 = dataSets;
                                    i5 = i6;
                                    f5 = f29;
                                    mPPointF2 = mPPointF3;
                                    barBuffer = barBuffer2;
                                    valueFormatter = valueFormatter2;
                                }
                                if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry3.getIcon();
                                    float f32 = barBuffer.buffer[i4 + 2];
                                    if (y < 0.0f) {
                                        f28 = f5;
                                    }
                                    Utils.drawImage(canvas, icon3, (int) (f32 + f28 + mPPointF2.x), (int) (f25 + mPPointF2.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i13;
                                barBuffer = barBuffer2;
                                list2 = dataSets;
                                i5 = i6;
                                mPPointF2 = mPPointF3;
                                valueFormatter = valueFormatter2;
                            }
                            i13 = i4 + 4;
                            mPPointF3 = mPPointF2;
                            valueFormatter2 = valueFormatter;
                            barBuffer2 = barBuffer;
                            dataSets = list2;
                            i6 = i5;
                            f6 = 2.0f;
                        }
                        list = dataSets;
                        i = i6;
                        mPPointF = mPPointF3;
                    }
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    i = i6;
                }
                i6 = i + 1;
                dataSets = list;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    protected boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f2, f - f4, f3, f + f4);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }
}
