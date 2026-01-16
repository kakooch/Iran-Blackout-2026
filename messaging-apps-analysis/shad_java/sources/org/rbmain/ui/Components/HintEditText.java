package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class HintEditText extends EditTextBoldCursor {
    private String hintText;
    private float numberSize;
    private Paint paint;
    private android.graphics.Rect rect;
    private float spaceSize;
    private float textOffset;

    public HintEditText(Context context) {
        super(context);
        this.paint = new Paint();
        this.rect = new android.graphics.Rect();
        this.paint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
    }

    public String getHintText() {
        return this.hintText;
    }

    public void setHintText(String str) {
        this.hintText = str;
        onTextChange();
        setText(getText());
    }

    @Override // org.rbmain.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        onTextChange();
    }

    public void onTextChange() {
        this.textOffset = length() > 0 ? getPaint().measureText(getText(), 0, length()) : 0.0f;
        this.spaceSize = getPaint().measureText(" ");
        this.numberSize = getPaint().measureText("1");
        invalidate();
    }

    @Override // org.rbmain.ui.Components.EditTextBoldCursor, org.rbmain.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException {
        float f;
        super.onDraw(canvas);
        if (this.hintText == null || length() >= this.hintText.length()) {
            return;
        }
        int measuredHeight = getMeasuredHeight() / 2;
        float f2 = this.textOffset;
        for (int length = length(); length < this.hintText.length(); length++) {
            if (this.hintText.charAt(length) == ' ') {
                f = this.spaceSize;
            } else {
                this.rect.set(((int) f2) + AndroidUtilities.dp(1.0f), measuredHeight, ((int) (this.numberSize + f2)) - AndroidUtilities.dp(1.0f), AndroidUtilities.dp(2.0f) + measuredHeight);
                canvas.drawRect(this.rect, this.paint);
                f = this.numberSize;
            }
            f2 += f;
        }
    }
}
