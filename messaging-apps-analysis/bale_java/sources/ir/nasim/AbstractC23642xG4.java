package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.xG4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23642xG4 {
    private static final Object[] a = new Object[0];
    private static final AbstractC23052wG4 b = new C3587Bm4(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(List list, int i) {
        int size = list.size();
        if (i < 0 || i >= size) {
            AbstractC22970w76.c("Index " + i + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(List list, int i, int i2) {
        int size = list.size();
        if (i > i2) {
            AbstractC22970w76.a("Indices are out of order. fromIndex (" + i + ") is greater than toIndex (" + i2 + ").");
        }
        if (i < 0) {
            AbstractC22970w76.c("fromIndex (" + i + ") is less than 0.");
        }
        if (i2 > size) {
            AbstractC22970w76.c("toIndex (" + i2 + ") is more than than the list size (" + size + ')');
        }
    }

    public static final AbstractC23052wG4 f() {
        AbstractC23052wG4 abstractC23052wG4 = b;
        AbstractC13042fc3.g(abstractC23052wG4, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return abstractC23052wG4;
    }

    public static final C3587Bm4 g(Object obj) {
        C3587Bm4 c3587Bm4 = new C3587Bm4(1);
        c3587Bm4.n(obj);
        return c3587Bm4;
    }

    public static final C3587Bm4 h(Object obj, Object obj2) {
        C3587Bm4 c3587Bm4 = new C3587Bm4(2);
        c3587Bm4.n(obj);
        c3587Bm4.n(obj2);
        return c3587Bm4;
    }
}
