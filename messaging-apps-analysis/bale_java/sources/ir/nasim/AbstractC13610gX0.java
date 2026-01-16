package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.gX0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13610gX0 extends AbstractC12992fX0 {
    public static boolean C(Collection collection, InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(collection, "<this>");
        AbstractC13042fc3.i(interfaceC23384wp6, "elements");
        Iterator it = interfaceC23384wp6.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean D(Collection collection, Iterable iterable) {
        AbstractC13042fc3.i(collection, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean E(Collection collection, Object[] objArr) {
        AbstractC13042fc3.i(collection, "<this>");
        AbstractC13042fc3.i(objArr, "elements");
        return collection.addAll(AbstractC9648aK.d(objArr));
    }

    public static final Collection F(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = AbstractC15401jX0.m1(iterable);
        }
        return (Collection) iterable;
    }

    private static final boolean G(Iterable iterable, UA2 ua2, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (((Boolean) ua2.invoke(it.next())).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    private static final boolean H(List list, UA2 ua2, boolean z) {
        int i;
        if (!(list instanceof RandomAccess)) {
            AbstractC13042fc3.g(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return G(AbstractC19810qy7.b(list), ua2, z);
        }
        int iO = AbstractC10360bX0.o(list);
        if (iO >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                Object obj = list.get(i2);
                if (((Boolean) ua2.invoke(obj)).booleanValue() != z) {
                    if (i != i2) {
                        list.set(i, obj);
                    }
                    i++;
                }
                if (i2 == iO) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int iO2 = AbstractC10360bX0.o(list);
        if (i > iO2) {
            return true;
        }
        while (true) {
            list.remove(iO2);
            if (iO2 == i) {
                return true;
            }
            iO2--;
        }
    }

    public static boolean I(Iterable iterable, UA2 ua2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return G(iterable, ua2, true);
    }

    public static final boolean J(Collection collection, Iterable iterable) {
        AbstractC13042fc3.i(collection, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        return collection.removeAll(F(iterable));
    }

    public static boolean K(List list, UA2 ua2) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return H(list, ua2, true);
    }

    public static Object L(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static Object M(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static Object N(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(AbstractC10360bX0.o(list));
    }

    public static Object O(List list) {
        AbstractC13042fc3.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(AbstractC10360bX0.o(list));
    }

    public static boolean P(Iterable iterable, UA2 ua2) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return G(iterable, ua2, false);
    }

    public static final boolean Q(Collection collection, Iterable iterable) {
        AbstractC13042fc3.i(collection, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        return collection.retainAll(F(iterable));
    }
}
