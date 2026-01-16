package ir.nasim;

/* renamed from: ir.nasim.vx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC22865vx {
    UNKNOWN(0),
    GENERIC(1),
    PC(2),
    MOBILE(3),
    TABLET(4),
    WATCH(5),
    MIRROR(6),
    CAR(7),
    TABLE(8),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC22865vx(int i) {
        this.a = i;
    }

    public static EnumC22865vx p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return GENERIC;
            case 2:
                return PC;
            case 3:
                return MOBILE;
            case 4:
                return TABLET;
            case 5:
                return WATCH;
            case 6:
                return MIRROR;
            case 7:
                return CAR;
            case 8:
                return TABLE;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
