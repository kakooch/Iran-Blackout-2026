package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.cX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10976cX0 extends AbstractC10360bX0 {
    public static int x(Iterable iterable, int i) {
        AbstractC13042fc3.i(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static final Integer y(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static List z(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, (Iterable) it.next());
        }
        return arrayList;
    }
}
