package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.He5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC4935He5 {
    public static final EnumC4935He5 a = new EnumC4935He5("ALIGNMENT", 0);
    public static final EnumC4935He5 b = new EnumC4935He5("DROPDOWN", 1);
    public static final EnumC4935He5 c = new EnumC4935He5("CENTER", 2);
    private static final /* synthetic */ EnumC4935He5[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC4935He5[] enumC4935He5ArrA = a();
        d = enumC4935He5ArrA;
        e = G92.a(enumC4935He5ArrA);
    }

    private EnumC4935He5(String str, int i) {
    }

    private static final /* synthetic */ EnumC4935He5[] a() {
        return new EnumC4935He5[]{a, b, c};
    }

    public static EnumC4935He5 valueOf(String str) {
        return (EnumC4935He5) Enum.valueOf(EnumC4935He5.class, str);
    }

    public static EnumC4935He5[] values() {
        return (EnumC4935He5[]) d.clone();
    }
}
