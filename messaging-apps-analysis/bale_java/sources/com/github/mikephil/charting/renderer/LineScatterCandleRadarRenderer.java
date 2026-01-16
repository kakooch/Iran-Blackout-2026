package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes2.dex */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {
    private Path a;

    public LineScatterCandleRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.a = new Path();
    }

    protected void drawHighlightLines(Canvas canvas, float f, float f2, ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet) {
        this.mHighlightPaint.setColor(iLineScatterCandleRadarDataSet.getHighLightColor());
        this.mHighlightPaint.setStrokeWidth(iLineScatterCandleRadarDataSet.getHighlightLineWidth());
        this.mHighlightPaint.setPathEffect(iLineScatterCandleRadarDataSet.getDashPathEffectHighlight());
        if (iLineScatterCandleRadarDataSet.isVerticalHighlightIndicatorEnabled()) {
            this.a.reset();
            this.a.moveTo(f, this.mViewPortHandler.contentTop());
            this.a.lineTo(f, this.mViewPortHandler.contentBottom());
            canvas.drawPath(this.a, this.mHighlightPaint);
        }
        if (iLineScatterCandleRadarDataSet.isHorizontalHighlightIndicatorEnabled()) {
            this.a.reset();
            this.a.moveTo(this.mViewPortHandler.contentLeft(), f2);
            this.a.lineTo(this.mViewPortHandler.contentRight(), f2);
            canvas.drawPath(this.a, this.mHighlightPaint);
        }
    }
}
