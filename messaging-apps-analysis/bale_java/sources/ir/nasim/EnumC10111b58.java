package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.b58, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC10111b58 {
    public static final a b;
    public static final EnumC10111b58 c = new EnumC10111b58("SETTING_BUTTON_PRESSED", 0, "settings_button_pressed");
    public static final EnumC10111b58 d = new EnumC10111b58("PHONE_REQUESTED", 1, "phone_requested");
    public static final EnumC10111b58 e = new EnumC10111b58("HOME_SCREEN_ADDED", 2, "home_screen_added");
    public static final EnumC10111b58 f = new EnumC10111b58("HOME_SCREEN_CHECKED", 3, "home_screen_checked");
    public static final EnumC10111b58 g = new EnumC10111b58("HOME_SCREEN_FAILED", 4, "home_screen_failed");
    public static final EnumC10111b58 h = new EnumC10111b58("BACK_BUTTON_PRESSED", 5, "back_button_pressed");
    public static final EnumC10111b58 i = new EnumC10111b58("CUSTOM_METHOD_INVOKED", 6, "custom_method_invoked");
    public static final EnumC10111b58 j = new EnumC10111b58("QR_SCAN_RECEIVED", 7, "qr_text_received");
    public static final EnumC10111b58 k = new EnumC10111b58("QR_SCAN_CLOSED", 8, "scan_qr_popup_closed");
    public static final EnumC10111b58 l = new EnumC10111b58("ACTIVATE", 9, "activated");
    public static final EnumC10111b58 m = new EnumC10111b58("DEACTIVATED", 10, "deactivated");
    private static final /* synthetic */ EnumC10111b58[] n;
    private static final /* synthetic */ F92 o;
    private final String a;

    /* renamed from: ir.nasim.b58$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC10111b58[] enumC10111b58ArrA = a();
        n = enumC10111b58ArrA;
        o = G92.a(enumC10111b58ArrA);
        b = new a(null);
    }

    private EnumC10111b58(String str, int i2, String str2) {
        this.a = str2;
    }

    private static final /* synthetic */ EnumC10111b58[] a() {
        return new EnumC10111b58[]{c, d, e, f, g, h, i, j, k, l, m};
    }

    public static EnumC10111b58 valueOf(String str) {
        return (EnumC10111b58) Enum.valueOf(EnumC10111b58.class, str);
    }

    public static EnumC10111b58[] values() {
        return (EnumC10111b58[]) n.clone();
    }

    public final String j() {
        return this.a;
    }
}
