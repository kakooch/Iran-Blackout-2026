package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Xg3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC8772Xg3 {
    public static final EnumC8772Xg3 b = new EnumC8772Xg3("ANY", 0, 1);
    public static final EnumC8772Xg3 c = new EnumC8772Xg3("PHOTO", 1, 2);
    public static final EnumC8772Xg3 d = new EnumC8772Xg3("CHANNEL", 2, 3);
    private static final /* synthetic */ EnumC8772Xg3[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        EnumC8772Xg3[] enumC8772Xg3ArrA = a();
        e = enumC8772Xg3ArrA;
        f = G92.a(enumC8772Xg3ArrA);
    }

    private EnumC8772Xg3(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC8772Xg3[] a() {
        return new EnumC8772Xg3[]{b, c, d};
    }

    public static EnumC8772Xg3 valueOf(String str) {
        return (EnumC8772Xg3) Enum.valueOf(EnumC8772Xg3.class, str);
    }

    public static EnumC8772Xg3[] values() {
        return (EnumC8772Xg3[]) e.clone();
    }
}
