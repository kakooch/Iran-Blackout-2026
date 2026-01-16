package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class XN2 {
    public static final a c;
    public static final XN2 d = new XN2("OTHER", 0, "DELETE_REASON_OTHER", AbstractC12217eE5.dialog_suspension_reason_other);
    public static final XN2 e = new XN2("INAPPROPRIATE_CONTENT", 1, "DELETE_REASON_INAPPROPRIATE_CONTENT", AbstractC12217eE5.dialog_suspension_reason_inappropriate_content);
    public static final XN2 f = new XN2("VIOLENCE", 2, "DELETE_REASON_VIOLENCE", AbstractC12217eE5.dialog_suspension_reason_violence);
    public static final XN2 g = new XN2("SCAM", 3, "DELETE_REASON_SCAM", AbstractC12217eE5.dialog_suspension_reason_scam);
    public static final XN2 h = new XN2("SPAM", 4, "DELETE_REASON_SPAM", AbstractC12217eE5.dialog_suspension_reason_other);
    public static final XN2 i = new XN2("UNKNOWN", 5, "DELETE_REASON_UNKNOWN", AbstractC12217eE5.dialog_suspension_reason_other);
    private static final /* synthetic */ XN2[] j;
    private static final /* synthetic */ F92 k;
    private final String a;
    private final int b;

    public static final class a {
        private a() {
        }

        public final XN2 a(String str) {
            AbstractC13042fc3.i(str, "reason");
            for (XN2 xn2 : XN2.values()) {
                if (AbstractC13042fc3.d(xn2.p(), str)) {
                    return xn2;
                }
            }
            return null;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        XN2[] xn2ArrA = a();
        j = xn2ArrA;
        k = G92.a(xn2ArrA);
        c = new a(null);
    }

    private XN2(String str, int i2, String str2, int i3) {
        this.a = str2;
        this.b = i3;
    }

    private static final /* synthetic */ XN2[] a() {
        return new XN2[]{d, e, f, g, h, i};
    }

    public static XN2 valueOf(String str) {
        return (XN2) Enum.valueOf(XN2.class, str);
    }

    public static XN2[] values() {
        return (XN2[]) j.clone();
    }

    public final int j() {
        return this.b;
    }

    public final String p() {
        return this.a;
    }
}
