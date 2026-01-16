package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import com.google.protobuf.AbstractC2383g;

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
/* renamed from: ir.nasim.Li3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC5905Li3 {
    public static final EnumC5905Li3 d;
    public static final EnumC5905Li3 e;
    public static final EnumC5905Li3 f;
    public static final EnumC5905Li3 g;
    public static final EnumC5905Li3 h;
    public static final EnumC5905Li3 i;
    public static final EnumC5905Li3 j;
    public static final EnumC5905Li3 k;
    public static final EnumC5905Li3 l;
    public static final EnumC5905Li3 m;
    private static final /* synthetic */ EnumC5905Li3[] n;
    private final Class a;
    private final Class b;
    private final Object c;

    static {
        EnumC5905Li3 enumC5905Li3 = new EnumC5905Li3("VOID", 0, Void.class, Void.class, null);
        d = enumC5905Li3;
        Class cls = Integer.TYPE;
        EnumC5905Li3 enumC5905Li32 = new EnumC5905Li3("INT", 1, cls, Integer.class, 0);
        e = enumC5905Li32;
        EnumC5905Li3 enumC5905Li33 = new EnumC5905Li3("LONG", 2, Long.TYPE, Long.class, 0L);
        f = enumC5905Li33;
        EnumC5905Li3 enumC5905Li34 = new EnumC5905Li3("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        g = enumC5905Li34;
        EnumC5905Li3 enumC5905Li35 = new EnumC5905Li3("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        h = enumC5905Li35;
        EnumC5905Li3 enumC5905Li36 = new EnumC5905Li3("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        i = enumC5905Li36;
        EnumC5905Li3 enumC5905Li37 = new EnumC5905Li3("STRING", 6, String.class, String.class, "");
        j = enumC5905Li37;
        EnumC5905Li3 enumC5905Li38 = new EnumC5905Li3("BYTE_STRING", 7, AbstractC2383g.class, AbstractC2383g.class, AbstractC2383g.b);
        k = enumC5905Li38;
        EnumC5905Li3 enumC5905Li39 = new EnumC5905Li3("ENUM", 8, cls, Integer.class, null);
        l = enumC5905Li39;
        EnumC5905Li3 enumC5905Li310 = new EnumC5905Li3(TokenNames.MESSAGE, 9, Object.class, Object.class, null);
        m = enumC5905Li310;
        n = new EnumC5905Li3[]{enumC5905Li3, enumC5905Li32, enumC5905Li33, enumC5905Li34, enumC5905Li35, enumC5905Li36, enumC5905Li37, enumC5905Li38, enumC5905Li39, enumC5905Li310};
    }

    private EnumC5905Li3(String str, int i2, Class cls, Class cls2, Object obj) {
        this.a = cls;
        this.b = cls2;
        this.c = obj;
    }

    public static EnumC5905Li3 valueOf(String str) {
        return (EnumC5905Li3) Enum.valueOf(EnumC5905Li3.class, str);
    }

    public static EnumC5905Li3[] values() {
        return (EnumC5905Li3[]) n.clone();
    }

    public Class a() {
        return this.b;
    }
}
