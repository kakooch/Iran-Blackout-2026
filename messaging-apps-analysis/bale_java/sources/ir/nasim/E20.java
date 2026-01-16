package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class E20 {
    public static final E20 a = new E20("START", 0);
    public static final E20 b = new E20("END", 1);
    public static final E20 c = new E20("TOP", 2);
    public static final E20 d = new E20("BOTTOM", 3);
    private static final /* synthetic */ E20[] e;
    private static final /* synthetic */ F92 f;

    static {
        E20[] e20ArrA = a();
        e = e20ArrA;
        f = G92.a(e20ArrA);
    }

    private E20(String str, int i) {
    }

    private static final /* synthetic */ E20[] a() {
        return new E20[]{a, b, c, d};
    }

    public static E20 valueOf(String str) {
        return (E20) Enum.valueOf(E20.class, str);
    }

    public static E20[] values() {
        return (E20[]) e.clone();
    }
}
