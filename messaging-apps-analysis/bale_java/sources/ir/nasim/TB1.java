package ir.nasim;

import ir.nasim.C9475a16;

/* loaded from: classes8.dex */
final class TB1 extends SB1 implements InterfaceC20295rm1 {
    private InterfaceC15796kB2 a;
    private Object b;
    private InterfaceC20295rm1 c;
    private Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TB1(InterfaceC15796kB2 interfaceC15796kB2, Object obj) {
        super(null);
        AbstractC13042fc3.i(interfaceC15796kB2, "block");
        this.a = interfaceC15796kB2;
        this.b = obj;
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = this;
        this.d = RB1.a;
    }

    @Override // ir.nasim.SB1
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.c = interfaceC20295rm1;
        this.b = obj;
        Object objE = AbstractC14862ic3.e();
        if (objE == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objE;
    }

    public final Object c() {
        while (true) {
            Object obj = this.d;
            InterfaceC20295rm1 interfaceC20295rm1 = this.c;
            if (interfaceC20295rm1 == null) {
                AbstractC10685c16.b(obj);
                return obj;
            }
            if (C9475a16.d(RB1.a, obj)) {
                try {
                    InterfaceC15796kB2 interfaceC15796kB2 = this.a;
                    Object obj2 = this.b;
                    Object objD = !(interfaceC15796kB2 instanceof E90) ? AbstractC14251hc3.d(interfaceC15796kB2, this, obj2, interfaceC20295rm1) : ((InterfaceC15796kB2) AbstractC19810qy7.g(interfaceC15796kB2, 3)).q(this, obj2, interfaceC20295rm1);
                    if (objD != AbstractC14862ic3.e()) {
                        interfaceC20295rm1.resumeWith(C9475a16.b(objD));
                    }
                } catch (Throwable th) {
                    C9475a16.a aVar = C9475a16.b;
                    interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
                }
            } else {
                this.d = RB1.a;
                interfaceC20295rm1.resumeWith(obj);
            }
        }
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        return C18712p72.a;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public void resumeWith(Object obj) {
        this.c = null;
        this.d = obj;
    }
}
