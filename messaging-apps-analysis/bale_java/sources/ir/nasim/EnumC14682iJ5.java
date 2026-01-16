package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.iJ5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC14682iJ5 {
    public static final EnumC14682iJ5 a = new EnumC14682iJ5("SUGGEST", 0, 1);
    public static final EnumC14682iJ5 b = new EnumC14682iJ5("VIEW", 1, 2);
    public static final EnumC14682iJ5 c = new EnumC14682iJ5("CLICK", 2, 3);
    public static final EnumC14682iJ5 d = new EnumC14682iJ5("JOIN", 3, 5);
    public static final EnumC14682iJ5 e = new EnumC14682iJ5("MORE", 4, 6);
    private static final /* synthetic */ EnumC14682iJ5[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC14682iJ5[] enumC14682iJ5ArrA = a();
        f = enumC14682iJ5ArrA;
        g = G92.a(enumC14682iJ5ArrA);
    }

    private EnumC14682iJ5(String str, int i, int i2) {
    }

    private static final /* synthetic */ EnumC14682iJ5[] a() {
        return new EnumC14682iJ5[]{a, b, c, d, e};
    }

    public static EnumC14682iJ5 valueOf(String str) {
        return (EnumC14682iJ5) Enum.valueOf(EnumC14682iJ5.class, str);
    }

    public static EnumC14682iJ5[] values() {
        return (EnumC14682iJ5[]) f.clone();
    }
}
