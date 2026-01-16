package ir.nasim;

/* renamed from: ir.nasim.Fv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC4599Fv {
    NONE(1),
    BANNER(2),
    NATIVE(3),
    BANNER_AND_NATIVE(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC4599Fv(int i) {
        this.a = i;
    }

    public static EnumC4599Fv p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : BANNER_AND_NATIVE : NATIVE : BANNER : NONE;
    }

    public int j() {
        return this.a;
    }
}
