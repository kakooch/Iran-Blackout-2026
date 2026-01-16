package ir.nasim.tgwidgets.editor.ui.Components;

import android.text.TextPaint;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class URLSpanNoUnderlineBold extends URLSpanNoUnderline {
    public URLSpanNoUnderlineBold(String str) {
        super(str != null ? str.replace((char) 8238, ' ') : str);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.URLSpanNoUnderline, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        textPaint.setUnderlineText(false);
    }
}
