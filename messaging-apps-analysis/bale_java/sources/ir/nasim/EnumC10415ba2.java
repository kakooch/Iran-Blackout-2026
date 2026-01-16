package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.ba2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC10415ba2 {
    public static final EnumC10415ba2 a = new EnumC10415ba2("VALIDATION_CODE", 0);
    public static final EnumC10415ba2 b = new EnumC10415ba2("PHONE_AUTH", 1);
    public static final EnumC10415ba2 c = new EnumC10415ba2("COMPLETE_AUTH", 2);
    public static final EnumC10415ba2 d = new EnumC10415ba2("SIGN_UP", 3);
    private static final /* synthetic */ EnumC10415ba2[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC10415ba2[] enumC10415ba2ArrA = a();
        e = enumC10415ba2ArrA;
        f = G92.a(enumC10415ba2ArrA);
    }

    private EnumC10415ba2(String str, int i) {
    }

    private static final /* synthetic */ EnumC10415ba2[] a() {
        return new EnumC10415ba2[]{a, b, c, d};
    }

    public static EnumC10415ba2 valueOf(String str) {
        return (EnumC10415ba2) Enum.valueOf(EnumC10415ba2.class, str);
    }

    public static EnumC10415ba2[] values() {
        return (EnumC10415ba2[]) e.clone();
    }
}
