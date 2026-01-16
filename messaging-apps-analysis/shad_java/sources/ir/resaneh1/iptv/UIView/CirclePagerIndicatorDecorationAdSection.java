package ir.resaneh1.iptv.UIView;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.fragment.home.sectionInfo.IndicatorCallback;

/* loaded from: classes3.dex */
public class CirclePagerIndicatorDecorationAdSection extends RecyclerView.ItemDecoration {
    private static final float DP = Resources.getSystem().getDisplayMetrics().density;
    private IndicatorCallback callback;
    private int columnCount;
    private final int mIndicatorHeight;
    private float mIndicatorItemLength;
    private float mIndicatorItemPadding;
    private final Interpolator mInterpolator;
    private final Paint mPaint;
    private int sizeList;
    private boolean isActive = true;
    private int colorActive = -10609235;
    private int colorInactive = -1;
    private boolean isRtlLayout = false;
    private boolean isInside = false;

    public void setInside(boolean z) {
        this.isInside = z;
    }

    public void setColorActive(int i) {
        this.colorActive = i;
    }

    public void setColorInactive(int i) {
        this.colorInactive = i;
    }

    public CirclePagerIndicatorDecorationAdSection() {
        float f = DP;
        this.mIndicatorHeight = (int) (16.0f * f);
        this.mIndicatorItemLength = 8.0f * f;
        this.mIndicatorItemPadding = f * 4.0f;
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        Paint paint = new Paint();
        this.mPaint = paint;
        this.columnCount = -1;
        this.sizeList = 1;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public void setCallback(IndicatorCallback indicatorCallback) {
        this.callback = indicatorCallback;
    }

    public void setColumn(int i) {
        this.columnCount = i;
    }

    public void setSizeList(int i) {
        this.sizeList = i;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        IndicatorCallback indicatorCallback = this.callback;
        if (indicatorCallback != null) {
            indicatorCallback.onDrawOver();
        }
        if (this.isActive) {
            drawOver(canvas, recyclerView, false);
        }
    }

    private int getItemCount(RecyclerView recyclerView) {
        int i = this.columnCount;
        return i == -1 ? recyclerView.getAdapter().getItemCount() : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawOver(android.graphics.Canvas r10, androidx.recyclerview.widget.RecyclerView r11, boolean r12) {
        /*
            r9 = this;
            int r7 = r9.getItemCount(r11)
            r0 = 2
            if (r7 >= r0) goto L8
            return
        L8:
            float r0 = r9.mIndicatorItemLength
            float r1 = (float) r7
            float r0 = r0 * r1
            r1 = 0
            int r2 = r7 + (-1)
            int r1 = java.lang.Math.max(r1, r2)
            float r1 = (float) r1
            float r2 = r9.mIndicatorItemPadding
            float r1 = r1 * r2
            float r0 = r0 + r1
            int r1 = r11.getWidth()
            float r1 = (float) r1
            float r1 = r1 - r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            int r3 = r11.getWidth()
            float r3 = (float) r3
            float r3 = r3 + r0
            float r3 = r3 / r2
            int r4 = r11.getHeight()
            float r4 = (float) r4
            int r5 = r9.mIndicatorHeight
            float r6 = (float) r5
            float r6 = r6 / r2
            float r4 = r4 - r6
            if (r12 == 0) goto L3d
            r12 = 0
            float r1 = (float) r5
            float r1 = r1 / r2
            r4 = r0
            r3 = r1
            r2 = 0
            goto L41
        L3d:
            r2 = r1
            r8 = r4
            r4 = r3
            r3 = r8
        L41:
            r9.drawInactiveIndicators(r10, r2, r3, r7)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r11 = r11.getLayoutManager()
            boolean r12 = r11 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r0 = -1
            if (r12 == 0) goto L56
            r12 = r11
            androidx.recyclerview.widget.LinearLayoutManager r12 = (androidx.recyclerview.widget.LinearLayoutManager) r12
            int r12 = r12.findFirstVisibleItemPosition()
        L54:
            r5 = r12
            goto L63
        L56:
            boolean r12 = r11 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r12 == 0) goto L62
            r12 = r11
            androidx.recyclerview.widget.GridLayoutManager r12 = (androidx.recyclerview.widget.GridLayoutManager) r12
            int r12 = r12.findFirstVisibleItemPosition()
            goto L54
        L62:
            r5 = -1
        L63:
            if (r5 != r0) goto L66
            return
        L66:
            android.view.View r11 = r11.findViewByPosition(r5)
            int r12 = r11.getLeft()
            int r11 = r11.getWidth()
            android.view.animation.Interpolator r1 = r9.mInterpolator
            int r12 = r12 * (-1)
            float r12 = (float) r12
            float r11 = (float) r11
            float r12 = r12 / r11
            float r6 = r1.getInterpolation(r12)
            r0 = r9
            r1 = r10
            r0.drawHighlights(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.UIView.CirclePagerIndicatorDecorationAdSection.drawOver(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, boolean):void");
    }

    private void drawInactiveIndicators(Canvas canvas, float f, float f2, int i) {
        this.mPaint.setColor(this.colorInactive);
        float f3 = this.mIndicatorItemLength + this.mIndicatorItemPadding;
        for (int i2 = 0; i2 < i; i2++) {
            float f4 = this.mIndicatorItemLength;
            canvas.drawCircle((f4 / 2.0f) + f, f2, f4 / 2.0f, this.mPaint);
            f += f3;
        }
    }

    private void drawHighlights(Canvas canvas, float f, float f2, float f3, int i, float f4, int i2) {
        this.mPaint.setColor(this.colorActive);
        float f5 = this.mIndicatorItemLength;
        float f6 = this.mIndicatorItemPadding;
        float f7 = f5 + f6;
        boolean z = this.isRtlLayout;
        float f8 = z ? (f3 - (((i / this.sizeList) + 1) * f7)) + f6 : (i * f7) + f;
        if (f4 == 0.0f) {
            canvas.drawCircle(f8 + (f5 / 2.0f), f2, f5 / 2.0f, this.mPaint);
        } else {
            canvas.drawCircle(f8 + ((z ? -1 : 1) * f7 * f4) + (f5 / 2.0f), f2, f5 / 2.0f, this.mPaint);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.isInside) {
            return;
        }
        rect.bottom = this.mIndicatorHeight + 4;
    }

    public void setRtlLayout(boolean z) {
        this.isRtlLayout = z;
    }

    public void setIndicatorItemSize(float f) {
        this.mIndicatorItemLength = f;
    }

    public void setIndicatorItemPadding(float f) {
        this.mIndicatorItemPadding = f;
    }

    public int getTotalWidth(RecyclerView recyclerView) {
        int itemCount = getItemCount(recyclerView);
        if (itemCount < 2) {
            return 0;
        }
        return (int) ((this.mIndicatorItemLength * itemCount) + (Math.max(0, itemCount - 1) * this.mIndicatorItemPadding));
    }

    public int getTotalHeight() {
        return this.mIndicatorHeight;
    }
}
