package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.kY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC16005kY4 {
    public static final EnumC16005kY4 b = new EnumC16005kY4("OPERATION_ERROR", 0, LD5.operation_error_snack_bar_message);
    private static final /* synthetic */ EnumC16005kY4[] c;
    private static final /* synthetic */ F92 d;
    private final int a;

    static {
        EnumC16005kY4[] enumC16005kY4ArrA = a();
        c = enumC16005kY4ArrA;
        d = G92.a(enumC16005kY4ArrA);
    }

    private EnumC16005kY4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC16005kY4[] a() {
        return new EnumC16005kY4[]{b};
    }

    public static EnumC16005kY4 valueOf(String str) {
        return (EnumC16005kY4) Enum.valueOf(EnumC16005kY4.class, str);
    }

    public static EnumC16005kY4[] values() {
        return (EnumC16005kY4[]) c.clone();
    }

    public final int j() {
        return this.a;
    }
}
