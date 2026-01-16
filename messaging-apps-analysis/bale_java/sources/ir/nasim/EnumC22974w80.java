package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.w80, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC22974w80 {
    public static final EnumC22974w80 b = new EnumC22974w80("SCAM", 0, AbstractC12217eE5.report_bottom_sheet_item_scam);
    public static final EnumC22974w80 c = new EnumC22974w80("SPAM", 1, AbstractC12217eE5.report_bottom_sheet_item_violence);
    public static final EnumC22974w80 d = new EnumC22974w80("IMMORAL", 2, AbstractC12217eE5.report_bottom_sheet_item_promoting_immoral_content);
    public static final EnumC22974w80 e = new EnumC22974w80("FALSE_INFORMATION", 3, AbstractC12217eE5.promoting_false_information);
    public static final EnumC22974w80 f = new EnumC22974w80("UNKNOWN", 4, AbstractC12217eE5.report_bottom_sheet_item_promoting_immoral_content);
    private static final /* synthetic */ EnumC22974w80[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    static {
        EnumC22974w80[] enumC22974w80ArrA = a();
        g = enumC22974w80ArrA;
        h = G92.a(enumC22974w80ArrA);
    }

    private EnumC22974w80(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC22974w80[] a() {
        return new EnumC22974w80[]{b, c, d, e, f};
    }

    public static EnumC22974w80 valueOf(String str) {
        return (EnumC22974w80) Enum.valueOf(EnumC22974w80.class, str);
    }

    public static EnumC22974w80[] values() {
        return (EnumC22974w80[]) g.clone();
    }

    public final int j() {
        return this.a;
    }
}
