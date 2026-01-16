package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.sC4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC20553sC4 {
    public static final EnumC20553sC4 a = new EnumC20553sC4("Title", 0);
    public static final EnumC20553sC4 b = new EnumC20553sC4("Image", 1);
    public static final EnumC20553sC4 c = new EnumC20553sC4("Animation", 2);
    private static final /* synthetic */ EnumC20553sC4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC20553sC4[] enumC20553sC4ArrA = a();
        d = enumC20553sC4ArrA;
        e = G92.a(enumC20553sC4ArrA);
    }

    private EnumC20553sC4(String str, int i) {
    }

    private static final /* synthetic */ EnumC20553sC4[] a() {
        return new EnumC20553sC4[]{a, b, c};
    }

    public static EnumC20553sC4 valueOf(String str) {
        return (EnumC20553sC4) Enum.valueOf(EnumC20553sC4.class, str);
    }

    public static EnumC20553sC4[] values() {
        return (EnumC20553sC4[]) d.clone();
    }
}
