package ir.eitaa.ui.Components;

import android.net.Uri;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.ui.Components.TextStyleSpan;

/* loaded from: classes3.dex */
public class URLSpanNoUnderline extends URLSpan {
    private TLObject object;
    private TextStyleSpan.TextStyleRun style;

    public URLSpanNoUnderline(String url) {
        this(url, null);
    }

    public URLSpanNoUnderline(String url, TextStyleSpan.TextStyleRun run) {
        super(url != null ? url.replace((char) 8238, ' ') : url);
        this.style = run;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        String url = getURL();
        if (url.startsWith("@")) {
            Browser.openUrl(widget.getContext(), Uri.parse("https://eitaa.com/" + url.substring(1)));
            return;
        }
        Browser.openUrl(widget.getContext(), url);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint p) {
        int i = p.linkColor;
        int color = p.getColor();
        super.updateDrawState(p);
        TextStyleSpan.TextStyleRun textStyleRun = this.style;
        if (textStyleRun != null) {
            textStyleRun.applyStyle(p);
        }
        p.setUnderlineText(i == color);
    }

    public void setObject(TLObject spanObject) {
        this.object = spanObject;
    }

    public TLObject getObject() {
        return this.object;
    }
}
