package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class YF6 {
    public static final YF6 a = new YF6("UNABLE_TO_CHANGE_NAME", 0);
    public static final YF6 b = new YF6("USER_ID_BUSY", 1);
    public static final YF6 c = new YF6("USER_ID_INVALID", 2);
    public static final YF6 d = new YF6("UNABLE_TO_CHANGE_USER_ID", 3);
    private static final /* synthetic */ YF6[] e;
    private static final /* synthetic */ F92 f;

    static {
        YF6[] yf6ArrA = a();
        e = yf6ArrA;
        f = G92.a(yf6ArrA);
    }

    private YF6(String str, int i) {
    }

    private static final /* synthetic */ YF6[] a() {
        return new YF6[]{a, b, c, d};
    }

    public static YF6 valueOf(String str) {
        return (YF6) Enum.valueOf(YF6.class, str);
    }

    public static YF6[] values() {
        return (YF6[]) e.clone();
    }
}
