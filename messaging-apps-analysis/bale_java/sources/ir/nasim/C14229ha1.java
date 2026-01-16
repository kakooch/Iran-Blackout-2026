package ir.nasim;

import ir.nasim.C14229ha1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.JK4;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;

/* renamed from: ir.nasim.ha1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14229ha1 {
    public static final C14229ha1 a = new C14229ha1();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(1811045496, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1174894281, false, b.a);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(-1051528073, false, c.a);

    /* renamed from: ir.nasim.ha1$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC17863nh1.m(interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ha1$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
            AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            JK4 jk4 = new JK4(JK4.a.b.a, new JK4.b.e(AbstractC10360bX0.m(), null, "چه خدماتی به «بله» اضافه شد؟", 2, null), OnboardingSpot.DialogBanner.a);
            interfaceC22053ub1.W(-1175902422);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.ia1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C14229ha1.b.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1175902294);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ja1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C14229ha1.b.f((OnboardingPeer.EmptyStateSuggestedPeer) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC16293l17.o(jk4, new C25038zd6(sa2, (UA2) objB2, null, null, 12, null), interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ha1$c */
    static final class c implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), C14229ha1.a.b(), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }

    public final InterfaceC14603iB2 c() {
        return d;
    }
}
