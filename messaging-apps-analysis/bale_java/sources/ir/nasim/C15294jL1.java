package ir.nasim;

import ir.nasim.C15294jL1;
import ir.nasim.UJ1;
import ir.nasim.core.network.RpcException;

/* renamed from: ir.nasim.jL1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C15294jL1 extends VW7 {
    private final C14934ij6 b;
    private final XJ1 c;
    private final AbstractC13778go1 d;
    private final InterfaceC9336Zm4 e;
    private final InterfaceC10258bL6 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC10258bL6 h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC10258bL6 j;
    private final QJ1 k;

    /* renamed from: ir.nasim.jL1$a */
    public static final class a implements QJ1 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g(C15294jL1 c15294jL1) {
            AbstractC13042fc3.i(c15294jL1, "this$0");
            c15294jL1.c1(UJ1.b.a);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C15294jL1 c15294jL1, int i) {
            AbstractC13042fc3.i(c15294jL1, "this$0");
            c15294jL1.c1(new UJ1.a(i));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C15294jL1 c15294jL1, int i) {
            AbstractC13042fc3.i(c15294jL1, "this$0");
            c15294jL1.c1(new UJ1.e(i));
            return C19938rB7.a;
        }

        @Override // ir.nasim.QJ1
        public SA2 a() {
            final C15294jL1 c15294jL1 = C15294jL1.this;
            return new SA2() { // from class: ir.nasim.hL1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C15294jL1.a.g(c15294jL1);
                }
            };
        }

        @Override // ir.nasim.QJ1
        public UA2 b() {
            final C15294jL1 c15294jL1 = C15294jL1.this;
            return new UA2() { // from class: ir.nasim.iL1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C15294jL1.a.h(c15294jL1, ((Integer) obj).intValue());
                }
            };
        }

        @Override // ir.nasim.QJ1
        public UA2 c() {
            final C15294jL1 c15294jL1 = C15294jL1.this;
            return new UA2() { // from class: ir.nasim.gL1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C15294jL1.a.i(c15294jL1, ((Integer) obj).intValue());
                }
            };
        }
    }

    /* renamed from: ir.nasim.jL1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jL1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15294jL1 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15294jL1 c15294jL1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15294jL1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C6517Nv5 c6517Nv5I = this.c.b.I();
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5I, null, this, 1, null);
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

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15294jL1.this.new b(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.b
                r2 = 1
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L1f
                if (r1 == r2) goto L1b
                if (r1 != r3) goto L13
                ir.nasim.AbstractC10685c16.b(r10)
                goto L5a
            L13:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1b:
                ir.nasim.AbstractC10685c16.b(r10)
                goto L44
            L1f:
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.jL1 r10 = ir.nasim.C15294jL1.this
                ir.nasim.Zm4 r10 = ir.nasim.C15294jL1.T0(r10)
            L28:
                java.lang.Object r1 = r10.getValue()
                r5 = r1
                ir.nasim.xK1 r5 = (ir.nasim.C23675xK1) r5
                ir.nasim.xK1 r5 = ir.nasim.C23675xK1.b(r5, r2, r4, r3, r4)
                boolean r1 = r10.f(r1, r5)
                if (r1 == 0) goto L28
                r9.b = r2
                r1 = 200(0xc8, double:9.9E-322)
                java.lang.Object r10 = ir.nasim.HG1.b(r1, r9)
                if (r10 != r0) goto L44
                return r0
            L44:
                ir.nasim.jL1 r10 = ir.nasim.C15294jL1.this
                ir.nasim.go1 r10 = ir.nasim.C15294jL1.R0(r10)
                ir.nasim.jL1$b$a r1 = new ir.nasim.jL1$b$a
                ir.nasim.jL1 r2 = ir.nasim.C15294jL1.this
                r1.<init>(r2, r4)
                r9.b = r3
                java.lang.Object r10 = ir.nasim.AbstractC9323Zl0.g(r10, r1, r9)
                if (r10 != r0) goto L5a
                return r0
            L5a:
                ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
                java.lang.Object r10 = r10.l()
                ir.nasim.jL1 r0 = ir.nasim.C15294jL1.this
                boolean r1 = ir.nasim.C9475a16.j(r10)
                r2 = 0
                if (r1 == 0) goto L89
                r1 = r10
                java.util.List r1 = (java.util.List) r1
                ir.nasim.Zm4 r5 = ir.nasim.C15294jL1.T0(r0)
            L70:
                java.lang.Object r6 = r5.getValue()
                r7 = r6
                ir.nasim.xK1 r7 = (ir.nasim.C23675xK1) r7
                ir.nasim.XJ1 r8 = ir.nasim.C15294jL1.P0(r0)
                java.util.List r8 = r8.c(r1)
                ir.nasim.xK1 r7 = r7.a(r2, r8)
                boolean r6 = r5.f(r6, r7)
                if (r6 == 0) goto L70
            L89:
                ir.nasim.jL1 r0 = ir.nasim.C15294jL1.this
                java.lang.Throwable r10 = ir.nasim.C9475a16.e(r10)
                if (r10 == 0) goto Lb6
                ir.nasim.Zm4 r1 = ir.nasim.C15294jL1.T0(r0)
            L95:
                java.lang.Object r5 = r1.getValue()
                r6 = r5
                ir.nasim.xK1 r6 = (ir.nasim.C23675xK1) r6
                ir.nasim.xK1 r6 = ir.nasim.C23675xK1.b(r6, r2, r4, r3, r4)
                boolean r5 = r1.f(r5, r6)
                if (r5 == 0) goto L95
                ir.nasim.ZF6$a r1 = new ir.nasim.ZF6$a
                java.lang.String r10 = r10.getMessage()
                if (r10 != 0) goto Lb0
                java.lang.String r10 = "EXCEPTION"
            Lb0:
                r1.<init>(r10)
                ir.nasim.C15294jL1.V0(r0, r1)
            Lb6:
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15294jL1.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jL1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jL1$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15294jL1 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15294jL1 c15294jL1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15294jL1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C6517Nv5 c6517Nv5N = this.c.b.N();
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5N, null, this, 1, null);
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

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15294jL1.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C15294jL1.this.e;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C23675xK1.b((C23675xK1) value, true, null, 2, null)));
                AbstractC13778go1 abstractC13778go1 = C15294jL1.this.d;
                a aVar = new a(C15294jL1.this, null);
                this.b = 1;
                obj = AbstractC9323Zl0.g(abstractC13778go1, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Object objL = ((C9475a16) obj).l();
            C15294jL1 c15294jL1 = C15294jL1.this;
            if (C9475a16.j(objL)) {
                c15294jL1.a1();
            }
            C15294jL1 c15294jL12 = C15294jL1.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                c15294jL12.a1();
                Exception exc = thE instanceof RpcException ? (RpcException) thE : null;
                if (exc == null) {
                    exc = new Exception(thE);
                }
                c15294jL12.c1(new UJ1.c(exc));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jL1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* renamed from: ir.nasim.jL1$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15294jL1 c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15294jL1 c15294jL1, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15294jL1;
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C6517Nv5 c6517Nv5P = this.c.b.P(this.d);
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5P, null, this, 1, null);
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

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15294jL1.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C15294jL1.this.e;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C23675xK1.b((C23675xK1) value, true, null, 2, null)));
                AbstractC13778go1 abstractC13778go1 = C15294jL1.this.d;
                a aVar = new a(C15294jL1.this, this.d, null);
                this.b = 1;
                obj = AbstractC9323Zl0.g(abstractC13778go1, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Object objL = ((C9475a16) obj).l();
            C15294jL1 c15294jL1 = C15294jL1.this;
            if (C9475a16.j(objL)) {
                c15294jL1.a1();
            }
            C15294jL1 c15294jL12 = C15294jL1.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                c15294jL12.a1();
                Exception exc = thE instanceof RpcException ? (RpcException) thE : null;
                if (exc == null) {
                    exc = new Exception(thE);
                }
                c15294jL12.c1(new UJ1.d(exc));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15294jL1(C14934ij6 c14934ij6, XJ1 xj1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c14934ij6, "securityModule");
        AbstractC13042fc3.i(xj1, "deviceDtoConverter");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = c14934ij6;
        this.c = xj1;
        this.d = abstractC13778go1;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C23675xK1(false, null, 3, null));
        this.e = interfaceC9336Zm4A;
        this.f = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(null);
        this.g = interfaceC9336Zm4A2;
        this.h = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(null);
        this.i = interfaceC9336Zm4A3;
        this.j = AbstractC6459Nq2.c(interfaceC9336Zm4A3);
        a1();
        this.k = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(ZF6 zf6) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, zf6));
    }

    public final QJ1 W0() {
        return this.k;
    }

    public final InterfaceC10258bL6 X0() {
        return this.f;
    }

    public final InterfaceC10258bL6 Y0() {
        return this.j;
    }

    public final InterfaceC10258bL6 Z0() {
        return this.h;
    }

    public final void b1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void c1(UJ1 uj1) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, uj1));
    }

    public final void e1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final void f1(int i) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(i, null), 3, null);
    }
}
