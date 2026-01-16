package ir.nasim;

import java.lang.reflect.Array;

/* loaded from: classes8.dex */
abstract class YJ {
    public static final Object[] a(Object[] objArr, int i) throws NegativeArraySizeException {
        AbstractC13042fc3.i(objArr, "reference");
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
        AbstractC13042fc3.g(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void b(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }
}
