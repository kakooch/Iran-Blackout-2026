package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.S31;

/* loaded from: classes4.dex */
public final class S31 {
    public static final S31 a = new S31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(905671909, false, a.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c() {
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1, 6).r(), null, 2, null);
            C9348Zn7 c9348Zn7K = g10.d(interfaceC22053ub1, 6).k();
            C6399Nk7 c6399Nk7H = C6399Nk7.h(C6399Nk7.b.a());
            long jF = g10.a(interfaceC22053ub1, 6).F();
            interfaceC22053ub1.W(-102087648);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.R31
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S31.a.c();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC8342Vo1.c(7200000L, eVarD, c9348Zn7K, c6399Nk7H, jF, (SA2) objB, interfaceC22053ub1, 196608, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }
}
