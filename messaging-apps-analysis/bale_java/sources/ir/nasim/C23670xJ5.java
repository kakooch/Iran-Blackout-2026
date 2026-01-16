package ir.nasim;

/* renamed from: ir.nasim.xJ5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23670xJ5 implements InterfaceC23080wJ5 {
    private final C6287Mz a;
    private final AbstractC13778go1 b;
    private final InterfaceC11621dJ7 c;
    private final C18246oK7 d;
    private final InterfaceC8327Vm4 e;

    /* renamed from: ir.nasim.xJ5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ C23670xJ5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11458d25 c11458d25, int i, int i2, C23670xJ5 c23670xJ5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c11458d25;
            this.f = i;
            this.g = i2;
            this.h = c23670xJ5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00f6 A[LOOP:1: B:28:0x00f0->B:30:0x00f6, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0118 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 348
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23670xJ5.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C23670xJ5(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, InterfaceC11621dJ7 interfaceC11621dJ7, C18246oK7 c18246oK7) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(c18246oK7, "mapper");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
        this.c = interfaceC11621dJ7;
        this.d = c18246oK7;
        this.e = AbstractC11420cy6.b(1, 0, EnumC6162Ml0.DROP_OLDEST, 2, null);
    }

    @Override // ir.nasim.InterfaceC23080wJ5
    public Object a(C11458d25 c11458d25, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new a(c11458d25, i, i2, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC23080wJ5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC8327Vm4 b() {
        return this.e;
    }
}
