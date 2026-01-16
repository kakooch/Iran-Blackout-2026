package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class FD7 {
    private final InterfaceC20315ro1 a;
    private final InterfaceC8327Vm4 b;
    private final InterfaceC10040ay6 c;

    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC11299cm3[] b;

        /* renamed from: ir.nasim.FD7$a$a, reason: collision with other inner class name */
        public static final class C0358a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ InterfaceC11299cm3[] b;

            /* renamed from: ir.nasim.FD7$a$a$a, reason: collision with other inner class name */
            public static final class C0359a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0359a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0358a.this.a(null, this);
                }
            }

            public C0358a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC11299cm3[] interfaceC11299cm3Arr) {
                this.a = interfaceC4806Gq2;
                this.b = interfaceC11299cm3Arr;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.FD7.a.C0358a.C0359a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.FD7$a$a$a r0 = (ir.nasim.FD7.a.C0358a.C0359a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.FD7$a$a$a r0 = new ir.nasim.FD7$a$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L52
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    r2 = r6
                    ir.nasim.sC7 r2 = (ir.nasim.AbstractC20556sC7) r2
                    ir.nasim.cm3[] r4 = r5.b
                    java.lang.Class r2 = r2.getClass()
                    ir.nasim.cm3 r2 = ir.nasim.AbstractC10882cM5.b(r2)
                    boolean r2 = ir.nasim.XJ.U(r4, r2)
                    if (r2 == 0) goto L52
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L52
                    return r1
                L52:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FD7.a.C0358a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11299cm3[] interfaceC11299cm3Arr) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC11299cm3Arr;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0358a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.FD7$b$a$a, reason: collision with other inner class name */
            public static final class C0360a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0360a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.FD7.b.a.C0360a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.FD7$b$a$a r0 = (ir.nasim.FD7.b.a.C0360a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.FD7$b$a$a r0 = new ir.nasim.FD7$b$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L41
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.sC7 r5 = (ir.nasim.AbstractC20556sC7) r5
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L41
                    return r1
                L41:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.FD7.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC20556sC7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = abstractC20556sC7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return FD7.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = FD7.this.b;
                AbstractC20556sC7 abstractC20556sC7 = this.d;
                this.b = 1;
                if (interfaceC8327Vm4.a(abstractC20556sC7, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public FD7(InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "externalScope");
        this.a = interfaceC20315ro1;
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, 0, null, 7, null);
        this.b = interfaceC8327Vm4B;
        this.c = AbstractC6459Nq2.b(interfaceC8327Vm4B);
    }

    public final InterfaceC4557Fq2 b(InterfaceC11299cm3... interfaceC11299cm3Arr) {
        AbstractC13042fc3.i(interfaceC11299cm3Arr, "kClasses");
        return new b(new a(this.c, interfaceC11299cm3Arr));
    }

    public final InterfaceC10040ay6 c() {
        return this.c;
    }

    public final void d(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        AbstractC10533bm0.d(this.a, null, null, new c(abstractC20556sC7, null), 3, null);
    }
}
