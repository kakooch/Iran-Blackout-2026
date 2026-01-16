package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.nU1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC17739nU1 {
    public static final EnumC17739nU1 a = new EnumC17739nU1("ALL", 0);
    public static final EnumC17739nU1 b = new EnumC17739nU1("STORE_CHANNEL", 1);
    public static final EnumC17739nU1 c = new EnumC17739nU1("CONTENT_CHANNEL", 2);
    private static final /* synthetic */ EnumC17739nU1[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC17739nU1[] enumC17739nU1ArrA = a();
        d = enumC17739nU1ArrA;
        e = G92.a(enumC17739nU1ArrA);
    }

    private EnumC17739nU1(String str, int i) {
    }

    private static final /* synthetic */ EnumC17739nU1[] a() {
        return new EnumC17739nU1[]{a, b, c};
    }

    public static EnumC17739nU1 valueOf(String str) {
        return (EnumC17739nU1) Enum.valueOf(EnumC17739nU1.class, str);
    }

    public static EnumC17739nU1[] values() {
        return (EnumC17739nU1[]) d.clone();
    }
}
