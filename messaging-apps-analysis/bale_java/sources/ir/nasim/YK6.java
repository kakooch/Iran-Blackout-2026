package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class YK6 {
    public static final YK6 a = new YK6("UPLOADING", 0);
    public static final YK6 b = new YK6("UPLOAD_ERROR", 1);
    public static final YK6 c = new YK6("UPLOADED", 2);
    public static final YK6 d = new YK6("WAITING", 3);
    private static final /* synthetic */ YK6[] e;
    private static final /* synthetic */ F92 f;

    static {
        YK6[] yk6ArrA = a();
        e = yk6ArrA;
        f = G92.a(yk6ArrA);
    }

    private YK6(String str, int i) {
    }

    private static final /* synthetic */ YK6[] a() {
        return new YK6[]{a, b, c, d};
    }

    public static YK6 valueOf(String str) {
        return (YK6) Enum.valueOf(YK6.class, str);
    }

    public static YK6[] values() {
        return (YK6[]) e.clone();
    }
}
