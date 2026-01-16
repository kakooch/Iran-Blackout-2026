package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class DividerCell extends View {
    private boolean forceDarkTheme;
    private Paint paint;

    public DividerCell(Context context) {
        super(context);
        this.paint = new Paint();
        setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), getPaddingTop() + getPaddingBottom() + 1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.forceDarkTheme) {
            this.paint.setColor(ColorUtils.blendARGB(-16777216, Theme.getColor("voipgroup_dialogBackground"), 0.2f));
        } else {
            this.paint.setColor(Theme.getColor("divider"));
        }
        canvas.drawLine(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getPaddingTop(), this.paint);
    }

    public void setForceDarkTheme(boolean forceDarkTheme) {
        this.forceDarkTheme = forceDarkTheme;
    }
}
