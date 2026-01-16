package ir.nasim;

import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20855sj0;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.sj0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20855sj0 {

    /* renamed from: ir.nasim.sj0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ InterfaceC20315ro1 b;
        final /* synthetic */ C19818qz6 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* renamed from: ir.nasim.sj0$a$a, reason: collision with other inner class name */
        static final class C1545a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19818qz6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1545a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19818qz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1545a(this.c, interfaceC20295rm1);
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
                return ((C1545a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
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
            AbstractC20855sj0.f(interfaceC9102Ym4, false);
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, C19818qz6 c19818qz6) {
            AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isConfirmDialogVisible$delegate");
            AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
            AbstractC20855sj0.f(interfaceC9102Ym4, false);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1545a(c19818qz6, null), 3, null);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            U21 u21 = U21.a;
            InterfaceC14603iB2 interfaceC14603iB2A = u21.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = u21.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-866747937);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.oj0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC20855sj0.a.d(sa2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.bot_review_confirm_dialog_ok_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-866738663);
            boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.c);
            final InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.d;
            final C19818qz6 c19818qz6 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.qj0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC20855sj0.a.f(interfaceC20315ro1, interfaceC9102Ym42, c19818qz6);
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

    /* JADX WARN: Removed duplicated region for block: B:106:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final ir.nasim.C22132uj0 r28, final java.lang.String r29, final ir.nasim.InterfaceC14603iB2 r30, final ir.nasim.SA2 r31, androidx.compose.ui.e r32, ir.nasim.InterfaceC22053ub1 r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20855sj0.d(ir.nasim.uj0, java.lang.String, ir.nasim.iB2, ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
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
    public static final C19938rB7 i(C22132uj0 c22132uj0, String str, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$botName");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onSubmitReview");
        AbstractC13042fc3.i(sa2, "$onSkipReview");
        d(c22132uj0, str, interfaceC14603iB2, sa2, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
