package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class F20 {
    public static final F20 a = new F20("NONE", 0);
    public static final F20 b = new F20("ELASTIC", 1);
    public static final F20 c = new F20("FADE", 2);
    public static final F20 d = new F20("CIRCULAR", 3);
    public static final F20 e = new F20("OVERSHOOT", 4);
    private static final /* synthetic */ F20[] f;
    private static final /* synthetic */ F92 g;

    static {
        F20[] f20ArrA = a();
        f = f20ArrA;
        g = G92.a(f20ArrA);
    }

    private F20(String str, int i) {
    }

    private static final /* synthetic */ F20[] a() {
        return new F20[]{a, b, c, d, e};
    }

    public static F20 valueOf(String str) {
        return (F20) Enum.valueOf(F20.class, str);
    }

    public static F20[] values() {
        return (F20[]) f.clone();
    }
}
