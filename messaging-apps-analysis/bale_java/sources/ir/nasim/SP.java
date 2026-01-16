package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class SP {
    public static final a a;
    public static final SP b = new SP("OTP", 0);
    public static final SP c = new SP("PASSWORD", 1);
    public static final SP d = new SP("FUTURE_TOKEN", 2);
    public static final SP e = new SP("UNSUPPORTED", 3);
    private static final /* synthetic */ SP[] f;
    private static final /* synthetic */ F92 g;

    public static final class a {

        /* renamed from: ir.nasim.SP$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0619a {
            public static final /* synthetic */ int[] a;
            public static final /* synthetic */ int[] b;

            static {
                int[] iArr = new int[PA.values().length];
                try {
                    iArr[PA.CODE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PA.PASSWORD.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PA.FUTURE_AUTH_TOKEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PA.UNSUPPORTED_VALUE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
                int[] iArr2 = new int[EnumC10305bR.values().length];
                try {
                    iArr2[EnumC10305bR.PhoneActivationType_CODE.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[EnumC10305bR.PhoneActivationType_PASSWORD.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[EnumC10305bR.PhoneActivationType_FUTURE_AUTH_TOKEN.ordinal()] = 3;
                } catch (NoSuchFieldError unused7) {
                }
                b = iArr2;
            }
        }

        private a() {
        }

        public final SP a(EnumC10305bR enumC10305bR) {
            AbstractC13042fc3.i(enumC10305bR, "activationType");
            int i = C0619a.b[enumC10305bR.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? SP.e : SP.d : SP.c : SP.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        SP[] spArrA = a();
        f = spArrA;
        g = G92.a(spArrA);
        a = new a(null);
    }

    private SP(String str, int i) {
    }

    private static final /* synthetic */ SP[] a() {
        return new SP[]{b, c, d, e};
    }

    public static SP valueOf(String str) {
        return (SP) Enum.valueOf(SP.class, str);
    }

    public static SP[] values() {
        return (SP[]) f.clone();
    }
}
