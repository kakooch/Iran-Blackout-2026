package ir.eitaa.messenger.support;

import ir.eitaa.tgnet.ConnectionsManager;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class ArrayUtils {
    private static final int CACHE_SIZE = 73;
    private static Object[] EMPTY = new Object[0];
    private static Object[] sCache = new Object[73];

    public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            int i2 = (1 << i) - 12;
            if (need <= i2) {
                return i2;
            }
        }
        return need;
    }

    private ArrayUtils() {
    }

    public static int idealBooleanArraySize(int need) {
        return idealByteArraySize(need);
    }

    public static int idealShortArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    public static int idealCharArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    public static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    public static int idealFloatArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    public static int idealObjectArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }

    public static boolean equals(byte[] array1, byte[] array2, int length) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length < length || array2.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static <T> T[] emptyArray(Class<T> cls) throws NegativeArraySizeException {
        if (cls == Object.class) {
            return (T[]) EMPTY;
        }
        int iIdentityHashCode = ((System.identityHashCode(cls) / 8) & ConnectionsManager.DEFAULT_DATACENTER_ID) % 73;
        Object objNewInstance = sCache[iIdentityHashCode];
        if (objNewInstance == null || objNewInstance.getClass().getComponentType() != cls) {
            objNewInstance = Array.newInstance((Class<?>) cls, 0);
            sCache[iIdentityHashCode] = objNewInstance;
        }
        return (T[]) ((Object[]) objNewInstance);
    }

    public static <T> boolean contains(T[] array, T value) {
        for (T t : array) {
            if (t == null) {
                if (value == null) {
                    return true;
                }
            } else if (value != null && t.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(int[] array, int value) {
        if (array == null) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static long total(long[] array) {
        long j = 0;
        for (long j2 : array) {
            j += j2;
        }
        return j;
    }

    public static <T> T[] appendElement(Class<T> cls, T[] tArr, T t) {
        T[] tArr2;
        int i = 0;
        if (tArr != null) {
            int length = tArr.length;
            tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length + 1));
            System.arraycopy(tArr, 0, tArr2, 0, length);
            i = length;
        } else {
            tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 1));
        }
        tArr2[i] = t;
        return tArr2;
    }

    public static <T> T[] removeElement(Class<T> cls, T[] tArr, T t) {
        if (tArr != null) {
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                if (tArr[i] == t) {
                    if (length == 1) {
                        return null;
                    }
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length - 1));
                    System.arraycopy(tArr, 0, tArr2, 0, i);
                    System.arraycopy(tArr, i + 1, tArr2, i, (length - i) - 1);
                    return tArr2;
                }
            }
        }
        return tArr;
    }

    public static int[] appendInt(int[] cur, int val) {
        if (cur == null) {
            return new int[]{val};
        }
        int length = cur.length;
        for (int i : cur) {
            if (i == val) {
                return cur;
            }
        }
        int[] iArr = new int[length + 1];
        System.arraycopy(cur, 0, iArr, 0, length);
        iArr[length] = val;
        return iArr;
    }

    public static int[] removeInt(int[] cur, int val) {
        if (cur == null) {
            return null;
        }
        int length = cur.length;
        for (int i = 0; i < length; i++) {
            if (cur[i] == val) {
                int i2 = length - 1;
                int[] iArr = new int[i2];
                if (i > 0) {
                    System.arraycopy(cur, 0, iArr, 0, i);
                }
                if (i < i2) {
                    System.arraycopy(cur, i + 1, iArr, i, (length - i) - 1);
                }
                return iArr;
            }
        }
        return cur;
    }
}
