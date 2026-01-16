package ir.nasim;

import java.nio.charset.Charset;
import java.util.Arrays;

/* renamed from: ir.nasim.ao8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9941ao8 {
    private static final Charset a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    public static final Object c = new Object();

    public static boolean a(int[] iArr, int[] iArr2) {
        return (iArr == null || iArr.length == 0) ? iArr2 == null || iArr2.length == 0 : Arrays.equals(iArr, iArr2);
    }

    public static boolean b(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length || objArr[i] != null) {
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z = i >= length;
                boolean z2 = i2 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i].equals(objArr2[i2])) {
                    return false;
                }
                i++;
                i2++;
            } else {
                i++;
            }
        }
    }

    public static int c(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr);
    }

    public static int d(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int iHashCode = 0;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                iHashCode = (iHashCode * 31) + obj.hashCode();
            }
        }
        return iHashCode;
    }

    public static void e(Zn8 zn8, Zn8 zn82) {
        zn8.getClass();
    }
}
