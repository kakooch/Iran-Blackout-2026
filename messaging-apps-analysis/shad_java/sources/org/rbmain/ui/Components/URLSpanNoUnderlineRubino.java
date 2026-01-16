package org.rbmain.ui.Components;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

/* loaded from: classes5.dex */
public class URLSpanNoUnderlineRubino extends URLSpan {
    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    public URLSpanNoUnderlineRubino(String str) {
        super(str);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
