package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.si6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC20851si6 {
    public static final EnumC20851si6 a = new EnumC20851si6("Inherit", 0);
    public static final EnumC20851si6 b = new EnumC20851si6("SecureOn", 1);
    public static final EnumC20851si6 c = new EnumC20851si6("SecureOff", 2);
    private static final /* synthetic */ EnumC20851si6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC20851si6[] enumC20851si6ArrA = a();
        d = enumC20851si6ArrA;
        e = G92.a(enumC20851si6ArrA);
    }

    private EnumC20851si6(String str, int i) {
    }

    private static final /* synthetic */ EnumC20851si6[] a() {
        return new EnumC20851si6[]{a, b, c};
    }

    public static EnumC20851si6 valueOf(String str) {
        return (EnumC20851si6) Enum.valueOf(EnumC20851si6.class, str);
    }

    public static EnumC20851si6[] values() {
        return (EnumC20851si6[]) d.clone();
    }
}
