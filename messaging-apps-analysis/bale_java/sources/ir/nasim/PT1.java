package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class PT1 {
    public static final PT1 a = new PT1("Vertical", 0);
    public static final PT1 b = new PT1("Horizontal", 1);
    public static final PT1 c = new PT1("Both", 2);
    private static final /* synthetic */ PT1[] d;
    private static final /* synthetic */ F92 e;

    static {
        PT1[] pt1ArrA = a();
        d = pt1ArrA;
        e = G92.a(pt1ArrA);
    }

    private PT1(String str, int i) {
    }

    private static final /* synthetic */ PT1[] a() {
        return new PT1[]{a, b, c};
    }

    public static PT1 valueOf(String str) {
        return (PT1) Enum.valueOf(PT1.class, str);
    }

    public static PT1[] values() {
        return (PT1[]) d.clone();
    }
}
