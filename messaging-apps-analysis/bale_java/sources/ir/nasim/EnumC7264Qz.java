package ir.nasim;

/* renamed from: ir.nasim.Qz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC7264Qz {
    NORMAL(1),
    BILL(2),
    PAYMENT(3),
    MELLI_LOAN(4),
    WALLET(5),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC7264Qz(int i) {
        this.a = i;
    }

    public static EnumC7264Qz p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? UNSUPPORTED_VALUE : WALLET : MELLI_LOAN : PAYMENT : BILL : NORMAL;
    }

    public int j() {
        return this.a;
    }
}
