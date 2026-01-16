package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class P25 {
    public static final P25 a = new P25("DIALOGS", 0);
    public static final P25 b = new P25("VITRINE", 1);
    public static final P25 c = new P25("MARKET", 2);
    public static final P25 d = new P25("PRIVACY_BAR", 3);
    private static final /* synthetic */ P25[] e;
    private static final /* synthetic */ F92 f;

    static {
        P25[] p25ArrA = a();
        e = p25ArrA;
        f = G92.a(p25ArrA);
    }

    private P25(String str, int i) {
    }

    private static final /* synthetic */ P25[] a() {
        return new P25[]{a, b, c, d};
    }

    public static P25 valueOf(String str) {
        return (P25) Enum.valueOf(P25.class, str);
    }

    public static P25[] values() {
        return (P25[]) e.clone();
    }
}
