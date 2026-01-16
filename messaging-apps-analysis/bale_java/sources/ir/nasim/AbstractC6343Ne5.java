package ir.nasim;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/* renamed from: ir.nasim.Ne5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC6343Ne5 {
    static Object[] a(Object[] objArr, int i, int i2, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i, i2, objArr2.getClass());
    }

    static Object[] b(Object[] objArr, int i) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
    }

    static Map c(int i) {
        return C12668f01.J(i);
    }
}
