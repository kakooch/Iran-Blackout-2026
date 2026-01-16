package ir.nasim;

import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class FG4 {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static Object c(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object d(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static String e(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
