package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class DH0 {
    public static final DH0 b = new DH0("CLICK", 0, 1);
    public static final DH0 c = new DH0("SCROLL", 1, 2);
    private static final /* synthetic */ DH0[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        DH0[] dh0ArrA = a();
        d = dh0ArrA;
        e = G92.a(dh0ArrA);
    }

    private DH0(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ DH0[] a() {
        return new DH0[]{b, c};
    }

    public static DH0 valueOf(String str) {
        return (DH0) Enum.valueOf(DH0.class, str);
    }

    public static DH0[] values() {
        return (DH0[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
