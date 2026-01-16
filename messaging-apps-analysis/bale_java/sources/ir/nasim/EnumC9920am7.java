package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.am7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC9920am7 {
    public static final EnumC9920am7 a = new EnumC9920am7("MAX_LIMIT", 0);
    public static final EnumC9920am7 b = new EnumC9920am7("USER_ID_MIN_LIMIT", 1);
    public static final EnumC9920am7 c = new EnumC9920am7("USER_ID_NOT_VALID", 2);
    public static final EnumC9920am7 d = new EnumC9920am7("USER_ID_USE_UNDER_LINE_FIRST", 3);
    public static final EnumC9920am7 e = new EnumC9920am7("USER_ID_USE_NUMBER_FIRST", 4);
    public static final EnumC9920am7 f = new EnumC9920am7("USER_ID_EXIST", 5);
    private static final /* synthetic */ EnumC9920am7[] g;
    private static final /* synthetic */ F92 h;

    static {
        EnumC9920am7[] enumC9920am7ArrA = a();
        g = enumC9920am7ArrA;
        h = G92.a(enumC9920am7ArrA);
    }

    private EnumC9920am7(String str, int i) {
    }

    private static final /* synthetic */ EnumC9920am7[] a() {
        return new EnumC9920am7[]{a, b, c, d, e, f};
    }

    public static EnumC9920am7 valueOf(String str) {
        return (EnumC9920am7) Enum.valueOf(EnumC9920am7.class, str);
    }

    public static EnumC9920am7[] values() {
        return (EnumC9920am7[]) g.clone();
    }
}
