package ir.nasim;

/* renamed from: ir.nasim.iz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC15083iz {
    UNKNOWN(0),
    FORWARD(1),
    BACKWARD(2),
    BOTH(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC15083iz(int i) {
        this.a = i;
    }

    public static EnumC15083iz p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : BOTH : BACKWARD : FORWARD : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
