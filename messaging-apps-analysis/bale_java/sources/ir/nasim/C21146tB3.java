package ir.nasim;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import ir.nasim.C7158Qn1;
import ir.nasim.InterfaceC21991uU3;

/* renamed from: ir.nasim.tB3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C21146tB3 extends AbstractC16876m1 {
    private final int a;
    private final boolean b;

    /* renamed from: ir.nasim.tB3$a */
    class a implements InterfaceC21991uU3.a {
        a() {
        }

        @Override // ir.nasim.InterfaceC21991uU3.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C7158Qn1 c7158Qn1) {
            c7158Qn1.m(C21146tB3.this.b ? new b(C21146tB3.this.a) : new c(C21146tB3.this.a));
        }
    }

    /* renamed from: ir.nasim.tB3$b */
    private static class b extends c {
        b(int i) {
            super(i);
        }

        @Override // ir.nasim.C21146tB3.c
        protected boolean b(Spannable spannable, int i) {
            return AbstractC20543sB3.b(spannable, i);
        }
    }

    /* renamed from: ir.nasim.tB3$c */
    private static class c implements C7158Qn1.g {
        private final int a;

        c(int i) {
            this.a = i;
        }

        @Override // ir.nasim.C7158Qn1.g
        public void a(InterfaceC24357yU3 interfaceC24357yU3, String str, int i) {
            InterfaceC12254eI6 interfaceC12254eI6A = interfaceC24357yU3.r().a().a(C9452Zz3.class);
            if (interfaceC12254eI6A == null) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (b(spannableStringBuilder, this.a)) {
                URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
                if (uRLSpanArr == null || uRLSpanArr.length <= 0) {
                    return;
                }
                InterfaceC17689nO5 interfaceC17689nO5O = interfaceC24357yU3.o();
                C15272jI6 c15272jI6M = interfaceC24357yU3.m();
                for (URLSpan uRLSpan : uRLSpanArr) {
                    AbstractC7392Rn1.e.d(interfaceC17689nO5O, uRLSpan.getURL());
                    C15272jI6.k(c15272jI6M, interfaceC12254eI6A.a(interfaceC24357yU3.r(), interfaceC17689nO5O), spannableStringBuilder.getSpanStart(uRLSpan) + i, spannableStringBuilder.getSpanEnd(uRLSpan) + i);
                }
            }
        }

        protected boolean b(Spannable spannable, int i) {
            return Linkify.addLinks(spannable, i);
        }
    }

    C21146tB3(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public static C21146tB3 l() {
        return n(false);
    }

    public static C21146tB3 m(int i, boolean z) {
        return new C21146tB3(i, z);
    }

    public static C21146tB3 n(boolean z) {
        return m(7, z);
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void c(InterfaceC21991uU3.b bVar) {
        bVar.a(C7158Qn1.class, new a());
    }
}
