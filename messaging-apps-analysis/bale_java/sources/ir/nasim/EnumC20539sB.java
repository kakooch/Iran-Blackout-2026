package ir.nasim;

/* renamed from: ir.nasim.sB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC20539sB {
    PAYMENT_UNKNOWN(0),
    PAYMENT_COUNT(1),
    PAYMENT_AMOUNT(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC20539sB(int i) {
        this.a = i;
    }

    public static EnumC20539sB p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? UNSUPPORTED_VALUE : PAYMENT_AMOUNT : PAYMENT_COUNT : PAYMENT_UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
