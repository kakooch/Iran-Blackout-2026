package ir.nasim;

/* loaded from: classes5.dex */
public final class D08 extends AbstractC21707u0 implements D48 {
    private final C9057Yh4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D08(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
    }

    @Override // ir.nasim.D48
    public boolean d(AbstractC20556sC7 abstractC20556sC7, long j) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (!(abstractC20556sC7 instanceof MC7)) {
            return false;
        }
        this.b.X().Q(abstractC20556sC7);
        return true;
    }
}
