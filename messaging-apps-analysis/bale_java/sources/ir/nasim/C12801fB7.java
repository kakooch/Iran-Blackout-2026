package ir.nasim;

/* renamed from: ir.nasim.fB7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12801fB7 extends C18419od6 {
    private final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public C12801fB7(InterfaceC11938do1 interfaceC11938do1, InterfaceC20295rm1 interfaceC20295rm1) {
        C14010hB7 c14010hB7 = C14010hB7.a;
        super(interfaceC11938do1.a(c14010hB7) == null ? interfaceC11938do1.X(c14010hB7) : interfaceC11938do1, interfaceC20295rm1);
        this.e = new ThreadLocal();
        if (interfaceC20295rm1.getContext().a(InterfaceC22753vm1.g0) instanceof AbstractC13778go1) {
            return;
        }
        Object objC = AbstractC7173Qo7.c(interfaceC11938do1, null);
        AbstractC7173Qo7.a(interfaceC11938do1, objC);
        i1(interfaceC11938do1, objC);
    }

    @Override // ir.nasim.C18419od6, ir.nasim.K0
    protected void d1(Object obj) {
        if (this.threadLocalIsSet) {
            XV4 xv4 = (XV4) this.e.get();
            if (xv4 != null) {
                AbstractC7173Qo7.a((InterfaceC11938do1) xv4.a(), xv4.b());
            }
            this.e.remove();
        }
        Object objA = E01.a(obj, this.d);
        InterfaceC20295rm1 interfaceC20295rm1 = this.d;
        InterfaceC11938do1 context = interfaceC20295rm1.getContext();
        Object objC = AbstractC7173Qo7.c(context, null);
        C12801fB7 c12801fB7G = objC != AbstractC7173Qo7.a ? AbstractC12551eo1.g(interfaceC20295rm1, context, objC) : null;
        try {
            this.d.resumeWith(objA);
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            if (c12801fB7G == null || c12801fB7G.h1()) {
                AbstractC7173Qo7.a(context, objC);
            }
        }
    }

    public final boolean h1() {
        boolean z = this.threadLocalIsSet && this.e.get() == null;
        this.e.remove();
        return !z;
    }

    public final void i1(InterfaceC11938do1 interfaceC11938do1, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(AbstractC4616Fw7.a(interfaceC11938do1, obj));
    }
}
