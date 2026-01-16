package ir.nasim.tgwidgets.editor.ui.Components;

import android.gov.nist.core.Separators;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import ir.nasim.AbstractC11908dl0;
import ir.nasim.AbstractC12724f57;
import ir.nasim.tgwidgets.editor.ui.Components.G;

/* loaded from: classes7.dex */
public class URLSpanNoUnderline extends URLSpan {
    private boolean a;
    private G.a b;
    private AbstractC12724f57 c;
    public String d;

    public URLSpanNoUnderline(String str) {
        this(str, null);
    }

    public void a(AbstractC12724f57 abstractC12724f57) {
        this.c = abstractC12724f57;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        String url = getURL();
        if (!url.startsWith(Separators.AT)) {
            AbstractC11908dl0.h(view.getContext(), url);
            return;
        }
        AbstractC11908dl0.d(view.getContext(), Uri.parse("https://t.me/" + url.substring(1)));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i = textPaint.linkColor;
        int color = textPaint.getColor();
        super.updateDrawState(textPaint);
        G.a aVar = this.b;
        if (aVar != null) {
            aVar.a(textPaint);
        }
        textPaint.setUnderlineText(i == color && !this.a);
    }

    public URLSpanNoUnderline(String str, G.a aVar) {
        super(str != null ? str.replace((char) 8238, ' ') : str);
        this.a = false;
        this.b = aVar;
    }
}
