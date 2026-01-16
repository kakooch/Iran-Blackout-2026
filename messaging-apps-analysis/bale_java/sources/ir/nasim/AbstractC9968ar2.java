package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.ar2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC9968ar2 {

    /* renamed from: ir.nasim.ar2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC11299cm3 b;

        /* renamed from: ir.nasim.ar2$a$a, reason: collision with other inner class name */
        public static final class C0867a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ InterfaceC11299cm3 b;

            /* renamed from: ir.nasim.ar2$a$a$a, reason: collision with other inner class name */
            public static final class C0868a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0868a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0867a.this.a(null, this);
                }
            }

            public C0867a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC11299cm3 interfaceC11299cm3) {
                this.a = interfaceC4806Gq2;
                this.b = interfaceC11299cm3;
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
                    boolean r0 = r6 instanceof ir.nasim.AbstractC9968ar2.a.C0867a.C0868a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.ar2$a$a$a r0 = (ir.nasim.AbstractC9968ar2.a.C0867a.C0868a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.ar2$a$a$a r0 = new ir.nasim.ar2$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.cm3 r2 = r4.b
                    boolean r2 = r2.k(r5)
                    if (r2 == 0) goto L47
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9968ar2.a.C0867a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11299cm3 interfaceC11299cm3) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC11299cm3;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0867a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ar2$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.ar2$b$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.ar2$b$a$a, reason: collision with other inner class name */
            public static final class C0869a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0869a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.AbstractC9968ar2.b.a.C0869a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.ar2$b$a$a r0 = (ir.nasim.AbstractC9968ar2.b.a.C0869a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.ar2$b$a$a r0 = new ir.nasim.ar2$b$a$a
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
                    if (r5 == 0) goto L41
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L41
                    return r1
                L41:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9968ar2.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

    /* renamed from: ir.nasim.ar2$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC14603iB2 b;

        /* renamed from: ir.nasim.ar2$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ InterfaceC14603iB2 b;

            /* renamed from: ir.nasim.ar2$c$a$a, reason: collision with other inner class name */
            public static final class C0870a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object d;
                Object e;

                public C0870a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.AbstractC9968ar2.c.a.C0870a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.ar2$c$a$a r0 = (ir.nasim.AbstractC9968ar2.c.a.C0870a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.ar2$c$a$a r0 = new ir.nasim.ar2$c$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3e
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L6a
                L2c:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L34:
                    java.lang.Object r6 = r0.e
                    ir.nasim.Gq2 r6 = (ir.nasim.InterfaceC4806Gq2) r6
                    java.lang.Object r2 = r0.d
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L5c
                L3e:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.iB2 r2 = r5.b
                    r0.d = r6
                    r0.e = r7
                    r0.b = r4
                    r4 = 6
                    ir.nasim.Y73.c(r4)
                    java.lang.Object r2 = r2.invoke(r6, r0)
                    r4 = 7
                    ir.nasim.Y73.c(r4)
                    if (r2 != r1) goto L5a
                    return r1
                L5a:
                    r2 = r6
                    r6 = r7
                L5c:
                    r7 = 0
                    r0.d = r7
                    r0.e = r7
                    r0.b = r3
                    java.lang.Object r6 = r6.a(r2, r0)
                    if (r6 != r1) goto L6a
                    return r1
                L6a:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9968ar2.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ar2$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ Object a;
        final /* synthetic */ InterfaceC4557Fq2 b;
        final /* synthetic */ InterfaceC15796kB2 c;

        /* renamed from: ir.nasim.ar2$d$a */
        public static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;
            Object e;
            Object f;

            public a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return d.this.b(null, this);
            }
        }

        public d(Object obj, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = obj;
            this.b = interfaceC4557Fq2;
            this.c = interfaceC15796kB2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r7, ir.nasim.InterfaceC20295rm1 r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof ir.nasim.AbstractC9968ar2.d.a
                if (r0 == 0) goto L13
                r0 = r8
                ir.nasim.ar2$d$a r0 = (ir.nasim.AbstractC9968ar2.d.a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.ar2$d$a r0 = new ir.nasim.ar2$d$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L44
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                ir.nasim.AbstractC10685c16.b(r8)
                goto L7b
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f
                ir.nasim.fL5 r7 = (ir.nasim.C12889fL5) r7
                java.lang.Object r2 = r0.e
                ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                java.lang.Object r4 = r0.d
                ir.nasim.ar2$d r4 = (ir.nasim.AbstractC9968ar2.d) r4
                ir.nasim.AbstractC10685c16.b(r8)
                goto L62
            L44:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.fL5 r8 = new ir.nasim.fL5
                r8.<init>()
                java.lang.Object r2 = r6.a
                r8.a = r2
                r0.d = r6
                r0.e = r7
                r0.f = r8
                r0.b = r4
                java.lang.Object r2 = r7.a(r2, r0)
                if (r2 != r1) goto L5f
                return r1
            L5f:
                r4 = r6
                r2 = r7
                r7 = r8
            L62:
                ir.nasim.Fq2 r8 = r4.b
                ir.nasim.ar2$e r5 = new ir.nasim.ar2$e
                ir.nasim.kB2 r4 = r4.c
                r5.<init>(r7, r4, r2)
                r7 = 0
                r0.d = r7
                r0.e = r7
                r0.f = r7
                r0.b = r3
                java.lang.Object r7 = r8.b(r5, r0)
                if (r7 != r1) goto L7b
                return r1
            L7b:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9968ar2.d.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.ar2$e */
    static final class e implements InterfaceC4806Gq2 {
        final /* synthetic */ C12889fL5 a;
        final /* synthetic */ InterfaceC15796kB2 b;
        final /* synthetic */ InterfaceC4806Gq2 c;

        /* renamed from: ir.nasim.ar2$e$a */
        static final class a extends AbstractC22163um1 {
            Object a;
            Object b;
            /* synthetic */ Object c;
            int e;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.c = obj;
                this.e |= RecyclerView.UNDEFINED_DURATION;
                return e.this.a(null, this);
            }
        }

        e(C12889fL5 c12889fL5, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC4806Gq2 interfaceC4806Gq2) {
            this.a = c12889fL5;
            this.b = interfaceC15796kB2;
            this.c = interfaceC4806Gq2;
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
                boolean r0 = r9 instanceof ir.nasim.AbstractC9968ar2.e.a
                if (r0 == 0) goto L13
                r0 = r9
                ir.nasim.ar2$e$a r0 = (ir.nasim.AbstractC9968ar2.e.a) r0
                int r1 = r0.e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.e = r1
                goto L18
            L13:
                ir.nasim.ar2$e$a r0 = new ir.nasim.ar2$e$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.c
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                ir.nasim.AbstractC10685c16.b(r9)
                goto L70
            L2c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L34:
                java.lang.Object r8 = r0.b
                ir.nasim.fL5 r8 = (ir.nasim.C12889fL5) r8
                java.lang.Object r2 = r0.a
                ir.nasim.ar2$e r2 = (ir.nasim.AbstractC9968ar2.e) r2
                ir.nasim.AbstractC10685c16.b(r9)
                goto L5a
            L40:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.fL5 r9 = r7.a
                ir.nasim.kB2 r2 = r7.b
                java.lang.Object r5 = r9.a
                r0.a = r7
                r0.b = r9
                r0.e = r4
                java.lang.Object r8 = r2.q(r5, r8, r0)
                if (r8 != r1) goto L56
                return r1
            L56:
                r2 = r7
                r6 = r9
                r9 = r8
                r8 = r6
            L5a:
                r8.a = r9
                ir.nasim.Gq2 r8 = r2.c
                ir.nasim.fL5 r9 = r2.a
                java.lang.Object r9 = r9.a
                r2 = 0
                r0.a = r2
                r0.b = r2
                r0.e = r3
                java.lang.Object r8 = r8.a(r9, r0)
                if (r8 != r1) goto L70
                return r1
            L70:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9968ar2.e.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.ar2$f */
    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public f(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new g(interfaceC4806Gq2, new C11637dL5()), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ar2$g */
    static final class g implements InterfaceC4806Gq2 {
        final /* synthetic */ InterfaceC4806Gq2 a;
        final /* synthetic */ C11637dL5 b;

        /* renamed from: ir.nasim.ar2$g$a */
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
                return g.this.a(null, this);
            }
        }

        g(InterfaceC4806Gq2 interfaceC4806Gq2, C11637dL5 c11637dL5) {
            this.a = interfaceC4806Gq2;
            this.b = c11637dL5;
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
                boolean r0 = r9 instanceof ir.nasim.AbstractC9968ar2.g.a
                if (r0 == 0) goto L13
                r0 = r9
                ir.nasim.ar2$g$a r0 = (ir.nasim.AbstractC9968ar2.g.a) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.ar2$g$a r0 = new ir.nasim.ar2$g$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                ir.nasim.AbstractC10685c16.b(r9)
                goto L4e
            L29:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L31:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.Gq2 r9 = r7.a
                ir.nasim.i63 r2 = new ir.nasim.i63
                ir.nasim.dL5 r4 = r7.b
                int r5 = r4.a
                int r6 = r5 + 1
                r4.a = r6
                if (r5 < 0) goto L51
                r2.<init>(r5, r8)
                r0.c = r3
                java.lang.Object r8 = r9.a(r2, r0)
                if (r8 != r1) goto L4e
                return r1
            L4e:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            L51:
                java.lang.ArithmeticException r8 = new java.lang.ArithmeticException
                java.lang.String r9 = "Index overflow has happened"
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9968ar2.g.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11299cm3 interfaceC11299cm3) {
        return new a(interfaceC4557Fq2, interfaceC11299cm3);
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return new b(interfaceC4557Fq2);
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
        return new c(interfaceC4557Fq2, interfaceC14603iB2);
    }

    public static final InterfaceC4557Fq2 d(InterfaceC4557Fq2 interfaceC4557Fq2, Object obj, InterfaceC15796kB2 interfaceC15796kB2) {
        return new d(obj, interfaceC4557Fq2, interfaceC15796kB2);
    }

    public static final InterfaceC4557Fq2 e(InterfaceC4557Fq2 interfaceC4557Fq2, Object obj, InterfaceC15796kB2 interfaceC15796kB2) {
        return AbstractC6459Nq2.j0(interfaceC4557Fq2, obj, interfaceC15796kB2);
    }

    public static final InterfaceC4557Fq2 f(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return new f(interfaceC4557Fq2);
    }
}
