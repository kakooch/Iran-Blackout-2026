package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.yD6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24207yD6 {
    public static final b b = new b(null);
    private final c a;

    /* renamed from: ir.nasim.yD6$a */
    private static final class a extends CancellationException {
        private final C24207yD6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C24207yD6 c24207yD6) {
            super("Cancelled isolated runner");
            AbstractC13042fc3.i(c24207yD6, "runner");
            this.a = c24207yD6;
        }

        public final C24207yD6 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.yD6$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yD6$c */
    private static final class c {
        private final C24207yD6 a;
        private final boolean b;
        private final InterfaceC19699qn4 c;
        private InterfaceC13730gj3 d;
        private int e;

        /* renamed from: ir.nasim.yD6$c$a */
        static final class a extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            /* synthetic */ Object d;
            int f;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.d = obj;
                this.f |= RecyclerView.UNDEFINED_DURATION;
                return c.this.a(null, this);
            }
        }

        /* renamed from: ir.nasim.yD6$c$b */
        static final class b extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            int d;
            /* synthetic */ Object e;
            int g;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.e = obj;
                this.g |= RecyclerView.UNDEFINED_DURATION;
                return c.this.b(0, null, this);
            }
        }

        public c(C24207yD6 c24207yD6, boolean z) {
            AbstractC13042fc3.i(c24207yD6, "singleRunner");
            this.a = c24207yD6;
            this.b = z;
            this.c = AbstractC20899sn4.b(false, 1, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object a(ir.nasim.InterfaceC13730gj3 r6, ir.nasim.InterfaceC20295rm1 r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof ir.nasim.C24207yD6.c.a
                if (r0 == 0) goto L13
                r0 = r7
                ir.nasim.yD6$c$a r0 = (ir.nasim.C24207yD6.c.a) r0
                int r1 = r0.f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f = r1
                goto L18
            L13:
                ir.nasim.yD6$c$a r0 = new ir.nasim.yD6$c$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.d
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.f
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L40
                if (r2 != r3) goto L38
                java.lang.Object r6 = r0.c
                ir.nasim.qn4 r6 = (ir.nasim.InterfaceC19699qn4) r6
                java.lang.Object r1 = r0.b
                ir.nasim.gj3 r1 = (ir.nasim.InterfaceC13730gj3) r1
                java.lang.Object r0 = r0.a
                ir.nasim.yD6$c r0 = (ir.nasim.C24207yD6.c) r0
                ir.nasim.AbstractC10685c16.b(r7)
                r7 = r6
                r6 = r1
                goto L55
            L38:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L40:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.qn4 r7 = r5.c
                r0.a = r5
                r0.b = r6
                r0.c = r7
                r0.f = r3
                java.lang.Object r0 = r7.a(r4, r0)
                if (r0 != r1) goto L54
                return r1
            L54:
                r0 = r5
            L55:
                ir.nasim.gj3 r1 = r0.d     // Catch: java.lang.Throwable -> L5c
                if (r6 != r1) goto L5e
                r0.d = r4     // Catch: java.lang.Throwable -> L5c
                goto L5e
            L5c:
                r6 = move-exception
                goto L66
            L5e:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L5c
                r7.e(r4)
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            L66:
                r7.e(r4)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24207yD6.c.a(ir.nasim.gj3, ir.nasim.rm1):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r11v0, types: [ir.nasim.gj3, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v1, types: [ir.nasim.qn4] */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v4, types: [ir.nasim.qn4] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object b(int r10, ir.nasim.InterfaceC13730gj3 r11, ir.nasim.InterfaceC20295rm1 r12) {
            /*
                r9 = this;
                boolean r0 = r12 instanceof ir.nasim.C24207yD6.c.b
                if (r0 == 0) goto L13
                r0 = r12
                ir.nasim.yD6$c$b r0 = (ir.nasim.C24207yD6.c.b) r0
                int r1 = r0.g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.g = r1
                goto L18
            L13:
                ir.nasim.yD6$c$b r0 = new ir.nasim.yD6$c$b
                r0.<init>(r12)
            L18:
                java.lang.Object r12 = r0.e
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.g
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L59
                if (r2 == r4) goto L47
                if (r2 != r3) goto L3f
                int r10 = r0.d
                java.lang.Object r11 = r0.c
                ir.nasim.qn4 r11 = (ir.nasim.InterfaceC19699qn4) r11
                java.lang.Object r1 = r0.b
                ir.nasim.gj3 r1 = (ir.nasim.InterfaceC13730gj3) r1
                java.lang.Object r0 = r0.a
                ir.nasim.yD6$c r0 = (ir.nasim.C24207yD6.c) r0
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.lang.Throwable -> L3c
                goto Laa
            L3c:
                r10 = move-exception
                goto Lb8
            L3f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L47:
                int r10 = r0.d
                java.lang.Object r11 = r0.c
                ir.nasim.qn4 r11 = (ir.nasim.InterfaceC19699qn4) r11
                java.lang.Object r2 = r0.b
                ir.nasim.gj3 r2 = (ir.nasim.InterfaceC13730gj3) r2
                java.lang.Object r6 = r0.a
                ir.nasim.yD6$c r6 = (ir.nasim.C24207yD6.c) r6
                ir.nasim.AbstractC10685c16.b(r12)
                goto L72
            L59:
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.qn4 r12 = r9.c
                r0.a = r9
                r0.b = r11
                r0.c = r12
                r0.d = r10
                r0.g = r4
                java.lang.Object r2 = r12.a(r5, r0)
                if (r2 != r1) goto L6f
                return r1
            L6f:
                r6 = r9
                r2 = r11
                r11 = r12
            L72:
                ir.nasim.gj3 r12 = r6.d     // Catch: java.lang.Throwable -> L3c
                if (r12 == 0) goto L89
                boolean r7 = r12.b()     // Catch: java.lang.Throwable -> L3c
                if (r7 == 0) goto L89
                int r7 = r6.e     // Catch: java.lang.Throwable -> L3c
                if (r7 < r10) goto L89
                if (r7 != r10) goto L87
                boolean r7 = r6.b     // Catch: java.lang.Throwable -> L3c
                if (r7 == 0) goto L87
                goto L89
            L87:
                r4 = 0
                goto Lb0
            L89:
                if (r12 == 0) goto L95
                ir.nasim.yD6$a r7 = new ir.nasim.yD6$a     // Catch: java.lang.Throwable -> L3c
                ir.nasim.yD6 r8 = r6.a     // Catch: java.lang.Throwable -> L3c
                r7.<init>(r8)     // Catch: java.lang.Throwable -> L3c
                r12.g(r7)     // Catch: java.lang.Throwable -> L3c
            L95:
                if (r12 == 0) goto Lac
                r0.a = r6     // Catch: java.lang.Throwable -> L3c
                r0.b = r2     // Catch: java.lang.Throwable -> L3c
                r0.c = r11     // Catch: java.lang.Throwable -> L3c
                r0.d = r10     // Catch: java.lang.Throwable -> L3c
                r0.g = r3     // Catch: java.lang.Throwable -> L3c
                java.lang.Object r12 = r12.k0(r0)     // Catch: java.lang.Throwable -> L3c
                if (r12 != r1) goto La8
                return r1
            La8:
                r1 = r2
                r0 = r6
            Laa:
                r6 = r0
                r2 = r1
            Lac:
                r6.d = r2     // Catch: java.lang.Throwable -> L3c
                r6.e = r10     // Catch: java.lang.Throwable -> L3c
            Lb0:
                java.lang.Boolean r10 = ir.nasim.AbstractC6392Nk0.a(r4)     // Catch: java.lang.Throwable -> L3c
                r11.e(r5)
                return r10
            Lb8:
                r11.e(r5)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24207yD6.c.b(int, ir.nasim.gj3, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.yD6$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C24207yD6.this.b(0, null, this);
        }
    }

    /* renamed from: ir.nasim.yD6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
            this.f = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = C24207yD6.this.new e(this.e, this.f, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[RETURN] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [ir.nasim.gj3] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v9, types: [ir.nasim.gj3] */
        /* JADX WARN: Type inference failed for: r3v2, types: [ir.nasim.yD6$c] */
        /* JADX WARN: Type inference failed for: r9v15, types: [ir.nasim.yD6$c] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.b
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L3c
                if (r1 == r5) goto L34
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L25
                if (r1 == r2) goto L1c
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1c:
                java.lang.Object r0 = r8.c
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                ir.nasim.AbstractC10685c16.b(r9)
                goto La0
            L25:
                ir.nasim.AbstractC10685c16.b(r9)
                goto La1
            L2a:
                java.lang.Object r1 = r8.c
                ir.nasim.gj3 r1 = (ir.nasim.InterfaceC13730gj3) r1
                ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L32
                goto L7c
            L32:
                r9 = move-exception
                goto L8e
            L34:
                java.lang.Object r1 = r8.c
                ir.nasim.gj3 r1 = (ir.nasim.InterfaceC13730gj3) r1
                ir.nasim.AbstractC10685c16.b(r9)
                goto L67
            L3c:
                ir.nasim.AbstractC10685c16.b(r9)
                java.lang.Object r9 = r8.c
                ir.nasim.ro1 r9 = (ir.nasim.InterfaceC20315ro1) r9
                ir.nasim.do1 r9 = r9.getCoroutineContext()
                ir.nasim.gj3$b r1 = ir.nasim.InterfaceC13730gj3.n0
                ir.nasim.do1$b r9 = r9.a(r1)
                if (r9 == 0) goto La4
                ir.nasim.gj3 r9 = (ir.nasim.InterfaceC13730gj3) r9
                ir.nasim.yD6 r1 = ir.nasim.C24207yD6.this
                ir.nasim.yD6$c r1 = ir.nasim.C24207yD6.a(r1)
                int r6 = r8.e
                r8.c = r9
                r8.b = r5
                java.lang.Object r1 = r1.b(r6, r9, r8)
                if (r1 != r0) goto L64
                return r0
            L64:
                r7 = r1
                r1 = r9
                r9 = r7
            L67:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto La1
                ir.nasim.UA2 r9 = r8.f     // Catch: java.lang.Throwable -> L32
                r8.c = r1     // Catch: java.lang.Throwable -> L32
                r8.b = r4     // Catch: java.lang.Throwable -> L32
                java.lang.Object r9 = r9.invoke(r8)     // Catch: java.lang.Throwable -> L32
                if (r9 != r0) goto L7c
                return r0
            L7c:
                ir.nasim.yD6 r9 = ir.nasim.C24207yD6.this
                ir.nasim.yD6$c r9 = ir.nasim.C24207yD6.a(r9)
                r2 = 0
                r8.c = r2
                r8.b = r3
                java.lang.Object r9 = r9.a(r1, r8)
                if (r9 != r0) goto La1
                return r0
            L8e:
                ir.nasim.yD6 r3 = ir.nasim.C24207yD6.this
                ir.nasim.yD6$c r3 = ir.nasim.C24207yD6.a(r3)
                r8.c = r9
                r8.b = r2
                java.lang.Object r1 = r3.a(r1, r8)
                if (r1 != r0) goto L9f
                return r0
            L9f:
                r0 = r9
            La0:
                throw r0
            La1:
                ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                return r9
            La4:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "Internal error. coroutineScope should've created a job."
                java.lang.String r0 = r0.toString()
                r9.<init>(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24207yD6.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24207yD6(boolean z) {
        this.a = new c(this, z);
    }

    public static /* synthetic */ Object c(C24207yD6 c24207yD6, int i, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return c24207yD6.b(i, ua2, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(int r5, ir.nasim.UA2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C24207yD6.d
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.yD6$d r0 = (ir.nasim.C24207yD6.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.yD6$d r0 = new ir.nasim.yD6$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.a
            ir.nasim.yD6 r5 = (ir.nasim.C24207yD6) r5
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: ir.nasim.C24207yD6.a -> L2d
            goto L53
        L2d:
            r6 = move-exception
            goto L4d
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.yD6$e r7 = new ir.nasim.yD6$e     // Catch: ir.nasim.C24207yD6.a -> L4b
            r2 = 0
            r7.<init>(r5, r6, r2)     // Catch: ir.nasim.C24207yD6.a -> L4b
            r0.a = r4     // Catch: ir.nasim.C24207yD6.a -> L4b
            r0.d = r3     // Catch: ir.nasim.C24207yD6.a -> L4b
            java.lang.Object r5 = ir.nasim.AbstractC20906so1.e(r7, r0)     // Catch: ir.nasim.C24207yD6.a -> L4b
            if (r5 != r1) goto L53
            return r1
        L4b:
            r6 = move-exception
            r5 = r4
        L4d:
            ir.nasim.yD6 r7 = r6.a()
            if (r7 != r5) goto L56
        L53:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        L56:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24207yD6.b(int, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    public /* synthetic */ C24207yD6(boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z);
    }
}
