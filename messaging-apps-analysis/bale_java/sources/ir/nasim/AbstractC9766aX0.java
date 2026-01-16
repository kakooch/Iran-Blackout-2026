package ir.nasim;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.aX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9766aX0 {
    public static List a(List list) {
        AbstractC13042fc3.i(list, "builder");
        return ((AB3) list).W();
    }

    public static final Object[] b(Object[] objArr, boolean z) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (z && AbstractC13042fc3.d(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List c() {
        return new AB3(0, 1, null);
    }

    public static List d(int i) {
        return new AB3(i);
    }

    public static List e(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        AbstractC13042fc3.h(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static Object[] f(int i, Object[] objArr) {
        AbstractC13042fc3.i(objArr, "array");
        if (i < objArr.length) {
            objArr[i] = null;
        }
        return objArr;
    }
}
