package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class SS4 {
    public static final SS4 a = new SS4("LEFT", 0);
    public static final SS4 b = new SS4("TOP", 1);
    public static final SS4 c = new SS4("RIGHT", 2);
    public static final SS4 d = new SS4("BOTTOM", 3);
    private static final /* synthetic */ SS4[] e;
    private static final /* synthetic */ F92 f;

    static {
        SS4[] ss4ArrA = a();
        e = ss4ArrA;
        f = G92.a(ss4ArrA);
    }

    private SS4(String str, int i) {
    }

    private static final /* synthetic */ SS4[] a() {
        return new SS4[]{a, b, c, d};
    }

    public static SS4 valueOf(String str) {
        return (SS4) Enum.valueOf(SS4.class, str);
    }

    public static SS4[] values() {
        return (SS4[]) e.clone();
    }
}
