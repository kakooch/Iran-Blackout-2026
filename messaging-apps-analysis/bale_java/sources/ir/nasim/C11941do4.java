package ir.nasim;

/* renamed from: ir.nasim.do4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11941do4 extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private final C9528a7 c;
    private final C9937ao4 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11941do4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        C9528a7 c9528a7C = C12736f7.n().c(C4614Fw5.d(new V6() { // from class: ir.nasim.co4
            @Override // ir.nasim.V6
            public final K6 create() {
                return C11941do4.B(this.a);
            }
        }), "actor/mxp");
        AbstractC13042fc3.h(c9528a7C, "actorOf(...)");
        this.c = c9528a7C;
        this.d = new C9937ao4(c9528a7C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 B(C11941do4 c11941do4) {
        AbstractC13042fc3.i(c11941do4, "this$0");
        return new C9345Zn4(c11941do4.b);
    }

    public final C6517Nv5 C() {
        return this.d.j();
    }

    public final C6517Nv5 D(String str) {
        AbstractC13042fc3.i(str, "query");
        return this.d.k(str);
    }

    public final C6517Nv5 E() {
        return this.d.l();
    }
}
