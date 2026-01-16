package ir.nasim;

import ir.nasim.AbstractC15082iy7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.kO3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15914kO3 {
    public static final AbstractC15082iy7 a(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21331tU0 interfaceC21331tU02) {
        AbstractC13042fc3.i(interfaceC21331tU0, "from");
        AbstractC13042fc3.i(interfaceC21331tU02, "to");
        interfaceC21331tU0.q().size();
        interfaceC21331tU02.q().size();
        AbstractC15082iy7.a aVar = AbstractC15082iy7.c;
        List listQ = interfaceC21331tU0.q();
        AbstractC13042fc3.h(listQ, "from.declaredTypeParameters");
        List list = listQ;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC22882vy7) it.next()).j());
        }
        List listQ2 = interfaceC21331tU02.q();
        AbstractC13042fc3.h(listQ2, "to.declaredTypeParameters");
        List list2 = listQ2;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            XC6 xc6P = ((InterfaceC22882vy7) it2.next()).p();
            AbstractC13042fc3.h(xc6P, "it.defaultType");
            arrayList2.add(AbstractC7731Sy7.a(xc6P));
        }
        return AbstractC15082iy7.a.e(aVar, AbstractC20051rO3.w(AbstractC15401jX0.v1(arrayList, arrayList2)), false, 2, null);
    }
}
