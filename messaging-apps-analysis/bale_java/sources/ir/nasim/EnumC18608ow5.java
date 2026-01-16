package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ow5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC18608ow5 {
    public static final EnumC18608ow5 c = new EnumC18608ow5("GIFT", 0, "properties.gift", true);
    public static final EnumC18608ow5 d = new EnumC18608ow5("THEME", 1, "properties2.ini", false);
    public static final EnumC18608ow5 e = new EnumC18608ow5("PUSH", 2, "push_properties.ini", true);
    public static final EnumC18608ow5 f = new EnumC18608ow5("PFM", 3, "pfm_properties.ini", true);
    public static final EnumC18608ow5 g = new EnumC18608ow5("CARD", 4, "card_properties.ini", true);
    public static final EnumC18608ow5 h = new EnumC18608ow5("GLOBAL_CONFIGS", 5, "force_update", false);
    public static final EnumC18608ow5 i = new EnumC18608ow5("FILES", 6, "files.ini", true);
    public static final EnumC18608ow5 j = new EnumC18608ow5("EMOJI", 7, "emoji.ini", true);
    public static final EnumC18608ow5 k = new EnumC18608ow5("JARYAN", 8, "jaryan.ini", true);
    public static final EnumC18608ow5 l = new EnumC18608ow5("VITRINE", 9, "vitrine.ini", true);
    public static final EnumC18608ow5 m = new EnumC18608ow5("SSL_PINS", 10, "ssl_pins.ini", false);
    public static final EnumC18608ow5 n = new EnumC18608ow5("ENDPOINTS", 11, "endpoints.ini", false);
    public static final EnumC18608ow5 o = new EnumC18608ow5("SHARED_OBJECT", 12, "shared_object.ini", false);
    public static final EnumC18608ow5 p = new EnumC18608ow5("TG_WIDGETS", 13, "tg_widgets.ini", true);
    public static final EnumC18608ow5 q = new EnumC18608ow5("USER_CONFIG", 14, "userconfing", true);
    public static final EnumC18608ow5 r = new EnumC18608ow5("COMMENT_PREF_KEY", 15, "COMMENT", true);
    public static final EnumC18608ow5 s = new EnumC18608ow5("LOCK_PREF_NAME", 16, "lock", false);
    public static final EnumC18608ow5 t = new EnumC18608ow5("MAIN_CONFIG_PREFERENCES_NAME", 17, "mainconfig", true);
    public static final EnumC18608ow5 u = new EnumC18608ow5("DEVICE_SPECIFIC", 18, "device_specific.ini", false);
    public static final EnumC18608ow5 v = new EnumC18608ow5("CRITICAL_KEY", 19, "critical_key", true);
    private static final /* synthetic */ EnumC18608ow5[] w;
    private static final /* synthetic */ F92 x;
    private final String a;
    private final boolean b;

    static {
        EnumC18608ow5[] enumC18608ow5ArrA = a();
        w = enumC18608ow5ArrA;
        x = G92.a(enumC18608ow5ArrA);
    }

    private EnumC18608ow5(String str, int i2, String str2, boolean z) {
        this.a = str2;
        this.b = z;
    }

    private static final /* synthetic */ EnumC18608ow5[] a() {
        return new EnumC18608ow5[]{c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
    }

    public static EnumC18608ow5 valueOf(String str) {
        return (EnumC18608ow5) Enum.valueOf(EnumC18608ow5.class, str);
    }

    public static EnumC18608ow5[] values() {
        return (EnumC18608ow5[]) w.clone();
    }

    public final String getValue() {
        return p(C13923h3.a.m());
    }

    public final String j() {
        return this.a;
    }

    public final String p(int i2) {
        if (!this.b || i2 == 0) {
            return this.a;
        }
        return i2 + "_" + this.a;
    }

    public final boolean q() {
        return this.b;
    }
}
