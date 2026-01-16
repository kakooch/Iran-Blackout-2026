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
public final class Vq8 {
    public static final Vq8 d;
    public static final Vq8 e;
    public static final Vq8 f;
    public static final Vq8 g;
    public static final Vq8 h;
    public static final Vq8 i;
    public static final Vq8 j;
    public static final Vq8 k;
    public static final Vq8 l;
    public static final Vq8 m;
    private static final /* synthetic */ Vq8[] n;
    private final Class a;
    private final Class b;
    private final Object c;

    static {
        Vq8 vq8 = new Vq8("VOID", 0, Void.class, Void.class, null);
        d = vq8;
        Class cls = Integer.TYPE;
        Vq8 vq82 = new Vq8("INT", 1, cls, Integer.class, 0);
        e = vq82;
        Vq8 vq83 = new Vq8("LONG", 2, Long.TYPE, Long.class, 0L);
        f = vq83;
        Vq8 vq84 = new Vq8("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        g = vq84;
        Vq8 vq85 = new Vq8("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        h = vq85;
        Vq8 vq86 = new Vq8("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        i = vq86;
        Vq8 vq87 = new Vq8("STRING", 6, String.class, String.class, "");
        j = vq87;
        Vq8 vq88 = new Vq8("BYTE_STRING", 7, com.google.android.gms.internal.vision.K.class, com.google.android.gms.internal.vision.K.class, com.google.android.gms.internal.vision.K.b);
        k = vq88;
        Vq8 vq89 = new Vq8("ENUM", 8, cls, Integer.class, null);
        l = vq89;
        Vq8 vq810 = new Vq8(TokenNames.MESSAGE, 9, Object.class, Object.class, null);
        m = vq810;
        n = new Vq8[]{vq8, vq82, vq83, vq84, vq85, vq86, vq87, vq88, vq89, vq810};
    }

    private Vq8(String str, int i2, Class cls, Class cls2, Object obj) {
        this.a = cls;
        this.b = cls2;
        this.c = obj;
    }

    public static Vq8[] values() {
        return (Vq8[]) n.clone();
    }

    public final Class a() {
        return this.b;
    }
}
