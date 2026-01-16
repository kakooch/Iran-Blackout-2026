package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C17448mz0;
import java.util.List;

/* renamed from: ir.nasim.tw0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21671tw0 {
    public static final b f = new b(null);
    public static final int g = 8;
    private final InterfaceC20315ro1 a;
    private final C20394rw0 b;
    private final InterfaceC13266fw0 c;
    private final A08 d;
    private final C22875vy0 e;

    /* renamed from: ir.nasim.tw0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.tw0$a$a, reason: collision with other inner class name */
        static final class C1614a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            C1614a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                XV4 xv4 = (XV4) this.c;
                return AbstractC4616Fw7.a(xv4.f(), (C17448mz0.a) this.d);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(XV4 xv4, C17448mz0.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                C1614a c1614a = new C1614a(interfaceC20295rm1);
                c1614a.c = xv4;
                c1614a.d = aVar;
                return c1614a.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.tw0$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C21671tw0 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C21671tw0 c21671tw0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c21671tw0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19406qI3.a("CallLogRepository", "a new call detected", new Object[0]);
                    C21671tw0 c21671tw0 = this.c;
                    this.b = 1;
                    if (c21671tw0.i(this) == objE) {
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
            public final Object invoke(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(xv4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.tw0$a$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.tw0$a$c$a, reason: collision with other inner class name */
            public static final class C1615a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.tw0$a$c$a$a, reason: collision with other inner class name */
                public static final class C1616a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1616a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1615a.this.a(null, this);
                    }
                }

                public C1615a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
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
                        boolean r0 = r8 instanceof ir.nasim.C21671tw0.a.c.C1615a.C1616a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.tw0$a$c$a$a r0 = (ir.nasim.C21671tw0.a.c.C1615a.C1616a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.tw0$a$c$a$a r0 = new ir.nasim.tw0$a$c$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        r2 = r7
                        ir.nasim.XV4 r2 = (ir.nasim.XV4) r2
                        java.lang.Object r4 = r2.e()
                        ir.nasim.mz0$a r5 = ir.nasim.C17448mz0.a.o
                        if (r4 == r5) goto L50
                        java.lang.Object r2 = r2.f()
                        if (r2 != r5) goto L50
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L50
                        return r1
                    L50:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21671tw0.a.c.C1615a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1615a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.tw0$a$d */
        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.tw0$a$d$a, reason: collision with other inner class name */
            public static final class C1617a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.tw0$a$d$a$a, reason: collision with other inner class name */
                public static final class C1618a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1618a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1617a.this.a(null, this);
                    }
                }

                public C1617a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                        boolean r0 = r6 instanceof ir.nasim.C21671tw0.a.d.C1617a.C1618a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.tw0$a$d$a$a r0 = (ir.nasim.C21671tw0.a.d.C1617a.C1618a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.tw0$a$d$a$a r0 = new ir.nasim.tw0$a$d$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                        ir.nasim.mz0$a r5 = r5.e()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21671tw0.a.d.C1617a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1617a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21671tw0.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = new d(C18039nz0.a.d());
                C17448mz0.a aVar = C17448mz0.a.o;
                c cVar = new c(AbstractC6459Nq2.l0(dVar, AbstractC4616Fw7.a(aVar, aVar), new C1614a(null)));
                b bVar = new b(C21671tw0.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(cVar, bVar, this) == objE) {
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

    /* renamed from: ir.nasim.tw0$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tw0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ List f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = list;
            this.g = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21671tw0.this.new c(this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.d
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L31
                if (r1 == r5) goto L2d
                if (r1 == r4) goto L28
                if (r1 == r3) goto L28
                if (r1 != r2) goto L20
                java.lang.Object r1 = r7.c
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r3 = r7.b
                ir.nasim.tw0 r3 = (ir.nasim.C21671tw0) r3
                ir.nasim.AbstractC10685c16.b(r8)
                goto L7f
            L20:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L28:
                ir.nasim.AbstractC10685c16.b(r8)
                goto La0
            L2d:
                ir.nasim.AbstractC10685c16.b(r8)
                goto L47
            L31:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.tw0 r8 = ir.nasim.C21671tw0.this
                ir.nasim.A08 r8 = ir.nasim.C21671tw0.d(r8)
                java.util.List r1 = r7.f
                boolean r6 = r7.g
                r7.d = r5
                java.lang.Object r8 = r8.I(r1, r6, r7)
                if (r8 != r0) goto L47
                return r0
            L47:
                boolean r8 = r7.g
                if (r8 == 0) goto L73
                java.util.List r8 = r7.f
                boolean r8 = r8.isEmpty()
                if (r8 == 0) goto L62
                ir.nasim.tw0 r8 = ir.nasim.C21671tw0.this
                ir.nasim.fw0 r8 = ir.nasim.C21671tw0.c(r8)
                r7.d = r4
                java.lang.Object r8 = r8.a(r7)
                if (r8 != r0) goto La0
                return r0
            L62:
                ir.nasim.tw0 r8 = ir.nasim.C21671tw0.this
                ir.nasim.fw0 r8 = ir.nasim.C21671tw0.c(r8)
                java.util.List r1 = r7.f
                r7.d = r3
                java.lang.Object r8 = r8.g(r1, r7)
                if (r8 != r0) goto La0
                return r0
            L73:
                java.util.List r8 = r7.f
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                ir.nasim.tw0 r1 = ir.nasim.C21671tw0.this
                java.util.Iterator r8 = r8.iterator()
                r3 = r1
                r1 = r8
            L7f:
                boolean r8 = r1.hasNext()
                if (r8 == 0) goto La0
                java.lang.Object r8 = r1.next()
                java.lang.Number r8 = (java.lang.Number) r8
                long r4 = r8.longValue()
                ir.nasim.fw0 r8 = ir.nasim.C21671tw0.c(r3)
                r7.b = r3
                r7.c = r1
                r7.d = r2
                java.lang.Object r8 = r8.d(r4, r7)
                if (r8 != r0) goto L7f
                return r0
            La0:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21671tw0.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tw0$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C21671tw0 b;

        /* renamed from: ir.nasim.tw0$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C21671tw0 b;

            /* renamed from: ir.nasim.tw0$d$a$a, reason: collision with other inner class name */
            public static final class C1619a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1619a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C21671tw0 c21671tw0) {
                this.a = interfaceC4806Gq2;
                this.b = c21671tw0;
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
                    boolean r0 = r8 instanceof ir.nasim.C21671tw0.d.a.C1619a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.tw0$d$a$a r0 = (ir.nasim.C21671tw0.d.a.C1619a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tw0$d$a$a r0 = new ir.nasim.tw0$d$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L56
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.NT4 r7 = (ir.nasim.NT4) r7
                    ir.nasim.tw0$e r2 = new ir.nasim.tw0$e
                    r4 = 0
                    r2.<init>(r4)
                    ir.nasim.NT4 r7 = ir.nasim.TT4.g(r7, r2)
                    ir.nasim.tw0$f r2 = new ir.nasim.tw0$f
                    ir.nasim.tw0 r5 = r6.b
                    r2.<init>(r4)
                    ir.nasim.NT4 r7 = ir.nasim.TT4.a(r7, r2)
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r7, r0)
                    if (r7 != r1) goto L56
                    return r1
                L56:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21671tw0.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2, C21671tw0 c21671tw0) {
            this.a = interfaceC4557Fq2;
            this.b = c21671tw0;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tw0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC17421mw0.d((C15057iw0) this.c);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C15057iw0 c15057iw0, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(c15057iw0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tw0$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C21671tw0.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(C21671tw0.this.e((C12630ew0) this.c));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C12630ew0 c12630ew0, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(c12630ew0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tw0$g */
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
            return C21671tw0.this.i(this);
        }
    }

    public C21671tw0(InterfaceC20315ro1 interfaceC20315ro1, C20394rw0 c20394rw0, InterfaceC13266fw0 interfaceC13266fw0, A08 a08, C22875vy0 c22875vy0) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(c20394rw0, "callLogRemoteMediator");
        AbstractC13042fc3.i(interfaceC13266fw0, "callLogDao");
        AbstractC13042fc3.i(a08, "voiceCallModule");
        AbstractC13042fc3.i(c22875vy0, "callRemoteDataSource");
        this.a = interfaceC20315ro1;
        this.b = c20394rw0;
        this.c = interfaceC13266fw0;
        this.d = a08;
        this.e = c22875vy0;
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(C12630ew0 c12630ew0) {
        return (c12630ew0.f() == EnumC17523n65.a && c12630ew0.a() == EnumC10879cM2.a && c12630ew0.d().b() == EnumC4280El4.a) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT4 h(C21671tw0 c21671tw0) {
        AbstractC13042fc3.i(c21671tw0, "this$0");
        return c21671tw0.c.f();
    }

    public final InterfaceC13730gj3 f(List list, boolean z) {
        AbstractC13042fc3.i(list, "callIds");
        return AbstractC10533bm0.d(this.a, null, null, new c(list, z, null), 3, null);
    }

    public final InterfaceC4557Fq2 g() {
        return new d(new C12960fT4(new MT4(10, 30, false, 30, 0, 0, 48, null), null, this.b, new SA2() { // from class: ir.nasim.sw0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21671tw0.h(this.a);
            }
        }, 2, null).a(), this);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof ir.nasim.C21671tw0.g
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.tw0$g r0 = (ir.nasim.C21671tw0.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.tw0$g r0 = new ir.nasim.tw0$g
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 0
            java.lang.String r4 = "CallLogRepository"
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L52
            if (r2 == r8) goto L4a
            if (r2 == r6) goto L3c
            if (r2 != r5) goto L34
            ir.nasim.AbstractC10685c16.b(r11)
            goto La5
        L34:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3c:
            java.lang.Object r2 = r0.a
            ir.nasim.tw0 r2 = (ir.nasim.C21671tw0) r2
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r11 = r11.l()
            goto L7c
        L4a:
            java.lang.Object r2 = r0.a
            ir.nasim.tw0 r2 = (ir.nasim.C21671tw0) r2
            ir.nasim.AbstractC10685c16.b(r11)
            goto L6a
        L52:
            ir.nasim.AbstractC10685c16.b(r11)
            java.lang.String r11 = "start update call log"
            java.lang.Object[] r2 = new java.lang.Object[r3]
            ir.nasim.C19406qI3.a(r4, r11, r2)
            ir.nasim.A08 r11 = r10.d
            r0.a = r10
            r0.d = r8
            java.lang.Object r11 = r11.J(r8, r0)
            if (r11 != r1) goto L69
            return r1
        L69:
            r2 = r10
        L6a:
            java.lang.String r9 = "getCallLogsPage(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r9)
            ir.nasim.Nv5 r11 = (ir.nasim.C6517Nv5) r11
            r0.a = r2
            r0.d = r6
            java.lang.Object r11 = ir.nasim.AbstractC6756Ov5.d(r11, r7, r0, r8, r7)
            if (r11 != r1) goto L7c
            return r1
        L7c:
            boolean r6 = ir.nasim.C9475a16.j(r11)
            if (r6 == 0) goto La5
            java.lang.String r6 = "get update call log successfully"
            java.lang.Object[] r3 = new java.lang.Object[r3]
            ir.nasim.C19406qI3.a(r4, r6, r3)
            boolean r3 = ir.nasim.C9475a16.g(r11)
            if (r3 == 0) goto L90
            r11 = r7
        L90:
            ai.bale.proto.MeetOuterClass$ResponseGetCallLogs r11 = (ai.bale.proto.MeetOuterClass$ResponseGetCallLogs) r11
            if (r11 == 0) goto La5
            ir.nasim.fw0 r2 = r2.c
            java.util.List r11 = ir.nasim.AbstractC15648jw0.d(r11)
            r0.a = r7
            r0.d = r5
            java.lang.Object r11 = r2.b(r11, r0)
            if (r11 != r1) goto La5
            return r1
        La5:
            ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21671tw0.i(ir.nasim.rm1):java.lang.Object");
    }
}
