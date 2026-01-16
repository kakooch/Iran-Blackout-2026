package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public class Sn8 {
    public static final Sn8 c;
    public static final Sn8 d;
    public static final Sn8 e;
    public static final Sn8 f;
    public static final Sn8 g;
    public static final Sn8 h;
    public static final Sn8 i;
    public static final Sn8 j;
    public static final Sn8 k;
    public static final Sn8 l;
    public static final Sn8 m;
    public static final Sn8 n;
    public static final Sn8 o;
    public static final Sn8 p;
    public static final Sn8 q;
    public static final Sn8 r;
    public static final Sn8 s;
    public static final Sn8 t;
    private static final /* synthetic */ Sn8[] u;
    private final Yn8 a;
    private final int b;

    static {
        Sn8 sn8 = new Sn8("DOUBLE", 0, Yn8.DOUBLE, 1);
        c = sn8;
        Sn8 sn82 = new Sn8("FLOAT", 1, Yn8.FLOAT, 5);
        d = sn82;
        Yn8 yn8 = Yn8.LONG;
        final int i2 = 2;
        Sn8 sn83 = new Sn8("INT64", 2, yn8, 0);
        e = sn83;
        final int i3 = 3;
        Sn8 sn84 = new Sn8("UINT64", 3, yn8, 0);
        f = sn84;
        Yn8 yn82 = Yn8.INT;
        Sn8 sn85 = new Sn8("INT32", 4, yn82, 0);
        g = sn85;
        Sn8 sn86 = new Sn8("FIXED64", 5, yn8, 1);
        h = sn86;
        Sn8 sn87 = new Sn8("FIXED32", 6, yn82, 5);
        i = sn87;
        Sn8 sn88 = new Sn8("BOOL", 7, Yn8.BOOLEAN, 0);
        j = sn88;
        final int i4 = 8;
        final Yn8 yn83 = Yn8.STRING;
        final String str = "STRING";
        Sn8 sn89 = new Sn8(str, i4, yn83, i2) { // from class: ir.nasim.Tn8
            {
                int i5 = 2;
                int i6 = 8;
            }
        };
        k = sn89;
        final Yn8 yn84 = Yn8.MESSAGE;
        final String str2 = "GROUP";
        final int i5 = 9;
        Sn8 sn810 = new Sn8(str2, i5, yn84, i3) { // from class: ir.nasim.Un8
            {
                int i6 = 3;
                int i7 = 9;
            }
        };
        l = sn810;
        final String str3 = TokenNames.MESSAGE;
        final int i6 = 10;
        final int i7 = 2;
        Sn8 sn811 = new Sn8(str3, i6, yn84, i7) { // from class: ir.nasim.Vn8
            {
                int i8 = 2;
                int i9 = 10;
            }
        };
        m = sn811;
        final int i8 = 11;
        final Yn8 yn85 = Yn8.BYTE_STRING;
        final String str4 = "BYTES";
        Sn8 sn812 = new Sn8(str4, i8, yn85, i7) { // from class: ir.nasim.Xn8
            {
                int i9 = 2;
                int i10 = 11;
            }
        };
        n = sn812;
        Sn8 sn813 = new Sn8("UINT32", 12, yn82, 0);
        o = sn813;
        Sn8 sn814 = new Sn8("ENUM", 13, Yn8.ENUM, 0);
        p = sn814;
        Sn8 sn815 = new Sn8("SFIXED32", 14, yn82, 5);
        q = sn815;
        Sn8 sn816 = new Sn8("SFIXED64", 15, yn8, 1);
        r = sn816;
        Sn8 sn817 = new Sn8("SINT32", 16, yn82, 0);
        s = sn817;
        Sn8 sn818 = new Sn8("SINT64", 17, yn8, 0);
        t = sn818;
        u = new Sn8[]{sn8, sn82, sn83, sn84, sn85, sn86, sn87, sn88, sn89, sn810, sn811, sn812, sn813, sn814, sn815, sn816, sn817, sn818};
    }

    private Sn8(String str, int i2, Yn8 yn8, int i3) {
        this.a = yn8;
        this.b = i3;
    }

    public static Sn8[] values() {
        return (Sn8[]) u.clone();
    }
}
