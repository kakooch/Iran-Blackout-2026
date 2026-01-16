package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class WV6 {
    public static final WV6 b = new WV6("GOFTOGOO", 0, 1);
    public static final WV6 c = new WV6("JARYAN", 1, 2);
    private static final /* synthetic */ WV6[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        WV6[] wv6ArrA = a();
        d = wv6ArrA;
        e = G92.a(wv6ArrA);
    }

    private WV6(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ WV6[] a() {
        return new WV6[]{b, c};
    }

    public static WV6 valueOf(String str) {
        return (WV6) Enum.valueOf(WV6.class, str);
    }

    public static WV6[] values() {
        return (WV6[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
