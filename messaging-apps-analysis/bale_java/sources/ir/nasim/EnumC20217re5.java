package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.re5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC20217re5 {
    public static final EnumC20217re5 a = new EnumC20217re5("UNCHANGED", 0);
    public static final EnumC20217re5 b = new EnumC20217re5("TRANSLUCENT", 1);
    public static final EnumC20217re5 c = new EnumC20217re5("OPAQUE", 2);
    private static final /* synthetic */ EnumC20217re5[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC20217re5[] enumC20217re5ArrA = a();
        d = enumC20217re5ArrA;
        e = G92.a(enumC20217re5ArrA);
    }

    private EnumC20217re5(String str, int i) {
    }

    private static final /* synthetic */ EnumC20217re5[] a() {
        return new EnumC20217re5[]{a, b, c};
    }

    public static EnumC20217re5 valueOf(String str) {
        return (EnumC20217re5) Enum.valueOf(EnumC20217re5.class, str);
    }

    public static EnumC20217re5[] values() {
        return (EnumC20217re5[]) d.clone();
    }
}
