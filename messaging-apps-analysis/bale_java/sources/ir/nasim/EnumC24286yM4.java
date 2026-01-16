package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yM4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC24286yM4 {
    public static final EnumC24286yM4 a = new EnumC24286yM4("Vertical", 0);
    public static final EnumC24286yM4 b = new EnumC24286yM4("Horizontal", 1);
    private static final /* synthetic */ EnumC24286yM4[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC24286yM4[] enumC24286yM4ArrA = a();
        c = enumC24286yM4ArrA;
        d = G92.a(enumC24286yM4ArrA);
    }

    private EnumC24286yM4(String str, int i) {
    }

    private static final /* synthetic */ EnumC24286yM4[] a() {
        return new EnumC24286yM4[]{a, b};
    }

    public static EnumC24286yM4 valueOf(String str) {
        return (EnumC24286yM4) Enum.valueOf(EnumC24286yM4.class, str);
    }

    public static EnumC24286yM4[] values() {
        return (EnumC24286yM4[]) c.clone();
    }
}
