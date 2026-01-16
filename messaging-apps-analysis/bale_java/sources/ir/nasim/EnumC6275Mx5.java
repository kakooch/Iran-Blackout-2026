package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Mx5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC6275Mx5 {
    public static final EnumC6275Mx5 b = new EnumC6275Mx5("v1", 0, 1);
    public static final EnumC6275Mx5 c = new EnumC6275Mx5("v2", 1, 2);
    public static final EnumC6275Mx5 d = new EnumC6275Mx5("v3", 2, 3);
    public static final EnumC6275Mx5 e = new EnumC6275Mx5("v4", 3, 4);
    public static final EnumC6275Mx5 f = new EnumC6275Mx5("v5", 4, 5);
    public static final EnumC6275Mx5 g = new EnumC6275Mx5("v6", 5, 6);
    public static final EnumC6275Mx5 h = new EnumC6275Mx5("v7", 6, 7);
    public static final EnumC6275Mx5 i = new EnumC6275Mx5("v8", 7, 8);
    public static final EnumC6275Mx5 j = new EnumC6275Mx5("v9", 8, 9);
    public static final EnumC6275Mx5 k = new EnumC6275Mx5("v10", 9, 10);
    public static final EnumC6275Mx5 l = new EnumC6275Mx5("v11", 10, 11);
    public static final EnumC6275Mx5 m = new EnumC6275Mx5("v12", 11, 12);
    public static final EnumC6275Mx5 n = new EnumC6275Mx5("v13", 12, 13);
    private static final /* synthetic */ EnumC6275Mx5[] o;
    private static final /* synthetic */ F92 p;
    private final int a;

    static {
        EnumC6275Mx5[] enumC6275Mx5ArrA = a();
        o = enumC6275Mx5ArrA;
        p = G92.a(enumC6275Mx5ArrA);
    }

    private EnumC6275Mx5(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC6275Mx5[] a() {
        return new EnumC6275Mx5[]{b, c, d, e, f, g, h, i, j, k, l, m, n};
    }

    public static EnumC6275Mx5 valueOf(String str) {
        return (EnumC6275Mx5) Enum.valueOf(EnumC6275Mx5.class, str);
    }

    public static EnumC6275Mx5[] values() {
        return (EnumC6275Mx5[]) o.clone();
    }

    public final int j() {
        return this.a;
    }
}
