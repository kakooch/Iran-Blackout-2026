package ir.nasim;

/* renamed from: ir.nasim.Nw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC6520Nw {
    NULL(1),
    GIFTPACKET(2),
    PUCHASEMESSAGE(3),
    CHARGE(4),
    ADSPOTPUCHASE(5),
    CRYPTO(6),
    PURCHASE(7),
    BOTPAYMENT(8),
    BOTWALLETPAYMENT(9),
    BOTGOLDPAYMENT(10),
    PREMIUMPAYMENT(11),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC6520Nw(int i) {
        this.a = i;
    }

    public static EnumC6520Nw p(int i) {
        switch (i) {
            case 1:
                return NULL;
            case 2:
                return GIFTPACKET;
            case 3:
                return PUCHASEMESSAGE;
            case 4:
                return CHARGE;
            case 5:
                return ADSPOTPUCHASE;
            case 6:
                return CRYPTO;
            case 7:
                return PURCHASE;
            case 8:
                return BOTPAYMENT;
            case 9:
                return BOTWALLETPAYMENT;
            case 10:
                return BOTGOLDPAYMENT;
            case 11:
                return PREMIUMPAYMENT;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
