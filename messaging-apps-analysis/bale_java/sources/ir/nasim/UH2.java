package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* loaded from: classes5.dex */
public final class UH2 extends AbstractC6981Pu5 {
    private C8610Ws b;
    private final InterfaceC9173Yu3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UH2(final BubbleTextView bubbleTextView) {
        super(bubbleTextView);
        AbstractC13042fc3.i(bubbleTextView, "progressTextView");
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.TH2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return UH2.A(bubbleTextView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String A(BubbleTextView bubbleTextView) {
        AbstractC13042fc3.i(bubbleTextView, "$progressTextView");
        return bubbleTextView.getContext().getString(AbstractC12217eE5.media_Gif);
    }

    private final Spannable B(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        Context context = x().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AbstractC17636nI6.h(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.bubble_background_icon), 0, 0, 0, 14, null);
        return spannableStringBuilder;
    }

    private final String z() {
        return (String) this.c.getValue();
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        C8610Ws c8610Ws = this.b;
        if (c8610Ws != null) {
            c8610Ws.stop();
            c8610Ws.S(null);
        }
        this.b = null;
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        x().r(B(z()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        String strO = AbstractC7426Rr.a.o(f);
        x().r(B(strO + Separators.SP + z()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        x().r(B(z()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void o(float f) {
        String strO = AbstractC7426Rr.a.o(f);
        x().r(B(strO + Separators.SP + z()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        String strO = aVar.o(f * f2);
        String strO2 = aVar.o(f2);
        x().r(B(strO + " / " + strO2 + "  " + z()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void t(float f) {
        x().r(B(z()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void u(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        String strO = aVar.o(f * f2);
        String strO2 = aVar.o(f2);
        x().r(B(strO + " / " + strO2 + "  " + z()));
    }

    @Override // ir.nasim.AbstractC6981Pu5
    public Spannable v(float f) {
        String strO = AbstractC7426Rr.a.o(f);
        return B(strO + " / " + strO + "  " + z());
    }
}
