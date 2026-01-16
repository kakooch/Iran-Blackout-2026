package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.n65, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC17523n65 {
    public static final EnumC17523n65 a = new EnumC17523n65("UNKNOWN", 0);
    public static final EnumC17523n65 b = new EnumC17523n65("ANSWERED", 1);
    public static final EnumC17523n65 c = new EnumC17523n65("MISSED", 2);
    public static final EnumC17523n65 d = new EnumC17523n65("REJECTED", 3);
    public static final EnumC17523n65 e = new EnumC17523n65("BUSY", 4);
    public static final EnumC17523n65 f = new EnumC17523n65("DISCONNECTED", 5);
    private static final /* synthetic */ EnumC17523n65[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC17523n65[] enumC17523n65ArrA = a();
        g = enumC17523n65ArrA;
        h = G92.a(enumC17523n65ArrA);
    }

    private EnumC17523n65(String str, int i) {
    }

    private static final /* synthetic */ EnumC17523n65[] a() {
        return new EnumC17523n65[]{a, b, c, d, e, f};
    }

    public static EnumC17523n65 valueOf(String str) {
        return (EnumC17523n65) Enum.valueOf(EnumC17523n65.class, str);
    }

    public static EnumC17523n65[] values() {
        return (EnumC17523n65[]) g.clone();
    }
}
