package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.qt6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC19761qt6 {
    public static final EnumC19761qt6 a = new EnumC19761qt6("LOADING", 0);
    public static final EnumC19761qt6 b = new EnumC19761qt6("LOADED", 1);
    public static final EnumC19761qt6 c = new EnumC19761qt6("ERROR", 2);
    private static final /* synthetic */ EnumC19761qt6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC19761qt6[] enumC19761qt6ArrA = a();
        d = enumC19761qt6ArrA;
        e = G92.a(enumC19761qt6ArrA);
    }

    private EnumC19761qt6(String str, int i) {
    }

    private static final /* synthetic */ EnumC19761qt6[] a() {
        return new EnumC19761qt6[]{a, b, c};
    }

    public static EnumC19761qt6 valueOf(String str) {
        return (EnumC19761qt6) Enum.valueOf(EnumC19761qt6.class, str);
    }

    public static EnumC19761qt6[] values() {
        return (EnumC19761qt6[]) d.clone();
    }
}
