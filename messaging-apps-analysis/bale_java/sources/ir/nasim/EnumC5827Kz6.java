package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Kz6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC5827Kz6 {
    public static final EnumC5827Kz6 b = new EnumC5827Kz6("REQUEST_ADD_TO_HOME_SCREEN", 0, 1);
    public static final EnumC5827Kz6 c = new EnumC5827Kz6("OPEN_CHAT_SHORTCUT", 1, 2);
    public static final EnumC5827Kz6 d = new EnumC5827Kz6("ADDED_TO_HOME_SCREEN", 2, 3);
    private static final /* synthetic */ EnumC5827Kz6[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        EnumC5827Kz6[] enumC5827Kz6ArrA = a();
        e = enumC5827Kz6ArrA;
        f = G92.a(enumC5827Kz6ArrA);
    }

    private EnumC5827Kz6(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC5827Kz6[] a() {
        return new EnumC5827Kz6[]{b, c, d};
    }

    public static EnumC5827Kz6 valueOf(String str) {
        return (EnumC5827Kz6) Enum.valueOf(EnumC5827Kz6.class, str);
    }

    public static EnumC5827Kz6[] values() {
        return (EnumC5827Kz6[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
