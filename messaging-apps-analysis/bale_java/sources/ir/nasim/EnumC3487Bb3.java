package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Bb3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC3487Bb3 {
    public static final EnumC3487Bb3 b = new EnumC3487Bb3("SEND_DATA", 0, 1);
    public static final EnumC3487Bb3 c = new EnumC3487Bb3("OPEN_URL", 1, 2);
    public static final EnumC3487Bb3 d = new EnumC3487Bb3("AUTHENTICATION", 2, 3);
    public static final EnumC3487Bb3 e = new EnumC3487Bb3("OPEN_WEB_APP", 3, 4);
    public static final EnumC3487Bb3 f = new EnumC3487Bb3("COPY_TEXT", 4, 5);
    public static final EnumC3487Bb3 g = new EnumC3487Bb3("CUSTOM_ACTION", 5, 6);
    public static final EnumC3487Bb3 h = new EnumC3487Bb3("UNSUPPORTED", 6, 7);
    private static final /* synthetic */ EnumC3487Bb3[] i;
    private static final /* synthetic */ F92 j;
    private final int a;

    static {
        EnumC3487Bb3[] enumC3487Bb3ArrA = a();
        i = enumC3487Bb3ArrA;
        j = G92.a(enumC3487Bb3ArrA);
    }

    private EnumC3487Bb3(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC3487Bb3[] a() {
        return new EnumC3487Bb3[]{b, c, d, e, f, g, h};
    }

    public static EnumC3487Bb3 valueOf(String str) {
        return (EnumC3487Bb3) Enum.valueOf(EnumC3487Bb3.class, str);
    }

    public static EnumC3487Bb3[] values() {
        return (EnumC3487Bb3[]) i.clone();
    }

    public final int j() {
        return this.a;
    }
}
