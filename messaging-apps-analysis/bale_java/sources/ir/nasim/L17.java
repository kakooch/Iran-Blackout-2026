package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class L17 {
    public static final L17 b = new L17("RECENTLY", 0, 1);
    public static final L17 c = new L17("POPULAR", 1, 2);
    private static final /* synthetic */ L17[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        L17[] l17ArrA = a();
        d = l17ArrA;
        e = G92.a(l17ArrA);
    }

    private L17(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ L17[] a() {
        return new L17[]{b, c};
    }

    public static L17 valueOf(String str) {
        return (L17) Enum.valueOf(L17.class, str);
    }

    public static L17[] values() {
        return (L17[]) d.clone();
    }
}
