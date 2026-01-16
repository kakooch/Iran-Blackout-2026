package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.aY7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC9782aY7 {
    private static final /* synthetic */ EnumC9782aY7[] A;
    private static final /* synthetic */ F92 B;
    public static final EnumC9782aY7 b;
    public static final EnumC9782aY7 c;
    public static final EnumC9782aY7 d;
    public static final EnumC9782aY7 e;
    public static final EnumC9782aY7 f;
    public static final EnumC9782aY7 g;
    public static final EnumC9782aY7 h;
    public static final EnumC9782aY7 i;
    public static final EnumC9782aY7 j;
    public static final EnumC9782aY7 k;
    public static final EnumC9782aY7 l;
    public static final EnumC9782aY7 m;
    public static final EnumC9782aY7 n;
    public static final EnumC9782aY7 o;
    public static final EnumC9782aY7 p;
    public static final EnumC9782aY7 q;
    public static final EnumC9782aY7 r;
    public static final EnumC9782aY7 s;
    public static final EnumC9782aY7 t;
    public static final EnumC9782aY7 u;
    public static final EnumC9782aY7 v;
    public static final EnumC9782aY7 w;
    public static final EnumC9782aY7 x;
    public static final EnumC9782aY7 y;
    public static final EnumC9782aY7 z;
    private final Integer a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        EnumC9782aY7 enumC9782aY7 = new EnumC9782aY7("TEXT", 0, 12);
        b = enumC9782aY7;
        c = new EnumC9782aY7("VOICE", 1, null, 1, null);
        d = new EnumC9782aY7("IMAGE", 2, 10);
        e = new EnumC9782aY7("AUDIO", 3, null, 1, null);
        int i2 = 1;
        ED1 ed1 = null;
        f = new EnumC9782aY7("FILE", 4, null, i2, ed1);
        int i3 = 1;
        Integer num = null;
        g = new EnumC9782aY7("STICKER", 5, num, i3, null == true ? 1 : 0);
        int i4 = 1;
        Integer num2 = null;
        h = new EnumC9782aY7("ANIMATED_STICKER", 6, num2, i4, null == true ? 1 : 0);
        i = new EnumC9782aY7("CALL", 7, num, i3, null == true ? 1 : 0);
        j = new EnumC9782aY7("CONTACT", 8, num2, i4, null == true ? 1 : 0);
        k = new EnumC9782aY7("SERVICE_MESSAGE", 9, 10);
        l = new EnumC9782aY7("LOCATION", 10, null == true ? 1 : 0, 1, null);
        m = new EnumC9782aY7("MONEY_REQUEST", 11, null == true ? 1 : 0, i2, ed1);
        int i5 = 1;
        Integer num3 = null;
        n = new EnumC9782aY7("GIFT_PACKET", 12, num3, i5, null);
        int i6 = 1;
        Integer num4 = null;
        o = new EnumC9782aY7("CROWD_FUNDING", 13, num4, i6, null);
        p = new EnumC9782aY7("BOUGHT_CONTENT", 14, num3, i5, null == true ? 1 : 0);
        q = new EnumC9782aY7("ALBUM", 15, num4, i6, null == true ? 1 : 0);
        r = new EnumC9782aY7("SPONSORED", 16, num3, i5, null == true ? 1 : 0);
        s = new EnumC9782aY7("BANNED", 17, num4, i6, null == true ? 1 : 0);
        t = new EnumC9782aY7("RECEIPT", 18, enumC9782aY7.a);
        int i7 = 1;
        ED1 ed12 = null;
        u = new EnumC9782aY7("UNSUPPORTED", 19, null == true ? 1 : 0, i7, ed12);
        v = new EnumC9782aY7("VIDEO_STREAM", 20, 8);
        w = new EnumC9782aY7("LIVE", 21, null == true ? 1 : 0, i7, ed12);
        x = new EnumC9782aY7("PROTECTED", 22, null == true ? 1 : 0, 1, null);
        y = new EnumC9782aY7("GOLD_GIFT_PACKET", 23, null, 1, null);
        z = new EnumC9782aY7("POLL", 24, null, 1, null);
        EnumC9782aY7[] enumC9782aY7ArrA = a();
        A = enumC9782aY7ArrA;
        B = G92.a(enumC9782aY7ArrA);
    }

    private EnumC9782aY7(String str, int i2, Integer num) {
        this.a = num;
    }

    private static final /* synthetic */ EnumC9782aY7[] a() {
        return new EnumC9782aY7[]{b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};
    }

    public static EnumC9782aY7 valueOf(String str) {
        return (EnumC9782aY7) Enum.valueOf(EnumC9782aY7.class, str);
    }

    public static EnumC9782aY7[] values() {
        return (EnumC9782aY7[]) A.clone();
    }

    public final Integer j() {
        return this.a;
    }

    /* synthetic */ EnumC9782aY7(String str, int i2, Integer num, int i3, ED1 ed1) {
        this(str, i2, (i3 & 1) != 0 ? null : num);
    }
}
