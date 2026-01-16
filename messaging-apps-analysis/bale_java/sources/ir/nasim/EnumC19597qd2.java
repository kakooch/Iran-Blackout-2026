package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.qd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC19597qd2 {
    public static final EnumC19597qd2 a = new EnumC19597qd2("IGNORE", 0);
    public static final EnumC19597qd2 b = new EnumC19597qd2("RESPECT_PERFORMANCE", 1);
    public static final EnumC19597qd2 c = new EnumC19597qd2("RESPECT_ALL", 2);
    private static final /* synthetic */ EnumC19597qd2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC19597qd2[] enumC19597qd2ArrA = a();
        d = enumC19597qd2ArrA;
        e = G92.a(enumC19597qd2ArrA);
    }

    private EnumC19597qd2(String str, int i) {
    }

    private static final /* synthetic */ EnumC19597qd2[] a() {
        return new EnumC19597qd2[]{a, b, c};
    }

    public static EnumC19597qd2 valueOf(String str) {
        return (EnumC19597qd2) Enum.valueOf(EnumC19597qd2.class, str);
    }

    public static EnumC19597qd2[] values() {
        return (EnumC19597qd2[]) d.clone();
    }
}
