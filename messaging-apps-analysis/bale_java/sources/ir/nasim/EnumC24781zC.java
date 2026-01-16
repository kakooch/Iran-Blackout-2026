package ir.nasim;

/* renamed from: ir.nasim.zC, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC24781zC {
    UNKNOWN(0),
    MALE(1),
    FEMALE(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC24781zC(int i) {
        this.a = i;
    }

    public static EnumC24781zC p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? UNSUPPORTED_VALUE : FEMALE : MALE : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
