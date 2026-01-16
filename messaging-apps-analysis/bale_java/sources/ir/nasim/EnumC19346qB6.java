package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.qB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC19346qB6 {
    public static final EnumC19346qB6 a = new EnumC19346qB6("BASIC", 0);
    public static final EnumC19346qB6 b = new EnumC19346qB6("DARK_MODE", 1);
    public static final EnumC19346qB6 c = new EnumC19346qB6("RTL", 2);
    public static final EnumC19346qB6 d = new EnumC19346qB6("FONT_SCALE", 3);
    public static final EnumC19346qB6 e = new EnumC19346qB6("DISPLAY_SCALED", 4);
    private static final /* synthetic */ EnumC19346qB6[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC19346qB6[] enumC19346qB6ArrA = a();
        f = enumC19346qB6ArrA;
        g = G92.a(enumC19346qB6ArrA);
    }

    private EnumC19346qB6(String str, int i) {
    }

    private static final /* synthetic */ EnumC19346qB6[] a() {
        return new EnumC19346qB6[]{a, b, c, d, e};
    }

    public static EnumC19346qB6 valueOf(String str) {
        return (EnumC19346qB6) Enum.valueOf(EnumC19346qB6.class, str);
    }

    public static EnumC19346qB6[] values() {
        return (EnumC19346qB6[]) f.clone();
    }
}
