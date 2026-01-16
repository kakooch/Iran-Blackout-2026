package ir.nasim;

/* loaded from: classes3.dex */
public final class NN implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public NN(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static AbstractC24902zP a(AbstractC24902zP abstractC24902zP) {
        return (AbstractC24902zP) AbstractC4746Gj5.d(KN.a.d(abstractC24902zP));
    }

    public static NN b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new NN(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC24902zP get() {
        return a((AbstractC24902zP) this.a.get());
    }
}
