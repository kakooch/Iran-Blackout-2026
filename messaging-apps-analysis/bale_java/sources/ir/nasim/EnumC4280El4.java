package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.El4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC4280El4 {
    public static final EnumC4280El4 a = new EnumC4280El4("UNKNOWN", 0);
    public static final EnumC4280El4 b = new EnumC4280El4("JOINED", 1);
    public static final EnumC4280El4 c = new EnumC4280El4("MISSED", 2);
    private static final /* synthetic */ EnumC4280El4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC4280El4[] enumC4280El4ArrA = a();
        d = enumC4280El4ArrA;
        e = G92.a(enumC4280El4ArrA);
    }

    private EnumC4280El4(String str, int i) {
    }

    private static final /* synthetic */ EnumC4280El4[] a() {
        return new EnumC4280El4[]{a, b, c};
    }

    public static EnumC4280El4 valueOf(String str) {
        return (EnumC4280El4) Enum.valueOf(EnumC4280El4.class, str);
    }

    public static EnumC4280El4[] values() {
        return (EnumC4280El4[]) d.clone();
    }
}
