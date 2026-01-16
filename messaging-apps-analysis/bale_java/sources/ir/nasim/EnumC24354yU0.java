package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC24354yU0 {
    public static final EnumC24354yU0 a = new EnumC24354yU0("NONE", 0);
    public static final EnumC24354yU0 b = new EnumC24354yU0("ALL_JSON_OBJECTS", 1);
    public static final EnumC24354yU0 c = new EnumC24354yU0("POLYMORPHIC", 2);
    private static final /* synthetic */ EnumC24354yU0[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC24354yU0[] enumC24354yU0ArrA = a();
        d = enumC24354yU0ArrA;
        e = G92.a(enumC24354yU0ArrA);
    }

    private EnumC24354yU0(String str, int i) {
    }

    private static final /* synthetic */ EnumC24354yU0[] a() {
        return new EnumC24354yU0[]{a, b, c};
    }

    public static EnumC24354yU0 valueOf(String str) {
        return (EnumC24354yU0) Enum.valueOf(EnumC24354yU0.class, str);
    }

    public static EnumC24354yU0[] values() {
        return (EnumC24354yU0[]) d.clone();
    }
}
