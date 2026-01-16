package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.jA1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC15195jA1 {
    public static final EnumC15195jA1 a = new EnumC15195jA1("Month", 0);
    public static final EnumC15195jA1 b = new EnumC15195jA1("Week", 1);
    public static final EnumC15195jA1 c = new EnumC15195jA1("Day", 2);
    public static final EnumC15195jA1 d = new EnumC15195jA1("ThirtyDays", 3);
    public static final EnumC15195jA1 e = new EnumC15195jA1("Custom", 4);
    private static final /* synthetic */ EnumC15195jA1[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC15195jA1[] enumC15195jA1ArrA = a();
        f = enumC15195jA1ArrA;
        g = G92.a(enumC15195jA1ArrA);
    }

    private EnumC15195jA1(String str, int i) {
    }

    private static final /* synthetic */ EnumC15195jA1[] a() {
        return new EnumC15195jA1[]{a, b, c, d, e};
    }

    public static EnumC15195jA1 valueOf(String str) {
        return (EnumC15195jA1) Enum.valueOf(EnumC15195jA1.class, str);
    }

    public static EnumC15195jA1[] values() {
        return (EnumC15195jA1[]) f.clone();
    }
}
