package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class G20 {
    public static final G20 a = new G20("START", 0);
    public static final G20 b = new G20("END", 1);
    public static final G20 c = new G20("TOP", 2);
    public static final G20 d = new G20("BOTTOM", 3);
    private static final /* synthetic */ G20[] e;
    private static final /* synthetic */ F92 f;

    static {
        G20[] g20ArrA = a();
        e = g20ArrA;
        f = G92.a(g20ArrA);
    }

    private G20(String str, int i) {
    }

    private static final /* synthetic */ G20[] a() {
        return new G20[]{a, b, c, d};
    }

    public static G20 valueOf(String str) {
        return (G20) Enum.valueOf(G20.class, str);
    }

    public static G20[] values() {
        return (G20[]) e.clone();
    }
}
