package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: ir.nasim.f44, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12711f44 extends ClickableSpan {
    private final String a;
    private final int b;

    public C12711f44(String str, int i) {
        AbstractC13042fc3.i(str, "displayName");
        this.a = str;
        this.b = i;
    }

    public final String a() {
        return "[" + this.a + "](uid:" + this.b + Separators.RPAREN;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        AbstractC13042fc3.i(view, "widget");
        C18987pb3.a.T1(Integer.valueOf(this.b));
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC13042fc3.i(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(C5495Jo7.a.h1());
        textPaint.setUnderlineText(false);
    }
}
