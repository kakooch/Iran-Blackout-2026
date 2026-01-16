package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class NA3 {
    public static final NA3 b = new NA3("APPROVED", 0);
    public static final NA3 c = new NA3("BLOCKED", 1);
    public static final NA3 d = new NA3("UNKNOWN", 2);
    public static final NA3 e = new NA3("ERROR", 3);
    private static final /* synthetic */ NA3[] f;
    private static final /* synthetic */ F92 g;
    private String a = "";

    static {
        NA3[] na3ArrA = a();
        f = na3ArrA;
        g = G92.a(na3ArrA);
    }

    private NA3(String str, int i) {
    }

    private static final /* synthetic */ NA3[] a() {
        return new NA3[]{b, c, d, e};
    }

    public static NA3 valueOf(String str) {
        return (NA3) Enum.valueOf(NA3.class, str);
    }

    public static NA3[] values() {
        return (NA3[]) f.clone();
    }

    public final String j() {
        return this.a;
    }

    public final void p(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.a = str;
    }
}
