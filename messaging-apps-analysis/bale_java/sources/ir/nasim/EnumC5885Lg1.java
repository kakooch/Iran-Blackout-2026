package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Lg1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC5885Lg1 {
    public static final EnumC5885Lg1 a = new EnumC5885Lg1("PHONE", 0);
    public static final EnumC5885Lg1 b = new EnumC5885Lg1("EMAIL", 1);
    public static final EnumC5885Lg1 c = new EnumC5885Lg1("WEB", 2);
    public static final EnumC5885Lg1 d = new EnumC5885Lg1("SOCIAL", 3);
    private static final /* synthetic */ EnumC5885Lg1[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC5885Lg1[] enumC5885Lg1ArrA = a();
        e = enumC5885Lg1ArrA;
        f = G92.a(enumC5885Lg1ArrA);
    }

    private EnumC5885Lg1(String str, int i) {
    }

    private static final /* synthetic */ EnumC5885Lg1[] a() {
        return new EnumC5885Lg1[]{a, b, c, d};
    }

    public static EnumC5885Lg1 valueOf(String str) {
        return (EnumC5885Lg1) Enum.valueOf(EnumC5885Lg1.class, str);
    }

    public static EnumC5885Lg1[] values() {
        return (EnumC5885Lg1[]) e.clone();
    }
}
