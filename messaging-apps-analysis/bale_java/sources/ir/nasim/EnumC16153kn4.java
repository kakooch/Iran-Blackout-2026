package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.kn4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC16153kn4 {
    public static final EnumC16153kn4 a = new EnumC16153kn4("Default", 0);
    public static final EnumC16153kn4 b = new EnumC16153kn4("UserInput", 1);
    public static final EnumC16153kn4 c = new EnumC16153kn4("PreventUserInput", 2);
    private static final /* synthetic */ EnumC16153kn4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC16153kn4[] enumC16153kn4ArrA = a();
        d = enumC16153kn4ArrA;
        e = G92.a(enumC16153kn4ArrA);
    }

    private EnumC16153kn4(String str, int i) {
    }

    private static final /* synthetic */ EnumC16153kn4[] a() {
        return new EnumC16153kn4[]{a, b, c};
    }

    public static EnumC16153kn4 valueOf(String str) {
        return (EnumC16153kn4) Enum.valueOf(EnumC16153kn4.class, str);
    }

    public static EnumC16153kn4[] values() {
        return (EnumC16153kn4[]) d.clone();
    }
}
