package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class XJ0 {
    private static final /* synthetic */ XJ0[] Z;
    public static final a c;
    private static final /* synthetic */ F92 z0;
    private final int a;
    private final String b;
    public static final XJ0 d = new XJ0("UNASSIGNED", 0, 0, "Cn");
    public static final XJ0 e = new XJ0("UPPERCASE_LETTER", 1, 1, "Lu");
    public static final XJ0 f = new XJ0("LOWERCASE_LETTER", 2, 2, "Ll");
    public static final XJ0 g = new XJ0("TITLECASE_LETTER", 3, 3, "Lt");
    public static final XJ0 h = new XJ0("MODIFIER_LETTER", 4, 4, "Lm");
    public static final XJ0 i = new XJ0("OTHER_LETTER", 5, 5, "Lo");
    public static final XJ0 j = new XJ0("NON_SPACING_MARK", 6, 6, "Mn");
    public static final XJ0 k = new XJ0("ENCLOSING_MARK", 7, 7, "Me");
    public static final XJ0 l = new XJ0("COMBINING_SPACING_MARK", 8, 8, "Mc");
    public static final XJ0 m = new XJ0("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
    public static final XJ0 n = new XJ0("LETTER_NUMBER", 10, 10, "Nl");
    public static final XJ0 o = new XJ0("OTHER_NUMBER", 11, 11, "No");
    public static final XJ0 p = new XJ0("SPACE_SEPARATOR", 12, 12, "Zs");
    public static final XJ0 q = new XJ0("LINE_SEPARATOR", 13, 13, "Zl");
    public static final XJ0 r = new XJ0("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
    public static final XJ0 s = new XJ0("CONTROL", 15, 15, "Cc");
    public static final XJ0 t = new XJ0("FORMAT", 16, 16, "Cf");
    public static final XJ0 u = new XJ0("PRIVATE_USE", 17, 18, "Co");
    public static final XJ0 v = new XJ0("SURROGATE", 18, 19, "Cs");
    public static final XJ0 w = new XJ0("DASH_PUNCTUATION", 19, 20, "Pd");
    public static final XJ0 x = new XJ0("START_PUNCTUATION", 20, 21, "Ps");
    public static final XJ0 y = new XJ0("END_PUNCTUATION", 21, 22, "Pe");
    public static final XJ0 z = new XJ0("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
    public static final XJ0 A = new XJ0("OTHER_PUNCTUATION", 23, 24, "Po");
    public static final XJ0 B = new XJ0("MATH_SYMBOL", 24, 25, "Sm");
    public static final XJ0 D = new XJ0("CURRENCY_SYMBOL", 25, 26, "Sc");
    public static final XJ0 G = new XJ0("MODIFIER_SYMBOL", 26, 27, "Sk");
    public static final XJ0 H = new XJ0("OTHER_SYMBOL", 27, 28, "So");
    public static final XJ0 J = new XJ0("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
    public static final XJ0 Y = new XJ0("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");

    public static final class a {
        private a() {
        }

        public final XJ0 a(int i) {
            if (i >= 0 && i < 17) {
                return (XJ0) XJ0.j().get(i);
            }
            if (18 <= i && i < 31) {
                return (XJ0) XJ0.j().get(i - 1);
            }
            throw new IllegalArgumentException("Category #" + i + " is not defined.");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        XJ0[] xj0ArrA = a();
        Z = xj0ArrA;
        z0 = G92.a(xj0ArrA);
        c = new a(null);
    }

    private XJ0(String str, int i2, int i3, String str2) {
        this.a = i3;
        this.b = str2;
    }

    private static final /* synthetic */ XJ0[] a() {
        return new XJ0[]{d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, D, G, H, J, Y};
    }

    public static F92 j() {
        return z0;
    }

    public static XJ0 valueOf(String str) {
        return (XJ0) Enum.valueOf(XJ0.class, str);
    }

    public static XJ0[] values() {
        return (XJ0[]) Z.clone();
    }
}
