package ir.nasim.tgwidgets.editor.ui.Cells;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes7.dex */
public class EmptyCell extends FrameLayout {
    private int a;

    public EmptyCell(Context context) {
        this(context, 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(this.a, 1073741824));
    }

    public void setHeight(int i) {
        if (this.a != i) {
            this.a = i;
            requestLayout();
        }
    }

    public EmptyCell(Context context, int i) {
        super(context);
        this.a = i;
    }
}
