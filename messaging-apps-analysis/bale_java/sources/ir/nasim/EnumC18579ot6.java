package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ot6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC18579ot6 {
    public static final EnumC18579ot6 a = new EnumC18579ot6("NOWHERE", 0);
    public static final EnumC18579ot6 b = new EnumC18579ot6("ALL_SERVICES", 1);
    public static final EnumC18579ot6 c = new EnumC18579ot6("ALL_BOTS", 2);
    private static final /* synthetic */ EnumC18579ot6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC18579ot6[] enumC18579ot6ArrA = a();
        d = enumC18579ot6ArrA;
        e = G92.a(enumC18579ot6ArrA);
    }

    private EnumC18579ot6(String str, int i) {
    }

    private static final /* synthetic */ EnumC18579ot6[] a() {
        return new EnumC18579ot6[]{a, b, c};
    }

    public static F92 j() {
        return e;
    }

    public static EnumC18579ot6 valueOf(String str) {
        return (EnumC18579ot6) Enum.valueOf(EnumC18579ot6.class, str);
    }

    public static EnumC18579ot6[] values() {
        return (EnumC18579ot6[]) d.clone();
    }
}
