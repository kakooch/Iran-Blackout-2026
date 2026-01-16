package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.oB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC18164oB6 {
    public static final EnumC18164oB6 a = new EnumC18164oB6("COMPONENTS", 0);
    public static final EnumC18164oB6 b = new EnumC18164oB6("COLORS", 1);
    public static final EnumC18164oB6 c = new EnumC18164oB6("TYPOGRAPHY", 2);
    private static final /* synthetic */ EnumC18164oB6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC18164oB6[] enumC18164oB6ArrA = a();
        d = enumC18164oB6ArrA;
        e = G92.a(enumC18164oB6ArrA);
    }

    private EnumC18164oB6(String str, int i) {
    }

    private static final /* synthetic */ EnumC18164oB6[] a() {
        return new EnumC18164oB6[]{a, b, c};
    }

    public static EnumC18164oB6 valueOf(String str) {
        return (EnumC18164oB6) Enum.valueOf(EnumC18164oB6.class, str);
    }

    public static EnumC18164oB6[] values() {
        return (EnumC18164oB6[]) d.clone();
    }
}
