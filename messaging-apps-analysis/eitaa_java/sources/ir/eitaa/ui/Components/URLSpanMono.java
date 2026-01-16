package ir.eitaa.ui.Components;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.TextStyleSpan;

/* loaded from: classes3.dex */
public class URLSpanMono extends MetricAffectingSpan {
    private int currentEnd;
    private CharSequence currentMessage;
    private int currentStart;
    private byte currentType;
    private TextStyleSpan.TextStyleRun style;

    public URLSpanMono(CharSequence message, int start, int end, byte type, TextStyleSpan.TextStyleRun run) {
        this.currentMessage = message;
        this.currentStart = start;
        this.currentEnd = end;
        this.currentType = type;
        this.style = run;
    }

    public void copyToClipboard() {
        AndroidUtilities.addToClipboard(this.currentMessage.subSequence(this.currentStart, this.currentEnd).toString());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        p.setTextSize(AndroidUtilities.dp(SharedConfig.fontSize - 1));
        p.setFlags(p.getFlags() | 128);
        TextStyleSpan.TextStyleRun textStyleRun = this.style;
        if (textStyleRun != null) {
            textStyleRun.applyStyle(p);
        } else {
            p.setTypeface(Typeface.MONOSPACE);
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint p) {
        p.setTextSize(AndroidUtilities.dp(SharedConfig.fontSize - 1));
        byte b = this.currentType;
        if (b == 2) {
            p.setColor(-1);
        } else if (b == 1) {
            p.setColor(Theme.getColor("chat_messageTextOut"));
        } else {
            p.setColor(Theme.getColor("chat_messageTextIn"));
        }
        TextStyleSpan.TextStyleRun textStyleRun = this.style;
        if (textStyleRun != null) {
            textStyleRun.applyStyle(p);
        } else {
            p.setTypeface(Typeface.MONOSPACE);
            p.setUnderlineText(false);
        }
    }
}
