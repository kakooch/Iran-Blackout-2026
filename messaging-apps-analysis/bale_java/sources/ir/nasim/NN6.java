package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class NN6 {
    public static final NN6 a = new NN6("CACHE", 0);
    public static final NN6 b = new NN6("INTERNAL", 1);
    public static final NN6 c = new NN6("EXTERNAL", 2);
    private static final /* synthetic */ NN6[] d;
    private static final /* synthetic */ F92 e;

    static {
        NN6[] nn6ArrA = a();
        d = nn6ArrA;
        e = G92.a(nn6ArrA);
    }

    private NN6(String str, int i) {
    }

    private static final /* synthetic */ NN6[] a() {
        return new NN6[]{a, b, c};
    }

    public static NN6 valueOf(String str) {
        return (NN6) Enum.valueOf(NN6.class, str);
    }

    public static NN6[] values() {
        return (NN6[]) d.clone();
    }
}
