package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC21542tj0;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.tj0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC21542tj0 {

    /* renamed from: ir.nasim.tj0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ InterfaceC20315ro1 b;
        final /* synthetic */ C19818qz6 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* renamed from: ir.nasim.tj0$a$a, reason: collision with other inner class name */
        static final class C1597a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1597a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1597a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19818qz6 c19818qz6 = this.c;
                    this.b = 1;
                    if (c19818qz6.o(this) == objE) {
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
                return ((C1597a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = sa2;
            this.b = interfaceC20315ro1;
            this.c = c19818qz6;
            this.d = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(sa2, "$onSkipReview");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isConfirmDialogVisible$delegate");
            AbstractC21542tj0.f(interfaceC9102Ym4, false);
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, C19818qz6 c19818qz6) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isConfirmDialogVisible$delegate");
            AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
            AbstractC21542tj0.f(interfaceC9102Ym4, false);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1597a(c19818qz6, null), 3, null);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            T21 t21 = T21.a;
            InterfaceC14603iB2 interfaceC14603iB2A = t21.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = t21.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(406932510);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.pj0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21542tj0.a.d(sa2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.bot_review_confirm_dialog_ok_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(406941784);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.c);
            final InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.d;
            final C19818qz6 c19818qz6 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.rj0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21542tj0.a.f(interfaceC20315ro1, interfaceC9102Ym42, c19818qz6);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa22, i2, c1454b, (SA2) objB2, AbstractC12217eE5.bot_review_confirm_dialog_cancel_button, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(final C22132uj0 c22132uj0, final String str, final InterfaceC14603iB2 interfaceC14603iB2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        String strA;
        InterfaceC22053ub1 interfaceC22053ub12;
        final InterfaceC9102Ym4 interfaceC9102Ym4;
        Integer numB;
        AbstractC13042fc3.i(str, "botName");
        AbstractC13042fc3.i(interfaceC14603iB2, "onSubmitReview");
        AbstractC13042fc3.i(sa2, "onSkipReview");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1970666697);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c22132uj0) : interfaceC22053ub1J.D(c22132uj0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(43530456);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(true, null, interfaceC22053ub1J, 6, 2);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB2;
            String strC = UY6.c(AbstractC12217eE5.bot_review_title, interfaceC22053ub1J, 0);
            String strD = UY6.d(AbstractC12217eE5.bot_review_description, new Object[]{str}, interfaceC22053ub1J, 0);
            int iIntValue = (c22132uj0 == null || (numB = c22132uj0.b()) == null) ? 0 : numB.intValue();
            if (c22132uj0 == null || (strA = c22132uj0.a()) == null) {
                strA = "";
            }
            String str2 = strA;
            interfaceC22053ub1J.W(43543908);
            int i3 = i2 & 7168;
            boolean z = i3 == 2048;
            Object objB3 = interfaceC22053ub1J.B();
            if (z || objB3 == aVar.a()) {
                objB3 = new InterfaceC14603iB2() { // from class: ir.nasim.jj0
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return AbstractC21542tj0.g(sa2, ((Integer) obj).intValue(), (String) obj2);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            P16.m(strC, strD, (InterfaceC14603iB2) objB3, interfaceC14603iB2, null, c19818qz6L, iIntValue, str2, 0, interfaceC22053ub1J, (i2 << 3) & 7168, 272);
            if (e(interfaceC9102Ym42)) {
                interfaceC22053ub12 = interfaceC22053ub1J;
                interfaceC22053ub12.W(43553107);
                boolean z2 = i3 == 2048;
                Object objB4 = interfaceC22053ub12.B();
                if (z2 || objB4 == aVar.a()) {
                    interfaceC9102Ym4 = interfaceC9102Ym42;
                    objB4 = new SA2() { // from class: ir.nasim.lj0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC21542tj0.h(sa2, interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub12.s(objB4);
                } else {
                    interfaceC9102Ym4 = interfaceC9102Ym42;
                }
                interfaceC22053ub12.Q();
                AbstractC6687Oo.a((SA2) objB4, new C18876pP1(true, true, false, 4, (ED1) null), AbstractC19242q11.e(-1074352389, true, new a(sa2, interfaceC20315ro1, c19818qz6L, interfaceC9102Ym4), interfaceC22053ub12, 54), interfaceC22053ub12, 432, 0);
            } else {
                interfaceC22053ub12 = interfaceC22053ub1J;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.nj0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC21542tj0.i(c22132uj0, str, interfaceC14603iB2, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean e(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2, int i, String str) {
        AbstractC13042fc3.i(sa2, "$onSkipReview");
        AbstractC13042fc3.i(str, "<unused var>");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(sa2, "$onSkipReview");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isConfirmDialogVisible$delegate");
        f(interfaceC9102Ym4, false);
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(C22132uj0 c22132uj0, String str, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$botName");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onSubmitReview");
        AbstractC13042fc3.i(sa2, "$onSkipReview");
        d(c22132uj0, str, interfaceC14603iB2, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
