package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.vh3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC22705vh3 {
    public static final EnumC22705vh3 a = new EnumC22705vh3("MARKET", 0);
    public static final EnumC22705vh3 b = new EnumC22705vh3("DISCOVER", 1);
    public static final EnumC22705vh3 c = new EnumC22705vh3("FEED", 2);
    private static final /* synthetic */ EnumC22705vh3[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC22705vh3[] enumC22705vh3ArrA = a();
        d = enumC22705vh3ArrA;
        e = G92.a(enumC22705vh3ArrA);
    }

    private EnumC22705vh3(String str, int i) {
    }

    private static final /* synthetic */ EnumC22705vh3[] a() {
        return new EnumC22705vh3[]{a, b, c};
    }

    public static EnumC22705vh3 valueOf(String str) {
        return (EnumC22705vh3) Enum.valueOf(EnumC22705vh3.class, str);
    }

    public static EnumC22705vh3[] values() {
        return (EnumC22705vh3[]) d.clone();
    }
}
