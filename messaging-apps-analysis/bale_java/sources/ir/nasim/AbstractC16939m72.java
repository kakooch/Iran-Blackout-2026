package ir.nasim;

/* renamed from: ir.nasim.m72, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16939m72 {
    public static final void b(final QI4 qi4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(qi4, "result");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-224665743);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(qi4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11456d23.b(FV4.c(KB5.empty_contacts, interfaceC22053ub1J, 0), TI4.d(qi4, interfaceC22053ub1J, i2 & 14), null, null, null, 0.0f, null, interfaceC22053ub1J, 0, 124);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.l72
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16939m72.c(qi4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
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
}
