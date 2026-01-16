package com.github.mikephil.charting.renderer;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes2.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    private RectF a;
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBarRect = new RectF();
        this.a = new RectF();
        this.mChart = barDataProvider;
        Paint paint = new Paint(1);
        this.mHighlightPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        Paint paint2 = new Paint(1);
        this.mShadowPaint = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.mBarBorderPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
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
                RectF rectF = this.a;
                rectF.left = x - barWidth;
                rectF.right = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.a.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.a.left)) {
                        break;
                    }
                    this.a.top = this.mViewPortHandler.contentTop();
                    this.a.bottom = this.mViewPortHandler.contentBottom();
                    canvas.drawRect(this.a, this.mShadowPaint);
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
            int i4 = i3 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i4])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i3])) {
                    return;
                }
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i3 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    float f = fArr[i3];
                    paint.setShader(new LinearGradient(f, fArr[i3 + 3], f, fArr[i3 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f2 = fArr2[i3];
                    float f3 = fArr2[i3 + 3];
                    float f4 = fArr2[i3 + 1];
                    int i5 = i3 / 4;
                    paint2.setShader(new LinearGradient(f2, f3, f2, f4, iBarDataSet.getGradientColor(i5).getStartColor(), iBarDataSet.getGradientColor(i5).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i6 = i3 + 1;
                int i7 = i3 + 3;
                canvas.drawRect(fArr3[i3], fArr3[i6], fArr3[i4], fArr3[i7], this.mRenderPaint);
                if (z) {
                    float[] fArr4 = barBuffer.buffer;
                    canvas.drawRect(fArr4[i3], fArr4[i6], fArr4[i4], fArr4[i7], this.mBarBorderPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y;
        float f;
        float f2;
        float f3;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() < 0 || !barEntry.isStacked()) {
                        y = barEntry.getY();
                        f = 0.0f;
                    } else if (this.mChart.isHighlightFullBarEnabled()) {
                        y = barEntry.getPositiveSum();
                        f = -barEntry.getNegativeSum();
                    } else {
                        Range range = barEntry.getRanges()[highlight.getStackIndex()];
                        f3 = range.from;
                        f2 = range.to;
                        prepareBarHighlight(barEntry.getX(), f3, f2, barData.getBarWidth() / 2.0f, transformer);
                        setHighlightDrawPos(highlight, this.mBarRect);
                        canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                    }
                    f2 = f;
                    f3 = y;
                    prepareBarHighlight(barEntry.getX(), f3, f2, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        MPPointF mPPointF;
        int i;
        float f;
        boolean z;
        float[] fArr;
        Transformer transformer;
        int i2;
        float f2;
        int i3;
        BarEntry barEntry;
        float[] fArr2;
        float f3;
        float f4;
        float f5;
        BarEntry barEntry2;
        float f6;
        boolean z2;
        int i4;
        ValueFormatter valueFormatter;
        List list2;
        MPPointF mPPointF2;
        BarEntry barEntry3;
        float f7;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean zIsDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i5 = 0;
            while (i5 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i5);
                if (shouldDrawValues(iBarDataSet)) {
                    applyValueTextStyle(iBarDataSet);
                    boolean zIsInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float fCalcTextHeight = Utils.calcTextHeight(this.mValuePaint, "8");
                    float f8 = zIsDrawValueAboveBarEnabled ? -fConvertDpToPixel : fCalcTextHeight + fConvertDpToPixel;
                    float f9 = zIsDrawValueAboveBarEnabled ? fCalcTextHeight + fConvertDpToPixel : -fConvertDpToPixel;
                    if (zIsInverted) {
                        f8 = (-f8) - fCalcTextHeight;
                        f9 = (-f9) - fCalcTextHeight;
                    }
                    float f10 = f8;
                    float f11 = f9;
                    BarBuffer barBuffer = this.mBarBuffers[i5];
                    float phaseY = this.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.x = Utils.convertDpToPixel(mPPointF3.x);
                    mPPointF3.y = Utils.convertDpToPixel(mPPointF3.y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        mPPointF = mPPointF3;
                        Transformer transformer2 = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i6 = 0;
                        int length = 0;
                        while (i6 < iBarDataSet.getEntryCount() * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry4 = (BarEntry) iBarDataSet.getEntryForIndex(i6);
                            float[] yVals = barEntry4.getYVals();
                            float[] fArr3 = barBuffer.buffer;
                            float f12 = (fArr3[length] + fArr3[length + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i6);
                            if (yVals != null) {
                                BarEntry barEntry5 = barEntry4;
                                i = i6;
                                f = fConvertDpToPixel;
                                z = zIsDrawValueAboveBarEnabled;
                                fArr = yVals;
                                transformer = transformer2;
                                float f13 = f12;
                                int length2 = fArr.length * 2;
                                float[] fArr4 = new float[length2];
                                float f14 = -barEntry5.getNegativeSum();
                                float f15 = 0.0f;
                                int i7 = 0;
                                int i8 = 0;
                                while (i7 < length2) {
                                    float f16 = fArr[i8];
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
                                    fArr4[i7 + 1] = f14 * phaseY;
                                    i7 += 2;
                                    i8++;
                                    f14 = f4;
                                }
                                transformer.pointValuesToPixel(fArr4);
                                int i9 = 0;
                                while (i9 < length2) {
                                    float f18 = fArr[i9 / 2];
                                    float f19 = fArr4[i9 + 1] + (((f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) == 0 && (f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1)) == 0 && (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1)) > 0) || (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) < 0 ? f11 : f10);
                                    int i10 = i9;
                                    if (!this.mViewPortHandler.isInBoundsRight(f13)) {
                                        break;
                                    }
                                    if (this.mViewPortHandler.isInBoundsY(f19) && this.mViewPortHandler.isInBoundsLeft(f13)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry6 = barEntry5;
                                            f3 = f19;
                                            i3 = i10;
                                            barEntry = barEntry6;
                                            fArr2 = fArr4;
                                            i2 = length2;
                                            f2 = f13;
                                            drawValue(canvas, valueFormatter2.getBarStackedLabel(f18, barEntry6), f13, f3, valueTextColor);
                                        } else {
                                            f3 = f19;
                                            i2 = length2;
                                            f2 = f13;
                                            i3 = i10;
                                            barEntry = barEntry5;
                                            fArr2 = fArr4;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon = barEntry.getIcon();
                                            Utils.drawImage(canvas, icon, (int) (f2 + mPPointF.x), (int) (f3 + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = length2;
                                        f2 = f13;
                                        i3 = i10;
                                        barEntry = barEntry5;
                                        fArr2 = fArr4;
                                    }
                                    i9 = i3 + 2;
                                    fArr4 = fArr2;
                                    barEntry5 = barEntry;
                                    length2 = i2;
                                    f13 = f2;
                                }
                            } else {
                                if (!this.mViewPortHandler.isInBoundsRight(f12)) {
                                    break;
                                }
                                int i11 = length + 1;
                                if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i11]) && this.mViewPortHandler.isInBoundsLeft(f12)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f5 = f12;
                                        f = fConvertDpToPixel;
                                        fArr = yVals;
                                        barEntry2 = barEntry4;
                                        i = i6;
                                        z = zIsDrawValueAboveBarEnabled;
                                        transformer = transformer2;
                                        drawValue(canvas, valueFormatter2.getBarLabel(barEntry4), f5, barBuffer.buffer[i11] + (barEntry4.getY() >= 0.0f ? f10 : f11), valueTextColor);
                                    } else {
                                        f5 = f12;
                                        i = i6;
                                        f = fConvertDpToPixel;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barEntry2 = barEntry4;
                                        transformer = transformer2;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon2 = barEntry2.getIcon();
                                        Utils.drawImage(canvas, icon2, (int) (mPPointF.x + f5), (int) (barBuffer.buffer[i11] + (barEntry2.getY() >= 0.0f ? f10 : f11) + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                    }
                                } else {
                                    transformer2 = transformer2;
                                    zIsDrawValueAboveBarEnabled = zIsDrawValueAboveBarEnabled;
                                    fConvertDpToPixel = fConvertDpToPixel;
                                    i6 = i6;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i6 = i + 1;
                            transformer2 = transformer;
                            zIsDrawValueAboveBarEnabled = z;
                            fConvertDpToPixel = f;
                        }
                    } else {
                        int i12 = 0;
                        while (i12 < barBuffer.buffer.length * this.mAnimator.getPhaseX()) {
                            float[] fArr5 = barBuffer.buffer;
                            float f20 = (fArr5[i12] + fArr5[i12 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f20)) {
                                break;
                            }
                            int i13 = i12 + 1;
                            if (this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i13]) && this.mViewPortHandler.isInBoundsLeft(f20)) {
                                int i14 = i12 / 4;
                                BarEntry barEntry7 = (BarEntry) iBarDataSet.getEntryForIndex(i14);
                                float y = barEntry7.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    String barLabel = valueFormatter2.getBarLabel(barEntry7);
                                    float[] fArr6 = barBuffer.buffer;
                                    barEntry3 = barEntry7;
                                    f7 = f20;
                                    i4 = i12;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                    float f21 = y >= 0.0f ? fArr6[i13] + f10 : fArr6[i12 + 3] + f11;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, barLabel, f7, f21, iBarDataSet.getValueTextColor(i14));
                                } else {
                                    barEntry3 = barEntry7;
                                    f7 = f20;
                                    i4 = i12;
                                    valueFormatter = valueFormatter2;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry3.getIcon();
                                    Utils.drawImage(canvas, icon3, (int) (f7 + mPPointF2.x), (int) ((y >= 0.0f ? barBuffer.buffer[i13] + f10 : barBuffer.buffer[i4 + 3] + f11) + mPPointF2.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i12;
                                valueFormatter = valueFormatter2;
                                list2 = dataSets;
                                mPPointF2 = mPPointF3;
                            }
                            i12 = i4 + 4;
                            mPPointF3 = mPPointF2;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                        }
                        list = dataSets;
                        mPPointF = mPPointF3;
                    }
                    f6 = fConvertDpToPixel;
                    z2 = zIsDrawValueAboveBarEnabled;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f6 = fConvertDpToPixel;
                    z2 = zIsDrawValueAboveBarEnabled;
                }
                i5++;
                zIsDrawValueAboveBarEnabled = z2;
                dataSets = list;
                fConvertDpToPixel = f6;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    protected void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f - f4, f2, f + f4, f3);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}
