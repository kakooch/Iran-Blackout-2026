package ir.nasim;

import ir.nasim.VI5;

/* renamed from: ir.nasim.oo1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC18524oo1 {
    private final String a;
    private final InterfaceC17639nJ0 b;
    private final InterfaceC20315ro1 c;

    /* renamed from: ir.nasim.oo1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC18524oo1.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC17639nJ0 interfaceC17639nJ0 = AbstractC18524oo1.this.b;
                Object obj2 = this.d;
                this.b = 1;
                if (interfaceC17639nJ0.o(obj2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.oo1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC18524oo1.this.new b(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006c A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:7:0x001d, B:21:0x0050, B:25:0x0064, B:27:0x006c, B:28:0x0070, B:36:0x00a2, B:32:0x0084, B:34:0x0088, B:35:0x00a1, B:16:0x003b, B:20:0x004c), top: B:43:0x0009, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:7:0x001d, B:21:0x0050, B:25:0x0064, B:27:0x006c, B:28:0x0070, B:36:0x00a2, B:32:0x0084, B:34:0x0088, B:35:0x00a1, B:16:0x003b, B:20:0x004c), top: B:43:0x0009, inners: #2 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007e -> B:31:0x0081). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0088 -> B:31:0x0081). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.f
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L41
                if (r1 == r3) goto L2e
                if (r1 != r2) goto L26
                java.lang.Object r1 = r11.e
                java.lang.Object r5 = r11.d
                ir.nasim.CJ0 r5 = (ir.nasim.CJ0) r5
                java.lang.Object r6 = r11.c
                ir.nasim.VI5 r6 = (ir.nasim.VI5) r6
                java.lang.Object r7 = r11.b
                ir.nasim.oo1 r7 = (ir.nasim.AbstractC18524oo1) r7
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
                goto L81
            L21:
                r12 = move-exception
                goto Laa
            L24:
                r12 = move-exception
                goto L84
            L26:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L2e:
                java.lang.Object r1 = r11.d
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r5 = r11.c
                r6 = r5
                ir.nasim.VI5 r6 = (ir.nasim.VI5) r6
                java.lang.Object r5 = r11.b
                ir.nasim.oo1 r5 = (ir.nasim.AbstractC18524oo1) r5
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.lang.Throwable -> L21
                r7 = r5
            L3f:
                r5 = r1
                goto L64
            L41:
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.oo1 r12 = ir.nasim.AbstractC18524oo1.this
                ir.nasim.nJ0 r6 = ir.nasim.AbstractC18524oo1.a(r12)
                ir.nasim.oo1 r12 = ir.nasim.AbstractC18524oo1.this
                ir.nasim.CJ0 r1 = r6.iterator()     // Catch: java.lang.Throwable -> L21
            L50:
                r11.b = r12     // Catch: java.lang.Throwable -> L21
                r11.c = r6     // Catch: java.lang.Throwable -> L21
                r11.d = r1     // Catch: java.lang.Throwable -> L21
                r11.e = r4     // Catch: java.lang.Throwable -> L21
                r11.f = r3     // Catch: java.lang.Throwable -> L21
                java.lang.Object r5 = r1.a(r11)     // Catch: java.lang.Throwable -> L21
                if (r5 != r0) goto L61
                return r0
            L61:
                r7 = r12
                r12 = r5
                goto L3f
            L64:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L21
                boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L21
                if (r12 == 0) goto La2
                java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L21
                r11.b = r7     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
                r11.c = r6     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
                r11.d = r5     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
                r11.e = r1     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
                r11.f = r2     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
                java.lang.Object r12 = r7.c(r1, r11)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
                if (r12 != r0) goto L81
                return r0
            L81:
                r1 = r5
                r12 = r7
                goto L50
            L84:
                boolean r8 = r12 instanceof java.util.concurrent.CancellationException     // Catch: java.lang.Throwable -> L21
                if (r8 != 0) goto La1
                java.lang.String r8 = ir.nasim.AbstractC18524oo1.b(r7)     // Catch: java.lang.Throwable -> L21
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21
                r9.<init>()     // Catch: java.lang.Throwable -> L21
                java.lang.String r10 = "Unhandled exception in message processing loop for msg: "
                r9.append(r10)     // Catch: java.lang.Throwable -> L21
                r9.append(r1)     // Catch: java.lang.Throwable -> L21
                java.lang.String r1 = r9.toString()     // Catch: java.lang.Throwable -> L21
                ir.nasim.C19406qI3.c(r8, r1, r12)     // Catch: java.lang.Throwable -> L21
                goto L81
            La1:
                throw r12     // Catch: java.lang.Throwable -> L21
            La2:
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L21
                ir.nasim.QJ0.a(r6, r4)
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                return r12
            Laa:
                throw r12     // Catch: java.lang.Throwable -> Lab
            Lab:
                r0 = move-exception
                ir.nasim.QJ0.a(r6, r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18524oo1.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public AbstractC18524oo1(AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, String str) {
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(str, "name");
        this.a = str;
        this.b = DJ0.a(Integer.MAX_VALUE, EnumC6162Ml0.SUSPEND, null);
        this.c = AbstractC20906so1.a(interfaceC20315ro1.getCoroutineContext().X(P17.a((InterfaceC13730gj3) interfaceC20315ro1.getCoroutineContext().a(InterfaceC13730gj3.n0))).X(abstractC13778go1.B0(1)).X(new C19115po1(str)));
    }

    protected abstract Object c(Object obj, InterfaceC20295rm1 interfaceC20295rm1);

    public final void d(Object obj) {
        AbstractC10533bm0.d(this.c, null, null, new a(obj, null), 3, null);
    }

    public void e() {
        VI5.a.a(this.b, null, 1, null);
        AbstractC20906so1.d(this.c, null, 1, null);
    }

    public final void f() {
        AbstractC10533bm0.d(this.c, null, null, new b(null), 3, null);
    }
}
