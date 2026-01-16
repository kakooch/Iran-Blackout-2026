package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Hr5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC5052Hr5 {
    public static final EnumC5052Hr5 a = new EnumC5052Hr5("CONTACTS", 0);
    public static final EnumC5052Hr5 b = new EnumC5052Hr5("EXCLUDE", 1);
    public static final EnumC5052Hr5 c = new EnumC5052Hr5("INCLUDE", 2);
    public static final EnumC5052Hr5 d = new EnumC5052Hr5("UNKNOWN", 3);
    private static final /* synthetic */ EnumC5052Hr5[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC5052Hr5[] enumC5052Hr5ArrA = a();
        e = enumC5052Hr5ArrA;
        f = G92.a(enumC5052Hr5ArrA);
    }

    private EnumC5052Hr5(String str, int i) {
    }

    private static final /* synthetic */ EnumC5052Hr5[] a() {
        return new EnumC5052Hr5[]{a, b, c, d};
    }

    public static EnumC5052Hr5 valueOf(String str) {
        return (EnumC5052Hr5) Enum.valueOf(EnumC5052Hr5.class, str);
    }

    public static EnumC5052Hr5[] values() {
        return (EnumC5052Hr5[]) e.clone();
    }
}
