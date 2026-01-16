package ir.nasim;

import ir.nasim.InterfaceC11938do1;

/* renamed from: ir.nasim.j96, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15190j96 extends AbstractC22163um1 implements InterfaceC4806Gq2, InterfaceC23369wo1 {
    public final InterfaceC4806Gq2 a;
    public final InterfaceC11938do1 b;
    public final int c;
    private InterfaceC11938do1 d;
    private InterfaceC20295rm1 e;

    /* renamed from: ir.nasim.j96$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final Integer a(int i, InterfaceC11938do1.b bVar) {
            return Integer.valueOf(i + 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (InterfaceC11938do1.b) obj2);
        }
    }

    public C15190j96(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC11938do1 interfaceC11938do1) {
        super(JA4.a, C18712p72.a);
        this.a = interfaceC4806Gq2;
        this.b = interfaceC11938do1;
        this.c = ((Number) interfaceC11938do1.f0(0, a.e)).intValue();
    }

    private final void n(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12, Object obj) {
        if (interfaceC11938do12 instanceof C17193mZ1) {
            y((C17193mZ1) interfaceC11938do12, obj);
        }
        AbstractC16372l96.a(this, interfaceC11938do1);
    }

    private final Object w(InterfaceC20295rm1 interfaceC20295rm1, Object obj) {
        InterfaceC11938do1 context = interfaceC20295rm1.getContext();
        AbstractC19067pj3.n(context);
        InterfaceC11938do1 interfaceC11938do1 = this.d;
        if (interfaceC11938do1 != context) {
            n(context, interfaceC11938do1, obj);
            this.d = context;
        }
        this.e = interfaceC20295rm1;
        InterfaceC15796kB2 interfaceC15796kB2 = AbstractC15781k96.a;
        InterfaceC4806Gq2 interfaceC4806Gq2 = this.a;
        AbstractC13042fc3.g(interfaceC4806Gq2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objQ = interfaceC15796kB2.q(interfaceC4806Gq2, obj, this);
        if (!AbstractC13042fc3.d(objQ, AbstractC14862ic3.e())) {
            this.e = null;
        }
        return objQ;
    }

    private final void y(C17193mZ1 c17193mZ1, Object obj) {
        throw new IllegalStateException(AbstractC16016kZ6.g("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + c17193mZ1.a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // ir.nasim.InterfaceC4806Gq2
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        try {
            Object objW = w(interfaceC20295rm1, obj);
            if (objW == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objW == AbstractC14862ic3.e() ? objW : C19938rB7.a;
        } catch (Throwable th) {
            this.d = new C17193mZ1(th, interfaceC20295rm1.getContext());
            throw th;
        }
    }

    @Override // ir.nasim.E90, ir.nasim.InterfaceC23369wo1
    public InterfaceC23369wo1 getCallerFrame() {
        InterfaceC20295rm1 interfaceC20295rm1 = this.e;
        if (interfaceC20295rm1 instanceof InterfaceC23369wo1) {
            return (InterfaceC23369wo1) interfaceC20295rm1;
        }
        return null;
    }

    @Override // ir.nasim.AbstractC22163um1, ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        InterfaceC11938do1 interfaceC11938do1 = this.d;
        return interfaceC11938do1 == null ? C18712p72.a : interfaceC11938do1;
    }

    @Override // ir.nasim.E90
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // ir.nasim.E90
    public Object invokeSuspend(Object obj) {
        Throwable thE = C9475a16.e(obj);
        if (thE != null) {
            this.d = new C17193mZ1(thE, getContext());
        }
        InterfaceC20295rm1 interfaceC20295rm1 = this.e;
        if (interfaceC20295rm1 != null) {
            interfaceC20295rm1.resumeWith(obj);
        }
        return AbstractC14862ic3.e();
    }

    @Override // ir.nasim.AbstractC22163um1, ir.nasim.E90
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
