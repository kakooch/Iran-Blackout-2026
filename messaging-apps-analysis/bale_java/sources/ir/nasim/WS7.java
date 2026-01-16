package ir.nasim;

import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;

/* loaded from: classes5.dex */
public final class WS7 extends OW1 implements InterfaceC20718sU7 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WS7(DocumentStateButton documentStateButton) {
        super(documentStateButton, Integer.valueOf(KB5.bubble_document_state_play), false, 4, null);
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
        v().c(w());
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void l(com.google.android.exoplayer2.E0 e0, float f) {
        AbstractC13042fc3.i(e0, "player");
        v().setVisibility(8);
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        v().c(w());
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void o(float f) {
        v().c(w());
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void p() {
        v().c(w());
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        v().c(w());
    }

    @Override // ir.nasim.OW1, ir.nasim.AbstractC22597vW1
    public void r(float f) {
        v().c(w());
    }
}
