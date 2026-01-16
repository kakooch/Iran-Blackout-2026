package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ot3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class EnumC18576ot3 {
    public static final EnumC18576ot3 b = new EnumC18576ot3("FARSI", 0, "fa");
    public static final EnumC18576ot3 c = new EnumC18576ot3("ENGLISH", 1, "en");
    public static final EnumC18576ot3 d = new EnumC18576ot3("ARABIC", 2, "ar");
    public static final EnumC18576ot3 e = new EnumC18576ot3("TORKI", 3, "ks");
    private static final /* synthetic */ EnumC18576ot3[] f;
    private static final /* synthetic */ F92 g;
    private final String a;

    static {
        EnumC18576ot3[] enumC18576ot3ArrA = a();
        f = enumC18576ot3ArrA;
        g = G92.a(enumC18576ot3ArrA);
    }

    private EnumC18576ot3(String str, int i, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC18576ot3[] a() {
        return new EnumC18576ot3[]{b, c, d, e};
    }

    public static EnumC18576ot3 valueOf(String str) {
        return (EnumC18576ot3) Enum.valueOf(EnumC18576ot3.class, str);
    }

    public static EnumC18576ot3[] values() {
        return (EnumC18576ot3[]) f.clone();
    }

    public final String j() {
        return this.a;
    }
}
