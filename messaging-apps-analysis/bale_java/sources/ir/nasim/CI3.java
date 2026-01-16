package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class CI3 {
    public static final CI3 a = new CI3("DELETE_LOGS_SUCCESS", 0);
    public static final CI3 b = new CI3("TRY_AGAIN", 1);
    public static final CI3 c = new CI3("EMPTY_LOG", 2);
    public static final CI3 d = new CI3("WEB_VIEW_DEBUG_DISABLED", 3);
    public static final CI3 e = new CI3("WEB_VIEW_DEBUG_ENABLED", 4);
    private static final /* synthetic */ CI3[] f;
    private static final /* synthetic */ F92 g;

    static {
        CI3[] ci3ArrA = a();
        f = ci3ArrA;
        g = G92.a(ci3ArrA);
    }

    private CI3(String str, int i) {
    }

    private static final /* synthetic */ CI3[] a() {
        return new CI3[]{a, b, c, d, e};
    }

    public static CI3 valueOf(String str) {
        return (CI3) Enum.valueOf(CI3.class, str);
    }

    public static CI3[] values() {
        return (CI3[]) f.clone();
    }
}
