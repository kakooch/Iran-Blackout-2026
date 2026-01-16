package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.lo2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC16752lo2 {
    public static final EnumC16752lo2 a = new EnumC16752lo2("Hidden", 0);
    public static final EnumC16752lo2 b = new EnumC16752lo2("Default", 1);
    public static final EnumC16752lo2 c = new EnumC16752lo2("Active", 2);
    private static final /* synthetic */ EnumC16752lo2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC16752lo2[] enumC16752lo2ArrA = a();
        d = enumC16752lo2ArrA;
        e = G92.a(enumC16752lo2ArrA);
    }

    private EnumC16752lo2(String str, int i) {
    }

    private static final /* synthetic */ EnumC16752lo2[] a() {
        return new EnumC16752lo2[]{a, b, c};
    }

    public static EnumC16752lo2 valueOf(String str) {
        return (EnumC16752lo2) Enum.valueOf(EnumC16752lo2.class, str);
    }

    public static EnumC16752lo2[] values() {
        return (EnumC16752lo2[]) d.clone();
    }
}
