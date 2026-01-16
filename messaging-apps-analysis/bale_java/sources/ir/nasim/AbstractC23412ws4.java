package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ws4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23412ws4 {
    public static final void b(final SA2 sa2, final UA2 ua2, final InterfaceC10258bL6 interfaceC10258bL6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onBarClicked");
        AbstractC13042fc3.i(ua2, "onJoinCallClicked");
        AbstractC13042fc3.i(interfaceC10258bL6, "callBarStateFlow");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1360072371);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC10258bL6) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, (i2 >> 6) & 14, 7);
            C19406qI3.a("GroupCallCallBar", "consume call bar state " + c(interfaceC9664aL6C), new Object[0]);
            InterfaceC6009Lu0 interfaceC6009Lu0C = c(interfaceC9664aL6C);
            if (interfaceC6009Lu0C instanceof C6147Mj3) {
                interfaceC22053ub1J.W(-356907052);
                AbstractC6880Pj3.c(sa2, (C6147Mj3) interfaceC6009Lu0C, interfaceC22053ub1J, i2 & 14);
                interfaceC22053ub1J.Q();
            } else if (interfaceC6009Lu0C instanceof C24353yU) {
                interfaceC22053ub1J.W(-356904255);
                BU.c(ua2, (C24353yU) interfaceC6009Lu0C, interfaceC22053ub1J, (i2 >> 3) & 14);
                interfaceC22053ub1J.Q();
            } else if (interfaceC6009Lu0C instanceof C16943m76) {
                interfaceC22053ub1J.W(-356901132);
                AbstractC18716p76.c(sa2, (C16943m76) interfaceC6009Lu0C, interfaceC22053ub1J, i2 & 14);
                interfaceC22053ub1J.Q();
            } else if (interfaceC6009Lu0C instanceof C13947h53) {
                interfaceC22053ub1J.W(-356898537);
                AbstractC20496s65.c(sa2, (C13947h53) interfaceC6009Lu0C, interfaceC22053ub1J, i2 & 14);
                interfaceC22053ub1J.Q();
            } else if (interfaceC6009Lu0C instanceof C19266q35) {
                interfaceC22053ub1J.W(-356895720);
                I65.c(sa2, (C19266q35) interfaceC6009Lu0C, interfaceC22053ub1J, i2 & 14);
                interfaceC22053ub1J.Q();
            } else if (interfaceC6009Lu0C instanceof C7124Qj3) {
                interfaceC22053ub1J.W(-356892683);
                AbstractC7829Tj3.c(sa2, (C7124Qj3) interfaceC6009Lu0C, interfaceC22053ub1J, i2 & 14);
                interfaceC22053ub1J.Q();
            } else {
                if (!AbstractC13042fc3.d(interfaceC6009Lu0C, J03.a)) {
                    interfaceC22053ub1J.W(-356908436);
                    interfaceC22053ub1J.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1J.W(1821395590);
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.vs4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23412ws4.d(sa2, ua2, interfaceC10258bL6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InterfaceC6009Lu0 c(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC6009Lu0) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(SA2 sa2, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onBarClicked");
        AbstractC13042fc3.i(ua2, "$onJoinCallClicked");
        AbstractC13042fc3.i(interfaceC10258bL6, "$callBarStateFlow");
        b(sa2, ua2, interfaceC10258bL6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
