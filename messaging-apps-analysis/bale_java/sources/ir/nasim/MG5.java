package ir.nasim;

import android.text.TextPaint;
import android.view.View;

/* loaded from: classes5.dex */
public final class MG5 extends AbstractC9643aJ3 {
    private final String a;
    private final boolean b;
    private InterfaceC14603iB2 c;
    private InterfaceC14603iB2 d;

    public MG5(String str, boolean z) {
        AbstractC13042fc3.i(str, "reactionCode");
        this.a = str;
        this.b = z;
    }

    @Override // ir.nasim.AbstractC9643aJ3
    public void a(View view) {
        InterfaceC14603iB2 interfaceC14603iB2 = this.d;
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(this.a, Boolean.valueOf(this.b));
        }
    }

    public final void b(InterfaceC14603iB2 interfaceC14603iB2) {
        this.c = interfaceC14603iB2;
    }

    public final void c(InterfaceC14603iB2 interfaceC14603iB2) {
        this.d = interfaceC14603iB2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        AbstractC13042fc3.i(view, "widget");
        InterfaceC14603iB2 interfaceC14603iB2 = this.c;
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(this.a, Boolean.valueOf(this.b));
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC13042fc3.i(textPaint, "ds");
    }
}
