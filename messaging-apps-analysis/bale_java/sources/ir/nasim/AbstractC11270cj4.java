package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC11270cj4;

/* renamed from: ir.nasim.cj4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC11270cj4 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(new SA2() { // from class: ir.nasim.aj4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AbstractC11270cj4.b();
        }
    });

    /* renamed from: ir.nasim.cj4$a */
    static final class a implements InterfaceC9300Zi4 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(a aVar, boolean z, boolean z2, C22642vb0 c22642vb0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(aVar, "$tmp0_rcvr");
            AbstractC13042fc3.i(c22642vb0, "$$unused$var$$2");
            aVar.a(z, z2, c22642vb0, interfaceC22053ub1, QJ5.a(i | 1));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC9300Zi4
        public final void a(final boolean z, final boolean z2, final C22642vb0 c22642vb0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
            int i2;
            AbstractC13042fc3.i(c22642vb0, "$unused$var$");
            InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1040375784);
            if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
                i2 = (interfaceC22053ub1J.V(this) ? 2048 : 1024) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 1025) == 1024 && interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.L();
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bj4
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC11270cj4.a.c(this.a, z, z2, c22642vb0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9300Zi4 b() {
        return a.a;
    }

    public static final AbstractC6535Nx5 c() {
        return a;
    }
}
