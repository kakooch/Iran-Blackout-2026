package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.kI1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC15858kI1 {
    public static final EnumC15858kI1 a = new EnumC15858kI1("WARNING", 0);
    public static final EnumC15858kI1 b = new EnumC15858kI1("ERROR", 1);
    public static final EnumC15858kI1 c = new EnumC15858kI1("HIDDEN", 2);
    private static final /* synthetic */ EnumC15858kI1[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC15858kI1[] enumC15858kI1ArrA = a();
        d = enumC15858kI1ArrA;
        e = G92.a(enumC15858kI1ArrA);
    }

    private EnumC15858kI1(String str, int i) {
    }

    private static final /* synthetic */ EnumC15858kI1[] a() {
        return new EnumC15858kI1[]{a, b, c};
    }

    public static EnumC15858kI1 valueOf(String str) {
        return (EnumC15858kI1) Enum.valueOf(EnumC15858kI1.class, str);
    }

    public static EnumC15858kI1[] values() {
        return (EnumC15858kI1[]) d.clone();
    }
}
