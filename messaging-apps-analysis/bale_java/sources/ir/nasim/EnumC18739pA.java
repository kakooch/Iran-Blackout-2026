package ir.nasim;

/* renamed from: ir.nasim.pA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18739pA {
    UNKNOWN(0),
    FIRST_TRANSACTION(1),
    ENTER_TOWN(2),
    TREASURE(3),
    REFERALL(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18739pA(int i) {
        this.a = i;
    }

    public static EnumC18739pA p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : REFERALL : TREASURE : ENTER_TOWN : FIRST_TRANSACTION : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
