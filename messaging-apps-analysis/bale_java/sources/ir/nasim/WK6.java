package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class WK6 {
    public static final WK6 a = new WK6("UNINITIALIZED", 0);
    public static final WK6 b = new WK6("UNAVAILABLE", 1);
    public static final WK6 c = new WK6("AVAILABLE", 2);
    public static final WK6 d = new WK6("DISCONNECTING", 3);
    public static final WK6 e = new WK6("CONNECTING", 4);
    public static final WK6 f = new WK6("CONNECTED", 5);
    public static final WK6 g = new WK6("PERMISSION_DENIED", 6);
    private static final /* synthetic */ WK6[] h;
    private static final /* synthetic */ F92 i;

    static {
        WK6[] wk6ArrA = a();
        h = wk6ArrA;
        i = G92.a(wk6ArrA);
    }

    private WK6(String str, int i2) {
    }

    private static final /* synthetic */ WK6[] a() {
        return new WK6[]{a, b, c, d, e, f, g};
    }

    public static WK6 valueOf(String str) {
        return (WK6) Enum.valueOf(WK6.class, str);
    }

    public static WK6[] values() {
        return (WK6[]) h.clone();
    }
}
