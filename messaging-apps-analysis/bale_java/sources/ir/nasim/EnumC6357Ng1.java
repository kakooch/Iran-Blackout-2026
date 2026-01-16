package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Ng1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC6357Ng1 {
    public static final EnumC6357Ng1 a = new EnumC6357Ng1("ADD_MEMBER", 0);
    public static final EnumC6357Ng1 b = new EnumC6357Ng1("ADD_ADMIN", 1);
    public static final EnumC6357Ng1 c = new EnumC6357Ng1("CREATE_GROUP_CHANNEL", 2);
    private static final /* synthetic */ EnumC6357Ng1[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC6357Ng1[] enumC6357Ng1ArrA = a();
        d = enumC6357Ng1ArrA;
        e = G92.a(enumC6357Ng1ArrA);
    }

    private EnumC6357Ng1(String str, int i) {
    }

    private static final /* synthetic */ EnumC6357Ng1[] a() {
        return new EnumC6357Ng1[]{a, b, c};
    }

    public static EnumC6357Ng1 valueOf(String str) {
        return (EnumC6357Ng1) Enum.valueOf(EnumC6357Ng1.class, str);
    }

    public static EnumC6357Ng1[] values() {
        return (EnumC6357Ng1[]) d.clone();
    }
}
