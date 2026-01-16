package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class D46 {
    public static final D46 b = new D46("ROOT_MANAGEMENT_APPS", 0, 1);
    public static final D46 c = new D46("DANGEROUS_APPS", 1, 2);
    public static final D46 d = new D46("SU_BINARY", 2, 4);
    public static final D46 e = new D46("DANGEROUS_PROPERTIES", 3, 8);
    public static final D46 f = new D46("WRITABLE_FILESYSTEM", 4, 16);
    public static final D46 g = new D46("TEST_KEYS", 5, 32);
    public static final D46 h = new D46("NATIVE_ROOT", 6, 64);
    public static final D46 i = new D46("MAGISK", 7, 128);
    public static final D46 j = new D46("NOT_DETECTED", 8, 0);
    private static final /* synthetic */ D46[] k;
    private static final /* synthetic */ F92 l;
    private final int a;

    static {
        D46[] d46ArrA = a();
        k = d46ArrA;
        l = G92.a(d46ArrA);
    }

    private D46(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ D46[] a() {
        return new D46[]{b, c, d, e, f, g, h, i, j};
    }

    public static D46 valueOf(String str) {
        return (D46) Enum.valueOf(D46.class, str);
    }

    public static D46[] values() {
        return (D46[]) k.clone();
    }

    public final int j() {
        return this.a;
    }
}
