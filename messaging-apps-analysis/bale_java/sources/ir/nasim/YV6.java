package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class YV6 {
    public static final YV6 b = new YV6("CLICK", 0, "click");
    public static final YV6 c = new YV6("OPEN", 1, "open");
    public static final YV6 d = new YV6("VIEW", 2, "view");
    public static final YV6 e = new YV6("REACTION", 3, "reaction");
    public static final YV6 f = new YV6("REPLY", 4, "reply");
    public static final YV6 g = new YV6("JOIN", 5, "join");
    public static final YV6 h = new YV6("PROFILE_VIEW", 6, "profile_view");
    public static final YV6 i = new YV6("PRE_LOAD", 7, "pre_load");
    public static final YV6 j = new YV6("DOWNLOAD", 8, "download");
    private static final /* synthetic */ YV6[] k;
    private static final /* synthetic */ F92 l;
    private final String a;

    static {
        YV6[] yv6ArrA = a();
        k = yv6ArrA;
        l = G92.a(yv6ArrA);
    }

    private YV6(String str, int i2, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ YV6[] a() {
        return new YV6[]{b, c, d, e, f, g, h, i, j};
    }

    public static YV6 valueOf(String str) {
        return (YV6) Enum.valueOf(YV6.class, str);
    }

    public static YV6[] values() {
        return (YV6[]) k.clone();
    }

    public final String j() {
        return this.a;
    }
}
