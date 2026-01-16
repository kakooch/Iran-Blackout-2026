package ir.nasim;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes6.dex */
public final class H46 extends BarChartRenderer {
    private final RectF b;
    private int c;
    private final Path d;

    public H46(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.b = new RectF();
        this.d = new Path();
    }

    private final void a(Canvas canvas, float f, float f2, float f3, float f4) {
        float f5 = (f3 - f) / 2;
        this.d.reset();
        this.d.addRoundRect(f, f2, f3, f4, new float[]{f5, f5, f5, f5, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        canvas.drawPath(this.d, this.mHighlightPaint);
    }

    private final Path b(RectF rectF, float f, float f2, boolean z, boolean z2, boolean z3, boolean z4) {
        float f3 = rectF.top;
        float f4 = rectF.left;
        float f5 = rectF.right;
        float f6 = rectF.bottom;
        Path path = new Path();
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f7 = f5 - f4;
        float f8 = f6 - f3;
        float f9 = 2;
        float f10 = f7 / f9;
        if (f > f10) {
            f = f10;
        }
        float f11 = f8 / f9;
        if (f2 > f11) {
            f2 = f11;
        }
        float f12 = f7 - (f9 * f);
        float f13 = f8 - (f9 * f2);
        path.moveTo(f5, f3 + f2);
        if (z2) {
            float f14 = -f2;
            path.rQuadTo(0.0f, f14, -f, f14);
        } else {
            path.rLineTo(0.0f, -f2);
            path.rLineTo(-f, 0.0f);
        }
        path.rLineTo(-f12, 0.0f);
        if (z) {
            float f15 = -f;
            path.rQuadTo(f15, 0.0f, f15, f2);
        } else {
            path.rLineTo(-f, 0.0f);
            path.rLineTo(0.0f, f2);
        }
        path.rLineTo(0.0f, f13);
        if (z4) {
            path.rQuadTo(0.0f, f2, f, f2);
        } else {
            path.rLineTo(0.0f, this.c + f2);
            path.rLineTo(f, 0.0f);
        }
        path.rLineTo(f12, 0.0f);
        if (z3) {
            path.rQuadTo(f, 0.0f, f, -f2);
        } else {
            path.rLineTo(f, 0.0f);
            path.rLineTo(0.0f, -f2);
        }
        path.rLineTo(0.0f, -f13);
        path.close();
        return path;
    }

    public final void c(int i) {
        this.c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        AbstractC13042fc3.i(canvas, "c");
        AbstractC13042fc3.i(iBarDataSet, "dataSet");
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
        boolean z = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            double dMin = Math.min(Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i2 = 0; i2 < dMin; i2++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i2)).getX();
                RectF rectF = this.b;
                rectF.left = x - barWidth;
                rectF.right = x + barWidth;
                transformer.rectValueToPixel(rectF);
                if (this.mViewPortHandler.isInBoundsLeft(this.b.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.b.left)) {
                        break;
                    }
                    this.b.top = this.mViewPortHandler.contentTop();
                    this.b.bottom = this.mViewPortHandler.contentBottom();
                    RectF rectF2 = this.mBarRect;
                    int i3 = this.c;
                    canvas.drawRoundRect(rectF2, i3, i3, this.mShadowPaint);
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
        int size = barBuffer.size() - 4;
        int iC = AbstractC16234kv5.c(size, 0, -4);
        if (iC > size) {
            return;
        }
        int i4 = size;
        while (true) {
            int i5 = i4 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i5])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i4])) {
                    return;
                }
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i4 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    Paint paint = this.mRenderPaint;
                    float[] fArr = barBuffer.buffer;
                    float f = fArr[i4];
                    paint.setShader(new LinearGradient(f, fArr[i4 + 3], f, fArr[i4 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.getGradientColors() != null) {
                    Paint paint2 = this.mRenderPaint;
                    float[] fArr2 = barBuffer.buffer;
                    float f2 = fArr2[i4];
                    float f3 = fArr2[i4 + 3];
                    float f4 = fArr2[i4 + 1];
                    int i6 = i4 / 4;
                    paint2.setShader(new LinearGradient(f2, f3, f2, f4, iBarDataSet.getGradientColor(i6).getStartColor(), iBarDataSet.getGradientColor(i6).getEndColor(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.buffer;
                int i7 = i4 + 1;
                int i8 = i4 + 3;
                RectF rectF3 = new RectF(fArr3[i4], fArr3[i7], fArr3[i5], fArr3[i8]);
                int i9 = this.c;
                canvas.drawPath(b(rectF3, i9, i9, true, true, false, false), this.mRenderPaint);
                if (z) {
                    float[] fArr4 = barBuffer.buffer;
                    RectF rectF4 = new RectF(fArr4[i4], fArr4[i7], fArr4[i5], fArr4[i8]);
                    int i10 = this.c;
                    canvas.drawPath(b(rectF4, i10, i10, true, true, false, false), this.mBarBorderPaint);
                }
            }
            if (i4 == iC) {
                return;
            } else {
                i4 -= 4;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y;
        float f;
        float f2;
        float f3;
        AbstractC13042fc3.i(canvas, "c");
        if (this.c <= 0) {
            super.drawHighlighted(canvas, highlightArr);
            return;
        }
        BarData barData = this.mChart.getBarData();
        AbstractC13042fc3.f(highlightArr);
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (!(highlight.getStackIndex() >= 0 && barEntry.isStacked())) {
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
                        RectF rectF = this.mBarRect;
                        a(canvas, rectF.left, rectF.top, rectF.right, rectF.bottom);
                    }
                    f2 = f;
                    f3 = y;
                    prepareBarHighlight(barEntry.getX(), f3, f2, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    RectF rectF2 = this.mBarRect;
                    a(canvas, rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
                }
            }
        }
    }
}
