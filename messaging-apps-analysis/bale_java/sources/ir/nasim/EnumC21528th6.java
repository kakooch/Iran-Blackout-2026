package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.th6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC21528th6 {
    public static final EnumC21528th6 a = new EnumC21528th6("None", 0);
    public static final EnumC21528th6 b = new EnumC21528th6("Init", 1);
    public static final EnumC21528th6 c = new EnumC21528th6("Searching", 2);
    public static final EnumC21528th6 d = new EnumC21528th6("SearchResult", 3);
    public static final EnumC21528th6 e = new EnumC21528th6("SelectSenderId", 4);
    private static final /* synthetic */ EnumC21528th6[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC21528th6[] enumC21528th6ArrA = a();
        f = enumC21528th6ArrA;
        g = G92.a(enumC21528th6ArrA);
    }

    private EnumC21528th6(String str, int i) {
    }

    private static final /* synthetic */ EnumC21528th6[] a() {
        return new EnumC21528th6[]{a, b, c, d, e};
    }

    public static EnumC21528th6 valueOf(String str) {
        return (EnumC21528th6) Enum.valueOf(EnumC21528th6.class, str);
    }

    public static EnumC21528th6[] values() {
        return (EnumC21528th6[]) f.clone();
    }
}
