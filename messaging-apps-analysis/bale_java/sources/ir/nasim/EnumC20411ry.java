package ir.nasim;

/* renamed from: ir.nasim.ry, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC20411ry {
    ALREADY_RECEIVED(1),
    SOLD_OUT(2),
    GIFT_CREATOR(3),
    SUCCESSFUL(4),
    PENDING(5),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC20411ry(int i) {
        this.a = i;
    }

    public static EnumC20411ry p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? UNSUPPORTED_VALUE : PENDING : SUCCESSFUL : GIFT_CREATOR : SOLD_OUT : ALREADY_RECEIVED;
    }

    public int j() {
        return this.a;
    }
}
