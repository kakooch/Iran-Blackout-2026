package ir.nasim;

/* renamed from: ir.nasim.Bv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC3663Bv {
    B2C(1),
    B2B(2),
    SUPPORTIVE(3),
    PR(4),
    TEST(5),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC3663Bv(int i) {
        this.a = i;
    }

    public static EnumC3663Bv p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? UNSUPPORTED_VALUE : TEST : PR : SUPPORTIVE : B2B : B2C;
    }

    public int j() {
        return this.a;
    }
}
