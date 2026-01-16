package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* loaded from: classes5.dex */
public class M23 extends AbstractC6981Pu5 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M23(BubbleTextView bubbleTextView) {
        super(bubbleTextView);
        AbstractC13042fc3.i(bubbleTextView, "progressTextView");
    }

    private final SpannableStringBuilder z(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        Context context = x().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AbstractC17636nI6.h(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.bubble_background_icon), 0, 0, 0, 14, null);
        return spannableStringBuilder;
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        y(null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        x().setContentDescription(x().getContext().getString(AbstractC12217eE5.item_not_downloaded_content_description));
        y(AbstractC7426Rr.a.o(f));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        y(null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void o(float f) {
        y(AbstractC7426Rr.a.o(f));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        x().setContentDescription(x().getContext().getString(AbstractC12217eE5.voice_downloading_content_description));
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        y(aVar.o(f * f2) + " / " + aVar.o(f2));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void t(float f) {
        y(null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void u(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        y(aVar.o(f * f2) + " / " + aVar.o(f2));
    }

    @Override // ir.nasim.AbstractC6981Pu5
    public Spannable v(float f) {
        String strO = AbstractC7426Rr.a.o(f);
        return z(strO + " / " + strO);
    }

    protected void y(String str) {
        x().r(str != null ? z(str) : null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
    }
}
