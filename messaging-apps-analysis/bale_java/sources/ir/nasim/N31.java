package ir.nasim;

import ir.nasim.AbstractC5914Lj3;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.JK4;
import ir.nasim.N31;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import ir.nasim.features.onboarding.data.model.PeerData;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class N31 {
    public static final N31 a = new N31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1232217951, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-471940449, false, b.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
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
            JK4.a.C0443a c0443a = JK4.a.C0443a.a;
            ArrayList arrayList = new ArrayList(3);
            int i2 = 0;
            for (int i3 = 3; i2 < i3; i3 = 3) {
                arrayList.add(new P07(AbstractC5914Lj3.c.a, new OnboardingPeer.EmptyStateSuggestedPeer(new PeerData(1, ExPeerType.BOT, "نسخه پزشکی", null, true, null, 32, null), "نسخه پزشکی رو چک کن", "شروع")));
                i2++;
            }
            JK4 jk4 = new JK4(c0443a, new JK4.b.d(arrayList, false, null, 6, null), OnboardingSpot.EmptyState.a);
            interfaceC22053ub1.W(983350108);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.L31
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return N31.a.d();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(983350236);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.M31
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return N31.a.f((OnboardingPeer.EmptyStateSuggestedPeer) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC7809Th1.u(jk4, new C25038zd6(sa2, (UA2) objB2, null, null, 12, null), null, interfaceC22053ub1, 0, 4);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
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
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), N31.a.a(), interfaceC22053ub1, C7252Qx5.i | 48);
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
}
