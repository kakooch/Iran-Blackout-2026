package ir.nasim;

/* loaded from: classes5.dex */
public final class KF3 {
    private final int a;
    private final InterfaceC11621dJ7 b;
    private final AbstractC13778go1 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KF3.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
                java.lang.Object r6 = r6.l()
                goto L5b
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L20:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
                java.lang.Object r6 = r6.l()
                goto L42
            L2a:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.KF3 r6 = ir.nasim.KF3.this
                ir.nasim.dJ7 r6 = ir.nasim.KF3.b(r6)
                ir.nasim.KF3 r1 = ir.nasim.KF3.this
                int r1 = ir.nasim.KF3.a(r1)
                r5.b = r3
                java.lang.Object r6 = r6.o(r1, r5)
                if (r6 != r0) goto L42
                return r0
            L42:
                ir.nasim.C9475a16.g(r6)
                ir.nasim.KF3 r6 = ir.nasim.KF3.this
                ir.nasim.dJ7 r6 = ir.nasim.KF3.b(r6)
                ir.nasim.KF3 r1 = ir.nasim.KF3.this
                int r1 = ir.nasim.KF3.a(r1)
                long r3 = (long) r1
                r5.b = r2
                java.lang.Object r6 = r6.i(r3, r5)
                if (r6 != r0) goto L5b
                return r0
            L5b:
                boolean r0 = ir.nasim.C9475a16.g(r6)
                if (r0 == 0) goto L62
                r6 = 0
            L62:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KF3.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public KF3(int i, InterfaceC11621dJ7 interfaceC11621dJ7, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = i;
        this.b = interfaceC11621dJ7;
        this.c = abstractC13778go1;
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new a(null), interfaceC20295rm1);
    }
}
