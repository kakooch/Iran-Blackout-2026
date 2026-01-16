package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ary {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Iterable<T> iterable) {
        T t;
        if (iterable instanceof List) {
            if (iterable.isEmpty()) {
                throw new NoSuchElementException();
            }
            return (T) iterable.get(iterable.size() - 1);
        }
        Iterator it = iterable.iterator();
        do {
            t = (T) it.next();
        } while (it.hasNext());
        return t;
    }

    static int b(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    static int c(Object obj) {
        return b(obj == null ? 0 : obj.hashCode());
    }

    static int d(int i) {
        int iMax = Math.max(i, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= iHighestOneBit) {
            return iHighestOneBit;
        }
        int i2 = iHighestOneBit + iHighestOneBit;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    static Object e(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    static int f(Object obj, int i) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }

    static void g(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    static int h(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    static int i(int i, int i2) {
        return i & (i2 ^ (-1));
    }

    static int j(int i, int i2, int i3) {
        return (i & (i3 ^ (-1))) | (i2 & i3);
    }

    static int k(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i2;
        int i3;
        int iC = c(obj);
        int i4 = iC & i;
        int iF = f(obj3, i4);
        if (iF == 0) {
            return -1;
        }
        int i5 = i(iC, i);
        int i6 = -1;
        while (true) {
            i2 = iF - 1;
            i3 = iArr[i2];
            if (i(i3, i) == i5 && apz.b(obj, objArr[i2]) && (objArr2 == null || apz.b(obj2, objArr2[i2]))) {
                break;
            }
            int i7 = i3 & i;
            if (i7 == 0) {
                return -1;
            }
            i6 = i2;
            iF = i7;
        }
        int i8 = i3 & i;
        if (i6 == -1) {
            g(obj3, i4, i8);
        } else {
            iArr[i6] = j(iArr[i6], i8, i);
        }
        return i2;
    }

    static void l(Object obj, Object obj2) {
        if (obj == null) {
            String strValueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("null key in entry: null=");
            sb.append(strValueOf);
            throw new NullPointerException(sb.toString());
        }
        if (obj2 != null) {
            return;
        }
        String strValueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 26);
        sb2.append("null value in entry: ");
        sb2.append(strValueOf2);
        sb2.append("=null");
        throw new NullPointerException(sb2.toString());
    }

    static void m(boolean z) {
        aqd.g(z, "no calls to next() since the last call to remove()");
    }

    static void n(int i, String str) {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void o(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void p(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void q(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void r(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static <T> T s(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    public static <T> T t(T t) {
        t.getClass();
        return t;
    }

    public static void u(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void v(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> void w(T t, Object obj) {
        if (t == null) {
            throw new IllegalStateException((String) obj);
        }
    }
}
