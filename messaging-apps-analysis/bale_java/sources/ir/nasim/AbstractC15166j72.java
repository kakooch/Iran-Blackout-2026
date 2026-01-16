package ir.nasim;

/* renamed from: ir.nasim.j72, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC15166j72 {
    public static final void b(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1041714316);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            ZH6.a(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.i(androidx.compose.ui.e.a, C17784nZ1.q(75)), 0.0f, 1, null), interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.i72
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC15166j72.c(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        b(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
