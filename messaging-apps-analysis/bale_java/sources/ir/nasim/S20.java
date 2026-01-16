package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class S20 {
    public static final S20 a = new S20("NONE", 0);
    public static final S20 b = new S20("FADE", 1);
    private static final /* synthetic */ S20[] c;
    private static final /* synthetic */ F92 d;

    static {
        S20[] s20ArrA = a();
        c = s20ArrA;
        d = G92.a(s20ArrA);
    }

    private S20(String str, int i) {
    }

    private static final /* synthetic */ S20[] a() {
        return new S20[]{a, b};
    }

    public static S20 valueOf(String str) {
        return (S20) Enum.valueOf(S20.class, str);
    }

    public static S20[] values() {
        return (S20[]) c.clone();
    }
}
