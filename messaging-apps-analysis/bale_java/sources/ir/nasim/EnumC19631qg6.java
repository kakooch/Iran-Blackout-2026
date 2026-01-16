package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.qg6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC19631qg6 {
    public static final EnumC19631qg6 a = new EnumC19631qg6("FORWARD", 0);
    public static final EnumC19631qg6 b = new EnumC19631qg6("BACKWARD", 1);
    public static final EnumC19631qg6 c = new EnumC19631qg6("BOTH", 2);
    private static final /* synthetic */ EnumC19631qg6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC19631qg6[] enumC19631qg6ArrA = a();
        d = enumC19631qg6ArrA;
        e = G92.a(enumC19631qg6ArrA);
    }

    private EnumC19631qg6(String str, int i) {
    }

    private static final /* synthetic */ EnumC19631qg6[] a() {
        return new EnumC19631qg6[]{a, b, c};
    }

    public static EnumC19631qg6 valueOf(String str) {
        return (EnumC19631qg6) Enum.valueOf(EnumC19631qg6.class, str);
    }

    public static EnumC19631qg6[] values() {
        return (EnumC19631qg6[]) d.clone();
    }
}
