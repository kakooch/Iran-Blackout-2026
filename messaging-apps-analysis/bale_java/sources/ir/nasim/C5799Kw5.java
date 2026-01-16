package ir.nasim;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Kw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5799Kw5 implements InterfaceC20102rU0 {
    private final InterfaceC6692Oo4 a;
    private final AbstractC7310Re0 b;
    private final UA2 c;
    private final Map d;

    public C5799Kw5(C8938Xw5 c8938Xw5, InterfaceC6692Oo4 interfaceC6692Oo4, AbstractC7310Re0 abstractC7310Re0, UA2 ua2) {
        AbstractC13042fc3.i(c8938Xw5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        AbstractC13042fc3.i(ua2, "classSource");
        this.a = interfaceC6692Oo4;
        this.b = abstractC7310Re0;
        this.c = ua2;
        List listN = c8938Xw5.N();
        AbstractC13042fc3.h(listN, "proto.class_List");
        List list = listN;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(AbstractC7170Qo4.a(this.a, ((C6526Nw5) obj).s0()), obj);
        }
        this.d = linkedHashMap;
    }

    @Override // ir.nasim.InterfaceC20102rU0
    public C19511qU0 a(C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        C6526Nw5 c6526Nw5 = (C6526Nw5) this.d.get(c24948zU0);
        if (c6526Nw5 == null) {
            return null;
        }
        return new C19511qU0(this.a, c6526Nw5, this.b, (JH6) this.c.invoke(c24948zU0));
    }

    public final Collection b() {
        return this.d.keySet();
    }
}
