package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.bX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10360bX0 extends AbstractC9766aX0 {
    public static ArrayList g(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new AJ(objArr, true));
    }

    public static final Collection h(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return new AJ(objArr, false);
    }

    public static final int i(List list, int i, int i2, UA2 ua2) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(ua2, "comparison");
        u(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iIntValue = ((Number) ua2.invoke(list.get(i4))).intValue();
            if (iIntValue < 0) {
                i = i4 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static final int j(List list, Comparable comparable, int i, int i2) {
        AbstractC13042fc3.i(list, "<this>");
        u(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iD = AbstractC18050o01.d((Comparable) list.get(i4), comparable);
            if (iD < 0) {
                i = i4 + 1;
            } else {
                if (iD <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int k(List list, int i, int i2, UA2 ua2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return i(list, i, i2, ua2);
    }

    public static /* synthetic */ int l(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return j(list, comparable, i, i2);
    }

    public static List m() {
        return C22370v72.a;
    }

    public static C24411ya3 n(Collection collection) {
        AbstractC13042fc3.i(collection, "<this>");
        return new C24411ya3(0, collection.size() - 1);
    }

    public static int o(List list) {
        AbstractC13042fc3.i(list, "<this>");
        return list.size() - 1;
    }

    public static List p(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return objArr.length > 0 ? AbstractC9648aK.d(objArr) : m();
    }

    public static List q(Object obj) {
        return obj != null ? AbstractC9766aX0.e(obj) : m();
    }

    public static List r(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return AbstractC10242bK.Y(objArr);
    }

    public static List s(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new AJ(objArr, true));
    }

    public static final List t(List list) {
        AbstractC13042fc3.i(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : AbstractC9766aX0.e(list.get(0)) : m();
    }

    private static final void u(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void v() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void w() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
