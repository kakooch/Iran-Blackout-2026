package ir.nasim;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.rO3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20051rO3 extends AbstractC19460qO3 {
    public static Map A(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static Map k() {
        C22966w72 c22966w72 = C22966w72.a;
        AbstractC13042fc3.g(c22966w72, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c22966w72;
    }

    public static Object l(Map map, Object obj) {
        AbstractC13042fc3.i(map, "<this>");
        return AbstractC18869pO3.a(map, obj);
    }

    public static HashMap m(XV4... xv4Arr) {
        AbstractC13042fc3.i(xv4Arr, "pairs");
        HashMap map = new HashMap(AbstractC19460qO3.f(xv4Arr.length));
        v(map, xv4Arr);
        return map;
    }

    public static Map n(XV4... xv4Arr) {
        AbstractC13042fc3.i(xv4Arr, "pairs");
        return xv4Arr.length > 0 ? z(xv4Arr, new LinkedHashMap(AbstractC19460qO3.f(xv4Arr.length))) : k();
    }

    public static Map o(Map map, Object obj) {
        AbstractC13042fc3.i(map, "<this>");
        Map mapA = A(map);
        mapA.remove(obj);
        return q(mapA);
    }

    public static Map p(XV4... xv4Arr) {
        AbstractC13042fc3.i(xv4Arr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(xv4Arr.length));
        v(linkedHashMap, xv4Arr);
        return linkedHashMap;
    }

    public static final Map q(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : AbstractC19460qO3.h(map) : k();
    }

    public static Map r(Map map, XV4 xv4) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(xv4, "pair");
        if (map.isEmpty()) {
            return AbstractC19460qO3.g(xv4);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(xv4.e(), xv4.f());
        return linkedHashMap;
    }

    public static Map s(Map map, Iterable iterable) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(iterable, "pairs");
        if (map.isEmpty()) {
            return w(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        u(linkedHashMap, iterable);
        return linkedHashMap;
    }

    public static Map t(Map map, Map map2) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final void u(Map map, Iterable iterable) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            XV4 xv4 = (XV4) it.next();
            map.put(xv4.a(), xv4.b());
        }
    }

    public static final void v(Map map, XV4[] xv4Arr) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(xv4Arr, "pairs");
        for (XV4 xv4 : xv4Arr) {
            map.put(xv4.a(), xv4.b());
        }
    }

    public static Map w(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return q(x(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return k();
        }
        if (size != 1) {
            return x(iterable, new LinkedHashMap(AbstractC19460qO3.f(collection.size())));
        }
        return AbstractC19460qO3.g((XV4) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map x(Iterable iterable, Map map) {
        AbstractC13042fc3.i(iterable, "<this>");
        AbstractC13042fc3.i(map, "destination");
        u(map, iterable);
        return map;
    }

    public static Map y(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? A(map) : AbstractC19460qO3.h(map) : k();
    }

    public static final Map z(XV4[] xv4Arr, Map map) {
        AbstractC13042fc3.i(xv4Arr, "<this>");
        AbstractC13042fc3.i(map, "destination");
        v(map, xv4Arr);
        return map;
    }
}
