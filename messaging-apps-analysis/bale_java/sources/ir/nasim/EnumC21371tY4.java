package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.tY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC21371tY4 {
    public static final EnumC21371tY4 a = new EnumC21371tY4("SAVE_DATA", 0);
    public static final EnumC21371tY4 b = new EnumC21371tY4("NEED_TO_UPDATE", 1);
    public static final EnumC21371tY4 c = new EnumC21371tY4("CREATED_PASSPORT", 2);
    private static final /* synthetic */ EnumC21371tY4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC21371tY4[] enumC21371tY4ArrA = a();
        d = enumC21371tY4ArrA;
        e = G92.a(enumC21371tY4ArrA);
    }

    private EnumC21371tY4(String str, int i) {
    }

    private static final /* synthetic */ EnumC21371tY4[] a() {
        return new EnumC21371tY4[]{a, b, c};
    }

    public static EnumC21371tY4 valueOf(String str) {
        return (EnumC21371tY4) Enum.valueOf(EnumC21371tY4.class, str);
    }

    public static EnumC21371tY4[] values() {
        return (EnumC21371tY4[]) d.clone();
    }
}
