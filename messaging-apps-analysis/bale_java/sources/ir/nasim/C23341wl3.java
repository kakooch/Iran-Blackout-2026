package ir.nasim;

/* renamed from: ir.nasim.wl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23341wl3 {
    public static final C23341wl3 a = new C23341wl3();
    public static final C9424Zw2 b = new C9424Zw2("kotlin.jvm.JvmField");
    private static final C24948zU0 c;

    static {
        C24948zU0 c24948zU0M = C24948zU0.m(new C9424Zw2("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        AbstractC13042fc3.h(c24948zU0M, "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
        c = c24948zU0M;
    }

    private C23341wl3() {
    }

    public static final String a(String str) {
        AbstractC13042fc3.i(str, "propertyName");
        return e(str) ? str : AbstractC13042fc3.q("get", BF0.a(str));
    }

    public static final boolean b(String str) {
        AbstractC13042fc3.i(str, "name");
        return AbstractC20153rZ6.S(str, "get", false, 2, null) || AbstractC20153rZ6.S(str, "is", false, 2, null);
    }

    public static final boolean c(String str) {
        AbstractC13042fc3.i(str, "name");
        return AbstractC20153rZ6.S(str, "set", false, 2, null);
    }

    public static final String d(String str) {
        String strA;
        AbstractC13042fc3.i(str, "propertyName");
        if (e(str)) {
            strA = str.substring(2);
            AbstractC13042fc3.h(strA, "(this as java.lang.String).substring(startIndex)");
        } else {
            strA = BF0.a(str);
        }
        return AbstractC13042fc3.q("set", strA);
    }

    public static final boolean e(String str) {
        AbstractC13042fc3.i(str, "name");
        if (!AbstractC20153rZ6.S(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char cCharAt = str.charAt(2);
        return AbstractC13042fc3.k(97, cCharAt) > 0 || AbstractC13042fc3.k(cCharAt, 122) > 0;
    }
}
