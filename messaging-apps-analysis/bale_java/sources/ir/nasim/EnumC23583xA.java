package ir.nasim;

/* renamed from: ir.nasim.xA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC23583xA {
    INFORMAL(1),
    VERIFIED(2),
    LEGAL(3),
    TOP_USER(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC23583xA(int i) {
        this.a = i;
    }

    public static EnumC23583xA p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : TOP_USER : LEGAL : VERIFIED : INFORMAL;
    }

    public int j() {
        return this.a;
    }
}
