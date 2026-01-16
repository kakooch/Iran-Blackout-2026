package ir.nasim;

/* renamed from: ir.nasim.dA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC11532dA {
    UNKNOWN(0),
    MCI(1),
    IRANCELL(2),
    RIGHTEL(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC11532dA(int i) {
        this.a = i;
    }

    public static EnumC11532dA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : RIGHTEL : IRANCELL : MCI : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
