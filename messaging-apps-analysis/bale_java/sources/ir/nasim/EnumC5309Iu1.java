package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Iu1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC5309Iu1 {
    public static final EnumC5309Iu1 a = new EnumC5309Iu1("CROSSED", 0);
    public static final EnumC5309Iu1 b = new EnumC5309Iu1("NOT_CROSSED", 1);
    public static final EnumC5309Iu1 c = new EnumC5309Iu1("COLLAPSED", 2);
    private static final /* synthetic */ EnumC5309Iu1[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC5309Iu1[] enumC5309Iu1ArrA = a();
        d = enumC5309Iu1ArrA;
        e = G92.a(enumC5309Iu1ArrA);
    }

    private EnumC5309Iu1(String str, int i) {
    }

    private static final /* synthetic */ EnumC5309Iu1[] a() {
        return new EnumC5309Iu1[]{a, b, c};
    }

    public static EnumC5309Iu1 valueOf(String str) {
        return (EnumC5309Iu1) Enum.valueOf(EnumC5309Iu1.class, str);
    }

    public static EnumC5309Iu1[] values() {
        return (EnumC5309Iu1[]) d.clone();
    }
}
