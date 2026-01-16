package ir.nasim;

import android.text.Spannable;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.Jk2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5454Jk2 extends AbstractC22597vW1 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final Spannable a;
    private final BubbleTextView b;

    /* renamed from: ir.nasim.Jk2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C5454Jk2(Spannable spannable, BubbleTextView bubbleTextView) {
        AbstractC13042fc3.i(spannable, "mimeType");
        AbstractC13042fc3.i(bubbleTextView, "progressTextView");
        this.a = spannable;
        this.b = bubbleTextView;
    }

    private final String v() {
        if (this.a.length() == 0) {
            return "";
        }
        return " - " + ((Object) this.a);
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        String strO = AbstractC7426Rr.a.o(interfaceC3346Am2.f() / 1024.0f);
        this.b.r(AbstractC17636nI6.i(strO + v()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        if (z) {
            return;
        }
        s(f, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        this.b.r(this.a);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void o(float f) {
        this.b.r(AbstractC17636nI6.i(AbstractC7426Rr.a.o(f) + v()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        String strO = aVar.o(f * f2);
        String strO2 = aVar.o(f2);
        this.b.r(AbstractC17636nI6.i(strO + " / " + strO2 + v()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void r(float f) {
        this.b.r(AbstractC17636nI6.i(AbstractC7426Rr.a.o(f) + v()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void t(float f) {
        String strO = AbstractC7426Rr.a.o(f);
        this.b.r(AbstractC17636nI6.i(strO + v()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void u(float f, float f2) {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        String strO = aVar.o(f * f2);
        String strO2 = aVar.o(f2);
        this.b.r(AbstractC17636nI6.i(strO + " / " + strO2 + v()));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
    }
}
