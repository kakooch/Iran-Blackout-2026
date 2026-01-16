package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class C86 {
    public static final C86 a = new C86("MAIN", 0);
    public static final C86 b = new C86("FILES", 1);
    private static final /* synthetic */ C86[] c;
    private static final /* synthetic */ F92 d;

    static {
        C86[] c86ArrA = a();
        c = c86ArrA;
        d = G92.a(c86ArrA);
    }

    private C86(String str, int i) {
    }

    private static final /* synthetic */ C86[] a() {
        return new C86[]{a, b};
    }

    public static C86 valueOf(String str) {
        return (C86) Enum.valueOf(C86.class, str);
    }

    public static C86[] values() {
        return (C86[]) c.clone();
    }
}
