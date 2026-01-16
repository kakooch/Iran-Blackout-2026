package ir.nasim;

/* loaded from: classes4.dex */
public abstract class FA1 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC15796kB2 c;
        final /* synthetic */ InterfaceC17916nm4 d;
        final /* synthetic */ InterfaceC17916nm4 e;
        final /* synthetic */ InterfaceC17916nm4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC17916nm4 interfaceC17916nm42, InterfaceC17916nm4 interfaceC17916nm43, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC15796kB2;
            this.d = interfaceC17916nm4;
            this.e = interfaceC17916nm42;
            this.f = interfaceC17916nm43;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.q(AbstractC6392Nk0.d(FA1.m(this.d)), AbstractC6392Nk0.d(FA1.o(this.e)), AbstractC6392Nk0.d(FA1.q(this.f)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(final ir.nasim.HA1 r27, androidx.compose.ui.e r28, ir.nasim.C9348Zn7 r29, final ir.nasim.InterfaceC15796kB2 r30, ir.nasim.InterfaceC22053ub1 r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FA1.g(ir.nasim.HA1, androidx.compose.ui.e, ir.nasim.Zn7, ir.nasim.kB2, ir.nasim.ub1, int, int):void");
    }

    private static final HA1 h(InterfaceC9664aL6 interfaceC9664aL6) {
        return (HA1) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        AbstractC13042fc3.i(interfaceC17916nm4, "$selectedDay$delegate");
        r(interfaceC17916nm4, i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC17916nm4 interfaceC17916nm4, String str) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$currentState$delegate");
        AbstractC13042fc3.i(interfaceC17916nm4, "$selectedMonth$delegate");
        AbstractC13042fc3.i(str, "it");
        p(interfaceC17916nm4, h(interfaceC9664aL6).b().indexOf(str));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        AbstractC13042fc3.i(interfaceC17916nm4, "$selectedYear$delegate");
        n(interfaceC17916nm4, i);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(HA1 ha1, androidx.compose.ui.e eVar, C9348Zn7 c9348Zn7, InterfaceC15796kB2 interfaceC15796kB2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ha1, "$state");
        AbstractC13042fc3.i(interfaceC15796kB2, "$onDateChanged");
        g(ha1, eVar, c9348Zn7, interfaceC15796kB2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    private static final void n(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    private static final void p(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    private static final void r(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    public static final void s(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1767954975);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            HA1 ha1 = new HA1(AbstractC7783Te2.d(AbstractC15401jX0.m1(new C24411ya3(2000, 2030))), AbstractC7783Te2.d(AbstractC10360bX0.p("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")), AbstractC7783Te2.d(AbstractC15401jX0.m1(new C24411ya3(1, 31))), 2023, 5, 15);
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(16));
            interfaceC22053ub1J.W(-2056493628);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC15796kB2() { // from class: ir.nasim.zA1
                    @Override // ir.nasim.InterfaceC15796kB2
                    public final Object q(Object obj, Object obj2, Object obj3) {
                        return FA1.t(((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            g(ha1, eVarI, null, (InterfaceC15796kB2) objB, interfaceC22053ub1J, 3120, 4);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.AA1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return FA1.u(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(int i, int i2, int i3) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        s(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
