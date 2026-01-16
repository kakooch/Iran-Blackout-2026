package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.hL4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC14097hL4 {
    public static final EnumC14097hL4 a = new EnumC14097hL4("FROM_MY_BANK", 0);
    public static final EnumC14097hL4 b = new EnumC14097hL4("FROM_SAPTA", 1);
    public static final EnumC14097hL4 c = new EnumC14097hL4("FROM_PUSH", 2);
    public static final EnumC14097hL4 d = new EnumC14097hL4("FROM_SAPTA_MESSAGE", 3);
    private static final /* synthetic */ EnumC14097hL4[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC14097hL4[] enumC14097hL4ArrA = a();
        e = enumC14097hL4ArrA;
        f = G92.a(enumC14097hL4ArrA);
    }

    private EnumC14097hL4(String str, int i) {
    }

    private static final /* synthetic */ EnumC14097hL4[] a() {
        return new EnumC14097hL4[]{a, b, c, d};
    }

    public static EnumC14097hL4 valueOf(String str) {
        return (EnumC14097hL4) Enum.valueOf(EnumC14097hL4.class, str);
    }

    public static EnumC14097hL4[] values() {
        return (EnumC14097hL4[]) e.clone();
    }
}
