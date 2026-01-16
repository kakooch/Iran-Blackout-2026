package ir.nasim;

import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import ir.nasim.AbstractC23684xL1;
import ir.nasim.AbstractC24274yL1;
import ir.nasim.IO1;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC18834pK4;
import ir.nasim.InterfaceC20625sK4;
import ir.nasim.X03;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import ir.nasim.features.onboarding.data.model.OnboardingBannerType;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class FO1 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.invoke(new IO1.b(InterfaceC18834pK4.c.a));
            this.c.invoke(new IO1.a(AbstractC23684xL1.d.b));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (FO1.l(this.d).g(FO1.k(this.e))) {
                this.c.invoke(new IO1.b(new InterfaceC18834pK4.f(FO1.H(FO1.k(this.e)))));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
            this.f = interfaceC9664aL63;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (FO1.w(this.d) != null && FO1.l(this.e).d(FO1.k(this.f))) {
                this.c.invoke(new IO1.a(AbstractC23684xL1.e.b));
            }
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
        final /* synthetic */ UA2 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9664aL6 interfaceC9664aL64, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
            this.f = interfaceC9664aL63;
            this.g = interfaceC9664aL64;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if ((!AbstractC20762sZ6.n0(FO1.y(this.d))) && FO1.l(this.e).e(FO1.k(this.f)) && !FO1.m(this.g)) {
                this.c.invoke(new IO1.a(AbstractC23684xL1.e.b));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC10258bL6 a;
        final /* synthetic */ InterfaceC10258bL6 b;
        final /* synthetic */ UA2 c;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC10258bL6 a;
            final /* synthetic */ InterfaceC10258bL6 b;
            final /* synthetic */ UA2 c;

            a(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2) {
                this.a = interfaceC10258bL6;
                this.b = interfaceC10258bL62;
                this.c = ua2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    FO1.j(this.a, this.b, this.c, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        e(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2) {
            this.a = interfaceC10258bL6;
            this.b = interfaceC10258bL62;
            this.c = ua2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1422357855, true, new a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC11273cj7.values().length];
            try {
                iArr[EnumC11273cj7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC11273cj7.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC11273cj7.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC11273cj7.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC11273cj7.f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    private static final X03 G(OnboardingBannerType onboardingBannerType, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        EV4 ev4H;
        X03 aVar;
        interfaceC22053ub1.W(-208025652);
        if (AbstractC13042fc3.d(onboardingBannerType, OnboardingBannerType.ImageCard.b)) {
            aVar = X03.b.b;
        } else if (onboardingBannerType instanceof OnboardingBannerType.ImageWithText) {
            OnboardingBannerType.ImageWithText imageWithText = (OnboardingBannerType.ImageWithText) onboardingBannerType;
            aVar = new X03.d(imageWithText.getTitle(), imageWithText.getDescription(), imageWithText.getIsRtl(), imageWithText.getIsFill());
        } else if (AbstractC13042fc3.d(onboardingBannerType, OnboardingBannerType.ImageFull.b)) {
            aVar = X03.c.b;
        } else {
            if (!(onboardingBannerType instanceof OnboardingBannerType.ActionCardBanner)) {
                throw new NoWhenBranchMatchedException();
            }
            OnboardingBannerType.ActionCardBanner actionCardBanner = (OnboardingBannerType.ActionCardBanner) onboardingBannerType;
            int peerId = actionCardBanner.getPeerId();
            String description = actionCardBanner.getDescription();
            if (actionCardBanner.getAvatar() == null) {
                interfaceC22053ub1.W(-1955911788);
                ev4H = coil.compose.e.a(null, null, null, null, 0, null, interfaceC22053ub1, 6, 62);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-1955842565);
                ev4H = AvatarAsyncImagePainterKt.h(actionCardBanner.getAvatar(), null, false, 0, interfaceC22053ub1, 0, 14);
                interfaceC22053ub1.Q();
            }
            aVar = new X03.a(peerId, description, actionCardBanner.getTitle(), ev4H, actionCardBanner.getIsBlueTick(), actionCardBanner.getButtonText());
        }
        interfaceC22053ub1.Q();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H(EnumC11273cj7 enumC11273cj7) {
        int i = f.a[enumC11273cj7.ordinal()];
        if (i == 1) {
            return 0;
        }
        int i2 = 3;
        if (i != 2) {
            if (i == 3) {
                return 2;
            }
            i2 = 4;
            if (i == 4) {
                return 1;
            }
            if (i != 5) {
                return 0;
            }
        }
        return i2;
    }

    public static final void I(ComposeView composeView, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2) {
        AbstractC13042fc3.i(composeView, "<this>");
        AbstractC13042fc3.i(interfaceC10258bL6, "tabTypeStateFlow");
        AbstractC13042fc3.i(interfaceC10258bL62, "uiStateStateFlow");
        AbstractC13042fc3.i(ua2, "handleDialogListTopSpotAction");
        composeView.setContent(AbstractC19242q11.c(-1575475226, true, new e(interfaceC10258bL6, interfaceC10258bL62, ua2)));
    }

    public static final void j(final InterfaceC10258bL6 interfaceC10258bL6, final InterfaceC10258bL6 interfaceC10258bL62, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        final InterfaceC9664aL6 interfaceC9664aL6;
        InterfaceC9664aL6 interfaceC9664aL62;
        InterfaceC22053ub1 interfaceC22053ub12;
        int i3;
        InterfaceC20295rm1 interfaceC20295rm1;
        int i4;
        InterfaceC9664aL6 interfaceC9664aL63;
        InterfaceC22053ub1 interfaceC22053ub13;
        InterfaceC9664aL6 interfaceC9664aL64;
        boolean z;
        AbstractC13042fc3.i(interfaceC10258bL6, "tabTypeStateFlow");
        AbstractC13042fc3.i(interfaceC10258bL62, "uiStateStateFlow");
        AbstractC13042fc3.i(ua2, "handleDialogListTopSpotAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-383764916);
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
        int i5 = i2;
        if ((i5 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub13 = interfaceC22053ub1J;
        } else {
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(interfaceC10258bL6, null, null, null, interfaceC22053ub1J, i5 & 14, 7);
            final InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC5976Lq2.c(interfaceC10258bL62, null, null, null, interfaceC22053ub1J, (i5 >> 3) & 14, 7);
            Object objA = l(interfaceC9664aL6C2).a();
            interfaceC22053ub1J.W(984271106);
            boolean zV = interfaceC22053ub1J.V(objA);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.nO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FO1.v(interfaceC9664aL6C2);
                    }
                });
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9664aL6 interfaceC9664aL65 = (InterfaceC9664aL6) objB;
            interfaceC22053ub1J.Q();
            Object objA2 = l(interfaceC9664aL6C2).a();
            interfaceC22053ub1J.W(984277284);
            boolean zV2 = interfaceC22053ub1J.V(objA2);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.pO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return FO1.x(interfaceC9664aL6C2);
                    }
                });
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC9664aL6 interfaceC9664aL66 = (InterfaceC9664aL6) objB2;
            interfaceC22053ub1J.Q();
            Object objA3 = l(interfaceC9664aL6C2).a();
            interfaceC22053ub1J.W(984283824);
            boolean zV3 = interfaceC22053ub1J.V(objA3);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.rO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(FO1.z(interfaceC9664aL6C2));
                    }
                });
                interfaceC22053ub1J.s(objB3);
            }
            InterfaceC9664aL6 interfaceC9664aL67 = (InterfaceC9664aL6) objB3;
            interfaceC22053ub1J.Q();
            Object objK = k(interfaceC9664aL6C);
            Object objL = l(interfaceC9664aL6C2);
            interfaceC22053ub1J.W(984290528);
            boolean zV4 = interfaceC22053ub1J.V(objK) | interfaceC22053ub1J.V(objL);
            Object objB4 = interfaceC22053ub1J.B();
            if (zV4 || objB4 == InterfaceC22053ub1.a.a()) {
                interfaceC9664aL6 = interfaceC9664aL6C;
                objB4 = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.tO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(FO1.n(interfaceC9664aL6C2, interfaceC9664aL6));
                    }
                });
                interfaceC22053ub1J.s(objB4);
            } else {
                interfaceC9664aL6 = interfaceC9664aL6C;
            }
            InterfaceC9664aL6 interfaceC9664aL68 = (InterfaceC9664aL6) objB4;
            interfaceC22053ub1J.Q();
            Object objK2 = k(interfaceC9664aL6);
            Object objL2 = l(interfaceC9664aL6C2);
            interfaceC22053ub1J.W(984296008);
            boolean zV5 = interfaceC22053ub1J.V(objK2) | interfaceC22053ub1J.V(objL2);
            Object objB5 = interfaceC22053ub1J.B();
            if (zV5 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.vO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(FO1.p(interfaceC9664aL6C2, interfaceC9664aL6));
                    }
                });
                interfaceC22053ub1J.s(objB5);
            }
            InterfaceC9664aL6 interfaceC9664aL69 = (InterfaceC9664aL6) objB5;
            interfaceC22053ub1J.Q();
            if (q(interfaceC9664aL69)) {
                interfaceC22053ub1J.W(448607143);
                e.a aVar = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i6 = G10.b;
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1J, i6).r(), null, 2, null);
                interfaceC9664aL62 = interfaceC9664aL67;
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
                androidx.compose.ui.e eVarB = androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1J, i6).b().e()), 0.0f, 1, null), 4.4186f, false, 2, null);
                InterfaceC20625sK4 interfaceC20625sK4B = l(interfaceC9664aL6C2).b();
                AbstractC13042fc3.g(interfaceC20625sK4B, "null cannot be cast to non-null type ir.nasim.features.onboarding.ui.model.OnboardingBannerUiState.Enabled");
                String strD = ((InterfaceC20625sK4.b) interfaceC20625sK4B).d();
                interfaceC22053ub1J.W(222499343);
                int i7 = i5 & 896;
                boolean zV6 = (i7 == 256) | interfaceC22053ub1J.V(interfaceC9664aL6);
                Object objB6 = interfaceC22053ub1J.B();
                if (zV6 || objB6 == InterfaceC22053ub1.a.a()) {
                    objB6 = new SA2() { // from class: ir.nasim.xO1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return FO1.r(ua2, interfaceC9664aL6);
                        }
                    };
                    interfaceC22053ub1J.s(objB6);
                }
                SA2 sa2 = (SA2) objB6;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(222510191);
                boolean zV7 = interfaceC22053ub1J.V(interfaceC9664aL6) | (i7 == 256);
                Object objB7 = interfaceC22053ub1J.B();
                if (zV7 || objB7 == InterfaceC22053ub1.a.a()) {
                    objB7 = new SA2() { // from class: ir.nasim.zO1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return FO1.s(ua2, interfaceC9664aL6);
                        }
                    };
                    interfaceC22053ub1J.s(objB7);
                }
                interfaceC22053ub1J.Q();
                InterfaceC20625sK4 interfaceC20625sK4B2 = l(interfaceC9664aL6C2).b();
                AbstractC13042fc3.g(interfaceC20625sK4B2, "null cannot be cast to non-null type ir.nasim.features.onboarding.ui.model.OnboardingBannerUiState.Enabled");
                interfaceC20295rm1 = null;
                i3 = 6;
                interfaceC22053ub12 = interfaceC22053ub1J;
                V03.c(eVarB, strD, null, sa2, (SA2) objB7, null, G(((InterfaceC20625sK4.b) interfaceC20625sK4B2).c(), interfaceC22053ub1J, 0), interfaceC22053ub12, X03.a << 18, 36);
                interfaceC22053ub12.u();
                interfaceC22053ub12.Q();
                i4 = 256;
            } else {
                interfaceC9664aL62 = interfaceC9664aL67;
                interfaceC22053ub12 = interfaceC22053ub1J;
                i3 = 6;
                interfaceC20295rm1 = null;
                i4 = 256;
                if (o(interfaceC9664aL68)) {
                    interfaceC22053ub12.W(449837440);
                    final Context context = (Context) interfaceC22053ub12.H(AndroidCompositionLocals_androidKt.g());
                    AbstractC24274yL1 abstractC24274yL1A = l(interfaceC9664aL6C2).a();
                    EnumC15912kO1 enumC15912kO1 = EnumC15912kO1.a;
                    interfaceC22053ub12.W(984348083);
                    boolean zD = ((i5 & 896) == 256) | interfaceC22053ub12.D(context);
                    Object objB8 = interfaceC22053ub12.B();
                    if (zD || objB8 == InterfaceC22053ub1.a.a()) {
                        objB8 = new SA2() { // from class: ir.nasim.BO1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return FO1.t(ua2, context);
                            }
                        };
                        interfaceC22053ub12.s(objB8);
                    }
                    interfaceC22053ub12.Q();
                    AbstractC22498vL1.g(abstractC24274yL1A, enumC15912kO1, (SA2) objB8, interfaceC22053ub12, 48);
                    interfaceC22053ub12.Q();
                } else {
                    interfaceC22053ub12.W(450173790);
                    interfaceC22053ub12.Q();
                }
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub12.W(984354286);
            int i8 = i5 & 896;
            boolean z2 = i8 == i4;
            Object objB9 = interfaceC22053ub12.B();
            if (z2 || objB9 == InterfaceC22053ub1.a.a()) {
                objB9 = new a(ua2, interfaceC20295rm1);
                interfaceC22053ub12.s(objB9);
            }
            interfaceC22053ub12.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB9, interfaceC22053ub12, i3);
            Boolean boolValueOf = Boolean.valueOf(q(interfaceC9664aL69));
            interfaceC22053ub12.W(984367576);
            boolean zV8 = interfaceC22053ub12.V(interfaceC9664aL6C2) | interfaceC22053ub12.V(interfaceC9664aL6) | (i8 == i4);
            Object objB10 = interfaceC22053ub12.B();
            if (zV8 || objB10 == InterfaceC22053ub1.a.a()) {
                objB10 = new b(ua2, interfaceC9664aL6C2, interfaceC9664aL6, interfaceC20295rm1);
                interfaceC22053ub12.s(objB10);
            }
            interfaceC22053ub12.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB10, interfaceC22053ub12, 0);
            Integer numW = w(interfaceC9664aL65);
            interfaceC22053ub12.W(984379849);
            boolean zV9 = interfaceC22053ub12.V(interfaceC9664aL65) | interfaceC22053ub12.V(interfaceC9664aL6C2) | interfaceC22053ub12.V(interfaceC9664aL6) | (i8 == i4);
            Object objB11 = interfaceC22053ub12.B();
            if (zV9 || objB11 == InterfaceC22053ub1.a.a()) {
                interfaceC9664aL63 = interfaceC9664aL6;
                interfaceC22053ub13 = interfaceC22053ub12;
                interfaceC9664aL64 = interfaceC9664aL62;
                z = true;
                Object cVar = new c(ua2, interfaceC9664aL65, interfaceC9664aL6C2, interfaceC9664aL63, null);
                interfaceC22053ub13.s(cVar);
                objB11 = cVar;
            } else {
                interfaceC9664aL63 = interfaceC9664aL6;
                interfaceC22053ub13 = interfaceC22053ub12;
                interfaceC9664aL64 = interfaceC9664aL62;
                z = true;
            }
            interfaceC22053ub13.Q();
            AbstractC10721c52.e(numW, (InterfaceC14603iB2) objB11, interfaceC22053ub13, 0);
            String strY = y(interfaceC9664aL66);
            Boolean boolValueOf2 = Boolean.valueOf(m(interfaceC9664aL64));
            interfaceC22053ub13.W(984390600);
            boolean zV10 = interfaceC22053ub13.V(interfaceC9664aL66) | interfaceC22053ub13.V(interfaceC9664aL6C2) | interfaceC22053ub13.V(interfaceC9664aL63) | interfaceC22053ub13.V(interfaceC9664aL64) | (i8 == i4 ? z : false);
            Object objB12 = interfaceC22053ub13.B();
            if (zV10 || objB12 == InterfaceC22053ub1.a.a()) {
                Object dVar = new d(ua2, interfaceC9664aL66, interfaceC9664aL6C2, interfaceC9664aL63, interfaceC9664aL64, null);
                interfaceC22053ub13.s(dVar);
                objB12 = dVar;
            }
            interfaceC22053ub13.Q();
            AbstractC10721c52.f(strY, boolValueOf2, (InterfaceC14603iB2) objB12, interfaceC22053ub13, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub13.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.DO1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return FO1.u(interfaceC10258bL6, interfaceC10258bL62, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumC11273cj7 k(InterfaceC9664aL6 interfaceC9664aL6) {
        return (EnumC11273cj7) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JO1 l(InterfaceC9664aL6 interfaceC9664aL6) {
        return (JO1) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC13042fc3.i(interfaceC9664aL62, "$currentTabType$delegate");
        return l(interfaceC9664aL6).c(k(interfaceC9664aL62));
    }

    private static final boolean o(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC13042fc3.i(interfaceC9664aL62, "$currentTabType$delegate");
        return l(interfaceC9664aL6).g(k(interfaceC9664aL62));
    }

    private static final boolean q(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        AbstractC13042fc3.i(interfaceC9664aL6, "$currentTabType$delegate");
        ua2.invoke(new IO1.b(new InterfaceC18834pK4.a(H(k(interfaceC9664aL6)))));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        AbstractC13042fc3.i(interfaceC9664aL6, "$currentTabType$delegate");
        ua2.invoke(new IO1.b(new InterfaceC18834pK4.b(H(k(interfaceC9664aL6)))));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(UA2 ua2, Context context) {
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        AbstractC13042fc3.i(context, "$context");
        ua2.invoke(new IO1.a(new AbstractC23684xL1.a(context)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$tabTypeStateFlow");
        AbstractC13042fc3.i(interfaceC10258bL62, "$uiStateStateFlow");
        AbstractC13042fc3.i(ua2, "$handleDialogListTopSpotAction");
        j(interfaceC10258bL6, interfaceC10258bL62, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer v(InterfaceC9664aL6 interfaceC9664aL6) {
        C23564x80 c23564x80A;
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC24274yL1 abstractC24274yL1A = l(interfaceC9664aL6).a();
        AbstractC24274yL1.b.a aVar = abstractC24274yL1A instanceof AbstractC24274yL1.b.a ? (AbstractC24274yL1.b.a) abstractC24274yL1A : null;
        if (aVar == null || (c23564x80A = aVar.a()) == null) {
            return null;
        }
        return Integer.valueOf(c23564x80A.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer w(InterfaceC9664aL6 interfaceC9664aL6) {
        return (Integer) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String x(InterfaceC9664aL6 interfaceC9664aL6) {
        C17103mP1 c17103mP1C;
        String strB;
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC24274yL1 abstractC24274yL1A = l(interfaceC9664aL6).a();
        AbstractC24274yL1.b.C1786b c1786b = abstractC24274yL1A instanceof AbstractC24274yL1.b.C1786b ? (AbstractC24274yL1.b.C1786b) abstractC24274yL1A : null;
        return (c1786b == null || (c17103mP1C = c1786b.c()) == null || (strB = c17103mP1C.b()) == null) ? "" : strB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y(InterfaceC9664aL6 interfaceC9664aL6) {
        return (String) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(InterfaceC9664aL6 interfaceC9664aL6) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$topSpotUiState$delegate");
        AbstractC24274yL1 abstractC24274yL1A = l(interfaceC9664aL6).a();
        AbstractC24274yL1.b.C1786b c1786b = abstractC24274yL1A instanceof AbstractC24274yL1.b.C1786b ? (AbstractC24274yL1.b.C1786b) abstractC24274yL1A : null;
        if (c1786b != null) {
            return c1786b.g();
        }
        return false;
    }
}
