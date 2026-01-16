package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class K5 {
    public static final K5 b = new K5("SEEN", 0, 1);
    public static final K5 c = new K5("OPEN", 1, 2);
    public static final K5 d = new K5("JOIN", 2, 3);
    public static final K5 e = new K5("FORWARD", 3, 4);
    public static final K5 f = new K5("REACTION", 4, 5);
    public static final K5 g = new K5("REMOVE_REACTION", 5, 6);
    public static final K5 h = new K5("SAVE", 6, 7);
    public static final K5 i = new K5("SHOW_MORE", 7, 8);
    public static final K5 j = new K5("UPVOTERS", 8, 9);
    public static final K5 k = new K5("REPORT", 9, 10);
    public static final K5 l = new K5("FULLSCREEN", 10, 11);
    public static final K5 m = new K5("ADD_TO_STORY", 11, 12);
    public static final K5 n = new K5("OPEN_COMMENT", 12, 15);
    private static final /* synthetic */ K5[] o;
    private static final /* synthetic */ F92 p;
    private final int a;

    static {
        K5[] k5ArrA = a();
        o = k5ArrA;
        p = G92.a(k5ArrA);
    }

    private K5(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ K5[] a() {
        return new K5[]{b, c, d, e, f, g, h, i, j, k, l, m, n};
    }

    public static K5 valueOf(String str) {
        return (K5) Enum.valueOf(K5.class, str);
    }

    public static K5[] values() {
        return (K5[]) o.clone();
    }

    public final int j() {
        return this.a;
    }
}
