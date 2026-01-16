package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.bY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC10399bY4 {
    public static final EnumC10399bY4 a = new EnumC10399bY4("WITH_BACKGROUND", 0);
    public static final EnumC10399bY4 b = new EnumC10399bY4("WITHOUT_BACKGROUND", 1);
    public static final EnumC10399bY4 c = new EnumC10399bY4("SUBMIT_BUTTON", 2);
    private static final /* synthetic */ EnumC10399bY4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC10399bY4[] enumC10399bY4ArrA = a();
        d = enumC10399bY4ArrA;
        e = G92.a(enumC10399bY4ArrA);
    }

    private EnumC10399bY4(String str, int i) {
    }

    private static final /* synthetic */ EnumC10399bY4[] a() {
        return new EnumC10399bY4[]{a, b, c};
    }

    public static EnumC10399bY4 valueOf(String str) {
        return (EnumC10399bY4) Enum.valueOf(EnumC10399bY4.class, str);
    }

    public static EnumC10399bY4[] values() {
        return (EnumC10399bY4[]) d.clone();
    }
}
