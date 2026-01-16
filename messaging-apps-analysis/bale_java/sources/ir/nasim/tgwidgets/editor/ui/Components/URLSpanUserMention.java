package ir.nasim.tgwidgets.editor.ui.Components;

import android.text.TextPaint;
import android.view.View;
import ir.nasim.tgwidgets.editor.ui.Components.G;

/* loaded from: classes7.dex */
public class URLSpanUserMention extends URLSpanNoUnderline {
    private int e;
    private G.a f;

    public URLSpanUserMention(String str, int i, G.a aVar) {
        super(str);
        this.e = i;
        this.f = aVar;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.URLSpanNoUnderline, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i = this.e;
        if (i == 3) {
            textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.s5));
        } else if (i == 2) {
            textPaint.setColor(-1);
        } else if (i == 1) {
            textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ka));
        } else {
            textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ja));
        }
        G.a aVar = this.f;
        if (aVar != null) {
            aVar.a(textPaint);
        } else {
            textPaint.setUnderlineText(false);
        }
    }
}
