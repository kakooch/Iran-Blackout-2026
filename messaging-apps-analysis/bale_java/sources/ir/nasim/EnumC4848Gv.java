package ir.nasim;

/* renamed from: ir.nasim.Gv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC4848Gv {
    ACTIVE(1),
    INACTIVE(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC4848Gv(int i) {
        this.a = i;
    }

    public static EnumC4848Gv p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : INACTIVE : ACTIVE;
    }

    public int j() {
        return this.a;
    }
}
