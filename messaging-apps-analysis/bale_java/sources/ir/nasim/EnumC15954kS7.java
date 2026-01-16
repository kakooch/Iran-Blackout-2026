package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.kS7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC15954kS7 {
    public static final EnumC15954kS7 a = new EnumC15954kS7("Up", 0);
    public static final EnumC15954kS7 b = new EnumC15954kS7("Down", 1);
    public static final EnumC15954kS7 c = new EnumC15954kS7("None", 2);
    private static final /* synthetic */ EnumC15954kS7[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC15954kS7[] enumC15954kS7ArrA = a();
        d = enumC15954kS7ArrA;
        e = G92.a(enumC15954kS7ArrA);
    }

    private EnumC15954kS7(String str, int i) {
    }

    private static final /* synthetic */ EnumC15954kS7[] a() {
        return new EnumC15954kS7[]{a, b, c};
    }

    public static EnumC15954kS7 valueOf(String str) {
        return (EnumC15954kS7) Enum.valueOf(EnumC15954kS7.class, str);
    }

    public static EnumC15954kS7[] values() {
        return (EnumC15954kS7[]) d.clone();
    }
}
