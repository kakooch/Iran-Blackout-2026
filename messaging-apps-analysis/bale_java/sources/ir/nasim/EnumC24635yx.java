package ir.nasim;

/* renamed from: ir.nasim.yx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC24635yx {
    UNKNOWN(0),
    AWAITINGCONTENTAPPROVAL(1),
    AWAITINGPAYMENT(2),
    AWAITINGTOSHOW(3),
    ACTIVE(4),
    FINISHED(5),
    REJECTCONTENT(6),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC24635yx(int i) {
        this.a = i;
    }

    public static EnumC24635yx p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return AWAITINGCONTENTAPPROVAL;
            case 2:
                return AWAITINGPAYMENT;
            case 3:
                return AWAITINGTOSHOW;
            case 4:
                return ACTIVE;
            case 5:
                return FINISHED;
            case 6:
                return REJECTCONTENT;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
