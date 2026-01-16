package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.wM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC23107wM5 {
    public static final EnumC23107wM5 c;
    public static final EnumC23107wM5 d;
    public static final EnumC23107wM5 e;
    public static final EnumC23107wM5 f;
    public static final EnumC23107wM5 g;
    public static final EnumC23107wM5 h;
    public static final EnumC23107wM5 i;
    private static final /* synthetic */ EnumC23107wM5[] j;
    private static final /* synthetic */ F92 k;
    private final int a;
    private final int b;

    static {
        int i2 = 2;
        c = new EnumC23107wM5("IGNORE_CASE", 0, i2, 0, 2, null);
        int i3 = 2;
        ED1 ed1 = null;
        int i4 = 0;
        d = new EnumC23107wM5("MULTILINE", 1, 8, i4, i3, ed1);
        int i5 = 2;
        ED1 ed12 = null;
        int i6 = 0;
        e = new EnumC23107wM5("LITERAL", i2, 16, i6, i5, ed12);
        f = new EnumC23107wM5("UNIX_LINES", 3, 1, i4, i3, ed1);
        g = new EnumC23107wM5("COMMENTS", 4, 4, i6, i5, ed12);
        h = new EnumC23107wM5("DOT_MATCHES_ALL", 5, 32, i4, i3, ed1);
        i = new EnumC23107wM5("CANON_EQ", 6, 128, i6, i5, ed12);
        EnumC23107wM5[] enumC23107wM5ArrA = a();
        j = enumC23107wM5ArrA;
        k = G92.a(enumC23107wM5ArrA);
    }

    private EnumC23107wM5(String str, int i2, int i3, int i4) {
        this.a = i3;
        this.b = i4;
    }

    private static final /* synthetic */ EnumC23107wM5[] a() {
        return new EnumC23107wM5[]{c, d, e, f, g, h, i};
    }

    public static EnumC23107wM5 valueOf(String str) {
        return (EnumC23107wM5) Enum.valueOf(EnumC23107wM5.class, str);
    }

    public static EnumC23107wM5[] values() {
        return (EnumC23107wM5[]) j.clone();
    }

    public int j() {
        return this.a;
    }

    /* synthetic */ EnumC23107wM5(String str, int i2, int i3, int i4, int i5, ED1 ed1) {
        this(str, i2, i3, (i5 & 2) != 0 ? i3 : i4);
    }
}
