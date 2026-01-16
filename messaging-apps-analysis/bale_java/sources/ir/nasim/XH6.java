package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class XH6 {
    public static final XH6 a = new XH6("MENU", 0);
    public static final XH6 b = new XH6("HOLDER", 1);
    public static final XH6 c = new XH6("BUTTON", 2);
    public static final XH6 d = new XH6("MODAL", 3);
    private static final /* synthetic */ XH6[] e;
    private static final /* synthetic */ F92 f;

    static {
        XH6[] xh6ArrA = a();
        e = xh6ArrA;
        f = G92.a(xh6ArrA);
    }

    private XH6(String str, int i) {
    }

    private static final /* synthetic */ XH6[] a() {
        return new XH6[]{a, b, c, d};
    }

    public static XH6 valueOf(String str) {
        return (XH6) Enum.valueOf(XH6.class, str);
    }

    public static XH6[] values() {
        return (XH6[]) e.clone();
    }
}
