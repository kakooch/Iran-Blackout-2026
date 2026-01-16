package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.y93, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class EnumC24167y93 {
    public static final EnumC24167y93 a = new EnumC24167y93("Focused", 0);
    public static final EnumC24167y93 b = new EnumC24167y93("UnfocusedEmpty", 1);
    public static final EnumC24167y93 c = new EnumC24167y93("UnfocusedNotEmpty", 2);
    private static final /* synthetic */ EnumC24167y93[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC24167y93[] enumC24167y93ArrA = a();
        d = enumC24167y93ArrA;
        e = G92.a(enumC24167y93ArrA);
    }

    private EnumC24167y93(String str, int i) {
    }

    private static final /* synthetic */ EnumC24167y93[] a() {
        return new EnumC24167y93[]{a, b, c};
    }

    public static EnumC24167y93 valueOf(String str) {
        return (EnumC24167y93) Enum.valueOf(EnumC24167y93.class, str);
    }

    public static EnumC24167y93[] values() {
        return (EnumC24167y93[]) d.clone();
    }
}
