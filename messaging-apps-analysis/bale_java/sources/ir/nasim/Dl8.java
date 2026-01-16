package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import com.google.android.gms.internal.clearcut.AbstractC2081f;

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
public final class Dl8 {
    public static final Dl8 d;
    public static final Dl8 e;
    public static final Dl8 f;
    public static final Dl8 g;
    public static final Dl8 h;
    public static final Dl8 i;
    public static final Dl8 j;
    public static final Dl8 k;
    public static final Dl8 l;
    public static final Dl8 m;
    private static final /* synthetic */ Dl8[] n;
    private final Class a;
    private final Class b;
    private final Object c;

    static {
        Dl8 dl8 = new Dl8("VOID", 0, Void.class, Void.class, null);
        d = dl8;
        Class cls = Integer.TYPE;
        Dl8 dl82 = new Dl8("INT", 1, cls, Integer.class, 0);
        e = dl82;
        Dl8 dl83 = new Dl8("LONG", 2, Long.TYPE, Long.class, 0L);
        f = dl83;
        Dl8 dl84 = new Dl8("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        g = dl84;
        Dl8 dl85 = new Dl8("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        h = dl85;
        Dl8 dl86 = new Dl8("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        i = dl86;
        Dl8 dl87 = new Dl8("STRING", 6, String.class, String.class, "");
        j = dl87;
        Dl8 dl88 = new Dl8("BYTE_STRING", 7, AbstractC2081f.class, AbstractC2081f.class, AbstractC2081f.b);
        k = dl88;
        Dl8 dl89 = new Dl8("ENUM", 8, cls, Integer.class, null);
        l = dl89;
        Dl8 dl810 = new Dl8(TokenNames.MESSAGE, 9, Object.class, Object.class, null);
        m = dl810;
        n = new Dl8[]{dl8, dl82, dl83, dl84, dl85, dl86, dl87, dl88, dl89, dl810};
    }

    private Dl8(String str, int i2, Class cls, Class cls2, Object obj) {
        this.a = cls;
        this.b = cls2;
        this.c = obj;
    }

    public static Dl8[] values() {
        return (Dl8[]) n.clone();
    }

    public final Class a() {
        return this.b;
    }
}
