package ir.nasim;

/* renamed from: ir.nasim.hB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC14002hB {
    UNKNOWN(0),
    BALE(1),
    IGAP(2),
    GAP(3),
    EITTA(4),
    RUBIKA(5),
    SPLUS(6),
    M7(7),
    M8(8),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC14002hB(int i) {
        this.a = i;
    }

    public static EnumC14002hB p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return BALE;
            case 2:
                return IGAP;
            case 3:
                return GAP;
            case 4:
                return EITTA;
            case 5:
                return RUBIKA;
            case 6:
                return SPLUS;
            case 7:
                return M7;
            case 8:
                return M8;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
