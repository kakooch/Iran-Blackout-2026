package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class HashtagSearchCell extends TextView {
    private boolean needDivider;

    public HashtagSearchCell(Context context) {
        super(context);
        setGravity(16);
        setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        setTextSize(1, 17.0f);
        setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
    }

    public void setNeedDivider(boolean value) {
        this.needDivider = value;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(48.0f) + 1);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.needDivider) {
            canvas.drawLine(0.0f, getHeight() - 1, getWidth(), getHeight() - 1, Theme.dividerPaint);
        }
    }
}
