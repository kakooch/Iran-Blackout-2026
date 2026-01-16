package ir.nasim;

/* renamed from: ir.nasim.tD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC21160tD {
    NOTREGISTERED(1),
    WAITING(2),
    ACCEPTED(3),
    REJECTED(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC21160tD(int i) {
        this.a = i;
    }

    public static EnumC21160tD p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : REJECTED : ACCEPTED : WAITING : NOTREGISTERED;
    }

    public int j() {
        return this.a;
    }
}
