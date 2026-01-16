package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.mT2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC17140mT2 {
    public static final EnumC17140mT2 a = new EnumC17140mT2("None", 0);
    public static final EnumC17140mT2 b = new EnumC17140mT2("Selection", 1);
    public static final EnumC17140mT2 c = new EnumC17140mT2("Cursor", 2);
    private static final /* synthetic */ EnumC17140mT2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC17140mT2[] enumC17140mT2ArrA = a();
        d = enumC17140mT2ArrA;
        e = G92.a(enumC17140mT2ArrA);
    }

    private EnumC17140mT2(String str, int i) {
    }

    private static final /* synthetic */ EnumC17140mT2[] a() {
        return new EnumC17140mT2[]{a, b, c};
    }

    public static EnumC17140mT2 valueOf(String str) {
        return (EnumC17140mT2) Enum.valueOf(EnumC17140mT2.class, str);
    }

    public static EnumC17140mT2[] values() {
        return (EnumC17140mT2[]) d.clone();
    }
}
