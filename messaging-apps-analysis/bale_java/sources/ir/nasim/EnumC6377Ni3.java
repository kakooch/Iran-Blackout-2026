package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.datastore.preferences.protobuf.AbstractC1937f;

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
/* renamed from: ir.nasim.Ni3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC6377Ni3 {
    public static final EnumC6377Ni3 d;
    public static final EnumC6377Ni3 e;
    public static final EnumC6377Ni3 f;
    public static final EnumC6377Ni3 g;
    public static final EnumC6377Ni3 h;
    public static final EnumC6377Ni3 i;
    public static final EnumC6377Ni3 j;
    public static final EnumC6377Ni3 k;
    public static final EnumC6377Ni3 l;
    public static final EnumC6377Ni3 m;
    private static final /* synthetic */ EnumC6377Ni3[] n;
    private final Class a;
    private final Class b;
    private final Object c;

    static {
        EnumC6377Ni3 enumC6377Ni3 = new EnumC6377Ni3("VOID", 0, Void.class, Void.class, null);
        d = enumC6377Ni3;
        Class cls = Integer.TYPE;
        EnumC6377Ni3 enumC6377Ni32 = new EnumC6377Ni3("INT", 1, cls, Integer.class, 0);
        e = enumC6377Ni32;
        EnumC6377Ni3 enumC6377Ni33 = new EnumC6377Ni3("LONG", 2, Long.TYPE, Long.class, 0L);
        f = enumC6377Ni33;
        EnumC6377Ni3 enumC6377Ni34 = new EnumC6377Ni3("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        g = enumC6377Ni34;
        EnumC6377Ni3 enumC6377Ni35 = new EnumC6377Ni3("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        h = enumC6377Ni35;
        EnumC6377Ni3 enumC6377Ni36 = new EnumC6377Ni3("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        i = enumC6377Ni36;
        EnumC6377Ni3 enumC6377Ni37 = new EnumC6377Ni3("STRING", 6, String.class, String.class, "");
        j = enumC6377Ni37;
        EnumC6377Ni3 enumC6377Ni38 = new EnumC6377Ni3("BYTE_STRING", 7, AbstractC1937f.class, AbstractC1937f.class, AbstractC1937f.b);
        k = enumC6377Ni38;
        EnumC6377Ni3 enumC6377Ni39 = new EnumC6377Ni3("ENUM", 8, cls, Integer.class, null);
        l = enumC6377Ni39;
        EnumC6377Ni3 enumC6377Ni310 = new EnumC6377Ni3(TokenNames.MESSAGE, 9, Object.class, Object.class, null);
        m = enumC6377Ni310;
        n = new EnumC6377Ni3[]{enumC6377Ni3, enumC6377Ni32, enumC6377Ni33, enumC6377Ni34, enumC6377Ni35, enumC6377Ni36, enumC6377Ni37, enumC6377Ni38, enumC6377Ni39, enumC6377Ni310};
    }

    private EnumC6377Ni3(String str, int i2, Class cls, Class cls2, Object obj) {
        this.a = cls;
        this.b = cls2;
        this.c = obj;
    }

    public static EnumC6377Ni3 valueOf(String str) {
        return (EnumC6377Ni3) Enum.valueOf(EnumC6377Ni3.class, str);
    }

    public static EnumC6377Ni3[] values() {
        return (EnumC6377Ni3[]) n.clone();
    }

    public Class a() {
        return this.b;
    }
}
