package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class LA7 {
    public static final LA7 a = new LA7("PENDING", 0);
    public static final LA7 b = new LA7("ERROR", 1);
    public static final LA7 c = new LA7("RECEIVED", 2);
    public static final LA7 d = new LA7("READ", 3);
    public static final LA7 e = new LA7("SENT", 4);
    private static final /* synthetic */ LA7[] f;
    private static final /* synthetic */ F92 g;

    static {
        LA7[] la7ArrA = a();
        f = la7ArrA;
        g = G92.a(la7ArrA);
    }

    private LA7(String str, int i) {
    }

    private static final /* synthetic */ LA7[] a() {
        return new LA7[]{a, b, c, d, e};
    }

    public static LA7 valueOf(String str) {
        return (LA7) Enum.valueOf(LA7.class, str);
    }

    public static LA7[] values() {
        return (LA7[]) f.clone();
    }
}
