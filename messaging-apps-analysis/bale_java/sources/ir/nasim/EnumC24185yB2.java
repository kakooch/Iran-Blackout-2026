package ir.nasim;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: ir.nasim.yB2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC24185yB2 {
    public static final a c;
    public static final EnumC24185yB2 d;
    public static final EnumC24185yB2 e;
    public static final EnumC24185yB2 f;
    public static final EnumC24185yB2 g;
    private static final /* synthetic */ EnumC24185yB2[] h;
    private final C9424Zw2 a;
    private final String b;

    /* renamed from: ir.nasim.yB2$a */
    public static final class a {

        /* renamed from: ir.nasim.yB2$a$a, reason: collision with other inner class name */
        public static final class C1777a {
            private final EnumC24185yB2 a;
            private final int b;

            public C1777a(EnumC24185yB2 enumC24185yB2, int i) {
                AbstractC13042fc3.i(enumC24185yB2, "kind");
                this.a = enumC24185yB2;
                this.b = i;
            }

            public final EnumC24185yB2 a() {
                return this.a;
            }

            public final int b() {
                return this.b;
            }

            public final EnumC24185yB2 c() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C1777a)) {
                    return false;
                }
                C1777a c1777a = (C1777a) obj;
                return this.a == c1777a.a && this.b == c1777a.b;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.a + ", arity=" + this.b + ')';
            }
        }

        private a() {
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char cCharAt = str.charAt(i);
                i++;
                int i3 = cCharAt - '0';
                if (i3 < 0 || i3 > 9) {
                    return null;
                }
                i2 = (i2 * 10) + i3;
            }
            return Integer.valueOf(i2);
        }

        public final EnumC24185yB2 a(C9424Zw2 c9424Zw2, String str) {
            AbstractC13042fc3.i(c9424Zw2, "packageFqName");
            AbstractC13042fc3.i(str, "className");
            for (EnumC24185yB2 enumC24185yB2 : EnumC24185yB2.values()) {
                if (AbstractC13042fc3.d(enumC24185yB2.j(), c9424Zw2) && AbstractC20153rZ6.S(str, enumC24185yB2.a(), false, 2, null)) {
                    return enumC24185yB2;
                }
            }
            return null;
        }

        public final EnumC24185yB2 b(String str, C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(str, "className");
            AbstractC13042fc3.i(c9424Zw2, "packageFqName");
            C1777a c1777aC = c(str, c9424Zw2);
            if (c1777aC == null) {
                return null;
            }
            return c1777aC.c();
        }

        public final C1777a c(String str, C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(str, "className");
            AbstractC13042fc3.i(c9424Zw2, "packageFqName");
            EnumC24185yB2 enumC24185yB2A = a(c9424Zw2, str);
            if (enumC24185yB2A == null) {
                return null;
            }
            String strSubstring = str.substring(enumC24185yB2A.a().length());
            AbstractC13042fc3.h(strSubstring, "(this as java.lang.String).substring(startIndex)");
            Integer numD = d(strSubstring);
            if (numD == null) {
                return null;
            }
            return new C1777a(enumC24185yB2A, numD.intValue());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC24185yB2 enumC24185yB2 = new EnumC24185yB2("Function", 0, PJ6.m, "Function");
        d = enumC24185yB2;
        EnumC24185yB2 enumC24185yB22 = new EnumC24185yB2("SuspendFunction", 1, PJ6.d, "SuspendFunction");
        e = enumC24185yB22;
        C9424Zw2 c9424Zw2 = PJ6.j;
        EnumC24185yB2 enumC24185yB23 = new EnumC24185yB2("KFunction", 2, c9424Zw2, "KFunction");
        f = enumC24185yB23;
        EnumC24185yB2 enumC24185yB24 = new EnumC24185yB2("KSuspendFunction", 3, c9424Zw2, "KSuspendFunction");
        g = enumC24185yB24;
        h = new EnumC24185yB2[]{enumC24185yB2, enumC24185yB22, enumC24185yB23, enumC24185yB24};
        c = new a(null);
    }

    private EnumC24185yB2(String str, int i, C9424Zw2 c9424Zw2, String str2) {
        this.a = c9424Zw2;
        this.b = str2;
    }

    public static EnumC24185yB2 valueOf(String str) {
        AbstractC13042fc3.i(str, "value");
        return (EnumC24185yB2) Enum.valueOf(EnumC24185yB2.class, str);
    }

    public static EnumC24185yB2[] values() {
        EnumC24185yB2[] enumC24185yB2Arr = h;
        EnumC24185yB2[] enumC24185yB2Arr2 = new EnumC24185yB2[enumC24185yB2Arr.length];
        System.arraycopy(enumC24185yB2Arr, 0, enumC24185yB2Arr2, 0, enumC24185yB2Arr.length);
        return enumC24185yB2Arr2;
    }

    public final String a() {
        return this.b;
    }

    public final C9424Zw2 j() {
        return this.a;
    }

    public final C6432No4 p(int i) {
        C6432No4 c6432No4P = C6432No4.p(AbstractC13042fc3.q(this.b, Integer.valueOf(i)));
        AbstractC13042fc3.h(c6432No4P, "identifier(\"$classNamePrefix$arity\")");
        return c6432No4P;
    }
}
