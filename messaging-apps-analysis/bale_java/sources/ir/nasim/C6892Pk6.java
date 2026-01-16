package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Pk6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6892Pk6 extends YT4 {
    private final C25108zk6 b;

    /* renamed from: ir.nasim.Pk6$a */
    static final class a extends AbstractC22163um1 {
        int a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C6892Pk6.this.f(null, this);
        }
    }

    /* renamed from: ir.nasim.Pk6$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C6892Pk6.this.k(0, 0, this);
        }
    }

    public C6892Pk6(C25108zk6 c25108zk6) {
        AbstractC13042fc3.i(c25108zk6, "seenListDataLoader");
        this.b = c25108zk6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(int r5, int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C6892Pk6.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Pk6$b r0 = (ir.nasim.C6892Pk6.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Pk6$b r0 = new ir.nasim.Pk6$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.zk6 r7 = r4.b
            r0.c = r3
            java.lang.Object r7 = r7.f(r5, r6, r0)
            if (r7 != r1) goto L3f
            return r1
        L3f:
            ir.nasim.XV4 r7 = (ir.nasim.XV4) r7
            java.lang.Object r5 = r7.e()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.List r5 = ir.nasim.ZW0.j0(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6892Pk6.k(int, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C6892Pk6.a
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Pk6$a r0 = (ir.nasim.C6892Pk6.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Pk6$a r0 = new ir.nasim.Pk6$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r7 = r0.a
            ir.nasim.AbstractC10685c16.b(r8)     // Catch: java.io.IOException -> L2b
            goto L58
        L2b:
            r7 = move-exception
            goto L77
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r8)
            java.lang.Object r8 = r7.a()     // Catch: java.io.IOException -> L2b
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.io.IOException -> L2b
            if (r8 == 0) goto L45
            int r8 = r8.intValue()     // Catch: java.io.IOException -> L2b
            goto L46
        L45:
            r8 = r3
        L46:
            int r7 = r7.b()     // Catch: java.io.IOException -> L2b
            r0.a = r8     // Catch: java.io.IOException -> L2b
            r0.d = r3     // Catch: java.io.IOException -> L2b
            java.lang.Object r7 = r6.k(r8, r7, r0)     // Catch: java.io.IOException -> L2b
            if (r7 != r1) goto L55
            return r1
        L55:
            r5 = r8
            r8 = r7
            r7 = r5
        L58:
            java.util.List r8 = (java.util.List) r8     // Catch: java.io.IOException -> L2b
            ir.nasim.YT4$b$c r0 = new ir.nasim.YT4$b$c     // Catch: java.io.IOException -> L2b
            r1 = 0
            if (r7 != r3) goto L61
            r2 = r1
            goto L67
        L61:
            int r2 = r7 + (-1)
            java.lang.Integer r2 = ir.nasim.AbstractC6392Nk0.d(r2)     // Catch: java.io.IOException -> L2b
        L67:
            boolean r4 = r8.isEmpty()     // Catch: java.io.IOException -> L2b
            if (r4 == 0) goto L6e
            goto L73
        L6e:
            int r7 = r7 + r3
            java.lang.Integer r1 = ir.nasim.AbstractC6392Nk0.d(r7)     // Catch: java.io.IOException -> L2b
        L73:
            r0.<init>(r8, r2, r1)     // Catch: java.io.IOException -> L2b
            goto L7c
        L77:
            ir.nasim.YT4$b$a r0 = new ir.nasim.YT4$b$a
            r0.<init>(r7)
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6892Pk6.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }
}
