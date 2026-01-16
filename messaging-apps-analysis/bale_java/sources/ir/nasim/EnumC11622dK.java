package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.dK, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC11622dK {
    public static final a a;
    public static final EnumC11622dK b = new EnumC11622dK("BOTTOM", 0);
    public static final EnumC11622dK c = new EnumC11622dK("TOP", 1);
    public static final EnumC11622dK d = new EnumC11622dK("START", 2);
    public static final EnumC11622dK e = new EnumC11622dK("END", 3);
    private static final /* synthetic */ EnumC11622dK[] f;
    private static final /* synthetic */ F92 g;

    /* renamed from: ir.nasim.dK$a */
    public static final class a {

        /* renamed from: ir.nasim.dK$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C1006a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC11622dK.values().length];
                try {
                    iArr[EnumC11622dK.d.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC11622dK.e.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final EnumC11622dK a(EnumC11622dK enumC11622dK, boolean z) {
            AbstractC13042fc3.i(enumC11622dK, "<this>");
            if (!z) {
                return enumC11622dK;
            }
            int i = C1006a.a[enumC11622dK.ordinal()];
            return i != 1 ? i != 2 ? enumC11622dK : EnumC11622dK.d : EnumC11622dK.e;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC11622dK[] enumC11622dKArrA = a();
        f = enumC11622dKArrA;
        g = G92.a(enumC11622dKArrA);
        a = new a(null);
    }

    private EnumC11622dK(String str, int i) {
    }

    private static final /* synthetic */ EnumC11622dK[] a() {
        return new EnumC11622dK[]{b, c, d, e};
    }

    public static EnumC11622dK valueOf(String str) {
        return (EnumC11622dK) Enum.valueOf(EnumC11622dK.class, str);
    }

    public static EnumC11622dK[] values() {
        return (EnumC11622dK[]) f.clone();
    }
}
