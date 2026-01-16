package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class HQ0 {
    public static final HQ0 b = new HQ0("OTHER", 0, 1);
    public static final HQ0 c = new HQ0("MAGAZINE", 1, 2);
    private static final /* synthetic */ HQ0[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        HQ0[] hq0ArrA = a();
        d = hq0ArrA;
        e = G92.a(hq0ArrA);
    }

    private HQ0(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ HQ0[] a() {
        return new HQ0[]{b, c};
    }

    public static HQ0 valueOf(String str) {
        return (HQ0) Enum.valueOf(HQ0.class, str);
    }

    public static HQ0[] values() {
        return (HQ0[]) d.clone();
    }
}
