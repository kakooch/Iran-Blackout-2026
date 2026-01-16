package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Nb1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6312Nb1 implements DS4 {
    private final List a;

    public C6312Nb1(List list) {
        AbstractC13042fc3.i(list, "providers");
        this.a = list;
        list.size();
        AbstractC15401jX0.r1(list).size();
    }

    @Override // ir.nasim.DS4
    public void a(C9424Zw2 c9424Zw2, Collection collection) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(collection, "packageFragments");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            CS4.a((AS4) it.next(), c9424Zw2, collection);
        }
    }

    @Override // ir.nasim.AS4
    public List b(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            CS4.a((AS4) it.next(), c9424Zw2, arrayList);
        }
        return AbstractC15401jX0.m1(arrayList);
    }

    @Override // ir.nasim.AS4
    public Collection l(C9424Zw2 c9424Zw2, UA2 ua2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(ua2, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((AS4) it.next()).l(c9424Zw2, ua2));
        }
        return hashSet;
    }
}
