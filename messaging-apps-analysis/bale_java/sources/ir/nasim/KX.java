package ir.nasim;

import ir.nasim.LX;

/* loaded from: classes4.dex */
public abstract class KX {
    /* JADX WARN: Removed duplicated region for block: B:122:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(androidx.compose.ui.e r23, ir.nasim.LX r24, ir.nasim.InterfaceC22053ub1 r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KX.f(androidx.compose.ui.e, ir.nasim.LX, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(final LX lx, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.JX
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(KX.h(lx));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(LX lx) {
        ((LX.a) lx).b().invoke(Boolean.valueOf(!r2.c()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(LX lx) {
        ((LX.a) lx).b().invoke(Boolean.valueOf(!r1.c()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(androidx.compose.ui.e eVar, LX lx, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        f(eVar, lx, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void k(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1467769152);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            f(null, new LX.a(true, null, false, 6, null), interfaceC22053ub1J, 0, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.FX
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return KX.l(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        k(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
