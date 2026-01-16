package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;

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
/* renamed from: ir.nasim.Ki3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC5671Ki3 {
    public static final EnumC5671Ki3 d;
    public static final EnumC5671Ki3 e;
    public static final EnumC5671Ki3 f;
    public static final EnumC5671Ki3 g;
    public static final EnumC5671Ki3 h;
    public static final EnumC5671Ki3 i;
    public static final EnumC5671Ki3 j;
    public static final EnumC5671Ki3 k;
    public static final EnumC5671Ki3 l;
    public static final EnumC5671Ki3 m;
    private static final /* synthetic */ EnumC5671Ki3[] n;
    private final Class a;
    private final Class b;
    private final Object c;

    static {
        EnumC5671Ki3 enumC5671Ki3 = new EnumC5671Ki3("VOID", 0, Void.class, Void.class, null);
        d = enumC5671Ki3;
        Class cls = Integer.TYPE;
        EnumC5671Ki3 enumC5671Ki32 = new EnumC5671Ki3("INT", 1, cls, Integer.class, 0);
        e = enumC5671Ki32;
        EnumC5671Ki3 enumC5671Ki33 = new EnumC5671Ki3("LONG", 2, Long.TYPE, Long.class, 0L);
        f = enumC5671Ki33;
        EnumC5671Ki3 enumC5671Ki34 = new EnumC5671Ki3("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        g = enumC5671Ki34;
        EnumC5671Ki3 enumC5671Ki35 = new EnumC5671Ki3("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        h = enumC5671Ki35;
        EnumC5671Ki3 enumC5671Ki36 = new EnumC5671Ki3("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        i = enumC5671Ki36;
        EnumC5671Ki3 enumC5671Ki37 = new EnumC5671Ki3("STRING", 6, String.class, String.class, "");
        j = enumC5671Ki37;
        EnumC5671Ki3 enumC5671Ki38 = new EnumC5671Ki3("BYTE_STRING", 7, AbstractC2345g.class, AbstractC2345g.class, AbstractC2345g.b);
        k = enumC5671Ki38;
        EnumC5671Ki3 enumC5671Ki39 = new EnumC5671Ki3("ENUM", 8, cls, Integer.class, null);
        l = enumC5671Ki39;
        EnumC5671Ki3 enumC5671Ki310 = new EnumC5671Ki3(TokenNames.MESSAGE, 9, Object.class, Object.class, null);
        m = enumC5671Ki310;
        n = new EnumC5671Ki3[]{enumC5671Ki3, enumC5671Ki32, enumC5671Ki33, enumC5671Ki34, enumC5671Ki35, enumC5671Ki36, enumC5671Ki37, enumC5671Ki38, enumC5671Ki39, enumC5671Ki310};
    }

    private EnumC5671Ki3(String str, int i2, Class cls, Class cls2, Object obj) {
        this.a = cls;
        this.b = cls2;
        this.c = obj;
    }

    public static EnumC5671Ki3 valueOf(String str) {
        return (EnumC5671Ki3) Enum.valueOf(EnumC5671Ki3.class, str);
    }

    public static EnumC5671Ki3[] values() {
        return (EnumC5671Ki3[]) n.clone();
    }

    public Class a() {
        return this.b;
    }
}
