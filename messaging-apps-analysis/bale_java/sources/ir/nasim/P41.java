package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.P41;

/* loaded from: classes5.dex */
public final class P41 {
    public static final P41 a = new P41();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1578047021, false, a.a);

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
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            EV4 ev4C = FV4.c(AbstractC24188yB5.avatar_placeholder, interfaceC22053ub1, 0);
            C12700f33 c12700f33D = FN1.d(EnumC23487x03.f, interfaceC22053ub1, 6);
            interfaceC22053ub1.W(-579186638);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
            if (objB == aVar3.a()) {
                objB = new SA2() { // from class: ir.nasim.N41
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return P41.a.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC22498vL1.u(ev4C, "کانال جوک و خنده", c12700f33D, "ممنونم سلامت باشید ممنونم سلامت باشید ممنونم سلامت باشید.", "", (SA2) objB, false, false, false, interfaceC22053ub1, 224304, 448);
            EV4 ev4C2 = FV4.c(AbstractC24188yB5.avatar_placeholder, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-579175950);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar3.a()) {
                objB2 = new SA2() { // from class: ir.nasim.O41
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return P41.a.f();
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC22498vL1.u(ev4C2, "جوک و خنده", null, "ممنونم سلامت باشید.", "عضوییت", (SA2) objB2, false, false, false, interfaceC22053ub1, 224688, 448);
            interfaceC22053ub1.u();
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
