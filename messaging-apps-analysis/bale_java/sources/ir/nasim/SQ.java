package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class SQ {
    public static final SQ a = new SQ("UNKNOWN", 0);
    public static final SQ b = new SQ("DEFAULT", 1);
    public static final SQ c = new SQ("BALEONLY", 2);
    public static final SQ d = new SQ("SMS", 3);
    public static final SQ e = new SQ("CALL", 4);
    public static final SQ f = new SQ("EMAIL", 5);
    public static final SQ g = new SQ("MISSCALL", 6);
    public static final SQ h = new SQ("SETUP_EMAIL_REQUIRED", 7);
    public static final SQ i = new SQ("WHATSAPP", 8);
    public static final SQ j = new SQ("TELEGRAM", 9);
    public static final SQ k = new SQ("FUTURE_AUTH_TOKEN", 10);
    public static final SQ l = new SQ("USSD", 11);
    public static final SQ m = new SQ("TELEGRAM_GATEWAY", 12);
    private static final /* synthetic */ SQ[] n;
    private static final /* synthetic */ F92 o;

    static {
        SQ[] sqArrA = a();
        n = sqArrA;
        o = G92.a(sqArrA);
    }

    private SQ(String str, int i2) {
    }

    private static final /* synthetic */ SQ[] a() {
        return new SQ[]{a, b, c, d, e, f, g, h, i, j, k, l, m};
    }

    public static SQ valueOf(String str) {
        return (SQ) Enum.valueOf(SQ.class, str);
    }

    public static SQ[] values() {
        return (SQ[]) n.clone();
    }
}
