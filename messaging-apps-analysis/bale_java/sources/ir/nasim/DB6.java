package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class DB6 {
    public static final DB6 b = new DB6("NONE", 0, 0);
    public static final DB6 c = new DB6("REVERSE", 1, 1);
    public static final DB6 d = new DB6("SHUFFLE", 2, 2);
    private static final /* synthetic */ DB6[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        DB6[] db6ArrA = a();
        e = db6ArrA;
        f = G92.a(db6ArrA);
    }

    private DB6(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ DB6[] a() {
        return new DB6[]{b, c, d};
    }

    public static DB6 valueOf(String str) {
        return (DB6) Enum.valueOf(DB6.class, str);
    }

    public static DB6[] values() {
        return (DB6[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
