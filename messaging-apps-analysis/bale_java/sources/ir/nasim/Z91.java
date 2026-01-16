package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC5914Lj3;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.JK4;
import ir.nasim.Z91;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import ir.nasim.features.onboarding.data.model.PeerData;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class Z91 {
    public static final Z91 a = new Z91();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1583307959, false, a.a);
    public static InterfaceC15796kB2 c = AbstractC19242q11.c(1074288005, false, b.a);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(-684746686, false, c.a);
    public static InterfaceC14603iB2 e = AbstractC19242q11.c(-232877609, false, d.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC24077y03.b(FV4.c(AbstractC24188yB5.arrow_left, interfaceC22053ub1, 0), UY6.c(UD5.bale_toolbar_navigation_back_icon_content_description, interfaceC22053ub1, 0), AbstractC18394ob1.d(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), false, 1, null), g10.a(interfaceC22053ub1, i2).G(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC19187pv3 interfaceC19187pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC19187pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC15710k25.i(true, interfaceC22053ub1, 6);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC19187pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(OnboardingPeer.SuggestedPeer suggestedPeer) {
            AbstractC13042fc3.i(suggestedPeer, "it");
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            JK4 jk4 = new JK4(JK4.a.b.a, new JK4.b.c(AbstractC10360bX0.m()), OnboardingSpot.DialogBanner.a);
            interfaceC22053ub1.W(-1229168106);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.aa1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Z91.c.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1229167978);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ba1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Z91.c.f((OnboardingPeer.SuggestedPeer) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            Y07.i(jk4, new C25038zd6(sa2, (UA2) objB2, null, null, 12, null), interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC14603iB2 {
        public static final d a = new d();

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(OnboardingPeer.SuggestedPeer suggestedPeer) {
            AbstractC13042fc3.i(suggestedPeer, "it");
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            JK4.a.C0443a c0443a = JK4.a.C0443a.a;
            ArrayList arrayList = new ArrayList(15);
            for (int i2 = 0; i2 < 15; i2++) {
                arrayList.add(new Q07(AbstractC5914Lj3.c.a, new OnboardingPeer.SuggestedPeer(new PeerData(1, ExPeerType.BOT, "Test", null, false, null, 32, null), 200, null, 4, null)));
            }
            JK4 jk4 = new JK4(c0443a, new JK4.b.c(arrayList), OnboardingSpot.SignUp.a);
            interfaceC22053ub1.W(278419511);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.ca1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Z91.d.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(278419639);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.da1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Z91.d.f((OnboardingPeer.SuggestedPeer) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            Y07.i(jk4, new C25038zd6(sa2, (UA2) objB2, null, null, 12, null), interfaceC22053ub1, 0);
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

    public final InterfaceC15796kB2 b() {
        return c;
    }

    public final InterfaceC14603iB2 c() {
        return d;
    }

    public final InterfaceC14603iB2 d() {
        return e;
    }
}
