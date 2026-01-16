package ir.nasim;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC13730gj3;

/* loaded from: classes6.dex */
public final class AY1 {
    private final MX1 a;
    private final FY1 b;
    private final IY1 c;
    private final InterfaceC20315ro1 d;
    private final AbstractC13778go1 e;
    private final UA2 f;
    private InterfaceC13730gj3 g;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.AY1$a$a, reason: collision with other inner class name */
        static final class C0265a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ AY1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0265a(AY1 ay1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = ay1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0265a c0265a = new C0265a(this.d, interfaceC20295rm1);
                c0265a.c = obj;
                return c0265a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.f.invoke((SY1) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0265a) create(sy1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* synthetic */ class b extends EB2 implements InterfaceC14603iB2 {
            b(Object obj) {
                super(2, obj, AbstractC13042fc3.a.class, "suspendConversion0", "invokeSuspend$suspendConversion0(Lkotlin/jvm/functions/Function1;Lir/nasim/file/download/model/DownloadState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Object invoke(SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
                return a.y((UA2) this.receiver, sy1, interfaceC20295rm1);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object y(UA2 ua2, SY1 sy1, InterfaceC20295rm1 interfaceC20295rm1) {
            ua2.invoke(sy1);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AY1.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2a
                if (r1 == r5) goto L26
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                goto L21
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1d:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L88
            L21:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L9e
            L26:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L54
            L2a:
                ir.nasim.AbstractC10685c16.b(r7)
                ir.nasim.AY1 r7 = ir.nasim.AY1.this
                ir.nasim.MX1 r7 = ir.nasim.AY1.c(r7)
                boolean r1 = r7 instanceof ir.nasim.MX1.a
                if (r1 == 0) goto L67
                ir.nasim.AY1 r7 = ir.nasim.AY1.this
                ir.nasim.IY1 r7 = ir.nasim.AY1.b(r7)
                ir.nasim.AY1 r1 = ir.nasim.AY1.this
                ir.nasim.MX1 r1 = ir.nasim.AY1.c(r1)
                ir.nasim.MX1$a r1 = (ir.nasim.MX1.a) r1
                ir.nasim.AY1 r2 = ir.nasim.AY1.this
                ir.nasim.FY1 r2 = ir.nasim.AY1.a(r2)
                r6.b = r5
                java.lang.Object r7 = r7.e(r1, r2, r6)
                if (r7 != r0) goto L54
                return r0
            L54:
                ir.nasim.Fq2 r7 = (ir.nasim.InterfaceC4557Fq2) r7
                ir.nasim.AY1$a$a r1 = new ir.nasim.AY1$a$a
                ir.nasim.AY1 r2 = ir.nasim.AY1.this
                r3 = 0
                r1.<init>(r2, r3)
                r6.b = r4
                java.lang.Object r7 = ir.nasim.AbstractC6459Nq2.l(r7, r1, r6)
                if (r7 != r0) goto L9e
                return r0
            L67:
                boolean r7 = r7 instanceof ir.nasim.MX1.b
                if (r7 == 0) goto La1
                ir.nasim.AY1 r7 = ir.nasim.AY1.this
                ir.nasim.IY1 r7 = ir.nasim.AY1.b(r7)
                ir.nasim.AY1 r1 = ir.nasim.AY1.this
                ir.nasim.MX1 r1 = ir.nasim.AY1.c(r1)
                ir.nasim.MX1$b r1 = (ir.nasim.MX1.b) r1
                ir.nasim.AY1 r4 = ir.nasim.AY1.this
                ir.nasim.FY1 r4 = ir.nasim.AY1.a(r4)
                r6.b = r3
                java.lang.Object r7 = r7.d(r1, r4, r6)
                if (r7 != r0) goto L88
                return r0
            L88:
                ir.nasim.Fq2 r7 = (ir.nasim.InterfaceC4557Fq2) r7
                ir.nasim.AY1$a$b r1 = new ir.nasim.AY1$a$b
                ir.nasim.AY1 r3 = ir.nasim.AY1.this
                ir.nasim.UA2 r3 = ir.nasim.AY1.d(r3)
                r1.<init>(r3)
                r6.b = r2
                java.lang.Object r7 = ir.nasim.AbstractC6459Nq2.l(r7, r1, r6)
                if (r7 != r0) goto L9e
                return r0
            L9e:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            La1:
                kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
                r7.<init>()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AY1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public AY1(MX1 mx1, FY1 fy1, IY1 iy1, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, UA2 ua2) {
        AbstractC13042fc3.i(mx1, "input");
        AbstractC13042fc3.i(fy1, "downloadPolicy");
        AbstractC13042fc3.i(iy1, "downloadRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(ua2, "notifier");
        this.a = mx1;
        this.b = fy1;
        this.c = iy1;
        this.d = interfaceC20315ro1;
        this.e = abstractC13778go1;
        this.f = ua2;
    }

    public final void e() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.g;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.g = null;
    }

    public final void f() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.g;
        if (interfaceC13730gj3 == null || !interfaceC13730gj3.b()) {
            this.g = AbstractC10533bm0.d(this.d, this.e, null, new a(null), 2, null);
        }
    }
}
