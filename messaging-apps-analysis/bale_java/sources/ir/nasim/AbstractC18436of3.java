package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.of3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18436of3 {
    public static final void c(final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1212423023);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            G10 g10 = G10.a;
            AbstractC9105Ym7.b(UY6.c(i, interfaceC22053ub1J, i3 & 14), androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1J, 6).y(), null, 2, null), C17784nZ1.q(16), C17784nZ1.q(8)), g10.a(interfaceC22053ub1J, 6).D(), AbstractC13784go7.g(15), null, null, M10.p(), 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 130992);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.nf3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18436of3.d(i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        c(i, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2045443818);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C16928m61.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mf3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18436of3.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
