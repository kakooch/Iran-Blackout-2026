package ir.nasim;

import android.text.Spannable;

/* renamed from: ir.nasim.lI6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16454lI6 extends Spannable.Factory {
    public static final C16454lI6 a = new C16454lI6();

    private C16454lI6() {
    }

    @Override // android.text.Spannable.Factory
    public Spannable newSpannable(CharSequence charSequence) {
        Spannable spannable = charSequence instanceof Spannable ? (Spannable) charSequence : null;
        if (spannable != null) {
            return spannable;
        }
        Spannable spannableNewSpannable = super.newSpannable(charSequence);
        AbstractC13042fc3.h(spannableNewSpannable, "newSpannable(...)");
        return spannableNewSpannable;
    }
}
