package ir.nasim;

import ir.nasim.AbstractC10280bO1;
import ir.nasim.AbstractC5914Lj3;
import ir.nasim.IK4;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.JK4;
import ir.nasim.OA2;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.bO1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC10280bO1 {

    /* renamed from: ir.nasim.bO1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ KK4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(KK4 kk4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = kk4;
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
            this.c.Z0(new IK4.d(M72.b));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bO1$b */
    static final class b extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ OnboardingPeer.EmptyStateSuggestedPeer c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.c = emptyStateSuggestedPeer;
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C11458d25 c11458d25I = AbstractC10280bO1.I(this.c.getPeerData().getPeerId(), this.c.getPeerData().getPeerType());
                this.d.invoke(c11458d25I, new EmptyStateOnboardingItemAction.MessageSent(this.c.getButtonText(), this.c.getDescription(), L72.b));
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
            return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bO1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ GT4 c;
        final /* synthetic */ C25038zd6 d;

        /* renamed from: ir.nasim.bO1$c$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C25038zd6 a;

            a(C25038zd6 c25038zd6) {
                this.a = c25038zd6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).intValue(), interfaceC20295rm1);
            }

            public final Object b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.g().invoke(AbstractC6392Nk0.d(i));
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(GT4 gt4, C25038zd6 c25038zd6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = gt4;
            this.d = c25038zd6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int y(GT4 gt4) {
            return gt4.v();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final GT4 gt4 = this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC10222bH6.r(new SA2() { // from class: ir.nasim.cO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Integer.valueOf(AbstractC10280bO1.c.y(gt4));
                    }
                }));
                a aVar = new a(this.d);
                this.b = 1;
                if (interfaceC4557Fq2V.b(aVar, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bO1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ GT4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = gt4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                int iH = this.c % this.d.H();
                if (this.d.v() != iH) {
                    GT4 gt4 = this.d;
                    this.b = 1;
                    if (GT4.d0(gt4, iH, 0.0f, this, 2, null) == objE) {
                        return objE;
                    }
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.bO1$e */
    static final class e implements InterfaceC16978mB2 {
        final /* synthetic */ JK4 a;
        final /* synthetic */ C25038zd6 b;

        e(JK4 jk4, C25038zd6 c25038zd6) {
            this.a = jk4;
            this.b = c25038zd6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C25038zd6 c25038zd6, P07 p07) {
            AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
            AbstractC13042fc3.i(p07, "$item");
            c25038zd6.f().invoke(p07.d());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C25038zd6 c25038zd6, P07 p07) {
            AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
            AbstractC13042fc3.i(p07, "$item");
            c25038zd6.h().invoke(p07.d());
            return C19938rB7.a;
        }

        public final void c(InterfaceC22573vT4 interfaceC22573vT4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            EV4 ev4H;
            InterfaceC19114po0 interfaceC19114po0;
            AbstractC13042fc3.i(interfaceC22573vT4, "$this$HorizontalPager");
            final P07 p07 = (P07) ((JK4.b.d) this.a.e()).f().get(i);
            if (p07.d().getPeerData().getAvatar() == null) {
                interfaceC22053ub1.W(-377753907);
                ev4H = coil.compose.e.a(null, null, null, null, 0, null, interfaceC22053ub1, 6, 62);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-377668595);
                ev4H = AvatarAsyncImagePainterKt.h(p07.d().getPeerData().getAvatar(), null, false, 0, interfaceC22053ub1, 0, 14);
                interfaceC22053ub1.Q();
            }
            EV4 ev4 = ev4H;
            String name = p07.d().getPeerData().getName();
            String description = p07.d().getDescription();
            String buttonText = p07.d().getButtonText();
            AbstractC5914Lj3 abstractC5914Lj3C = p07.c();
            if (abstractC5914Lj3C instanceof AbstractC5914Lj3.c) {
                interfaceC19114po0 = InterfaceC19114po0.b.a.a;
            } else if (abstractC5914Lj3C instanceof AbstractC5914Lj3.b) {
                interfaceC19114po0 = OA2.a.b;
            } else {
                if (!(abstractC5914Lj3C instanceof AbstractC5914Lj3.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC19114po0 = InterfaceC19114po0.b.a.a;
            }
            InterfaceC19114po0 interfaceC19114po02 = interfaceC19114po0;
            boolean hasBlueTick = p07.d().getPeerData().getHasBlueTick();
            interfaceC22053ub1.W(-1120537312);
            boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(p07);
            final C25038zd6 c25038zd6 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.dO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10280bO1.e.d(c25038zd6, p07);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1120533537);
            boolean zV2 = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(p07);
            final C25038zd6 c25038zd62 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.eO1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10280bO1.e.f(c25038zd62, p07);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            N07.e(null, ev4, name, description, interfaceC19114po02, buttonText, hasBlueTick, false, sa2, (SA2) objB2, interfaceC22053ub1, 0, 129);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            c((InterfaceC22573vT4) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bO1$f */
    public /* synthetic */ class f {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.E0(interfaceC11943do6, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 0.0f);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 1.0f);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.p0(interfaceC11943do6, B26.b.b());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(JK4 jk4, C25038zd6 c25038zd6, int i, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        x(jk4, c25038zd6, i, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void F(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-246176105);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C16918m51.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.NN1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10280bO1.G(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        F(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C11458d25 I(int i, ExPeerType exPeerType) {
        int i2 = exPeerType == null ? -1 : f.a[exPeerType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            C11458d25 c11458d25E = C11458d25.E(i);
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            return c11458d25E;
        }
        C11458d25 c11458d25Y = C11458d25.y(i);
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        return c11458d25Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final ir.nasim.InterfaceC14603iB2 r19, ir.nasim.KK4 r20, ir.nasim.InterfaceC22053ub1 r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10280bO1.o(ir.nasim.iB2, ir.nasim.KK4, ir.nasim.ub1, int, int):void");
    }

    private static final JK4 p(InterfaceC9664aL6 interfaceC9664aL6) {
        return (JK4) interfaceC9664aL6.getValue();
    }

    private static final int q(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(InterfaceC14603iB2 interfaceC14603iB2, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
        interfaceC14603iB2.invoke(I(emptyStateSuggestedPeer.getPeerData().getPeerId(), emptyStateSuggestedPeer.getPeerData().getPeerType()), new EmptyStateOnboardingItemAction.Opened(emptyStateSuggestedPeer.getButtonText(), emptyStateSuggestedPeer.getDescription(), L72.b));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(KK4 kk4, int i) {
        kk4.h1(i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(InterfaceC14603iB2 interfaceC14603iB2, KK4 kk4, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        o(interfaceC14603iB2, kk4, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC14603iB2 interfaceC14603iB2, KK4 kk4, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        o(interfaceC14603iB2, kk4, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(KK4 kk4) {
        kk4.Z0(IK4.a.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(KK4 kk4, InterfaceC14603iB2 interfaceC14603iB2, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
        kk4.Z0(new IK4.b(emptyStateSuggestedPeer.getPeerData().getPeerId(), emptyStateSuggestedPeer.getPeerData().getPeerType(), new b(emptyStateSuggestedPeer, interfaceC14603iB2, null)));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void x(final ir.nasim.JK4 r38, final ir.nasim.C25038zd6 r39, final int r40, androidx.compose.ui.e r41, ir.nasim.InterfaceC22053ub1 r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 1205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10280bO1.x(ir.nasim.JK4, ir.nasim.zd6, int, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(JK4 jk4, C25038zd6 c25038zd6, int i, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        x(jk4, c25038zd6, i, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int z(JK4 jk4) {
        AbstractC13042fc3.i(jk4, "$uiState");
        return ((JK4.b.d) jk4.e()).f().size();
    }
}
