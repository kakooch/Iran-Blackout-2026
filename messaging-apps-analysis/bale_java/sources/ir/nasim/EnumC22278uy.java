package ir.nasim;

/* renamed from: ir.nasim.uy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC22278uy {
    UNKNOWN(0),
    PRIZE_ASC(1),
    DATE_ASC(2),
    PRIZE_DESC(3),
    DATE_DESC(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC22278uy(int i) {
        this.a = i;
    }

    public static EnumC22278uy p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : DATE_DESC : PRIZE_DESC : DATE_ASC : PRIZE_ASC : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
