package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yK1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC24265yK1 {
    public static final a b;
    public static final EnumC24265yK1 c = new EnumC24265yK1("UNKNOWN", 0, 0);
    public static final EnumC24265yK1 d = new EnumC24265yK1("GENERIC", 1, 1);
    public static final EnumC24265yK1 e = new EnumC24265yK1("PC", 2, 2);
    public static final EnumC24265yK1 f = new EnumC24265yK1("MOBILE", 3, 3);
    public static final EnumC24265yK1 g = new EnumC24265yK1("TABLET", 4, 4);
    public static final EnumC24265yK1 h = new EnumC24265yK1("WATCH", 5, 5);
    public static final EnumC24265yK1 i = new EnumC24265yK1("MIRROR", 6, 6);
    public static final EnumC24265yK1 j = new EnumC24265yK1("CAR", 7, 7);
    public static final EnumC24265yK1 k = new EnumC24265yK1("TABLE", 8, 8);
    public static final EnumC24265yK1 l = new EnumC24265yK1("UNRECOGNIZED", 9, -1);
    private static final /* synthetic */ EnumC24265yK1[] m;
    private static final /* synthetic */ F92 n;
    private final int a;

    /* renamed from: ir.nasim.yK1$a */
    public static final class a {
        private a() {
        }

        public final EnumC24265yK1 a(int i) {
            switch (i) {
            }
            return EnumC24265yK1.l;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC24265yK1[] enumC24265yK1ArrA = a();
        m = enumC24265yK1ArrA;
        n = G92.a(enumC24265yK1ArrA);
        b = new a(null);
    }

    private EnumC24265yK1(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ EnumC24265yK1[] a() {
        return new EnumC24265yK1[]{c, d, e, f, g, h, i, j, k, l};
    }

    public static EnumC24265yK1 valueOf(String str) {
        return (EnumC24265yK1) Enum.valueOf(EnumC24265yK1.class, str);
    }

    public static EnumC24265yK1[] values() {
        return (EnumC24265yK1[]) m.clone();
    }
}
