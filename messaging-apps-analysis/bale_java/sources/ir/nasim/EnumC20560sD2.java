package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.sD2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC20560sD2 {
    public static final EnumC20560sD2 a = new EnumC20560sD2("SEND_ITEMS_AS_FILE", 0);
    public static final EnumC20560sD2 b = new EnumC20560sD2("SEND_ITEMS_AS_ALBUM", 1);
    public static final EnumC20560sD2 c = new EnumC20560sD2("SEND_ITEMS_SEPARATELY", 2);
    private static final /* synthetic */ EnumC20560sD2[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC20560sD2[] enumC20560sD2ArrA = a();
        d = enumC20560sD2ArrA;
        e = G92.a(enumC20560sD2ArrA);
    }

    private EnumC20560sD2(String str, int i) {
    }

    private static final /* synthetic */ EnumC20560sD2[] a() {
        return new EnumC20560sD2[]{a, b, c};
    }

    public static EnumC20560sD2 valueOf(String str) {
        return (EnumC20560sD2) Enum.valueOf(EnumC20560sD2.class, str);
    }

    public static EnumC20560sD2[] values() {
        return (EnumC20560sD2[]) d.clone();
    }
}
