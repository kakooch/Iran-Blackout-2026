package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public final class D44 {
    public final Set a(List list, List list2) {
        ArrayList arrayList;
        AbstractC13042fc3.i(list2, "loadReaction");
        if (list != null) {
            List list3 = list;
            arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((C15759k74) it.next()).b());
            }
        } else {
            arrayList = null;
        }
        return b(arrayList, list2);
    }

    public final Set b(List list, List list2) {
        Object obj;
        AbstractC13042fc3.i(list2, "loadReaction");
        if (list == null) {
            return AbstractC15401jX0.r1(list2);
        }
        List list3 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
        Iterator it = list3.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (AbstractC13042fc3.d(str, ((C15759k74) next).b())) {
                    obj = next;
                    break;
                }
            }
            C15759k74 c15759k74 = (C15759k74) obj;
            if (c15759k74 == null) {
                c15759k74 = new C15759k74(str, 0L, false, 6, null);
            }
            arrayList.add(c15759k74);
        }
        Set setQ1 = AbstractC15401jX0.q1(arrayList);
        Iterator it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (AbstractC13042fc3.d(((C15759k74) next2).b(), "👁️")) {
                obj = next2;
                break;
            }
        }
        C15759k74 c15759k742 = (C15759k74) obj;
        if (c15759k742 != null) {
            setQ1.add(c15759k742);
        } else {
            setQ1.add(new C15759k74("👁️", 0L, false, 6, null));
        }
        return setQ1;
    }
}
