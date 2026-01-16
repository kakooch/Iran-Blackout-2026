package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.gf4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC13691gf4 {
    public static final EnumC13691gf4 a = new EnumC13691gf4("NOT_STARTED", 0);
    public static final EnumC13691gf4 b = new EnumC13691gf4("IN_PROGRESS", 1);
    public static final EnumC13691gf4 c = new EnumC13691gf4("DONE", 2);
    public static final EnumC13691gf4 d = new EnumC13691gf4("FAILED", 3);
    private static final /* synthetic */ EnumC13691gf4[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC13691gf4[] enumC13691gf4ArrA = a();
        e = enumC13691gf4ArrA;
        f = G92.a(enumC13691gf4ArrA);
    }

    private EnumC13691gf4(String str, int i) {
    }

    private static final /* synthetic */ EnumC13691gf4[] a() {
        return new EnumC13691gf4[]{a, b, c, d};
    }

    public static EnumC13691gf4 valueOf(String str) {
        return (EnumC13691gf4) Enum.valueOf(EnumC13691gf4.class, str);
    }

    public static EnumC13691gf4[] values() {
        return (EnumC13691gf4[]) e.clone();
    }

    public final boolean j() {
        return this == c || this == d;
    }
}
