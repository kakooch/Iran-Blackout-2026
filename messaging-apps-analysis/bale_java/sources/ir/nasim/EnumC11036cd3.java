package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.cd3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC11036cd3 {
    public static final EnumC11036cd3 a = new EnumC11036cd3("IGNORED", 0);
    public static final EnumC11036cd3 b = new EnumC11036cd3("SCHEDULED", 1);
    public static final EnumC11036cd3 c = new EnumC11036cd3("DEFERRED", 2);
    public static final EnumC11036cd3 d = new EnumC11036cd3("IMMINENT", 3);
    private static final /* synthetic */ EnumC11036cd3[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC11036cd3[] enumC11036cd3ArrA = a();
        e = enumC11036cd3ArrA;
        f = G92.a(enumC11036cd3ArrA);
    }

    private EnumC11036cd3(String str, int i) {
    }

    private static final /* synthetic */ EnumC11036cd3[] a() {
        return new EnumC11036cd3[]{a, b, c, d};
    }

    public static EnumC11036cd3 valueOf(String str) {
        return (EnumC11036cd3) Enum.valueOf(EnumC11036cd3.class, str);
    }

    public static EnumC11036cd3[] values() {
        return (EnumC11036cd3[]) e.clone();
    }
}
