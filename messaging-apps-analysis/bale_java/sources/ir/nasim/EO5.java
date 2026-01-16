package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class EO5 {
    public static final EO5 a = new EO5("Restart", 0);
    public static final EO5 b = new EO5("Reverse", 1);
    private static final /* synthetic */ EO5[] c;
    private static final /* synthetic */ F92 d;

    static {
        EO5[] eo5ArrA = a();
        c = eo5ArrA;
        d = G92.a(eo5ArrA);
    }

    private EO5(String str, int i) {
    }

    private static final /* synthetic */ EO5[] a() {
        return new EO5[]{a, b};
    }

    public static EO5 valueOf(String str) {
        return (EO5) Enum.valueOf(EO5.class, str);
    }

    public static EO5[] values() {
        return (EO5[]) c.clone();
    }
}
