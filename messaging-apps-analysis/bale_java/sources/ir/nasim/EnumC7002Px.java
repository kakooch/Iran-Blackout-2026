package ir.nasim;

/* renamed from: ir.nasim.Px, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC7002Px {
    NOTALLOWED(1),
    ALLOWED(2),
    WAITING(3),
    ACCEPTED(4),
    REJECTED(5),
    NO_AD(6),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC7002Px(int i2) {
        this.a = i2;
    }

    public static EnumC7002Px p(int i2) {
        switch (i2) {
            case 1:
                return NOTALLOWED;
            case 2:
                return ALLOWED;
            case 3:
                return WAITING;
            case 4:
                return ACCEPTED;
            case 5:
                return REJECTED;
            case 6:
                return NO_AD;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
