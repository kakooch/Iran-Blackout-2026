package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class AW5 {
    public static final AW5 a = new AW5("Ltr", 0);
    public static final AW5 b = new AW5("Rtl", 1);
    private static final /* synthetic */ AW5[] c;
    private static final /* synthetic */ F92 d;

    static {
        AW5[] aw5ArrA = a();
        c = aw5ArrA;
        d = G92.a(aw5ArrA);
    }

    private AW5(String str, int i) {
    }

    private static final /* synthetic */ AW5[] a() {
        return new AW5[]{a, b};
    }

    public static AW5 valueOf(String str) {
        return (AW5) Enum.valueOf(AW5.class, str);
    }

    public static AW5[] values() {
        return (AW5[]) c.clone();
    }
}
