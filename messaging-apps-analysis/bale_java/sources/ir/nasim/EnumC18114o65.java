package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.o65, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC18114o65 {
    public static final EnumC18114o65 a = new EnumC18114o65("UNKNOWN", 0);
    public static final EnumC18114o65 b = new EnumC18114o65("ANSWERED", 1);
    public static final EnumC18114o65 c = new EnumC18114o65("MISSED", 2);
    public static final EnumC18114o65 d = new EnumC18114o65("REJECTED", 3);
    public static final EnumC18114o65 e = new EnumC18114o65("BUSY", 4);
    public static final EnumC18114o65 f = new EnumC18114o65("DISCONNECTED", 5);
    private static final /* synthetic */ EnumC18114o65[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC18114o65[] enumC18114o65ArrA = a();
        g = enumC18114o65ArrA;
        h = G92.a(enumC18114o65ArrA);
    }

    private EnumC18114o65(String str, int i) {
    }

    private static final /* synthetic */ EnumC18114o65[] a() {
        return new EnumC18114o65[]{a, b, c, d, e, f};
    }

    public static EnumC18114o65 valueOf(String str) {
        return (EnumC18114o65) Enum.valueOf(EnumC18114o65.class, str);
    }

    public static EnumC18114o65[] values() {
        return (EnumC18114o65[]) g.clone();
    }
}
