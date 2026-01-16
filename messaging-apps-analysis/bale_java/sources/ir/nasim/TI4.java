package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* loaded from: classes5.dex */
public abstract class TI4 {
    public static final void b(final QI4 qi4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(qi4, "result");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1975849016);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(qi4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC9339Zm7.b(d(qi4, interfaceC22053ub1J, i2 & 14), androidx.compose.foundation.layout.q.k(androidx.compose.ui.e.a, C17784nZ1.q(36), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, new C9348Zn7(DX0.b(OY0.b((Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g()), AbstractC21139tA5.n200)), AbstractC13784go7.g(14), new C4593Fu2(400), (C3418Au2) null, (C3657Bu2) null, AbstractC19143pr.a(C6011Lu2.k()), (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, C6399Nk7.b.a(), 0, AbstractC13784go7.g(21), (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16613336, (ED1) null), interfaceC22053ub1J, 48, 0, 65532);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.SI4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return TI4.c(qi4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(QI4 qi4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(qi4, "$result");
        b(qi4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final String d(QI4 qi4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        String strC;
        AbstractC13042fc3.i(qi4, "result");
        interfaceC22053ub1.W(-934370901);
        if (qi4.a() >= 3 && qi4.b().size() >= 3) {
            interfaceC22053ub1.W(1510765629);
            if (JF5.j(((PI4) qi4.b().get(0)).c()) || JF5.j(((PI4) qi4.b().get(1)).c())) {
                interfaceC22053ub1.W(1510853700);
                strC = UY6.d(AbstractC12217eE5.on_boarding_contacts_in_bale_3, new Object[]{((PI4) qi4.b().get(0)).c(), ((PI4) qi4.b().get(1)).c(), GY6.a(String.valueOf(qi4.a() - 2))}, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1511041250);
                strC = UY6.d(AbstractC12217eE5.on_boarding_contacts_in_bale_3_2, new Object[]{((PI4) qi4.b().get(0)).c(), ((PI4) qi4.b().get(1)).c(), GY6.a(String.valueOf(qi4.a() - 2))}, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.Q();
        } else if (qi4.a() == 2 && qi4.b().size() == 2) {
            interfaceC22053ub1.W(1511292133);
            strC = UY6.d(AbstractC12217eE5.on_boarding_contacts_in_bale_2, new Object[]{((PI4) qi4.b().get(0)).c(), ((PI4) qi4.b().get(1)).c()}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (qi4.a() == 1 && qi4.b().size() == 1) {
            interfaceC22053ub1.W(1511472026);
            strC = UY6.d(AbstractC12217eE5.on_boarding_contacts_in_bale_1, new Object[]{((PI4) qi4.b().get(0)).c()}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(1511573551);
            strC = UY6.c(AbstractC12217eE5.on_boarding_contacts_in_bale_0, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return strC;
    }
}
