package ir.nasim;

/* renamed from: ir.nasim.Cv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC3897Cv {
    UNKNOWN(0),
    VITRINE(1),
    SEARCHBAR(2),
    CHANNEL(3),
    DIALOG(4),
    BOT(5),
    MYBANK(6),
    MARKET(7),
    ONBOARDING(8),
    SPONSORED_MESSAGE(9),
    UNDER_PEER(10),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC3897Cv(int i) {
        this.a = i;
    }

    public static EnumC3897Cv p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return VITRINE;
            case 2:
                return SEARCHBAR;
            case 3:
                return CHANNEL;
            case 4:
                return DIALOG;
            case 5:
                return BOT;
            case 6:
                return MYBANK;
            case 7:
                return MARKET;
            case 8:
                return ONBOARDING;
            case 9:
                return SPONSORED_MESSAGE;
            case 10:
                return UNDER_PEER;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
