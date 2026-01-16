package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
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
        this.paint.setColor(Theme.getColor("windowBackgroundWhiteHintText"));
    }

    public String getHintText() {
        return this.hintText;
    }

    public void setHintText(String value) {
        this.hintText = value;
        onTextChange();
        setText(getText());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        onTextChange();
    }

    public void onTextChange() {
        this.textOffset = length() > 0 ? getPaint().measureText(getText(), 0, length()) : 0.0f;
        this.spaceSize = getPaint().measureText(" ");
        this.numberSize = getPaint().measureText("1");
        invalidate();
    }

    @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
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
