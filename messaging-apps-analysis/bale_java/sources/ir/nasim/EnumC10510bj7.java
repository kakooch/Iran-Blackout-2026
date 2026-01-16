package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.bj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class EnumC10510bj7 {
    public static final EnumC10510bj7 a = new EnumC10510bj7("Tabs", 0);
    public static final EnumC10510bj7 b = new EnumC10510bj7("Divider", 1);
    public static final EnumC10510bj7 c = new EnumC10510bj7("Indicator", 2);
    private static final /* synthetic */ EnumC10510bj7[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC10510bj7[] enumC10510bj7ArrA = a();
        d = enumC10510bj7ArrA;
        e = G92.a(enumC10510bj7ArrA);
    }

    private EnumC10510bj7(String str, int i) {
    }

    private static final /* synthetic */ EnumC10510bj7[] a() {
        return new EnumC10510bj7[]{a, b, c};
    }

    public static EnumC10510bj7 valueOf(String str) {
        return (EnumC10510bj7) Enum.valueOf(EnumC10510bj7.class, str);
    }

    public static EnumC10510bj7[] values() {
        return (EnumC10510bj7[]) d.clone();
    }
}
