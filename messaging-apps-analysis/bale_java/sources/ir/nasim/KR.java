package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class KR {
    public static final KR b = new KR("WALLET", 0, 1);
    public static final KR c = new KR("BOT_MESSAGE", 1, 2);
    public static final KR d = new KR("WEB_APP", 2, 3);
    public static final KR e = new KR("INLINE_BUTTON", 3, 4);
    private static final /* synthetic */ KR[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        KR[] krArrA = a();
        f = krArrA;
        g = G92.a(krArrA);
    }

    private KR(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ KR[] a() {
        return new KR[]{b, c, d, e};
    }

    public static KR valueOf(String str) {
        return (KR) Enum.valueOf(KR.class, str);
    }

    public static KR[] values() {
        return (KR[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
