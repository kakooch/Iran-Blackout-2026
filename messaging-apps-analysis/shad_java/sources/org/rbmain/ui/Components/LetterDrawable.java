package org.rbmain.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class LetterDrawable extends Drawable {
    private static TextPaint namePaint;
    public static Paint paint = new Paint();
    private RectF rect = new RectF();
    private StringBuilder stringBuilder = new StringBuilder(5);
    private float textHeight;
    private StaticLayout textLayout;
    private float textLeft;
    private float textWidth;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public LetterDrawable() {
        if (namePaint == null) {
            namePaint = new TextPaint(1);
        }
        namePaint.setTextSize(AndroidUtilities.dp(28.0f));
        paint.setColor(Theme.getColor(Theme.key_sharedMedia_linkPlaceholder));
        namePaint.setColor(Theme.getColor(Theme.key_sharedMedia_linkPlaceholderText));
    }

    public void setBackgroundColor(int i) {
        paint.setColor(i);
    }

    public void setColor(int i) {
        namePaint.setColor(i);
    }

    public void setTitle(String str) {
        this.stringBuilder.setLength(0);
        if (str != null && str.length() > 0) {
            this.stringBuilder.append(str.substring(0, 1));
        }
        if (this.stringBuilder.length() > 0) {
            try {
                StaticLayout staticLayout = new StaticLayout(this.stringBuilder.toString().toUpperCase(), namePaint, AndroidUtilities.dp(100.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.textLayout = staticLayout;
                if (staticLayout.getLineCount() > 0) {
                    this.textLeft = this.textLayout.getLineLeft(0);
                    this.textWidth = this.textLayout.getLineWidth(0);
                    this.textHeight = this.textLayout.getLineBottom(0);
                    return;
                }
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        this.textLayout = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        android.graphics.Rect bounds = getBounds();
        if (bounds == null) {
            return;
        }
        this.rect.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), paint);
        canvas.save();
        if (this.textLayout != null) {
            float fWidth = bounds.width();
            canvas.translate((bounds.left + ((fWidth - this.textWidth) / 2.0f)) - this.textLeft, bounds.top + ((fWidth - this.textHeight) / 2.0f));
            this.textLayout.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        namePaint.setAlpha(i);
        paint.setAlpha(i);
    }
}
