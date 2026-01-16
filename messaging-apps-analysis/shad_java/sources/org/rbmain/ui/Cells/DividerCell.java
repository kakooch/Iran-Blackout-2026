package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes4.dex */
public class DividerCell extends View {
    public DividerCell(Context context) {
        super(context);
        setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), getPaddingTop() + getPaddingBottom() + 1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getPaddingTop(), Theme.dividerPaint);
    }
}
