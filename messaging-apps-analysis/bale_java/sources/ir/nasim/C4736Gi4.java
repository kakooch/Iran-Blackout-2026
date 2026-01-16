package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.Gi4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4736Gi4 extends M23 {
    private final InterfaceC9173Yu3 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4736Gi4(BubbleTextView bubbleTextView) {
        super(bubbleTextView);
        AbstractC13042fc3.i(bubbleTextView, "progressTextView");
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Fi4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C4736Gi4.E(this.a);
            }
        });
    }

    private final Spannable B() {
        String string = x().getContext().getString(AbstractC12217eE5.money_request);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        Context context = x().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        int iB = OY0.b(context, AbstractC21139tA5.colorOnPrimary);
        Spannable spannableC = C(iB);
        if (spannableC != null) {
            spannableStringBuilder.append((CharSequence) spannableC);
            spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        }
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new C22749vl7(iB, AbstractC8943Xx1.c(JF5.g() ? -2 : -1)), spannableStringBuilder.length() - string.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        Context context2 = x().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        AbstractC17636nI6.h(spannableStringBuilder, OY0.b(context2, AbstractC21139tA5.bubble_background_icon), 6, 0, 0, 12, null);
        return spannableStringBuilder;
    }

    private final Spannable C(int i) {
        Context context = x().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        Drawable drawableD = AbstractC6713Oq7.d(context, KB5.money_request_icon, i);
        if (drawableD == null) {
            return null;
        }
        drawableD.setBounds(0, 0, AbstractC8943Xx1.c(20), AbstractC8943Xx1.c(20));
        C12109e33 c12109e33 = new C12109e33(drawableD, -((AbstractC8943Xx1.c(1) * 15) + 2));
        SpannableString spannableString = new SpannableString(Separators.SP);
        spannableString.setSpan(c12109e33, 0, spannableString.length(), 33);
        return spannableString;
    }

    private final Spannable D() {
        return (Spannable) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Spannable E(C4736Gi4 c4736Gi4) {
        AbstractC13042fc3.i(c4736Gi4, "this$0");
        return c4736Gi4.B();
    }

    @Override // ir.nasim.M23, ir.nasim.AbstractC6981Pu5
    public Spannable v(float f) {
        return D();
    }

    @Override // ir.nasim.M23
    protected void y(String str) {
        x().r(D());
    }
}
