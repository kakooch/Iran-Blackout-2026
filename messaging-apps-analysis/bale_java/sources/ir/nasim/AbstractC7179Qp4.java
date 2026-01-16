package ir.nasim;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Qp4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7179Qp4 {
    public static final List a(Map map, UA2 ua2) {
        AbstractC13042fc3.i(map, "<this>");
        AbstractC13042fc3.i(ua2, "isArgumentMissing");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            androidx.navigation.b bVar = (androidx.navigation.b) entry.getValue();
            if (bVar != null && !bVar.c() && !bVar.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (((Boolean) ua2.invoke((String) obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
