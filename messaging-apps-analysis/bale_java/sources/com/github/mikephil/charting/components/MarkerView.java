package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class MarkerView extends RelativeLayout implements IMarker {
    private MPPointF a;
    private MPPointF b;
    private WeakReference c;

    public MarkerView(Context context, int i) {
        super(context);
        this.a = new MPPointF();
        this.b = new MPPointF();
        setupLayoutResource(i);
    }

    private void setupLayoutResource(int i) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f, float f2) {
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f, f2);
        int iSave = canvas.save();
        canvas.translate(f + offsetForDrawingAtPoint.x, f2 + offsetForDrawingAtPoint.y);
        draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public Chart getChartView() {
        WeakReference weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return this.a;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffsetForDrawingAtPoint(float f, float f2) {
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.b;
        mPPointF.x = offset.x;
        mPPointF.y = offset.y;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        MPPointF mPPointF2 = this.b;
        float f3 = mPPointF2.x;
        if (f + f3 < 0.0f) {
            mPPointF2.x = -f;
        } else if (chartView != null && f + width + f3 > chartView.getWidth()) {
            this.b.x = (chartView.getWidth() - f) - width;
        }
        MPPointF mPPointF3 = this.b;
        float f4 = mPPointF3.y;
        if (f2 + f4 < 0.0f) {
            mPPointF3.y = -f2;
        } else if (chartView != null && f2 + height + f4 > chartView.getHeight()) {
            this.b.y = (chartView.getHeight() - f2) - height;
        }
        return this.b;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setChartView(Chart chart) {
        this.c = new WeakReference(chart);
    }

    public void setOffset(MPPointF mPPointF) {
        this.a = mPPointF;
        if (mPPointF == null) {
            this.a = new MPPointF();
        }
    }

    public void setOffset(float f, float f2) {
        MPPointF mPPointF = this.a;
        mPPointF.x = f;
        mPPointF.y = f2;
    }
}
