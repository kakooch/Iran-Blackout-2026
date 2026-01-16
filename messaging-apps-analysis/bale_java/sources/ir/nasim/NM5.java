package ir.nasim;

/* loaded from: classes7.dex */
public final class NM5 implements InterfaceC20203rd1 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(NM5 nm5, boolean z, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(nm5, "$tmp0_rcvr");
        AbstractC13042fc3.i(ua2, "$onShowFragment");
        nm5.a(z, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20203rd1
    public void a(final boolean z, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        AbstractC13042fc3.i(ua2, "onShowFragment");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2060362149);
        if ((i & 1) == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.MM5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return NM5.c(this.a, z, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
