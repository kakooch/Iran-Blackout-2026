package androidx.compose.ui.platform;

import android.view.ViewGroup;
import androidx.compose.ui.e;
import ir.nasim.AbstractC12000du3;
import ir.nasim.C19938rB7;
import ir.nasim.CK5;
import ir.nasim.EK5;
import ir.nasim.InterfaceC11379cu3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC6886Pk0;
import ir.nasim.SA2;

/* loaded from: classes2.dex */
final class n extends e.c implements InterfaceC6886Pk0 {
    private ViewGroup o;

    public n(ViewGroup viewGroup) {
        this.o = viewGroup;
    }

    @Override // ir.nasim.InterfaceC6886Pk0
    public Object q1(InterfaceC11379cu3 interfaceC11379cu3, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
        long jE = AbstractC12000du3.e(interfaceC11379cu3);
        CK5 ck5 = (CK5) sa2.invoke();
        CK5 ck5S = ck5 != null ? ck5.s(jE) : null;
        if (ck5S != null) {
            this.o.requestRectangleOnScreen(EK5.b(ck5S), false);
        }
        return C19938rB7.a;
    }

    public final void v2(ViewGroup viewGroup) {
        this.o = viewGroup;
    }
}
