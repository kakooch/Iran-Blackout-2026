package ir.nasim;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class WB7 {
    public static final WB7 c;
    public static final WB7 d;
    public static final WB7 e;
    public static final WB7 f;
    private static final /* synthetic */ WB7[] g;
    private final C24948zU0 a;
    private final C6432No4 b;

    static {
        C24948zU0 c24948zU0E = C24948zU0.e("kotlin/UByteArray");
        AbstractC13042fc3.h(c24948zU0E, "fromString(\"kotlin/UByteArray\")");
        WB7 wb7 = new WB7("UBYTEARRAY", 0, c24948zU0E);
        c = wb7;
        C24948zU0 c24948zU0E2 = C24948zU0.e("kotlin/UShortArray");
        AbstractC13042fc3.h(c24948zU0E2, "fromString(\"kotlin/UShortArray\")");
        WB7 wb72 = new WB7("USHORTARRAY", 1, c24948zU0E2);
        d = wb72;
        C24948zU0 c24948zU0E3 = C24948zU0.e("kotlin/UIntArray");
        AbstractC13042fc3.h(c24948zU0E3, "fromString(\"kotlin/UIntArray\")");
        WB7 wb73 = new WB7("UINTARRAY", 2, c24948zU0E3);
        e = wb73;
        C24948zU0 c24948zU0E4 = C24948zU0.e("kotlin/ULongArray");
        AbstractC13042fc3.h(c24948zU0E4, "fromString(\"kotlin/ULongArray\")");
        WB7 wb74 = new WB7("ULONGARRAY", 3, c24948zU0E4);
        f = wb74;
        g = new WB7[]{wb7, wb72, wb73, wb74};
    }

    private WB7(String str, int i, C24948zU0 c24948zU0) {
        this.a = c24948zU0;
        C6432No4 c6432No4J = c24948zU0.j();
        AbstractC13042fc3.h(c6432No4J, "classId.shortClassName");
        this.b = c6432No4J;
    }

    public static WB7 valueOf(String str) {
        AbstractC13042fc3.i(str, "value");
        return (WB7) Enum.valueOf(WB7.class, str);
    }

    public static WB7[] values() {
        WB7[] wb7Arr = g;
        WB7[] wb7Arr2 = new WB7[wb7Arr.length];
        System.arraycopy(wb7Arr, 0, wb7Arr2, 0, wb7Arr.length);
        return wb7Arr2;
    }

    public final C6432No4 a() {
        return this.b;
    }
}
