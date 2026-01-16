package ir.nasim;

/* renamed from: ir.nasim.Tz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC7971Tz {
    AMOUNT(1),
    PERCENTAGE(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC7971Tz(int i) {
        this.a = i;
    }

    public static EnumC7971Tz p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : PERCENTAGE : AMOUNT;
    }

    public int j() {
        return this.a;
    }
}
