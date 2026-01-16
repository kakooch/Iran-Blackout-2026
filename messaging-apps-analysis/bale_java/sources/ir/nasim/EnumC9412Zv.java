package ir.nasim;

/* renamed from: ir.nasim.Zv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC9412Zv {
    UNKNOWN(0),
    SCAM(1),
    IMMORAL(2),
    SPAM(3),
    DISINFORMATION(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC9412Zv(int i) {
        this.a = i;
    }

    public static EnumC9412Zv p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : DISINFORMATION : SPAM : IMMORAL : SCAM : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
