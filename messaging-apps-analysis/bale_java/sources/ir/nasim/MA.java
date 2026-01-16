package ir.nasim;

/* loaded from: classes4.dex */
public enum MA {
    UNKNOWN(0),
    TOPUP(1),
    WITHDRAW(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    MA(int i) {
        this.a = i;
    }

    public static MA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? UNSUPPORTED_VALUE : WITHDRAW : TOPUP : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
