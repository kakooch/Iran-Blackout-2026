package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC5914Lj3;
import ir.nasim.E31;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.JK4;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import ir.nasim.features.onboarding.data.model.PeerData;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class E31 {
    public static final E31 a = new E31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(509262215, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1550105016, false, b.a);
    public static InterfaceC15796kB2 d = AbstractC19242q11.c(265338211, false, c.a);
    public static InterfaceC14603iB2 e = AbstractC19242q11.c(1233684715, false, d.a);
    public static InterfaceC14603iB2 f = AbstractC19242q11.c(-503847509, false, e.a);
    public static InterfaceC14603iB2 g = AbstractC19242q11.c(2026345252, false, f.a);
    public static InterfaceC14603iB2 h = AbstractC19242q11.c(446275172, false, g.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(KD5.features_onboarding_suggested_channels, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).G(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65530);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
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

    static final class c implements InterfaceC15796kB2 {
        public static final c a = new c();

        c() {
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

    static final class d implements InterfaceC14603iB2 {
        public static final d a = new d();

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(OnboardingPeer.ContactsChannel contactsChannel) {
            AbstractC13042fc3.i(contactsChannel, "it");
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            JK4 jk4 = new JK4(JK4.a.b.a, new JK4.b.a(AbstractC10360bX0.m(), null, 2, null), OnboardingSpot.Unknown.a);
            interfaceC22053ub1.W(-1345684894);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.F31
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return E31.d.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1345684766);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.G31
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return E31.d.f((OnboardingPeer.ContactsChannel) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC25073zh1.i(jk4, new C25038zd6(sa2, (UA2) objB2, null, null, 12, null), interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class e implements InterfaceC14603iB2 {
        public static final e a = new e();

        e() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), E31.a.d(), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class f implements InterfaceC14603iB2 {
        public static final f a = new f();

        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(OnboardingPeer.ContactsChannel contactsChannel) {
            AbstractC13042fc3.i(contactsChannel, "it");
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            JK4.a.C0443a c0443a = JK4.a.C0443a.a;
            ArrayList arrayList = new ArrayList(10);
            int i2 = 0;
            for (int i3 = 10; i2 < i3; i3 = 10) {
                AbstractC5914Lj3 abstractC5914Lj3 = i2 % 2 == 0 ? AbstractC5914Lj3.c.a : AbstractC5914Lj3.a.a;
                i2++;
                arrayList.add(new C20836sh1(abstractC5914Lj3, new OnboardingPeer.ContactsChannel(new PeerData(1, null, "توسعه کسب و کار", null, true, null, 32, null), 2000, null, i2 * 10, 4, null)));
            }
            JK4 jk4 = new JK4(c0443a, new JK4.b.a(arrayList, null, 2, null), OnboardingSpot.Unknown.a);
            interfaceC22053ub1.W(1669464516);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.H31
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return E31.f.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1669464644);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.I31
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return E31.f.f((OnboardingPeer.ContactsChannel) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC25073zh1.i(jk4, new C25038zd6(sa2, (UA2) objB2, null, null, 12, null), interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class g implements InterfaceC14603iB2 {
        public static final g a = new g();

        g() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), E31.a.f(), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }

    public final InterfaceC15796kB2 c() {
        return d;
    }

    public final InterfaceC14603iB2 d() {
        return e;
    }

    public final InterfaceC14603iB2 e() {
        return f;
    }

    public final InterfaceC14603iB2 f() {
        return g;
    }

    public final InterfaceC14603iB2 g() {
        return h;
    }
}
