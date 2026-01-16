package ir.nasim;

/* renamed from: ir.nasim.dd6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11834dd6 implements InterfaceC20817sf2 {
    private final InterfaceC7720Sx5 a;

    public C11834dd6(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static AbstractC4684Gc6 a(QV0 qv0) {
        return (AbstractC4684Gc6) AbstractC3561Bj5.c(AbstractC11039cd6.a(qv0), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static C11834dd6 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C11834dd6(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC4684Gc6 get() {
        return a((QV0) this.a.get());
    }
}
