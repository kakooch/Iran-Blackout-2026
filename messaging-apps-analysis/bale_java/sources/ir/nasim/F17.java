package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class F17 {
    public static final F17 b = new F17("JOIN_CHANNEL", 0, 1);
    public static final F17 c = new F17("SHARED_MEDIA", 1, 2);
    private static final /* synthetic */ F17[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        F17[] f17ArrA = a();
        d = f17ArrA;
        e = G92.a(f17ArrA);
    }

    private F17(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ F17[] a() {
        return new F17[]{b, c};
    }

    public static F17 valueOf(String str) {
        return (F17) Enum.valueOf(F17.class, str);
    }

    public static F17[] values() {
        return (F17[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
