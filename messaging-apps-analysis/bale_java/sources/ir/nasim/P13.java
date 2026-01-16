package ir.nasim;

import android.content.Context;
import android.graphics.PorterDuff;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;

/* loaded from: classes5.dex */
public final class P13 extends OW1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P13(DocumentStateButton documentStateButton, int i) {
        super(documentStateButton, Integer.valueOf(i), false, 4, null);
        AbstractC13042fc3.i(documentStateButton, "documentStateButton");
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void a() {
        super.a();
        v().setVisibility(0);
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        super.d(interfaceC3346Am2);
        v().setVisibility(8);
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        super.n(c4512Fl2, f, j);
        DocumentStateButton documentStateButtonV = v();
        Context context = v().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        documentStateButtonV.setBackgroundColor(OY0.b(context, AbstractC21139tA5.bubble_background_icon), PorterDuff.Mode.MULTIPLY);
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void t(float f) {
        super.t(f);
        v().setVisibility(8);
    }
}
