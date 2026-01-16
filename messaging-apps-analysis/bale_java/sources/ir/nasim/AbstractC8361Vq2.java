package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Vq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC8361Vq2 {

    /* renamed from: ir.nasim.Vq2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC15796kB2 b;

        /* renamed from: ir.nasim.Vq2$a$a, reason: collision with other inner class name */
        public static final class C0719a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;
            Object e;

            public C0719a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return a.this.b(null, this);
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC15796kB2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r6, ir.nasim.InterfaceC20295rm1 r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof ir.nasim.AbstractC8361Vq2.a.C0719a
                if (r0 == 0) goto L13
                r0 = r7
                ir.nasim.Vq2$a$a r0 = (ir.nasim.AbstractC8361Vq2.a.C0719a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.Vq2$a$a r0 = new ir.nasim.Vq2$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                ir.nasim.AbstractC10685c16.b(r7)
                goto L6f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.e
                ir.nasim.Gq2 r6 = (ir.nasim.InterfaceC4806Gq2) r6
                java.lang.Object r2 = r0.d
                ir.nasim.Vq2$a r2 = (ir.nasim.AbstractC8361Vq2.a) r2
                ir.nasim.AbstractC10685c16.b(r7)
                goto L53
            L40:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Fq2 r7 = r5.a
                r0.d = r5
                r0.e = r6
                r0.b = r4
                java.lang.Object r7 = ir.nasim.AbstractC6459Nq2.i(r7, r6, r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                r2 = r5
            L53:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L6f
                ir.nasim.kB2 r2 = r2.b
                r4 = 0
                r0.d = r4
                r0.e = r4
                r0.b = r3
                r3 = 6
                ir.nasim.Y73.c(r3)
                java.lang.Object r6 = r2.q(r6, r7, r0)
                r7 = 7
                ir.nasim.Y73.c(r7)
                if (r6 != r1) goto L6f
                return r1
            L6f:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8361Vq2.a.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Vq2$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC6459Nq2.i(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Vq2$c */
    static final class c implements InterfaceC4806Gq2 {
        final /* synthetic */ InterfaceC4806Gq2 a;
        final /* synthetic */ C12889fL5 b;

        /* renamed from: ir.nasim.Vq2$c$a */
        static final class a extends AbstractC22163um1 {
            Object a;
            /* synthetic */ Object b;
            int d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= RecyclerView.UNDEFINED_DURATION;
                return c.this.a(null, this);
            }
        }

        c(InterfaceC4806Gq2 interfaceC4806Gq2, C12889fL5 c12889fL5) {
            this.a = interfaceC4806Gq2;
            this.b = c12889fL5;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof ir.nasim.AbstractC8361Vq2.c.a
                if (r0 == 0) goto L13
                r0 = r6
                ir.nasim.Vq2$c$a r0 = (ir.nasim.AbstractC8361Vq2.c.a) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.d = r1
                goto L18
            L13:
                ir.nasim.Vq2$c$a r0 = new ir.nasim.Vq2$c$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.b
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.d
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.a
                ir.nasim.Vq2$c r5 = (ir.nasim.AbstractC8361Vq2.c) r5
                ir.nasim.AbstractC10685c16.b(r6)     // Catch: java.lang.Throwable -> L2d
                goto L47
            L2d:
                r6 = move-exception
                goto L4c
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L37:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.Gq2 r6 = r4.a     // Catch: java.lang.Throwable -> L4a
                r0.a = r4     // Catch: java.lang.Throwable -> L4a
                r0.d = r3     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = r6.a(r5, r0)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r1) goto L47
                return r1
            L47:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            L4a:
                r6 = move-exception
                r5 = r4
            L4c:
                ir.nasim.fL5 r5 = r5.b
                r5.a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8361Vq2.c.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Vq2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(true);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(th, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vq2$e */
    static final class e extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ InterfaceC14603iB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
            this.e = j;
            this.f = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            return n((InterfaceC4806Gq2) obj, (Throwable) obj2, ((Number) obj3).longValue(), (InterfaceC20295rm1) obj4);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Throwable th = (Throwable) this.c;
                if (this.d < this.e) {
                    InterfaceC14603iB2 interfaceC14603iB2 = this.f;
                    this.b = 1;
                    obj = interfaceC14603iB2.invoke(th, this);
                    if (obj == objE) {
                        return objE;
                    }
                }
                return AbstractC6392Nk0.a(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            boolean z = ((Boolean) obj).booleanValue();
            return AbstractC6392Nk0.a(z);
        }

        public final Object n(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.e, this.f, interfaceC20295rm1);
            eVar.c = th;
            eVar.d = j;
            return eVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vq2$f */
    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC16978mB2 b;

        /* renamed from: ir.nasim.Vq2$f$a */
        public static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;
            Object e;
            Object f;
            long g;
            int h;

            public a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return f.this.b(null, this);
            }
        }

        public f(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC16978mB2 interfaceC16978mB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC16978mB2;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x006e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:30:0x00a6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:27:0x009a). Please report as a decompilation issue!!! */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r12, ir.nasim.InterfaceC20295rm1 r13) throws java.lang.Throwable {
            /*
                r11 = this;
                boolean r0 = r13 instanceof ir.nasim.AbstractC8361Vq2.f.a
                if (r0 == 0) goto L13
                r0 = r13
                ir.nasim.Vq2$f$a r0 = (ir.nasim.AbstractC8361Vq2.f.a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.Vq2$f$a r0 = new ir.nasim.Vq2$f$a
                r0.<init>(r13)
            L18:
                java.lang.Object r13 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L52
                if (r2 == r4) goto L42
                if (r2 != r3) goto L3a
                long r5 = r0.g
                java.lang.Object r12 = r0.f
                java.lang.Throwable r12 = (java.lang.Throwable) r12
                java.lang.Object r2 = r0.e
                ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                java.lang.Object r7 = r0.d
                ir.nasim.Vq2$f r7 = (ir.nasim.AbstractC8361Vq2.f) r7
                ir.nasim.AbstractC10685c16.b(r13)
                goto L9a
            L3a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L42:
                int r12 = r0.h
                long r5 = r0.g
                java.lang.Object r2 = r0.e
                ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                java.lang.Object r7 = r0.d
                ir.nasim.Vq2$f r7 = (ir.nasim.AbstractC8361Vq2.f) r7
                ir.nasim.AbstractC10685c16.b(r13)
                goto L74
            L52:
                ir.nasim.AbstractC10685c16.b(r13)
                r5 = 0
                r13 = r11
            L58:
                ir.nasim.Fq2 r2 = r13.a
                r0.d = r13
                r0.e = r12
                r7 = 0
                r0.f = r7
                r0.g = r5
                r7 = 0
                r0.h = r7
                r0.b = r4
                java.lang.Object r2 = ir.nasim.AbstractC6459Nq2.i(r2, r12, r0)
                if (r2 != r1) goto L6f
                return r1
            L6f:
                r10 = r2
                r2 = r12
                r12 = r7
                r7 = r13
                r13 = r10
            L74:
                java.lang.Throwable r13 = (java.lang.Throwable) r13
                if (r13 == 0) goto La6
                ir.nasim.mB2 r12 = r7.b
                java.lang.Long r8 = ir.nasim.AbstractC6392Nk0.e(r5)
                r0.d = r7
                r0.e = r2
                r0.f = r13
                r0.g = r5
                r0.b = r3
                r9 = 6
                ir.nasim.Y73.c(r9)
                java.lang.Object r12 = r12.e(r2, r13, r8, r0)
                r8 = 7
                ir.nasim.Y73.c(r8)
                if (r12 != r1) goto L97
                return r1
            L97:
                r10 = r13
                r13 = r12
                r12 = r10
            L9a:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto La8
                r12 = 1
                long r5 = r5 + r12
                r12 = r4
            La6:
                r13 = r7
                goto La9
            La8:
                throw r12
            La9:
                if (r12 != 0) goto Lae
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                return r12
            Lae:
                r12 = r2
                goto L58
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8361Vq2.f.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
        return new a(interfaceC4557Fq2, interfaceC15796kB2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.InterfaceC4557Fq2 r4, ir.nasim.InterfaceC4806Gq2 r5, ir.nasim.InterfaceC20295rm1 r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof ir.nasim.AbstractC8361Vq2.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Vq2$b r0 = (ir.nasim.AbstractC8361Vq2.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Vq2$b r0 = new ir.nasim.Vq2$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.a
            ir.nasim.fL5 r4 = (ir.nasim.C12889fL5) r4
            ir.nasim.AbstractC10685c16.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.fL5 r6 = new ir.nasim.fL5
            r6.<init>()
            ir.nasim.Vq2$c r2 = new ir.nasim.Vq2$c     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.a = r6     // Catch: java.lang.Throwable -> L51
            r0.c = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.b(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            java.lang.Object r4 = r4.a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            ir.nasim.do1 r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            ir.nasim.AbstractC16041kc2.a(r4, r5)
            throw r4
        L72:
            ir.nasim.AbstractC16041kc2.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8361Vq2.b(ir.nasim.Fq2, ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
    }

    private static final boolean c(Throwable th, InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 == null || !interfaceC13730gj3.isCancelled()) {
            return false;
        }
        return d(th, interfaceC13730gj3.q());
    }

    private static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && AbstractC13042fc3.d(th2, th);
    }

    public static final InterfaceC4557Fq2 e(InterfaceC4557Fq2 interfaceC4557Fq2, long j, InterfaceC14603iB2 interfaceC14603iB2) {
        if (j > 0) {
            return AbstractC6459Nq2.i0(interfaceC4557Fq2, new e(j, interfaceC14603iB2, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j).toString());
    }

    public static /* synthetic */ InterfaceC4557Fq2 f(InterfaceC4557Fq2 interfaceC4557Fq2, long j, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            interfaceC14603iB2 = new d(null);
        }
        return AbstractC6459Nq2.g0(interfaceC4557Fq2, j, interfaceC14603iB2);
    }

    public static final InterfaceC4557Fq2 g(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC16978mB2 interfaceC16978mB2) {
        return new f(interfaceC4557Fq2, interfaceC16978mB2);
    }
}
