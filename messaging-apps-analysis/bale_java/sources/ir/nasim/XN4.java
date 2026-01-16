package ir.nasim;

/* loaded from: classes3.dex */
public final class XN4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public XN4(QN4 qn4) {
        this.a = qn4;
    }

    public static XN4 a(QN4 qn4) {
        return new XN4(qn4);
    }

    public static UA2 c(QN4 qn4) {
        return qn4.g();
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UA2 get() {
        return c(this.a);
    }
}
