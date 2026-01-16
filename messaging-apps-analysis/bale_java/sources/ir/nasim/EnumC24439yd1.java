package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yd1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC24439yd1 {
    public static final EnumC24439yd1 a = new EnumC24439yd1("CONNECTING", 0);
    public static final EnumC24439yd1 b = new EnumC24439yd1("CONNECTED", 1);
    public static final EnumC24439yd1 c = new EnumC24439yd1("DISCONNECTED", 2);
    public static final EnumC24439yd1 d = new EnumC24439yd1("RECONNECTING", 3);
    public static final EnumC24439yd1 e = new EnumC24439yd1("RESUMING", 4);
    private static final /* synthetic */ EnumC24439yd1[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC24439yd1[] enumC24439yd1ArrA = a();
        f = enumC24439yd1ArrA;
        g = G92.a(enumC24439yd1ArrA);
    }

    private EnumC24439yd1(String str, int i) {
    }

    private static final /* synthetic */ EnumC24439yd1[] a() {
        return new EnumC24439yd1[]{a, b, c, d, e};
    }

    public static EnumC24439yd1 valueOf(String str) {
        return (EnumC24439yd1) Enum.valueOf(EnumC24439yd1.class, str);
    }

    public static EnumC24439yd1[] values() {
        return (EnumC24439yd1[]) f.clone();
    }
}
