package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.aj7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
final class EnumC9890aj7 {
    public static final EnumC9890aj7 a = new EnumC9890aj7("Tabs", 0);
    public static final EnumC9890aj7 b = new EnumC9890aj7("Divider", 1);
    public static final EnumC9890aj7 c = new EnumC9890aj7("Indicator", 2);
    private static final /* synthetic */ EnumC9890aj7[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC9890aj7[] enumC9890aj7ArrA = a();
        d = enumC9890aj7ArrA;
        e = G92.a(enumC9890aj7ArrA);
    }

    private EnumC9890aj7(String str, int i) {
    }

    private static final /* synthetic */ EnumC9890aj7[] a() {
        return new EnumC9890aj7[]{a, b, c};
    }

    public static EnumC9890aj7 valueOf(String str) {
        return (EnumC9890aj7) Enum.valueOf(EnumC9890aj7.class, str);
    }

    public static EnumC9890aj7[] values() {
        return (EnumC9890aj7[]) d.clone();
    }
}
