package ir.nasim;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class ON3 {
    public static final Map a(Map map, Map map2, Object obj) {
        AbstractC13042fc3.i(map, "newMap");
        AbstractC13042fc3.i(map2, "oldMap");
        Set setL = AbstractC4846Gu6.l(map.keySet(), map2.keySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : setL) {
            if (!AbstractC13042fc3.d(map.get(obj2), map2.get(obj2))) {
                Object obj3 = map.get(obj2);
                if (obj3 == null) {
                    obj3 = obj;
                }
                linkedHashMap.put(obj2, obj3);
            }
        }
        return linkedHashMap;
    }
}
