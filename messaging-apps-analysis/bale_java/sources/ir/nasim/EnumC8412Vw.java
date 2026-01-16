package ir.nasim;

/* renamed from: ir.nasim.Vw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC8412Vw {
    RED(1),
    YELLOW(2),
    GREEN(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC8412Vw(int i) {
        this.a = i;
    }

    public static EnumC8412Vw p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : GREEN : YELLOW : RED;
    }

    public int j() {
        return this.a;
    }
}
