package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.zZ4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC24997zZ4 {
    public static final EnumC24997zZ4 a = new EnumC24997zZ4("WITH_BACKGROUND", 0);
    public static final EnumC24997zZ4 b = new EnumC24997zZ4("WITHOUT_BACKGROUND", 1);
    private static final /* synthetic */ EnumC24997zZ4[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC24997zZ4[] enumC24997zZ4ArrA = a();
        c = enumC24997zZ4ArrA;
        d = G92.a(enumC24997zZ4ArrA);
    }

    private EnumC24997zZ4(String str, int i) {
    }

    private static final /* synthetic */ EnumC24997zZ4[] a() {
        return new EnumC24997zZ4[]{a, b};
    }

    public static EnumC24997zZ4 valueOf(String str) {
        return (EnumC24997zZ4) Enum.valueOf(EnumC24997zZ4.class, str);
    }

    public static EnumC24997zZ4[] values() {
        return (EnumC24997zZ4[]) c.clone();
    }
}
