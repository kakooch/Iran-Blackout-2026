package ir.nasim;

/* renamed from: ir.nasim.cA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC10768cA {
    UNKNOWN(0),
    TOPUP(1),
    WOW(2),
    VOUCHER(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC10768cA(int i) {
        this.a = i;
    }

    public static EnumC10768cA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : VOUCHER : WOW : TOPUP : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
