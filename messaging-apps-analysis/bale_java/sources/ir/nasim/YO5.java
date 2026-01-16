package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class YO5 {
    public static final YO5 a = new YO5("INTERNAL_BROWSER", 0);
    public static final YO5 b = new YO5("EXTERNAL_BROWSER", 1);
    private static final /* synthetic */ YO5[] c;
    private static final /* synthetic */ F92 d;

    static {
        YO5[] yo5ArrA = a();
        c = yo5ArrA;
        d = G92.a(yo5ArrA);
    }

    private YO5(String str, int i) {
    }

    private static final /* synthetic */ YO5[] a() {
        return new YO5[]{a, b};
    }

    public static F92 j() {
        return d;
    }

    public static YO5 valueOf(String str) {
        return (YO5) Enum.valueOf(YO5.class, str);
    }

    public static YO5[] values() {
        return (YO5[]) c.clone();
    }
}
