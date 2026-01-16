package ir.nasim;

/* loaded from: classes3.dex */
class GL4 implements InterfaceC7959Tx5 {
    private static final InterfaceC24229yG1 c = new InterfaceC24229yG1() { // from class: ir.nasim.EL4
        @Override // ir.nasim.InterfaceC24229yG1
        public final void a(InterfaceC7959Tx5 interfaceC7959Tx5) {
            GL4.d(interfaceC7959Tx5);
        }
    };
    private static final InterfaceC7959Tx5 d = new InterfaceC7959Tx5() { // from class: ir.nasim.FL4
        @Override // ir.nasim.InterfaceC7959Tx5
        public final Object get() {
            return GL4.e();
        }
    };
    private InterfaceC24229yG1 a;
    private volatile InterfaceC7959Tx5 b;

    private GL4(InterfaceC24229yG1 interfaceC24229yG1, InterfaceC7959Tx5 interfaceC7959Tx5) {
        this.a = interfaceC24229yG1;
        this.b = interfaceC7959Tx5;
    }

    static GL4 c() {
        return new GL4(c, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object e() {
        return null;
    }

    void f(InterfaceC7959Tx5 interfaceC7959Tx5) {
        InterfaceC24229yG1 interfaceC24229yG1;
        if (this.b != d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC24229yG1 = this.a;
            this.a = null;
            this.b = interfaceC7959Tx5;
        }
        interfaceC24229yG1.a(interfaceC7959Tx5);
    }

    @Override // ir.nasim.InterfaceC7959Tx5
    public Object get() {
        return this.b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(InterfaceC7959Tx5 interfaceC7959Tx5) {
    }
}
