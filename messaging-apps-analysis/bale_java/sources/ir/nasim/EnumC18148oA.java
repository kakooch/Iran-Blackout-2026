package ir.nasim;

/* renamed from: ir.nasim.oA, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18148oA {
    UNKNOWN(0),
    HIDDEN(1),
    LOCKED(2),
    INPROGRESS(3),
    COMPLETED(4),
    RECEIVED(5),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18148oA(int i2) {
        this.a = i2;
    }

    public static EnumC18148oA p(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? UNSUPPORTED_VALUE : RECEIVED : COMPLETED : INPROGRESS : LOCKED : HIDDEN : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
