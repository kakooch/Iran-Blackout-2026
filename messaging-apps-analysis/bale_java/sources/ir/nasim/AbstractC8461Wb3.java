package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Wb3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC8461Wb3 {
    public static final AbstractC18174oC7 a(List list) {
        XC6 xc6S0;
        AbstractC13042fc3.i(list, "types");
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("Expected some types".toString());
        }
        if (size == 1) {
            return (AbstractC18174oC7) AbstractC15401jX0.V0(list);
        }
        List<AbstractC18174oC7> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        boolean z = false;
        boolean z2 = false;
        for (AbstractC18174oC7 abstractC18174oC7 : list2) {
            z = z || AbstractC4816Gr3.a(abstractC18174oC7);
            if (abstractC18174oC7 instanceof XC6) {
                xc6S0 = (XC6) abstractC18174oC7;
            } else {
                if (!(abstractC18174oC7 instanceof AbstractC6200Mp2)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (AbstractC21730u22.a(abstractC18174oC7)) {
                    return abstractC18174oC7;
                }
                xc6S0 = ((AbstractC6200Mp2) abstractC18174oC7).S0();
                z2 = true;
            }
            arrayList.add(xc6S0);
        }
        if (z) {
            XC6 xc6J = AbstractC14230ha2.j(AbstractC13042fc3.q("Intersection of error types: ", list));
            AbstractC13042fc3.h(xc6J, "createErrorType(\"Intersection of error types: $types\")");
            return xc6J;
        }
        if (!z2) {
            return C19219py7.a.c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(AbstractC7411Rp2.d((AbstractC18174oC7) it.next()));
        }
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        C19219py7 c19219py7 = C19219py7.a;
        return C4567Fr3.d(c19219py7.c(arrayList), c19219py7.c(arrayList2));
    }
}
