package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Wq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC8595Wq2 {

    /* renamed from: ir.nasim.Wq2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ int b;

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, int i) {
            this.a = interfaceC4557Fq2;
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new b(new C11637dL5(), this.b, interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wq2$b */
    static final class b implements InterfaceC4806Gq2 {
        final /* synthetic */ C11637dL5 a;
        final /* synthetic */ int b;
        final /* synthetic */ InterfaceC4806Gq2 c;

        /* renamed from: ir.nasim.Wq2$b$a */
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
                return b.this.a(null, this);
            }
        }

        b(C11637dL5 c11637dL5, int i, InterfaceC4806Gq2 interfaceC4806Gq2) {
            this.a = c11637dL5;
            this.b = i;
            this.c = interfaceC4806Gq2;
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
                boolean r0 = r7 instanceof ir.nasim.AbstractC8595Wq2.b.a
                if (r0 == 0) goto L13
                r0 = r7
                ir.nasim.Wq2$b$a r0 = (ir.nasim.AbstractC8595Wq2.b.a) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.Wq2$b$a r0 = new ir.nasim.Wq2$b$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                ir.nasim.AbstractC10685c16.b(r7)
                goto L47
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.dL5 r7 = r5.a
                int r2 = r7.a
                int r4 = r5.b
                if (r2 < r4) goto L4a
                ir.nasim.Gq2 r7 = r5.c
                r0.c = r3
                java.lang.Object r6 = r7.a(r6, r0)
                if (r6 != r1) goto L47
                return r1
            L47:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            L4a:
                int r2 = r2 + r3
                r7.a = r2
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8595Wq2.b.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Wq2$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC14603iB2 b;

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new d(new C9663aL5(), interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wq2$d */
    static final class d implements InterfaceC4806Gq2 {
        final /* synthetic */ C9663aL5 a;
        final /* synthetic */ InterfaceC4806Gq2 b;
        final /* synthetic */ InterfaceC14603iB2 c;

        /* renamed from: ir.nasim.Wq2$d$a */
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
                return d.this.a(null, this);
            }
        }

        d(C9663aL5 c9663aL5, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = c9663aL5;
            this.b = interfaceC4806Gq2;
            this.c = interfaceC14603iB2;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof ir.nasim.AbstractC8595Wq2.d.a
                if (r0 == 0) goto L13
                r0 = r8
                ir.nasim.Wq2$d$a r0 = (ir.nasim.AbstractC8595Wq2.d.a) r0
                int r1 = r0.e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.e = r1
                goto L18
            L13:
                ir.nasim.Wq2$d$a r0 = new ir.nasim.Wq2$d$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.c
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                ir.nasim.AbstractC10685c16.b(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.b
                java.lang.Object r2 = r0.a
                ir.nasim.Wq2$d r2 = (ir.nasim.AbstractC8595Wq2.d) r2
                ir.nasim.AbstractC10685c16.b(r8)
                goto L6c
            L41:
                ir.nasim.AbstractC10685c16.b(r8)
                goto L59
            L45:
                ir.nasim.AbstractC10685c16.b(r8)
                ir.nasim.aL5 r8 = r6.a
                boolean r8 = r8.a
                if (r8 == 0) goto L5c
                ir.nasim.Gq2 r8 = r6.b
                r0.e = r5
                java.lang.Object r7 = r8.a(r7, r0)
                if (r7 != r1) goto L59
                return r1
            L59:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            L5c:
                ir.nasim.iB2 r8 = r6.c
                r0.a = r6
                r0.b = r7
                r0.e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                return r1
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                ir.nasim.aL5 r8 = r2.a
                r8.a = r5
                ir.nasim.Gq2 r8 = r2.b
                r2 = 0
                r0.a = r2
                r0.b = r2
                r0.e = r3
                java.lang.Object r7 = r8.a(r7, r0)
                if (r7 != r1) goto L88
                return r1
            L88:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            L8b:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8595Wq2.d.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Wq2$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC14603iB2 b;

        /* renamed from: ir.nasim.Wq2$e$a */
        public static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;

            public a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return e.this.b(null, this);
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC14603iB2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r6, ir.nasim.InterfaceC20295rm1 r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof ir.nasim.AbstractC8595Wq2.e.a
                if (r0 == 0) goto L13
                r0 = r7
                ir.nasim.Wq2$e$a r0 = (ir.nasim.AbstractC8595Wq2.e.a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.Wq2$e$a r0 = new ir.nasim.Wq2$e$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r6 = r0.d
                ir.nasim.Wq2$f r6 = (ir.nasim.AbstractC8595Wq2.f) r6
                ir.nasim.AbstractC10685c16.b(r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
                goto L53
            L2d:
                r7 = move-exception
                goto L50
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.Fq2 r7 = r5.a
                ir.nasim.Wq2$f r2 = new ir.nasim.Wq2$f
                ir.nasim.iB2 r4 = r5.b
                r2.<init>(r4, r6)
                r0.d = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4e
                r0.b = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4e
                java.lang.Object r6 = r7.b(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L4e
                if (r6 != r1) goto L53
                return r1
            L4e:
                r7 = move-exception
                r6 = r2
            L50:
                ir.nasim.AbstractC5742Kq2.a(r7, r6)
            L53:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8595Wq2.e.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Wq2$f */
    public static final class f implements InterfaceC4806Gq2 {
        final /* synthetic */ InterfaceC14603iB2 a;
        final /* synthetic */ InterfaceC4806Gq2 b;

        /* renamed from: ir.nasim.Wq2$f$a */
        public static final class a extends AbstractC22163um1 {
            Object a;
            /* synthetic */ Object b;
            int c;
            Object e;

            public a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.c |= RecyclerView.UNDEFINED_DURATION;
                return f.this.a(null, this);
            }
        }

        public f(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC4806Gq2 interfaceC4806Gq2) {
            this.a = interfaceC14603iB2;
            this.b = interfaceC4806Gq2;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4806Gq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof ir.nasim.AbstractC8595Wq2.f.a
                if (r0 == 0) goto L13
                r0 = r9
                ir.nasim.Wq2$f$a r0 = (ir.nasim.AbstractC8595Wq2.f.a) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.Wq2$f$a r0 = new ir.nasim.Wq2$f$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.b
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r8 = r0.a
                ir.nasim.Wq2$f r8 = (ir.nasim.AbstractC8595Wq2.f) r8
                ir.nasim.AbstractC10685c16.b(r9)
                goto L7c
            L30:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L38:
                java.lang.Object r8 = r0.e
                java.lang.Object r2 = r0.a
                ir.nasim.Wq2$f r2 = (ir.nasim.AbstractC8595Wq2.f) r2
                ir.nasim.AbstractC10685c16.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L63
            L46:
                ir.nasim.AbstractC10685c16.b(r9)
                ir.nasim.iB2 r9 = r7.a
                r0.a = r7
                r0.e = r8
                r0.c = r4
                r2 = 6
                ir.nasim.Y73.c(r2)
                java.lang.Object r9 = r9.invoke(r8, r0)
                r2 = 7
                ir.nasim.Y73.c(r2)
                if (r9 != r1) goto L60
                return r1
            L60:
                r2 = r9
                r9 = r8
                r8 = r7
            L63:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L7b
                ir.nasim.Gq2 r2 = r8.b
                r0.a = r8
                r5 = 0
                r0.e = r5
                r0.c = r3
                java.lang.Object r9 = r2.a(r9, r0)
                if (r9 != r1) goto L7c
                return r1
            L7b:
                r4 = 0
            L7c:
                if (r4 == 0) goto L81
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            L81:
                kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8595Wq2.f.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, int i) {
        if (i >= 0) {
            return new a(interfaceC4557Fq2, i);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i).toString());
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
        return new c(interfaceC4557Fq2, interfaceC14603iB2);
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
        return new e(interfaceC4557Fq2, interfaceC14603iB2);
    }
}
