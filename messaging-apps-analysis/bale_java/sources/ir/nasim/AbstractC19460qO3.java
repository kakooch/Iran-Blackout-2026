package ir.nasim;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.qO3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19460qO3 extends AbstractC18869pO3 {
    public static Map c(Map map) {
        AbstractC13042fc3.i(map, "builder");
        return ((JN3) map).p();
    }

    public static Map d() {
        return new JN3();
    }

    public static Map e(int i) {
        return new JN3(i);
    }

    public static int f(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map g(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "pair");
        Map mapSingletonMap = Collections.singletonMap(xv4.e(), xv4.f());
        AbstractC13042fc3.h(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map h(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        AbstractC13042fc3.h(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static SortedMap i(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        return new TreeMap(map);
    }

    public static SortedMap j(Map map, Comparator comparator) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
