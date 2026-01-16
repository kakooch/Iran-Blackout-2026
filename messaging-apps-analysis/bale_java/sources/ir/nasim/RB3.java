package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class RB3 {
    public static final RB3 a = new RB3("UNKNOWN", 0);
    public static final RB3 b = new RB3("FORWARD", 1);
    public static final RB3 c = new RB3("BACKWARD", 2);
    public static final RB3 d = new RB3("BOTH", 3);
    private static final /* synthetic */ RB3[] e;
    private static final /* synthetic */ F92 f;

    static {
        RB3[] rb3ArrA = a();
        e = rb3ArrA;
        f = G92.a(rb3ArrA);
    }

    private RB3(String str, int i) {
    }

    private static final /* synthetic */ RB3[] a() {
        return new RB3[]{a, b, c, d};
    }

    public static RB3 valueOf(String str) {
        return (RB3) Enum.valueOf(RB3.class, str);
    }

    public static RB3[] values() {
        return (RB3[]) e.clone();
    }
}
