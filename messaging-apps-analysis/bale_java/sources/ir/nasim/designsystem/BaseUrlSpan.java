package ir.nasim.designsystem;

import android.text.TextPaint;
import android.text.style.URLSpan;
import ir.nasim.C5495Jo7;

/* loaded from: classes5.dex */
public abstract class BaseUrlSpan extends URLSpan {
    public BaseUrlSpan(String str) {
        super(str);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(C5495Jo7.a.h1());
        textPaint.setUnderlineText(false);
    }
}
