package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.cj7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC11273cj7 {
    public static final EnumC11273cj7 a = new EnumC11273cj7("CALL_LOGS", 0);
    public static final EnumC11273cj7 b = new EnumC11273cj7("ALL", 1);
    public static final EnumC11273cj7 c = new EnumC11273cj7("PRIVATE", 2);
    public static final EnumC11273cj7 d = new EnumC11273cj7("CHANNEL", 3);
    public static final EnumC11273cj7 e = new EnumC11273cj7("GROUP", 4);
    public static final EnumC11273cj7 f = new EnumC11273cj7("BOT", 5);
    private static final /* synthetic */ EnumC11273cj7[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC11273cj7[] enumC11273cj7ArrA = a();
        g = enumC11273cj7ArrA;
        h = G92.a(enumC11273cj7ArrA);
    }

    private EnumC11273cj7(String str, int i) {
    }

    private static final /* synthetic */ EnumC11273cj7[] a() {
        return new EnumC11273cj7[]{a, b, c, d, e, f};
    }

    public static EnumC11273cj7 valueOf(String str) {
        return (EnumC11273cj7) Enum.valueOf(EnumC11273cj7.class, str);
    }

    public static EnumC11273cj7[] values() {
        return (EnumC11273cj7[]) g.clone();
    }

    public final boolean j() {
        return this == b || this == c || this == d || this == e || this == f;
    }

    public final boolean p() {
        return this == b || this == d;
    }
}
