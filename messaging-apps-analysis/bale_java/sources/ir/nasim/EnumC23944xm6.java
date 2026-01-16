package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.xm6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC23944xm6 {
    public static final EnumC23944xm6 a = new EnumC23944xm6("IS_SELECTED", 0);
    public static final EnumC23944xm6 b = new EnumC23944xm6("IS_IN_SELECT_MODE", 1);
    public static final EnumC23944xm6 c = new EnumC23944xm6("NOT_IN_SELECT_MODE", 2);
    private static final /* synthetic */ EnumC23944xm6[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC23944xm6[] enumC23944xm6ArrA = a();
        d = enumC23944xm6ArrA;
        e = G92.a(enumC23944xm6ArrA);
    }

    private EnumC23944xm6(String str, int i) {
    }

    private static final /* synthetic */ EnumC23944xm6[] a() {
        return new EnumC23944xm6[]{a, b, c};
    }

    public static EnumC23944xm6 valueOf(String str) {
        return (EnumC23944xm6) Enum.valueOf(EnumC23944xm6.class, str);
    }

    public static EnumC23944xm6[] values() {
        return (EnumC23944xm6[]) d.clone();
    }
}
