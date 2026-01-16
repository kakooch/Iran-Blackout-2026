package ir.nasim;

/* renamed from: ir.nasim.Vz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC8439Vz {
    UNKNOWN(0),
    URL(1),
    PEER(2),
    CARD2CARD(3),
    CARD_BALANCE(4),
    BILL(5),
    CHARGE(6),
    PFM(7),
    USSD(8),
    INVOICE(9),
    INTENT_URL(10),
    MENU(11),
    MONEY_REQUEST(12),
    CROWDFUNDING(13),
    GIFT_PACKET(14),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC8439Vz(int i) {
        this.a = i;
    }

    public static EnumC8439Vz j(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return URL;
            case 2:
                return PEER;
            case 3:
                return CARD2CARD;
            case 4:
                return CARD_BALANCE;
            case 5:
                return BILL;
            case 6:
                return CHARGE;
            case 7:
                return PFM;
            case 8:
                return USSD;
            case 9:
                return INVOICE;
            case 10:
                return INTENT_URL;
            case 11:
                return MENU;
            case 12:
                return MONEY_REQUEST;
            case 13:
                return CROWDFUNDING;
            case 14:
                return GIFT_PACKET;
            default:
                return UNSUPPORTED_VALUE;
        }
    }
}
