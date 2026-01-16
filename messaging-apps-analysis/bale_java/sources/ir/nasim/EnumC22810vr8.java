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
/* renamed from: ir.nasim.vr8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC22810vr8 {
    public static final EnumC22810vr8 d;
    public static final EnumC22810vr8 e;
    public static final EnumC22810vr8 f;
    public static final EnumC22810vr8 g;
    public static final EnumC22810vr8 h;
    public static final EnumC22810vr8 i;
    public static final EnumC22810vr8 j;
    public static final EnumC22810vr8 k;
    public static final EnumC22810vr8 l;
    public static final EnumC22810vr8 m;
    private static final /* synthetic */ EnumC22810vr8[] n;
    private final Class a;
    private final Class b;
    private final Object c;

    static {
        EnumC22810vr8 enumC22810vr8 = new EnumC22810vr8("VOID", 0, Void.class, Void.class, null);
        d = enumC22810vr8;
        Class cls = Integer.TYPE;
        EnumC22810vr8 enumC22810vr82 = new EnumC22810vr8("INT", 1, cls, Integer.class, 0);
        e = enumC22810vr82;
        EnumC22810vr8 enumC22810vr83 = new EnumC22810vr8("LONG", 2, Long.TYPE, Long.class, 0L);
        f = enumC22810vr83;
        EnumC22810vr8 enumC22810vr84 = new EnumC22810vr8("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        g = enumC22810vr84;
        EnumC22810vr8 enumC22810vr85 = new EnumC22810vr8("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        h = enumC22810vr85;
        EnumC22810vr8 enumC22810vr86 = new EnumC22810vr8("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        i = enumC22810vr86;
        EnumC22810vr8 enumC22810vr87 = new EnumC22810vr8("STRING", 6, String.class, String.class, "");
        j = enumC22810vr87;
        EnumC22810vr8 enumC22810vr88 = new EnumC22810vr8("BYTE_STRING", 7, com.google.android.gms.internal.measurement.A0.class, com.google.android.gms.internal.measurement.A0.class, com.google.android.gms.internal.measurement.A0.b);
        k = enumC22810vr88;
        EnumC22810vr8 enumC22810vr89 = new EnumC22810vr8("ENUM", 8, cls, Integer.class, null);
        l = enumC22810vr89;
        EnumC22810vr8 enumC22810vr810 = new EnumC22810vr8(TokenNames.MESSAGE, 9, Object.class, Object.class, null);
        m = enumC22810vr810;
        n = new EnumC22810vr8[]{enumC22810vr8, enumC22810vr82, enumC22810vr83, enumC22810vr84, enumC22810vr85, enumC22810vr86, enumC22810vr87, enumC22810vr88, enumC22810vr89, enumC22810vr810};
    }

    private EnumC22810vr8(String str, int i2, Class cls, Class cls2, Object obj) {
        this.a = cls;
        this.b = cls2;
        this.c = obj;
    }

    public static EnumC22810vr8[] values() {
        return (EnumC22810vr8[]) n.clone();
    }

    public final Class a() {
        return this.b;
    }
}
