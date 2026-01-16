package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Xq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC8861Xq2 {
    private static final int a = AbstractC10110b57.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    /* renamed from: ir.nasim.Xq2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC14603iB2 b;

        /* renamed from: ir.nasim.Xq2$a$a, reason: collision with other inner class name */
        public static final class C0769a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ InterfaceC14603iB2 b;

            /* renamed from: ir.nasim.Xq2$a$a$a, reason: collision with other inner class name */
            public static final class C0770a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0770a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0769a.this.a(null, this);
                }
            }

            public C0769a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = interfaceC4806Gq2;
                this.b = interfaceC14603iB2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.AbstractC8861Xq2.a.C0769a.C0770a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Xq2$a$a$a r0 = (ir.nasim.AbstractC8861Xq2.a.C0769a.C0770a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Xq2$a$a$a r0 = new ir.nasim.Xq2$a$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5d
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L51
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.iB2 r2 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r2.invoke(r7, r0)
                    if (r7 != r1) goto L4e
                    return r1
                L4e:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L51:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5d
                    return r1
                L5d:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8861Xq2.a.C0769a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0769a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xq2$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC14603iB2 b;

        /* renamed from: ir.nasim.Xq2$b$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ InterfaceC14603iB2 b;

            /* renamed from: ir.nasim.Xq2$b$a$a, reason: collision with other inner class name */
            public static final class C0771a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0771a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = interfaceC4806Gq2;
                this.b = interfaceC14603iB2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.AbstractC8861Xq2.b.a.C0771a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Xq2$b$a$a r0 = (ir.nasim.AbstractC8861Xq2.b.a.C0771a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Xq2$b$a$a r0 = new ir.nasim.Xq2$b$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5d
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L51
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.iB2 r2 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r2.invoke(r7, r0)
                    if (r7 != r1) goto L4e
                    return r1
                L4e:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L51:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5d
                    return r1
                L5d:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8861Xq2.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xq2$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new d(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xq2$d */
    static final class d implements InterfaceC4806Gq2 {
        final /* synthetic */ InterfaceC4806Gq2 a;

        /* renamed from: ir.nasim.Xq2$d$a */
        static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.c |= RecyclerView.UNDEFINED_DURATION;
                return d.this.a(null, this);
            }
        }

        d(InterfaceC4806Gq2 interfaceC4806Gq2) {
            this.a = interfaceC4806Gq2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(ir.nasim.InterfaceC4557Fq2 r5, ir.nasim.InterfaceC20295rm1 r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof ir.nasim.AbstractC8861Xq2.d.a
                if (r0 == 0) goto L13
                r0 = r6
                ir.nasim.Xq2$d$a r0 = (ir.nasim.AbstractC8861Xq2.d.a) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.Xq2$d$a r0 = new ir.nasim.Xq2$d$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                ir.nasim.AbstractC10685c16.b(r6)
                goto L3f
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.Gq2 r6 = r4.a
                r0.c = r3
                java.lang.Object r5 = ir.nasim.AbstractC6459Nq2.A(r6, r5, r0)
                if (r5 != r1) goto L3f
                return r1
            L3f:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8861Xq2.d.a(ir.nasim.Fq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Xq2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Object obj2 = this.d;
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                this.c = interfaceC4806Gq2;
                this.b = 1;
                obj = interfaceC14603iB2.invoke(obj2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                AbstractC10685c16.b(obj);
            }
            this.c = null;
            this.b = 2;
            if (interfaceC4806Gq2.a(obj, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.e, interfaceC20295rm1);
            eVar.c = interfaceC4806Gq2;
            eVar.d = obj;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
        return AbstractC6459Nq2.P(new a(interfaceC4557Fq2, interfaceC14603iB2));
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        return AbstractC6459Nq2.Q(new b(interfaceC4557Fq2, interfaceC14603iB2), i);
    }

    public static /* synthetic */ InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, int i, InterfaceC14603iB2 interfaceC14603iB2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = a;
        }
        return AbstractC6459Nq2.N(interfaceC4557Fq2, i, interfaceC14603iB2);
    }

    public static final InterfaceC4557Fq2 d(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return new c(interfaceC4557Fq2);
    }

    public static final InterfaceC4557Fq2 e(InterfaceC4557Fq2 interfaceC4557Fq2, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i).toString());
        }
        if (i == 1) {
            return AbstractC6459Nq2.P(interfaceC4557Fq2);
        }
        return new C22479vJ0(interfaceC4557Fq2, i, null, 0, null, 28, null);
    }

    public static final InterfaceC4557Fq2 f(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
        return AbstractC6459Nq2.s0(interfaceC4557Fq2, new e(interfaceC14603iB2, null));
    }

    public static final InterfaceC4557Fq2 g(Iterable iterable) {
        return new EJ0(iterable, null, 0, null, 14, null);
    }

    public static final InterfaceC4557Fq2 h(InterfaceC4557Fq2... interfaceC4557Fq2Arr) {
        return AbstractC6459Nq2.Y(AbstractC10242bK.O(interfaceC4557Fq2Arr));
    }

    public static final InterfaceC4557Fq2 i(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
        return new C24255yJ0(interfaceC15796kB2, interfaceC4557Fq2, null, 0, null, 28, null);
    }
}
