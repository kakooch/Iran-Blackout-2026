package ir.nasim;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class Pv8 {
    final TreeMap a = new TreeMap();
    final TreeMap b = new TreeMap();

    private static final int c(C20322ro8 c20322ro8, C20853si8 c20853si8, InterfaceC22720vi8 interfaceC22720vi8) {
        InterfaceC22720vi8 interfaceC22720vi8A = c20853si8.a(c20322ro8, Collections.singletonList(interfaceC22720vi8));
        if (interfaceC22720vi8A instanceof Ph8) {
            return AbstractC9951ap8.b(interfaceC22720vi8A.k().doubleValue());
        }
        return -1;
    }

    public final void a(String str, int i, C20853si8 c20853si8, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.b;
        } else {
            if (!"edit".equals(str2)) {
                throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
            }
            treeMap = this.a;
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            i = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i), c20853si8);
    }

    public final void b(C20322ro8 c20322ro8, C18461oh8 c18461oh8) {
        Jr8 jr8 = new Jr8(c18461oh8);
        for (Integer num : this.a.keySet()) {
            C16097kh8 c16097kh8Clone = c18461oh8.b().clone();
            int iC = c(c20322ro8, (C20853si8) this.a.get(num), jr8);
            if (iC == 2 || iC == -1) {
                c18461oh8.f(c16097kh8Clone);
            }
        }
        Iterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            c(c20322ro8, (C20853si8) this.b.get((Integer) it.next()), jr8);
        }
    }
}
