package ir.nasim;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ZB7 {
    public static final ZB7 d;
    public static final ZB7 e;
    public static final ZB7 f;
    public static final ZB7 g;
    private static final /* synthetic */ ZB7[] h;
    private final C24948zU0 a;
    private final C6432No4 b;
    private final C24948zU0 c;

    static {
        C24948zU0 c24948zU0E = C24948zU0.e("kotlin/UByte");
        AbstractC13042fc3.h(c24948zU0E, "fromString(\"kotlin/UByte\")");
        ZB7 zb7 = new ZB7("UBYTE", 0, c24948zU0E);
        d = zb7;
        C24948zU0 c24948zU0E2 = C24948zU0.e("kotlin/UShort");
        AbstractC13042fc3.h(c24948zU0E2, "fromString(\"kotlin/UShort\")");
        ZB7 zb72 = new ZB7("USHORT", 1, c24948zU0E2);
        e = zb72;
        C24948zU0 c24948zU0E3 = C24948zU0.e("kotlin/UInt");
        AbstractC13042fc3.h(c24948zU0E3, "fromString(\"kotlin/UInt\")");
        ZB7 zb73 = new ZB7("UINT", 2, c24948zU0E3);
        f = zb73;
        C24948zU0 c24948zU0E4 = C24948zU0.e("kotlin/ULong");
        AbstractC13042fc3.h(c24948zU0E4, "fromString(\"kotlin/ULong\")");
        ZB7 zb74 = new ZB7("ULONG", 3, c24948zU0E4);
        g = zb74;
        h = new ZB7[]{zb7, zb72, zb73, zb74};
    }

    private ZB7(String str, int i, C24948zU0 c24948zU0) {
        this.a = c24948zU0;
        C6432No4 c6432No4J = c24948zU0.j();
        AbstractC13042fc3.h(c6432No4J, "classId.shortClassName");
        this.b = c6432No4J;
        this.c = new C24948zU0(c24948zU0.h(), C6432No4.p(AbstractC13042fc3.q(c6432No4J.h(), "Array")));
    }

    public static ZB7 valueOf(String str) {
        AbstractC13042fc3.i(str, "value");
        return (ZB7) Enum.valueOf(ZB7.class, str);
    }

    public static ZB7[] values() {
        ZB7[] zb7Arr = h;
        ZB7[] zb7Arr2 = new ZB7[zb7Arr.length];
        System.arraycopy(zb7Arr, 0, zb7Arr2, 0, zb7Arr.length);
        return zb7Arr2;
    }

    public final C24948zU0 a() {
        return this.c;
    }

    public final C24948zU0 j() {
        return this.a;
    }

    public final C6432No4 p() {
        return this.b;
    }
}
