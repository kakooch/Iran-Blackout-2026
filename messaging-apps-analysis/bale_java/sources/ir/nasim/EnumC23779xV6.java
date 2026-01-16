package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.xV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC23779xV6 {
    public static final EnumC23779xV6 a = new EnumC23779xV6("UNKNOWN", 0);
    public static final EnumC23779xV6 b = new EnumC23779xV6("PRIVATE", 1);
    public static final EnumC23779xV6 c = new EnumC23779xV6("GROUP", 2);
    public static final EnumC23779xV6 d = new EnumC23779xV6("CHANNEL", 3);
    public static final EnumC23779xV6 e = new EnumC23779xV6("POPULAR", 4);
    public static final EnumC23779xV6 f = new EnumC23779xV6("BOT", 5);
    private static final /* synthetic */ EnumC23779xV6[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC23779xV6[] enumC23779xV6ArrA = a();
        g = enumC23779xV6ArrA;
        h = G92.a(enumC23779xV6ArrA);
    }

    private EnumC23779xV6(String str, int i) {
    }

    private static final /* synthetic */ EnumC23779xV6[] a() {
        return new EnumC23779xV6[]{a, b, c, d, e, f};
    }

    public static EnumC23779xV6 valueOf(String str) {
        return (EnumC23779xV6) Enum.valueOf(EnumC23779xV6.class, str);
    }

    public static EnumC23779xV6[] values() {
        return (EnumC23779xV6[]) g.clone();
    }
}
