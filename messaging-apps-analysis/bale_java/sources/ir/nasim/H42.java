package ir.nasim;

import ir.nasim.AbstractC22169um7;
import ir.nasim.H42;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.core.network.RpcException;

/* loaded from: classes7.dex */
public final class H42 extends VW7 {
    private final DG2 b;
    private final C9057Yh4 c;
    private final C22434vE0 d;
    private String e;
    private final InterfaceC9336Zm4 f;
    private InterfaceC13730gj3 g;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return H42.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            C21231tK7 c21231tK7;
            Object value;
            C32 c32;
            String str;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                DG2 dg2 = H42.this.b;
                this.b = 1;
                objA = dg2.a(this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            H42 h42 = H42.this;
            if (C9475a16.j(objA) && (c21231tK7 = (C21231tK7) objA) != null) {
                String str2 = (String) c21231tK7.s().b();
                if (str2 == null) {
                    str2 = "";
                }
                h42.e = str2;
                InterfaceC9336Zm4 interfaceC9336Zm4 = h42.f;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c32 = (C32) value;
                    str = h42.e;
                    if (str == null) {
                        AbstractC13042fc3.y("oldUserId");
                        str = null;
                    }
                } while (!interfaceC9336Zm4.f(value, C32.c(c32, str, false, false, null, false, null, 62, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return H42.this.new b(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r13.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2b
                if (r1 == r4) goto L27
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                ir.nasim.AbstractC10685c16.b(r14)
                ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
                java.lang.Object r14 = r14.l()
                goto L76
            L1b:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L23:
                ir.nasim.AbstractC10685c16.b(r14)
                goto L65
            L27:
                ir.nasim.AbstractC10685c16.b(r14)
                goto L39
            L2b:
                ir.nasim.AbstractC10685c16.b(r14)
                r13.b = r4
                r4 = 400(0x190, double:1.976E-321)
                java.lang.Object r14 = ir.nasim.HG1.b(r4, r13)
                if (r14 != r0) goto L39
                return r0
            L39:
                ir.nasim.H42 r14 = ir.nasim.H42.this
                ir.nasim.Zm4 r14 = ir.nasim.H42.U0(r14)
            L3f:
                java.lang.Object r1 = r14.getValue()
                r4 = r1
                ir.nasim.C32 r4 = (ir.nasim.C32) r4
                ir.nasim.um7$c r10 = ir.nasim.AbstractC22169um7.c.a
                r11 = 31
                r12 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                ir.nasim.C32 r4 = ir.nasim.C32.c(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                boolean r1 = r14.f(r1, r4)
                if (r1 == 0) goto L3f
                r13.b = r3
                r3 = 300(0x12c, double:1.48E-321)
                java.lang.Object r14 = ir.nasim.HG1.b(r3, r13)
                if (r14 != r0) goto L65
                return r0
            L65:
                ir.nasim.H42 r14 = ir.nasim.H42.this
                ir.nasim.vE0 r14 = ir.nasim.H42.P0(r14)
                java.lang.String r1 = r13.d
                r13.b = r2
                java.lang.Object r14 = r14.a(r1, r13)
                if (r14 != r0) goto L76
                return r0
            L76:
                ir.nasim.H42 r0 = ir.nasim.H42.this
                boolean r1 = ir.nasim.C9475a16.j(r14)
                if (r1 == 0) goto Lca
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 == 0) goto La6
                ir.nasim.Zm4 r14 = ir.nasim.H42.U0(r0)
            L8a:
                java.lang.Object r0 = r14.getValue()
                r1 = r0
                ir.nasim.C32 r1 = (ir.nasim.C32) r1
                ir.nasim.um7$a r7 = ir.nasim.AbstractC22169um7.a.a
                r8 = 31
                r9 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                ir.nasim.C32 r1 = ir.nasim.C32.c(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                boolean r0 = r14.f(r0, r1)
                if (r0 == 0) goto L8a
                goto Lca
            La6:
                ir.nasim.Zm4 r14 = ir.nasim.H42.U0(r0)
            Laa:
                java.lang.Object r0 = r14.getValue()
                r1 = r0
                ir.nasim.C32 r1 = (ir.nasim.C32) r1
                ir.nasim.um7$b r7 = new ir.nasim.um7$b
                ir.nasim.am7 r2 = ir.nasim.EnumC9920am7.f
                r7.<init>(r2)
                r8 = 31
                r9 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                ir.nasim.C32 r1 = ir.nasim.C32.c(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                boolean r0 = r14.f(r0, r1)
                if (r0 == 0) goto Laa
            Lca:
                ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.H42.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(H42 h42, C14505i18 c14505i18) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = h42.f;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, null, true, null, 47, null)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(H42 h42, Exception exc) {
            Object value;
            Object value2;
            Object value3;
            Object value4;
            if (!(exc instanceof RpcException)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = h42.f;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, YF6.d, false, null, 55, null)));
                return;
            }
            String str = ((RpcException) exc).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String();
            if (AbstractC13042fc3.d(str, "NICKNAME_BUSY")) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = h42.f;
                do {
                    value4 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value4, C32.c((C32) value4, null, false, false, YF6.b, false, null, 55, null)));
            } else if (AbstractC13042fc3.d(str, "NICKNAME_INVALID")) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = h42.f;
                do {
                    value3 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value3, C32.c((C32) value3, null, false, false, YF6.c, false, null, 55, null)));
            } else {
                InterfaceC9336Zm4 interfaceC9336Zm44 = h42.f;
                do {
                    value2 = interfaceC9336Zm44.getValue();
                } while (!interfaceC9336Zm44.f(value2, C32.c((C32) value2, null, false, false, YF6.d, false, null, 55, null)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(H42 h42, C14505i18 c14505i18, Exception exc) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = h42.f;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, null, false, null, 59, null)));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return H42.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC9336Zm4 interfaceC9336Zm4 = H42.this.f;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, true, null, false, null, 57, null)));
            C6517Nv5 c6517Nv5E = H42.this.c.H().E(this.d);
            final H42 h42 = H42.this;
            C6517Nv5 c6517Nv5M0 = c6517Nv5E.m0(new InterfaceC24449ye1() { // from class: ir.nasim.I42
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    H42.c.D(h42, (C14505i18) obj2);
                }
            });
            final H42 h422 = H42.this;
            C6517Nv5 c6517Nv5E2 = c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.J42
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    H42.c.G(h422, (Exception) obj2);
                }
            });
            final H42 h423 = H42.this;
            c6517Nv5E2.z(new InterfaceC3273Ae1() { // from class: ir.nasim.K42
                @Override // ir.nasim.InterfaceC3273Ae1
                public final void apply(Object obj2, Object obj3) {
                    H42.c.H(h423, (C14505i18) obj2, (Exception) obj3);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public H42(DG2 dg2, C9057Yh4 c9057Yh4, C22434vE0 c22434vE0) {
        AbstractC13042fc3.i(dg2, "getUserVmUseCase");
        AbstractC13042fc3.i(c9057Yh4, "modules");
        AbstractC13042fc3.i(c22434vE0, "canSetNickNameUseCase");
        this.b = dg2;
        this.c = c9057Yh4;
        this.d = c22434vE0;
        this.f = AbstractC12281eL6.a(C32.g.a());
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    private final void W0(String str) {
        InterfaceC13730gj3 interfaceC13730gj3 = this.g;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.g = AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(str, null), 3, null);
    }

    private final AbstractC22169um7 Y0(String str) {
        if (str.length() == 0) {
            return AbstractC22169um7.a.a;
        }
        if (str.length() > B32.c.j()) {
            return new AbstractC22169um7.b(EnumC9920am7.a);
        }
        if (str.length() < 5) {
            return new AbstractC22169um7.b(EnumC9920am7.b);
        }
        if (!a1(str)) {
            return new AbstractC22169um7.b(EnumC9920am7.c);
        }
        if (AbstractC22039uZ6.s1(str) == '_') {
            return new AbstractC22169um7.b(EnumC9920am7.d);
        }
        if (Character.isDigit(AbstractC22039uZ6.s1(str))) {
            return new AbstractC22169um7.b(EnumC9920am7.e);
        }
        String str2 = this.e;
        if (str2 == null) {
            AbstractC13042fc3.y("oldUserId");
            str2 = null;
        }
        if (!AbstractC13042fc3.d(str2, str)) {
            W0(str);
        }
        return AbstractC22169um7.a.a;
    }

    private final boolean a1(String str) {
        return new C20644sM5("^[a-zA-Z0-9_]+$").g(str);
    }

    public final void X0(String str) {
        Object value;
        C32 c32;
        String str2;
        AbstractC13042fc3.i(str, "newUserId");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c32 = (C32) value;
            str2 = this.e;
            if (str2 == null) {
                AbstractC13042fc3.y("oldUserId");
                str2 = null;
            }
        } while (!interfaceC9336Zm4.f(value, C32.c(c32, str, !AbstractC13042fc3.d(str2, str), false, null, false, Y0(str), 28, null)));
    }

    public final InterfaceC10258bL6 Z0() {
        return this.f;
    }

    public final void b1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C32.c((C32) value, null, false, false, null, false, null, 55, null)));
    }

    public final void c1(String str) {
        AbstractC13042fc3.i(str, "newUserId");
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new c(str, null), 2, null);
    }
}
