package ir.nasim;

import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.pO3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC18869pO3 {
    public static final Object a(Map map, Object obj) {
        AbstractC13042fc3.i(map, "<this>");
        if (map instanceof InterfaceC11662dO3) {
            return ((InterfaceC11662dO3) map).D(obj);
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static Map b(Map map, UA2 ua2) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(ua2, "defaultValue");
        return map instanceof InterfaceC11662dO3 ? b(((InterfaceC11662dO3) map).getMap(), ua2) : new C12305eO3(map, ua2);
    }
}
