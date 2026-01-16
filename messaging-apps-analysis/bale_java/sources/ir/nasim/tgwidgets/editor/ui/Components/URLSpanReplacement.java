package ir.nasim.tgwidgets.editor.ui.Components;

import android.net.Uri;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import ir.nasim.AbstractC11908dl0;
import ir.nasim.tgwidgets.editor.ui.Components.G;

/* loaded from: classes7.dex */
public class URLSpanReplacement extends URLSpan {
    private G.a a;

    public URLSpanReplacement(String str) {
        this(str, null);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        AbstractC11908dl0.d(view.getContext(), Uri.parse(getURL()));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int color = textPaint.getColor();
        super.updateDrawState(textPaint);
        G.a aVar = this.a;
        if (aVar != null) {
            aVar.a(textPaint);
            textPaint.setUnderlineText(textPaint.linkColor == color);
        }
    }

    public URLSpanReplacement(String str, G.a aVar) {
        super(str != null ? str.replace((char) 8238, ' ') : str);
        this.a = aVar;
    }
}
