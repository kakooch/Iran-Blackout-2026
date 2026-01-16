package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.w03, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC22897w03 {
    public static final EnumC22897w03 a = new EnumC22897w03("START", 0);
    public static final EnumC22897w03 b = new EnumC22897w03("END", 1);
    public static final EnumC22897w03 c = new EnumC22897w03("TOP", 2);
    public static final EnumC22897w03 d = new EnumC22897w03("BOTTOM", 3);
    private static final /* synthetic */ EnumC22897w03[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC22897w03[] enumC22897w03ArrA = a();
        e = enumC22897w03ArrA;
        f = G92.a(enumC22897w03ArrA);
    }

    private EnumC22897w03(String str, int i) {
    }

    private static final /* synthetic */ EnumC22897w03[] a() {
        return new EnumC22897w03[]{a, b, c, d};
    }

    public static EnumC22897w03 valueOf(String str) {
        return (EnumC22897w03) Enum.valueOf(EnumC22897w03.class, str);
    }

    public static EnumC22897w03[] values() {
        return (EnumC22897w03[]) e.clone();
    }
}
