package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class RE {
    public static final RE a = new RE("NORMAL", 0);
    public static final RE b = new RE("NOWRUZ", 1);
    public static final RE c = new RE("MUHARRAM", 2);
    public static final RE d = new RE("YALDA", 3);
    public static final RE e = new RE("NIME_SHABAN", 4);
    public static final RE f = new RE("WORLD_CUP", 5);
    public static final RE g = new RE("BOOK_FAIR", 6);
    public static final RE h = new RE("IMAMREZA", 7);
    public static final RE i = new RE("CHARSHANBE_SOURI", 8);
    public static final RE j = new RE("IRAN_FLAG_THEME", 9);
    public static final RE k = new RE("RAMADAN", 10);
    public static final RE l = new RE("BAHMAN22", 11);
    public static final RE m = new RE("GHADR", 12);
    public static final RE n = new RE("GHADIR", 13);
    public static final RE o = new RE("GHORBAN", 14);
    public static final RE p = new RE("GIRL_DAY", 15);
    public static final RE q = new RE("FERDOWSI", 16);
    public static final RE r = new RE("HELAL_AHMAR", 17);
    public static final RE s = new RE("MOALLEM", 18);
    public static final RE t = new RE("RELIGION_BIRTHS", 19);
    public static final RE u = new RE("IMAM_HOSEIN", 20);
    private static final /* synthetic */ RE[] v;
    private static final /* synthetic */ F92 w;

    static {
        RE[] reArrA = a();
        v = reArrA;
        w = G92.a(reArrA);
    }

    private RE(String str, int i2) {
    }

    private static final /* synthetic */ RE[] a() {
        return new RE[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u};
    }

    public static RE valueOf(String str) {
        return (RE) Enum.valueOf(RE.class, str);
    }

    public static RE[] values() {
        return (RE[]) v.clone();
    }
}
