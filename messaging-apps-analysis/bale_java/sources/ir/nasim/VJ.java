package ir.nasim;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class VJ {
    public static Object[] a(Object[]... objArr) {
        if (objArr.length == 0) {
            return (Object[]) Array.newInstance(objArr.getClass(), 0);
        }
        int length = 0;
        for (Object[] objArr2 : objArr) {
            length += objArr2.length;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr[0], length);
        int length2 = objArr[0].length;
        for (int i = 1; i < objArr.length; i++) {
            Object[] objArr3 = objArr[i];
            int length3 = objArr3.length;
            System.arraycopy(objArr3, 0, objArrCopyOf, length2, length3);
            length2 += length3;
        }
        return objArrCopyOf;
    }

    public static boolean b(int[] iArr, int i) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (!DG4.a(objArr[i], obj)) {
                i++;
            } else if (i >= 0) {
                return true;
            }
        }
        return false;
    }
}
