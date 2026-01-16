package ir.nasim;

import ir.nasim.PI7;

/* renamed from: ir.nasim.ho5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14375ho5 extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private final InterfaceC4308Eo5 c;
    private final C17614nG2 d;
    private final BG2 e;

    /* renamed from: ir.nasim.ho5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ UA2 e;

        /* renamed from: ir.nasim.ho5$a$a, reason: collision with other inner class name */
        static final class C1283a implements InterfaceC4806Gq2 {
            final /* synthetic */ UA2 a;

            C1283a(UA2 ua2) {
                this.a = ua2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(PI7 pi7, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.invoke(pi7);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14375ho5.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14375ho5 c14375ho5 = C14375ho5.this;
                long j = this.d;
                this.b = 1;
                obj = c14375ho5.F(j, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            C1283a c1283a = new C1283a(this.e);
            this.b = 2;
            if (((InterfaceC4557Fq2) obj).b(c1283a, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ho5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ InterfaceC14603iB2 d;
        final /* synthetic */ C14375ho5 e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14603iB2 interfaceC14603iB2, C14375ho5 c14375ho5, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
            this.e = c14375ho5;
            this.f = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC14603iB2 interfaceC14603iB2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14603iB2 interfaceC14603iB22 = this.d;
                C14375ho5 c14375ho5 = this.e;
                long j = this.f;
                this.b = interfaceC14603iB22;
                this.c = 1;
                Object objE2 = c14375ho5.E(j, this);
                if (objE2 == objE) {
                    return objE;
                }
                interfaceC14603iB2 = interfaceC14603iB22;
                obj = objE2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC14603iB2 = (InterfaceC14603iB2) this.b;
                AbstractC10685c16.b(obj);
            }
            PI7 pi7 = (PI7) obj;
            interfaceC14603iB2.invoke(AbstractC6392Nk0.a((pi7 != null ? pi7.u() : null) == PI7.a.ONLINE), AbstractC6392Nk0.e(this.f));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14375ho5(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "modules");
        this.b = c9057Yh4;
        C11942do5.p.b(c9057Yh4);
        C12736f7.n().d("actor/presence/own", new V6() { // from class: ir.nasim.go5
            @Override // ir.nasim.V6
            public final K6 create() {
                return C14375ho5.B(this.a);
            }
        });
        InterfaceC13191fo5 interfaceC13191fo5 = (InterfaceC13191fo5) I22.a(C5721Ko.a.d(), InterfaceC13191fo5.class);
        this.c = interfaceC13191fo5.V0();
        this.d = interfaceC13191fo5.k();
        this.e = interfaceC13191fo5.G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 B(C14375ho5 c14375ho5) {
        AbstractC13042fc3.i(c14375ho5, "this$0");
        return new C21264tO4(c14375ho5.b);
    }

    public final void C(androidx.lifecycle.j jVar, long j, UA2 ua2) {
        AbstractC13042fc3.i(jVar, "lifeCycle");
        AbstractC13042fc3.i(ua2, "onChangedListener");
        AbstractC10533bm0.d(androidx.lifecycle.o.a(jVar), null, null, new a(j, ua2, null), 3, null);
    }

    public final InterfaceC13730gj3 D(androidx.lifecycle.j jVar, long j, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(jVar, "lifeCycle");
        AbstractC13042fc3.i(interfaceC14603iB2, "onChangedListener");
        return AbstractC10533bm0.d(androidx.lifecycle.o.a(jVar), null, null, new b(interfaceC14603iB2, this, j, null), 3, null);
    }

    public final Object E(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.d.d(j, interfaceC20295rm1);
    }

    public final Object F(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.e.b(j, interfaceC20295rm1);
    }

    public final void G(int i, long j) {
        this.c.j(i, j);
    }
}
