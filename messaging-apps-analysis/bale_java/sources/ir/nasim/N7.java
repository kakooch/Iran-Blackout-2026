package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.K7;
import ir.nasim.core.network.RpcException;

/* loaded from: classes7.dex */
public final class N7 extends VW7 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final KM2 b;
    private final C10299bQ2 c;
    private final InterfaceC9336Zm4 d;
    private final InterfaceC10258bL6 e;
    private final InterfaceC9173Yu3 f;
    private final InterfaceC9173Yu3 g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ int f;
        final /* synthetic */ SA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = i;
            this.g = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return N7.this.new b(this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            N7 n7;
            Object objD;
            SA2 sa2;
            Object value;
            Object aVar;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Integer numZ0 = N7.this.Z0();
                if (numZ0 != null) {
                    n7 = N7.this;
                    int i2 = this.f;
                    SA2 sa22 = this.g;
                    C6517Nv5 c6517Nv5K1 = n7.c.k1(i2, numZ0.intValue(), 0);
                    this.b = n7;
                    this.c = sa22;
                    this.d = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5K1, null, this, 1, null);
                    if (objD == objE) {
                        return objE;
                    }
                    sa2 = sa22;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sa2 = (SA2) this.c;
            n7 = (N7) this.b;
            AbstractC10685c16.b(obj);
            objD = ((C9475a16) obj).l();
            if (C9475a16.j(objD)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = n7.d;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value2, K7.b.a));
                sa2.invoke();
            }
            Throwable thE = C9475a16.e(objD);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = n7.d;
                do {
                    value = interfaceC9336Zm42.getValue();
                    K7 k7 = (K7) value;
                    if ((k7 instanceof K7.d) && (thE instanceof RpcException)) {
                        RpcException rpcException = (RpcException) thE;
                        aVar = K7.d.b((K7.d) k7, null, false, AbstractC6392Nk0.d((rpcException.getCode() == 6 && AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "ALREADY_INVITED")) ? RD5.features_sharedmedia_add_bot_to_group_failed_already_exist : (rpcException.getCode() == 7 && AbstractC13042fc3.d(rpcException.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "NOT_APPROVED")) ? RD5.features_sharedmedia_add_bot_to_group_failed_privacy_not_allowed : RD5.error_unknown), 1, null);
                    } else {
                        aVar = new K7.a(thE);
                    }
                } while (!interfaceC9336Zm42.f(value, aVar));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return N7.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                N7 n7 = N7.this;
                this.b = 1;
                if (n7.d1(this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return N7.this.d1(this);
        }
    }

    public N7(KM2 km2, C10299bQ2 c10299bQ2, final androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = km2;
        this.c = c10299bQ2;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(K7.b.a);
        this.d = interfaceC9336Zm4A;
        this.e = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.L7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return N7.X0(yVar);
            }
        });
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.M7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return N7.Y0(yVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer X0(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        return (Integer) yVar.c("botIdArg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Y0(androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(yVar, "$savedStateHandle");
        return (String) yVar.c("botNameArg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer Z0() {
        return (Integer) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ee -> B:39:0x00f1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d1(ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.N7.d1(ir.nasim.rm1):java.lang.Object");
    }

    private final void f1() {
        Object value;
        Object objB;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
            objB = (K7) value;
            if (objB instanceof K7.d) {
                objB = K7.d.b((K7.d) objB, null, true, null, 5, null);
            }
        } while (!interfaceC9336Zm4.f(value, objB));
    }

    public final void W0(int i2, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "done");
        f1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(i2, sa2, null), 3, null);
    }

    public final String a1() {
        return (String) this.g.getValue();
    }

    public final InterfaceC10258bL6 b1() {
        return this.e;
    }

    public final InterfaceC13730gj3 c1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final void e1() {
        Object value;
        Object objB;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
            objB = (K7) value;
            if (objB instanceof K7.d) {
                objB = K7.d.b((K7.d) objB, null, false, null, 3, null);
            }
        } while (!interfaceC9336Zm4.f(value, objB));
    }
}
