package ir.nasim;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
abstract class QJ {
    static Object[] a(Object[] objArr, int i) {
        if (objArr.length < i) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
