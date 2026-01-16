package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.dj5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC11893dj5 {
    public static final EnumC11893dj5 b = new EnumC11893dj5("CLICK", 0, 1);
    public static final EnumC11893dj5 c = new EnumC11893dj5("SEND", 1, 2);
    private static final /* synthetic */ EnumC11893dj5[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        EnumC11893dj5[] enumC11893dj5ArrA = a();
        d = enumC11893dj5ArrA;
        e = G92.a(enumC11893dj5ArrA);
    }

    private EnumC11893dj5(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC11893dj5[] a() {
        return new EnumC11893dj5[]{b, c};
    }

    public static EnumC11893dj5 valueOf(String str) {
        return (EnumC11893dj5) Enum.valueOf(EnumC11893dj5.class, str);
    }

    public static EnumC11893dj5[] values() {
        return (EnumC11893dj5[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
