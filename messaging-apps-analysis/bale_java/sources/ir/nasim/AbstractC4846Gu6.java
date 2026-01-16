package ir.nasim;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.Gu6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4846Gu6 extends AbstractC4597Fu6 {
    public static Set j(Set set, Iterable iterable) {
        AbstractC13042fc3.i(set, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        Collection<?> collectionF = AbstractC13610gX0.F(iterable);
        if (collectionF.isEmpty()) {
            return AbstractC15401jX0.r1(set);
        }
        if (!(collectionF instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionF);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!collectionF.contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static Set k(Set set, Object obj) {
        AbstractC13042fc3.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC19460qO3.f(set.size()));
        boolean z = false;
        for (Object obj2 : set) {
            boolean z2 = true;
            if (!z && AbstractC13042fc3.d(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    public static Set l(Set set, Iterable iterable) {
        int size;
        AbstractC13042fc3.i(set, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        Integer numY = AbstractC10976cX0.y(iterable);
        if (numY != null) {
            size = set.size() + numY.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC19460qO3.f(size));
        linkedHashSet.addAll(set);
        AbstractC13610gX0.D(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static Set m(Set set, Object obj) {
        AbstractC13042fc3.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC19460qO3.f(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
