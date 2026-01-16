package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.kq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC16185kq6 {
    public static final EnumC16185kq6 b = new EnumC16185kq6("CONTACTS_PERMISSION_EVENT_IGNORE", 0, 0);
    public static final EnumC16185kq6 c = new EnumC16185kq6("CONTACTS_PERMISSION_EVENT_ACCEPT", 1, 1);
    public static final EnumC16185kq6 d = new EnumC16185kq6("CONTACTS_PERMISSION_EVENT_PERMIT", 2, 2);
    private static final /* synthetic */ EnumC16185kq6[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        EnumC16185kq6[] enumC16185kq6ArrA = a();
        e = enumC16185kq6ArrA;
        f = G92.a(enumC16185kq6ArrA);
    }

    private EnumC16185kq6(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC16185kq6[] a() {
        return new EnumC16185kq6[]{b, c, d};
    }

    public static EnumC16185kq6 valueOf(String str) {
        return (EnumC16185kq6) Enum.valueOf(EnumC16185kq6.class, str);
    }

    public static EnumC16185kq6[] values() {
        return (EnumC16185kq6[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
