package ir.nasim;

/* loaded from: classes3.dex */
public final class VN4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public VN4(QN4 qn4) {
        this.a = qn4;
    }

    public static VN4 a(QN4 qn4) {
        return new VN4(qn4);
    }

    public static boolean b(QN4 qn4) {
        return qn4.e();
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean get() {
        return Boolean.valueOf(b(this.a));
    }
}
