package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.vB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC22413vB6 {
    public static final EnumC22413vB6 a = new EnumC22413vB6("COMPONENT_GROUPS", 0);
    public static final EnumC22413vB6 b = new EnumC22413vB6("COMPONENTS_IN_A_GROUP", 1);
    public static final EnumC22413vB6 c = new EnumC22413vB6("COMPONENT_STYLES", 2);
    public static final EnumC22413vB6 d = new EnumC22413vB6("COMPONENT_DETAIL", 3);
    public static final EnumC22413vB6 e = new EnumC22413vB6("SHOWKASE_CATEGORIES", 4);
    public static final EnumC22413vB6 f = new EnumC22413vB6("COLOR_GROUPS", 5);
    public static final EnumC22413vB6 g = new EnumC22413vB6("COLORS_IN_A_GROUP", 6);
    public static final EnumC22413vB6 h = new EnumC22413vB6("TYPOGRAPHY_GROUPS", 7);
    public static final EnumC22413vB6 i = new EnumC22413vB6("TYPOGRAPHY_IN_A_GROUP", 8);
    private static final /* synthetic */ EnumC22413vB6[] j;
    private static final /* synthetic */ F92 k;

    static {
        EnumC22413vB6[] enumC22413vB6ArrA = a();
        j = enumC22413vB6ArrA;
        k = G92.a(enumC22413vB6ArrA);
    }

    private EnumC22413vB6(String str, int i2) {
    }

    private static final /* synthetic */ EnumC22413vB6[] a() {
        return new EnumC22413vB6[]{a, b, c, d, e, f, g, h, i};
    }

    public static EnumC22413vB6 valueOf(String str) {
        return (EnumC22413vB6) Enum.valueOf(EnumC22413vB6.class, str);
    }

    public static EnumC22413vB6[] values() {
        return (EnumC22413vB6[]) j.clone();
    }
}
