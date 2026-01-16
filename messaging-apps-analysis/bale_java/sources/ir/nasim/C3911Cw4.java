package ir.nasim;

/* renamed from: ir.nasim.Cw4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3911Cw4 extends AbstractC21707u0 implements InterfaceC25225zw4 {
    private final C9057Yh4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3911Cw4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
    }

    @Override // ir.nasim.InterfaceC25225zw4
    public C6517Nv5 a(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (!(abstractC20556sC7 instanceof C12228eF7)) {
            return null;
        }
        C12228eF7 c12228eF7 = (C12228eF7) abstractC20556sC7;
        this.b.S().T5(c12228eF7.a(), c12228eF7.b());
        return C6517Nv5.l0(C14505i18.a);
    }
}
