package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class JM3 {
    public static final JM3 a = new JM3("UP_VOTE", 0);
    public static final JM3 b = new JM3("DOW_VOTE", 1);
    public static final JM3 c = new JM3("NO_VOTE", 2);
    private static final /* synthetic */ JM3[] d;
    private static final /* synthetic */ F92 e;

    static {
        JM3[] jm3ArrA = a();
        d = jm3ArrA;
        e = G92.a(jm3ArrA);
    }

    private JM3(String str, int i) {
    }

    private static final /* synthetic */ JM3[] a() {
        return new JM3[]{a, b, c};
    }

    public static JM3 valueOf(String str) {
        return (JM3) Enum.valueOf(JM3.class, str);
    }

    public static JM3[] values() {
        return (JM3[]) d.clone();
    }
}
