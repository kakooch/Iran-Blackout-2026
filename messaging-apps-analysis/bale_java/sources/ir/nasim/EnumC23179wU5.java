package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wU5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC23179wU5 {
    public static final EnumC23179wU5 a = new EnumC23179wU5("PERMISSION_REQUESTED", 0);
    public static final EnumC23179wU5 b = new EnumC23179wU5("SENT_TO_SETTINGS", 1);
    public static final EnumC23179wU5 c = new EnumC23179wU5("CANCELED_BY_USER", 2);
    public static final EnumC23179wU5 d = new EnumC23179wU5("NOT_NEEDED", 3);
    private static final /* synthetic */ EnumC23179wU5[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC23179wU5[] enumC23179wU5ArrA = a();
        e = enumC23179wU5ArrA;
        f = G92.a(enumC23179wU5ArrA);
    }

    private EnumC23179wU5(String str, int i) {
    }

    private static final /* synthetic */ EnumC23179wU5[] a() {
        return new EnumC23179wU5[]{a, b, c, d};
    }

    public static EnumC23179wU5 valueOf(String str) {
        return (EnumC23179wU5) Enum.valueOf(EnumC23179wU5.class, str);
    }

    public static EnumC23179wU5[] values() {
        return (EnumC23179wU5[]) e.clone();
    }
}
