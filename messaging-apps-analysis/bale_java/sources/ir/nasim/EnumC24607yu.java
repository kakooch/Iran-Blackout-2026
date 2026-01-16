package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yu, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class EnumC24607yu {
    public static final EnumC24607yu a = new EnumC24607yu("Paragraph", 0);
    public static final EnumC24607yu b = new EnumC24607yu("Span", 1);
    public static final EnumC24607yu c = new EnumC24607yu("VerbatimTts", 2);
    public static final EnumC24607yu d = new EnumC24607yu("Url", 3);
    public static final EnumC24607yu e = new EnumC24607yu("Link", 4);
    public static final EnumC24607yu f = new EnumC24607yu("Clickable", 5);
    public static final EnumC24607yu g = new EnumC24607yu("String", 6);
    private static final /* synthetic */ EnumC24607yu[] h;
    private static final /* synthetic */ F92 i;

    static {
        EnumC24607yu[] enumC24607yuArrA = a();
        h = enumC24607yuArrA;
        i = G92.a(enumC24607yuArrA);
    }

    private EnumC24607yu(String str, int i2) {
    }

    private static final /* synthetic */ EnumC24607yu[] a() {
        return new EnumC24607yu[]{a, b, c, d, e, f, g};
    }

    public static EnumC24607yu valueOf(String str) {
        return (EnumC24607yu) Enum.valueOf(EnumC24607yu.class, str);
    }

    public static EnumC24607yu[] values() {
        return (EnumC24607yu[]) h.clone();
    }
}
