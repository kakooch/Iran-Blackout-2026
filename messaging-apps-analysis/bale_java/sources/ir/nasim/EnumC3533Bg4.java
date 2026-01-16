package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Bg4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC3533Bg4 {
    public static final EnumC3533Bg4 a = new EnumC3533Bg4("Remove", 0);
    public static final EnumC3533Bg4 b = new EnumC3533Bg4("Edit", 1);
    public static final EnumC3533Bg4 c = new EnumC3533Bg4("Insert", 2);
    private static final /* synthetic */ EnumC3533Bg4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC3533Bg4[] enumC3533Bg4ArrA = a();
        d = enumC3533Bg4ArrA;
        e = G92.a(enumC3533Bg4ArrA);
    }

    private EnumC3533Bg4(String str, int i) {
    }

    private static final /* synthetic */ EnumC3533Bg4[] a() {
        return new EnumC3533Bg4[]{a, b, c};
    }

    public static EnumC3533Bg4 valueOf(String str) {
        return (EnumC3533Bg4) Enum.valueOf(EnumC3533Bg4.class, str);
    }

    public static EnumC3533Bg4[] values() {
        return (EnumC3533Bg4[]) d.clone();
    }
}
