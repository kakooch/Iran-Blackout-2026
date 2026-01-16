package ir.nasim;

import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC23684xL1;
import ir.nasim.GO1;
import ir.nasim.InterfaceC13521gN1;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC18834pK4;
import ir.nasim.InterfaceC20625sK4;
import ir.nasim.X03;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import ir.nasim.features.onboarding.data.model.OnboardingBannerType;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class EO1 {

    static final class a extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ X03.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(X03.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.c = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18987pb3.x1(C18987pb3.a, EO1.x(this.c.d(), ExPeerType.BOT), null, null, false, null, null, false, null, null, false, null, 2046, null);
                this.b = 1;
                if (HG1.b(1200L, this) == objE) {
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

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final void i(final InterfaceC10258bL6 interfaceC10258bL6, final InterfaceC10258bL6 interfaceC10258bL62, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        long jA;
        AbstractC13042fc3.i(interfaceC10258bL6, "activeTabStateFlow");
        AbstractC13042fc3.i(interfaceC10258bL62, "uiStateStateFlow");
        AbstractC13042fc3.i(ua2, "handleDialogListTopSpotAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(840469442);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC10258bL62) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i3 & 14, 7);
            final InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC5976Lq2.c(interfaceC10258bL62, null, null, null, interfaceC22053ub1J, (i3 >> 3) & 14, 7);
            InterfaceC13521gN1 interfaceC13521gN1J = j(interfaceC9664aL6C);
            GO1.b bVarK = k(interfaceC9664aL6C2);
            interfaceC22053ub1J.W(-1101887284);
            boolean zV = interfaceC22053ub1J.V(interfaceC13521gN1J) | interfaceC22053ub1J.V(bVarK);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.oO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(EO1.q(interfaceC9664aL6C2, interfaceC9664aL6C));
                    }
                });
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
            interfaceC22053ub1J.Q();
            InterfaceC13521gN1 interfaceC13521gN1J2 = j(interfaceC9664aL6C);
            GO1.b bVarK2 = k(interfaceC9664aL6C2);
            interfaceC22053ub1J.W(-1101882412);
            boolean zV2 = interfaceC22053ub1J.V(interfaceC13521gN1J2) | interfaceC22053ub1J.V(bVarK2);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.qO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(EO1.s(interfaceC9664aL6C2, interfaceC9664aL6C));
                    }
                });
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC9664aL6 interfaceC9664aL62 = (InterfaceC9664aL6) objB2;
            interfaceC22053ub1J.Q();
            if (k(interfaceC9664aL6C2).b() instanceof InterfaceC20625sK4.c) {
                InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M != null) {
                    interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.sO1
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return EO1.u(interfaceC10258bL6, interfaceC10258bL62, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            if (t(interfaceC9664aL62)) {
                interfaceC22053ub1J.W(201736564);
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC20625sK4 interfaceC20625sK4B = k(interfaceC9664aL6C2).b();
                AbstractC13042fc3.g(interfaceC20625sK4B, "null cannot be cast to non-null type ir.nasim.features.onboarding.ui.model.OnboardingBannerUiState.Enabled");
                OnboardingBannerType onboardingBannerTypeC = ((InterfaceC20625sK4.b) interfaceC20625sK4B).c();
                if (AbstractC13042fc3.d(onboardingBannerTypeC, OnboardingBannerType.ImageFull.b) || (onboardingBannerTypeC instanceof OnboardingBannerType.ImageWithText) || (onboardingBannerTypeC instanceof OnboardingBannerType.ActionCardBanner)) {
                    interfaceC22053ub1J.W(-1101862115);
                    jA = G10.a.a(interfaceC22053ub1J, G10.b).A();
                    interfaceC22053ub1J.Q();
                } else {
                    if (!AbstractC13042fc3.d(onboardingBannerTypeC, OnboardingBannerType.ImageCard.b)) {
                        interfaceC22053ub1J.W(-1101871804);
                        interfaceC22053ub1J.Q();
                        throw new NoWhenBranchMatchedException();
                    }
                    interfaceC22053ub1J.W(-1101859484);
                    jA = G10.a.a(interfaceC22053ub1J, G10.b).r();
                    interfaceC22053ub1J.Q();
                }
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, jA, null, 2, null);
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
                InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar2.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                InterfaceC20625sK4 interfaceC20625sK4B2 = k(interfaceC9664aL6C2).b();
                AbstractC13042fc3.g(interfaceC20625sK4B2, "null cannot be cast to non-null type ir.nasim.features.onboarding.ui.model.OnboardingBannerUiState.Enabled");
                OnboardingBannerType onboardingBannerTypeC2 = ((InterfaceC20625sK4.b) interfaceC20625sK4B2).c();
                int i4 = OnboardingBannerType.a;
                androidx.compose.ui.e eVarW = w(onboardingBannerTypeC2, aVar, interfaceC22053ub1J, i4 | 48);
                InterfaceC20625sK4 interfaceC20625sK4B3 = k(interfaceC9664aL6C2).b();
                AbstractC13042fc3.g(interfaceC20625sK4B3, "null cannot be cast to non-null type ir.nasim.features.onboarding.ui.model.OnboardingBannerUiState.Enabled");
                String strD = ((InterfaceC20625sK4.b) interfaceC20625sK4B3).d();
                interfaceC22053ub1J.W(-183162224);
                int i5 = i3 & 896;
                boolean zV3 = interfaceC22053ub1J.V(interfaceC9664aL6C2) | (i5 == 256) | interfaceC22053ub1J.V(interfaceC9664aL6C);
                Object objB3 = interfaceC22053ub1J.B();
                if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.uO1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return EO1.l(ua2, interfaceC9664aL6C2, interfaceC9664aL6C);
                        }
                    };
                    interfaceC22053ub1J.s(objB3);
                }
                SA2 sa2 = (SA2) objB3;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(-183119344);
                boolean zV4 = (i5 == 256) | interfaceC22053ub1J.V(interfaceC9664aL6C);
                Object objB4 = interfaceC22053ub1J.B();
                if (zV4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.wO1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return EO1.m(ua2, interfaceC9664aL6C);
                        }
                    };
                    interfaceC22053ub1J.s(objB4);
                }
                SA2 sa22 = (SA2) objB4;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(-183109808);
                boolean zV5 = (i5 == 256) | interfaceC22053ub1J.V(interfaceC9664aL6C);
                Object objB5 = interfaceC22053ub1J.B();
                if (zV5 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new UA2() { // from class: ir.nasim.yO1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return EO1.n(ua2, interfaceC9664aL6C, (X03.a) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB5);
                }
                interfaceC22053ub1J.Q();
                InterfaceC20625sK4 interfaceC20625sK4B4 = k(interfaceC9664aL6C2).b();
                AbstractC13042fc3.g(interfaceC20625sK4B4, "null cannot be cast to non-null type ir.nasim.features.onboarding.ui.model.OnboardingBannerUiState.Enabled");
                interfaceC22053ub12 = interfaceC22053ub1J;
                V03.c(eVarW, strD, null, sa2, sa22, (UA2) objB5, y(((InterfaceC20625sK4.b) interfaceC20625sK4B4).c(), interfaceC22053ub1J, i4), interfaceC22053ub12, X03.a << 18, 4);
                interfaceC22053ub12.u();
                interfaceC22053ub12.Q();
            } else {
                interfaceC22053ub12 = interfaceC22053ub1J;
                if (r(interfaceC9664aL6)) {
                    interfaceC22053ub12.W(205239626);
                    final Context context = (Context) interfaceC22053ub12.H(AndroidCompositionLocals_androidKt.g());
                    AbstractC24274yL1 abstractC24274yL1A = k(interfaceC9664aL6C2).a();
                    EnumC15912kO1 enumC15912kO1 = EnumC15912kO1.b;
                    interfaceC22053ub12.W(-1101752151);
                    boolean zD = ((i3 & 896) == 256) | interfaceC22053ub12.D(context);
                    Object objB6 = interfaceC22053ub12.B();
                    if (zD || objB6 == InterfaceC22053ub1.a.a()) {
                        objB6 = new SA2() { // from class: ir.nasim.AO1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return EO1.o(ua2, context);
                            }
                        };
                        interfaceC22053ub12.s(objB6);
                    }
                    interfaceC22053ub12.Q();
                    AbstractC22498vL1.g(abstractC24274yL1A, enumC15912kO1, (SA2) objB6, interfaceC22053ub12, 48);
                    interfaceC22053ub12.Q();
                } else {
                    interfaceC22053ub12.W(205575976);
                    interfaceC22053ub12.Q();
                }
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub12.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new InterfaceC14603iB2() { // from class: ir.nasim.CO1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return EO1.p(interfaceC10258bL6, interfaceC10258bL62, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InterfaceC13521gN1 j(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC13521gN1) interfaceC9664aL6.getValue();
    }

    private static final GO1.b k(InterfaceC9664aL6 interfaceC9664aL6) {
        return (GO1.b) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC13042fc3.i(interfaceC9664aL62, "$activeTab$delegate");
        InterfaceC20625sK4 interfaceC20625sK4B = k(interfaceC9664aL6).b();
        InterfaceC20625sK4.b bVar = interfaceC20625sK4B instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) interfaceC20625sK4B : null;
        OnboardingBannerType onboardingBannerTypeC = bVar != null ? bVar.c() : null;
        if (onboardingBannerTypeC instanceof OnboardingBannerType.ActionCardBanner) {
            C18987pb3.x1(C18987pb3.a, x(((OnboardingBannerType.ActionCardBanner) onboardingBannerTypeC).getPeerId(), ExPeerType.BOT), null, null, false, null, null, false, null, null, false, null, 2046, null);
            ua2.invoke(new GO1.a.b(InterfaceC18834pK4.e.a));
        } else {
            ua2.invoke(new GO1.a.b(new InterfaceC18834pK4.a(z(j(interfaceC9664aL62)))));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        AbstractC13042fc3.i(interfaceC9664aL6, "$activeTab$delegate");
        ua2.invoke(new GO1.a.b(new InterfaceC18834pK4.b(z(j(interfaceC9664aL6)))));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, X03.a aVar) {
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        AbstractC13042fc3.i(interfaceC9664aL6, "$activeTab$delegate");
        AbstractC13042fc3.i(aVar, "actionBanner");
        ua2.invoke(new GO1.a.b(new InterfaceC18834pK4.d(z(j(interfaceC9664aL6)), aVar.d(), ExPeerType.BOT, new a(aVar, null))));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(UA2 ua2, Context context) {
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        AbstractC13042fc3.i(context, "$context");
        ua2.invoke(new GO1.a.C0389a(new AbstractC23684xL1.a(context)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$activeTabStateFlow");
        AbstractC13042fc3.i(interfaceC10258bL62, "$uiStateStateFlow");
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        i(interfaceC10258bL6, interfaceC10258bL62, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC13042fc3.i(interfaceC9664aL62, "$activeTab$delegate");
        return k(interfaceC9664aL6).c(j(interfaceC9664aL62));
    }

    private static final boolean r(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC13042fc3.i(interfaceC9664aL62, "$activeTab$delegate");
        return k(interfaceC9664aL6).h(j(interfaceC9664aL62));
    }

    private static final boolean t(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$activeTabStateFlow");
        AbstractC13042fc3.i(interfaceC10258bL62, "$uiStateStateFlow");
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        i(interfaceC10258bL6, interfaceC10258bL62, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final androidx.compose.ui.e w(OnboardingBannerType onboardingBannerType, androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        androidx.compose.ui.e eVarB;
        interfaceC22053ub1.W(1520304382);
        if (AbstractC13042fc3.d(onboardingBannerType, OnboardingBannerType.ImageCard.b)) {
            interfaceC22053ub1.W(1003623906);
            eVarB = androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(eVar, G10.a.c(interfaceC22053ub1, G10.b).b().e()), 0.0f, 1, null), 4.4186f, false, 2, null);
            interfaceC22053ub1.Q();
        } else if (AbstractC13042fc3.d(onboardingBannerType, OnboardingBannerType.ImageFull.b)) {
            interfaceC22053ub1.W(1047634961);
            interfaceC22053ub1.Q();
            eVarB = androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(eVar, 0.0f, 1, null), 4.0f, false, 2, null);
        } else if (onboardingBannerType instanceof OnboardingBannerType.ImageWithText) {
            interfaceC22053ub1.W(1047754032);
            eVarB = androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(eVar, G10.a.c(interfaceC22053ub1, G10.b).b().c()), 0.0f, 1, null), 4.1f, false, 2, null);
            interfaceC22053ub1.Q();
        } else {
            if (!(onboardingBannerType instanceof OnboardingBannerType.ActionCardBanner)) {
                interfaceC22053ub1.W(1003618026);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(1003640991);
            eVarB = androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(eVar, G10.a.c(interfaceC22053ub1, G10.b).b().c()), 0.0f, 1, null), 4.6f, false, 2, null);
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return eVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C11458d25 x(int i, ExPeerType exPeerType) {
        int i2 = exPeerType == null ? -1 : b.a[exPeerType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            C11458d25 c11458d25E = C11458d25.E(i);
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            return c11458d25E;
        }
        C11458d25 c11458d25Y = C11458d25.y(i);
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        return c11458d25Y;
    }

    private static final X03 y(OnboardingBannerType onboardingBannerType, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        EV4 ev4H;
        X03 aVar;
        interfaceC22053ub1.W(1519516994);
        if (onboardingBannerType instanceof OnboardingBannerType.ImageWithText) {
            OnboardingBannerType.ImageWithText imageWithText = (OnboardingBannerType.ImageWithText) onboardingBannerType;
            aVar = new X03.d(imageWithText.getTitle(), imageWithText.getDescription(), imageWithText.getIsRtl(), imageWithText.getIsFill());
        } else if (AbstractC13042fc3.d(onboardingBannerType, OnboardingBannerType.ImageCard.b)) {
            aVar = X03.b.b;
        } else if (AbstractC13042fc3.d(onboardingBannerType, OnboardingBannerType.ImageFull.b)) {
            aVar = X03.c.b;
        } else {
            if (!(onboardingBannerType instanceof OnboardingBannerType.ActionCardBanner)) {
                throw new NoWhenBranchMatchedException();
            }
            OnboardingBannerType.ActionCardBanner actionCardBanner = (OnboardingBannerType.ActionCardBanner) onboardingBannerType;
            int peerId = actionCardBanner.getPeerId();
            String description = actionCardBanner.getDescription();
            String title = actionCardBanner.getTitle();
            boolean isBlueTick = actionCardBanner.getIsBlueTick();
            String buttonText = actionCardBanner.getButtonText();
            if (actionCardBanner.getAvatar() == null) {
                interfaceC22053ub1.W(1620201342);
                ev4H = coil.compose.e.a(null, null, null, null, 0, null, interfaceC22053ub1, 6, 62);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1620270565);
                ev4H = AvatarAsyncImagePainterKt.h(actionCardBanner.getAvatar(), null, false, 0, interfaceC22053ub1, 0, 14);
                interfaceC22053ub1.Q();
            }
            aVar = new X03.a(peerId, description, title, ev4H, isBlueTick, buttonText);
        }
        interfaceC22053ub1.Q();
        return aVar;
    }

    public static final int z(InterfaceC13521gN1 interfaceC13521gN1) {
        AbstractC13042fc3.i(interfaceC13521gN1, "<this>");
        InterfaceC13521gN1.b bVar = interfaceC13521gN1 instanceof InterfaceC13521gN1.b ? (InterfaceC13521gN1.b) interfaceC13521gN1 : null;
        if (bVar != null) {
            return bVar.e();
        }
        return -1;
    }
}
