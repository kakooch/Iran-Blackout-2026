package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.yJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24255yJ0 extends AbstractC23075wJ0 {
    private final InterfaceC15796kB2 e;

    /* renamed from: ir.nasim.yJ0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4806Gq2 e;

        /* renamed from: ir.nasim.yJ0$a$a, reason: collision with other inner class name */
        static final class C1781a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ InterfaceC20315ro1 b;
            final /* synthetic */ C24255yJ0 c;
            final /* synthetic */ InterfaceC4806Gq2 d;

            /* renamed from: ir.nasim.yJ0$a$a$a, reason: collision with other inner class name */
            static final class C1782a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C24255yJ0 c;
                final /* synthetic */ InterfaceC4806Gq2 d;
                final /* synthetic */ Object e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1782a(C24255yJ0 c24255yJ0, InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c24255yJ0;
                    this.d = interfaceC4806Gq2;
                    this.e = obj;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1782a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC15796kB2 interfaceC15796kB2 = this.c.e;
                        InterfaceC4806Gq2 interfaceC4806Gq2 = this.d;
                        Object obj2 = this.e;
                        this.b = 1;
                        if (interfaceC15796kB2.q(interfaceC4806Gq2, obj2, this) == objE) {
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
                    return ((C1782a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.yJ0$a$a$b */
            static final class b extends AbstractC22163um1 {
                Object a;
                Object b;
                Object c;
                /* synthetic */ Object d;
                int f;

                b(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.d = obj;
                    this.f |= RecyclerView.UNDEFINED_DURATION;
                    return C1781a.this.a(null, this);
                }
            }

            C1781a(C12889fL5 c12889fL5, InterfaceC20315ro1 interfaceC20315ro1, C24255yJ0 c24255yJ0, InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = c12889fL5;
                this.b = interfaceC20315ro1;
                this.c = c24255yJ0;
                this.d = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.C24255yJ0.a.C1781a.b
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.yJ0$a$a$b r0 = (ir.nasim.C24255yJ0.a.C1781a.b) r0
                    int r1 = r0.f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f = r1
                    goto L18
                L13:
                    ir.nasim.yJ0$a$a$b r0 = new ir.nasim.yJ0$a$a$b
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.d
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.f
                    r3 = 1
                    if (r2 == 0) goto L3b
                    if (r2 != r3) goto L33
                    java.lang.Object r8 = r0.c
                    ir.nasim.gj3 r8 = (ir.nasim.InterfaceC13730gj3) r8
                    java.lang.Object r8 = r0.b
                    java.lang.Object r0 = r0.a
                    ir.nasim.yJ0$a$a r0 = (ir.nasim.C24255yJ0.a.C1781a) r0
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L5e
                L33:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L3b:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.fL5 r9 = r7.a
                    java.lang.Object r9 = r9.a
                    ir.nasim.gj3 r9 = (ir.nasim.InterfaceC13730gj3) r9
                    if (r9 == 0) goto L5d
                    kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                    r2.<init>()
                    r9.g(r2)
                    r0.a = r7
                    r0.b = r8
                    r0.c = r9
                    r0.f = r3
                    java.lang.Object r9 = r9.k0(r0)
                    if (r9 != r1) goto L5d
                    return r1
                L5d:
                    r0 = r7
                L5e:
                    ir.nasim.fL5 r9 = r0.a
                    ir.nasim.ro1 r1 = r0.b
                    ir.nasim.xo1 r3 = ir.nasim.EnumC23959xo1.UNDISPATCHED
                    ir.nasim.yJ0$a$a$a r4 = new ir.nasim.yJ0$a$a$a
                    ir.nasim.yJ0 r2 = r0.c
                    ir.nasim.Gq2 r0 = r0.d
                    r5 = 0
                    r4.<init>(r2, r0, r8, r5)
                    r5 = 1
                    r6 = 0
                    r2 = 0
                    ir.nasim.gj3 r8 = ir.nasim.AbstractC9323Zl0.d(r1, r2, r3, r4, r5, r6)
                    r9.a = r8
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24255yJ0.a.C1781a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC4806Gq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C24255yJ0.this.new a(this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                C12889fL5 c12889fL5 = new C12889fL5();
                C24255yJ0 c24255yJ0 = C24255yJ0.this;
                InterfaceC4557Fq2 interfaceC4557Fq2 = c24255yJ0.d;
                C1781a c1781a = new C1781a(c12889fL5, interfaceC20315ro1, c24255yJ0, this.e);
                this.b = 1;
                if (interfaceC4557Fq2.b(c1781a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ C24255yJ0(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, int i2, ED1 ed1) {
        this(interfaceC15796kB2, interfaceC4557Fq2, (i2 & 4) != 0 ? C18712p72.a : interfaceC11938do1, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? EnumC6162Ml0.SUSPEND : enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return new C24255yJ0(this.e, this.d, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC23075wJ0
    protected Object t(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(interfaceC4806Gq2, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public C24255yJ0(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC4557Fq2, interfaceC11938do1, i, enumC6162Ml0);
        this.e = interfaceC15796kB2;
    }
}
