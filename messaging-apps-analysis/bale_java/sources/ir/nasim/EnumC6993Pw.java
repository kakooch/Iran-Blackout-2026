package ir.nasim;

/* renamed from: ir.nasim.Pw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC6993Pw {
    UNKNOWN(0),
    TOPUP(1),
    VOUCHER(2),
    WOW(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC6993Pw(int i) {
        this.a = i;
    }

    public static EnumC6993Pw p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : WOW : VOUCHER : TOPUP : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
