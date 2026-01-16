package ir.nasim;

import ir.nasim.C20603sI0;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.nI0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17630nI0 {
    private static ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        C20603sI0 c20603sI0H = null;
        while (it.hasNext()) {
            C20603sI0 c20603sI0 = (C20603sI0) it.next();
            C20603sI0.a aVarG = c20603sI0.g();
            C20603sI0.a aVar = C20603sI0.a.ADD;
            if (aVarG == aVar) {
                if (c20603sI0H != null) {
                    if (c20603sI0H.g() == aVar && c20603sI0H.d() + c20603sI0H.f() == c20603sI0.d()) {
                        c20603sI0H = C20603sI0.h(c20603sI0H, c20603sI0);
                    } else {
                        arrayList2.add(c20603sI0H);
                        c20603sI0H = null;
                    }
                }
            } else if (c20603sI0H != null) {
                arrayList2.add(c20603sI0H);
                c20603sI0H = null;
            }
            if (c20603sI0H == null) {
                c20603sI0H = c20603sI0;
            }
        }
        if (c20603sI0H != null) {
            arrayList2.add(c20603sI0H);
        }
        return arrayList2;
    }

    public static ArrayList b(ArrayList arrayList) {
        return a(arrayList);
    }
}
