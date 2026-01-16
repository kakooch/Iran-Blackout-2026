package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Uj4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC8066Uj4 {
    public static final EnumC8066Uj4 b = new EnumC8066Uj4("ADD_TO_HOME_SCREEN", 0, 1);
    public static final EnumC8066Uj4 c = new EnumC8066Uj4("ADDED_TO_HOME_SCREEN", 1, 10);
    public static final EnumC8066Uj4 d = new EnumC8066Uj4("RELOAD_PAGE", 2, 2);
    public static final EnumC8066Uj4 e = new EnumC8066Uj4("TERMS_OF_USE", 3, 3);
    public static final EnumC8066Uj4 f = new EnumC8066Uj4("GO_TO_SETTING", 4, 4);
    private static final /* synthetic */ EnumC8066Uj4[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    static {
        EnumC8066Uj4[] enumC8066Uj4ArrA = a();
        g = enumC8066Uj4ArrA;
        h = G92.a(enumC8066Uj4ArrA);
    }

    private EnumC8066Uj4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC8066Uj4[] a() {
        return new EnumC8066Uj4[]{b, c, d, e, f};
    }

    public static EnumC8066Uj4 valueOf(String str) {
        return (EnumC8066Uj4) Enum.valueOf(EnumC8066Uj4.class, str);
    }

    public static EnumC8066Uj4[] values() {
        return (EnumC8066Uj4[]) g.clone();
    }

    public final int j() {
        return this.a;
    }
}
