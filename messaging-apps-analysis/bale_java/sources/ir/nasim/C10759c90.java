package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.c90, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C10759c90 {
    private final Map a = new HashMap();

    C10759c90() {
    }

    int[] a() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry entry : this.a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > iIntValue) {
                iIntValue = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return BO4.b(arrayList);
    }

    void b(int i) {
        Integer num = (Integer) this.a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
