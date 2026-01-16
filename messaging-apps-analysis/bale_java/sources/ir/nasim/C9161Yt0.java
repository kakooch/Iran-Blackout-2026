package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.VS4;

/* renamed from: ir.nasim.Yt0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9161Yt0 {
    private final C5499Jp2 a;
    private final InterfaceC8327Vm4 b;
    private final InterfaceC10040ay6 c;
    private final InterfaceC13730gj3 d;
    private final InterfaceC4557Fq2 e;

    /* renamed from: ir.nasim.Yt0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.Yt0$a$a, reason: collision with other inner class name */
        static final class C0801a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            C0801a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0801a c0801a = new C0801a(interfaceC20295rm1);
                c0801a.c = obj;
                return c0801a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((C14555i63) this.c) != null);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C14555i63 c14555i63, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0801a) create(c14555i63, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Yt0$a$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ C11637dL5 a;
            final /* synthetic */ InterfaceC4806Gq2 b;

            /* renamed from: ir.nasim.Yt0$a$b$a, reason: collision with other inner class name */
            static final class C0802a extends AbstractC22163um1 {
                Object a;
                Object b;
                /* synthetic */ Object c;
                int e;

                C0802a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return b.this.a(null, this);
                }
            }

            b(C11637dL5 c11637dL5, InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = c11637dL5;
                this.b = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.C14555i63 r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C9161Yt0.a.b.C0802a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Yt0$a$b$a r0 = (ir.nasim.C9161Yt0.a.b.C0802a) r0
                    int r1 = r0.e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.e = r1
                    goto L18
                L13:
                    ir.nasim.Yt0$a$b$a r0 = new ir.nasim.Yt0$a$b$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.c
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.e
                    r3 = 1
                    if (r2 == 0) goto L39
                    if (r2 != r3) goto L31
                    java.lang.Object r5 = r0.b
                    ir.nasim.i63 r5 = (ir.nasim.C14555i63) r5
                    java.lang.Object r0 = r0.a
                    ir.nasim.Yt0$a$b r0 = (ir.nasim.C9161Yt0.a.b) r0
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L5d
                L31:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L39:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.AbstractC13042fc3.f(r5)
                    int r6 = r5.c()
                    ir.nasim.dL5 r2 = r4.a
                    int r2 = r2.a
                    if (r6 <= r2) goto L65
                    ir.nasim.Gq2 r6 = r4.b
                    java.lang.Object r2 = r5.d()
                    r0.a = r4
                    r0.b = r5
                    r0.e = r3
                    java.lang.Object r6 = r6.a(r2, r0)
                    if (r6 != r1) goto L5c
                    return r1
                L5c:
                    r0 = r4
                L5d:
                    ir.nasim.dL5 r6 = r0.a
                    int r5 = r5.c()
                    r6.a = r5
                L65:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9161Yt0.a.b.a(ir.nasim.i63, ir.nasim.rm1):java.lang.Object");
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C9161Yt0.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                C11637dL5 c11637dL5 = new C11637dL5();
                c11637dL5.a = RecyclerView.UNDEFINED_DURATION;
                InterfaceC4557Fq2 interfaceC4557Fq2Q0 = AbstractC6459Nq2.q0(C9161Yt0.this.c, new C0801a(null));
                b bVar = new b(c11637dL5, interfaceC4806Gq2);
                this.b = 1;
                if (interfaceC4557Fq2Q0.b(bVar, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Yt0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ C9161Yt0 d;

        /* renamed from: ir.nasim.Yt0$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C9161Yt0 a;

            /* renamed from: ir.nasim.Yt0$b$a$a, reason: collision with other inner class name */
            static final class C0803a extends AbstractC22163um1 {
                Object a;
                Object b;
                /* synthetic */ Object c;
                int e;

                C0803a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C9161Yt0 c9161Yt0) {
                this.a = c9161Yt0;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.C14555i63 r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.C9161Yt0.b.a.C0803a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.Yt0$b$a$a r0 = (ir.nasim.C9161Yt0.b.a.C0803a) r0
                    int r1 = r0.e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.e = r1
                    goto L18
                L13:
                    ir.nasim.Yt0$b$a$a r0 = new ir.nasim.Yt0$b$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.c
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.e
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L6b
                L2c:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L34:
                    java.lang.Object r6 = r0.b
                    ir.nasim.i63 r6 = (ir.nasim.C14555i63) r6
                    java.lang.Object r2 = r0.a
                    ir.nasim.Yt0$b$a r2 = (ir.nasim.C9161Yt0.b.a) r2
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L57
                L40:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Yt0 r7 = r5.a
                    ir.nasim.Vm4 r7 = ir.nasim.C9161Yt0.b(r7)
                    r0.a = r5
                    r0.b = r6
                    r0.e = r4
                    java.lang.Object r7 = r7.a(r6, r0)
                    if (r7 != r1) goto L56
                    return r1
                L56:
                    r2 = r5
                L57:
                    ir.nasim.Yt0 r7 = r2.a
                    ir.nasim.Jp2 r7 = ir.nasim.C9161Yt0.c(r7)
                    r2 = 0
                    r0.a = r2
                    r0.b = r2
                    r0.e = r3
                    java.lang.Object r6 = r7.c(r6, r0)
                    if (r6 != r1) goto L6b
                    return r1
                L6b:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9161Yt0.b.a.a(ir.nasim.i63, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC4557Fq2 interfaceC4557Fq2, C9161Yt0 c9161Yt0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC4557Fq2;
            this.d = c9161Yt0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2T0 = AbstractC6459Nq2.t0(this.c);
                a aVar = new a(this.d);
                this.b = 1;
                if (interfaceC4557Fq2T0.b(aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Yt0$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final void a(Throwable th) {
            C9161Yt0.this.b.c(null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yt0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C9161Yt0.this.new d(interfaceC20295rm1);
            dVar.d = obj;
            return dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r1 = r4.b
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r4.d
                ir.nasim.Gq2 r3 = (ir.nasim.InterfaceC4806Gq2) r3
                ir.nasim.AbstractC10685c16.b(r5)
                goto L56
            L1a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L22:
                java.lang.Object r1 = r4.d
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                ir.nasim.AbstractC10685c16.b(r5)
                goto L43
            L2a:
                ir.nasim.AbstractC10685c16.b(r5)
                java.lang.Object r5 = r4.d
                r1 = r5
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                ir.nasim.Yt0 r5 = ir.nasim.C9161Yt0.this
                ir.nasim.Jp2 r5 = ir.nasim.C9161Yt0.c(r5)
                r4.d = r1
                r4.c = r3
                java.lang.Object r5 = r5.b(r4)
                if (r5 != r0) goto L43
                return r0
            L43:
                java.util.List r5 = (java.util.List) r5
                ir.nasim.Yt0 r3 = ir.nasim.C9161Yt0.this
                ir.nasim.gj3 r3 = ir.nasim.C9161Yt0.a(r3)
                r3.start()
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.Iterator r5 = r5.iterator()
                r3 = r1
                r1 = r5
            L56:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto L6f
                java.lang.Object r5 = r1.next()
                ir.nasim.i63 r5 = (ir.nasim.C14555i63) r5
                r4.d = r3
                r4.b = r1
                r4.c = r2
                java.lang.Object r5 = r3.a(r5, r4)
                if (r5 != r0) goto L56
                return r0
            L6f:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9161Yt0.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C9161Yt0(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "src");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = new C5499Jp2();
        InterfaceC8327Vm4 interfaceC8327Vm4A = AbstractC11420cy6.a(1, Integer.MAX_VALUE, EnumC6162Ml0.SUSPEND);
        this.b = interfaceC8327Vm4A;
        this.c = AbstractC6459Nq2.d0(interfaceC8327Vm4A, new d(null));
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(interfaceC20315ro1, null, EnumC23959xo1.LAZY, new b(interfaceC4557Fq2, this, null), 1, null);
        interfaceC13730gj3D.s(new c());
        this.d = interfaceC13730gj3D;
        this.e = AbstractC6459Nq2.R(new a(null));
    }

    public final void e() {
        InterfaceC13730gj3.a.a(this.d, null, 1, null);
    }

    public final VS4.b f() {
        return this.a.a();
    }

    public final InterfaceC4557Fq2 g() {
        return this.e;
    }
}
