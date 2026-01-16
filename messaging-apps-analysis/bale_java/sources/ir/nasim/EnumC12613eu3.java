package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.eu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC12613eu3 {
    public static final EnumC12613eu3 a = new EnumC12613eu3("Ltr", 0);
    public static final EnumC12613eu3 b = new EnumC12613eu3("Rtl", 1);
    private static final /* synthetic */ EnumC12613eu3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC12613eu3[] enumC12613eu3ArrA = a();
        c = enumC12613eu3ArrA;
        d = G92.a(enumC12613eu3ArrA);
    }

    private EnumC12613eu3(String str, int i) {
    }

    private static final /* synthetic */ EnumC12613eu3[] a() {
        return new EnumC12613eu3[]{a, b};
    }

    public static EnumC12613eu3 valueOf(String str) {
        return (EnumC12613eu3) Enum.valueOf(EnumC12613eu3.class, str);
    }

    public static EnumC12613eu3[] values() {
        return (EnumC12613eu3[]) c.clone();
    }
}
