package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Oi8 {
    final Map a = new HashMap();
    final Xj8 b = new Xj8();

    public Oi8() {
        b(new Li8());
        b(new Ri8());
        b(new Wi8());
        b(new Gj8());
        b(new Uj8());
        b(new Wj8());
        b(new Yj8());
    }

    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, InterfaceC22720vi8 interfaceC22720vi8) {
        AbstractC9951ap8.c(c20322ro8);
        if (!(interfaceC22720vi8 instanceof C23906xi8)) {
            return interfaceC22720vi8;
        }
        C23906xi8 c23906xi8 = (C23906xi8) interfaceC22720vi8;
        ArrayList arrayListB = c23906xi8.b();
        String strA = c23906xi8.a();
        return (this.a.containsKey(strA) ? (Ni8) this.a.get(strA) : this.b).a(strA, c20322ro8, arrayListB);
    }

    final void b(Ni8 ni8) {
        Iterator it = ni8.a.iterator();
        while (it.hasNext()) {
            this.a.put(((EnumC9901ak8) it.next()).j().toString(), ni8);
        }
    }
}
