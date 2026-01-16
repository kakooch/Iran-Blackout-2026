package ir.nasim;

/* renamed from: ir.nasim.Oz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC6786Oz {
    MINE(1),
    OTHERS(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC6786Oz(int i) {
        this.a = i;
    }

    public static EnumC6786Oz p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : OTHERS : MINE;
    }

    public int j() {
        return this.a;
    }
}
