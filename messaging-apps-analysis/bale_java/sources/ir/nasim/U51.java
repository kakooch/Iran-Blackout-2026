package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.U51;
import ir.nasim.X03;

/* loaded from: classes4.dex */
public final class U51 {
    public static final U51 a = new U51();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1949163752, false, a.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f() {
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(-1681206976);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB == aVar2.a()) {
                objB = new SA2() { // from class: ir.nasim.S51
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return U51.a.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1681205792);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar2.a()) {
                objB2 = new SA2() { // from class: ir.nasim.T51
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return U51.a.f();
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            V03.c(aVar, "", null, sa2, (SA2) objB2, null, X03.b.b, interfaceC22053ub1, 1600566, 36);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }
}
