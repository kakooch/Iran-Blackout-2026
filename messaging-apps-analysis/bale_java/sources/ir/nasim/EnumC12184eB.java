package ir.nasim;

/* renamed from: ir.nasim.eB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC12184eB {
    UNKNOWN(0),
    NONE(1),
    SPAM(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC12184eB(int i) {
        this.a = i;
    }

    public static EnumC12184eB p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? UNSUPPORTED_VALUE : SPAM : NONE : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
