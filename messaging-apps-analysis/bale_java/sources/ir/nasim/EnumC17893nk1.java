package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.nk1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class EnumC17893nk1 {
    public static final EnumC17893nk1 a = new EnumC17893nk1("VIEW_APPEAR", 0);
    public static final EnumC17893nk1 b = new EnumC17893nk1("VIEW_DISAPPEAR", 1);
    private static final /* synthetic */ EnumC17893nk1[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC17893nk1[] enumC17893nk1ArrA = a();
        c = enumC17893nk1ArrA;
        d = G92.a(enumC17893nk1ArrA);
    }

    private EnumC17893nk1(String str, int i) {
    }

    private static final /* synthetic */ EnumC17893nk1[] a() {
        return new EnumC17893nk1[]{a, b};
    }

    public static EnumC17893nk1 valueOf(String str) {
        return (EnumC17893nk1) Enum.valueOf(EnumC17893nk1.class, str);
    }

    public static EnumC17893nk1[] values() {
        return (EnumC17893nk1[]) c.clone();
    }
}
