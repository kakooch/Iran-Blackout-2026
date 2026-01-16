package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class BJ6 {
    public static final BJ6 a = new BJ6("FOLDER", 0);
    public static final BJ6 b = new BJ6("CallLogs", 1);
    public static final BJ6 c = new BJ6("Loading", 2);
    private static final /* synthetic */ BJ6[] d;
    private static final /* synthetic */ F92 e;

    static {
        BJ6[] bj6ArrA = a();
        d = bj6ArrA;
        e = G92.a(bj6ArrA);
    }

    private BJ6(String str, int i) {
    }

    private static final /* synthetic */ BJ6[] a() {
        return new BJ6[]{a, b, c};
    }

    public static BJ6 valueOf(String str) {
        return (BJ6) Enum.valueOf(BJ6.class, str);
    }

    public static BJ6[] values() {
        return (BJ6[]) d.clone();
    }
}
