package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* loaded from: classes2.dex */
public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {
    private float[] b;
    private float[] c;
    private float[] d;
    private float[] e;
    private float[] f;
    protected CandleDataProvider mChart;

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.b = new float[8];
        this.c = new float[4];
        this.d = new float[4];
        this.e = new float[4];
        this.f = new float[4];
        this.mChart = candleDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getCandleData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, ICandleDataSet iCandleDataSet) {
        Transformer transformer = this.mChart.getTransformer(iCandleDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        float barSpace = iCandleDataSet.getBarSpace();
        boolean showCandleBar = iCandleDataSet.getShowCandleBar();
        this.mXBounds.set(this.mChart, iCandleDataSet);
        this.mRenderPaint.setStrokeWidth(iCandleDataSet.getShadowWidth());
        int i = this.mXBounds.min;
        while (true) {
            BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
            if (i > xBounds.range + xBounds.min) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex(i);
            if (candleEntry != null) {
                float x = candleEntry.getX();
                float open = candleEntry.getOpen();
                float close = candleEntry.getClose();
                float high = candleEntry.getHigh();
                float low = candleEntry.getLow();
                if (showCandleBar) {
                    float[] fArr = this.b;
                    fArr[0] = x;
                    fArr[2] = x;
                    fArr[4] = x;
                    fArr[6] = x;
                    if (open > close) {
                        fArr[1] = high * phaseY;
                        fArr[3] = open * phaseY;
                        fArr[5] = low * phaseY;
                        fArr[7] = close * phaseY;
                    } else if (open < close) {
                        fArr[1] = high * phaseY;
                        fArr[3] = close * phaseY;
                        fArr[5] = low * phaseY;
                        fArr[7] = open * phaseY;
                    } else {
                        fArr[1] = high * phaseY;
                        float f = open * phaseY;
                        fArr[3] = f;
                        fArr[5] = low * phaseY;
                        fArr[7] = f;
                    }
                    transformer.pointValuesToPixel(fArr);
                    if (!iCandleDataSet.getShadowColorSameAsCandle()) {
                        this.mRenderPaint.setColor(iCandleDataSet.getShadowColor() == 1122867 ? iCandleDataSet.getColor(i) : iCandleDataSet.getShadowColor());
                    } else if (open > close) {
                        this.mRenderPaint.setColor(iCandleDataSet.getDecreasingColor() == 1122867 ? iCandleDataSet.getColor(i) : iCandleDataSet.getDecreasingColor());
                    } else if (open < close) {
                        this.mRenderPaint.setColor(iCandleDataSet.getIncreasingColor() == 1122867 ? iCandleDataSet.getColor(i) : iCandleDataSet.getIncreasingColor());
                    } else {
                        this.mRenderPaint.setColor(iCandleDataSet.getNeutralColor() == 1122867 ? iCandleDataSet.getColor(i) : iCandleDataSet.getNeutralColor());
                    }
                    this.mRenderPaint.setStyle(Paint.Style.STROKE);
                    canvas.drawLines(this.b, this.mRenderPaint);
                    float[] fArr2 = this.c;
                    fArr2[0] = (x - 0.5f) + barSpace;
                    fArr2[1] = close * phaseY;
                    fArr2[2] = (x + 0.5f) - barSpace;
                    fArr2[3] = open * phaseY;
                    transformer.pointValuesToPixel(fArr2);
                    if (open > close) {
                        if (iCandleDataSet.getDecreasingColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet.getColor(i));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getDecreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getDecreasingPaintStyle());
                        float[] fArr3 = this.c;
                        canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.mRenderPaint);
                    } else if (open < close) {
                        if (iCandleDataSet.getIncreasingColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet.getColor(i));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getIncreasingColor());
                        }
                        this.mRenderPaint.setStyle(iCandleDataSet.getIncreasingPaintStyle());
                        float[] fArr4 = this.c;
                        canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.mRenderPaint);
                    } else {
                        if (iCandleDataSet.getNeutralColor() == 1122867) {
                            this.mRenderPaint.setColor(iCandleDataSet.getColor(i));
                        } else {
                            this.mRenderPaint.setColor(iCandleDataSet.getNeutralColor());
                        }
                        float[] fArr5 = this.c;
                        canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.mRenderPaint);
                    }
                } else {
                    float[] fArr6 = this.d;
                    fArr6[0] = x;
                    fArr6[1] = high * phaseY;
                    fArr6[2] = x;
                    fArr6[3] = low * phaseY;
                    float[] fArr7 = this.e;
                    fArr7[0] = (x - 0.5f) + barSpace;
                    float f2 = open * phaseY;
                    fArr7[1] = f2;
                    fArr7[2] = x;
                    fArr7[3] = f2;
                    float[] fArr8 = this.f;
                    fArr8[0] = (0.5f + x) - barSpace;
                    float f3 = close * phaseY;
                    fArr8[1] = f3;
                    fArr8[2] = x;
                    fArr8[3] = f3;
                    transformer.pointValuesToPixel(fArr6);
                    transformer.pointValuesToPixel(this.e);
                    transformer.pointValuesToPixel(this.f);
                    this.mRenderPaint.setColor(open > close ? iCandleDataSet.getDecreasingColor() == 1122867 ? iCandleDataSet.getColor(i) : iCandleDataSet.getDecreasingColor() : open < close ? iCandleDataSet.getIncreasingColor() == 1122867 ? iCandleDataSet.getColor(i) : iCandleDataSet.getIncreasingColor() : iCandleDataSet.getNeutralColor() == 1122867 ? iCandleDataSet.getColor(i) : iCandleDataSet.getNeutralColor());
                    float[] fArr9 = this.d;
                    canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.mRenderPaint);
                    float[] fArr10 = this.e;
                    canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.mRenderPaint);
                    float[] fArr11 = this.f;
                    canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.mRenderPaint);
                }
            }
            i++;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        CandleData candleData = this.mChart.getCandleData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ICandleDataSet) candleData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.isHighlightEnabled()) {
                CandleEntry candleEntry = (CandleEntry) iLineScatterCandleRadarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(candleEntry, iLineScatterCandleRadarDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iLineScatterCandleRadarDataSet.getAxisDependency()).getPixelForValues(candleEntry.getX(), ((candleEntry.getLow() * this.mAnimator.getPhaseY()) + (candleEntry.getHigh() * this.mAnimator.getPhaseY())) / 2.0f);
                    highlight.setDraw((float) pixelForValues.x, (float) pixelForValues.y);
                    drawHighlightLines(canvas, (float) pixelForValues.x, (float) pixelForValues.y, iLineScatterCandleRadarDataSet);
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
        ICandleDataSet iCandleDataSet;
        CandleEntry candleEntry;
        float f;
        if (isDrawingValuesAllowed(this.mChart)) {
            List<T> dataSets = this.mChart.getCandleData().getDataSets();
            for (int i = 0; i < dataSets.size(); i++) {
                ICandleDataSet iCandleDataSet2 = (ICandleDataSet) dataSets.get(i);
                if (shouldDrawValues(iCandleDataSet2) && iCandleDataSet2.getEntryCount() >= 1) {
                    applyValueTextStyle(iCandleDataSet2);
                    Transformer transformer = this.mChart.getTransformer(iCandleDataSet2.getAxisDependency());
                    this.mXBounds.set(this.mChart, iCandleDataSet2);
                    float phaseX = this.mAnimator.getPhaseX();
                    float phaseY = this.mAnimator.getPhaseY();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.mXBounds;
                    float[] fArrGenerateTransformedValuesCandle = transformer.generateTransformedValuesCandle(iCandleDataSet2, phaseX, phaseY, xBounds.min, xBounds.max);
                    float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
                    ValueFormatter valueFormatter = iCandleDataSet2.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iCandleDataSet2.getIconsOffset());
                    mPPointF.x = Utils.convertDpToPixel(mPPointF.x);
                    mPPointF.y = Utils.convertDpToPixel(mPPointF.y);
                    int i2 = 0;
                    while (i2 < fArrGenerateTransformedValuesCandle.length) {
                        float f2 = fArrGenerateTransformedValuesCandle[i2];
                        float f3 = fArrGenerateTransformedValuesCandle[i2 + 1];
                        if (!this.mViewPortHandler.isInBoundsRight(f2)) {
                            break;
                        }
                        if (this.mViewPortHandler.isInBoundsLeft(f2) && this.mViewPortHandler.isInBoundsY(f3)) {
                            int i3 = i2 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) iCandleDataSet2.getEntryForIndex(this.mXBounds.min + i3);
                            if (iCandleDataSet2.isDrawValuesEnabled()) {
                                candleEntry = candleEntry2;
                                f = f3;
                                iCandleDataSet = iCandleDataSet2;
                                drawValue(canvas, valueFormatter.getCandleLabel(candleEntry2), f2, f3 - fConvertDpToPixel, iCandleDataSet2.getValueTextColor(i3));
                            } else {
                                candleEntry = candleEntry2;
                                f = f3;
                                iCandleDataSet = iCandleDataSet2;
                            }
                            if (candleEntry.getIcon() != null && iCandleDataSet.isDrawIconsEnabled()) {
                                Drawable icon = candleEntry.getIcon();
                                Utils.drawImage(canvas, icon, (int) (f2 + mPPointF.x), (int) (f + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        } else {
                            iCandleDataSet = iCandleDataSet2;
                        }
                        i2 += 2;
                        iCandleDataSet2 = iCandleDataSet;
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }
}
