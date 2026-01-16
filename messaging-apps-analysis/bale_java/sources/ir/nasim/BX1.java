package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class BX1 {
    public static final BX1 b = new BX1("SMALL", 0, 32768);
    public static final BX1 c = new BX1("MEDIUM", 1, 65536);
    public static final BX1 d = new BX1("BIG", 2, 131072);
    private static final /* synthetic */ BX1[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        BX1[] bx1ArrA = a();
        e = bx1ArrA;
        f = G92.a(bx1ArrA);
    }

    private BX1(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ BX1[] a() {
        return new BX1[]{b, c, d};
    }

    public static F92 j() {
        return f;
    }

    public static BX1 valueOf(String str) {
        return (BX1) Enum.valueOf(BX1.class, str);
    }

    public static BX1[] values() {
        return (BX1[]) e.clone();
    }

    public final int p() {
        return this.a;
    }
}
