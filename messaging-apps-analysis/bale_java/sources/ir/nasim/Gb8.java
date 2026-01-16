package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class Gb8 {
    public static final Gb8 c = new Gb8("OBJ", 0, '{', '}');
    public static final Gb8 d = new Gb8("LIST", 1, '[', ']');
    public static final Gb8 e = new Gb8("MAP", 2, '{', '}');
    public static final Gb8 f = new Gb8("POLY_OBJ", 3, '[', ']');
    private static final /* synthetic */ Gb8[] g;
    private static final /* synthetic */ F92 h;
    public final char a;
    public final char b;

    static {
        Gb8[] gb8ArrA = a();
        g = gb8ArrA;
        h = G92.a(gb8ArrA);
    }

    private Gb8(String str, int i, char c2, char c3) {
        this.a = c2;
        this.b = c3;
    }

    private static final /* synthetic */ Gb8[] a() {
        return new Gb8[]{c, d, e, f};
    }

    public static F92 j() {
        return h;
    }

    public static Gb8 valueOf(String str) {
        return (Gb8) Enum.valueOf(Gb8.class, str);
    }

    public static Gb8[] values() {
        return (Gb8[]) g.clone();
    }
}
