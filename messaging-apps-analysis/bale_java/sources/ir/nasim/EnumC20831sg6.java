package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.sg6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC20831sg6 {
    public static final EnumC20831sg6 a = new EnumC20831sg6("FORWARD", 0);
    public static final EnumC20831sg6 b = new EnumC20831sg6("BACKWARD", 1);
    public static final EnumC20831sg6 c = new EnumC20831sg6("BOTH", 2);
    private static final /* synthetic */ EnumC20831sg6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC20831sg6[] enumC20831sg6ArrA = a();
        d = enumC20831sg6ArrA;
        e = G92.a(enumC20831sg6ArrA);
    }

    private EnumC20831sg6(String str, int i) {
    }

    private static final /* synthetic */ EnumC20831sg6[] a() {
        return new EnumC20831sg6[]{a, b, c};
    }

    public static EnumC20831sg6 valueOf(String str) {
        return (EnumC20831sg6) Enum.valueOf(EnumC20831sg6.class, str);
    }

    public static EnumC20831sg6[] values() {
        return (EnumC20831sg6[]) d.clone();
    }
}
