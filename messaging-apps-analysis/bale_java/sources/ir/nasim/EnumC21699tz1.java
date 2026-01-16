package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.tz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC21699tz1 {
    public static final EnumC21699tz1 a = new EnumC21699tz1("MEMORY_CACHE", 0);
    public static final EnumC21699tz1 b = new EnumC21699tz1("MEMORY", 1);
    public static final EnumC21699tz1 c = new EnumC21699tz1("DISK", 2);
    public static final EnumC21699tz1 d = new EnumC21699tz1("NETWORK", 3);
    private static final /* synthetic */ EnumC21699tz1[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC21699tz1[] enumC21699tz1ArrA = a();
        e = enumC21699tz1ArrA;
        f = G92.a(enumC21699tz1ArrA);
    }

    private EnumC21699tz1(String str, int i) {
    }

    private static final /* synthetic */ EnumC21699tz1[] a() {
        return new EnumC21699tz1[]{a, b, c, d};
    }

    public static EnumC21699tz1 valueOf(String str) {
        return (EnumC21699tz1) Enum.valueOf(EnumC21699tz1.class, str);
    }

    public static EnumC21699tz1[] values() {
        return (EnumC21699tz1[]) e.clone();
    }
}
