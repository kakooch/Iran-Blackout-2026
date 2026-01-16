package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Yp2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC9127Yp2 {
    public static final EnumC9127Yp2 a = new EnumC9127Yp2("HAFEZ", 0);
    public static final EnumC9127Yp2 b = new EnumC9127Yp2("GIFT", 1);
    public static final EnumC9127Yp2 c = new EnumC9127Yp2("HEDIE", 2);
    public static final EnumC9127Yp2 d = new EnumC9127Yp2("HEDIE_WITH_OUT_TEXT", 3);
    private static final /* synthetic */ EnumC9127Yp2[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC9127Yp2[] enumC9127Yp2ArrA = a();
        e = enumC9127Yp2ArrA;
        f = G92.a(enumC9127Yp2ArrA);
    }

    private EnumC9127Yp2(String str, int i) {
    }

    private static final /* synthetic */ EnumC9127Yp2[] a() {
        return new EnumC9127Yp2[]{a, b, c, d};
    }

    public static EnumC9127Yp2 valueOf(String str) {
        return (EnumC9127Yp2) Enum.valueOf(EnumC9127Yp2.class, str);
    }

    public static EnumC9127Yp2[] values() {
        return (EnumC9127Yp2[]) e.clone();
    }
}
