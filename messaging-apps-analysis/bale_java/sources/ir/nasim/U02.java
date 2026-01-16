package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class U02 {
    public static final U02 a = new U02("Closed", 0);
    public static final U02 b = new U02("Open", 1);
    private static final /* synthetic */ U02[] c;
    private static final /* synthetic */ F92 d;

    static {
        U02[] u02ArrA = a();
        c = u02ArrA;
        d = G92.a(u02ArrA);
    }

    private U02(String str, int i) {
    }

    private static final /* synthetic */ U02[] a() {
        return new U02[]{a, b};
    }

    public static U02 valueOf(String str) {
        return (U02) Enum.valueOf(U02.class, str);
    }

    public static U02[] values() {
        return (U02[]) c.clone();
    }
}
