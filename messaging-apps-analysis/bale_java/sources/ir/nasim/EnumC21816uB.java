package ir.nasim;

/* renamed from: ir.nasim.uB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC21816uB {
    PURCHESE(1),
    BILL(2),
    CHARGE(3),
    MONEY_TRANSFER(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC21816uB(int i) {
        this.a = i;
    }

    public static EnumC21816uB p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : MONEY_TRANSFER : CHARGE : BILL : PURCHESE;
    }

    public int j() {
        return this.a;
    }
}
