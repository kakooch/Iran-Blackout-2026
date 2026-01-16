package ir.nasim;

/* renamed from: ir.nasim.eA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC12175eA {
    UNKNOWN(0),
    MCI(1),
    IRANCELL(2),
    RIGHTEL(3),
    IRANCELL_TD_LTE(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC12175eA(int i) {
        this.a = i;
    }

    public static EnumC12175eA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : IRANCELL_TD_LTE : RIGHTEL : IRANCELL : MCI : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
