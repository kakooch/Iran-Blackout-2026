package ir.nasim;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import java.util.List;

/* renamed from: ir.nasim.lq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16769lq {
    private static final a a = new a();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [androidx.emoji2.text.e] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static final CharSequence a(String str, float f, C9348Zn7 c9348Zn7, List list, List list2, WH1 wh1, InterfaceC16978mB2 interfaceC16978mB2, boolean z) {
        CharSequence charSequenceU;
        C17847nf5 c17847nf5A;
        if (z && androidx.emoji2.text.e.k()) {
            C23283wf5 c23283wf5W = c9348Zn7.w();
            C24136y62 c24136y62D = (c23283wf5W == null || (c17847nf5A = c23283wf5W.a()) == null) ? null : C24136y62.d(c17847nf5A.b());
            charSequenceU = androidx.emoji2.text.e.c().u(str, 0, str.length(), Integer.MAX_VALUE, c24136y62D == null ? 0 : C24136y62.g(c24136y62D.j(), C24136y62.b.a()));
            AbstractC13042fc3.f(charSequenceU);
        } else {
            charSequenceU = str;
        }
        if (list.isEmpty() && list2.isEmpty() && AbstractC13042fc3.d(c9348Zn7.D(), C5477Jm7.c.a()) && C13193fo7.f(c9348Zn7.s()) == 0) {
            return charSequenceU;
        }
        Spannable spannableString = charSequenceU instanceof Spannable ? (Spannable) charSequenceU : new SpannableString(charSequenceU);
        if (AbstractC13042fc3.d(c9348Zn7.A(), C24525yl7.b.d())) {
            AbstractC15863kI6.v(spannableString, a, 0, str.length());
        }
        if (b(c9348Zn7) && c9348Zn7.t() == null) {
            AbstractC15863kI6.s(spannableString, c9348Zn7.s(), f, wh1);
        } else {
            C4888Gz3 c4888Gz3T = c9348Zn7.t();
            if (c4888Gz3T == null) {
                c4888Gz3T = C4888Gz3.d.a();
            }
            AbstractC15863kI6.r(spannableString, c9348Zn7.s(), f, wh1, c4888Gz3T);
        }
        AbstractC15863kI6.z(spannableString, c9348Zn7.D(), f, wh1);
        AbstractC15863kI6.x(spannableString, c9348Zn7, list, wh1, interfaceC16978mB2);
        AbstractC15863kI6.k(spannableString, list, f, wh1, c9348Zn7.D());
        AbstractC25047ze5.d(spannableString, list2, wh1);
        return spannableString;
    }

    public static final boolean b(C9348Zn7 c9348Zn7) {
        C17847nf5 c17847nf5A;
        C23283wf5 c23283wf5W = c9348Zn7.w();
        if (c23283wf5W == null || (c17847nf5A = c23283wf5W.a()) == null) {
            return false;
        }
        return c17847nf5A.c();
    }

    /* renamed from: ir.nasim.lq$a */
    public static final class a extends CharacterStyle {
        a() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }
    }
}
