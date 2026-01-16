package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class OP5 {
    public static final OP5 b = new OP5("SCAM", 0, AbstractC12217eE5.report_bottom_sheet_item_scam);
    public static final OP5 c = new OP5("INAPPROPRIATE_CONTENT", 1, AbstractC12217eE5.report_bottom_sheet_item_unethical_content);
    public static final OP5 d = new OP5("VIOLENCE", 2, AbstractC12217eE5.report_bottom_sheet_item_violence);
    public static final OP5 e = new OP5("SPAM", 3, AbstractC12217eE5.report_bottom_sheet_item_spam);
    public static final OP5 f = new OP5("FALSE_INFO", 4, AbstractC12217eE5.report_bottom_sheet_item_false_information);
    private static final /* synthetic */ OP5[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    static {
        OP5[] op5ArrA = a();
        g = op5ArrA;
        h = G92.a(op5ArrA);
    }

    private OP5(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ OP5[] a() {
        return new OP5[]{b, c, d, e, f};
    }

    public static OP5 valueOf(String str) {
        return (OP5) Enum.valueOf(OP5.class, str);
    }

    public static OP5[] values() {
        return (OP5[]) g.clone();
    }

    public final int j() {
        return this.a;
    }
}
