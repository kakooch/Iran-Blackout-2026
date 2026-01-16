package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class B32 {
    public static final B32 b = new B32("NAME", 0, 64);
    public static final B32 c = new B32("USER_ID", 1, 32);
    public static final B32 d = new B32("ABOUT_ME", 2, 70);
    private static final /* synthetic */ B32[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        B32[] b32ArrA = a();
        e = b32ArrA;
        f = G92.a(b32ArrA);
    }

    private B32(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ B32[] a() {
        return new B32[]{b, c, d};
    }

    public static B32 valueOf(String str) {
        return (B32) Enum.valueOf(B32.class, str);
    }

    public static B32[] values() {
        return (B32[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
