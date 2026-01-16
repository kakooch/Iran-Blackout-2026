package ir.nasim;

/* renamed from: ir.nasim.Mv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC6251Mv {
    UNKNOWN(0),
    DEFAULT(1),
    BALEONLY(2),
    SMS(3),
    CALL(4),
    EMAIL(5),
    MISSCALL(6),
    SETUP_EMAIL_REQUIRED(7),
    WHATSAPP(8),
    TELEGRAM(9),
    USSD(10),
    FUTURE_AUTH_TOKEN(11),
    TELEGRAM_GATEWAY(12),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC6251Mv(int i) {
        this.a = i;
    }

    public static EnumC6251Mv p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return DEFAULT;
            case 2:
                return BALEONLY;
            case 3:
                return SMS;
            case 4:
                return CALL;
            case 5:
                return EMAIL;
            case 6:
                return MISSCALL;
            case 7:
                return SETUP_EMAIL_REQUIRED;
            case 8:
                return WHATSAPP;
            case 9:
                return TELEGRAM;
            case 10:
                return USSD;
            case 11:
                return FUTURE_AUTH_TOKEN;
            case 12:
                return TELEGRAM_GATEWAY;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
