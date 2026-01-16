package ir.nasim;

import ir.nasim.AbstractC10289bP1;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.pM5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18853pM5 {
    public static final void b(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(sa2, "startOnButtonClicked");
        AbstractC13042fc3.i(sa22, "endOnButtonClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1151872671);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            U81 u81 = U81.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC19555qZ.E(u81.a(), AbstractC10289bP1.b.c.b, u81.b(), AbstractC10289bP1.a.c.a, InterfaceC19114po0.b.a.a, sa2, ED5.contacts_refresh_positive_btn, InterfaceC19114po0.b.C1454b.a, sa22, ED5.contacts_refresh_negative_btn, null, interfaceC22053ub1J, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | ((i2 << 15) & 458752) | (InterfaceC19114po0.b.C1454b.b << 21) | ((i2 << 21) & 234881024), 0, 1024);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.oM5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18853pM5.c(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$startOnButtonClicked");
        AbstractC13042fc3.i(sa22, "$endOnButtonClicked");
        b(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
