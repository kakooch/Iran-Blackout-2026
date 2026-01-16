package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class H48 {
    public static final H48 b = new H48("MAIN_MENU", 0, 1);
    public static final H48 c = new H48("PROFILE_BUTTON", 1, 2);
    public static final H48 d = new H48("DIALOG_BUTTON", 2, 3);
    public static final H48 e = new H48("DEEP_LINK", 3, 4);
    public static final H48 f = new H48("INLINE_BUTTON", 4, 5);
    public static final H48 g = new H48("REPLAY_MARKUP", 5, 6);
    public static final H48 h = new H48("SHORTCUT", 6, 7);
    public static final H48 i = new H48("SEARCH_BUTTON", 7, 8);
    public static final H48 j = new H48("MINIMIZE_WEB_APP", 8, 9);
    public static final H48 k = new H48("MAXIMIZE_WEB_APP", 9, 10);
    public static final H48 l = new H48("CLOSE_MINIMIZER", 10, 11);
    private static final /* synthetic */ H48[] m;
    private static final /* synthetic */ F92 n;
    private final int a;

    static {
        H48[] h48ArrA = a();
        m = h48ArrA;
        n = G92.a(h48ArrA);
    }

    private H48(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ H48[] a() {
        return new H48[]{b, c, d, e, f, g, h, i, j, k, l};
    }

    public static H48 valueOf(String str) {
        return (H48) Enum.valueOf(H48.class, str);
    }

    public static H48[] values() {
        return (H48[]) m.clone();
    }

    public final int j() {
        return this.a;
    }
}
