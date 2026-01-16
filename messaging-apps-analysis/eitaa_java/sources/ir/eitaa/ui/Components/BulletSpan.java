package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* loaded from: classes3.dex */
public class BulletSpan implements LeadingMarginSpan {
    private final int mBulletRadius;
    private final int mColor;
    private final int mGapWidth;
    private final boolean mWantColor;

    public BulletSpan(int gapWidth, int color, int bulletRadius) {
        this(gapWidth, color, true, bulletRadius);
    }

    private BulletSpan(int gapWidth, int color, boolean wantColor, int bulletRadius) {
        this.mGapWidth = gapWidth;
        this.mBulletRadius = bulletRadius;
        this.mColor = color;
        this.mWantColor = wantColor;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return (this.mBulletRadius * 2) + this.mGapWidth;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        int color;
        if (((Spanned) text).getSpanStart(this) == start) {
            Paint.Style style = paint.getStyle();
            if (this.mWantColor) {
                color = paint.getColor();
                paint.setColor(this.mColor);
            } else {
                color = 0;
            }
            paint.setStyle(Paint.Style.FILL);
            if (layout != null) {
                bottom -= layout.getLineForOffset(start) != layout.getLineCount() + (-1) ? (int) layout.getSpacingAdd() : 0;
            }
            canvas.drawCircle(x + (dir * r7), (top + bottom) / 2.0f, this.mBulletRadius, paint);
            if (this.mWantColor) {
                paint.setColor(color);
            }
            paint.setStyle(style);
        }
    }
}
