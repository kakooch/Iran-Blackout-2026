package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.zz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC25253zz5 {
    public static final EnumC25253zz5 b = new EnumC25253zz5("WRITE_QUERY", 0, 1);
    public static final EnumC25253zz5 c = new EnumC25253zz5("RECENTLY", 1, 2);
    public static final EnumC25253zz5 d = new EnumC25253zz5("POPULAR", 2, 3);
    private static final /* synthetic */ EnumC25253zz5[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        EnumC25253zz5[] enumC25253zz5ArrA = a();
        e = enumC25253zz5ArrA;
        f = G92.a(enumC25253zz5ArrA);
    }

    private EnumC25253zz5(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC25253zz5[] a() {
        return new EnumC25253zz5[]{b, c, d};
    }

    public static EnumC25253zz5 valueOf(String str) {
        return (EnumC25253zz5) Enum.valueOf(EnumC25253zz5.class, str);
    }

    public static EnumC25253zz5[] values() {
        return (EnumC25253zz5[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
