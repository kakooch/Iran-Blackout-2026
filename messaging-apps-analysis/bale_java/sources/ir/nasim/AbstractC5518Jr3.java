package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Jr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5518Jr3 {
    private static final C7332Rg4 a = new C7332Rg4("KotlinTypeRefiner");

    public static final C7332Rg4 a() {
        return a;
    }

    public static final List b(AbstractC5284Ir3 abstractC5284Ir3, Iterable iterable) {
        AbstractC13042fc3.i(abstractC5284Ir3, "<this>");
        AbstractC13042fc3.i(iterable, "types");
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(abstractC5284Ir3.g((AbstractC4099Dr3) it.next()));
        }
        return arrayList;
    }
}
