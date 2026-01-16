package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.cG4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC10827cG4 {
    public static final EnumC10827cG4 b = new EnumC10827cG4("FORGET_PASSWORD", 0, AbstractC24800zD5.features_authenticator_forgot_password_appbar);
    public static final EnumC10827cG4 c = new EnumC10827cG4("AUTHORIZE_USER_SET_PASSWORD", 1, AbstractC24800zD5.features_authenticator_authorize_user_appbar);
    public static final EnumC10827cG4 d = new EnumC10827cG4("AUTHORIZE_USER_VALIDATE_SESSION", 2, AbstractC24800zD5.features_authenticator_authorize_user_appbar);
    private static final /* synthetic */ EnumC10827cG4[] e;
    private static final /* synthetic */ F92 f;
    private final int a;

    static {
        EnumC10827cG4[] enumC10827cG4ArrA = a();
        e = enumC10827cG4ArrA;
        f = G92.a(enumC10827cG4ArrA);
    }

    private EnumC10827cG4(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC10827cG4[] a() {
        return new EnumC10827cG4[]{b, c, d};
    }

    public static EnumC10827cG4 valueOf(String str) {
        return (EnumC10827cG4) Enum.valueOf(EnumC10827cG4.class, str);
    }

    public static EnumC10827cG4[] values() {
        return (EnumC10827cG4[]) e.clone();
    }

    public final int j() {
        return this.a;
    }
}
