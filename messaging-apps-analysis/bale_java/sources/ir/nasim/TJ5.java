package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class TJ5 {
    public static final TJ5 a = new TJ5("DEFAULT", 0);
    public static final TJ5 b = new TJ5("FORCE_SOFT_RECONNECT", 1);
    public static final TJ5 c = new TJ5("FORCE_FULL_RECONNECT", 2);
    private static final /* synthetic */ TJ5[] d;
    private static final /* synthetic */ F92 e;

    static {
        TJ5[] tj5ArrA = a();
        d = tj5ArrA;
        e = G92.a(tj5ArrA);
    }

    private TJ5(String str, int i) {
    }

    private static final /* synthetic */ TJ5[] a() {
        return new TJ5[]{a, b, c};
    }

    public static TJ5 valueOf(String str) {
        return (TJ5) Enum.valueOf(TJ5.class, str);
    }

    public static TJ5[] values() {
        return (TJ5[]) d.clone();
    }
}
