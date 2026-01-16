package ir.nasim;

/* renamed from: ir.nasim.my, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC17438my {
    UNKNOWN(0),
    MAN(1),
    WOMAN(2),
    OTHERS(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC17438my(int i) {
        this.a = i;
    }

    public static EnumC17438my p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : OTHERS : WOMAN : MAN : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
