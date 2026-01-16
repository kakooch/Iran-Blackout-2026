package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.tO3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21263tO3 extends AbstractC20660sO3 {
    public static InterfaceC23384wp6 B(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        return AbstractC15401jX0.g0(map.entrySet());
    }

    public static List C(Map map) {
        AbstractC13042fc3.i(map, "<this>");
        if (map.size() == 0) {
            return AbstractC10360bX0.m();
        }
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return AbstractC10360bX0.m();
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (!it.hasNext()) {
            return AbstractC9766aX0.e(new XV4(entry.getKey(), entry.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new XV4(entry.getKey(), entry.getValue()));
        do {
            Map.Entry entry2 = (Map.Entry) it.next();
            arrayList.add(new XV4(entry2.getKey(), entry2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
