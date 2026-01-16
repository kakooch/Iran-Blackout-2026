package ir.nasim;

/* renamed from: ir.nasim.nz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18038nz {
    UNKNOWN(0),
    NORMAL(1),
    OUTDATE(2),
    DOUBTFUL(3),
    CURRENT_DATE(4),
    CLEARING(5),
    DEFFERED_CLAIMS(6),
    OUTDATED(7),
    DATE_EXTENSION(8),
    BUYING(9),
    OPEN_NEW_ACCOUNT(10),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18038nz(int i) {
        this.a = i;
    }

    public static EnumC18038nz p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return NORMAL;
            case 2:
                return OUTDATE;
            case 3:
                return DOUBTFUL;
            case 4:
                return CURRENT_DATE;
            case 5:
                return CLEARING;
            case 6:
                return DEFFERED_CLAIMS;
            case 7:
                return OUTDATED;
            case 8:
                return DATE_EXTENSION;
            case 9:
                return BUYING;
            case 10:
                return OPEN_NEW_ACCOUNT;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
