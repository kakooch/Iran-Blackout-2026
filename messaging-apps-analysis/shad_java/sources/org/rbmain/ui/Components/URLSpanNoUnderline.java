package org.rbmain.ui.Components;

import android.net.Uri;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.TLObject;
import org.rbmain.ui.Components.TextStyleSpan;

/* loaded from: classes5.dex */
public class URLSpanNoUnderline extends URLSpan {
    public String label;
    private TLObject object;
    private TextStyleSpan.TextStyleRun style;

    public URLSpanNoUnderline(String str) {
        this(str, null);
    }

    public URLSpanNoUnderline(String str, TextStyleSpan.TextStyleRun textStyleRun) {
        super(str != null ? str.replace((char) 8238, ' ') : str);
        this.style = textStyleRun;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        String url = getURL();
        if (url.startsWith("@")) {
            Browser.openUrl(view.getContext(), Uri.parse("https://rubika.ir/" + url.substring(1)));
            return;
        }
        Browser.openUrl(view.getContext(), url);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i = textPaint.linkColor;
        int color = textPaint.getColor();
        super.updateDrawState(textPaint);
        TextStyleSpan.TextStyleRun textStyleRun = this.style;
        if (textStyleRun != null) {
            textStyleRun.applyStyle(textPaint);
        }
        textPaint.setUnderlineText(i == color);
    }

    public void setObject(TLObject tLObject) {
        this.object = tLObject;
    }

    public TLObject getObject() {
        return this.object;
    }
}
