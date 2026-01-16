package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.cj5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
final class EnumC11271cj5 {
    public static final EnumC11271cj5 a = new EnumC11271cj5("INITIAL", 0);
    public static final EnumC11271cj5 b = new EnumC11271cj5("ON_LOAD_STORY", 1);
    private static final /* synthetic */ EnumC11271cj5[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC11271cj5[] enumC11271cj5ArrA = a();
        c = enumC11271cj5ArrA;
        d = G92.a(enumC11271cj5ArrA);
    }

    private EnumC11271cj5(String str, int i) {
    }

    private static final /* synthetic */ EnumC11271cj5[] a() {
        return new EnumC11271cj5[]{a, b};
    }

    public static F92 j() {
        return d;
    }

    public static EnumC11271cj5 valueOf(String str) {
        return (EnumC11271cj5) Enum.valueOf(EnumC11271cj5.class, str);
    }

    public static EnumC11271cj5[] values() {
        return (EnumC11271cj5[]) c.clone();
    }
}
