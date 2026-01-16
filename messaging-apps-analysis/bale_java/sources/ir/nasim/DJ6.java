package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DJ6 {
    public static final void a(ArrayList arrayList) {
        arrayList.clear();
    }

    public static /* synthetic */ ArrayList c(ArrayList arrayList, int i, ED1 ed1) {
        if ((i & 1) != 0) {
            arrayList = new ArrayList();
        }
        return b(arrayList);
    }

    public static final int d(ArrayList arrayList) {
        return arrayList.size();
    }

    public static final boolean e(ArrayList arrayList) {
        return arrayList.isEmpty();
    }

    public static final boolean f(ArrayList arrayList) {
        return !e(arrayList);
    }

    public static final Object g(ArrayList arrayList) {
        return arrayList.get(d(arrayList) - 1);
    }

    public static final Object h(ArrayList arrayList, int i) {
        return arrayList.get(i);
    }

    public static final Object i(ArrayList arrayList) {
        return arrayList.remove(d(arrayList) - 1);
    }

    public static final boolean j(ArrayList arrayList, Object obj) {
        return arrayList.add(obj);
    }

    public static final Object[] k(ArrayList arrayList) {
        int size = arrayList.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            objArr[i] = arrayList.get(i);
        }
        return objArr;
    }

    public static ArrayList b(ArrayList arrayList) {
        return arrayList;
    }
}
