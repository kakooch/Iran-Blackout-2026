package ir.nasim;

import ir.nasim.AbstractC22073ud1;

/* renamed from: ir.nasim.ud1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22073ud1 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(new SA2() { // from class: ir.nasim.sd1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AbstractC22073ud1.b();
        }
    });

    /* renamed from: ir.nasim.ud1$a */
    static final class a implements InterfaceC20203rd1 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(a aVar, boolean z, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(aVar, "$tmp0_rcvr");
            AbstractC13042fc3.i(ua2, "$$unused$var$$1");
            aVar.a(z, ua2, interfaceC22053ub1, QJ5.a(i | 1));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC20203rd1
        public final void a(final boolean z, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
            int i2;
            AbstractC13042fc3.i(ua2, "$unused$var$");
            InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1088302503);
            if ((i & 384) == 0) {
                i2 = (interfaceC22053ub1J.V(this) ? 256 : 128) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 129) == 128 && interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.L();
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.td1
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC22073ud1.a.c(this.a, z, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC20203rd1 b() {
        return a.a;
    }

    public static final AbstractC6535Nx5 c() {
        return a;
    }
}
