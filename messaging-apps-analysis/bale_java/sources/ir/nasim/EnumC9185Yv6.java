package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Yv6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC9185Yv6 {
    public static final EnumC9185Yv6 a = new EnumC9185Yv6("ALERT_DIALOG", 0);
    public static final EnumC9185Yv6 b = new EnumC9185Yv6("NAVIGATION", 1);
    public static final EnumC9185Yv6 c = new EnumC9185Yv6("SWITCH", 2);
    public static final EnumC9185Yv6 d = new EnumC9185Yv6("BUTTON", 3);
    public static final EnumC9185Yv6 e = new EnumC9185Yv6("RADIO_GROUP", 4);
    public static final EnumC9185Yv6 f = new EnumC9185Yv6("CHECKBOX_GROUP", 5);
    public static final EnumC9185Yv6 g = new EnumC9185Yv6("DESCRIPTION", 6);
    public static final EnumC9185Yv6 h = new EnumC9185Yv6("SEPARATOR", 7);
    private static final /* synthetic */ EnumC9185Yv6[] i;
    private static final /* synthetic */ F92 j;

    static {
        EnumC9185Yv6[] enumC9185Yv6ArrA = a();
        i = enumC9185Yv6ArrA;
        j = G92.a(enumC9185Yv6ArrA);
    }

    private EnumC9185Yv6(String str, int i2) {
    }

    private static final /* synthetic */ EnumC9185Yv6[] a() {
        return new EnumC9185Yv6[]{a, b, c, d, e, f, g, h};
    }

    public static EnumC9185Yv6 valueOf(String str) {
        return (EnumC9185Yv6) Enum.valueOf(EnumC9185Yv6.class, str);
    }

    public static EnumC9185Yv6[] values() {
        return (EnumC9185Yv6[]) i.clone();
    }
}
