package ir.nasim;

/* renamed from: ir.nasim.Jv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC5550Jv {
    ALL(1),
    TRUE(2),
    FALSE(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC5550Jv(int i) {
        this.a = i;
    }

    public static EnumC5550Jv p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : FALSE : TRUE : ALL;
    }

    public int j() {
        return this.a;
    }
}
