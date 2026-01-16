package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.i05, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC14492i05 {
    public static final EnumC14492i05 a = new EnumC14492i05("TEXT", 0);
    public static final EnumC14492i05 b = new EnumC14492i05("NUMERIC", 1);
    public static final EnumC14492i05 c = new EnumC14492i05("MULTILINE_TEXT", 2);
    private static final /* synthetic */ EnumC14492i05[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC14492i05[] enumC14492i05ArrA = a();
        d = enumC14492i05ArrA;
        e = G92.a(enumC14492i05ArrA);
    }

    private EnumC14492i05(String str, int i) {
    }

    private static final /* synthetic */ EnumC14492i05[] a() {
        return new EnumC14492i05[]{a, b, c};
    }

    public static EnumC14492i05 valueOf(String str) {
        return (EnumC14492i05) Enum.valueOf(EnumC14492i05.class, str);
    }

    public static EnumC14492i05[] values() {
        return (EnumC14492i05[]) d.clone();
    }
}
