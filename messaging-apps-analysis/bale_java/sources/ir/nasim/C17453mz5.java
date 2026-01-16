package ir.nasim;

/* renamed from: ir.nasim.mz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17453mz5 extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private final C9528a7 c;
    private final InterfaceC9173Yu3 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17453mz5(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        C9528a7 c9528a7D = C12736f7.n().d("actor/pushReg", new V6() { // from class: ir.nasim.kz5
            @Override // ir.nasim.V6
            public final K6 create() {
                return C17453mz5.D(this.a);
            }
        });
        AbstractC13042fc3.h(c9528a7D, "actorOf(...)");
        this.c = c9528a7D;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lz5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17453mz5.E(this.a);
            }
        });
    }

    private final C25244zy5 C() {
        return (C25244zy5) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 D(C17453mz5 c17453mz5) {
        AbstractC13042fc3.i(c17453mz5, "this$0");
        return new C24650yy5(c17453mz5.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C25244zy5 E(C17453mz5 c17453mz5) {
        AbstractC13042fc3.i(c17453mz5, "this$0");
        return new C25244zy5(c17453mz5.c);
    }

    public final void F(long j, String str) {
        AbstractC13042fc3.i(str, "token");
        C().j(j, str);
    }

    public final C6517Nv5 G(String str) {
        AbstractC13042fc3.i(str, "token");
        return C().k(str);
    }
}
