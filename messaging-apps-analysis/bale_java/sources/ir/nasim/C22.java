package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class C22 {
    public static final C22 a = new C22("NEW", 0);
    public static final C22 b = new C22("OK", 1);
    public static final C22 c = new C22("KEY_RATCHETED", 2);
    public static final C22 d = new C22("MISSING_KEY", 3);
    public static final C22 e = new C22("ENCRYPTION_FAILED", 4);
    public static final C22 f = new C22("DECRYPTION_FAILED", 5);
    public static final C22 g = new C22("INTERNAL_ERROR", 6);
    private static final /* synthetic */ C22[] h;
    private static final /* synthetic */ F92 i;

    static {
        C22[] c22ArrA = a();
        h = c22ArrA;
        i = G92.a(c22ArrA);
    }

    private C22(String str, int i2) {
    }

    private static final /* synthetic */ C22[] a() {
        return new C22[]{a, b, c, d, e, f, g};
    }

    public static C22 valueOf(String str) {
        return (C22) Enum.valueOf(C22.class, str);
    }

    public static C22[] values() {
        return (C22[]) h.clone();
    }
}
