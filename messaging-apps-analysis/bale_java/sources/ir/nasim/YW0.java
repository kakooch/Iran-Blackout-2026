package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class YW0 {
    public static final void a(Collection collection, Object obj) {
        AbstractC13042fc3.i(collection, "<this>");
        if (obj != null) {
            collection.add(obj);
        }
    }

    private static final int b(int i) {
        if (i < 3) {
            return 3;
        }
        return i + (i / 3) + 1;
    }

    public static final List c(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return AbstractC10360bX0.m();
        }
        if (size == 1) {
            return AbstractC9766aX0.e(AbstractC15401jX0.q0(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final Map d(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    public static final HashMap e(int i) {
        return new HashMap(b(i));
    }

    public static final HashSet f(int i) {
        return new HashSet(b(i));
    }

    public static final LinkedHashSet g(int i) {
        return new LinkedHashSet(b(i));
    }
}
