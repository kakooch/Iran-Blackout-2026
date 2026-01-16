package ir.nasim;

/* loaded from: classes3.dex */
public abstract class Hu8 {
    public static int a(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b(i, i2, "index"));
        }
        return i;
    }

    private static String b(int i, int i2, String str) {
        if (i < 0) {
            return Jv8.a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return Jv8.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
