package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.li4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC16694li4 {
    public static final a a;
    public static final EnumC16694li4 b = new EnumC16694li4("MINE", 0);
    public static final EnumC16694li4 c = new EnumC16694li4("OTHERS", 1);
    public static final EnumC16694li4 d = new EnumC16694li4("UNSUPPORTED_VALUE", 2);
    private static final /* synthetic */ EnumC16694li4[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.li4$a */
    public static final class a {

        /* renamed from: ir.nasim.li4$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1376a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[R60.values().length];
                try {
                    iArr[R60.MoneyRequestDetailResponseType_MINE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[R60.MoneyRequestDetailResponseType_OTHERS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final EnumC16694li4 a(R60 r60) {
            int i = r60 == null ? -1 : C1376a.a[r60.ordinal()];
            return i != 1 ? i != 2 ? EnumC16694li4.d : EnumC16694li4.c : EnumC16694li4.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC16694li4[] enumC16694li4ArrA = a();
        e = enumC16694li4ArrA;
        f = G92.a(enumC16694li4ArrA);
        a = new a(null);
    }

    private EnumC16694li4(String str, int i) {
    }

    private static final /* synthetic */ EnumC16694li4[] a() {
        return new EnumC16694li4[]{b, c, d};
    }

    public static EnumC16694li4 valueOf(String str) {
        return (EnumC16694li4) Enum.valueOf(EnumC16694li4.class, str);
    }

    public static EnumC16694li4[] values() {
        return (EnumC16694li4[]) e.clone();
    }
}
