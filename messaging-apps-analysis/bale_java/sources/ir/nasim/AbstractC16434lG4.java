package ir.nasim;

/* renamed from: ir.nasim.lG4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16434lG4 {
    static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }

    static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    static Object[] c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    public static Object[] d(Object[] objArr, int i) {
        return AbstractC6343Ne5.b(objArr, i);
    }
}
