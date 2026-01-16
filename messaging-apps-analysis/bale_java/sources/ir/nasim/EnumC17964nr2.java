package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.nr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC17964nr2 {
    public static final EnumC17964nr2 a = new EnumC17964nr2("GIFT_PACKET", 0);
    public static final EnumC17964nr2 b = new EnumC17964nr2("MONEY_REQUEST", 1);
    public static final EnumC17964nr2 c = new EnumC17964nr2("CROWDFUNDING", 2);
    private static final /* synthetic */ EnumC17964nr2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC17964nr2[] enumC17964nr2ArrA = a();
        d = enumC17964nr2ArrA;
        e = G92.a(enumC17964nr2ArrA);
    }

    private EnumC17964nr2(String str, int i) {
    }

    private static final /* synthetic */ EnumC17964nr2[] a() {
        return new EnumC17964nr2[]{a, b, c};
    }

    public static EnumC17964nr2 valueOf(String str) {
        return (EnumC17964nr2) Enum.valueOf(EnumC17964nr2.class, str);
    }

    public static EnumC17964nr2[] values() {
        return (EnumC17964nr2[]) d.clone();
    }
}
