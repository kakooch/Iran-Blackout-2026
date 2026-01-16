package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import ir.nasim.AbstractC18693p53;
import ir.nasim.C17448mz0;
import ir.nasim.C21753u45;
import ir.nasim.D20;
import ir.nasim.Z20;

/* renamed from: ir.nasim.p53, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18693p53 {

    /* renamed from: ir.nasim.p53$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ InterfaceC9102Ym4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = sa2;
            this.e = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c) {
                    this.b = 1;
                    if (HG1.b(300L, this) == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Z20 z20I = AbstractC18693p53.i(this.e);
            if (z20I != null) {
                Z20.a.b(z20I, 50, 0, 2, null);
            }
            this.d.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.p53$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ D20.a a;
        final /* synthetic */ InterfaceC9102Ym4 b;

        b(D20.a aVar, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = aVar;
            this.b = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4, Z20 z20) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$balloonWindow$delegate");
            AbstractC13042fc3.i(z20, "it");
            AbstractC18693p53.o(interfaceC9102Ym4, z20);
            return C19938rB7.a;
        }

        public final void b(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC15796kB2, "content");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.D(interfaceC15796kB2) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            D20.a aVar = this.a;
            interfaceC22053ub1.W(252323825);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.q53
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC18693p53.b.c(interfaceC9102Ym4, (Z20) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            J20.a(null, aVar, null, null, (UA2) objB, null, interfaceC15796kB2, interfaceC22053ub1, ((i << 18) & 3670016) | 24576, 45);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC15796kB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:215:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final ir.nasim.AbstractC7031Pz0 r34, final ir.nasim.C17448mz0.a r35, final ir.nasim.InterfaceC8534Wj4 r36, final ir.nasim.SA2 r37, final boolean r38, final ir.nasim.SA2 r39, final boolean r40, final android.content.Context r41, final ir.nasim.UA2 r42, final ir.nasim.SA2 r43, final ir.nasim.SA2 r44, final boolean r45, final ir.nasim.SA2 r46, final boolean r47, ir.nasim.InterfaceC22053ub1 r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 1306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18693p53.h(ir.nasim.Pz0, ir.nasim.mz0$a, ir.nasim.Wj4, ir.nasim.SA2, boolean, ir.nasim.SA2, boolean, android.content.Context, ir.nasim.UA2, ir.nasim.SA2, ir.nasim.SA2, boolean, ir.nasim.SA2, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z20 i(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (Z20) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onToggleVoice");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onToggleVoice");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(Context context, UA2 ua2, SA2 sa2) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(ua2, "$onPermissionRequired");
        AbstractC13042fc3.i(sa2, "$onToggleVideo");
        if (AbstractC4043Dl1.a(context, "android.permission.CAMERA") != 0) {
            ua2.invoke(C21753u45.d.f);
        } else {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onEndCallClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(AbstractC7031Pz0 abstractC7031Pz0, C17448mz0.a aVar, InterfaceC8534Wj4 interfaceC8534Wj4, SA2 sa2, boolean z, SA2 sa22, boolean z2, Context context, UA2 ua2, SA2 sa23, SA2 sa24, boolean z3, SA2 sa25, boolean z4, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(aVar, "$callState");
        AbstractC13042fc3.i(interfaceC8534Wj4, "$moreOptionButtonState");
        AbstractC13042fc3.i(sa2, "$onOpenMoreMenuClicked");
        AbstractC13042fc3.i(sa22, "$onToggleVoice");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(ua2, "$onPermissionRequired");
        AbstractC13042fc3.i(sa23, "$onToggleVideo");
        AbstractC13042fc3.i(sa24, "$onEndCallClicked");
        AbstractC13042fc3.i(sa25, "$onRecordToolTipShowed");
        h(abstractC7031Pz0, aVar, interfaceC8534Wj4, sa2, z, sa22, z2, context, ua2, sa23, sa24, z3, sa25, z4, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(InterfaceC9102Ym4 interfaceC9102Ym4, Z20 z20) {
        interfaceC9102Ym4.setValue(z20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C9348Zn7 c9348Zn7, D20.a aVar) {
        AbstractC13042fc3.i(c9348Zn7, "$balloonTextStyle");
        AbstractC13042fc3.i(aVar, "$this$rememberBalloonBuilder");
        aVar.d1(10);
        aVar.a1(0.5f);
        aVar.c1(EnumC12874fK.b);
        aVar.d2(BD5.call_record_tooltip);
        C3418Au2 c3418Au2M = c9348Zn7.m();
        if (c3418Au2M != null) {
            aVar.g2(c3418Au2M.i());
        }
        aVar.e2(C13193fo7.h(c9348Zn7.l()));
        H20.b(aVar, C24381yX0.b.a());
        H20.a(aVar, AbstractC24067xz3.S());
        aVar.l1(8.0f);
        aVar.P1(12);
        aVar.V1(8);
        aVar.H1(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        aVar.f1(5000L);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onOpenMoreMenuClicked");
        sa2.invoke();
        return C19938rB7.a;
    }
}
