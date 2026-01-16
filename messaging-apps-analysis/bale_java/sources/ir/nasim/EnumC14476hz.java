package ir.nasim;

/* renamed from: ir.nasim.hz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC14476hz {
    OPENGRAPH(1),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC14476hz(int i) {
        this.a = i;
    }

    public static EnumC14476hz p(int i) {
        return i != 1 ? UNSUPPORTED_VALUE : OPENGRAPH;
    }

    public int j() {
        return this.a;
    }
}
