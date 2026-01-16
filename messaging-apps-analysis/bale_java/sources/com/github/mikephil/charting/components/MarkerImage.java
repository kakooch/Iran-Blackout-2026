package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class MarkerImage implements IMarker {
    private Context a;
    private Drawable b;
    private WeakReference e;
    private MPPointF c = new MPPointF();
    private MPPointF d = new MPPointF();
    private FSize f = new FSize();
    private Rect g = new Rect();

    public MarkerImage(Context context, int i) {
        this.a = context;
        this.b = context.getResources().getDrawable(i, null);
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f, float f2) {
        if (this.b == null) {
            return;
        }
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f, f2);
        FSize fSize = this.f;
        float intrinsicWidth = fSize.width;
        float intrinsicHeight = fSize.height;
        if (intrinsicWidth == 0.0f) {
            intrinsicWidth = this.b.getIntrinsicWidth();
        }
        if (intrinsicHeight == 0.0f) {
            intrinsicHeight = this.b.getIntrinsicHeight();
        }
        this.b.copyBounds(this.g);
        Drawable drawable = this.b;
        Rect rect = this.g;
        int i = rect.left;
        int i2 = rect.top;
        drawable.setBounds(i, i2, ((int) intrinsicWidth) + i, ((int) intrinsicHeight) + i2);
        int iSave = canvas.save();
        canvas.translate(f + offsetForDrawingAtPoint.x, f2 + offsetForDrawingAtPoint.y);
        this.b.draw(canvas);
        canvas.restoreToCount(iSave);
        this.b.setBounds(this.g);
    }

    public Chart getChartView() {
        WeakReference weakReference = this.e;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return this.c;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffsetForDrawingAtPoint(float f, float f2) {
        Drawable drawable;
        Drawable drawable2;
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.d;
        mPPointF.x = offset.x;
        mPPointF.y = offset.y;
        Chart chartView = getChartView();
        FSize fSize = this.f;
        float intrinsicWidth = fSize.width;
        float intrinsicHeight = fSize.height;
        if (intrinsicWidth == 0.0f && (drawable2 = this.b) != null) {
            intrinsicWidth = drawable2.getIntrinsicWidth();
        }
        if (intrinsicHeight == 0.0f && (drawable = this.b) != null) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        MPPointF mPPointF2 = this.d;
        float f3 = mPPointF2.x;
        if (f + f3 < 0.0f) {
            mPPointF2.x = -f;
        } else if (chartView != null && f + intrinsicWidth + f3 > chartView.getWidth()) {
            this.d.x = (chartView.getWidth() - f) - intrinsicWidth;
        }
        MPPointF mPPointF3 = this.d;
        float f4 = mPPointF3.y;
        if (f2 + f4 < 0.0f) {
            mPPointF3.y = -f2;
        } else if (chartView != null && f2 + intrinsicHeight + f4 > chartView.getHeight()) {
            this.d.y = (chartView.getHeight() - f2) - intrinsicHeight;
        }
        return this.d;
    }

    public FSize getSize() {
        return this.f;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
    }

    public void setChartView(Chart chart) {
        this.e = new WeakReference(chart);
    }

    public void setOffset(MPPointF mPPointF) {
        this.c = mPPointF;
        if (mPPointF == null) {
            this.c = new MPPointF();
        }
    }

    public void setSize(FSize fSize) {
        this.f = fSize;
        if (fSize == null) {
            this.f = new FSize();
        }
    }

    public void setOffset(float f, float f2) {
        MPPointF mPPointF = this.c;
        mPPointF.x = f;
        mPPointF.y = f2;
    }
}
