package ir.nasim;

/* loaded from: classes4.dex */
public enum QA {
    UNKNOWN(0),
    DIRECT(1),
    EXTRA(2),
    VOUCHER(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    QA(int i) {
        this.a = i;
    }

    public static QA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : VOUCHER : EXTRA : DIRECT : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
