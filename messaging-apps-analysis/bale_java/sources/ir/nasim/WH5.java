package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class WH5 {
    public static final WH5 b = new WH5("LIKE", 0, 1);
    public static final WH5 c = new WH5("LONG_TOUCH", 1, 2);
    public static final WH5 d = new WH5("DOUBLE_TAP", 2, 3);
    private static final /* synthetic */ WH5[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        WH5[] wh5ArrA = a();
        e = wh5ArrA;
        f = G92.a(wh5ArrA);
    }

    private WH5(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ WH5[] a() {
        return new WH5[]{b, c, d};
    }

    public static WH5 valueOf(String str) {
        return (WH5) Enum.valueOf(WH5.class, str);
    }

    public static WH5[] values() {
        return (WH5[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
