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
/* renamed from: ir.nasim.ks8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class EnumC16207ks8 {
    public static final EnumC16207ks8 c;
    public static final EnumC16207ks8 d;
    public static final EnumC16207ks8 e;
    public static final EnumC16207ks8 f;
    public static final EnumC16207ks8 g;
    public static final EnumC16207ks8 h;
    public static final EnumC16207ks8 i;
    public static final EnumC16207ks8 j;
    public static final EnumC16207ks8 k;
    public static final EnumC16207ks8 l;
    public static final EnumC16207ks8 m;
    public static final EnumC16207ks8 n;
    public static final EnumC16207ks8 o;
    public static final EnumC16207ks8 p;
    public static final EnumC16207ks8 q;
    public static final EnumC16207ks8 r;
    public static final EnumC16207ks8 s;
    public static final EnumC16207ks8 t;
    private static final /* synthetic */ EnumC16207ks8[] u;
    private final EnumC17980ns8 a;
    private final int b;

    static {
        EnumC16207ks8 enumC16207ks8 = new EnumC16207ks8("DOUBLE", 0, EnumC17980ns8.DOUBLE, 1);
        c = enumC16207ks8;
        EnumC16207ks8 enumC16207ks82 = new EnumC16207ks8("FLOAT", 1, EnumC17980ns8.FLOAT, 5);
        d = enumC16207ks82;
        EnumC17980ns8 enumC17980ns8 = EnumC17980ns8.LONG;
        final int i2 = 2;
        EnumC16207ks8 enumC16207ks83 = new EnumC16207ks8("INT64", 2, enumC17980ns8, 0);
        e = enumC16207ks83;
        final int i3 = 3;
        EnumC16207ks8 enumC16207ks84 = new EnumC16207ks8("UINT64", 3, enumC17980ns8, 0);
        f = enumC16207ks84;
        EnumC17980ns8 enumC17980ns82 = EnumC17980ns8.INT;
        EnumC16207ks8 enumC16207ks85 = new EnumC16207ks8("INT32", 4, enumC17980ns82, 0);
        g = enumC16207ks85;
        EnumC16207ks8 enumC16207ks86 = new EnumC16207ks8("FIXED64", 5, enumC17980ns8, 1);
        h = enumC16207ks86;
        EnumC16207ks8 enumC16207ks87 = new EnumC16207ks8("FIXED32", 6, enumC17980ns82, 5);
        i = enumC16207ks87;
        EnumC16207ks8 enumC16207ks88 = new EnumC16207ks8("BOOL", 7, EnumC17980ns8.BOOLEAN, 0);
        j = enumC16207ks88;
        final int i4 = 8;
        final EnumC17980ns8 enumC17980ns83 = EnumC17980ns8.STRING;
        final String str = "STRING";
        EnumC16207ks8 enumC16207ks89 = new EnumC16207ks8(str, i4, enumC17980ns83, i2) { // from class: ir.nasim.js8
            {
                int i5 = 2;
                int i6 = 8;
            }
        };
        k = enumC16207ks89;
        final EnumC17980ns8 enumC17980ns84 = EnumC17980ns8.MESSAGE;
        final String str2 = "GROUP";
        final int i5 = 9;
        EnumC16207ks8 enumC16207ks810 = new EnumC16207ks8(str2, i5, enumC17980ns84, i3) { // from class: ir.nasim.ms8
            {
                int i6 = 3;
                int i7 = 9;
            }
        };
        l = enumC16207ks810;
        final String str3 = TokenNames.MESSAGE;
        final int i6 = 10;
        final int i7 = 2;
        EnumC16207ks8 enumC16207ks811 = new EnumC16207ks8(str3, i6, enumC17980ns84, i7) { // from class: ir.nasim.ls8
            {
                int i8 = 2;
                int i9 = 10;
            }
        };
        m = enumC16207ks811;
        final int i8 = 11;
        final EnumC17980ns8 enumC17980ns85 = EnumC17980ns8.BYTE_STRING;
        final String str4 = "BYTES";
        EnumC16207ks8 enumC16207ks812 = new EnumC16207ks8(str4, i8, enumC17980ns85, i7) { // from class: ir.nasim.os8
            {
                int i9 = 2;
                int i10 = 11;
            }
        };
        n = enumC16207ks812;
        EnumC16207ks8 enumC16207ks813 = new EnumC16207ks8("UINT32", 12, enumC17980ns82, 0);
        o = enumC16207ks813;
        EnumC16207ks8 enumC16207ks814 = new EnumC16207ks8("ENUM", 13, EnumC17980ns8.ENUM, 0);
        p = enumC16207ks814;
        EnumC16207ks8 enumC16207ks815 = new EnumC16207ks8("SFIXED32", 14, enumC17980ns82, 5);
        q = enumC16207ks815;
        EnumC16207ks8 enumC16207ks816 = new EnumC16207ks8("SFIXED64", 15, enumC17980ns8, 1);
        r = enumC16207ks816;
        EnumC16207ks8 enumC16207ks817 = new EnumC16207ks8("SINT32", 16, enumC17980ns82, 0);
        s = enumC16207ks817;
        EnumC16207ks8 enumC16207ks818 = new EnumC16207ks8("SINT64", 17, enumC17980ns8, 0);
        t = enumC16207ks818;
        u = new EnumC16207ks8[]{enumC16207ks8, enumC16207ks82, enumC16207ks83, enumC16207ks84, enumC16207ks85, enumC16207ks86, enumC16207ks87, enumC16207ks88, enumC16207ks89, enumC16207ks810, enumC16207ks811, enumC16207ks812, enumC16207ks813, enumC16207ks814, enumC16207ks815, enumC16207ks816, enumC16207ks817, enumC16207ks818};
    }

    private EnumC16207ks8(String str, int i2, EnumC17980ns8 enumC17980ns8, int i3) {
        this.a = enumC17980ns8;
        this.b = i3;
    }

    public static EnumC16207ks8[] values() {
        return (EnumC16207ks8[]) u.clone();
    }

    public final EnumC17980ns8 a() {
        return this.a;
    }
}
