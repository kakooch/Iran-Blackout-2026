package ir.nasim;

import ir.nasim.W24;
import java.util.Collection;
import java.util.LinkedHashSet;

/* renamed from: ir.nasim.sd6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20801sd6 {
    public static final Collection a(Collection collection, Collection collection2) {
        AbstractC13042fc3.i(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final CE6 b(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "scopes");
        CE6 ce6 = new CE6();
        for (Object obj : iterable) {
            W24 w24 = (W24) obj;
            if (w24 != null && w24 != W24.b.b) {
                ce6.add(obj);
            }
        }
        return ce6;
    }
}
