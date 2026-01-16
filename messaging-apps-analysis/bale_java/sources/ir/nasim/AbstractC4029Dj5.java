package ir.nasim;

/* renamed from: ir.nasim.Dj5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC4029Dj5 {
    private static String a(int i, int i2, String str) {
        if (i < 0) {
            return AbstractC13634gZ6.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AbstractC13634gZ6.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String b(int i, int i2, String str) {
        if (i < 0) {
            return AbstractC13634gZ6.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AbstractC13634gZ6.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String c(int i, int i2, int i3) {
        return (i < 0 || i > i3) ? b(i, i3, "start index") : (i2 < 0 || i2 > i3) ? b(i2, i3, "end index") : AbstractC13634gZ6.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(AbstractC13634gZ6.b(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void g(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(AbstractC13634gZ6.b(str, Long.valueOf(j)));
        }
    }

    public static int h(int i, int i2) {
        return i(i, i2, "index");
    }

    public static int i(int i, int i2, String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(a(i, i2, str));
        }
        return i;
    }

    public static Object j(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object k(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int l(int i, int i2) {
        return m(i, i2, "index");
    }

    public static int m(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b(i, i2, str));
        }
        return i;
    }

    public static void n(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(c(i, i2, i3));
        }
    }

    public static void o(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void p(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
