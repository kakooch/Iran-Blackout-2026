package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.uM, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC21915uM {
    public static final EnumC21915uM a = new EnumC21915uM("HALF_X", 0);
    public static final EnumC21915uM b = new EnumC21915uM("ONE_X", 1);
    public static final EnumC21915uM c = new EnumC21915uM("ONE_AND_HALF_X", 2);
    public static final EnumC21915uM d = new EnumC21915uM("TWO_X", 3);
    private static final /* synthetic */ EnumC21915uM[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC21915uM[] enumC21915uMArrA = a();
        e = enumC21915uMArrA;
        f = G92.a(enumC21915uMArrA);
    }

    private EnumC21915uM(String str, int i) {
    }

    private static final /* synthetic */ EnumC21915uM[] a() {
        return new EnumC21915uM[]{a, b, c, d};
    }

    public static EnumC21915uM valueOf(String str) {
        return (EnumC21915uM) Enum.valueOf(EnumC21915uM.class, str);
    }

    public static EnumC21915uM[] values() {
        return (EnumC21915uM[]) e.clone();
    }
}
