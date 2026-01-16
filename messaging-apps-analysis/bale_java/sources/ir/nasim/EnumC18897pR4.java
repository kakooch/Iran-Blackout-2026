package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.pR4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC18897pR4 {
    public static final EnumC18897pR4 b = new EnumC18897pR4("UNKNOWN", 0, 0);
    public static final EnumC18897pR4 c = new EnumC18897pR4("TOPUP", 1, 1);
    public static final EnumC18897pR4 d = new EnumC18897pR4("WITHDRAW", 2, 2);
    public static final EnumC18897pR4 e = new EnumC18897pR4("UNSUPPORTED_VALUE", 3, -1);
    private static final /* synthetic */ EnumC18897pR4[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        EnumC18897pR4[] enumC18897pR4ArrA = a();
        f = enumC18897pR4ArrA;
        g = G92.a(enumC18897pR4ArrA);
    }

    private EnumC18897pR4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC18897pR4[] a() {
        return new EnumC18897pR4[]{b, c, d, e};
    }

    public static EnumC18897pR4 valueOf(String str) {
        return (EnumC18897pR4) Enum.valueOf(EnumC18897pR4.class, str);
    }

    public static EnumC18897pR4[] values() {
        return (EnumC18897pR4[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
