package ir.eitaa.ui.Components;

import android.text.TextPaint;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class URLSpanNoUnderlineBold extends URLSpanNoUnderline {
    public URLSpanNoUnderlineBold(String url) {
        super(url != null ? url.replace((char) 8238, ' ') : url);
    }

    @Override // ir.eitaa.ui.Components.URLSpanNoUnderline, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setTypeface(AndroidUtilities.getFontFamily(true));
        ds.setUnderlineText(false);
    }
}
