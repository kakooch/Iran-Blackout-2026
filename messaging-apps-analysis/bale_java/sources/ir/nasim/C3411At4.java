package ir.nasim;

import ir.nasim.InterfaceC12464ef4;

/* renamed from: ir.nasim.At4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3411At4 {
    private final OK a;
    private final C11057cf4 b;
    private final C9847af4 c;
    private final AbstractC13778go1 d;
    private final AbstractC13778go1 e;
    private final InterfaceC20315ro1 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC10258bL6 h;
    private C13100ff4 i;

    /* renamed from: ir.nasim.At4$a */
    static final class a extends AbstractC19859r37 implements UA2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C3411At4.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5H = C3411At4.this.a.h();
                AbstractC13042fc3.h(c6517Nv5H, "getAllValues(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5H, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            return C9475a16.a(objD);
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C3411At4(OK ok, C11057cf4 c11057cf4, C9847af4 c9847af4, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(ok, "oldDownloadedEngine");
        AbstractC13042fc3.i(c11057cf4, "migrationDownloadRepository");
        AbstractC13042fc3.i(c9847af4, "migrationChecker");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "defaultDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        this.a = ok;
        this.b = c11057cf4;
        this.c = c9847af4;
        this.d = abstractC13778go1;
        this.e = abstractC13778go12;
        this.f = interfaceC20315ro1;
        EnumC13691gf4 enumC13691gf4 = (C8386Vt0.a.S3() && c9847af4.b()) ? EnumC13691gf4.c : EnumC13691gf4.a;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(enumC13691gf4);
        this.g = interfaceC9336Zm4A;
        this.h = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(C3411At4 c3411At4, Throwable th) {
        AbstractC13042fc3.i(c3411At4, "this$0");
        c3411At4.i = null;
        return C19938rB7.a;
    }

    private final void h() {
        C13100ff4 c13100ff4 = new C13100ff4(this.g, new a(null), this.b, this.c, this.d, this.e, this.f, false, 128, null);
        c13100ff4.f();
        this.i = c13100ff4;
    }

    public final void c(C10405bZ1 c10405bZ1) {
        AbstractC13042fc3.i(c10405bZ1, "item");
        C13100ff4 c13100ff4 = this.i;
        if (c13100ff4 != null) {
            c13100ff4.d(new InterfaceC12464ef4.b(c10405bZ1));
        }
    }

    public final void d(long j) {
        C13100ff4 c13100ff4 = this.i;
        if (c13100ff4 != null) {
            c13100ff4.d(new InterfaceC12464ef4.c(j));
        }
    }

    public final InterfaceC24823zG1 e() {
        if (this.c.b() || !C8386Vt0.a.S3()) {
            return AbstractC23485x01.b(Boolean.FALSE);
        }
        h();
        InterfaceC22299v01 interfaceC22299v01C = AbstractC23485x01.c(null, 1, null);
        interfaceC22299v01C.s(new UA2() { // from class: ir.nasim.zt4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3411At4.f(this.a, (Throwable) obj);
            }
        });
        C13100ff4 c13100ff4 = this.i;
        if (c13100ff4 != null) {
            c13100ff4.d(new InterfaceC12464ef4.d(interfaceC22299v01C));
        }
        return interfaceC22299v01C;
    }

    public final InterfaceC10258bL6 g() {
        return this.h;
    }
}
