package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public final class LQ {
    public static final c h = new c(null);
    public static final int i = 8;
    private final AbstractC13778go1 a;
    private final C6287Mz b;
    private final InterfaceC3570Bk5 c;
    private final C17453mz5 d;
    private final C15721k36 e;
    private final C12328eR f;
    private final InterfaceC19483qR g;

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
            Object objG = LQ.this.g(this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = LQ.this.new b(interfaceC20295rm1);
            bVar.d = obj;
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x013f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r16) {
            /*
                Method dump skipped, instructions count: 418
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LQ.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public LQ(AbstractC13778go1 abstractC13778go1, C6287Mz c6287Mz, InterfaceC3570Bk5 interfaceC3570Bk5, C17453mz5 c17453mz5, C15721k36 c15721k36, C12328eR c12328eR, InterfaceC19483qR interfaceC19483qR) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "prefStorage");
        AbstractC13042fc3.i(c17453mz5, "pushModule");
        AbstractC13042fc3.i(c15721k36, "rootBeer");
        AbstractC13042fc3.i(c12328eR, "encryptedSharedPreferences");
        AbstractC13042fc3.i(interfaceC19483qR, "authenticatorLocalDataSource");
        this.a = abstractC13778go1;
        this.b = c6287Mz;
        this.c = interfaceC3570Bk5;
        this.d = c17453mz5;
        this.e = c15721k36;
        this.f = c12328eR;
        this.g = interfaceC19483qR;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.LQ.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.LQ$a r0 = (ir.nasim.LQ.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.LQ$a r0 = new ir.nasim.LQ$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.a
            ir.nasim.LQ$b r2 = new ir.nasim.LQ$b
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LQ.g(ir.nasim.rm1):java.lang.Object");
    }
}
