package ir.nasim.tgwidgets.editor.ui.Components;

import android.text.TextPaint;
import ir.nasim.tgwidgets.editor.ui.Components.G;

/* loaded from: classes7.dex */
public class URLSpanBotCommand extends URLSpanNoUnderline {
    public static boolean g = true;
    public int e;
    private G.a f;

    public URLSpanBotCommand(String str, int i) {
        this(str, i, null);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.URLSpanNoUnderline, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i = this.e;
        if (i == 2) {
            textPaint.setColor(-1);
        } else if (i == 1) {
            textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(g ? ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ka : ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ia));
        } else {
            textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(g ? ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ja : ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ha));
        }
        G.a aVar = this.f;
        if (aVar != null) {
            aVar.a(textPaint);
        } else {
            textPaint.setUnderlineText(false);
        }
    }

    public URLSpanBotCommand(String str, int i, G.a aVar) {
        super(str);
        this.e = i;
        this.f = aVar;
    }
}
