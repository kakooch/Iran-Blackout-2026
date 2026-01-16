package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class ZR3 {
    public static final ZR3 b = new ZR3("BAZZAR", 0, 7);
    public static final ZR3 c = new ZR3("MYKET", 1, 8);
    public static final ZR3 d = new ZR3("BAZZAR_WEBSITE", 2, 9);
    public static final ZR3 e = new ZR3("MYKET_WEBSITE", 3, 10);
    private static final /* synthetic */ ZR3[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        ZR3[] zr3ArrA = a();
        f = zr3ArrA;
        g = G92.a(zr3ArrA);
    }

    private ZR3(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ ZR3[] a() {
        return new ZR3[]{b, c, d, e};
    }

    public static ZR3 valueOf(String str) {
        return (ZR3) Enum.valueOf(ZR3.class, str);
    }

    public static ZR3[] values() {
        return (ZR3[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
