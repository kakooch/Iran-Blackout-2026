package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class AY4 {
    public static final AY4 a = new AY4("WITH_BACKGROUND", 0);
    public static final AY4 b = new AY4("WITHOUT_BACKGROUND", 1);
    public static final AY4 c = new AY4("SUBMIT_BUTTON", 2);
    private static final /* synthetic */ AY4[] d;
    private static final /* synthetic */ F92 e;

    static {
        AY4[] ay4ArrA = a();
        d = ay4ArrA;
        e = G92.a(ay4ArrA);
    }

    private AY4(String str, int i) {
    }

    private static final /* synthetic */ AY4[] a() {
        return new AY4[]{a, b, c};
    }

    public static AY4 valueOf(String str) {
        return (AY4) Enum.valueOf(AY4.class, str);
    }

    public static AY4[] values() {
        return (AY4[]) d.clone();
    }
}
