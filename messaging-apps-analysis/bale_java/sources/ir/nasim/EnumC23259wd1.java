package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wd1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC23259wd1 {
    public static final EnumC23259wd1 a = new EnumC23259wd1("EXCELLENT", 0);
    public static final EnumC23259wd1 b = new EnumC23259wd1("GOOD", 1);
    public static final EnumC23259wd1 c = new EnumC23259wd1("POOR", 2);
    public static final EnumC23259wd1 d = new EnumC23259wd1("UNKNOWN", 3);
    private static final /* synthetic */ EnumC23259wd1[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC23259wd1[] enumC23259wd1ArrA = a();
        e = enumC23259wd1ArrA;
        f = G92.a(enumC23259wd1ArrA);
    }

    private EnumC23259wd1(String str, int i) {
    }

    private static final /* synthetic */ EnumC23259wd1[] a() {
        return new EnumC23259wd1[]{a, b, c, d};
    }

    public static EnumC23259wd1 valueOf(String str) {
        return (EnumC23259wd1) Enum.valueOf(EnumC23259wd1.class, str);
    }

    public static EnumC23259wd1[] values() {
        return (EnumC23259wd1[]) e.clone();
    }
}
