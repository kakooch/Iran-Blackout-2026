package ir.nasim;

/* renamed from: ir.nasim.ny, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18029ny {
    UNKNOWN(0),
    GROUPS(1),
    CHANNELS(2),
    BOTH(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18029ny(int i) {
        this.a = i;
    }

    public static EnumC18029ny p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : BOTH : CHANNELS : GROUPS : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
