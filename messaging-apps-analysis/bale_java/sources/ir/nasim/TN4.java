package ir.nasim;

/* loaded from: classes3.dex */
public final class TN4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public TN4(QN4 qn4) {
        this.a = qn4;
    }

    public static AbstractC24902zP a(QN4 qn4) {
        return qn4.c();
    }

    public static TN4 b(QN4 qn4) {
        return new TN4(qn4);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC24902zP get() {
        return a(this.a);
    }
}
