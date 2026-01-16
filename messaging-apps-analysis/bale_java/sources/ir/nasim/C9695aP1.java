package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.InterfaceC18834pK4;
import ir.nasim.InterfaceC20625sK4;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.onboarding.data.model.OnboardingBannerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.aP1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9695aP1 {
    private final FK4 a;
    private final C6409Nm b;
    private final SettingsModule c;
    private final E84 d;
    private final AbstractC13778go1 e;
    private final InterfaceC20315ro1 f;
    private final InterfaceC9336Zm4 g;

    /* renamed from: ir.nasim.aP1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9695aP1.this.new a(interfaceC20295rm1);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:37:0x00a7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005b -> B:20:0x005e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r14.e
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 != r3) goto L1a
                java.lang.Object r1 = r14.d
                java.lang.Object r4 = r14.c
                ir.nasim.aP1 r4 = (ir.nasim.C9695aP1) r4
                java.lang.Object r5 = r14.b
                ir.nasim.Zm4 r5 = (ir.nasim.InterfaceC9336Zm4) r5
                ir.nasim.AbstractC10685c16.b(r15)
                goto L5e
            L1a:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L22:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.aP1 r15 = ir.nasim.C9695aP1.this
                ir.nasim.Zm4 r15 = ir.nasim.C9695aP1.e(r15)
                ir.nasim.aP1 r1 = ir.nasim.C9695aP1.this
                r5 = r15
                r4 = r1
            L2f:
                java.lang.Object r1 = r5.getValue()
                r15 = r1
                ir.nasim.sK4 r15 = (ir.nasim.InterfaceC20625sK4) r15
                boolean r15 = ir.nasim.C9695aP1.g(r4)
                if (r15 == 0) goto L3f
                ir.nasim.features.onboarding.data.model.OnboardingSpot$ActionBanner r15 = ir.nasim.features.onboarding.data.model.OnboardingSpot.ActionBanner.a
                goto L49
            L3f:
                boolean r15 = ir.nasim.C9695aP1.h(r4)
                if (r15 == 0) goto L48
                ir.nasim.features.onboarding.data.model.OnboardingSpot$DialogBanner r15 = ir.nasim.features.onboarding.data.model.OnboardingSpot.DialogBanner.a
                goto L49
            L48:
                r15 = r2
            L49:
                if (r15 == 0) goto La7
                ir.nasim.FK4 r6 = ir.nasim.C9695aP1.c(r4)
                r14.b = r5
                r14.c = r4
                r14.d = r1
                r14.e = r3
                java.lang.Object r15 = r6.a(r15, r14)
                if (r15 != r0) goto L5e
                return r0
            L5e:
                ir.nasim.features.onboarding.data.model.OnboardingData r15 = (ir.nasim.features.onboarding.data.model.OnboardingData) r15
                boolean r6 = r15 instanceof ir.nasim.features.onboarding.data.model.OnboardingData.Enabled
                if (r6 == 0) goto La3
                boolean r6 = r15 instanceof ir.nasim.features.onboarding.data.model.OnboardingData.Enabled.SuggestedServicePeers
                if (r6 == 0) goto L79
                int r7 = ir.nasim.C9695aP1.a(r4)
                ir.nasim.core.modules.settings.SettingsModule r8 = ir.nasim.C9695aP1.d(r4)
                int r8 = r8.k3()
                if (r7 > r8) goto L79
                ir.nasim.sK4$a r15 = ir.nasim.InterfaceC20625sK4.a.a
                goto La5
            L79:
                ir.nasim.sK4$b r13 = new ir.nasim.sK4$b
                r7 = r15
                ir.nasim.features.onboarding.data.model.OnboardingData$Enabled r7 = (ir.nasim.features.onboarding.data.model.OnboardingData.Enabled) r7
                int r8 = ir.nasim.features.onboarding.data.model.OnboardingData.Enabled.d(r7, r2, r3, r2)
                java.lang.String r7 = r7.getBannerUrl()
                if (r7 != 0) goto L8a
                java.lang.String r7 = ""
            L8a:
                r9 = r7
                if (r6 == 0) goto L94
                ir.nasim.features.onboarding.data.model.OnboardingData$Enabled$SuggestedServicePeers r15 = (ir.nasim.features.onboarding.data.model.OnboardingData.Enabled.SuggestedServicePeers) r15
                ir.nasim.features.onboarding.data.model.OnboardingBannerType r15 = r15.getBannerType()
                goto L96
            L94:
                ir.nasim.features.onboarding.data.model.OnboardingBannerType$ImageCard r15 = ir.nasim.features.onboarding.data.model.OnboardingBannerType.ImageCard.b
            L96:
                r11 = 8
                r12 = 0
                r10 = 0
                r6 = r13
                r7 = r8
                r8 = r9
                r9 = r15
                r6.<init>(r7, r8, r9, r10, r11, r12)
                r15 = r13
                goto La5
            La3:
                ir.nasim.sK4$a r15 = ir.nasim.InterfaceC20625sK4.a.a
            La5:
                if (r15 != 0) goto La9
            La7:
                ir.nasim.sK4$a r15 = ir.nasim.InterfaceC20625sK4.a.a
            La9:
                boolean r15 = r5.f(r1, r15)
                if (r15 == 0) goto L2f
                ir.nasim.rB7 r15 = ir.nasim.C19938rB7.a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9695aP1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.aP1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC18834pK4.d d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC18834pK4.d dVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = dVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9695aP1.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC9336Zm4 interfaceC9336Zm4;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9695aP1.this.m(new InterfaceC18834pK4.a(this.d.a()));
                UA2 ua2D = this.d.d();
                this.b = 1;
                if (ua2D.invoke(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    interfaceC9336Zm4 = C9695aP1.this.g;
                    do {
                        value = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value, InterfaceC20625sK4.a.a));
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            if (this.d.c() == ExPeerType.BOT) {
                C9695aP1.this.d.A2(C11458d25.E(this.d.b()), "/start", null, true, null);
            }
            Object value2 = C9695aP1.this.g.getValue();
            InterfaceC20625sK4.b bVar = value2 instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) value2 : null;
            if (bVar != null) {
                C9695aP1 c9695aP1 = C9695aP1.this;
                if (bVar.c() instanceof OnboardingBannerType.ActionCardBanner) {
                    c9695aP1.v(bVar, 6);
                }
            }
            this.b = 2;
            if (HG1.b(2000L, this) == objE) {
                return objE;
            }
            interfaceC9336Zm4 = C9695aP1.this.g;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, InterfaceC20625sK4.a.a));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C9695aP1(FK4 fk4, C6409Nm c6409Nm, SettingsModule settingsModule, E84 e84, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(fk4, "onboardingRepository");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(e84, "messageModule");
        AbstractC13042fc3.i(abstractC13778go1, "coroutineDispatcher");
        this.a = fk4;
        this.b = c6409Nm;
        this.c = settingsModule;
        this.d = e84;
        this.e = abstractC13778go1;
        this.f = AbstractC20906so1.a(abstractC13778go1);
        this.g = AbstractC12281eL6.a(InterfaceC20625sK4.c.a);
        e84.T0().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        CopyOnWriteArrayList copyOnWriteArrayListQ = this.d.N0().q();
        AbstractC13042fc3.h(copyOnWriteArrayListQ, "getGroups(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayListQ.iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList copyOnWriteArrayListQ2 = ((C15913kO2) it.next()).q();
            AbstractC13042fc3.h(copyOnWriteArrayListQ2, "getShortDialogs(...)");
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = copyOnWriteArrayListQ2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(((C25254zz6) it2.next()).w().getPeerId()));
            }
            AbstractC13610gX0.D(arrayList, arrayList2);
        }
        return arrayList.size();
    }

    private final String k(int i) {
        if (i == 0) {
            String lowerCase = "ALL".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        if (i == 1) {
            String lowerCase2 = "PRIVATE".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            return lowerCase2;
        }
        if (i == 2) {
            String lowerCase3 = "GROUP".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
            return lowerCase3;
        }
        if (i == 3) {
            String lowerCase4 = "CHANNEL".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase4, "toLowerCase(...)");
            return lowerCase4;
        }
        if (i == 4) {
            String lowerCase5 = "BOT".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase5, "toLowerCase(...)");
            return lowerCase5;
        }
        if (i != 10) {
            return CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
        }
        String lowerCase6 = "BOT".toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase6, "toLowerCase(...)");
        return lowerCase6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(InterfaceC18834pK4.a aVar) {
        Object value = this.g.getValue();
        InterfaceC20625sK4.b bVar = value instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) value : null;
        if (bVar != null) {
            this.c.i7(true);
            if (!(bVar.c() instanceof OnboardingBannerType.ImageCard)) {
                this.c.v7(3);
            }
            w(bVar, aVar.a(), 2);
        }
    }

    private final void n(InterfaceC18834pK4.b bVar) {
        Object value;
        Object value2 = this.g.getValue();
        InterfaceC20625sK4.b bVar2 = value2 instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) value2 : null;
        if (bVar2 != null) {
            this.c.i7(true);
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, InterfaceC20625sK4.a.a));
            w(bVar2, bVar.a(), 1);
            if (bVar2.c() instanceof OnboardingBannerType.ActionCardBanner) {
                v(bVar2, 8);
            }
            if (bVar2.c() instanceof OnboardingBannerType.ImageCard) {
                return;
            }
            this.c.v7(3);
        }
    }

    private final void o(InterfaceC18834pK4.c cVar) {
        AbstractC10533bm0.d(this.f, null, null, new a(null), 3, null);
    }

    private final void p(InterfaceC18834pK4.d dVar) {
        AbstractC10533bm0.d(this.f, null, null, new b(dVar, null), 3, null);
    }

    private final void r(InterfaceC18834pK4.e eVar) {
        Object value = this.g.getValue();
        InterfaceC20625sK4.b bVar = value instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) value : null;
        if (bVar == null || !(bVar.c() instanceof OnboardingBannerType.ActionCardBanner)) {
            return;
        }
        v(bVar, 7);
    }

    private final void s(InterfaceC18834pK4.f fVar) {
        Object value = this.g.getValue();
        InterfaceC20625sK4.b bVar = value instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) value : null;
        if (bVar != null) {
            InterfaceC20625sK4.b.a aVar = InterfaceC20625sK4.b.e;
            if (aVar.a()) {
                SettingsModule settingsModule = this.c;
                settingsModule.j7(settingsModule.t3() + 1);
                aVar.b(false);
            }
            w(bVar, fVar.a(), 3);
            if (!(bVar.c() instanceof OnboardingBannerType.ImageCard)) {
                SettingsModule settingsModule2 = this.c;
                settingsModule2.v7(settingsModule2.R3() + 1);
            }
            if (bVar.c() instanceof OnboardingBannerType.ActionCardBanner) {
                v(bVar, 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        return C8386Vt0.Db() && (this.c.R3() < 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        return C8386Vt0.S5() && !this.c.s3() && (this.c.t3() < 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(InterfaceC20625sK4.b bVar, int i) {
        OnboardingBannerType onboardingBannerTypeC = bVar.c();
        AbstractC13042fc3.g(onboardingBannerTypeC, "null cannot be cast to non-null type ir.nasim.features.onboarding.data.model.OnboardingBannerType.ActionCardBanner");
        OnboardingBannerType.ActionCardBanner actionCardBanner = (OnboardingBannerType.ActionCardBanner) onboardingBannerTypeC;
        XV4 xv4A = AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f()));
        XV4 xv4A2 = AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis()));
        XV4 xv4A3 = AbstractC4616Fw7.a("scenario_id", 2);
        XV4 xv4A4 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(actionCardBanner.getPeerId()));
        String lowerCase = ExPeerType.BOT.toString().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        this.b.d("dialog_banner", AbstractC20051rO3.p(xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("peer_type", lowerCase), AbstractC4616Fw7.a("message_type", actionCardBanner.getTitle()), AbstractC4616Fw7.a("message_info", actionCardBanner.getDescription()), AbstractC4616Fw7.a("action_type", Integer.valueOf(i))));
    }

    private final void w(InterfaceC20625sK4.b bVar, int i, int i2) {
        this.b.d("onboarding_old_users", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", Integer.valueOf(i2)), AbstractC4616Fw7.a("client_name", ConstantDeviceInfo.APP_PLATFORM), AbstractC4616Fw7.a("scenario_id", Integer.valueOf(bVar.e())), AbstractC4616Fw7.a("tab_title", k(i))));
    }

    public final InterfaceC10258bL6 l() {
        return AbstractC6459Nq2.c(this.g);
    }

    public final void q(InterfaceC18834pK4 interfaceC18834pK4) {
        AbstractC13042fc3.i(interfaceC18834pK4, "bannerUiAction");
        if (interfaceC18834pK4 instanceof InterfaceC18834pK4.c) {
            o((InterfaceC18834pK4.c) interfaceC18834pK4);
            return;
        }
        if (interfaceC18834pK4 instanceof InterfaceC18834pK4.f) {
            s((InterfaceC18834pK4.f) interfaceC18834pK4);
            return;
        }
        if (interfaceC18834pK4 instanceof InterfaceC18834pK4.a) {
            m((InterfaceC18834pK4.a) interfaceC18834pK4);
            return;
        }
        if (interfaceC18834pK4 instanceof InterfaceC18834pK4.b) {
            n((InterfaceC18834pK4.b) interfaceC18834pK4);
        } else if (interfaceC18834pK4 instanceof InterfaceC18834pK4.d) {
            p((InterfaceC18834pK4.d) interfaceC18834pK4);
        } else {
            if (!(interfaceC18834pK4 instanceof InterfaceC18834pK4.e)) {
                throw new NoWhenBranchMatchedException();
            }
            r((InterfaceC18834pK4.e) interfaceC18834pK4);
        }
    }
}
