package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Nh, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC6364Nh {
    public static final a b;
    public static final EnumC6364Nh c = new EnumC6364Nh("NONE", 0, 0);
    public static final EnumC6364Nh d = new EnumC6364Nh("BANNER", 1, 1);
    public static final EnumC6364Nh e = new EnumC6364Nh("NATIVE", 2, 2);
    public static final EnumC6364Nh f = new EnumC6364Nh("BANNER_AND_NATIVE", 3, 3);
    private static final /* synthetic */ EnumC6364Nh[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    /* renamed from: ir.nasim.Nh$a */
    public static final class a {
        private a() {
        }

        public final EnumC6364Nh a(int i) {
            EnumC6364Nh enumC6364Nh;
            EnumC6364Nh[] enumC6364NhArrValues = EnumC6364Nh.values();
            int length = enumC6364NhArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    enumC6364Nh = null;
                    break;
                }
                enumC6364Nh = enumC6364NhArrValues[i2];
                if (enumC6364Nh.j() == i) {
                    break;
                }
                i2++;
            }
            return enumC6364Nh == null ? EnumC6364Nh.c : enumC6364Nh;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC6364Nh[] enumC6364NhArrA = a();
        g = enumC6364NhArrA;
        h = G92.a(enumC6364NhArrA);
        b = new a(null);
    }

    private EnumC6364Nh(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC6364Nh[] a() {
        return new EnumC6364Nh[]{c, d, e, f};
    }

    public static EnumC6364Nh valueOf(String str) {
        return (EnumC6364Nh) Enum.valueOf(EnumC6364Nh.class, str);
    }

    public static EnumC6364Nh[] values() {
        return (EnumC6364Nh[]) g.clone();
    }

    public final int j() {
        return this.a;
    }
}
