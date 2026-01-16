package ir.nasim;

/* loaded from: classes7.dex */
public final class PM5 implements InterfaceC9300Zi4 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(PM5 pm5, boolean z, boolean z2, C22642vb0 c22642vb0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(pm5, "$tmp0_rcvr");
        AbstractC13042fc3.i(c22642vb0, "$navigationCallbacks");
        pm5.a(z, z2, c22642vb0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC9300Zi4
    public void a(final boolean z, final boolean z2, final C22642vb0 c22642vb0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        AbstractC13042fc3.i(c22642vb0, "navigationCallbacks");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1054354172);
        if ((i & 1) == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.OM5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return PM5.c(this.a, z, z2, c22642vb0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
