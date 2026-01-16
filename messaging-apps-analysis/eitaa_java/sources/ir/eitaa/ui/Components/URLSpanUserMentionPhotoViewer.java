package ir.eitaa.ui.Components;

import android.text.TextPaint;

/* loaded from: classes3.dex */
public class URLSpanUserMentionPhotoViewer extends URLSpanUserMention {
    public URLSpanUserMentionPhotoViewer(String url, boolean isOutOwner) {
        super(url, 2);
    }

    @Override // ir.eitaa.ui.Components.URLSpanUserMention, ir.eitaa.ui.Components.URLSpanNoUnderline, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(-1);
        ds.setUnderlineText(false);
    }
}
