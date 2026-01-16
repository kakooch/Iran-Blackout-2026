package ir.nasim;

/* renamed from: ir.nasim.Pz4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7035Pz4 extends AbstractC21707u0 implements InterfaceC25225zw4 {
    private final C9057Yh4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7035Pz4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
    }

    @Override // ir.nasim.InterfaceC25225zw4
    public C6517Nv5 a(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if ((abstractC20556sC7 instanceof BG7) || (abstractC20556sC7 instanceof C24829zG7)) {
            return this.b.Y().D().p(abstractC20556sC7);
        }
        return null;
    }
}
