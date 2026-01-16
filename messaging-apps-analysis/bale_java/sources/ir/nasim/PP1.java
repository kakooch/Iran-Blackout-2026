package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class PP1 {
    public static final PP1 b = new PP1("HEADER", 0, 1);
    public static final PP1 c = new PP1("NORMAL", 1, 2);
    public static final PP1 d = new PP1("FOOTER", 2, 3);
    private static final /* synthetic */ PP1[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        PP1[] pp1ArrA = a();
        e = pp1ArrA;
        f = G92.a(pp1ArrA);
    }

    private PP1(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ PP1[] a() {
        return new PP1[]{b, c, d};
    }

    public static PP1 valueOf(String str) {
        return (PP1) Enum.valueOf(PP1.class, str);
    }

    public static PP1[] values() {
        return (PP1[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
