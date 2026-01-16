package ir.nasim;

/* renamed from: ir.nasim.ez, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC12656ez {
    INACTIVE(1),
    ACTIVE(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC12656ez(int i) {
        this.a = i;
    }

    public static EnumC12656ez p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : ACTIVE : INACTIVE;
    }

    public int j() {
        return this.a;
    }
}
