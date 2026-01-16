package ir.nasim;

/* renamed from: ir.nasim.qy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC19802qy {
    SAME(1),
    RANDOM(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC19802qy(int i) {
        this.a = i;
    }

    public static EnumC19802qy p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : RANDOM : SAME;
    }

    public int j() {
        return this.a;
    }
}
