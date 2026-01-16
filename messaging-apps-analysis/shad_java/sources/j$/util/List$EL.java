package j$.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: j$.util.List$-EL, reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class List$EL {
    public static void sort(List list, Comparator comparator) {
        if (DesugarCollections.b.isInstance(list)) {
            DesugarCollections.e(list, comparator);
            return;
        }
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        ListIterator listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }
}
