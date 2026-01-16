package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC5914Lj3;
import ir.nasim.IK4;
import ir.nasim.JK4;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.onboarding.data.model.OnboardingData;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public final class KK4 extends VW7 {
    private final androidx.lifecycle.y b;
    private final FK4 c;
    private final C6409Nm d;
    private final SettingsModule e;
    private final E84 f;
    private final C10299bQ2 g;
    private final K72 h;
    private final InterfaceC3570Bk5 i;
    private boolean j;
    private final InterfaceC9336Zm4 k;
    private final InterfaceC10258bL6 l;
    private final InterfaceC10258bL6 m;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[M72.values().length];
            try {
                iArr[M72.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[M72.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ IK4.b c;
        final /* synthetic */ KK4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(IK4.b bVar, KK4 kk4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bVar;
            this.d = kk4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
                java.lang.Object r7 = r7.l()
                goto L89
            L18:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L20:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L36
            L24:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.IK4$b r7 = r6.c
                ir.nasim.UA2 r7 = r7.c()
                r6.b = r3
                java.lang.Object r7 = r7.invoke(r6)
                if (r7 != r0) goto L36
                return r0
            L36:
                ir.nasim.IK4$b r7 = r6.c
                ir.nasim.core.modules.profile.entity.ExPeerType r7 = r7.b()
                ir.nasim.core.modules.profile.entity.ExPeerType r1 = ir.nasim.core.modules.profile.entity.ExPeerType.BOT
                if (r7 != r1) goto L66
                ir.nasim.KK4 r7 = r6.d
                ir.nasim.E84 r0 = ir.nasim.KK4.S0(r7)
                ir.nasim.IK4$b r7 = r6.c
                int r7 = r7.a()
                ir.nasim.d25 r1 = ir.nasim.C11458d25.E(r7)
                r4 = 1
                r5 = 0
                java.lang.String r2 = "/start"
                r3 = 0
                r0.A2(r1, r2, r3, r4, r5)
                ir.nasim.KK4 r7 = r6.d
                ir.nasim.IK4$b r0 = r6.c
                int r0 = r0.a()
                ir.nasim.Lj3$a r1 = ir.nasim.AbstractC5914Lj3.a.a
                ir.nasim.KK4.W0(r7, r0, r1)
                goto Lb0
            L66:
                ir.nasim.KK4 r7 = r6.d
                ir.nasim.bQ2 r7 = ir.nasim.KK4.R0(r7)
                ir.nasim.IK4$b r1 = r6.c
                int r1 = r1.a()
                ir.nasim.d25 r1 = ir.nasim.C11458d25.y(r1)
                java.lang.String r4 = "group(...)"
                ir.nasim.AbstractC13042fc3.h(r1, r4)
                ir.nasim.Nv5 r7 = r7.q2(r1)
                r6.b = r2
                r1 = 0
                java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r1, r6, r3, r1)
                if (r7 != r0) goto L89
                return r0
            L89:
                boolean r0 = ir.nasim.C9475a16.j(r7)
                if (r0 == 0) goto L9d
                ir.nasim.KK4 r7 = r6.d
                ir.nasim.IK4$b r0 = r6.c
                int r0 = r0.a()
                ir.nasim.Lj3$a r1 = ir.nasim.AbstractC5914Lj3.a.a
                ir.nasim.KK4.W0(r7, r0, r1)
                goto Lb0
            L9d:
                boolean r7 = ir.nasim.C9475a16.g(r7)
                if (r7 == 0) goto Lb0
                ir.nasim.KK4 r7 = r6.d
                ir.nasim.IK4$b r0 = r6.c
                int r0 = r0.a()
                ir.nasim.Lj3$c r1 = ir.nasim.AbstractC5914Lj3.c.a
                ir.nasim.KK4.W0(r7, r0, r1)
            Lb0:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KK4.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ OnboardingSpot d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(OnboardingSpot onboardingSpot, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = onboardingSpot;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KK4.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FK4 fk4 = KK4.this.c;
                OnboardingSpot onboardingSpot = this.d;
                this.b = 1;
                obj = fk4.a(onboardingSpot, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            OnboardingData onboardingData = (OnboardingData) obj;
            InterfaceC9336Zm4 interfaceC9336Zm4 = KK4.this.k;
            KK4 kk4 = KK4.this;
            OnboardingSpot onboardingSpot2 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, ((JK4) value).a(JK4.a.C0443a.a, JK4.b.b(JK4.b.C0444b.a, onboardingData, kk4.e.v1() == 2 ? EnumC3773Ch1.c : EnumC3773Ch1.b, null, 2, null), onboardingSpot2)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ M72 d;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ KK4 a;
            final /* synthetic */ M72 b;

            a(KK4 kk4, M72 m72) {
                this.a = kk4;
                this.b = m72;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(OnboardingData onboardingData, InterfaceC20295rm1 interfaceC20295rm1) {
                Object value;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.a.k;
                M72 m72 = this.b;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, JK4.b((JK4) value, JK4.a.C0443a.a, JK4.b.b(JK4.b.C0444b.a, onboardingData, null, m72, 1, null), null, 4, null)));
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(M72 m72, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = m72;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KK4.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6I = KK4.this.h.i();
                a aVar = new a(KK4.this, this.d);
                this.b = 1;
                if (interfaceC10258bL6I.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public KK4(androidx.lifecycle.y yVar, FK4 fk4, C6409Nm c6409Nm, SettingsModule settingsModule, E84 e84, C10299bQ2 c10299bQ2, K72 k72, InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        AbstractC13042fc3.i(fk4, "onboardingRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(k72, "emptyStateOnboardingProvider");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        this.b = yVar;
        this.c = fk4;
        this.d = c6409Nm;
        this.e = settingsModule;
        this.f = e84;
        this.g = c10299bQ2;
        this.h = k72;
        this.i = interfaceC3570Bk5;
        this.j = true;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new JK4(JK4.a.b.a, JK4.b.C0444b.a, OnboardingSpot.Unknown.a));
        this.k = interfaceC9336Zm4A;
        this.l = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.m = k72.j();
    }

    private final void a1(IK4.a aVar) {
        Object value;
        if (this.j) {
            JK4.b bVarE = ((JK4) this.l.getValue()).e();
            if (bVarE instanceof JK4.b.c) {
                m1();
                return;
            }
            if (bVarE instanceof JK4.b.a) {
                i1();
                return;
            }
            if (bVarE instanceof JK4.b.C0444b) {
                return;
            }
            if (!(bVarE instanceof JK4.b.d)) {
                if (!(bVarE instanceof JK4.b.e)) {
                    throw new NoWhenBranchMatchedException();
                }
                s1();
                return;
            }
            JK4.b bVarE2 = ((JK4) this.l.getValue()).e();
            AbstractC13042fc3.g(bVarE2, "null cannot be cast to non-null type ir.nasim.onboarding.ui.model.OnboardingUiState.ScreenData.SuggestedPeersEmptyState");
            JK4.b.d dVar = (JK4.b.d) bVarE2;
            this.i.g(dVar.e().j(), false);
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, JK4.b((JK4) value, null, JK4.b.d.d(dVar, null, false, null, 5, null), null, 5, null)));
            l1();
        }
    }

    private final void b1(IK4.b bVar) {
        v1(bVar.a(), AbstractC5914Lj3.b.a);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(bVar, this, null), 3, null);
    }

    private final void c1(IK4.c cVar) {
        Object value;
        Object value2;
        OnboardingSpot onboardingSpot = (OnboardingSpot) this.b.c("onboarding_spot");
        Integer num = (Integer) this.b.c("scenario_id");
        InterfaceC13730gj3 interfaceC13730gj3D = null;
        if (onboardingSpot != null && num != null) {
            int iIntValue = num.intValue();
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
            do {
                value2 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value2, ((JK4) value2).a(JK4.a.b.a, iIntValue != 1 ? iIntValue != 5 ? new JK4.b.c(AbstractC10360bX0.m()) : new JK4.b.e(AbstractC10360bX0.m(), null, null, 6, null) : new JK4.b.a(AbstractC10360bX0.m(), EnumC3773Ch1.b), onboardingSpot)));
            interfaceC13730gj3D = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(onboardingSpot, null), 3, null);
        }
        if (interfaceC13730gj3D == null) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.k;
            do {
                value = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value, JK4.b((JK4) value, JK4.a.C0443a.a, null, null, 6, null)));
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    private final void d1(M72 m72) {
        Object value;
        if (this.i.h(m72.j(), true)) {
            this.h.l();
            g1(m72);
        } else {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, ((JK4) value).a(JK4.a.C0443a.a, new JK4.b.d(AbstractC10360bX0.m(), false, m72, 2, null), OnboardingSpot.EmptyState.a)));
        }
    }

    private final void e1(IK4.e eVar) {
        JK4.b bVarE = ((JK4) this.k.getValue()).e();
        if ((bVarE instanceof JK4.b.d ? (JK4.b.d) bVarE : null) != null) {
            q1(eVar.a(), 7);
        }
    }

    private final void f1(IK4.f fVar) {
        JK4.b bVarE = ((JK4) this.l.getValue()).e();
        if (bVarE instanceof JK4.b.c) {
            p1();
            return;
        }
        if (bVarE instanceof JK4.b.a) {
            k1();
            return;
        }
        if ((bVarE instanceof JK4.b.C0444b) || (bVarE instanceof JK4.b.d)) {
            return;
        }
        if (!(bVarE instanceof JK4.b.e)) {
            throw new NoWhenBranchMatchedException();
        }
        t1();
        u1();
    }

    private final void g1(M72 m72) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(m72, null), 3, null);
        int i = a.a[m72.ordinal()];
        if (i == 1) {
            this.h.n();
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void i1() {
        HashMap map = new HashMap();
        map.put("client_name", ConstantDeviceInfo.APP_PLATFORM);
        OnboardingSpot onboardingSpotD = ((JK4) this.l.getValue()).d();
        if (onboardingSpotD instanceof OnboardingSpot.SignUp) {
            return;
        }
        if (onboardingSpotD instanceof OnboardingSpot.DialogBanner) {
            map.put("scenario_id", 1);
            map.put("action_type", 4);
            this.d.d("onboarding_old_users", map);
        } else if (!(onboardingSpotD instanceof OnboardingSpot.Unknown) && !(onboardingSpotD instanceof OnboardingSpot.EmptyState) && !(onboardingSpotD instanceof OnboardingSpot.ActionBanner)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void j1(C20836sh1 c20836sh1) {
        HashMap map = new HashMap();
        map.put("client_name", ConstantDeviceInfo.APP_PLATFORM);
        map.put("members_count", Integer.valueOf(c20836sh1.c().getChannelMemberCount()));
        map.put("memberscount", Integer.valueOf(c20836sh1.c().getChannelCommonContactsCount()));
        map.put("peer_id", Integer.valueOf(c20836sh1.c().getPeerData().getPeerId()));
        ExPeerType peerType = c20836sh1.c().getPeerData().getPeerType();
        if (peerType != null) {
            String lowerCase = peerType.name().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
        }
        OnboardingSpot onboardingSpotD = ((JK4) this.l.getValue()).d();
        if (onboardingSpotD instanceof OnboardingSpot.SignUp) {
            return;
        }
        if (onboardingSpotD instanceof OnboardingSpot.DialogBanner) {
            map.put("scenario_id", 1);
            map.put("action_type", 5);
            this.d.d("onboarding_old_users", map);
        } else if (!(onboardingSpotD instanceof OnboardingSpot.Unknown) && !AbstractC13042fc3.d(onboardingSpotD, OnboardingSpot.EmptyState.a) && !AbstractC13042fc3.d(onboardingSpotD, OnboardingSpot.ActionBanner.a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void k1() {
        HashMap map = new HashMap();
        map.put("client_name", ConstantDeviceInfo.APP_PLATFORM);
        OnboardingSpot onboardingSpotD = ((JK4) this.l.getValue()).d();
        if (onboardingSpotD instanceof OnboardingSpot.SignUp) {
            return;
        }
        if (onboardingSpotD instanceof OnboardingSpot.DialogBanner) {
            map.put("scenario_id", 1);
            map.put("action_type", 0);
            this.d.d("onboarding_old_users", map);
        } else if (!(onboardingSpotD instanceof OnboardingSpot.Unknown) && !(onboardingSpotD instanceof OnboardingSpot.EmptyState) && !(onboardingSpotD instanceof OnboardingSpot.ActionBanner)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void l1() {
        JK4.b bVarE = ((JK4) this.k.getValue()).e();
        AbstractC13042fc3.g(bVarE, "null cannot be cast to non-null type ir.nasim.onboarding.ui.model.OnboardingUiState.ScreenData.SuggestedPeersEmptyState");
        JK4.b.d dVar = (JK4.b.d) bVarE;
        int i = a.a[dVar.e().ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 3;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (dVar.f().isEmpty()) {
            return;
        }
        OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeerD = ((P07) dVar.f().get(((Number) this.m.getValue()).intValue() % dVar.f().size())).d();
        XV4 xv4A = AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f()));
        XV4 xv4A2 = AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis()));
        XV4 xv4A3 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(emptyStateSuggestedPeerD.getPeerData().getPeerId()));
        String lowerCase = String.valueOf(emptyStateSuggestedPeerD.getPeerData().getPeerType()).toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        XV4 xv4A4 = AbstractC4616Fw7.a("peer_type", lowerCase);
        XV4 xv4A5 = AbstractC4616Fw7.a("event_type", Integer.valueOf(i2));
        XV4 xv4A6 = AbstractC4616Fw7.a("action_type", 2);
        XV4 xv4A7 = AbstractC4616Fw7.a("message_type", emptyStateSuggestedPeerD.getButtonText());
        String description = emptyStateSuggestedPeerD.getDescription();
        if (description == null) {
            description = "";
        }
        C3343Am.i("Empty_state", AbstractC20051rO3.p(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, xv4A6, xv4A7, AbstractC4616Fw7.a("msg_info", description)));
    }

    private final void m1() {
        HashMap map = new HashMap();
        map.put("client_name", ConstantDeviceInfo.APP_PLATFORM);
        OnboardingSpot onboardingSpotD = ((JK4) this.l.getValue()).d();
        if (onboardingSpotD instanceof OnboardingSpot.SignUp) {
            map.put("scenario_id", 10);
            map.put("page_type", 3);
            map.put("action_type", 1);
            this.d.d("onboarding_v2", map);
            return;
        }
        if (onboardingSpotD instanceof OnboardingSpot.DialogBanner) {
            map.put("scenario_id", 2);
            map.put("action_type", 4);
            this.d.d("onboarding_old_users", map);
        } else if (!(onboardingSpotD instanceof OnboardingSpot.Unknown) && !AbstractC13042fc3.d(onboardingSpotD, OnboardingSpot.EmptyState.a) && !AbstractC13042fc3.d(onboardingSpotD, OnboardingSpot.ActionBanner.a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void o1(Q07 q07) {
        HashMap map = new HashMap();
        map.put("client_name", ConstantDeviceInfo.APP_PLATFORM);
        map.put("members_count", Integer.valueOf(q07.d().getMemberOrUserCount()));
        map.put("peer_id", Integer.valueOf(q07.d().getPeerData().getPeerId()));
        ExPeerType peerType = q07.d().getPeerData().getPeerType();
        if (peerType != null) {
            String lowerCase = peerType.name().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
        }
        OnboardingSpot onboardingSpotD = ((JK4) this.l.getValue()).d();
        if (onboardingSpotD instanceof OnboardingSpot.SignUp) {
            map.put("scenario_id", 10);
            map.put("page_type", 3);
            map.put("action_type", 4);
            this.d.d("onboarding_v2", map);
            this.j = false;
            return;
        }
        if (onboardingSpotD instanceof OnboardingSpot.DialogBanner) {
            map.put("scenario_id", 2);
            map.put("action_type", 5);
            this.d.d("onboarding_old_users", map);
        } else if (!(onboardingSpotD instanceof OnboardingSpot.Unknown) && !(onboardingSpotD instanceof OnboardingSpot.EmptyState) && !AbstractC13042fc3.d(onboardingSpotD, OnboardingSpot.ActionBanner.a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void p1() {
        HashMap map = new HashMap();
        map.put("client_name", ConstantDeviceInfo.APP_PLATFORM);
        OnboardingSpot onboardingSpotD = ((JK4) this.l.getValue()).d();
        if (onboardingSpotD instanceof OnboardingSpot.SignUp) {
            map.put("scenario_id", 10);
            map.put("page_type", 3);
            map.put("action_type", 0);
            this.d.d("onboarding_v2", map);
            return;
        }
        if (onboardingSpotD instanceof OnboardingSpot.DialogBanner) {
            map.put("scenario_id", 2);
            map.put("action_type", 0);
            this.d.d("onboarding_old_users", map);
        } else if (!(onboardingSpotD instanceof OnboardingSpot.Unknown) && !(onboardingSpotD instanceof OnboardingSpot.EmptyState) && !AbstractC13042fc3.d(onboardingSpotD, OnboardingSpot.ActionBanner.a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void q1(int i, int i2) {
        JK4.b bVarE = ((JK4) this.l.getValue()).e();
        AbstractC13042fc3.g(bVarE, "null cannot be cast to non-null type ir.nasim.onboarding.ui.model.OnboardingUiState.ScreenData.SuggestedServicePeers");
        XV4 xv4A = AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f()));
        XV4 xv4A2 = AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis()));
        XV4 xv4A3 = AbstractC4616Fw7.a("scenario_id", 1);
        XV4 xv4A4 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(i));
        String lowerCase = ExPeerType.BOT.toString().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        this.d.d("dialog_banner", AbstractC20051rO3.p(xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("peer_type", lowerCase), AbstractC4616Fw7.a("message_type", String.valueOf(((JK4.b.e) bVarE).e())), AbstractC4616Fw7.a("action_type", Integer.valueOf(i2))));
    }

    private final void s1() {
        this.d.d("dialog_banner", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis())), AbstractC4616Fw7.a("scenario_id", 1), AbstractC4616Fw7.a("action_type", 4)));
    }

    private final void t1() {
        this.d.d("dialog_banner", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis())), AbstractC4616Fw7.a("scenario_id", 1), AbstractC4616Fw7.a("action_type", 3)));
    }

    private final void u1() {
        JK4.b bVarE = ((JK4) this.k.getValue()).e();
        JK4.b.d dVar = bVarE instanceof JK4.b.d ? (JK4.b.d) bVarE : null;
        if (dVar != null) {
            for (P07 p07 : dVar.f()) {
                p07.d().getPeerData().getPeerId();
                q1(p07.d().getPeerData().getPeerId(), 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(int i, AbstractC5914Lj3 abstractC5914Lj3) {
        Object next;
        Object value;
        JK4 jk4;
        ArrayList arrayList;
        Object next2;
        Object value2;
        JK4 jk42;
        ArrayList arrayList2;
        Object next3;
        Object value3;
        JK4 jk43;
        ArrayList arrayList3;
        Object next4;
        Object value4;
        JK4 jk44;
        ArrayList arrayList4;
        boolean z = abstractC5914Lj3 instanceof AbstractC5914Lj3.a;
        if (z) {
            this.h.g(i);
        }
        JK4.b bVarE = ((JK4) this.k.getValue()).e();
        if (bVarE instanceof JK4.b.c) {
            JK4.b.c cVar = (JK4.b.c) bVarE;
            Iterator it = cVar.d().iterator();
            while (true) {
                if (it.hasNext()) {
                    next4 = it.next();
                    if (((Q07) next4).d().getPeerData().getPeerId() == i) {
                        break;
                    }
                } else {
                    next4 = null;
                    break;
                }
            }
            Q07 q07 = (Q07) next4;
            Q07 q07B = q07 != null ? Q07.b(q07, abstractC5914Lj3, null, 2, null) : null;
            if (q07B != null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
                do {
                    value4 = interfaceC9336Zm4.getValue();
                    jk44 = (JK4) value4;
                    List<Q07> listD = cVar.d();
                    arrayList4 = new ArrayList(AbstractC10976cX0.x(listD, 10));
                    for (Q07 q072 : listD) {
                        if (q072.d().getPeerData().getPeerId() == i) {
                            q072 = q07B;
                        }
                        arrayList4.add(q072);
                    }
                } while (!interfaceC9336Zm4.f(value4, JK4.b(jk44, null, cVar.c(arrayList4), null, 5, null)));
                if (q07B.c() instanceof AbstractC5914Lj3.a) {
                    o1(q07B);
                    return;
                }
                return;
            }
            return;
        }
        if (bVarE instanceof JK4.b.a) {
            JK4.b.a aVar = (JK4.b.a) bVarE;
            Iterator it2 = aVar.e().iterator();
            while (true) {
                if (it2.hasNext()) {
                    next3 = it2.next();
                    if (((C20836sh1) next3).c().getPeerData().getPeerId() == i) {
                        break;
                    }
                } else {
                    next3 = null;
                    break;
                }
            }
            C20836sh1 c20836sh1 = (C20836sh1) next3;
            C20836sh1 c20836sh1B = c20836sh1 != null ? C20836sh1.b(c20836sh1, abstractC5914Lj3, null, 2, null) : null;
            if (c20836sh1B != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = this.k;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                    jk43 = (JK4) value3;
                    List<C20836sh1> listE = aVar.e();
                    arrayList3 = new ArrayList(AbstractC10976cX0.x(listE, 10));
                    for (C20836sh1 c20836sh12 : listE) {
                        if (c20836sh12.c().getPeerData().getPeerId() == i) {
                            c20836sh12 = c20836sh1B;
                        }
                        arrayList3.add(c20836sh12);
                    }
                } while (!interfaceC9336Zm42.f(value3, JK4.b(jk43, null, JK4.b.a.d(aVar, arrayList3, null, 2, null), null, 5, null)));
                if (c20836sh1B.d() instanceof AbstractC5914Lj3.a) {
                    j1(c20836sh1B);
                    return;
                }
                return;
            }
            return;
        }
        if (bVarE instanceof JK4.b.C0444b) {
            return;
        }
        if (!(bVarE instanceof JK4.b.d)) {
            if (!(bVarE instanceof JK4.b.e)) {
                throw new NoWhenBranchMatchedException();
            }
            JK4.b.e eVar = (JK4.b.e) bVarE;
            Iterator it3 = eVar.g().iterator();
            while (true) {
                if (it3.hasNext()) {
                    next = it3.next();
                    if (((P07) next).d().getPeerData().getPeerId() == i) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            P07 p07 = (P07) next;
            P07 p07B = p07 != null ? P07.b(p07, abstractC5914Lj3, null, 2, null) : null;
            if (z) {
                q1(i, 6);
            }
            if (p07B != null) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = this.k;
                do {
                    value = interfaceC9336Zm43.getValue();
                    jk4 = (JK4) value;
                    List<P07> listG = eVar.g();
                    arrayList = new ArrayList(AbstractC10976cX0.x(listG, 10));
                    for (P07 p072 : listG) {
                        if (p072.d().getPeerData().getPeerId() == i) {
                            p072 = p07B;
                        }
                        arrayList.add(p072);
                    }
                } while (!interfaceC9336Zm43.f(value, JK4.b(jk4, null, JK4.b.e.d(eVar, arrayList, null, null, 6, null), null, 5, null)));
                return;
            }
            return;
        }
        if (!AbstractC13042fc3.d(abstractC5914Lj3, AbstractC5914Lj3.b.a) && !AbstractC13042fc3.d(abstractC5914Lj3, AbstractC5914Lj3.c.a)) {
            if (!AbstractC13042fc3.d(abstractC5914Lj3, AbstractC5914Lj3.a.a)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        JK4.b.d dVar = (JK4.b.d) bVarE;
        Iterator it4 = dVar.f().iterator();
        while (true) {
            if (it4.hasNext()) {
                next2 = it4.next();
                if (((P07) next2).d().getPeerData().getPeerId() == i) {
                    break;
                }
            } else {
                next2 = null;
                break;
            }
        }
        P07 p073 = (P07) next2;
        P07 p07B2 = p073 != null ? P07.b(p073, abstractC5914Lj3, null, 2, null) : null;
        if (p07B2 != null) {
            InterfaceC9336Zm4 interfaceC9336Zm44 = this.k;
            do {
                value2 = interfaceC9336Zm44.getValue();
                jk42 = (JK4) value2;
                List<P07> listF = dVar.f();
                arrayList2 = new ArrayList(AbstractC10976cX0.x(listF, 10));
                for (P07 p074 : listF) {
                    if (p074.d().getPeerData().getPeerId() == i) {
                        p074 = p07B2;
                    }
                    arrayList2.add(p074);
                }
            } while (!interfaceC9336Zm44.f(value2, JK4.b(jk42, null, JK4.b.d.d(dVar, arrayList2, false, null, 6, null), null, 5, null)));
        }
    }

    public final InterfaceC10258bL6 X0() {
        return this.m;
    }

    public final InterfaceC10258bL6 Y0() {
        return this.l;
    }

    public final void Z0(IK4 ik4) {
        AbstractC13042fc3.i(ik4, "action");
        if (ik4 instanceof IK4.c) {
            c1((IK4.c) ik4);
            return;
        }
        if (ik4 instanceof IK4.f) {
            f1((IK4.f) ik4);
            return;
        }
        if (ik4 instanceof IK4.b) {
            b1((IK4.b) ik4);
            return;
        }
        if (ik4 instanceof IK4.a) {
            a1((IK4.a) ik4);
        } else if (ik4 instanceof IK4.d) {
            d1(((IK4.d) ik4).a());
        } else {
            if (!(ik4 instanceof IK4.e)) {
                throw new NoWhenBranchMatchedException();
            }
            e1((IK4.e) ik4);
        }
    }

    public final void h1(int i) {
        this.h.p(i);
    }
}
