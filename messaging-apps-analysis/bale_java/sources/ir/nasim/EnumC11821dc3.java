package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.dc3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC11821dc3 {
    public static final EnumC11821dc3 a = new EnumC11821dc3("Min", 0);
    public static final EnumC11821dc3 b = new EnumC11821dc3("Max", 1);
    private static final /* synthetic */ EnumC11821dc3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC11821dc3[] enumC11821dc3ArrA = a();
        c = enumC11821dc3ArrA;
        d = G92.a(enumC11821dc3ArrA);
    }

    private EnumC11821dc3(String str, int i) {
    }

    private static final /* synthetic */ EnumC11821dc3[] a() {
        return new EnumC11821dc3[]{a, b};
    }

    public static EnumC11821dc3 valueOf(String str) {
        return (EnumC11821dc3) Enum.valueOf(EnumC11821dc3.class, str);
    }

    public static EnumC11821dc3[] values() {
        return (EnumC11821dc3[]) c.clone();
    }
}
