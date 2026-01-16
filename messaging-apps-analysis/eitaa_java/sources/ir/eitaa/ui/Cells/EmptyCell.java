package ir.eitaa.ui.Cells;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class EmptyCell extends FrameLayout {
    private int cellHeight;

    public EmptyCell(Context context) {
        this(context, 8);
    }

    public EmptyCell(Context context, int height) {
        super(context);
        this.cellHeight = height;
    }

    public void setHeight(int height) {
        if (this.cellHeight != height) {
            this.cellHeight = height;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(this.cellHeight, 1073741824));
    }
}
