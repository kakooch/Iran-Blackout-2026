package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.jn4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC15562jn4 {
    public static final EnumC15562jn4 a = new EnumC15562jn4("Default", 0);
    public static final EnumC15562jn4 b = new EnumC15562jn4("UserInput", 1);
    public static final EnumC15562jn4 c = new EnumC15562jn4("PreventUserInput", 2);
    private static final /* synthetic */ EnumC15562jn4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC15562jn4[] enumC15562jn4ArrA = a();
        d = enumC15562jn4ArrA;
        e = G92.a(enumC15562jn4ArrA);
    }

    private EnumC15562jn4(String str, int i) {
    }

    private static final /* synthetic */ EnumC15562jn4[] a() {
        return new EnumC15562jn4[]{a, b, c};
    }

    public static EnumC15562jn4 valueOf(String str) {
        return (EnumC15562jn4) Enum.valueOf(EnumC15562jn4.class, str);
    }

    public static EnumC15562jn4[] values() {
        return (EnumC15562jn4[]) d.clone();
    }
}
