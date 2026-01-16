package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.jy7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC15673jy7 {
    public static final EnumC15673jy7 a = new EnumC15673jy7("MEDIA", 0);
    public static final EnumC15673jy7 b = new EnumC15673jy7("STICKER", 1);
    public static final EnumC15673jy7 c = new EnumC15673jy7("BOTH", 2);
    private static final /* synthetic */ EnumC15673jy7[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC15673jy7[] enumC15673jy7ArrA = a();
        d = enumC15673jy7ArrA;
        e = G92.a(enumC15673jy7ArrA);
    }

    private EnumC15673jy7(String str, int i) {
    }

    private static final /* synthetic */ EnumC15673jy7[] a() {
        return new EnumC15673jy7[]{a, b, c};
    }

    public static EnumC15673jy7 valueOf(String str) {
        return (EnumC15673jy7) Enum.valueOf(EnumC15673jy7.class, str);
    }

    public static EnumC15673jy7[] values() {
        return (EnumC15673jy7[]) d.clone();
    }
}
