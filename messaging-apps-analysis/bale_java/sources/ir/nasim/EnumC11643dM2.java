package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.dM2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC11643dM2 {
    public static final EnumC11643dM2 a = new EnumC11643dM2("UNKNOWN", 0);
    public static final EnumC11643dM2 b = new EnumC11643dM2("JOINED", 1);
    public static final EnumC11643dM2 c = new EnumC11643dM2("MISSED", 2);
    private static final /* synthetic */ EnumC11643dM2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC11643dM2[] enumC11643dM2ArrA = a();
        d = enumC11643dM2ArrA;
        e = G92.a(enumC11643dM2ArrA);
    }

    private EnumC11643dM2(String str, int i) {
    }

    private static final /* synthetic */ EnumC11643dM2[] a() {
        return new EnumC11643dM2[]{a, b, c};
    }

    public static EnumC11643dM2 valueOf(String str) {
        return (EnumC11643dM2) Enum.valueOf(EnumC11643dM2.class, str);
    }

    public static EnumC11643dM2[] values() {
        return (EnumC11643dM2[]) d.clone();
    }
}
