package ir.nasim;

/* renamed from: ir.nasim.x74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC23558x74 {
    PENDING(1),
    SENT(2),
    ERROR(5),
    UNKNOWN(6),
    LIMIT_EXCEEDED(7);

    int a;

    EnumC23558x74(int i) {
        this.a = i;
    }

    public static EnumC23558x74 j(int i) {
        return i != 1 ? (i == 2 || i == 3 || i == 4) ? SENT : i != 5 ? i != 7 ? UNKNOWN : LIMIT_EXCEEDED : ERROR : PENDING;
    }
}
