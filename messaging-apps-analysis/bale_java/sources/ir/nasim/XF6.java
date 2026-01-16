package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class XF6 {
    public static final XF6 a = new XF6("SUCCESS_CHANGE_DEFAULT_TAB", 0);
    private static final /* synthetic */ XF6[] b;
    private static final /* synthetic */ F92 c;

    static {
        XF6[] xf6ArrA = a();
        b = xf6ArrA;
        c = G92.a(xf6ArrA);
    }

    private XF6(String str, int i) {
    }

    private static final /* synthetic */ XF6[] a() {
        return new XF6[]{a};
    }

    public static XF6 valueOf(String str) {
        return (XF6) Enum.valueOf(XF6.class, str);
    }

    public static XF6[] values() {
        return (XF6[]) b.clone();
    }
}
