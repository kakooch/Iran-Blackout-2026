package ir.nasim;

/* renamed from: ir.nasim.ow, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18602ow {
    UNKNOWN(0),
    WATER(1),
    POWER(2),
    GAS(3),
    PHONE(4),
    HAMRAHEAVAL(5),
    RIGHTEL(11),
    IRANCELL(12),
    TRAFFICFINE(13),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18602ow(int i) {
        this.a = i;
    }

    public static EnumC18602ow p(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return WATER;
        }
        if (i == 2) {
            return POWER;
        }
        if (i == 3) {
            return GAS;
        }
        if (i == 4) {
            return PHONE;
        }
        if (i == 5) {
            return HAMRAHEAVAL;
        }
        switch (i) {
            case 11:
                return RIGHTEL;
            case 12:
                return IRANCELL;
            case 13:
                return TRAFFICFINE;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
