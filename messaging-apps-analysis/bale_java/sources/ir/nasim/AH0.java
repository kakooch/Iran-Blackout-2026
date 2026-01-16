package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes6.dex */
public final class AH0 {
    public static final AH0 a = new AH0();
    private static InterfaceC8327Vm4 b;
    private static InterfaceC8327Vm4 c;
    private static InterfaceC8327Vm4 d;
    private static final InterfaceC20315ro1 e;
    private static final BankingModule f;
    public static final int g;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.AH0$a$a, reason: collision with other inner class name */
        static final class C0259a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            C0259a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0259a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    AH0 ah0 = AH0.a;
                    this.b = 1;
                    if (ah0.t(this) == objE) {
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
                return ((C0259a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new C0259a(null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.e(null, this);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.f(null, this);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.g(null, this);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.h(null, this);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.i(null, 0, 0, null, this);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.r(this);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    AH0 ah0 = AH0.a;
                    if (ah0.m().e().isEmpty()) {
                        ArrayList arrayListZ1 = AH0.f.Z1(BankCreditCard.c.b);
                        if (ah0.m().e().isEmpty()) {
                            InterfaceC8327Vm4 interfaceC8327Vm4M = ah0.m();
                            if (arrayListZ1 == null) {
                                arrayListZ1 = new ArrayList();
                            }
                            this.b = 1;
                            if (interfaceC8327Vm4M.a(arrayListZ1, this) == objE) {
                                return objE;
                            }
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(interfaceC20295rm1);
            hVar.c = obj;
            return hVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.s(this);
        }
    }

    static final class j extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.t(this);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x007d A[SYNTHETIC] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.c
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L23
                    if (r1 == r3) goto L1b
                    if (r1 != r2) goto L13
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L93
                L13:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1b:
                    java.lang.Object r1 = r5.b
                    java.util.ArrayList r1 = (java.util.ArrayList) r1
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L64
                L23:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.AH0 r6 = ir.nasim.AH0.a
                    ir.nasim.Vm4 r1 = r6.p()
                    java.util.List r1 = r1.e()
                    boolean r1 = r1.isEmpty()
                    if (r1 == 0) goto L93
                    ir.nasim.core.modules.banking.BankingModule r1 = ir.nasim.AH0.d()
                    ir.nasim.features.payment.data.model.BankCreditCard$c r4 = ir.nasim.features.payment.data.model.BankCreditCard.c.a
                    java.util.ArrayList r1 = r1.Z1(r4)
                    if (r1 != 0) goto L47
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                L47:
                    ir.nasim.Vm4 r4 = r6.p()
                    java.util.List r4 = r4.e()
                    boolean r4 = r4.isEmpty()
                    if (r4 == 0) goto L64
                    ir.nasim.Vm4 r6 = r6.p()
                    r5.b = r1
                    r5.c = r3
                    java.lang.Object r6 = r6.a(r1, r5)
                    if (r6 != r0) goto L64
                    return r0
                L64:
                    java.util.Iterator r6 = r1.iterator()
                L68:
                    boolean r1 = r6.hasNext()
                    r3 = 0
                    if (r1 == 0) goto L7d
                    java.lang.Object r1 = r6.next()
                    r4 = r1
                    ir.nasim.features.payment.data.model.BankCreditCard r4 = (ir.nasim.features.payment.data.model.BankCreditCard) r4
                    boolean r4 = r4.isDefault()
                    if (r4 == 0) goto L68
                    goto L7e
                L7d:
                    r1 = r3
                L7e:
                    ir.nasim.features.payment.data.model.BankCreditCard r1 = (ir.nasim.features.payment.data.model.BankCreditCard) r1
                    if (r1 == 0) goto L93
                    ir.nasim.AH0 r6 = ir.nasim.AH0.a
                    ir.nasim.Vm4 r6 = r6.k()
                    r5.b = r3
                    r5.c = r2
                    java.lang.Object r6 = r6.a(r1, r5)
                    if (r6 != r0) goto L93
                    return r0
                L93:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.k.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AH0.this.u(null, this);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ BankCreditCard c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(BankCreditCard bankCreditCard, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bankCreditCard;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new m(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4K = AH0.a.k();
                BankCreditCard bankCreditCard = this.c;
                this.b = 1;
                if (interfaceC8327Vm4K.a(bankCreditCard, this) == objE) {
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        EnumC6162Ml0 enumC6162Ml0 = EnumC6162Ml0.DROP_OLDEST;
        b = AbstractC11420cy6.b(1, 0, enumC6162Ml0, 2, null);
        c = AbstractC11420cy6.b(1, 0, enumC6162Ml0, 2, null);
        d = AbstractC11420cy6.b(1, 0, enumC6162Ml0, 2, null);
        e = AbstractC20906so1.a(C12366eV1.c());
        f = AbstractC5969Lp4.e().y();
        AbstractC10533bm0.d(C17050mJ2.a, C12366eV1.c(), null, new a(null), 2, null);
        g = 8;
    }

    private AH0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList j(BankCreditCard bankCreditCard, C12889fL5 c12889fL5) {
        AbstractC13042fc3.i(bankCreditCard, "$bankCard");
        AbstractC13042fc3.i(c12889fL5, "$card");
        ArrayList<BankCreditCard> arrayList = new ArrayList(a.q());
        for (BankCreditCard bankCreditCard2 : arrayList) {
            if (AbstractC13042fc3.d(bankCreditCard2.getId(), bankCreditCard.getId())) {
                bankCreditCard2.setExpirationMonth(bankCreditCard.getExpirationMonth());
                bankCreditCard2.setExpirationYear(bankCreditCard.getExpirationYear());
                bankCreditCard2.setCvv2(bankCreditCard.getCvv2());
                c12889fL5.a = bankCreditCard2;
            }
        }
        a.x(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList v(BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(bankCreditCard, "$bankCard");
        AbstractC10533bm0.d(e, null, null, new m(bankCreditCard, null), 3, null);
        ArrayList<BankCreditCard> arrayList = new ArrayList(a.q());
        for (BankCreditCard bankCreditCard2 : arrayList) {
            bankCreditCard2.setDefault(AbstractC13042fc3.d(bankCreditCard2.getId(), bankCreditCard.getId()));
        }
        a.x(arrayList);
        return arrayList;
    }

    private final void x(ArrayList arrayList) {
        AbstractC12992fX0.B(arrayList, new Comparator() { // from class: ir.nasim.xH0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AH0.y((BankCreditCard) obj, (BankCreditCard) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int y(BankCreditCard bankCreditCard, BankCreditCard bankCreditCard2) {
        if (bankCreditCard2.isDefault()) {
            return 1;
        }
        if (bankCreditCard.isDefault()) {
            return -1;
        }
        if (!bankCreditCard.isEnrolled() && bankCreditCard2.isEnrolled()) {
            return 1;
        }
        if (bankCreditCard.isEnrolled() && !bankCreditCard2.isEnrolled()) {
            return -1;
        }
        if (bankCreditCard.isShaparkMigrationNeed() && !bankCreditCard2.isShaparkMigrationNeed()) {
            return 1;
        }
        if (bankCreditCard.isShaparkMigrationNeed() || !bankCreditCard2.isShaparkMigrationNeed()) {
            return bankCreditCard.getNumber().compareTo(bankCreditCard2.getNumber());
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ir.nasim.features.payment.data.model.BankCreditCard r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.AH0.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.AH0$b r0 = (ir.nasim.AH0.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.AH0$b r0 = new ir.nasim.AH0$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.a
            ir.nasim.features.payment.data.model.BankCreditCard r6 = (ir.nasim.features.payment.data.model.BankCreditCard) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L76
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.a
            ir.nasim.AH0 r6 = (ir.nasim.AH0) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L55
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.core.modules.banking.BankingModule r7 = ir.nasim.AH0.f
            ir.nasim.Nv5 r6 = r7.R0(r6)
            r0.a = r5
            r0.d = r4
            java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.a(r6, r0)
            if (r7 != r1) goto L54
            return r1
        L54:
            r6 = r5
        L55:
            ir.nasim.features.payment.data.model.BankCreditCard r7 = (ir.nasim.features.payment.data.model.BankCreditCard) r7
            ir.nasim.Vm4 r2 = ir.nasim.AH0.c
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.ArrayList r6 = r6.n()
            r4.<init>(r6)
            r4.add(r7)
            ir.nasim.AH0 r6 = ir.nasim.AH0.a
            r6.x(r4)
            r0.a = r7
            r0.d = r3
            java.lang.Object r6 = r2.a(r4, r0)
            if (r6 != r1) goto L75
            return r1
        L75:
            r6 = r7
        L76:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.e(ir.nasim.features.payment.data.model.BankCreditCard, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.features.payment.data.model.BankCreditCard r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.AH0.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.AH0$c r0 = (ir.nasim.AH0.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.AH0$c r0 = new ir.nasim.AH0$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.a
            ir.nasim.features.payment.data.model.BankCreditCard r6 = (ir.nasim.features.payment.data.model.BankCreditCard) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L76
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.a
            ir.nasim.AH0 r6 = (ir.nasim.AH0) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L55
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.core.modules.banking.BankingModule r7 = ir.nasim.AH0.f
            ir.nasim.Nv5 r6 = r7.Y0(r6)
            r0.a = r5
            r0.d = r4
            java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.a(r6, r0)
            if (r7 != r1) goto L54
            return r1
        L54:
            r6 = r5
        L55:
            ir.nasim.features.payment.data.model.BankCreditCard r7 = (ir.nasim.features.payment.data.model.BankCreditCard) r7
            ir.nasim.Vm4 r2 = ir.nasim.AH0.b
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.ArrayList r6 = r6.q()
            r4.<init>(r6)
            r4.add(r7)
            ir.nasim.AH0 r6 = ir.nasim.AH0.a
            r6.x(r4)
            r0.a = r7
            r0.d = r3
            java.lang.Object r6 = r2.a(r4, r0)
            if (r6 != r1) goto L75
            return r1
        L75:
            r6 = r7
        L76:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.f(ir.nasim.features.payment.data.model.BankCreditCard, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.features.payment.data.model.BankCreditCard r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.AH0.d
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.AH0$d r0 = (ir.nasim.AH0.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.AH0$d r0 = new ir.nasim.AH0$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L43
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r9)
            goto L8f
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            java.lang.Object r8 = r0.b
            ir.nasim.Vm4 r8 = (ir.nasim.InterfaceC8327Vm4) r8
            java.lang.Object r2 = r0.a
            ir.nasim.features.payment.data.model.BankCreditCard r2 = (ir.nasim.features.payment.data.model.BankCreditCard) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L77
        L43:
            java.lang.Object r8 = r0.a
            ir.nasim.features.payment.data.model.BankCreditCard r8 = (ir.nasim.features.payment.data.model.BankCreditCard) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L5f
        L4b:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.core.modules.banking.BankingModule r9 = ir.nasim.AH0.f
            ir.nasim.Nv5 r9 = r9.B2(r8)
            r0.a = r8
            r0.e = r5
            java.lang.Object r9 = ir.nasim.AbstractC6756Ov5.a(r9, r0)
            if (r9 != r1) goto L5f
            return r1
        L5f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            r9.booleanValue()
            ir.nasim.Vm4 r9 = ir.nasim.AH0.c
            r0.a = r8
            r0.b = r9
            r0.e = r4
            java.lang.Object r2 = ir.nasim.AbstractC6459Nq2.G(r9, r0)
            if (r2 != r1) goto L73
            return r1
        L73:
            r6 = r2
            r2 = r8
            r8 = r9
            r9 = r6
        L77:
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r9)
            r4.remove(r2)
            r9 = 0
            r0.a = r9
            r0.b = r9
            r0.e = r3
            java.lang.Object r8 = r8.a(r4, r0)
            if (r8 != r1) goto L8f
            return r1
        L8f:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.g(ir.nasim.features.payment.data.model.BankCreditCard, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.features.payment.data.model.BankCreditCard r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.AH0.e
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.AH0$e r0 = (ir.nasim.AH0.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.AH0$e r0 = new ir.nasim.AH0$e
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L43
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r9)
            goto L94
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            java.lang.Object r8 = r0.b
            ir.nasim.Vm4 r8 = (ir.nasim.InterfaceC8327Vm4) r8
            java.lang.Object r2 = r0.a
            ir.nasim.features.payment.data.model.BankCreditCard r2 = (ir.nasim.features.payment.data.model.BankCreditCard) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L77
        L43:
            java.lang.Object r8 = r0.a
            ir.nasim.features.payment.data.model.BankCreditCard r8 = (ir.nasim.features.payment.data.model.BankCreditCard) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L5f
        L4b:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.core.modules.banking.BankingModule r9 = ir.nasim.AH0.f
            ir.nasim.Nv5 r9 = r9.H2(r8)
            r0.a = r8
            r0.e = r5
            java.lang.Object r9 = ir.nasim.AbstractC6756Ov5.a(r9, r0)
            if (r9 != r1) goto L5f
            return r1
        L5f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            r9.booleanValue()
            ir.nasim.Vm4 r9 = ir.nasim.AH0.b
            r0.a = r8
            r0.b = r9
            r0.e = r4
            java.lang.Object r2 = ir.nasim.AbstractC6459Nq2.G(r9, r0)
            if (r2 != r1) goto L73
            return r1
        L73:
            r6 = r2
            r2 = r8
            r8 = r9
            r9 = r6
        L77:
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r9)
            r4.remove(r2)
            ir.nasim.AH0 r9 = ir.nasim.AH0.a
            r9.x(r4)
            r9 = 0
            r0.a = r9
            r0.b = r9
            r0.e = r3
            java.lang.Object r8 = r8.a(r4, r0)
            if (r8 != r1) goto L94
            return r1
        L94:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.h(ir.nasim.features.payment.data.model.BankCreditCard, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(final ir.nasim.features.payment.data.model.BankCreditCard r7, int r8, int r9, java.lang.String r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof ir.nasim.AH0.f
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.AH0$f r0 = (ir.nasim.AH0.f) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.AH0$f r0 = new ir.nasim.AH0$f
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.a
            ir.nasim.fL5 r7 = (ir.nasim.C12889fL5) r7
            ir.nasim.AbstractC10685c16.b(r11)
            goto L78
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r7 = r0.b
            ir.nasim.Vm4 r7 = (ir.nasim.InterfaceC8327Vm4) r7
            java.lang.Object r8 = r0.a
            ir.nasim.fL5 r8 = (ir.nasim.C12889fL5) r8
            ir.nasim.AbstractC10685c16.b(r11)
            goto L69
        L44:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.fL5 r11 = new ir.nasim.fL5
            r11.<init>()
            ir.nasim.Vm4 r2 = ir.nasim.AH0.b
            ir.nasim.core.modules.banking.BankingModule r5 = ir.nasim.AH0.f
            ir.nasim.Nv5 r8 = r5.n1(r7, r8, r9, r10)
            ir.nasim.zH0 r9 = new ir.nasim.zH0
            r9.<init>()
            r0.a = r11
            r0.b = r2
            r0.e = r4
            java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.b(r8, r9, r0)
            if (r7 != r1) goto L66
            return r1
        L66:
            r8 = r11
            r11 = r7
            r7 = r2
        L69:
            r0.a = r8
            r9 = 0
            r0.b = r9
            r0.e = r3
            java.lang.Object r7 = r7.a(r11, r0)
            if (r7 != r1) goto L77
            return r1
        L77:
            r7 = r8
        L78:
            java.lang.Object r7 = r7.a
            ir.nasim.AbstractC13042fc3.f(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.i(ir.nasim.features.payment.data.model.BankCreditCard, int, int, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC8327Vm4 k() {
        return d;
    }

    public final BankCreditCard l() {
        for (BankCreditCard bankCreditCard : q()) {
            if (bankCreditCard.isDefault()) {
                return bankCreditCard;
            }
        }
        return null;
    }

    public final InterfaceC8327Vm4 m() {
        return c;
    }

    public final ArrayList n() {
        List listE = c.e();
        return listE.isEmpty() ^ true ? (ArrayList) AbstractC15401jX0.q0(listE) : new ArrayList();
    }

    public final InterfaceC20315ro1 o() {
        return e;
    }

    public final InterfaceC8327Vm4 p() {
        return b;
    }

    public final ArrayList q() {
        List listE = b.e();
        return listE.isEmpty() ^ true ? (ArrayList) AbstractC15401jX0.q0(listE) : new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.AH0.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.AH0$g r0 = (ir.nasim.AH0.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.AH0$g r0 = new ir.nasim.AH0$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L44
            if (r2 == r6) goto L40
            if (r2 == r5) goto L38
            if (r2 != r4) goto L30
            ir.nasim.AbstractC10685c16.b(r8)
            goto L77
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            java.lang.Object r2 = r0.a
            ir.nasim.Vm4 r2 = (ir.nasim.InterfaceC8327Vm4) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6c
        L40:
            ir.nasim.AbstractC10685c16.b(r8)
            goto L59
        L44:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.do1 r8 = r0.getContext()
            ir.nasim.AH0$h r2 = new ir.nasim.AH0$h
            r2.<init>(r3)
            r0.d = r6
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            ir.nasim.Vm4 r2 = ir.nasim.AH0.c
            ir.nasim.core.modules.banking.BankingModule r8 = ir.nasim.AH0.f
            ir.nasim.Nv5 r8 = r8.Q1()
            r0.a = r2
            r0.d = r5
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.a(r8, r0)
            if (r8 != r1) goto L6c
            return r1
        L6c:
            r0.a = r3
            r0.d = r4
            java.lang.Object r8 = r2.a(r8, r0)
            if (r8 != r1) goto L77
            return r1
        L77:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.r(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.AH0.i
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.AH0$i r0 = (ir.nasim.AH0.i) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.AH0$i r0 = new ir.nasim.AH0$i
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            ir.nasim.AbstractC10685c16.b(r8)
            goto La0
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            java.lang.Object r2 = r0.a
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L76
        L41:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            goto L5d
        L4b:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.core.modules.banking.BankingModule r8 = ir.nasim.AH0.f
            ir.nasim.Nv5 r8 = r8.R1()
            r0.d = r5
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r6, r0, r5, r6)
            if (r8 != r1) goto L5d
            return r1
        L5d:
            boolean r2 = ir.nasim.C9475a16.g(r8)
            if (r2 == 0) goto L64
            r8 = r6
        L64:
            r2 = r8
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            if (r2 == 0) goto La0
            ir.nasim.Vm4 r8 = ir.nasim.AH0.b
            r0.a = r2
            r0.d = r4
            java.lang.Object r8 = r8.a(r2, r0)
            if (r8 != r1) goto L76
            return r1
        L76:
            java.util.Iterator r8 = r2.iterator()
        L7a:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r8.next()
            r4 = r2
            ir.nasim.features.payment.data.model.BankCreditCard r4 = (ir.nasim.features.payment.data.model.BankCreditCard) r4
            boolean r4 = r4.isDefault()
            if (r4 == 0) goto L7a
            goto L8f
        L8e:
            r2 = r6
        L8f:
            ir.nasim.features.payment.data.model.BankCreditCard r2 = (ir.nasim.features.payment.data.model.BankCreditCard) r2
            if (r2 == 0) goto La0
            ir.nasim.Vm4 r8 = ir.nasim.AH0.d
            r0.a = r6
            r0.d = r3
            java.lang.Object r8 = r8.a(r2, r0)
            if (r8 != r1) goto La0
            return r1
        La0:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.s(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ir.nasim.AH0.j
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.AH0$j r0 = (ir.nasim.AH0.j) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.AH0$j r0 = new ir.nasim.AH0$j
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3d
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            ir.nasim.AbstractC10685c16.b(r7)
            goto L60
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            java.lang.Object r2 = r0.a
            ir.nasim.AH0 r2 = (ir.nasim.AH0) r2
            ir.nasim.AbstractC10685c16.b(r7)
            goto L55
        L3d:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.do1 r7 = r0.getContext()
            ir.nasim.AH0$k r2 = new ir.nasim.AH0$k
            r2.<init>(r3)
            r0.a = r6
            r0.d = r5
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L54
            return r1
        L54:
            r2 = r6
        L55:
            r0.a = r3
            r0.d = r4
            java.lang.Object r7 = r2.s(r0)
            if (r7 != r1) goto L60
            return r1
        L60:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.t(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(final ir.nasim.features.payment.data.model.BankCreditCard r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.AH0.l
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.AH0$l r0 = (ir.nasim.AH0.l) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.AH0$l r0 = new ir.nasim.AH0$l
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r9)
            goto L66
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.a
            ir.nasim.Vm4 r8 = (ir.nasim.InterfaceC8327Vm4) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L5a
        L3c:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.Vm4 r9 = ir.nasim.AH0.b
            ir.nasim.core.modules.banking.BankingModule r2 = ir.nasim.AH0.f
            ir.nasim.Nv5 r2 = r2.g1(r8)
            ir.nasim.yH0 r5 = new ir.nasim.yH0
            r5.<init>()
            r0.a = r9
            r0.d = r4
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.b(r2, r5, r0)
            if (r8 != r1) goto L57
            return r1
        L57:
            r6 = r9
            r9 = r8
            r8 = r6
        L5a:
            r2 = 0
            r0.a = r2
            r0.d = r3
            java.lang.Object r8 = r8.a(r9, r0)
            if (r8 != r1) goto L66
            return r1
        L66:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AH0.u(ir.nasim.features.payment.data.model.BankCreditCard, ir.nasim.rm1):java.lang.Object");
    }

    public final Object w(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC8327Vm4 interfaceC8327Vm4 = b;
        ArrayList<BankCreditCard> arrayList = new ArrayList(q());
        for (BankCreditCard bankCreditCard : arrayList) {
            if (AbstractC13042fc3.d(bankCreditCard.getId(), str)) {
                bankCreditCard.setEnrolled(true);
            }
        }
        a.x(arrayList);
        Object objA = interfaceC8327Vm4.a(arrayList, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }
}
