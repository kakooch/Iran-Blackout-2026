package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.vJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22479vJ0 extends AbstractC20003rJ0 {
    private final InterfaceC4557Fq2 d;
    private final int e;

    /* renamed from: ir.nasim.vJ0$a */
    static final class a implements InterfaceC4806Gq2 {
        final /* synthetic */ InterfaceC13730gj3 a;
        final /* synthetic */ InterfaceC13783go6 b;
        final /* synthetic */ InterfaceC16204ks5 c;
        final /* synthetic */ C7640So6 d;

        /* renamed from: ir.nasim.vJ0$a$a, reason: collision with other inner class name */
        static final class C1662a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ C7640So6 d;
            final /* synthetic */ InterfaceC13783go6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1662a(InterfaceC4557Fq2 interfaceC4557Fq2, C7640So6 c7640So6, InterfaceC13783go6 interfaceC13783go6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = c7640So6;
                this.e = interfaceC13783go6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1662a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                try {
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                        C7640So6 c7640So6 = this.d;
                        this.b = 1;
                        if (interfaceC4557Fq2.b(c7640So6, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    this.e.release();
                    return C19938rB7.a;
                } catch (Throwable th) {
                    this.e.release();
                    throw th;
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1662a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.vJ0$a$b */
        static final class b extends AbstractC22163um1 {
            Object a;
            Object b;
            /* synthetic */ Object c;
            int e;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.c = obj;
                this.e |= RecyclerView.UNDEFINED_DURATION;
                return a.this.a(null, this);
            }
        }

        a(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC13783go6 interfaceC13783go6, InterfaceC16204ks5 interfaceC16204ks5, C7640So6 c7640So6) {
            this.a = interfaceC13730gj3;
            this.b = interfaceC13783go6;
            this.c = interfaceC16204ks5;
            this.d = c7640So6;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(ir.nasim.InterfaceC4557Fq2 r8, ir.nasim.InterfaceC20295rm1 r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof ir.nasim.C22479vJ0.a.b
                if (r0 == 0) goto L13
                r0 = r9
                ir.nasim.vJ0$a$b r0 = (ir.nasim.C22479vJ0.a.b) r0
                int r1 = r0.e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.e = r1
                goto L18
            L13:
                ir.nasim.vJ0$a$b r0 = new ir.nasim.vJ0$a$b
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.c
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.e
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r8 = r0.b
                ir.nasim.Fq2 r8 = (ir.nasim.InterfaceC4557Fq2) r8
                java.lang.Object r0 = r0.a
                ir.nasim.vJ0$a r0 = (ir.nasim.C22479vJ0.a) r0
                ir.nasim.AbstractC10685c16.b(r9)
                goto L53
            L31:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L39:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.gj3 r9 = r7.a
                if (r9 == 0) goto L43
                ir.nasim.AbstractC19067pj3.o(r9)
            L43:
                ir.nasim.go6 r9 = r7.b
                r0.a = r7
                r0.b = r8
                r0.e = r3
                java.lang.Object r9 = r9.b(r0)
                if (r9 != r1) goto L52
                return r1
            L52:
                r0 = r7
            L53:
                ir.nasim.ks5 r1 = r0.c
                ir.nasim.vJ0$a$a r4 = new ir.nasim.vJ0$a$a
                ir.nasim.So6 r9 = r0.d
                ir.nasim.go6 r0 = r0.b
                r2 = 0
                r4.<init>(r8, r9, r0, r2)
                r5 = 3
                r6 = 0
                r3 = 0
                ir.nasim.AbstractC9323Zl0.d(r1, r2, r3, r4, r5, r6)
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22479vJ0.a.a(ir.nasim.Fq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    public /* synthetic */ C22479vJ0(InterfaceC4557Fq2 interfaceC4557Fq2, int i, InterfaceC11938do1 interfaceC11938do1, int i2, EnumC6162Ml0 enumC6162Ml0, int i3, ED1 ed1) {
        this(interfaceC4557Fq2, i, (i3 & 4) != 0 ? C18712p72.a : interfaceC11938do1, (i3 & 8) != 0 ? -2 : i2, (i3 & 16) != 0 ? EnumC6162Ml0.SUSPEND : enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected String h() {
        return "concurrency=" + this.e;
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected Object j(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.d.b(new a((InterfaceC13730gj3) interfaceC20295rm1.getContext().a(InterfaceC13730gj3.n0), AbstractC14984io6.b(this.e, 0, 2, null), interfaceC16204ks5, new C7640So6(interfaceC16204ks5)), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return new C22479vJ0(this.d, this.e, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    public VI5 p(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC13822gs5.d(interfaceC20315ro1, this.a, this.b, n());
    }

    public C22479vJ0(InterfaceC4557Fq2 interfaceC4557Fq2, int i, InterfaceC11938do1 interfaceC11938do1, int i2, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC11938do1, i2, enumC6162Ml0);
        this.d = interfaceC4557Fq2;
        this.e = i;
    }
}
