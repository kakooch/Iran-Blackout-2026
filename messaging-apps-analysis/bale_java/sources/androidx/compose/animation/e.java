package androidx.compose.animation;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC5999Lt;
import ir.nasim.C4414Fa3;
import ir.nasim.FV0;
import ir.nasim.IY7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC4788Go2;

/* loaded from: classes.dex */
public abstract class e {
    private static final long a;

    static {
        long j = RecyclerView.UNDEFINED_DURATION;
        a = C4414Fa3.c((j & 4294967295L) | (j << 32));
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC4788Go2 interfaceC4788Go2, InterfaceC14603iB2 interfaceC14603iB2) {
        return FV0.b(eVar).i(new SizeAnimationModifierElement(interfaceC4788Go2, InterfaceC12529em.a.o(), interfaceC14603iB2));
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC4788Go2 interfaceC4788Go2, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }
        if ((i & 2) != 0) {
            interfaceC14603iB2 = null;
        }
        return a(eVar, interfaceC4788Go2, interfaceC14603iB2);
    }

    public static final long c() {
        return a;
    }

    public static final boolean d(long j) {
        return !C4414Fa3.e(j, a);
    }
}
