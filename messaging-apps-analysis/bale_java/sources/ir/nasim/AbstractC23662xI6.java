package ir.nasim;

/* renamed from: ir.nasim.xI6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23662xI6 {
    public static final C6432No4 a = C6432No4.s("<no name provided>");
    public static final C6432No4 b = C6432No4.s("<root package>");
    public static final C6432No4 c = C6432No4.p("Companion");
    public static final C6432No4 d = C6432No4.p("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
    public static final C6432No4 e = C6432No4.s("<anonymous>");

    private static /* synthetic */ void a(int i) {
        String str = i != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 1 ? 2 : 3];
        if (i != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = "name";
        }
        if (i != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(C6432No4 c6432No4) {
        if (c6432No4 == null) {
            a(1);
        }
        return (c6432No4.h().isEmpty() || c6432No4.q()) ? false : true;
    }

    public static C6432No4 c(C6432No4 c6432No4) {
        if (c6432No4 == null || c6432No4.q()) {
            c6432No4 = d;
        }
        if (c6432No4 == null) {
            a(0);
        }
        return c6432No4;
    }
}
