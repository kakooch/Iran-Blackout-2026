package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class DL4 {
    public static final DL4 a = new DL4("GENERATE_LINK", 0);
    public static final DL4 b = new DL4("START_GROUP_CALL", 1);
    private static final /* synthetic */ DL4[] c;
    private static final /* synthetic */ F92 d;

    static {
        DL4[] dl4ArrA = a();
        c = dl4ArrA;
        d = G92.a(dl4ArrA);
    }

    private DL4(String str, int i) {
    }

    private static final /* synthetic */ DL4[] a() {
        return new DL4[]{a, b};
    }

    public static DL4 valueOf(String str) {
        return (DL4) Enum.valueOf(DL4.class, str);
    }

    public static DL4[] values() {
        return (DL4[]) c.clone();
    }
}
