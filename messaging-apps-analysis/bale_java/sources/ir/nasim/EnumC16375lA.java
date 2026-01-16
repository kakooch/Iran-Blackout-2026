package ir.nasim;

/* renamed from: ir.nasim.lA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC16375lA {
    UNKNOWN(0),
    CHARGE_TOPUP(1),
    CHARGE_WOW(2),
    CHARGE_VOUCHER(3),
    INTERNET_BUNDLE(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC16375lA(int i) {
        this.a = i;
    }

    public static EnumC16375lA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : INTERNET_BUNDLE : CHARGE_VOUCHER : CHARGE_WOW : CHARGE_TOPUP : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
