package ir.eitaa.ui.Components;

import android.content.Context;
import android.text.Layout;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class CorrectlyMeasuringTextView extends TextView {
    public CorrectlyMeasuringTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int wms, int hms) {
        super.onMeasure(wms, hms);
        try {
            Layout layout = getLayout();
            if (layout.getLineCount() <= 1) {
                return;
            }
            int iMax = 0;
            for (int lineCount = layout.getLineCount() - 1; lineCount >= 0; lineCount--) {
                iMax = Math.max(iMax, Math.round(layout.getPaint().measureText(getText(), layout.getLineStart(lineCount), layout.getLineEnd(lineCount))));
            }
            super.onMeasure(Math.min(iMax + getPaddingLeft() + getPaddingRight(), getMeasuredWidth()) | 1073741824, 1073741824 | getMeasuredHeight());
        } catch (Exception unused) {
        }
    }
}
