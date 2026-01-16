package ir.nasim;

/* renamed from: ir.nasim.By, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC3690By {
    GROUP(1),
    CHANNEL(2),
    SUPER_GROUP(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC3690By(int i) {
        this.a = i;
    }

    public static EnumC3690By p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : SUPER_GROUP : CHANNEL : GROUP;
    }

    public int j() {
        return this.a;
    }
}
