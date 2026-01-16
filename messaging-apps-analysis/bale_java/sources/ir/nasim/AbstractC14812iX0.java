package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.iX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14812iX0 extends AbstractC14201hX0 {
    public static List Z(Iterable iterable, Class cls) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(cls, "klass");
        return (List) a0(iterable, new ArrayList(), cls);
    }

    public static final Collection a0(Iterable iterable, Collection collection, Class cls) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        AbstractC13042fc3.i(cls, "klass");
        for (Object obj : iterable) {
            if (cls.isInstance(obj)) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static void b0(List list) {
        AbstractC13042fc3.i(list, "<this>");
        Collections.reverse(list);
    }

    public static SortedSet c0(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        return (SortedSet) AbstractC15401jX0.i1(iterable, new TreeSet());
    }

    public static SortedSet d0(Iterable iterable, Comparator comparator) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        return (SortedSet) AbstractC15401jX0.i1(iterable, new TreeSet(comparator));
    }
}
