package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class YI7 {
    public static final YI7 a = new YI7("ONLINE", 0);
    public static final YI7 b = new YI7("OFFLINE", 1);
    public static final YI7 c = new YI7("NONE", 2);
    private static final /* synthetic */ YI7[] d;
    private static final /* synthetic */ F92 e;

    static {
        YI7[] yi7ArrA = a();
        d = yi7ArrA;
        e = G92.a(yi7ArrA);
    }

    private YI7(String str, int i) {
    }

    private static final /* synthetic */ YI7[] a() {
        return new YI7[]{a, b, c};
    }

    public static F92 j() {
        return e;
    }

    public static YI7 valueOf(String str) {
        return (YI7) Enum.valueOf(YI7.class, str);
    }

    public static YI7[] values() {
        return (YI7[]) d.clone();
    }
}
