package ir.nasim;

/* renamed from: ir.nasim.Ny, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC6538Ny {
    DAILY(1),
    WEEKLY(2),
    MONTHLY(3),
    TRIMESTER(4),
    SEMIANNUAL(5),
    ANNUAL(6),
    OTHERS(7),
    THREEDAYS(8),
    FIFTEENDAYS(9),
    REASON(10),
    TWOMONTH(11),
    FOURMONTH(12),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC6538Ny(int i) {
        this.a = i;
    }

    public static EnumC6538Ny p(int i) {
        switch (i) {
            case 1:
                return DAILY;
            case 2:
                return WEEKLY;
            case 3:
                return MONTHLY;
            case 4:
                return TRIMESTER;
            case 5:
                return SEMIANNUAL;
            case 6:
                return ANNUAL;
            case 7:
                return OTHERS;
            case 8:
                return THREEDAYS;
            case 9:
                return FIFTEENDAYS;
            case 10:
                return REASON;
            case 11:
                return TWOMONTH;
            case 12:
                return FOURMONTH;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
