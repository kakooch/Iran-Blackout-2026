package ir.eitaa.ui.Cells;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class TextInfoCell extends FrameLayout {
    private TextView textView;

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void setText(String text) {
        this.textView.setText(text);
    }
}
