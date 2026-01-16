package ir.eitaa.ui.Components;

import android.text.TextPaint;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.TextStyleSpan;

/* loaded from: classes3.dex */
public class URLSpanBotCommand extends URLSpanNoUnderline {
    public static boolean enabled = true;
    public int currentType;
    private TextStyleSpan.TextStyleRun style;

    public URLSpanBotCommand(String url, int type) {
        this(url, type, null);
    }

    public URLSpanBotCommand(String url, int type, TextStyleSpan.TextStyleRun run) {
        super(url);
        this.currentType = type;
        this.style = run;
    }

    @Override // ir.eitaa.ui.Components.URLSpanNoUnderline, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint p) {
        super.updateDrawState(p);
        int i = this.currentType;
        if (i == 2) {
            p.setColor(-1);
        } else if (i == 1) {
            p.setColor(Theme.getColor(enabled ? "chat_messageLinkOut" : "chat_messageTextOut"));
        } else {
            p.setColor(Theme.getColor(enabled ? "chat_messageLinkIn" : "chat_messageTextIn"));
        }
        TextStyleSpan.TextStyleRun textStyleRun = this.style;
        if (textStyleRun != null) {
            textStyleRun.applyStyle(p);
        } else {
            p.setUnderlineText(false);
        }
    }
}
