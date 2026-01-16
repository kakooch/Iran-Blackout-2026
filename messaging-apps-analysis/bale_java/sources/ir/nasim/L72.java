package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class L72 {
    public static final L72 b = new L72("DIALOG_LIST", 0, 1);
    public static final L72 c = new L72("CONTACTS", 1, 3);
    private static final /* synthetic */ L72[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        L72[] l72ArrA = a();
        d = l72ArrA;
        e = G92.a(l72ArrA);
    }

    private L72(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ L72[] a() {
        return new L72[]{b, c};
    }

    public static L72 valueOf(String str) {
        return (L72) Enum.valueOf(L72.class, str);
    }

    public static L72[] values() {
        return (L72[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
