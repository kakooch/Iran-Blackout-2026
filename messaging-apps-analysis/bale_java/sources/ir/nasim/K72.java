package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.onboarding.data.model.OnboardingData;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import ir.nasim.features.onboarding.data.model.PeerData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public final class K72 {
    private final InterfaceC3570Bk5 a;
    private final InterfaceC20315ro1 b;
    private final AbstractC13778go1 c;
    private final SettingsModule d;
    private final InterfaceC11621dJ7 e;
    private final E84 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC10258bL6 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC10258bL6 j;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19110pn6 c;
        final /* synthetic */ K72 d;

        /* renamed from: ir.nasim.K72$a$a, reason: collision with other inner class name */
        static final class C0455a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ int c;
            final /* synthetic */ K72 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0455a(K72 k72, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = k72;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0455a c0455a = new C0455a(this.d, interfaceC20295rm1);
                c0455a.c = ((Number) obj).intValue();
                return c0455a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c == 0) {
                    K72 k72 = this.d;
                    k72.p(((Number) k72.j().getValue()).intValue() + 1);
                }
                return C19938rB7.a;
            }

            public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0455a) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C19110pn6 c19110pn6, K72 k72, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19110pn6;
            this.d = k72;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A = this.c.a();
                C0455a c0455a = new C0455a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, c0455a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return K72.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Collection arrayList;
            Object objF;
            Object value;
            Object next;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List listK = K72.this.k(K72.this.d.P1());
                Set setH = K72.this.h();
                arrayList = new ArrayList();
                for (Object obj2 : listK) {
                    if (!setH.contains(String.valueOf(((C21228tK4) obj2).c()))) {
                        arrayList.add(obj2);
                    }
                }
                InterfaceC11621dJ7 interfaceC11621dJ7 = K72.this.e;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AbstractC6392Nk0.d(((C21228tK4) it.next()).c()));
                }
                this.b = arrayList;
                this.c = 1;
                objF = InterfaceC11621dJ7.f(interfaceC11621dJ7, arrayList2, false, this, 2, null);
                if (objF == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Collection collection = (List) this.b;
                AbstractC10685c16.b(obj);
                arrayList = collection;
                objF = obj;
            }
            Iterable iterable = (Iterable) objF;
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            Iterator it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                C17637nI7 c17637nI7 = (C17637nI7) it2.next();
                Iterator it3 = arrayList.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    if (((C21228tK4) next).c() == c17637nI7.u0().getPeerId()) {
                        break;
                    }
                }
                C21228tK4 c21228tK4 = (C21228tK4) next;
                int peerId = c17637nI7.u0().getPeerId();
                ExPeerType exPeerType = c17637nI7.getExPeerType();
                String strD = c21228tK4 != null ? c21228tK4.d() : null;
                PeerData peerData = new PeerData(peerId, exPeerType, strD == null ? "" : strD, c17637nI7.S(), c21228tK4 != null ? c21228tK4.e() : false, null, 32, null);
                String strB = c21228tK4 != null ? c21228tK4.b() : null;
                String strA = c21228tK4 != null ? c21228tK4.a() : null;
                if (strA == null) {
                    strA = "";
                }
                arrayList3.add(new OnboardingPeer.EmptyStateSuggestedPeer(peerData, strB, strA));
            }
            Object disabled = arrayList3.isEmpty() ? new OnboardingData.Disabled(OnboardingSpot.EmptyState.a) : new OnboardingData.Enabled.EmptyStateSuggestedPeers(OnboardingSpot.EmptyState.a, arrayList3, null);
            InterfaceC9336Zm4 interfaceC9336Zm4 = K72.this.g;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, disabled));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public K72(InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, SettingsModule settingsModule, InterfaceC11621dJ7 interfaceC11621dJ7, E84 e84, C19110pn6 c19110pn6) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(e84, "messageModule");
        AbstractC13042fc3.i(c19110pn6, "selectedTabFlowProvider");
        this.a = interfaceC3570Bk5;
        this.b = interfaceC20315ro1;
        this.c = abstractC13778go1;
        this.d = settingsModule;
        this.e = interfaceC11621dJ7;
        this.f = e84;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new OnboardingData.Disabled(OnboardingSpot.EmptyState.a));
        this.g = interfaceC9336Zm4A;
        this.h = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(0);
        this.i = interfaceC9336Zm4A2;
        this.j = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19110pn6, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set h() {
        CopyOnWriteArrayList copyOnWriteArrayListQ = this.f.N0().q();
        AbstractC13042fc3.h(copyOnWriteArrayListQ, "getGroups(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayListQ.iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList copyOnWriteArrayListQ2 = ((C15913kO2) it.next()).q();
            AbstractC13042fc3.h(copyOnWriteArrayListQ2, "getShortDialogs(...)");
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = copyOnWriteArrayListQ2.iterator();
            while (it2.hasNext()) {
                String strValueOf = String.valueOf(((C25254zz6) it2.next()).w().getPeerId());
                if (strValueOf != null) {
                    arrayList2.add(strValueOf);
                }
            }
            AbstractC13610gX0.D(arrayList, arrayList2);
        }
        return AbstractC15401jX0.r1(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List k(String str) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            C13149fk3 c13149fk3J = AbstractC9083Yk3.c(str).o().L("peers").j();
            AbstractC13042fc3.f(c13149fk3J);
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(c13149fk3J, 10));
            Iterator it = c13149fk3J.iterator();
            while (it.hasNext()) {
                C8542Wk3 c8542Wk3O = ((AbstractC22735vk3) it.next()).o();
                AbstractC22735vk3 abstractC22735vk3L = c8542Wk3O.L("peerId");
                int i = abstractC22735vk3L != null ? abstractC22735vk3L.i() : 0;
                AbstractC22735vk3 abstractC22735vk3L2 = c8542Wk3O.L("description");
                String strV = abstractC22735vk3L2 != null ? abstractC22735vk3L2.v() : null;
                String str2 = "";
                if (strV == null) {
                    strV = "";
                }
                AbstractC22735vk3 abstractC22735vk3L3 = c8542Wk3O.L("isBlueTick");
                boolean zF = abstractC22735vk3L3 != null ? abstractC22735vk3L3.f() : false;
                AbstractC22735vk3 abstractC22735vk3L4 = c8542Wk3O.L("title");
                String strV2 = abstractC22735vk3L4 != null ? abstractC22735vk3L4.v() : null;
                String str3 = strV2 == null ? "" : strV2;
                AbstractC22735vk3 abstractC22735vk3L5 = c8542Wk3O.L("buttonText");
                String strV3 = abstractC22735vk3L5 != null ? abstractC22735vk3L5.v() : null;
                if (strV3 != null) {
                    str2 = strV3;
                }
                arrayList.add(new C21228tK4(i, strV, str3, zF, str2));
            }
            objB = C9475a16.b(arrayList);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        List listM = AbstractC10360bX0.m();
        if (C9475a16.g(objB)) {
            objB = listM;
        }
        return (List) objB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(K72 k72, C14505i18 c14505i18) {
        AbstractC13042fc3.i(k72, "this$0");
        AbstractC10533bm0.d(k72.b, k72.c, null, k72.new b(null), 2, null);
    }

    private final void o(int i) {
        OnboardingData onboardingData = (OnboardingData) this.g.getValue();
        if (onboardingData instanceof OnboardingData.Enabled.EmptyStateSuggestedPeers) {
            List peerList = ((OnboardingData.Enabled.EmptyStateSuggestedPeers) onboardingData).getPeerList();
            if (i < 0 || i >= peerList.size()) {
                return;
            }
            OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer = (OnboardingPeer.EmptyStateSuggestedPeer) peerList.get(i);
            XV4 xv4A = AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f()));
            XV4 xv4A2 = AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis()));
            XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(emptyStateSuggestedPeer.getPeerData().getPeerId()));
            String lowerCase = String.valueOf(emptyStateSuggestedPeer.getPeerData().getPeerType()).toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            XV4 xv4A4 = AbstractC4616Fw7.a("peer_type", lowerCase);
            XV4 xv4A5 = AbstractC4616Fw7.a("event_type", 1);
            XV4 xv4A6 = AbstractC4616Fw7.a("action_type", 1);
            XV4 xv4A7 = AbstractC4616Fw7.a("message_type", emptyStateSuggestedPeer.getButtonText());
            String description = emptyStateSuggestedPeer.getDescription();
            if (description == null) {
                description = "";
            }
            C3343Am.i("Empty_state", AbstractC20051rO3.p(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, xv4A6, xv4A7, AbstractC4616Fw7.a("msg_info", description)));
        }
    }

    public final void g(int i) {
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        Object emptyStateSuggestedPeers = (OnboardingData) interfaceC9336Zm4.getValue();
        if (emptyStateSuggestedPeers instanceof OnboardingData.Enabled.EmptyStateSuggestedPeers) {
            OnboardingSpot.EmptyState emptyState = OnboardingSpot.EmptyState.a;
            List peerList = ((OnboardingData.Enabled.EmptyStateSuggestedPeers) emptyStateSuggestedPeers).getPeerList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : peerList) {
                if (((OnboardingPeer.EmptyStateSuggestedPeer) obj).getPeerData().getPeerId() != i) {
                    arrayList.add(obj);
                }
            }
            emptyStateSuggestedPeers = new OnboardingData.Enabled.EmptyStateSuggestedPeers(emptyState, arrayList, null);
        }
        interfaceC9336Zm4.setValue(emptyStateSuggestedPeers);
    }

    public final InterfaceC10258bL6 i() {
        return this.h;
    }

    public final InterfaceC10258bL6 j() {
        return this.j;
    }

    public final C6517Nv5 l() {
        return this.f.T0().l().m0(new InterfaceC24449ye1() { // from class: ir.nasim.J72
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                K72.m(this.a, (C14505i18) obj);
            }
        });
    }

    public final void n() {
        OnboardingData onboardingData = (OnboardingData) this.g.getValue();
        if (onboardingData instanceof OnboardingData.Enabled.EmptyStateSuggestedPeers) {
            for (OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer : ((OnboardingData.Enabled.EmptyStateSuggestedPeers) onboardingData).getPeerList()) {
                XV4 xv4A = AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f()));
                XV4 xv4A2 = AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis()));
                XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(emptyStateSuggestedPeer.getPeerData().getPeerId()));
                String lowerCase = String.valueOf(emptyStateSuggestedPeer.getPeerData().getPeerType()).toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                XV4 xv4A4 = AbstractC4616Fw7.a("peer_type", lowerCase);
                XV4 xv4A5 = AbstractC4616Fw7.a("event_type", 3);
                XV4 xv4A6 = AbstractC4616Fw7.a("action_type", 1);
                XV4 xv4A7 = AbstractC4616Fw7.a("message_type", emptyStateSuggestedPeer.getButtonText());
                String description = emptyStateSuggestedPeer.getDescription();
                if (description == null) {
                    description = "";
                }
                C3343Am.i("Empty_state", AbstractC20051rO3.p(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, xv4A6, xv4A7, AbstractC4616Fw7.a("msg_info", description)));
            }
        }
    }

    public final void p(int i) {
        Object value;
        if (((Number) this.i.getValue()).intValue() != i) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Number) value).intValue();
            } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i)));
            o(i);
        }
    }
}
