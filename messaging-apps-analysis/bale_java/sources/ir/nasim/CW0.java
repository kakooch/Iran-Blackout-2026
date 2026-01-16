package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import ir.nasim.InterfaceC24357yU3;
import ir.nasim.core.markdown.code.ViewSourceCodeSpan;
import ir.nasim.features.root.RootActivity;

/* loaded from: classes4.dex */
public final class CW0 extends AbstractC16876m1 {

    static final class a implements InterfaceC24357yU3.c {
        a() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(InterfaceC24357yU3 interfaceC24357yU3, BW0 bw0) {
            AbstractC13042fc3.i(interfaceC24357yU3, "visitor");
            AbstractC13042fc3.i(bw0, "code");
            String strM = bw0.m();
            AbstractC13042fc3.h(strM, "getLiteral(...)");
            CW0.this.l(interfaceC24357yU3, AbstractC20762sZ6.n1(strM).toString());
        }
    }

    public static final class b extends ClickableSpan {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            Bundle bundle = new Bundle();
            bundle.putString("arg_short_text_title", this.a);
            bundle.putString("arg_short_text_content", this.b);
            RootActivity.INSTANCE.h(C5721Ko.a.d(), "action_open_short_text_preview_fragment", bundle);
        }
    }

    private final void k(InterfaceC24357yU3 interfaceC24357yU3, int i, String str, String str2) {
        C15272jI6 c15272jI6M = interfaceC24357yU3.m();
        AbstractC13042fc3.h(c15272jI6M, "builder(...)");
        c15272jI6M.d(str).j(new b(str, str2), i, c15272jI6M.length(), 33).d(Separators.SP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(InterfaceC24357yU3 interfaceC24357yU3, String str) {
        int length = interfaceC24357yU3.length();
        interfaceC24357yU3.m().d(Separators.SP);
        if (AbstractC20762sZ6.X(str, "[", false, 2, null) && AbstractC20762sZ6.X(str, "]", false, 2, null)) {
            m(interfaceC24357yU3, length + 1, str);
        } else {
            n(interfaceC24357yU3, length + 1, str);
        }
    }

    private final void m(InterfaceC24357yU3 interfaceC24357yU3, int i, String str) {
        if (!AbstractC20153rZ6.S(str, "[", false, 2, null)) {
            n(interfaceC24357yU3, i, str);
            return;
        }
        String strH1 = AbstractC20762sZ6.h1(AbstractC20762sZ6.Z0(str, "[", null, 2, null), "]", null, 2, null);
        String string = AbstractC20762sZ6.n1(AbstractC20762sZ6.Z0(str, "]", null, 2, null)).toString();
        if (AbstractC20762sZ6.n1(strH1).toString().length() == 0) {
            n(interfaceC24357yU3, i, str);
        } else {
            k(interfaceC24357yU3, i, strH1, string);
        }
    }

    private final void n(InterfaceC24357yU3 interfaceC24357yU3, int i, String str) {
        if (AbstractC20762sZ6.n0(str)) {
            interfaceC24357yU3.y(new C5693Kk7(str));
            return;
        }
        C15272jI6 c15272jI6M = interfaceC24357yU3.m();
        AbstractC13042fc3.h(c15272jI6M, "builder(...)");
        c15272jI6M.d("View Source Code");
        c15272jI6M.j(new ViewSourceCodeSpan(str), i, c15272jI6M.length(), 33);
        AbstractC13042fc3.f(c15272jI6M.j(new RelativeSizeSpan(1.1f), i, c15272jI6M.length(), 33));
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void i(InterfaceC24357yU3.b bVar) {
        AbstractC13042fc3.i(bVar, "builder");
        bVar.a(BW0.class, new a());
    }
}
