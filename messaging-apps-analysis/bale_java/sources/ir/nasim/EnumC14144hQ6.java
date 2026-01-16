package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.hQ6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC14144hQ6 {
    public static final EnumC14144hQ6 a = new EnumC14144hQ6("PHOTO", 0);
    public static final EnumC14144hQ6 b = new EnumC14144hQ6("VIDEO", 1);
    public static final EnumC14144hQ6 c = new EnumC14144hQ6("TEXT", 2);
    public static final EnumC14144hQ6 d = new EnumC14144hQ6("UNRECOGNIZED", 3);
    private static final /* synthetic */ EnumC14144hQ6[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC14144hQ6[] enumC14144hQ6ArrA = a();
        e = enumC14144hQ6ArrA;
        f = G92.a(enumC14144hQ6ArrA);
    }

    private EnumC14144hQ6(String str, int i) {
    }

    private static final /* synthetic */ EnumC14144hQ6[] a() {
        return new EnumC14144hQ6[]{a, b, c, d};
    }

    public static EnumC14144hQ6 valueOf(String str) {
        return (EnumC14144hQ6) Enum.valueOf(EnumC14144hQ6.class, str);
    }

    public static EnumC14144hQ6[] values() {
        return (EnumC14144hQ6[]) e.clone();
    }
}
