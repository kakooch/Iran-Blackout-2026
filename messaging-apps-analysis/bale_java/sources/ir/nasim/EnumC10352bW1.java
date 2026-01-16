package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.bW1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC10352bW1 {
    public static final EnumC10352bW1 a = new EnumC10352bW1("LARGE", 0);
    public static final EnumC10352bW1 b = new EnumC10352bW1("MEDIUM", 1);
    public static final EnumC10352bW1 c = new EnumC10352bW1("NORMAL", 2);
    public static final EnumC10352bW1 d = new EnumC10352bW1("SMALL", 3);
    private static final /* synthetic */ EnumC10352bW1[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC10352bW1[] enumC10352bW1ArrA = a();
        e = enumC10352bW1ArrA;
        f = G92.a(enumC10352bW1ArrA);
    }

    private EnumC10352bW1(String str, int i) {
    }

    private static final /* synthetic */ EnumC10352bW1[] a() {
        return new EnumC10352bW1[]{a, b, c, d};
    }

    public static EnumC10352bW1 valueOf(String str) {
        return (EnumC10352bW1) Enum.valueOf(EnumC10352bW1.class, str);
    }

    public static EnumC10352bW1[] values() {
        return (EnumC10352bW1[]) e.clone();
    }
}
