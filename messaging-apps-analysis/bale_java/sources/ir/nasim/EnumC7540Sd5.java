package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Sd5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC7540Sd5 {
    public static final EnumC7540Sd5 c = new EnumC7540Sd5("PIN", 0, EnumC23487x03.b, FD5.dialogs_menu_pin);
    public static final EnumC7540Sd5 d = new EnumC7540Sd5("UNPIN", 1, EnumC23487x03.c, FD5.dialogs_menu_un_pin);
    private static final /* synthetic */ EnumC7540Sd5[] e;
    private static final /* synthetic */ F92 f;
    private final EnumC23487x03 a;
    private final int b;

    static {
        EnumC7540Sd5[] enumC7540Sd5ArrA = a();
        e = enumC7540Sd5ArrA;
        f = G92.a(enumC7540Sd5ArrA);
    }

    private EnumC7540Sd5(String str, int i, EnumC23487x03 enumC23487x03, int i2) {
        this.a = enumC23487x03;
        this.b = i2;
    }

    private static final /* synthetic */ EnumC7540Sd5[] a() {
        return new EnumC7540Sd5[]{c, d};
    }

    public static EnumC7540Sd5 valueOf(String str) {
        return (EnumC7540Sd5) Enum.valueOf(EnumC7540Sd5.class, str);
    }

    public static EnumC7540Sd5[] values() {
        return (EnumC7540Sd5[]) e.clone();
    }

    public final int j() {
        return this.b;
    }

    public final EnumC23487x03 p() {
        return this.a;
    }
}
