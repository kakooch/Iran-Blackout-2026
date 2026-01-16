package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class MM1 {
    public static final MM1 a = new MM1("PIN", 0);
    private static final /* synthetic */ MM1[] b;
    private static final /* synthetic */ F92 c;

    static {
        MM1[] mm1ArrA = a();
        b = mm1ArrA;
        c = G92.a(mm1ArrA);
    }

    private MM1(String str, int i) {
    }

    private static final /* synthetic */ MM1[] a() {
        return new MM1[]{a};
    }

    public static MM1 valueOf(String str) {
        return (MM1) Enum.valueOf(MM1.class, str);
    }

    public static MM1[] values() {
        return (MM1[]) b.clone();
    }
}
