package ir.nasim;

import ir.nasim.IK4;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;

/* renamed from: ir.nasim.Th1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC7809Th1 {

    /* renamed from: ir.nasim.Th1$a */
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
            this.c.Z0(new IK4.d(M72.c));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Th1$b */
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
                C11458d25 c11458d25F = AbstractC7809Th1.F(this.c.getPeerData().getPeerId(), this.c.getPeerData().getPeerType());
                this.d.invoke(c11458d25F, new EmptyStateOnboardingItemAction.MessageSent(this.c.getButtonText(), this.c.getDescription(), L72.c));
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

    /* renamed from: ir.nasim.Th1$c */
    public /* synthetic */ class c {
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
    public static final C19938rB7 A(C25038zd6 c25038zd6, P07 p07) {
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        AbstractC13042fc3.i(p07, "$item");
        c25038zd6.h().invoke(p07.d());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(JK4 jk4, C25038zd6 c25038zd6, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        u(jk4, c25038zd6, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void C(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(666907108);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, N31.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Gh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7809Th1.D(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        C(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C11458d25 F(int i, ExPeerType exPeerType) {
        int i2 = exPeerType == null ? -1 : c.a[exPeerType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            C11458d25 c11458d25E = C11458d25.E(i);
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            return c11458d25E;
        }
        C11458d25 c11458d25Y = C11458d25.y(i);
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        return c11458d25Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(final ir.nasim.InterfaceC14603iB2 r20, ir.nasim.KK4 r21, ir.nasim.InterfaceC22053ub1 r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7809Th1.n(ir.nasim.iB2, ir.nasim.KK4, ir.nasim.ub1, int, int):void");
    }

    private static final JK4 o(InterfaceC9664aL6 interfaceC9664aL6) {
        return (JK4) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(InterfaceC14603iB2 interfaceC14603iB2, KK4 kk4, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        n(interfaceC14603iB2, kk4, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(InterfaceC14603iB2 interfaceC14603iB2, KK4 kk4, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        n(interfaceC14603iB2, kk4, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(KK4 kk4) {
        kk4.Z0(IK4.a.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(KK4 kk4, InterfaceC14603iB2 interfaceC14603iB2, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
        kk4.Z0(new IK4.b(emptyStateSuggestedPeer.getPeerData().getPeerId(), emptyStateSuggestedPeer.getPeerData().getPeerType(), new b(emptyStateSuggestedPeer, interfaceC14603iB2, null)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(InterfaceC14603iB2 interfaceC14603iB2, OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$openDialog");
        AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
        interfaceC14603iB2.invoke(F(emptyStateSuggestedPeer.getPeerData().getPeerId(), emptyStateSuggestedPeer.getPeerData().getPeerType()), new EmptyStateOnboardingItemAction.Opened(emptyStateSuggestedPeer.getButtonText(), emptyStateSuggestedPeer.getDescription(), L72.c));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u(final ir.nasim.JK4 r40, final ir.nasim.C25038zd6 r41, androidx.compose.ui.e r42, ir.nasim.InterfaceC22053ub1 r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 1348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7809Th1.u(ir.nasim.JK4, ir.nasim.zd6, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(JK4 jk4, C25038zd6 c25038zd6, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        u(jk4, c25038zd6, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.E0(interfaceC11943do6, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 0.0f);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.F0(interfaceC11943do6, 1.0f);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(C25038zd6 c25038zd6, P07 p07) {
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        AbstractC13042fc3.i(p07, "$item");
        c25038zd6.f().invoke(p07.d());
        return C19938rB7.a;
    }
}
