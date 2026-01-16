package ir.nasim;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.sO2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC20659sO2 {
    public static Map a(InterfaceC18868pO2 interfaceC18868pO2) {
        AbstractC13042fc3.i(interfaceC18868pO2, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = interfaceC18868pO2.b();
        while (itB.hasNext()) {
            Object objA = interfaceC18868pO2.a(itB.next());
            Object c11637dL5 = linkedHashMap.get(objA);
            if (c11637dL5 == null && !linkedHashMap.containsKey(objA)) {
                c11637dL5 = new C11637dL5();
            }
            C11637dL5 c11637dL52 = (C11637dL5) c11637dL5;
            c11637dL52.a++;
            linkedHashMap.put(objA, c11637dL52);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            AbstractC13042fc3.g(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            AbstractC19810qy7.e(entry).setValue(Integer.valueOf(((C11637dL5) entry.getValue()).a));
        }
        return AbstractC19810qy7.d(linkedHashMap);
    }
}
