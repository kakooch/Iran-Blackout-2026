package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Cb3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC3721Cb3 {
    public static final EnumC3721Cb3 b = new EnumC3721Cb3("SEND_MESSAGE", 0, 1);
    public static final EnumC3721Cb3 c = new EnumC3721Cb3("REQUEST_CONTACT", 1, 2);
    public static final EnumC3721Cb3 d = new EnumC3721Cb3("REQUEST_LOCATION", 2, 3);
    public static final EnumC3721Cb3 e = new EnumC3721Cb3("OPEN_WEB_APP", 3, 4);
    public static final EnumC3721Cb3 f = new EnumC3721Cb3("CUSTOM_ACTION", 4, 5);
    public static final EnumC3721Cb3 g = new EnumC3721Cb3("UNSUPPORTED", 5, 6);
    private static final /* synthetic */ EnumC3721Cb3[] h;
    private static final /* synthetic */ F92 i;
    private final int a;

    static {
        EnumC3721Cb3[] enumC3721Cb3ArrA = a();
        h = enumC3721Cb3ArrA;
        i = G92.a(enumC3721Cb3ArrA);
    }

    private EnumC3721Cb3(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC3721Cb3[] a() {
        return new EnumC3721Cb3[]{b, c, d, e, f, g};
    }

    public static EnumC3721Cb3 valueOf(String str) {
        return (EnumC3721Cb3) Enum.valueOf(EnumC3721Cb3.class, str);
    }

    public static EnumC3721Cb3[] values() {
        return (EnumC3721Cb3[]) h.clone();
    }

    public final int j() {
        return this.a;
    }
}
